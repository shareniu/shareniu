package com.shareniu.mall.shiro.quartz2;

import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.session.mgt.ValidatingSessionManager;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 清理调度器
 *
 * Created by wenzhouyang on 2015/1/14.
 */
public class Quartz2SessionValidationScheduler implements SessionValidationScheduler {

    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/
    /**
     * The default interval at which sessions will be validated (1 hour);
     * This can be overridden by calling {@link #setSessionValidationInterval(long)}
     */
    public static final long DEFAULT_SESSION_VALIDATION_INTERVAL = DefaultSessionManager.DEFAULT_SESSION_VALIDATION_INTERVAL;

    /**
     * The name assigned to the quartz job.
     */
    private static final String JOB_NAME = "SessionValidationJob";

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/
    private static final Logger log = LoggerFactory.getLogger(Quartz2SessionValidationScheduler.class);


    private Scheduler scheduler;

    private boolean schedulerImplicitlyCreated = false;

    private boolean enabled = false;

    /**
     * The session manager used to validate sessions.
     */
    private ValidatingSessionManager sessionManager;

    /**
     * The session validation interval in milliseconds.
     */
    private long sessionValidationInterval = DEFAULT_SESSION_VALIDATION_INTERVAL;

    /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    public Quartz2SessionValidationScheduler() {
    }

    public Quartz2SessionValidationScheduler(ValidatingSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/

    /*protected Scheduler getScheduler() throws SchedulerException {
        if (scheduler == null) {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            schedulerImplicitlyCreated = true;
        }
        return scheduler;
    }*/

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void setSessionManager(ValidatingSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    /**
     * Returns <code>true</code> if this Scheduler is enabled and ready to begin validation at the appropriate time,
     * <code>false</code> otherwise.
     * <p/>
     * It does <em>not</em> indicate if the validation is actually executing at that instant - only that it is prepared
     * to do so at the appropriate time.
     *
     * @return <code>true</code> if this Scheduler is enabled and ready to begin validation at the appropriate time,
     * <code>false</code> otherwise.
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Specifies how frequently (in milliseconds) this Scheduler will call the
     * {@link ValidatingSessionManager#validateSessions() ValidatingSessionManager#validateSessions()} method.
     *
     * <p>Unless this method is called, the default value is {@link #DEFAULT_SESSION_VALIDATION_INTERVAL}.
     *
     * @param sessionValidationInterval
     */
    public void setSessionValidationInterval(long sessionValidationInterval) {
        this.sessionValidationInterval = sessionValidationInterval;
    }

    /**
     * Enables the session validation job.
     */
    @Override
    public void enableSessionValidation() {
        if (log.isDebugEnabled()) {
            log.debug("Scheduling session validation job using Quartz with " +
                    "session validation interval of [" + sessionValidationInterval + "]ms...");
        }

        try {
            SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity(getClass().getName(), Scheduler.DEFAULT_GROUP)
            .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(sessionValidationInterval).repeatForever()).build();

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put(QuartzSessionValidationJob.SESSION_MANAGER_KEY, sessionManager);
            JobDetail jobDetail = JobBuilder.newJob().ofType(QuartzSessionValidationJob.class)
                    .withIdentity(JOB_NAME, Scheduler.DEFAULT_GROUP).setJobData(jobDataMap).build();


            Scheduler scheduler = getScheduler();

            scheduler.scheduleJob(jobDetail, simpleTrigger);
            if (schedulerImplicitlyCreated) {
                scheduler.start();
                if (log.isDebugEnabled()) {
                    log.debug("Successfully started implicitly created Quartz Scheduler instance.");
                }
            }
            this.enabled = true;

            if (log.isDebugEnabled()) {
                log.debug("Session validation job successfully scheduled with Quartz.");
            }

        } catch (SchedulerException e) {
            if (log.isErrorEnabled()) {
                log.error("Error starting the Quartz session validation job.  Session validation may not occur.", e);
            }
        }
    }

    /**
     * Disables the session validation job.
     */
    @Override
    public void disableSessionValidation() {
        if (scheduler != null) {
            try {
                scheduler.shutdown(false);
            } catch (SchedulerException e) {
                log.error("", e);
            }
        }
    }
    // ==== 12/10新增修改.重写方法.
    protected Scheduler getScheduler() throws SchedulerException {
        if (scheduler == null) {
            Properties properties = new Properties();
            properties.setProperty("org.quartz.scheduler.instanceName", "shiro-quartz-scheduler");
            properties.setProperty("org.quartz.scheduler.rmi.export", "false");
            properties.setProperty("org.quartz.scheduler.rmi.proxy", "false");
            properties.setProperty("org.quartz.scheduler.wrapJobExecutionInUserTransaction", "false");
            properties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
            properties.setProperty("org.quartz.threadPool.threadCount", "10");
            properties.setProperty("org.quartz.threadPool.threadPriority", "5");
            properties.setProperty("org.quartz.jobStore.misfireThreshold", "6000");
            properties.setProperty("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");
            properties.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
            scheduler = new StdSchedulerFactory(properties).getScheduler();
            schedulerImplicitlyCreated = true;
        }
        return scheduler;
    }
}
