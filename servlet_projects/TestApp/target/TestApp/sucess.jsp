<%@ page language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        String user = null;
        String sessionId = null;
        HttpSession session1 = request.getSession();
        if (session1.getAttribute("user")==null){
            response.sendRedirect("login.html");
        }
        else{
            user = (String) session1.getAttribute("user");
        }

        String uname = null;
        Cookie cookies[] = request.getCookies();
        if (cookies != null){
            for(Cookie ck : cookies){
                if (ck.getName().equals("user")){
                    uname = ck.getValue();
                }
                if (ck.getName().equals("JSESSIONID")){
                    sessionId = ck.getValue();
                }
            }
        }

        if (uname==null){
            response.sendRedirect("login.html");
        }
    %>

    <h1>Welcoomee <%= uname %> </h1>
    <%= user %> <br> <%= sessionId %>

    <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout" >    
    </form>
</body>
</html>