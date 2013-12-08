<html>
<head>
<title>Edit Profile</title>
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/registration.css" />
<script src="js/ajax.js"></script>
<script src="js/login.js"></script>

<script>
function goToEdit() {
<?php
	$u = $_GET["u"];
	$t = $_GET["t"];
	echo "window.location = 'edit_profile.php?u=".$u."&t=".$t."'";
?>
}
</script>

</head>

<body onload="return !redirect_login();">
<div class="outer">
	<?php
		include("header.php");
		include("lib/rest_request.php");
		$data["token"]=$t;
		$result = sendRestRequest("GET","user/".$u,$data);
		$user = $result["user"];
echo"<div class='content'>";
echo"<h3>Edit Profile</h3>";
echo"<form id='form1' name='form1' method='post'>";
echo"<div id='regtable' class='table'>";
echo"<div class='row'>";
echo"		<div class='cell50'><pre>Name			: ".$user["nama_lengkap"]."</pre></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'><pre>Address			: ".$user["alamat"]."</pre></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'><pre>Kota				: ".$user["kota"]."</pre></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'><pre>Provinsi			: ".$user["provinsi"]."</pre></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'><pre>Zip Code			: ".$user["kodepos"]."</pre></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'><pre>City				: ".$user["kota"]."</pre></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'><pre>Contact			: ".$user["telepon"]."</pre></div>";
echo"</div>";
echo"<div class='row'>";
echo"		<div class='cell50'><pre>Email			: ".$user["email"]."</pre></div>";
echo"</div>";
echo"<div class='row'>";
echo"	<div class='cell50'><input type='button' onclick='goToEdit()' value='Edit' /></div>";
echo"</div>
	</div>
	</div>
	</form>
</div></div>
</body>
</html>";
?>