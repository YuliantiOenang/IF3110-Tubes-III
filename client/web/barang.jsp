<%-- 
    Document   : barang
    Created on : Nov 27, 2013, 4:16:57 PM
    Author     : Aurelia H B Matondang
--%>

<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="ruserba.database.DatabaseHelper" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/desktop.css">
        <script src='/ruserba/js/addamounttocart.js'></script>
        <title>Detail Barang</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            String query = "select * from barang where id_barang=" + id;
            DatabaseHelper.Connect();
            ResultSet res = DatabaseHelper.executeQuery(query);
            res.next();
        %>
	
        <h3 class="judul_halaman"> <%= res.getString("nama_barang") %></h3>
	<br/><br/><br/>
	<div class="barang_container">
	<div class="barang_gambar_detail">
            <img src="/ruserba/assets/barang/<%= res.getString("gambar") %>" width=100%/>
	</div>
	<div class="barang_detail">
            <%
                String id_kategori = res.getString("id_kategori");
                query = "select nama_kategori from kategori where id_kategori="+id_kategori;
                ResultSet kategori = DatabaseHelper.executeQuery(query);
                kategori.next();
            %>
	Kategori:
	<a href="/ruserba/kategori/<%= res.getString("id_kategori") %>">
            <%= kategori.getString("nama_kategori") %>
	</a>
	<span class="barang_nama">
	</span>
	<br>
        <%
            if(res.getInt("tersedia")==0){
        %>
		<span class="barang_tersedia">
		Barang tidak tersedia
		</span>
		<br>
	<% }
	else{ %>
		<span class="barang_tersedia">
                    Barang tersedia (<%= res.getString("tersedia") %> 	unit)
		</span>
		<br>
	<% } %>
	<span class="barang_harga">
            Rp <%= res.getString("harga_barang") %>,00
	</span>
	<br>
	<br>
	<br>
        <%
	if (res.getInt("tersedia") > 0) {
        %>
		Jumlah
                <input type="number" class="inputjumlah" name="jumlah" value="1" min="1" max="<%= res.getString("tersedia") %>"/>
		<br>
                <a class="button beli" name="<%= res.getString("id_barang") %>" href="javascript:void(0)"><div>Pesan Barang</div></a>
                <%
	}
        %>
	</div>
	</div>
        
    </body>
</html>
