<%-- 
    Document   : credit
    Created on : Dec 7, 2013, 2:24:04 PM
    Author     : What
--%>
<%@ page import="com.ruserba.web.WebUtil" %>
<%@ page import="com.ruserba.model.Database" %>
<%@ page import="com.ruserba.model.Category" %>
<%@ page import="com.ruserba.model.Product" %>
<%@ page import="com.ruserba.model.SearchAttribute" %>
<%@ page import="java.util.ArrayList" %>

<% request.setAttribute("page_title", "RuSerBa - Registrasi"); %>
<% request.setAttribute("css_file", "styles/register.css"); %>
<% request.setAttribute("js_file", "scripts/register.js"); %>
<jsp:include page="/WEB-INF/jsp/begin.jsp" />

<p>
Silakan registrasi kartu kredit. bagian yang berlabel bintang (*) wajib diisi.
<button id="register" onclick="cobaRegisterKartu()">Register Kartu</button>
<div id=responseRegister> </div>
</p>
<div id="register_form">
	<label>No.Kartu *</label>
	<input type="text" id="nomor_kartu" name="nomor_kartu" onblur="cekNoKartu()" required>
	<div id=responseUsername> </div>
	<br>
	<label>Nama Pemilik *</label>
	<input type="email" id="nama_kartu" name="nama_kartu" onblur="cekNamaKartu()" required>
	<div id=responseEmail> </div>
	<br>
	<label>Tanggal Expire *</label>
	<input type="date" id="ekspirasi_kartu" name="ekspirasi_kartu" onblur="cekExpiryKartu()" required>
</div>