package com.test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class AppExcpetionHandler extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processError(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processError(request, response);
    }

    public void processError(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");

        int error_code = (Integer) request.getAttribute("javax.servlet.error.status_code");

        String servlet_name = (String) request.getAttribute("javax.servlet.error.servlet_name");

        String request_uri = (String) request.getAttribute("javax.servlet.error.request_uri");

        if(servlet_name==null){
            servlet_name="Unknown";
        }
        if(request_uri==null){
            request_uri="Unknown";
        }

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>ExceptionDetails</title><head>");
        out.println("<body><h3>Exception Details</h3><br>");
        out.println("<ul>");

    }

}
