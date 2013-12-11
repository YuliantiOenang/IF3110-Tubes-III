<?php //if they DID upload a file...

$nama=$_GET["nama"];
if($_FILES['photo']['name'])
{

	$message="";
	//if no errors...
	if(!$_FILES['photo']['error'])
	{
		//now is the time to modify the future file name and validate the file
		$new_file_name = strtolower($_FILES['photo']['tmp_name']); //rename file
		$valid_file = true;
		if($_FILES['photo']['size'] > (1024000)) //can't be larger than 1 MB
		{
			$valid_file = false;
			
			echo '<script type="text/javascript"> 
			alert("Oops!  Your file\'s size is to large"); 
			history.back();
			window.location = "uploadadmin.php";
			</script>';
		}
		
		//if the file has passed the test
		if($valid_file)
		{
			//move it to where we want it to be
			move_uploaded_file($_FILES['photo']['tmp_name'], 'images/'.$nama.'.jpg');
			echo '<script type="text/javascript"> 
			alert("Congratulations!  Your file was accepted."); 
			history.back();
			window.location = "indexadmin.php";
			</script>';
		}
	
	}
	//if there is an error...
	else
	{
		echo '<script type="text/javascript"> 
		alert("error to upload photo"); 
		history.back();
		window.location = "ubahadmin.php";
		</script>';
	}
	
	
}

?>