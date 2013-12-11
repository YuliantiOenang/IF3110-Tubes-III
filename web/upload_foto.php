<?php
	$allowedExts = array("gif", "jpeg", "jpg", "png");
	$temp = explode(".", $_FILES["file"]["name"]);
	$extension = end($temp);
	
	if ((($_FILES["file"]["type"] == "image/gif")
	|| ($_FILES["file"]["type"] == "image/jpeg")
	|| ($_FILES["file"]["type"] == "image/jpg")
	|| ($_FILES["file"]["type"] == "image/pjpeg")
	|| ($_FILES["file"]["type"] == "image/x-png")
	|| ($_FILES["file"]["type"] == "image/png"))
	&& ($_FILES["file"]["size"] < 2000000)
	&& in_array($extension, $allowedExts))
	{
		if ($_FILES["file"]["error"] > 0)
		{
			echo "Return Code: " . $_FILES["file"]["error"] . "<br>";
		}
		else
		{
			echo "<center><b>Upload: </b> " . $_FILES["file"]["name"] . "<br><br></center>";
			echo "<center><b>Type: </b>" . $_FILES["file"]["type"] . "<br><br></center>";
			echo "<center><b>Size: </b>" . ($_FILES["file"]["size"] / 1024) . " kB<br><br></center>";
			echo "<center><b>Temp file: </b>" . $_FILES["file"]["tmp_name"] . "<br><br></center>";

			if (file_exists("images/" . $_FILES["file"]["name"]))
			{
				echo "<center><b>" . $_FILES["file"]["name"] . " already exists. " . "</b><br><br></center>";	
				$message2 = "Foto Barang sudah ada, gunakan foto lain!";
				echo "<script type='text/javascript'>alert('$message2');</script>";				
			}
			else
			{
				move_uploaded_file($_FILES["file"]["tmp_name"],
				"images/" . $_FILES["file"]["name"]);
				echo "<center><b>Stored in: " . "images/" . $_FILES["file"]["name"] . "</b><br><br></center>";
				
				$message = "Foto Barang berhasil di upload !";
				echo "<script type='text/javascript'>alert('$message');</script>";
			}
		}
	}
	else
	{
		$message1 = "Invalid file";
		echo "<script type='text/javascript'>alert('$message1');</script>";
	}
	
	echo "<center> <a href=\"tambahfoto.php\">Klik disini</a> untuk kembali ke halaman sebelumnya </center>";	
?>