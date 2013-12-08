<html>

<head>
<title>Edit Profile</title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/registration.css" />
<script src="js/ajax.js"></script>
<script src="js/login.js"></script>

<script type="text/javascript">
function ValidateForm(form)
{

var a=document.forms["form1"]["name"].value;
var b=document.forms["form1"]["province"].value;
var c=document.forms["form1"]["address"].value;
var d=document.forms["form1"]["contact"].value;
var e=document.forms["form1"]["email"].value;
var f=document.forms["form1"]["username"].value;
var g=document.forms["form1"]["password"].value;
var h=document.forms["form1"]["cpassword"].value;
var i=document.forms["form1"]["city"].value;
var j=document.forms["form1"]["zipcode"].value;

if (a==null || a=="")
  {
  alert("Name must be filled out");
  return false;
  }
if (b==null)
  {
  alert("Province must be filled out");
  return false;
  }
if (i==null)
  {
  alert("City must be filled out");
  return false;
  }
if (j==null || a=="")
  {
  alert("Zip Code must be filled out");
  return false;
  }
if (f.length<5)
  {
  alert("Username must be more than 5 characters");
  return false;
  }
if (g.length<8)
  {
  alert("Password must be more than 8 characters");
  return false;
  }
if (c==null || c=="")
  {
  alert("Address must be filled out");
  return false;
  }
if (e==null || e=="")
  {
  alert("Email address must be filled out");
  return false;
  }
if (f==null || f=="")
  {
  alert("username must be filled out");
  return false;
  }
if (g==null || g=="")
  {
  alert("Password must be filled out");
  return false;
  }
if (h==null || h=="")
  {
  alert("Confirm password must be filled out");
  return false;
  }
if (h!=g)
  {
  alert("Password is not same with confirmed one!");
  return false;
  }
 
if (e==g)
  {
  alert("Password is same email address!");
  return false;
  }
  
//var reg = /^[a-z][0-9a-z]*([._][0-9a-z])*[@][a-z0-9]+([.][a-z]{2,})+$/;
/*if (!reg.test(e)){
	alert("Email is not valid");
	return false;
}*/

var reg = /^.+@.+\..{2,}$/;
if (!reg.test(e)){
	alert("Email is not valid");
	return false;
}

var reg = /^.+ .+$/;
if (!reg.test(a)){
	alert("Name is not valid");
	return false;
}

	var data = {"name" : a, "provinsi" :b, "address" : c, "contact" : d, "email" : e, "username" : f, "password" : g, "city" : i,"zipcode" : j};
	var callback = function(response){	
		if(response.status == "ok"){
			alert("Anda berhasil edit profile");
			
			var hasil = {"user": f, "id": response.id};
			localStorage.setItem("logininfo", JSON.stringify(hasil));
			
			window.location = "kredit.php";
		}else{
			alert(response.raw);
		}
	};
	
	sendAjax(data, "handle_edit_profile.php", callback);
	
	//action="handle_registration.php">
}
</script>

</head>

<body onload="return !redirect_login();">
<div class="outer">
	<?php
		include("header.php");
		include("lib/rest_request.php");
		$data["token"]=$_GET["t"];
		$result = sendRestRequest("GET","user/".$_GET["u"],$data);
		$user = $result["user"];
echo"<div class='content'>";
echo"<h3>Edit Profile</h3>";
echo"<form id='form1' name='form1' method='post'>";
echo"<div id='regtable' class='table'>";
echo"<div class='row'>";
echo"		<div class='cell50'>Name:</div>";
echo"		<div class='cell50'><input type='text' name='name' value=".$user["nama_lengkap"]."/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>Address:</div>";
echo"		<div class='cell50'><input type='text' name='name' value=".$user["alamat"]."/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>Province:</div>";
echo"		<div class='cell50'><input type='text' name='name' value=".$user["provinsi"]."/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>City:</div>";
echo"		<div class='cell50'><input type='text' name='name' value=".$user["kota"]."/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>Zip Code:</div>";
echo"		<div class='cell50'><input type='text' name='name' value=".$user["kodepos"]."/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>Contact No:</div>";
echo"		<div class='cell50'><input type='text' name='name' value=".$user["telepon"]."/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>Email:</div>";
echo"		<div class='cell50'><input type='text' name='name' value=".$user["email"]."/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>Username:</div>";
echo"		<div class='cell50'><input type='text' name='name' value=".$user["username"]."/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>Password:</div>";
echo"		<div class='cell50'><input type='text' name='password'/></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'>Confirm Password:</div>";
echo"		<div class='cell50'><input type='text' name='cpassword'/></div>";
echo"</div>
	</div>
	</form>
</div></div>
</body>
</html>";
?>