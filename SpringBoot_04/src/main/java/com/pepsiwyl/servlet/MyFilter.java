package com.pepsiwyl.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author by pepsi-wyl
 * @date 2022-03-19 10:29
 */

@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/js/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.info("MyFiler初始化完成");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFiler工作");
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
        log.info("MyFiler销毁完成");
    }
}
