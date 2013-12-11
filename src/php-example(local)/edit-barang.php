	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Registrasi Identitas</title>
	</head>
	<body onLoad ="load()">
		<?php include('header_admin.php'); ?>		
		<div id="content">
		</div>
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
			var id;
			id = <?php echo $_GET['id'] ?>;
			function load () {
				xmlhttp.open("POST","json-decode.php",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send("id2="+id);

				xmlhttp.onreadystatechange = function () {
					if (xmlhttp.readyState==4 && xmlhttp.status==200)
					{
						document.getElementById("content").innerHTML=xmlhttp.responseText;
					}
				}				
			}
		</script>
	</body>
</html>
