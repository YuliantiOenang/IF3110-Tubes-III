<%-- 
    Document   : admin-edit
    Created on : Nov 26, 2013, 10:25:20 PM
    Author     : Ahmad Fauzan
--%>

<%@page import="ruserba.beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="barang" scope="request" class="ruserba.beans.Item"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/desktop.css">
        <script src='js/profile.js'></script>
        <title>Edit Barang</title>
    </head>
    <body>
        <% 
            if(session.getAttribute("user") == null || !((User) session.getAttribute("user")).getUsername().equalsIgnoreCase("admin")) {  
                    String redirectURL = "";
                    response.sendRedirect(redirectURL);
            } 
        %> 
        <div class='formcontainer'>
            <h2 id='formtitle'>Edit <jsp:getProperty name="barang" property="name"/></h2>
            <br />
            <form id='formprofile' method='post' action='SaveItemServlet' enctype="multipart/form-data">
                <input type="hidden" name="id_barang" value="<jsp:getProperty name="barang" property="id" />" />
                <span class='formlabel'>Nama barang</span><input type='text' name='nama_barang' value='<jsp:getProperty name="barang" property="name"/>' /><br />
                <br />
                <span class='formlabel'>Kategori</span><input type='text' name='category' value='<jsp:getProperty name="barang" property="category"/>' /><br />
                <br />
                <span class='formlabel'>Harga Barang</span><input type='text' name='harga' value='<jsp:getProperty name="barang" property="price"/>'/><br />
                <br />
                <span class='formlabel'>Jumlah Tersedia </span><input type='text' name='tersedia' value='<jsp:getProperty name="barang" property="tersedia"/>'/><br />
                <br />
                <span class='formlabel'>Gambar </span><input type='file' name='gambar' /><br />
                <br />
                <br />
                <input type='submit' name='esubmit' value='Simpan'>
            </form>
        </div>
    </body>
</html>
