<jsp:include page="contentBegin.jsp"></jsp:include>
<%@ page import="model.*" %>
<%@page import="java.util.HashMap"%>
<%
HashMap<String,String> model = new HashMap<String,String>();
model = (HashMap<String,String>)request.getAttribute("model");
%>

<form method="post" action="${pageContext.request.contextPath}/InputProfile">
	<div class='register_div'>
		<h1 class='header'>Edit Profile</h1>
		<div class="per_form">
			<label>Nama Lengkap</label><input type="text" value="<%= model.get("nama") %>" name="Profile[nama]" id="nama" required onkeyup="Register.cekNama()">
			<span class="error" id="error-nama"></span>
		</div>
		<div class="per_form">
			<label>Username</label><input type="text" value="<%= model.get("username") %>" id="username" disabled="disabled">
		</div>
		<div class="per_form">
			<label>Email</label><input type="text" value="<%= model.get("email") %>" id="email" disabled="disabled">
		</div>
		<div class="per_form">
			<label>Password Baru</label><input type="password" value="" name="Profile[password]" id="password" onkeyup="Register.cekPassword()">
			<span class="error" id="error-password"></span>
		</div>
		<div class="per_form">
			<label>Confirm Pass.</label><input type="password" value="" name="Profile[confirm]" id="confirm" onkeyup="Register.cekConfirm()">
			<span class="error" id="error-confirm"></span>
		</div>
	</div>
	<div class='register_div'>
		<div class="per_form">
			<label>Alamat</label><input type="text" value="<%= model.get("alamat") %>" name="Profile[alamat]" id="alamat" required>
			<span id="error-alamat"></span>
		</div>
		<div class="per_form">
			<label>Provinsi</label>
			<select value="<?php echo $model->provinsi ?>" name="Profile[provinsi]" id="provinsi" required>
				<option value="">Pilih Provinsi :</option>
				
				<!-- <?php 
				$propinsi = array("Aceh", "Sumatera Utara", "Sumatera Barat", "Riau", "Jambi", "Sumatera Selatan", "Lampung", "Bengkulu", "Bangka Belitung", "Kepulauan Riau", "Jakarta", "Jawa Barat", "Jawa Tengah", "Yogyakarta", "Jawa Timur", "Banten", "Bali", "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Timur", "Kalimantan Tengah", "Kalimantan Selatan", "Sulawesi Utara", "Sulawesi Tengah", "Sulawesi Selatan", "Sulawesi Tenggara", "Gorontalo", "Sulawesi Barat", "Maluku", "Maluku Utara", "Papua", "Papua Barat");
				sort($propinsi);
				foreach ($propinsi as $item) : ?>
					<option value="<?php echo $item ?>" <?php if ($item==$model->provinsi) echo "selected" ?>><?php echo $item ?></option>
				<?php endforeach; ?> -->
				
				<%
  				String[] provinsi = {"Aceh", "Sumatera Utara", "Sumatera Barat", "Riau", "Jambi", "Sumatera Selatan", "Lampung", "Bengkulu", "Bangka Belitung", "Kepulauan Riau", "Jakarta", "Jawa Barat", "Jawa Tengah", "Yogyakarta", "Jawa Timur", "Banten", "Bali", "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Kalimantan Barat", "Kalimantan Timur", "Kalimantan Tengah", "Kalimantan Selatan", "Sulawesi Utara", "Sulawesi Tengah", "Sulawesi Selatan", "Sulawesi Tenggara", "Gorontalo", "Sulawesi Barat", "Maluku", "Maluku Utara", "Papua", "Papua Barat"};		
  				for (String str : provinsi){
				%>
					<option value="<% out.print(str); %>" <% if ((model.get("provinsi").toString()).equals(str)) {out.print("selected");} %>><% out.print(str); %></option>
  				<%
				}  
				%>
				
			</select>
			<span id="error-provinsi"></span>
		</div>
		<div class="per_form">
			<label>Kota</label><input type="text" value="<%= model.get("kota") %>" name="Profile[kota]" id="kota" required>
			<span id="error-kota"></span>
		</div>
		<div class="per_form">
			<label>Kode Pos</label><input type="text" value="<%= model.get("kodepos") %>" name="Profile[kodepos]" id="kodepos" required>
			<span id="error-kodepos"></span>
		</div>
		<div class="per_form">
			<label>Telepon</label><input type="text" value="telepon" name="Profile[telepon]" id="telepon" required>
			<span id="error-telepon"></span>
		</div>
		<button type="submit" id="btn" onclick="return Register.compareDefault()" class="btn">Simpan</button>
	</div>
</form>


<script src="${pageContext.request.contextPath}/js/register.js"></script>
<script>
	var server = "${pageContext.request.contextPath}";
	var defaultForm = {};
	for (var key in Register.validForm) {
		if (Register.validForm.hasOwnProperty(key)) {
			defaultForm[key] = document.getElementById(key).value;
		}
	}
</script>

<jsp:include page="contentEnd.jsp"></jsp:include>