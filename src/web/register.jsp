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

<%
	if (WebUtil.isLoggedIn(application, request))	{
		response.sendRedirect("index.jsp"); return;
	}
%>

<p>
Silakan registrasi. bagian yang berlabel bintang (*) wajib diisi.
<button id="register" onclick="cobaRegister()">Register Me!</button>
<div id=responseRegister> </div>
</p>
<div id="register_form">
	<label>Username *</label>
	<input type="text" id="username" name="username" onblur="cekUsername()" required>
	<div id=responseUsername> </div>
	<br>
	<label>Email *</label>
	<input type="email" id="email" name="email" onblur="cekEmail()" required>
	<div id=responseEmail> </div>
	<br>
	<label>Password *</label>
	<input type="password" id="password" name="password" required>
	<br>
	<label>Confirm Password *</label>
	<input type="password" id="confirm_pwd" onblur="cekPassword()" required>
	<div id=responsePassword> </div>
	<br>
	<label>Full Name *</label>
	<input type="text" id="nama_lengkap" name="nama_lengkap" onblur="cekFullname()" required>
	<div id=responseFullname> </div>
	<br>
	<label>Provinsi</label>
	<input type="text" id="provinsi" name="provinsi">
	<br>
	<label>Kota/Kabupaten</label>
	<input type="text" id="kota" name="kota">
	<br>
	<label>Alamat</label>
	<input type="text" id="alamat" name="alamat">
	<br>
	<label>Kode Pos</label>
	<input type="text" id="kode_pos" name="kode_pos">
	<div id=responseAngka> </div>
	<br>
	<label>Telepon</label>
	<input type="text" id="telepon" name="kontak">
	<div id=responseAngka> </div>
</div>