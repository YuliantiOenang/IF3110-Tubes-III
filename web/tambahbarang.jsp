<%-- 
    Document   : tambahbarang
    Created on : Nov 27, 2013, 5:48:26 PM
    Author     : IHSAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String cat = request.getParameter( "cat" );
   int intcat = Integer.parseInt(cat) + 1;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Tambah Barang</h3>
        <form method="get" action="http://localhost:8080/tugas_web2/AddRedirection.jsp">
            <input name="nama" type="text" placeholder="Nama Barang">
            <input name="harga" type="text" placeholder="Harga Barang">
            <input name="kategori" type="hidden" value="<%= intcat%>">
            <input type="submit" value="Tambah">
        </form>
    </body>
</html>
