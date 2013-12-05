<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.frexesc.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
<title>Insert title here</title>
<%
	UserBean user = (UserBean)request.getAttribute("user");
%>
<script>
function isChanged(nama, tel, add, cit, prov, posta) {
	if (nama == "<%=user.getName()%>" && tel == "<%=user.getTelephone()%>" && add == "<%=user.getAddress()%>" && cit == "<%=user.getCity()%>" && prov == "<%=user.getProvince()%>" && posta == "<%=user.getPostal()%>") {
		var r = confirm("Tidak ada perubahan dilakukan, lanjutkan?");
		return r;
	}
	return true;
}
</script>
</head>
<body>
	<jsp:include page="layout.jsp" />
	<form method="post"
		onsubmit="return (isChanged(name.value, telephone.value, address.value, city.value, province.value, postal.value) && validateEdit());"
		action="user" name="regform">
		<div class='register_div'>
			<h1 class='header'>Edit Profile</h1>
			<div class="per_form">
				<label>Nama Lengkap</label><input type="text"
					value="${user.getName()}" name="name" id="name" required
					onkeyup="if(this.value != '') validateName(this.value, 'fullname'); validateAll();">
				<span class="error" id="fullname"></span>
			</div>
			<div class="per_form">
				<label>Password Baru</label><input type="password"
					value="${user.getPassword()}" name="password1" id="password1"
					onkeyup="if(this.value != '') validatePassword(this.value, password2.value, username.value, email.value, 'valpasswords'); validateAll();">
				<span class="error" id="valpassword"></span>
			</div>
			<div class="per_form">
				<label>Confirm Pass.</label><input type="password"
					value="${user.getPassword()}" name="password2" id="password2"
					onkeyup="if(this.value != '') validatePassword(password1.value, this.value, username.value, email.value, 'valpasswords'); validateAll();">
				<span class="error" id="valpasswords"></span>
			</div>
		</div>
		<div class='register_div'>
			<div class='per_form small'>
				<label class='uncheck'>Alamat</label><input type="text"
					name="address" id="address" value="${user.getAddress()}"
					onkeyup="validateEmpty(this.value, 'valaddress'); validateAll();"
					required> <span id="valaddress"></span>
			</div>

			<div class='per_form small'>
				<label>Provinsi</label> <select value="" name="province"
					id="province" required>
					<option value="">Pilih Provinsi :</option>
					<%
						String[] provinsis = { "Aceh", "Sumatera Utara", "Sumatera Barat", "Riau", "Jambi", "Sumatera Selatan", "Lampung", "Bengkulu", "Bangka Belitung", "Kepulauan Riau", "Jakarta", "Jawa Barat", "Jawa Tengah", "Yogyakarta", "Jawa Timur", "Banten", "Bali", "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Timur", "Kalimantan Tengah", "Kalimantan Selatan", "Sulawesi Utara", "Sulawesi Tengah", "Sulawesi Selatan", "Sulawesi Tenggara", "Gorontalo", "Sulawesi Barat", "Maluku", "Maluku Utara", "Papua", "Papua Barat" };
									for (String provinsi : provinsis) {
					%>
					<%
						if (provinsi.equals(((UserBean) request.getAttribute("user")).getProvince())) {
					%>
					<option value="<%=provinsi%>" selected>
						<%=provinsi%>
					</option>
					<%
						} else {
					%>
					<option value="<%=provinsi%>">
						<%=provinsi%>
					</option>
					<%
						}
					%>
					<%
						}
					%>
				</select> <span id="valprovince"></span>
			</div>

			<div class='per_form small'>
				<label class='uncheck'>Kota/Kabupaten</label><input type="text"
					name="city" id="city" value="${user.getCity()}"
					onkeyup="validateEmpty(this.value, 'valcity'); validateAll();"
					required> <span id="valcity"></span>
			</div>

			<div class='per_form small'>
				<label class='uncheck'>Kodepos</label><input type="text"
					name="postal" id="postal" value="${user.getPostal()}"
					onkeyup="validateEmpty(this.value, 'valpostal'); validateAll();"
					required> <span id="valpostal"></span>
			</div>

			<div class='per_form small'>
				<label class='uncheck'>Telepon</label><input type="text"
					name="telephone" id="telephone" value="${user.getTelephone()}"
					onkeyup="validateEmpty(this.value, 'valtelephone'); validateAll();"
					required> <span id="valtelephone"></span>
			</div>
			<p class='keterangan'>Lorem ipsum dolor sit amet lorem ipsum
				dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet
				lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum
				dolor sit amet lorem ipsum dolor sit amet</p>

			<input id="action" name="action" type="hidden" value="edit" />
			<button type="submit" id="btn" onclick="" class="btn">Simpan</button>
		</div>
	</form>
	<jsp:include page="footer.jsp" />
	<script>
	var name = document.getElementById("name");
	var telephone = document.getElementById("telephone");
	var address = document.getElementById("address");
	var city = document.getElementById("city");
	var province = document.getElementById("province");
	var postal = document.getElementById("postal");
	</script>
</body>
</html>