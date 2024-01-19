package com.test.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig config) {
        this.context = config.getServletContext();
        this.context.log("Authentication Filter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested URI :--->" + uri);

        HttpSession session = req.getSession(false);
        if (session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))) {
            this.context.log("Unauthorized request!!");
            res.sendRedirect("login.html");
        } else {
            chain.doFilter(request, response);
        }

    }
}
