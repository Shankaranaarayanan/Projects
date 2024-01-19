package com.test.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.ServletContext;


public class LoggingFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig cnfg){
        this.context = cnfg.getServletContext();
        this.context.log("Loggining filter init complete...");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest req = (HttpServletRequest) request;

        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            this.context.log("Request Params:--> "+request.getRemoteAddr() +names.nextElement()+" : "+request.getParameter(names.nextElement()));
        }

        Cookie[] ck = req.getCookies();
        for(Cookie cookie : ck){
            this.context.log("Cookies:---> "+req.getRemoteAddr()+cookie.getName()+" : "+cookie.getValue());
        }

        chain.doFilter(request, response);
    }

    public void destroy(){
        //To clean the data!!
    }
    
}
