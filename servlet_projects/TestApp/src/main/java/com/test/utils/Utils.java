package com.test.utils;

// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;


// import javax.naming.Context;
// import javax.naming.InitialContext;

// import javax.servlet.ServletContext;
// import javax.servlet.ServletConfig;
// import javax.servlet.Servlet.getServletConfig;




import com.test.entity.user1;


public class Utils {
    // ServletConfig conf = getServletConfig();

    // ServletContext context = getServletContext();

    // new Dotenv.Builder().resource(".env.other").build().load();
    Map<String, String> env = System.getenv();


    public ArrayList<user1> getAllUsers(){
        ArrayList<user1> allUsers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Context ctx = null;
        try{
			ctx = new InitialContext();
			// DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
            Context initCtx  = (Context) ctx.lookup("java:/comp/env");
            DataSource ds = (DataSource) initCtx.lookup("jdbc/test");
			conn = ds.getConnection();
            stmt = conn.prepareStatement("SELECT * from user1;");
            rs = stmt.executeQuery();
            while(rs.next()){
                user1 u = new user1(rs.getString(2), rs.getInt(3), rs.getString(4));
                allUsers.add(u);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return allUsers;
    }
}
