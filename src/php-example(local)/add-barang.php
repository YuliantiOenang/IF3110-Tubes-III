	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Registrasi Identitas</title>
		<script type="text/javascript">
			var xmlhttp;
			if (window.XMLHttpRequest)
  			{// code for IE7+, Firefox, Chrome, Opera, Safari
  				xmlhttp=new XMLHttpRequest();
  			}
			else
  			{// code for IE6, IE5
  				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  			}
  			var valid = false;
  			function username_check () {
  				var username = document.getElementById('nama').value;
					xmlhttp.open("POST","json-decode.php",true);
					xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xmlhttp.send("nama="+username);

					xmlhttp.onreadystatechange = function () {
						if (xmlhttp.readyState==4 && xmlhttp.status==200)
						{
							if (xmlhttp.responseText == '0') {
								valid = true;
								document.getElementById("status").innerHTML='<img src="available.png" align="absmiddle"> <font color="Green"> Lanjutkan </font>';
							} else {
								document.getElementById("status").innerHTML='<img src="not_available.png" align="absmiddle"> <font color="red">Nama arang tersebut sudah ada </font>';
							}
						}
					}
				this.validasi();
			}
			function validasi () {
				if (valid) {
					document.getElementById("reg_btn").disabled = false;
				}
			}
		</script>
	</head>
	<body onLoad="load()">
		<?php include('header_admin.php'); ?>	
		<div id="content">
		 	<form method="post" action="soap-client-example.php">
		    	<div class="style_form">
		      		<label for="nama">Nama Barang: </label>
		      		<input type="text" name="nama" id="nama" class="form_element" onkeyup="username_check()"/>
		      		<span id="status"></span> </div>
		    	<div class="style_form">
		      		<label for="kategori">Kategori: </label>
		      		<input type="text" name="kategori" id="kategori" class="form_element"/>
		      		<span id="status2"></span> </div>
		    	<div class="style_form">
		      		<label for="harga">Harga: </label>
		      		<input type="text" name="harga" id="harga" class="form_element"/>
		      		<span id="status3"></span> </div>
		    	<div class="style_form">
		      		<label for="stok">Stok: </label>
		      		<input type="text" name="stok" id="stok" class="form_element"/>
		      		<span id="status4"></span> </div>
		    	<div class="style_form">
		      		<label for="deskripsi">Deskripsi: </label>
		      		<input type="text" name="deskripsi" id="deskripsi" class="form_element"/>
		      		<span id="status5"></span> </div>
		    	<div class="style_form">
		      		<label for="path">Path Gambar: </label>
		      		<input type="text" name="path" id="path" class="form_element"/>
		      	</div>
		    	<div class="style_form">
		      		<input name="submit" type="submit" value="tambahkan" id="reg_btn" disabled/>
		    	</div>
		  	</form>
		</div>
	</body>
</html>
