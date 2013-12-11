<%-- 
    Document   : DeleteRedirection
    Created on : Nov 27, 2013, 5:18:45 PM
    Author     : IHSAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.if3110.web.JSONResponder" %>
<!DOCTYPE html>
<%
   String id = request.getParameter( "id" );
   String cat = request.getParameter( "cat" );
   String redirectURL = "";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%! JSONResponder jsr = new JSONResponder(); %>
    <body>
        <% 
            jsr.delBarang(Integer.parseInt(id));
            redirectURL = "http://localhost:8080/tugas_web2/barangadmin.jsp?cat=" + cat;
            response.sendRedirect(redirectURL);
        %>
    </body>
</html>
