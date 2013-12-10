<%@ include file= "./header.jsp" %>
<%
if((sesi != null) && (sesi.getAttribute("username") != null))
	out.print("<script>window.location='index.jsp';</script>");
%>
<script type="text/javascript" src="verify.js"></script>
<form name="register" action="javascript:verifRegis();" method="post">
			Username: <input type="text" onkeyup="return checkUsername(this)" name="username" value=""><div id="err_username"></div><br>
			Password: <input type="password" name="password" onkeyup="checkPass(this)"><div id="err_pass"></div><br>
			Re-type Password: <input type="password" onkeyup="confirmPassword(this)" name="repassword"><div id="err_repass"></div><br>
			Nama Lengkap: <input type="text" name="fullname" onkeyup="checkFullName(this)"><div id="err_fullname"></div><br>
			Nomor Hand Phone: <input type="text" name="hpnum"><br>
			Alamat : <input type="text" name="address"><br>
			Provinsi : <input type="text" name="province"><br>
			Kecamatan : <input type="text" name="kecamatan"><br>
			Kode Pos : <input type="text" name="postalcode"><br>
			Email : <input type="text" name="Email" onkeyup="checkEmail(this)"><div id="err_email"></div><br>
			<input type="submit" id="daftar" value="Register">
			<div id="reg_error"></div>
</form>
<%@ include file= "./footer.jsp" %> 