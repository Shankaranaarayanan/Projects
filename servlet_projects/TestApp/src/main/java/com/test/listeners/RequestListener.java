package com.test.listeners;

import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletContext;

import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener{

    public void requestInitialized(ServletRequestEvent event){
        ServletContext ctx = event.getServletContext();
        ctx.log("Request initiated!! ->>"+event.getServletRequest().getRemoteAddr());
    }

    public void requestDestroyed(ServletRequestEvent event){
        ServletContext ctx = event.getServletContext();
        ctx.log("Request destroyed!! ->>"+event.getServletRequest().getRemoteAddr());
    }
    
}
