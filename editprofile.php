<?php
	include 'connect.php';
	include 'header.php';
	$id = $_SESSION['username'];
	$eprofile_query = "SELECT * FROM `progin_13511059`.user WHERE username = '".$id."'";
	$eprofile_hasil = mysql_query($eprofile_query,$con);
	if(!$eprofile_hasil){
		echo "Cannot Access Profile Right Now";
	}
	else{
		$eprofile_row = mysql_fetch_array($eprofile_hasil);
		echo'<form name="edit" action="javascript:verifRegis();" method="post">
			Change Password: <input type="password" onkeyup="checkPass(this)" name="password" value="'. $eprofile_row['password']. '"><div id="err_pass"></div><br>
			Confirm Password: <input type="password" onkeyup="confirmPassword(this)"name="repassword" value="'. $eprofile_row['password']. '"><div id="err_repass"></div><br>
			Nama Lengkap: <input type="text" name="fullname" onkeyup="checkFullName(this)" value="'. $eprofile_row['nama_lengkap']. '"><div id="err_fullname"></div><br>
			Nomor Hand Phone: <input type="text" name="hpnum" value="'. $eprofile_row['handphone']. '"><br>
			Alamat : <input type="text" name="address" value="'. $eprofile_row['address']. '"><br>
			Provinsi : <input type="text" name="province" value="'. $eprofile_row['province']. '"><br>
			Kecamatan : <input type="text" name="kecamatan" value="'. $eprofile_row['state']. '"><br>
			Kode Pos : <input type="text" name="postalcode" value="'. $eprofile_row['postcode']. '"><br>
			<input type="submit" id="subedit" value="Edit">
			<div id="edit_error"></div>
		</form>
	';	
	}?>
	<script>
			function confirmAll(){
				var password = document.forms['edit']['password'].value;
				var repassword = document.forms['edit']['repassword'].value;
				var namalengkap = document.forms['edit']['fullname'].value;
				var hpnum = document.forms['edit']['hpnum'].value;
				var address = document.forms['edit']['address'].value;
				var province = document.forms['edit']['province'].value;
				var kecamatan = document.forms['edit']['kecamatan'].value;
				var postcode = document.forms['edit']['postalcode'].value;
				var fullNameRegexStr = /^[A-Z][a-z]+([\ ][A-Za-z]+)+$/;
				var isNameValid = fullNameRegexStr.test(namalengkap);
				var isValid = true;
				var button = document.getElementById('subedit');
					if (password.length<8){
						isValid = false;
					}
					else if (password!=repassword){
						isValid = false;
					}
					else if (!isNameValid){
						isValid = false;
					}
					if(isValid){
						button.disabled = false;	
					}
					else{
						button.disabled = true;
					}
			}
			function verifRegis(){
				var password = document.forms['edit']['password'].value;
				var repassword = document.forms['edit']['repassword'].value;
				var namalengkap = document.forms['edit']['fullname'].value;
				var hpnum = document.forms['edit']['hpnum'].value;
				var address = document.forms['edit']['address'].value;
				var province = document.forms['edit']['province'].value;
				var kecamatan = document.forms['edit']['kecamatan'].value;
				var postcode = document.forms['edit']['postalcode'].value;
				var reg_error = document.getElementById('edit_error');
				var data = "password="+password+"&repassword="+repassword
							+"&namalengkap="+namalengkap+"&hpnum="+hpnum+"&address="+address+
							"&province="+province+"&kecamatan="+kecamatan+"&postcode="+postcode;
				if(window.XMLHttpRequest){
					xmlhttp = new XMLHttpRequest();
				}
				else{
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.onreadystatechange=function(){
					if(xmlhttp.readyState==4&&xmlhttp.status==200){
						reg_error.innerHTML = xmlhttp.responseText;
						if(reg_error==""){
							//Handle SESSION & LOCAL STORAGE
						}
					}
				}
				xmlhttp.open("POST","veredit.php",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send(data);
			}
			function checkFullName(fld){
				var err_fullname = document.getElementById("err_fullname");
				var fullNameStr = fld.value;
				var fullNameRegexStr = /^[A-Z][a-z]+([\ ][A-Za-z]+)+$/;
				var isValid = fullNameRegexStr.test(fullNameStr);
				confirmAll();
				if(!isValid){
					err_fullname.innerHTML= "The Full Name must be 2 words and only alphabets";
					return false;
				}
				else{
					err_fullname.innerHTML= "";
					return true;
				}
			}
			function checkPass(fld){
				var err_pass = document.getElementById("err_pass");
				confirmAll();
				if(fld.value.length<8){
					err_pass.innerHTML = "Password must be longer than 8 characters";
					return false;
				}
				else{
					err_pass.innerHTML = "";
					return true;
				}
			}
			function confirmPassword(fld){
				var err_repass = document.getElementById("err_repass");
				var firstPass = document.forms['edit']['password'].value;
				var nowPass = fld.value;
				confirmAll();
				if(firstPass!= nowPass){
					err_repass.innerHTML = "The Second Password is Different";
					return false;
				}
				else{
					err_repass.innerHTML = "";
					return true;
				}
			}
		</script>
	<?php include 'footer.php'; ?>