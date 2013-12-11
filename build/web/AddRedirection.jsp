<%-- 
    Document   : AddRedirection
    Created on : Nov 27, 2013, 6:38:48 PM
    Author     : IHSAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.if3110.web.JSONResponder" %>
<!DOCTYPE html>
<%
   String nama = request.getParameter( "nama" );
   String kategori = request.getParameter( "kategori" );
   String harga = request.getParameter( "harga" );   
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
            jsr.addBarang(nama, Float.parseFloat(harga), Integer.parseInt(kategori));
            redirectURL = "http://localhost:8080/tugas_web2/barangadmin.jsp?cat=" + (Integer.parseInt(kategori) - 1);
            response.sendRedirect(redirectURL);
        %>
    </body>
</html>
