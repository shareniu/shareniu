package com.shareniu.mall.shiro.utils;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ajax utils
 *
 * Created by wenzhouyang on 2015/1/13.
 */
public class AjaxUtils {

    /**
     * 是否是ajax 请求
     *
     * @param request httpServletRequest
     *                @see javax.servlet.http.HttpServletRequest
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }
    public static void toJson(Object value,HttpServletResponse resp){
        Gson gson = new Gson();
        String json = gson.toJson(value);
        responseOut(resp, json);
    }
    public static void toJson2(Object value,HttpServletResponse resp){
        Gson gson = new Gson();
        String json = gson.toJson(value);
        responseOut2(resp, json);
    }
    /**
     * print to the page
     * @param resp
     *         the response object
     * @param value
     *          the value
     */
    public static void responseOut(HttpServletResponse resp,Object value){
        PrintWriter out = null;
        try {
            setContentTypeHtml(resp);
            out = resp.getWriter();
            if (out != null) {
                out.print(value);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
                out = null;
            }
        }
    }
    public static void responseOut2(HttpServletResponse resp,Object value){
        PrintWriter out = null;
        try {
            setContentTypeHtml2(resp);
            out = resp.getWriter();
            if (out != null) {
                out.print(value);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
                out = null;
            }
        }
    }
    public static void setContentTypeHtml(HttpServletResponse resp){
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
    }
    public static void setContentTypeHtml2(HttpServletResponse resp){
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
    }

    public static void ajaxprint(String str,HttpServletResponse response){
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
