<%-- 
    Document   : updateadmin
    Created on : Nov 27, 2013, 3:21:58 PM
    Author     : IHSAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String cat = request.getParameter( "cat" );
   String id = request.getParameter( "id" );
   String name = request.getParameter( "name" );
   String price = request.getParameter( "price" );
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Ubah Barang</h3>
        <form method="get" action="http://localhost:8080/tugas_web2/UpdateRedirection.jsp">
            <input name="nama" type="text" value="<%= name%>">
            <input name="harga" type="text" value="<%= price%>">
            <input name="kategori" type="hidden" value="<%= cat%>">
            <input name="id" type="hidden" value="<%= id%>">
            <input type="submit" value="Ubah">
        </form>  
    </body>
</html>
