<?php include "header.php";?>
<?php include "sidebar.php";?>
<article id="featured" class="body">
		<h2 id="headername"></h2>
		<div id="info"></div>
			<span id="foto" style="float:left"></span>
			<pre><h4>   Nama Lengkap:</h4></pre>
			<pre><h2 id="nama">     </h2></pre>
			<pre><h4>   Username:</h4></pre>
			<pre><h2 id="usernamep">     @</h2></pre><br><hr>
			<pre><h4>Basic Info</h4></pre>
			<pre id="nomorhp">Nomor Hp		: </pre>
			<pre id="alamat">Alamat		: </pre>
			<pre id="provinsi">Provinsi		: </pre>
			<pre id="kota">Kota			: </pre>
			<pre id="kodepos">Kode Pos		: </pre>
			<pre id="email">Email			: </pre>
			<pre id="trans">Jumlah Transaksi yang sudah dilakukan	: </pre>
		<form method="post" action="editprofile.php">
		<input type="submit" value="Edit Profile"> <span id="cekkartu"></span>
		</form>
</article><!-- /#featured -->
<script>
if(typeof(Storage)!=="undefined"){
	if(localStorage.wbduser){
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				var str = xmlhttp.responseText.split("||");
				document.getElementById("nama").innerHTML+=str[0];
				document.getElementById("nomorhp").innerHTML+=str[1];
				document.getElementById("alamat").innerHTML+=str[2];
				document.getElementById("provinsi").innerHTML+=str[3];
				document.getElementById("kota").innerHTML+=str[4];
				document.getElementById("kodepos").innerHTML+=str[5];
				document.getElementById("email").innerHTML+=str[6];
				document.getElementById("usernamep").innerHTML+=str[7];
				document.getElementById("foto").innerHTML+="<img src='images/"+str[9]+"'>";
				document.getElementById("trans").innerHTML+=str[10];
				document.getElementById("info").innerHTML="";
			}else{
				document.getElementById("info").innerHTML="<img src='images/ajax-loader.gif'>";
			}
		}
		xmlhttp.open("POST","ajaxprofile.php",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("username="+localStorage.wbduser);
		cekkartu(localStorage.wbduser);
	}else{
		var s = "<strong>Maaf, halaman ini tidak bisa diakses jika kamu belum login.</strong><br>";
		s += "<p>Halaman akan segera dialihkan ke halaman registrasi...</p>";
		document.getElementById("featured").innerHTML = s;
		setTimeout("window.location='registerform.php'",3000);
	}
}else{
	document.getElementById("menubar").innerHTML="Maaf, browser kamu tidak support Web Storage sehingga informasi username tidak dapat disimpan...";
}
function cekkartu(username){
	var xmlhttp;
	if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			if(xmlhttp.responseText=="error"){
				document.getElementById("cekkartu").innerHTML="Gagal mengambil data kartu kredit dari database.";
			}else if(xmlhttp.responseText=="notregistered"){
				document.getElementById("cekkartu").innerHTML="<a href='registercardform.php'>Daftarkan kartu kredit saya</a>";
			}else{
				document.getElementById("cekkartu").innerHTML="Nomor kartu kredit Anda : "+xmlhttp.responseText;
			}
		}else{
			document.getElementById("cekkartu").innerHTML="<img src='images/ajax-loader.gif'>";
		}
	}
	xmlhttp.open("POST","cekkartukredit.php",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("username="+username);
}
</script>
<?php include "footer.php";?>

</div>
</body>
</html>