<%-- 
    Document   : barang
    Created on : Nov 27, 2013, 4:16:57 PM
    Author     : Aurelia H B Matondang
--%>

<%@page import="java.io.Console"%>
<%@page import="ruserba.services.RuserbaServices"%>
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
            
            JSONObject barang = RuserbaServices.GetBarang(Integer.parseInt(id));
            
        %>
	
        <h3 class="judul_halaman"> <%= barang.getString("nama_barang") %></h3>
	<br/><br/><br/>
	<div class="barang_container">
	<div class="barang_gambar_detail">
            <img src="/ruserba/assets/barang/<%= barang.getString("gambar") %>" width=100%/>
	</div>
	<div class="barang_detail">
            <%
                String id_kategori = barang.getString("id_kategori");
                String query = "select nama_kategori from kategori where id_kategori="+id_kategori;
                DatabaseHelper.Connect();
                ResultSet kategori = DatabaseHelper.executeQuery(query);
                kategori.next();
            %>
	Kategori:
	<a href="/ruserba/kategori/<%= barang.getString("id_kategori") %>">
            <%= kategori.getString("nama_kategori") %>
	</a>
	<span class="barang_nama">
	</span>
	<br>
        <%
            if(barang.getInt("tersedia")==0){
        %>
		<span class="barang_tersedia">
		Barang tidak tersedia
		</span>
		<br>
	<% }
	else{ %>
		<span class="barang_tersedia">
                    Barang tersedia (<%= barang.getString("tersedia") %> 	unit)
		</span>
		<br>
	<% } %>
	<span class="barang_harga">
            Rp <%= barang.getString("harga_barang") %>,00
	</span>
	<br>
	<br>
	<br>
        <%
	if (barang.getInt("tersedia") > 0) {
        %>
		Jumlah
                <input type="number" class="inputjumlah" name="jumlah" value="1" min="1" max="<%= barang.getString("tersedia") %>"/>
		<br>
                <a class="button beli" name="<%= barang.getString("id_barang") %>" href="javascript:void(0)"><div>Pesan Barang</div></a>
                <%
	}
        %>
	</div>
	</div>
        
    </body>
</html>
