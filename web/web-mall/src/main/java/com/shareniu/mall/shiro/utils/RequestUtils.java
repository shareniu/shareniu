package com.shareniu.mall.shiro.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wzy on 2015/4/7.
 */
public class RequestUtils {

    public static String getCurrentUrl(HttpServletRequest request, String URIEncoding) {
        String queryString = request.getQueryString();
        List<String> parameterNamesByGet = parameterNamesByGet(queryString);

        int paramSizeByGet = parameterNamesByGet.size();

        int paramTotal = request.getParameterMap().size();
        if ((paramTotal == 0) && (paramSizeByGet == 0)) {
            return request.getRequestURL().toString();
        }
        if (((paramTotal > 0) && (paramTotal == paramSizeByGet)) || ((paramTotal == 0) && (paramSizeByGet > 0))) {
            return request.getRequestURL() + "?" + queryString;
        }
        StringBuffer url = request.getRequestURL();
        url.append("?");
        if (paramSizeByGet > 0) {
            url.append(queryString);
        }
        String afterConvert = covertToGet(parameterNamesByGet, request.getParameterMap(), URIEncoding);
        if (afterConvert.trim().length() > 0) {
            url.append("&").append(afterConvert);
        }
        return url.toString();
    }

    private static String covertToGet(Collection<String> parameterNamesByGet, Map<String, String[]> parameterMap, String URIEncoding) {
        if (parameterMap.size() == 0) {
            return "";
        }
        StringBuilder postParams = new StringBuilder();
        Set<String> parameterNameSet = parameterMap.keySet();
        for (String key : parameterNameSet) {
            if (!parameterNamesByGet.contains(key)) {
                postParams.append(key).append("=").append(encode(((String[]) parameterMap.get(key))[0], URIEncoding)).append("&");
            }
        }
        return postParams.toString().substring(0, postParams.length() - 1);
    }

    private static List<String> parameterNamesByGet(String queryString) {
        List<String> parameterNames = new ArrayList<String>();
        if (StringUtils.isNotEmpty(queryString)) {
            String[] params = queryString.split("&");
            for (String param : params) {
                if (param.contains("=")) {
                    parameterNames.add(param.split("=")[0]);
                }
            }
        }
        return parameterNames;
    }

    public static String encode(String value, String charset) {
        if ((value == null) || (value.length() == 0)) {
            return "";
        }
        try {
            return URLEncoder.encode(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String decode(String value, String charset) {
        if ((value == null) || (value.length() == 0)) {
            return "";
        }
        try {
            return URLDecoder.decode(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String getReturnUrl(String passportUrl, String returnUrl, String encodeReturnUrl) {
        if (StringUtils.isEmpty(returnUrl)) {
            return passportUrl;
        }
        return passportUrl + "?ReturnUrl=" + encodeReturnUrl;
    }
}
