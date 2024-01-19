package com.test.app;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import java.sql.SQLException;
// import java.sql.DriverManager;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;

import com.test.utils.Utils;

import com.test.entity.user1;

@WebServlet
public class App extends HttpServlet {
    Utils util = new Utils();

    // new Dotenv.Builder().resource(".env.other").build().load();
    public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        ArrayList<user1> allUsers = new ArrayList<>();
        allUsers = util.getAllUsers();
        for (user1 user1 : allUsers) {
            out.println(user1.getName());
        }

        out.println("Helooo World uh!");
    }
}
