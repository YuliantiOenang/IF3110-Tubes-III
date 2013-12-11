<?php
session_start();
include('conn.php');
?>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home</title>
<link rel="stylesheet" href="css.css" type="text/css">
<link rel="stylesheet" href="login.css" type="text/css">
<link rel="stylesheet" href="upload.css" type="text/css">
<link rel="stylesheet" href="content.css" type="text/css">
<script type="text/javascript" src="jq-1.4.1.min.js"></script>
<script type="text/javascript">
$(function()
{
  $('.userid').keyup(function()
  {
  var userid=$(this).val();
  userid=trim(userid);
  if(userid!=''){
  $('.check').show();
  $('.check').fadeIn(400).html('<br><img src="images/ajax-loading.gif" /> ');

  var dataString = 'userid='+ userid;
  $.ajax({
          type: "POST",
          url: "check.php",
          data: dataString,
          cache: false,
          success: function(result){
               var result=trim(result);
               if(result==''){
                       $('.check').html('<font color="green"><br>'+userid+' Tersedia</font>');
                       $('#submit').attr('disabled', '');
                       $('#submit').attr('value', 'Register');
                       $(".userid").removeClass("red");
                       $(".userid").addClass("white");
               }else{
                       $('.check').html('<br>'+userid+' '+result);
                       $('#submit').attr('disabled', 'disabled');
                       $('#submit').attr('value', 'Register Deactive');
                       $(".userid").removeClass("white");
                       $(".userid").addClass("red");
               }
          }
      });
   }else{
       $('.check').html('');
       $('#submit').attr('disabled', 'disabled');
       $('#submit').attr('value', 'Register Deactive');
   }
  });
});

$(function()
{
  $('.email').keyup(function()
  {
  var email=$(this).val();
  email=trim(email);
  if(email!=''){
  $('.checkemail').show();
  $('.checkemail').fadeIn(400).html('<br><img src="images/ajax-loading.gif" /> ');

  var dataString = 'email='+ email;
  $.ajax({
          type: "POST",
          url: "checkemail.php",
          data: dataString,
          cache: false,
          success: function(result){
               var result=trim(result);
               if(result==''){
                       $('.checkemail').html('<font color="green"><br>'+email+' Tersedia</font>');
                       $('#submit').attr('disabled', '');
                       $('#submit').attr('value', 'Register');
                       $(".email").removeClass("red");
                       $(".email").addClass("white");
               }else{
                       $('.checkemail').html('<br>'+email+' '+result);
                       $('#submit').attr('disabled', 'disabled');
                       $('#submit').attr('value', 'Register Deactive');
                       $(".email").removeClass("white");
                       $(".email").addClass("red");
               }
          }
      });
   }else{
       $('.checkemail').html('');
       $('#submit').attr('disabled', 'disabled');
       $('#submit').attr('value', 'Register Deactive');
   }
  });
});

$(function()
{
  $('.nokartu').keyup(function()
  {
  var nokartu=$(this).val();
  nokartu=trim(nokartu);
  if(nokartu!=''){
  $('.checknokartu').show();
  $('.checknokartu').fadeIn(400).html('<br><img src="images/ajax-loading.gif" /> ');

  var dataString = 'nokartu='+ nokartu;
  $.ajax({
          type: "POST",
          url: "checknokartu.php",
          data: dataString,
          cache: false,
          success: function(result){
               var result=trim(result);
               if(result==''){
                       $('.checknokartu').html('<font color="green"><br>'+nokartu+' Tersedia</font>');
                       $('#btn-ok').attr('disabled', '');
                       $('#btn-ok').attr('value', 'OK');
                       $(".nokartu").removeClass("red");
                       $(".nokartu").addClass("white");
               }else{
                       $('.checknokartu').html('<br>'+nokartu+' '+result);
                       $('#btn-ok').attr('disabled', 'disabled');
                       $('#btn-ok').attr('value', 'Register Deactive');
                       $(".nokartu").removeClass("white");
                       $(".nokartu").addClass("red");
               }
          }
      });
   }else{
       $('.checknokartu').html('');
       $('#btn-ok').attr('disabled', 'disabled');
       $('#btn-ok').attr('value', 'Register Deactive');
   }
  });
});


