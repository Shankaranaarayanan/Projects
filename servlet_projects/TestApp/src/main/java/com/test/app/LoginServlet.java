package com.test.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String password = request.getParameter("pass");

        if (uname.equals("admin") && password.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "Test User");
            session.setMaxInactiveInterval(30);
            Cookie loginck = new Cookie("user", uname);
            loginck.setMaxAge(30);
            response.addCookie(loginck);
            String encodedURL = response.encodeRedirectURL("sucess.jsp");
            response.sendRedirect(encodedURL);
        }

        else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }

    }
}