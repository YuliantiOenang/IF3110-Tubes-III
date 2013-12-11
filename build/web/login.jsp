<%-- 
    Document   : login
    Created on : Nov 26, 2013, 3:02:43 PM
    Author     : IHSAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String name = request.getParameter( "nama_pengguna" );
   String pw = request.getParameter( "kata_sandi" );
   session.setAttribute( "nama", name );
   session.setAttribute( "sandi", pw );
   String redirectURL = "";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>Apa lu <%= session.getAttribute("nama") %></p>
        <p>gw tau password lu <%= session.getAttribute("sandi") %> mampus lu</p>
        <% 
            if (session.getAttribute("nama").equals("admin")) {
                redirectURL = "http://localhost:8080/tugas_web2/admin.jsp";
            } else {
                redirectURL = "http://localhost:8080/tugas_web2/index.jsp";
            }
            response.sendRedirect(redirectURL);
        %>
    </body>
</html>
