<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head><title>Pendaftaran Kartu Kredit</title></head>
<link rel="stylesheet" href="css/registerform.css" type="text/css" />
<link rel="stylesheet" href="css/kalender.css" type="text/css" />
<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
	<%@ include file="header.jsp" %>
	<article id="featured" class="body">
	<form id="registerform" method="post" action="registercard" name="myform">
	<strong><h2>Pendaftaran Kartu Kredit</h2></strong><br>
	<p><script>document.write(localStorage.wbduser);</script> bisa mendaftarkan kartu kredit sekarang atau nanti</p>
	<pre>Card Number	<input type="text" name="cardnumber"></pre>
	<pre>Name on Card	<input type="text" name="nama"></pre>
	<pre>Expired Date 	<input onclick="ds_sh(this);" name="expired" readonly="readonly" style="cursor: text"></pre>
	<input type="hidden" name="username" id="usernamep" value="">
	<div id="cek"><input type="button" value="Ok" onclick="cekkartu(document.forms['myform']);"> <a href="index.jsp">Skip</a></div>
	</form>
	<script>
	if(typeof(Storage)!=="undefined"){
		if(!localStorage.wbduser){
			var s = "<strong>Maaf, halaman ini tidak bisa diakses jika kamu belum login.</strong><br>";
			s += "<p>Halaman akan segera dialihkan ke halaman registrasi...</p>";
			document.getElementById("registerform").innerHTML = s;
			setTimeout("window.location='registerform.jsp'",3000);
		}else{
			document.getElementById("usernamep").value=localStorage.wbduser;
		}
	}else{
		document.getElementById("menubar").innerHTML="Maaf, browser kamu tidak support Web Storage sehingga informasi username tidak dapat disimpan...";
	}
	function cekkartu(form){
		var xmlhttp;
		if (form.cardnumber.value.length==0 || form.nama.value.length==0){	 
			alert("Masih ada form yang belum Anda isi");
		}else{
			if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp=new XMLHttpRequest();
			}else{// code for IE6, IE5
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}	
			xmlhttp.onreadystatechange=function(){
				if (xmlhttp.readyState==4 && xmlhttp.status==200){
					if(xmlhttp.responseText=="valid"){
						form.submit();
					}else{
						alert("Pendaftaran kartu kredit gagal!\nNomor Kartu atau Nama Anda tidak valid");
					}
					document.getElementById("cek").innerHTML='<input type="button" value="Ok" onclick="cekkartu(document.forms[\'myform\']);"> <a href="index.jsp">Skip</a>';
				}else{
					document.getElementById("cek").innerHTML="<img src='images/mini-loader.gif'> Harap tunggu! kami sedang memvalidasi kartu kredit Anda...";
				}
			}
			xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/registercard?cardnumber="+form.cardnumber.value+"*name="+form.nama.value,true);
			xmlhttp.send();
		}
	}
	</script>
	<div class="ds_box" id="ds_conclass" style="display: none;">
		<div id="ds_calclass"></div>
	</div>
<script type="text/javascript" src="javascript/kalender.js"></script>
	</article><!-- /#featured -->
	<%@ include file="footer.jsp" %>
	</div>
</body>