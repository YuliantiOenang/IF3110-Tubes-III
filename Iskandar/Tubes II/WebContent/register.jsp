<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/css/style.css" />
<jsp:include page="header.jsp" />
<script src="js/validate.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<!-- new code -->
	<jsp:include page="layout.jsp" />
	<form method="post" action="user" onsubmit="return validateAll()" name="regform">
		<div class='register_div'>
			<h1 class='header'>Register</h1>
			<div class='per_form'>
				<label>Nama Lengkap</label><input type="text" name="name"
					id="name" value=""
					onkeyup="if(this.value != '') validateName(this.value, 'fullname'); validateAll();" required> 
					<span class='error'
					id="fullname"></span>
			</div>

			<div class='per_form'>
				<label>Email</label><input type="text" name="email"
					id="email" value=""
					onkeyup="if(this.value != '') validateEmail('email', this.value, 'valemail'); validateAll();" required> <span class='error'
					id="valemail"></span>
			</div>

			<div class='per_form'>
				<label>Username</label><input type="text" name="username"
					id="username" value=""
					onkeyup="if(this.value != '') validateUsername('username', this.value, 'valusername'); validateAll();" required> <span
					class='error' id="valusername"></span>
			</div>

			<div class='per_form'>
				<label>Password</label><input type="password"
					name="password1" id="password1" placeholderPassword :=""
					value=""
					onkeyup="if(this.value != '') validatePassword(this.value, password2.value, username.value, email.value, 'valpasswords');  validateAll();" required> <span
					class='error' id="valpassword"></span>
			</div>

			<div class='per_form'>
				<label>Confirm Pass.</label><input type="password"
					name="password2" id="password2"
					value=""
					onkeyup="if(this.value != '') validatePassword(password1.value, this.value, username.value, email.value, 'valpasswords');  validateAll();" required> <span
					class='error' id="valpasswords"></span>
			</div>
		</div>
		<div class='register_div'>
			<div class='per_form small'>
				<label class='uncheck'>Alamat</label><input type="text"
					name="address" id="address"
					value="" onkeyup="validateEmpty(this.value, 'valaddress')  validateAll();" required> <span
					id="valaddress"></span>
			</div>

			<div class='per_form small'>
				<label>Provinsi</label> <select value="" name="province" id="province" required>
					<option value="">Pilih Provinsi :</option>
					<%
					String[] provinsis = {"Aceh", "Sumatera Utara", "Sumatera Barat", "Riau", "Jambi", "Sumatera Selatan", "Lampung", "Bengkulu", "Bangka Belitung", "Kepulauan Riau", "Jakarta", "Jawa Barat", "Jawa Tengah", "Yogyakarta", "Jawa Timur", "Banten", "Bali", "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Timur", "Kalimantan Tengah", "Kalimantan Selatan", "Sulawesi Utara", "Sulawesi Tengah", "Sulawesi Selatan", "Sulawesi Tenggara", "Gorontalo", "Sulawesi Barat", "Maluku", "Maluku Utara", "Papua", "Papua Barat"};
					for (String provinsi: provinsis) {
						%>
						<option value="<%= provinsi %>">
						<%= provinsi %>
						</option>
						<%
					}
					%>
				</select> <span id="valprovince"></span>
			</div>

			<div class='per_form small'>
				<label class='uncheck'>Kota/Kabupaten</label><input type="text"
					name="city" id="city" value="" onkeyup="validateEmpty(this.value, 'valcity');  validateAll();"
					required> <span id="valcity"></span>
			</div>

			<div class='per_form small'>
				<label class='uncheck'>Kodepos</label><input type="text"
					name="postal" id="postal"
					onkeyup="validateEmpty(this.value, 'valpostal');  validateAll();"  required> <span
					id="valpostal"></span>
			</div>

			<div class='per_form small'>
				<label class='uncheck'>Telepon</label><input type="text"
					name="telephone" id="telephone"
					value=""
					onkeyup="validateEmpty(this.value, 'valtelephone');  validateAll();" required> <span
					id="valtelephone"></span>
			</div>
			<p class='keterangan'>Lorem ipsum dolor sit amet lorem ipsum
				dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet
				lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum
				dolor sit amet lorem ipsum dolor sit amet</p>
			<input type="hidden" name="action" value="register"></input>
			<button type="submit" id="btn" class="btn" disabled>Daftar</button>
		</div>
		<br />
	</form>
	<script src="<?php echo $this->getBaseUrl() ?>/js/register.js"></script>
	<script>
		var server = "<?php echo Template::getBaseUrl() ?>";
	</script>
	<!-- new code -->	
	
	<jsp:include page="footer.jsp" />
</body>
</html>