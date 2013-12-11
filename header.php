<?php
	include 'connect.php';
	session_start();
	function getCateLink($idkat){
	
		if($idkat==1){
			$nama = "Pangan";
		}
		else if($idkat==3){
			$nama = "Elektronik";
		}
		else if($idkat==2){
			$nama = "Pakaian";
		}
		else if($idkat==4){
			$nama = "Rumah Tangga";
		}
		else if($idkat==5){
			$nama = "Olah Raga";
		}
		$page = 1;
		echo '<li> <a href="kategori.php?id=', $idkat ,'&page=', $page ,'">', $nama ,'</a></li>';
	} ?>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
			<title>RUko SERba imBA </title>
			<link href="AJS_style.css" rel="stylesheet" type="text/css" />
			<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
			<link href="css/layout.css" rel="stylesheet" type="text/css" />
        	<link href="css/modal.css" rel="stylesheet" type="text/css" />

	</head>
		<body>
			<div id="AJS_body_wrapper">
			<div id="AJS_wrapper">
				<div id="AJS_header">
					<?php
						if (!isset($_SESSION['username'])){
							echo '<div id="site_title"><h1><a href="index.php">Ruko Serba Ada</a></h1></div>';
						} else {
							echo '<div id="site_title"><h1><a href="index.php">Welcome, '.$_SESSION['username'].'</a></h1></div>';
						}
					?>
        			<div id="header_right">
        				<p>
	           
            			</p>
					</div>	
					<div class="cleaner"></div>
				</div> <!-- End Of Header -->
			<div id="AJS_menubar">
				<div id="top_nav" class="ddsmoothmenu">
					<ul>
                		<?php
                			if (!isset($_SESSION['username'])){
								echo '<li><a href="register.php">Sign Up</a></li>
									<li><a href="#login_form">Log in </a></li>';
							}
							else{
								echo '	<li><a href="cardregist.php"> Register Credit Card </a></li>
										<li><a href="shoppingbag.php"> Shopping Bag </a></li>
										<li><a href="profile.php?id=',$_SESSION['username'],'">Profile</a></li>
										<li><a href="logout.php">Log out</a></li>';

							}
						?>
                	</ul>
                	<br style="clear: left" />
		        </div> <!-- end of ddsmoothmenu -->	
    	</div> <!-- END of AJS_menubar -->
    	<!-- popup form #1 -->
        <a href="#x" class="overlay" id="login_form" ></a>
        <div class="popup">
            <h2>Welcome Guest!</h2>
            <p>Please enter your login and password here</p>
            <form name="login" action="javascript:verLogin();" method="post">
	            
	                Username : <input type="text" name="username"><br>
	                Password : <input type="password" name="password"><br>
	                <div id="err_login"></div><br>
	            	<input type="submit" value="Log In" />
	        </form>
            <a class="close" href="#close"></a>
        </div>

    	<div id="AJS_main">
			<div id="sidebar" class="float_r">
				
	        	<div class="sidebar_box"><span class="bottom"></span>
	        		<h3>Search Option : </h3>
	        		<form name="search" action="search.php" method="get">
						<input type="hidden" name="page" value="1">
						<input type="text" name="searched" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
						<input type="submit" value="Cari" alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
		        		<p>Kategori : </p>
		        		<select name="s_kategori">
							<option value="1">Pangan</option>
							<option value="2">Pakaian</option>
							<option value="3">Elektronik</option>
							<option value="4">Rumah Tangga</option>
							<option value="5">Olah Raga</option>
						</select><br>
						<p>Harga kurang dari : </p>
						<input type="text" name="s_harga" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
					</form>

	            	<h3>Kategori</h3>   
	                <div class="content"> 
	                	<ul class="sidebar_list">
	                        <?php
					    		$kategori_query = 'SELECT DISTINCT kategori_barang FROM `progin_13511059`.barang';
								$kategori_hasil = mysql_query($kategori_query,$con);
								if(!$kategori_hasil){
									echo'Tidak dapat mengakses kategori';
								}
								else{
									while($kategori_row = mysql_fetch_array($kategori_hasil)){
										getCateLink($kategori_row['kategori_barang']);
									}
								}
							?>
	                    </ul>
	                </div>
	            </div>
	        </div>

		<script>
			function verLogin(){
				var username = document.forms['login']['username'].value;
				var password = document.forms['login']['password'].value;
				var err_login = document.getElementById("err_login");
				var isLogin = false;
				if(window.XMLHttpRequest){
					xmlhttp = new XMLHttpRequest();
				}
				else{
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.onreadystatechange=function(){
					if(xmlhttp.readyState==4&&xmlhttp.status==200){
						err_login.innerHTML = xmlhttp.responseText;

						if(err_login==""){
							//Handle SESSION & LOCAL STORAGE
						}
					}
				}
				xmlhttp.open("GET","login.php?username="+username+"&password="+password,true);
				xmlhttp.send();
			}
		</script>