function trim(str){
     var str=str.replace(/^\s+|\s+$/,'');
     return str;
}
</script>
</head>
<body>
	<div id="all"> 
		<div id="header"> 
			<div id="logo"> 
				<a href="index.php"> <img border="0" src="images/logo.png" width="100" height="100"></a> 
			</div> 
			<div id="shoppingbag"> 	
				<a href="index.php?page=cart&action="> <img border="0" src="images/shoppingbag.png" width="70" height="70"></a> 
				<br>shopping bag 
			</div> 
			<div id="headerright"> 	
				<table border=0>
					<tr align="center"><td><a class="linkheader" href="index.php">Home</a> </td>
						<td><a class="linkheader" href="index.php">Direktori</a></td>
						<td><a class="linkheader" href="index.php">Tentang Kami</a></td>
						<td>
						<!--SETELAH LOGIN AKAN MUNCUL LOGOUT-->
						<?php
							if(isset($_SESSION['userid'])){
								echo "<a class='linkheader' href='logout.php'>Logout</a>";
							}
							else{
								echo "<a class='linkheader' href='#popup'>Login</a>";
							}
						?>
						</td>
						<td>
						<!--/SETELAH LOGIN AKAN MUNCUL LOGOUT-->
						<!-- MUNCUL LINK WELCOME "USERNAME" JIKA SUDAH LOGIN DAN AKAN MUNCUL LINK REGISTRASI JIKA BELUM LOGIN-->
						<?php
							if(isset($_SESSION['userid'])){
								echo "<a class='linkheader' href='index.php?page=profil'>Welcome ".$_SESSION['userid']."!</a>";
							}
							else{
								echo "<a class='linkheader' href='index.php?page=registration'>Registrasi</a>";
							}
						?>
						<!-- /MUNCUL LINK WELCOME "USERNAME" JIKA SUDAH LOGIN DAN AKAN MUNCUL LINK REGISTRASI JIKA BELUM LOGIN-->
						</td></tr>
						
				<!--PENCARIAN BARANG-->
					<form action="index.php?page=search-1" method="post">
						<input type="text" name="query" />
						<select name="pencarian">
						<option value="nama_barang">Nama Barang
						<option value="kategori">Kategori
						<option value="harga_barang">Harga
						<option value="stok_barang">Stok
						</select>
						<input type="submit" name="submit" value="Cari" />
					</form>
				</table>
				<!--/PENCARIAN BARANG-->
				<!--POP UP LOGIN-->
				<div id="popup">
					<div class="window">
						<a href="#" class="close-button" title="Close">X</a>
						<h1>Login</h1>
						<form method="POST" action="sukses.php">
						<table border=0 align="center">
						<tr><td><label>Username </label></td><td><input type="text" name="userid" id="userid"><br></td></tr>
						<tr><td><label>Password </label></td><td><input type="password" name="password" id="password"><br></td></tr>
						<tr><td></td><td><input class="submit" type="submit" name="submit" value="login"></td></tr>
						</table>
						</form>
					</div>
				</div>
				<!--/POP UP LOGIN-->
				<!--POP UP UPLOAD-->
				<div id="uploadgambar">
					<div class="windowupload">
						<a href="#" class="close-buttonupload" title="Close">X</a>
						<h1>Tambah Barang</h1>
						<form action="upload-file.php" method="post" enctype="multipart/form-data">
						<table border=0 align="center">
						<tr><td><label>Nama Barang:</label></td><td><input type="text" name="namabarang" id="namabarang"><br></td></tr>
						<tr><td><label>Harga:</label></td><td><input type="text" name="harga" id="harga"><br></td></tr>
						<tr><td><label>Stok:</label></td><td><input type="text" name="stok" id="stok"><br></td></tr>
						<tr><td><label>Kategori:</label></td><td>
						<select id="kategori" name="kategori"><?php
							$the_key = 'Sembako'; // or whatever you want
							foreach(array(
								'Sembako' => 'Sembako',
								'Daging' => 'Daging',
								'Sayur' => 'Sayur',
								'Buah' => 'Buah',
								'Bumbu Dapur' => 'Bumbu Dapur',
								'Snack' => 'Snack',
								'Minuman' => 'Minuman',
								'Sabun' => 'Sabun',
								'Lainnya' => 'Lainnya',
							) as $key => $val){
						?><option value="<?php echo $key; ?>"<?php
							if($key==$the_key)echo ' selected="selected"';
						?>><?php echo $val; ?></option><?php
							}
						?></select>
						<br></td></tr>
						<tr><td><label for="file">Filename:</label></td><td><input type="file" name="file" id="file"><br></td></tr>
						<tr><td></td><td><input class="submit" type="submit" name="submit" value="Upload"></td></tr>
						</table>
						</form>
					</div>
				</div>
				<!--/POP UP UPLOAD-->
			 </div>
		 </div>
		 <div id="navigasi">
			 <ul class="nav">
				 <li><a href="index.php?page=listbarang&kategori=Sembako">Sembako</a></li>
				  <li><a href="index.php?page=listbarang&kategori=Daging">Daging</a></li>
				 <li><a href="index.php?page=listbarang&kategori=Sayur">Sayur</a></li>
				 <li><a href="index.php?page=listbarang&kategori=Buah">Buah</a></li>
				 <li><a href="index.php?page=listbarang&kategori=Bumbu Dapur">Bumbu Dapur</a></li>
				 <li><a href="index.php?page=listbarang&kategori=Snack">Snack</a></li>
				 <li><a href="index.php?page=listbarang&kategori=Minuman">Minuman</a></li>
				 <li><a href="index.php?page=listbarang&kategori=Sabun">Sabun</a></li>
				 <li><a href="index.php?page=listbarang&kategori=Lainnya">Lainnya</a></li>
				 </ul>
		</div>
		<?php
		
		
		if(isset($_GET['page'])) {
			$page = $_GET['page'] . ".php";
			include ($page);
		}
		else if(isset($_POST['efullname'])){
		
			$_SESSION['hasefullname'] = $_POST['efullname'] ;
			$_SESSION['hasenohp'] = $_POST['enohp'];
			$_SESSION['hasealamat'] = $_POST['ealamat'];
			$_SESSION['haseprovinsi'] = $_POST['eprovinsi'];
			$_SESSION['hasekabupaten'] = $_POST['ekabupaten'];
			$_SESSION['hasekodepos'] = $_POST['ekodepos'];
			$_SESSION['hasepassword'] = $_POST['epwd1'];
			include ("suksesedit.php");
		}
		else if(isset($_SESSION['efullname']) && isset($_SESSION['enohp']) && isset($_SESSION['ealamat']) && isset($_SESSION['eprovinsi']) && isset($_SESSION['ekabupaten']) && isset($_SESSION['ekodepos']) && isset($_SESSION['epassword'])){
			//MENUJU FORM EDIT PROFILE
			$page = "editprofil.php";
			include ($page);
		}
		else if(isset($_SESSION['userid']) && isset($_SESSION['nokartu'])){
			include ('prosedur.php');
		}
		else if(isset($_SESSION['userid']) && isset($_SESSION['password']) && isset($_SESSION['fullname']) && isset($_SESSION['email'])){
			include ('daftarkartukredit.php');
		}
		
		else if(isset($_SESSION['admin'])){
			include ('prosedur.php');
		}
		else if(isset($_SESSION['buyer'])){
			//echo"buyer";
			include ('prosedur.php');
		}
		else {
			include ('prosedur.php');
		}?>	
	</div>
	<!-- INI KEMARIN KETINGGALAN JS NYA !!! -->
	<script type = "text/javascript" src="prosedur.js"></script>
</body>

<?php

?>