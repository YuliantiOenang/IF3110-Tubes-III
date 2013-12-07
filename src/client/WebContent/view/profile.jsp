<%@ page import="javaModel.Profile" %>
<%@ page import="javaModel.Helper" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>
<% Profile P = (Profile) request.getAttribute("profile"); %>
<div class="center">
<div class="register_div">
	<h1 class='header'>Profil</h1>
	<div class="per_form">
		<label>Nama Lengkap:</label><p><%= P.nama.get(0) %></p>
	</div>
	<div class="per_form">
		<label>Username:</label><p><%= P.username.get(0) %></p>
	</div>
	<div class="per_form">
		<label>Email:</label><p><%= P.email.get(0) %></p>
	</div>
	<div class="per_form">
		<label>Alamat:</label><p><%= P.alamat.get(0) %></p>
	</div>
	<div class="per_form">
		<label>Provinsi:</label><p><%= P.provinsi.get(0) %></p>
	</div>
	<div class="per_form">
		<label>Kota:</label><p><%= P.kota.get(0) %></p>
	</div>
	<div class="per_form">
		<label>Kode Pos:</label><p><%= P.kodepos.get(0) %></p>
	</div>
	<div class="per_form">
		<label>Telepon:</label><p><%= P.telepon.get(0) %></p>
	</div>
	<div class="per_form">
		<label>Transaksi:</label><p><%= P.transaksi.get(0) %></p>
	</div>
	<a href="/ruserba/profile/edit" class="btn">Edit Profile</a>
</div>

</div>