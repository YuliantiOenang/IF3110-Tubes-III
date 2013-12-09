<!DOCTYPE html> 
<?php 
				session_start();?>
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
	http.open('get', 'proses_login.php?user='+username+'&pass='+password,true);
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
				window.location="logout.php";
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
window.location="logout.php";
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
<div id="lightbox">	
		<div class="loginpoptop"><!--pop up-->
		<h4 id="loginHeader">LOGIN</h4>
		</div>
		<form id="test">
			<div class="forms">
			Username : <input type="text" id="user" required placeholder = "Username" /></br>
			</div>
			<div class="forms">
			Password : <input type="password" id="pass" required placeholder = "Password"></br>
			</div>
			<div class="forms">
			<input type="button" value="LogIn" onclick="login()"></input>
			<input type="button" value="Cancel" onclick="cancel()"></input>
			</div>
			<div class="error">
			<p id="Error"></p>
			</div>
			</form>

		</div>
<div class = "main">
		<div class = "header">
		
		<div class = "logohead">
			<div >
				<a href="index.php"><img src = "images/logo.png" class = "logo"></a>
				</img>
				</div>
			<div class = "loginplace">
				<div>
				<?php
				if(!isset($_COOKIE['user1']))
				{
				?>
					<img src = "images/login.png" class = "login" onclick="popClik()" id="loginButton"></img>
				<?php
				}
				else
				{
				?>
					<img src = "images/logout.png" class = "login" onclick="logout()" id="loginButton"></img>
				<?php
				}
				?>
				</div>
				<div >
				<?php
				if(isset($_COOKIE['user1']))
				{
				?>
					<img src = "images/cart.png" class = "cart" onclick="window.location='shoppingbag.php'"></img>
				<?php
				}
				?>
				</div>
			</div>
			<div class = "signupplace">
				
				<div>
				<?php
				if(!isset($_COOKIE['user1']))
				{
				?>
				<img src = "images/signup.png" class = "signup" id="signup" onclick="window.location='registrasi.php'"></img>
				<?php
				}
				?>
					
				</div> 
				
			<a href="see_profile.php"><p class="welctext" id="welcome"><?php if(isset($_COOKIE['user1'])) echo "WELCOME,".$_COOKIE['user1'].""; ?></p></a>
			</div>
		</div>
		<div class = "menu">
				<div>
					<a href="kategori.php?key=Jaket"><img src = "images/jacket.png" class = "jacket"></img></a>
				</div>
				<div>
					<a href="kategori.php?key=Sweater"><img src = "images/sweaters.png" class = "tshirt"></img>
				</div>
				<div >
					<a href="kategori.php?key=TShirt"><img src = "images/tshirt.png" class = "wristband"></img></a>
				</div>
				<div>
					<a href="kategori.php?key=Misc"><img src = "images/misc.png"  class = "emblem"></img></a>
				</div>
				<div>
					<a href="kategori.php?key=Pokemon"><img src = "images/pokemon.png"  class = "pokemon"></img></a>
				</div>
		</div>
		<div class = "main">
		</div>
	
