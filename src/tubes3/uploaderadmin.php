<?php
require_once('header.php'); ?>
<html>
	<head>
		<script>
			if (localStorage.user!="admin") {
				window.location = "index.jsp"
			}
			
		</script>

	<link rel="stylesheet" href="layout.css">
	</head>
	<?php
	require_once('middleadmin.php'); ?>
		<div id="container-left">
		<div id="container">
		<h2>Upload Gambar Barang</h2>
		<?php 
		
			$nama=$_GET["nama"];
			echo '
				<form enctype="multipart/form-data" action="uploader.php?nama=',$nama,'" method="POST" name="upload">
					Your Photo: <input type="file" name="photo" size="25" />
					<input type="submit" name="submit" value="Submit" />
				</form>
			';
		?>
		

		</div>
		</div>
	</body>
</html>