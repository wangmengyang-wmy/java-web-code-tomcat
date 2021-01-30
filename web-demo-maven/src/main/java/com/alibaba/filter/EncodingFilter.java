package com.alibaba.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class EncodingFilter implements Filter {

    public EncodingFilter() {
        System.out.println("过滤器构造");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println("Filter init name "+s);
            System.out.println("Filter init value "+filterConfig.getInitParameter(s));
        }
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8"); //将编码改为utf-8
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println("EncodingFilter执行前！！！");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie:cookies) {
            String name = cookie.getName();
            System.out.println("Cookie Name "+name);
            String value = cookie.getValue();
            System.out.println("Cookie Value "+value);
        }
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("EncodingFilter执行后！！！");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
