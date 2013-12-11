<?php
	include 'connect.php';
	include 'header.php';
	$id = $_GET['id'];

	$profile_query = "SELECT * FROM `progin_13511059`.user WHERE username = '".$id."'";
	$profile_hasil = mysql_query($profile_query,$con);
	if(!$profile_hasil){
		echo "Cannot Access Profile Right Now";
	}
	else{
		$profile_row = mysql_fetch_array($profile_hasil);
		echo '
			<h3>',$profile_row['nama_lengkap'],'</h3><br>
			<p>username :',$profile_row['username'],'  </p><br>
			<p>email :',$profile_row['email'],' </p><br>
			<p>Mobile :',$profile_row['handphone'],' </p><br>
			<p>Address :',$profile_row['address'],' </p><br>
			<p>Province :',$profile_row['province'],' </p><br>
			<p>State : ',$profile_row['state'],'</p><br>
			<p>Postal Code :',$profile_row['postcode'],' </p><br>
			<a href="editprofile.php"> Edit Profile </a>
		';
	}
	include 'footer.php';
?>