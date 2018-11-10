package com.sunlands.examplan.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sunlands.examplan.constant.AppGlobalStatusCodePrompt;
import com.sunlands.examplan.utils.Notify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器基类
 *
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年08月02日10:02:13
 */
public abstract class BaseController {

    JSON JSON = new JSONArray();

    private static final String UTF_8 = "UTF-8";

    private static final String GBK = "GBK";

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    /**
     * 获取request
     *
     * @return
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取session
     *
     * @return
     */
    protected HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    /**
     * 获取application
     *
     * @return
     */
    protected ServletContext getApplication() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getServletContext();
    }

    protected ServletContext getServletContext() {
        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }

    public String getString(String name) {
        return getString(name, null);
    }

    public String getString(String name, String defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr == null || "".equals(resultStr) || "null".equals(resultStr) || "undefined".equals(resultStr)) {
            return defaultValue;
        } else {
            return resultStr;
        }
    }

    /**
     * @param name
     * @param request
     * @param defaultValue 默认值
     * @return
     */
    public String getStringByRequest(String name, HttpServletRequest request, String defaultValue) {
        String resultStr = request.getParameter(name);
        if (resultStr == null || "".equals(resultStr) || "null".equals(resultStr) || "undefined".equals(resultStr)) {
            return defaultValue;
        } else {
            try {
                String decode = URLDecoder.decode(resultStr, UTF_8);
                return decode;
            } catch (UnsupportedEncodingException e) {
                LOGGER.error(e.getMessage());
                return defaultValue;
            }
        }
    }

    /**
     * 获取请求中的参数值，如果参数值为null刚转为空字符串""
     *
     * @return
     */
    public Map<String, Object> getParamMap_NullStr(Map map) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Set keys = map.keySet();
        for (Object key : keys) {
            String value = this.getString(key.toString());
            if (value == null) {
                value = "";
            }
            parameters.put(key.toString(), value);
        }
        return parameters;
    }

    public int getInt(String name) {
        return getInt(name, 0);
    }

    public int getInt(String name, int defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr != null) {
            try {
                return Integer.parseInt(resultStr);
            } catch (Exception e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    public BigDecimal getBigDecimal(String name) {
        return getBigDecimal(name, null);
    }

    public BigDecimal getBigDecimal(String name, BigDecimal defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr != null) {
            try {
                return BigDecimal.valueOf(Double.parseDouble(resultStr));
            } catch (Exception e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    /**
     * 根据参数名从HttpRequest中获取String类型的参数值，无值则返回"" .
     *
     * @param key .
     * @return TestJwt .
     */
    public String getString_UrlDecode_UTF8(String key) {
        try {
            return URLDecoder.decode(this.getString(key), UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    public String getString_UrlDecode_GBK(String key) {
        try {
            return new String(getString(key.toString()).getBytes("GBK"), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取客户端的IP地址
     *
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 获取refererUrl
     */
    public String getRefererUrl(HttpServletRequest request) {
        return request.getHeader("referer");
    }


    protected void renderSuccess(HttpServletResponse response, Object object) {
        Notify notify = new Notify();
        notify.setSuccess(true);
        notify.setCode(AppGlobalStatusCodePrompt.Q_ALL_SUCCESS_CODE);
        notify.setMsg(AppGlobalStatusCodePrompt.Q_ALL_SUCCESS_MSG);
        notify.setData(object);
        renderString(response, notify);
    }

    protected void renderError(HttpServletResponse response, Object object) {
        Notify notify = new Notify();
        notify.setSuccess(true);
        notify.setCode(AppGlobalStatusCodePrompt.Q_ALL_FAIL_CODE);
        notify.setMsg(AppGlobalStatusCodePrompt.Q_ALL_FAIL_MSG);
        notify.setData(object);
        renderString(response, notify);
    }

    protected void renderNotNull(HttpServletResponse response) {
        Notify notify = new Notify();
        notify.setSuccess(false);
        notify.setCode(AppGlobalStatusCodePrompt.Q_ALL_FAIL_PARAMETER_NOTNULL_CODE);
        notify.setMsg(AppGlobalStatusCodePrompt.Q_ALL_FAIL_PARAMETER_NOTNULL_MSG);
        renderString(response, notify);
    }

    protected void renderNotNull(HttpServletResponse response,Object o) {
        Notify notify = new Notify();
        notify.setSuccess(false);
        notify.setData(o);
        notify.setCode(AppGlobalStatusCodePrompt.Q_ALL_FAIL_PARAMETER_NOTNULL_CODE);
        notify.setMsg(AppGlobalStatusCodePrompt.Q_ALL_FAIL_PARAMETER_NOTNULL_MSG);
        renderString(response, notify);
    }

    protected void renderParameterError(HttpServletResponse response) {
        Notify notify = new Notify();
        notify.setSuccess(false);
        notify.setCode(AppGlobalStatusCodePrompt.Q_ALL_FAIL_PARAMETER_ERROR_CODE);
        notify.setMsg(AppGlobalStatusCodePrompt.Q_ALL_FAIL_PARAMETER_ERROR_MSG);
        renderString(response, notify);
    }

    protected void renderParameterError(HttpServletResponse response, Object o) {
        Notify notify = new Notify();
        notify.setSuccess(false);
        notify.setData(o);
        notify.setCode(AppGlobalStatusCodePrompt.Q_ALL_FAIL_PARAMETER_ERROR_CODE);
        notify.setMsg(AppGlobalStatusCodePrompt.Q_ALL_FAIL_PARAMETER_ERROR_MSG);
        renderString(response, notify);
    }

    /**
     * 客户端返回JSON字符串
     *
     * @param response
     * @param object
     * @return
     */
    protected String renderString(HttpServletResponse response, Object object) {

        return renderString(response, JSON.toJSONString(object), "application/json");
    }

    /**
     * 客户端返回字符串
     *
     * @param response
     * @param string
     * @return
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token,password");
            response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
            response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
            // 指定允许其他域名访问  
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
