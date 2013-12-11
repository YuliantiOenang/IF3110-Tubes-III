<!DOCTYPE html> 
<html>

<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/latihan.css"> <!--pemanggilan file css-->

</head>

<script src="js/AjaxCreateObject.js" language="javascript"></script>
<script type="text/javascript">

function suggestSearch(str){
	//document.getElementById("search_suggestion").innerHTML = str;
	if(str.length == 0){
		document.getElementById("search_suggestion").innerHTML="";
		return;
	}
	
	http.onreadystatechange=function(){
		if(http.readyState == 4 && http.status == 200){
			document.getElementById("search_suggestion").innerHTML = http.responseText;
		}
	}
	
	http.open("GET","proses_suggest_search.php?q="+str,true);
	http.send();
}

function copySuggest(){
	var x = document.getElementsByName("key");
	x[0].value = document.getElementById("search_suggestion").innerHTML;
}


function popClik()
{
	
	var lightbox = document.getElementById("lightbox");
       var dimmer = document.createElement("div");
    
    dimmer.style.width =  document.documentElement.scrollWidth + 'px';
    dimmer.style.height = document.documentElement.scrollHeight + 'px';
    dimmer.className = 'dimmer';
    dimmer.id='dim';
    test.onclick=function(){
        document.body.removeChild(this);   
        lightbox.style.visibility = 'hidden';
    }
    
    dimmer.onclick = function(){
        document.body.removeChild(this);   
		document.getElementById('user').value="";
		document.getElementById('pass').value="";
        lightbox.style.visibility = 'hidden';
    }
        
    document.body.appendChild(dimmer);
    
    lightbox.style.visibility = 'visible';
    lightbox.style.top = window.innerHeight/2 - 200 + 'px';
    lightbox.style.left = window.innerWidth/2 - 100 + 'px';
	document.getElementById("user").focus();
}
function login()
{
	//mengambil semua variable dalam form login
	var username = encodeURI(document.getElementById('user').value);	
	var password = encodeURI(document.getElementById('pass').value);
	
	//request ke file php
	http.open('get', 'proses_login.jsp?user='+username+'&pass='+password,true);
	//cek hasil request 4 jika berhasil
	http.onreadystatechange = function()
	  {
		
		if (http.readyState==4 && http.status==200)
		{
			try
			{
			var decodeJSON = JSON.parse(http.responseText);
			
			document.getElementById("welcome").innerHTML="WELCOME,"+decodeJSON.nama;
			var lightbox = document.getElementById("lightbox");
			var dimmer = document.getElementById("dim");
			var signup = document.getElementById("signup");
			
			var loginButton = document.getElementById("loginButton");
			lightbox.style.visibility = 'hidden';
			signup.style.visibility = 'hidden';
			loginButton.src="images/logout.png";
			loginButton.onclick=function()
			{
				window.location="logout.jsp";
			}
			document.body.removeChild(dimmer); 
			remove("signup"); 
			
			}
			catch(e)
			{
			document.getElementById("Error").innerHTML="Welcome,"+http.responseText;
			var user=document.getElementById("user");
			
			
			}
		}
	  }
	http.send(); 
	
}
function logout()
{
window.location="logout.jsp";
}
function cancel()
{
	var lightbox = document.getElementById("lightbox");
	var dimmer = document.getElementById("dim");
	lightbox.style.visibility = 'hidden';
	document.getElementById('user').value="";
	document.getElementById('pass').value="";
	document.body.removeChild(dimmer); 
}
function remove(id)
{
    return (elem=document.getElementById(id)).parentNode.removeChild(elem);
}
</script>

