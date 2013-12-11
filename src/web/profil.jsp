<%-- 
    Document   : profil
    Created on : Dec 7, 2013, 2:24:04 PM
    Author     : What
--%>
<%@ page import="com.ruserba.model.User"%>
<%@ page import="com.ruserba.web.WebUtil" %>
<%@ page import="com.ruserba.model.Database" %>
<%@ page import="com.ruserba.model.Category" %>
<%@ page import="com.ruserba.model.Product" %>
<%@ page import="com.ruserba.model.SearchAttribute" %>
<%@ page import="java.util.ArrayList" %>

<% request.setAttribute("page_title", "RuSerBa - Profil"); %>
<% request.setAttribute("css_file", "styles/register.css"); %>
<% request.setAttribute("js_file", "scripts/register.js"); %>
<jsp:include page="/WEB-INF/jsp/begin.jsp" />

<p>
<h1>Halaman Profil</h1>
<button id="register" onclick="cobaRegister()">Edit Profile</button>
<div id=responseRegister> </div>
</p>

<%
	Database db = WebUtil.getDatabase(getServletContext());
	User user = db.getUserData(Integer.parseInt(request.getParameter("id_user")));
%>

<div id="register_form">
	<label>Username</label>
	<%= user.getUsername() %>
	<div id=responseUsername> </div>
	<br>
	<label>Email</label>
	<%= user.getEmail() %>
	<div id=responseEmail> </div>
	<br>
	<label>Full Name</label>
	<%= user.getNamaLengkap() %>
	<div id=responseFullname> </div>
	<br>
	<label>Provinsi</label>
	<%= user.getProvinsi() %>
	<br>
	<label>Kota/Kabupaten</label>
	<%= user.getKota() %>
	<br>
	<label>Alamat</label>
	<%= user.getAlamat() %>
	<br>
	<label>Kode Pos</label>
	<%= user.getKodePos() %>
	<div id=responseAngka> </div>
	<br>
	<label>Telepon</label>
	<%= user.getKontak() %>
	<div id=responseAngka> </div>
</div>