<?php include('header_admin.php'); 
	$state = 8;
	include('json-decode.php');
	for ($i=0; $i<sizeof($decoded); $i++){
		echo '<a href="json-decode.php?state=9&id=';
		echo $i+1;
		echo '">';
		echo 'Delete     </a>';
		echo '<a href="edit-barang.php?id=';
		echo $i+1;
		echo '">';
		echo 'Edit     </a>';
		echo $decoded[$i];
		echo '<br><br>';
	}	
?>