<body>
    <?php include "headeradmin.php"; ?>
	<div class = "bodymain">
		
		<div class = "boddy">
			<div class = "topfivetitle">
			<p class = "title"> TOP THREE JACKETS</p></br>
			</div>
			<div class = "topthreecat">
				<?php
					$count=0;
					$hasil = mysql_query("SELECT peralatan.no_alat,peralatan.nama,peralatan.harga,terbayar.jumlah,peralatan.foto FROM `terbayar`,`peralatan` where peralatan.no_alat=terbayar.id_barang and peralatan.kategori='Jaket' group by peralatan.nama order by terbayar.jumlah desc");
					while(($baris=mysql_fetch_row($hasil)) && $count<3)
					{
					echo "<div class = 'toppreview'>
						<div class = 'previmage'>
							<a href='detailbarang.php?id=".$baris[0]."'><img src='".$baris[4]."' class='resizeimage'></a>
						</div>
						<p class = 'copyrightext'> ".$baris[1]." </br>
						  Rp".$baris[2]." </label> </br> </p>
					</div>";
							$count++;
					}
				?>
			</div>
			<div class = "topfivetitle">
			<p class = "title"> TOP THREE SWEATER</p></br>
			</div>
			<div class = "topthreecat">
				<?php
					$count=0;
					$hasil = mysql_query("SELECT peralatan.no_alat,peralatan.nama,peralatan.harga,terbayar.jumlah,peralatan.foto FROM `terbayar`,`peralatan` where peralatan.no_alat=terbayar.id_barang and peralatan.kategori='Sweater' group by peralatan.nama order by terbayar.jumlah desc");
					while(($baris=mysql_fetch_row($hasil)) && $count<3)
					{
					echo "<div class = 'toppreview'>
						<div class = 'previmage'>
							<a href='detailbarang.php?id=".$baris[0]."'><img src='".$baris[4]."' class='resizeimage'></a>
						</div>
						<p class = 'copyrightext'> ".$baris[1]." </br>
						  Rp".$baris[2]." </label> </br> </p>
					</div>";
							$count++;
					}
				?>
			</div>
			<div class = "topfivetitle">
			<p class = "title"> TOP THREE T-SHIRTS</p></br>
			</div>
			<div class = "topthreecat">
				<?php
					$count=0;
					$hasil = mysql_query("SELECT peralatan.no_alat,peralatan.nama,peralatan.harga,terbayar.jumlah,peralatan.foto FROM `terbayar`,`peralatan` where peralatan.no_alat=terbayar.id_barang and peralatan.kategori='TShirt' group by peralatan.nama order by terbayar.jumlah desc");
					while(($baris=mysql_fetch_row($hasil)) && $count<3)
					{
					echo "<div class = 'toppreview'>
						<div class = 'previmage'>
							<a href='detailbarang.php?id=".$baris[0]."'><img src='".$baris[4]."' class='resizeimage'></a>
						</div>
						<p class = 'copyrightext'> ".$baris[1]." </br>
						  Rp".$baris[2]." </label> </br> </p>
					</div>";
							$count++;
					}
				?>
			</div>
			<div class = "topfivetitle">
			<p class = "title"> TOP THREE MISC.</p></br>
			</div>
			<div class = "topthreecat">
				<?php
					$count=0;
					$hasil = mysql_query("SELECT peralatan.no_alat,peralatan.nama,peralatan.harga,terbayar.jumlah,peralatan.foto FROM `terbayar`,`peralatan` where peralatan.no_alat=terbayar.id_barang and peralatan.kategori='Misc' group by peralatan.nama order by terbayar.jumlah desc");
					while(($baris=mysql_fetch_row($hasil)) && $count<3)
					{
					echo "<div class = 'toppreview'>
						<div class = 'previmage'>
							<a href='detailbarang.php?id=".$baris[0]."'><img src='".$baris[4]."' class='resizeimage'></a>
						</div>
						<p class = 'copyrightext'> ".$baris[1]." </br>
						  Rp".$baris[2]." </label> </br> </p>
					</div>";
							$count++;
					}
				?>
			</div>
			<div class = "topfivetitle">
			<p class = "title"> TOP THREE POKEMON</p></br>
			</div>
			<div class = "topthreecat">
				<?php
					$count=0;
					$hasil = mysql_query("SELECT peralatan.no_alat,peralatan.nama,peralatan.harga,terbayar.jumlah,peralatan.foto FROM `terbayar`,`peralatan` where peralatan.no_alat=terbayar.id_barang and peralatan.kategori='Pokemon' group by peralatan.nama order by terbayar.jumlah desc");
					while(($baris=mysql_fetch_row($hasil)) && $count<3)
					{
					echo "<div class = 'toppreview'>
						<div class = 'previmage'>
							<a href='detailbarang.php?id=".$baris[0]."'><img src='".$baris[4]."' class='resizeimage'></a>
						</div>
						<p class = 'copyrightext'> ".$baris[1]." </br>
						  Rp".$baris[2]." </label> </br> </p>
					</div>";
							$count++;
					}
				?>
			</div>
			<div class = "mekanisme">
			<p class = "copyrightext"> Mekanisme Pembayaran </br></br>
			1. Pembeli melakukan login atau sign up
			2. Pembeli memesan produk-produk yang ingin dibeli </br>
			3. Pembeli melakukan checkout dengan memilih cart </br>
			4. Pembeli memilih mekanisme pembayaran, yaitu dengan kartu kredit yang dipilih </br>
			</div>
		</div>
		</div>
		<div class = "footer">
			<div class = "info">

			</div>
			
					
			
		</div>
</div>
</body>
</html>