<%@page import="java.util.*"%>
<%@page import="kelas.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KLK STORE</title>
</head>
<body>
	<div class="page_container">
	<%@ include file="template/template.jsp" %>
	<link rel="stylesheet" href="css/index.css" type="text/css">
	
	<h2 class="mekanisme">Untuk membeli barang, buat akun dan login terlebih dahulu. Masukkan barang ke cart dari halaman detail atau halaman search. Lakukan pembelian dari halaman cart (jangan lupa registrasi kartu kredit).</h2>
	
	<%
	
		out.println("<h1>BARANG POPULER</h1>");
		int no = 1;
		for(int i=0;i<5;i++){
			out.println("<h1>Kategori: " + request.getAttribute("namaKategori" + i) + "<br/></h1>");
			ArrayList<Barang> barangs = (ArrayList<Barang>) request.getAttribute("barangKategori" + i);
			%>
			<div class="pull_left">
			<%
			
			for(Barang b: barangs){
				%>
				<div class="list_barang">
					<div class="gambar">
						<img src="res/<%= b.getGambar() %>" width="150px" height="150px">
					</div>
					<div class="list_desc">
						<strong>Nama:</strong> <a href="detail?gid=<%= b.getId_inven() %>"><%= b.getNama() %></a><br/>
						<strong>Harga:</strong> <%= b.getHarga() %><br/>
						<form class="cart_buy">
							<input type='text' id='quant<%= no %>' value='0' size=7 >
							<img class="cart_button" src="res/addtocart.png" width=125 onclick="validate(<%= b.getId_inven() %>, <%= no %>)">
						</form>
						<div class="notif" id='notif<%=no%>'></div>
					</div>
				</div>
				<%
				no++;
			}
			
			%>
			</div>
			<% 
		}
		
	%>
	</div>
</body>
<script src="transaction.js"></script>
</html>