</div>
<div class = "bodymain">
		<div class = "sidebar">
		
			<p class = "searchtitle"> Search it! </p>
		<form action="hasilsearch.php" method="get">
		<div class = "kategori">
			<select name="kategori">
				<option value="all">All</option>
				<option value="Jaket">Jacket</option>
				<option value="TShirt">T-shirt</option>
				<option value="Sweater">Sweater</option>
				<option value="Misc">Misc.</option>
				<option value="Pokemon">Pokemon</option>
			</select>
			<input type="text" id="user" name="key" required placeholder = "e.g. Mylo Xyloto" onkeyup="suggestSearch(this.value)" /></br>
	</div>
	
	<div class = "kategori">
	<label> Price Range: </label>
	<select name="range">
				<option value=1>< Rp50.000 </option>
				<option value=2>Rp50.000 - Rp100.000</option>
				<option value=3>Rp100.001 - Rp150.000</option>
				<option value=4>> Rp150.000</option>
				
			</select>
	</div>
	<div class = "kategori">
	<input type="submit" value="Search!"></input>
	</div>
	<label>Suggestion : <br><span id="search_suggestion" onclick="copySuggest()"></span></label>
	</form>
	</div>
	<div class = "boddy">
		<div class = "topfivetitle">
		<p class = "title"> SEARCH RESULTS</p></br></br>
		</div>
		<?php
		
		$counter=0;
		
		if(isset($_GET['key']))
		{
			session_unset();
			if($_GET['kategori'] == "all")
			{
				if($_GET['range']==1)
				{
				$hasil_temp="select nama, kategori,harga,deskripsi,foto,no_alat from peralatan where harga<50000 and nama like '%".$_GET['key']."%'";
				}
				if($_GET['range']==2)
				{
				$hasil_temp="select nama, kategori,harga,deskripsi,foto,no_alat from peralatan where harga>50000 and harga<100000 and nama like '%".$_GET['key']."%'";
				}
				if($_GET['range']==3)
				{
				$hasil_temp="select nama, kategori,harga,deskripsi,foto,no_alat from peralatan where harga>100000 and harga<150000 and nama like '%".$_GET['key']."%'";
				}
				if($_GET['range']==4)
				{
				$hasil_temp="select nama, kategori,harga,deskripsi,foto,no_alat from peralatan where harga>150000 and nama like '%".$_GET['key']."%'";
				}
				
				$_SESSION['hasil']=$hasil_temp;
				$url= "http://limitless-earth-2748.herokuapp.com/REST/getSearch/".urlencode($hasil_temp)."";
				$response=json_decode(file_get_contents($url),true);
				
				$arr=$response;
				$counter=0;
				while(isset($arr['nama'.$counter]))
				{
						$_SESSION['nama'.$counter]=$arr['nama'.$counter];
						$_SESSION['harga'.$counter]=$arr['harga'.$counter];
						$_SESSION['foto'.$counter]=$arr['foto'.$counter];
						$_SESSION['id'.$counter]=$arr['id'.$counter];
						$counter++;
						
				}
				echo $counter;
				$_SESSION['jumlah']=$counter;
			}
			else
			{
				session_unset();
				if($_GET['range']==1)
				{
				$hasil_temp="select nama, kategori,harga,deskripsi,foto,no_alat from peralatan where kategori='".$_GET['kategori']."' and harga<50000 and nama like '%".$_GET['key']."%'";
				}
				if($_GET['range']==2)
				{
				$hasil_temp="select nama, kategori,harga,deskripsi,foto,no_alat from peralatan where kategori='".$_GET['kategori']."' and harga>50000 and harga<100000 and nama like '%".$_GET['key']."%'";
				}
				if($_GET['range']==3)
				{
				$hasil_temp="select nama, kategori,harga,deskripsi,foto,no_alat from peralatan where kategori='".$_GET['kategori']."' and harga>100000 and harga<150000 and nama like '%".$_GET['key']."%'";
				}
				if($_GET['range']==4)
				{
				$hasil_temp="select nama, kategori,harga,deskripsi,foto,no_alat from peralatan where kategori='".$_GET['kategori']."' and harga>150000 and nama like '%".$_GET['key']."%'";
				}
				$_SESSION['hasil']=$hasil_temp;
				
				$url= "http://limitless-earth-2748.herokuapp.com/REST/getSearch/".urlencode($hasil_temp)."";
				$response=json_decode(file_get_contents($url),true);
				$arr=$response;
				
				$counter=0;
				while(isset($arr['nama'.$counter]))
				{
						$_SESSION['nama'.$counter]=$arr['nama'.$counter];
						$_SESSION['harga'.$counter]=$arr['harga'.$counter];
						$_SESSION['foto'.$counter]=$arr['foto'.$counter];
						$_SESSION['id'.$counter]=$arr['id'.$counter];
						$counter++;
						
				}
				echo $counter;
				$_SESSION['jumlah']=$counter;
			}
			//$_SESSION['hasil']=$hasil;
		}
		
		else
		{
		$hasil=$_SESSION['hasil'];
		
		$_SESSION['hasil']=$hasil;
		}
		if(!isset($_GET['page']))
		{
			$i=0;
			while($i<$counter && $i<10 && isset($_SESSION['nama'.$i]))
			{
			
			echo '<div class = "searchres">
					<div class = "previmage">
						<a href="detailbarang.php?id='.$_SESSION['id'.$i].'"><img src= "'.$_SESSION["foto".$i].'" class="resizeimage"><img></a>
					</div>
					<p class = "copyrightext"> '.$_SESSION["nama".$i].' </br>
						  Rp'.$_SESSION["harga".$i].' </label> </br> </p>
				</div>';
			$i++;
			}
		}
		else
		{
			
			$counter=0;
			$batas=($_GET['page']*10)+10;
			$counter=$_GET['page']*10;
			while($counter<$batas && isset($_SESSION['nama'.$counter]))
			{
			echo '<div class = "searchres">
					<div class = "previmage">
						<a href="detailbarang.php?id='.$_SESSION['id'.$counter].'"><img src= "'.$_SESSION["foto".$counter].'" class="resizeimage"><img></a>
					</div>
					<p class = "copyrightext"> '.$_SESSION["nama".$counter].' </br>
						  Rp'.$_SESSION["harga".$counter].' </label> </br> </p>
				</div>';
			$counter++;
			}
		}
		?>
			 <div class = "searchnext">
			 <?php
			 $hasil_temp=$_SESSION['hasil'];
			 $num_rows = $_SESSION['jumlah'];
			 
			 if($num_rows%10!=0 && $num_rows>10)
			 {
				$tambah=1;
			 }
			 else
			 {
				$tambah=0;
			 }
			 $jumlahPage=$num_rows/10 + $tambah;
			 
			 $i=0;
			 for($i=0;$i<$jumlahPage;$i++)
			{
			echo 'Page <a href="hasilsearch.php?page='.$i.'">'.($i+1).'  </a>';
			}
			?>
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