package com.shareniu.dao.mapper;
import java.math.BigInteger;

import com.shareniu.dao.entity.UserEntity;

/**
 * TUser Edit Dao
 * @author system
 */
public interface UserEdt {
	/**
     * add record
     * @author system
     * @param tUser tUser
     * @return int
     */
    public int insertTUser(UserEntity tUser);
    
    /**
     * update record by Primary Key
     * @author system
     * @param  tUser tUser
     * @return int
     */
    public int updateTUserByPrimaryKey(UserEntity tUser);
    
    /**
     * delete record
     * @author system
     * @param tUser tUser
     * @return int
     */
    public int deleteTUser(UserEntity tUser);
	
	/**
     * delete record by Primary Key
     * @author system
     * @param  id id
     * @return int
     */
    public int deleteByPrimaryKey(BigInteger id);
}