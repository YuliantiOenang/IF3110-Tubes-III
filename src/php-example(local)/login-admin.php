<?php

//include('database_connection.php');

include "json-decode.php";
/*$sql="SELECT * FROM $tbl_name WHERE username='$myusername' and password='$mypassword'";
$result=mysql_query($sql, $link);

// Mysql_num_row is counting table row
$count=mysql_num_rows($result);*/

// If result matched $myusername and $mypassword, table row must be 1 row

if($decoded==1){
	?>
	<script type="text/javascript">
		localStorage.login='<?php echo $_POST['username7'];?>';
		var d = new Date();
		d.setDate(d.getDate() + 30);
		var n = d.getTime();
		localStorage.expired=n; 
		window.location="index-admin.php";
	</script>
	<?php
}
else {
	?>
	<script type="text/javascript">
		alert("login atau pass tidak sesuai");
		window.location="index-admin.php";
	</script>
	<?php
}
?>