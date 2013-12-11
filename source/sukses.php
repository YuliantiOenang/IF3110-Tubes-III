<?php
session_start();
	include('conn.php');
	//INSERT NEW MEMBER INTO DATABASE
	if(isset($_POST['userid']) && isset($_POST['fullname']) && isset($_POST['email']) && isset($_POST['nohp']) && isset($_POST['alamat'])&& isset($_POST['provinsi']) && isset($_POST['kabupaten']) && isset($_POST['kodepos'])){
		pg_query ("INSERT INTO anggota (userid, fullname, nohp, email, alamat, kabupaten, provinsi, kodepos, password ) VALUES (' $_POST[userid]', '$_POST[fullname]', '$_POST[nohp]', '$_POST[email]', '$_POST[alamat]', '$_POST[kabupaten]', '$_POST[provinsi]', '$_POST[kodepos]', '$_POST[pwd1]' )");
		$_SESSION['userid'] = $_POST['userid'];
		$_SESSION['password'] = $_POST['pwd1'];
		$_SESSION['fullname'] = $_POST['fullname'];
		$_SESSION['email'] = $_POST['email'];
		//echo "bisa!";
		header('Location: index.php'); 
	}
	//LOGIN
	else if(isset($_POST['userid']) && $_POST['password']){
		$_SESSION['userid'] = $_POST['userid'];
		$_SESSION['password'] = $_POST['password'];
		
		$sql = "SELECT * FROM anggota WHERE userid='" . $_SESSION['userid'] ."' AND Password = '". $_SESSION['password'] ."'";
		$result = pg_query($sql);
		$row = pg_num_rows($result);
		if ($row == 0)
		{
			echo "Login Fail";
			session_unset();
			echo "<meta http-equiv=\"refresh\"
			content=\"3; URL = index.php\">";
		}
		else{
			//echo "sukses";
			
			if($_SESSION['userid'] == "kharisma" || $_SESSION['userid'] == "isabel"){
				$_SESSION['admin'] = "admin";
				header('Location: index.php'); 	
			}
			else{
				$_SESSION['buyer'] = "buyer";
				header('Location: index.php');
			}
		}
	}
	//KARTU KREDIT
	else if(isset($_POST['nokartu']) && $_POST['namakartu'] && $_POST[tglkadaluwarsa]){
		pg_query ("INSERT INTO kartukredit (nokartu, namakartu, tglkadaluwarsa, userid) VALUES ('$_POST[nokartu]', '$_POST[namakartu]', '$_POST[tglkadaluwarsa]', '$_SESSION[userid]')");
		//echo htmlspecialchars($_SESSION[userid]);
		$_SESSION['nokartu'] = $_POST['nokartu'];
		$_SESSION['namakartu'] = $_POST['namakartu'];
		$un = $_SESSION['userid'];
		//echo "sukses kartu kredit";
		header('Location: index.php'); 
	}
	else{
		echo "belum berhasil";
	}
	//Close specified connection
	//pg_close($conn);
?>