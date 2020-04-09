//package com.iot.config;
//
///**
// * Created by user on 2018/7/5.
// */
//
//
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * 跨域访问处理(跨域资源共享)
// * 解决前后端分离架构中的跨域问题
// */
//@Component
//@ServletComponentScan
//@WebFilter(urlPatterns = "/*",filterName = "shiroLoginFilter")
//public class CorsFilter implements Filter {
//
//    private FilterConfig config = null;
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        this.config = config;
//    }
//    @Override
//    public void destroy() {
//        this.config = null;
//    }
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        // 允许哪些Origin发起跨域请求,nginx下正常
//        // response.setHeader( "Access-Control-Allow-Origin", config.getInitParameter( "AccessControlAllowOrigin" ) );
//        response.setHeader( "Access-Control-Allow-Origin", "*" );
//        // 允许请求的方法
//        response.setHeader( "Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,PATCH" );
//        // 多少秒内，不需要再发送预检验请求，可以缓存该结果
//        response.setHeader( "Access-Control-Max-Age", "3600" );
//        // 表明它允许跨域请求包含xxx头
//        response.setHeader( "Access-Control-Allow-Headers", "Authorization,Origin,X-Requested-With,Content-Type, Accept" );
//        filterChain.doFilter( servletRequest, response );
//    }
//
//}