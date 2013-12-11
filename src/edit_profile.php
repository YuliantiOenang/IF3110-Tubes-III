<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/latihan.css"> <!--pemanggilan file css-->
<?php
if(!isset($_COOKIE['user1']))
{
	?>
			<script type="text/javascript">
						window.alert("Maaf Anda harus LOGIN terlebih dahulu");
						window.location="index.php";
						</script>
		<?php
}

?>
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

function getCookie(c_name)
//FUNGSI PENGAMBIL COOCIE
{
var c_value = document.cookie;
var c_start = c_value.indexOf(" " + c_name + "=");
if (c_start == -1)
  {
  c_start = c_value.indexOf(c_name + "=");
  }
if (c_start == -1)
  {
  c_value = null;
  }
else
  {
  c_start = c_value.indexOf("=", c_start) + 1;
  var c_end = c_value.indexOf(";", c_start);
  if (c_end == -1)
  {
c_end = c_value.length;
}
c_value = unescape(c_value.substring(c_start,c_end));
}
return c_value;
}

function checkSubmit(){
	var can_submit = true;
	var ada_berubah = false;
	//setcookie("user1",asu,time()+10000000); 
	
	document.getElementById("pesan").innerHTML = "";
	
	//CHECK PASSWORD
	if(document.getElementById("password").value == ""){
		alert("Password Tidak Boleh Kosong");
		document.getElementById("pesan").innerHTML += "Password tidak boleh kosong.\n"
		can_submit = false;
	}else{
		if(document.getElementById("password").value != document.getElementById("conf_password").value){
			alert("Password yang anda masukkan tidak sama dengan konfirmasi password");
			can_submit = false;
		}else{
			if(document.getElementById("password").value.length < 8){
				alert("Panjang password minimal 8 karakter");
				can_submit = false;
			}else{
				if(document.getElementById("password").value == getCookie("username")){
					alert("password tidak boleh sama dengan username");
					can_submit = false;
				}else{
					//document.getElementById("pesan").innerHTML = getCookie("email");
					if(document.getElementById("password").value == getCookie("email")){
						alert("Password tidak boleh sama dengan email");
						can_submit = false;
					}
				}
			}
		}
	}
	
	if(document.getElementById("nama_lengkap").value != document.getElementById("nama_lengkap").defaultValue){
		
		var cekNama = document.getElementById("nama_lengkap").value;
		cekNama.trim();
		var arrNama = cekNama.split(" ");
		
		
		if(arrNama.length > 1 && arrNama[1] != ""){
			ada_berubah = true;
		}else{
			alert("Nama tidak valid, kurang dari 2 kata");
			can_submit = false;
		}
	}
	
	if(document.getElementById("password").value != getCookie("password")){
		ada_berubah = true;
	}
	
	
	if(document.getElementById("alamat").value != document.getElementById("alamat").defaultValue){
		ada_berubah = true;
	}
	
	if(document.getElementById("provinsi").value != document.getElementById("provinsi").defaultValue){
		ada_berubah = true;
	}
	
	if(document.getElementById("kobupaten").value != document.getElementById("kobupaten").defaultValue){
		ada_berubah = true;
	}
	
	if(document.getElementById("kodepos").value != document.getElementById("kodepos").defaultValue){
		ada_berubah = true;
	}
	
	if(document.getElementById("handphone").value != document.getElementById("handphone").defaultValue){
		ada_berubah = true;
	}
	//document.write("");
	
	if(!ada_berubah){
		alert("Tidak ada data yang berubah");
		can_submit = false;
	}
	
	if(can_submit){
		//kirim data
		var data_kirim;
		data_kirim = "nama_lengkap=" + document.getElementById("nama_lengkap").value;
		data_kirim += "&password=" + document.getElementById("password").value;
		data_kirim += "&alamat=" + document.getElementById("alamat").value;
		data_kirim += "&provinsi=" + document.getElementById("provinsi").value;
		data_kirim += "&kobupaten=" + document.getElementById("kobupaten").value;
		data_kirim += "&kodepos=" + document.getElementById("kodepos").value;
		data_kirim += "&handphone=" + document.getElementById("handphone").value
		
		window.location="proses_edit.php?"+data_kirim;
		
		/*http.open("POST","proses_edit.php",true);
		http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		http.send("nama_lengkap="+document.getElementById("nama_lengkap").value+
			"&password="+document.getElementById("password").value+
			"&alamat="+document.getElementById("alamat").value+
			"&kobupaten="+document.getElementById("kobupaten").value+
			"&kodepos="+document.getElementById("kodepos").value+
			"&handphone="+document.getElementById("handphone").value
			);*/
	}
	
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

<?php
	// setcookie('user1','asu',time()+3600*24*30);
	// setcookie("IdCustomer", '1', time()+3600*24*30);
	// setcookie('username','asusampas',time()+3600*24*30);
	// setcookie("email","ampas@ampas.com",time()+3600*24*30);
	// setcookie("password","ampasampas",time()+3600*24*30);
	// setcookie("alamat","jalan sesuatu",time()+3600*24*30);
	// setcookie("provinsi","jawa Barat",time()+3600*24*30);
	// setcookie("kobupaten","bandung",time()+3600*24*30);
	// setcookie("kodepos","14350",time()+3600*24*30);
	// setcookie("handphone","08988204004",time()+3600*24*30);
?>

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
					<img src = "images/cart.png" class = "cart" onclick="window.location='shoppingbag.php'"></img>
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
		<p class = "title"> EDIT PROFILE</p></br></br>
		</div>
			<div class = "registerspace">
			<label>Nama Lengkap</label> <input type="text" id="nama_lengkap" placeholder = "Chris Martin" value =<?php echo $_COOKIE["user1"]?> defaultValue = <?php echo $_COOKIE["user1"]?>></br></br>
			
			<label>Change Password</label> <input type="password" id="password" required placeholder = "1234"></br></br>
			
			<label>Confirm change Password</label> <input type="password" id="conf_password" required placeholder = "1234"></br></br>
			
			<label>Alamat</label> <input type="text" id="alamat" placeholder = "Jl. Ganesha No.10 Bandung" value ="<?php if(isset($_COOKIE["alamat"])) echo $_COOKIE["alamat"];?>" defaultValue = <?php if(isset($_COOKIE["alamat"])) echo $_COOKIE["alamat"]?>></br></br>
			
			<label>Provinsi</label> <input type="text" id="provinsi" placeholder = "Jawa Barat" value ="<?php if(isset($_COOKIE["provinsi"])) echo $_COOKIE["provinsi"];?>" defaultValue = <?php if(isset($_COOKIE["provinsi"])) echo $_COOKIE["provinsi"]?>></br></br>
			
			<label>Kota/Kabupaten</label> <input type="text" id="kobupaten" placeholder = "Sumur Bandung" value ="<?php if(isset($_COOKIE["kobupaten"])) echo $_COOKIE["kobupaten"];?>" defaultValue = <?php if(isset($_COOKIE["kobupaten"])) echo $_COOKIE["kobupaten"]?>></br></br>
			
			<label>Kode Pos</label> <input type="text" id="kodepos" placeholder = "40124" value ="<?php if(isset($_COOKIE["kodepos"])) echo $_COOKIE["kodepos"];?>" defaultValue = <?php if(isset($_COOKIE["kodepos"])) echo $_COOKIE["kodepos"]?>></br></br>
			
			<label>Nomor Handphone</label> <input type="text" id="handphone" placeholder = "08180000000" value ="<?php if(isset($_COOKIE["handphone"])) echo $_COOKIE["handphone"];?>" defaultValue = <?php if(isset($_COOKIE["handphone"])) echo $_COOKIE["handphone"]?>></br></br>
			
			<input type="button" value = "Save" onclick="checkSubmit()"><label id="pesan"></label></br></br>
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