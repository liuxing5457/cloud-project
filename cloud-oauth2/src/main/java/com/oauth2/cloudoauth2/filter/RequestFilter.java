package com.oauth2.cloudoauth2.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @ClassName RequestFilter
 * @Description TODO
 * @Author  xuzibang
 * @Date 2019/11/16
 */
@Component
public class RequestFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(RequestFilter.class);

    public static final String UNKNOWN = "unknown";

    @Override
    public void destroy() {

    }

    private HttpServletRequest request;

    private HttpServletResponse response;

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {

        request = (HttpServletRequest) arg0;

        response = (HttpServletResponse) arg1;

        log.info(getIpAddr(request) + ":" + request.getRequestURI() + "?" + request.getQueryString());

        arg2.doFilter(request, arg1);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    /**
     * 获取Ip地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}

