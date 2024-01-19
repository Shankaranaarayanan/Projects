package com.test.app;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String uname = "";
        Cookie cookies[] = request.getCookies();
        if (cookies != null){
            for (Cookie cookie: cookies){
                if (cookie.getName().equals("user")){
                    uname = (String) cookie.getValue();
                }
            }
        }

        HttpSession session = request.getSession();
        if (session != null){
            session.invalidate();
        }

        System.out.println("Sucessfully logged out "+uname);
        response.sendRedirect("login.html");
    }
}
