<?php
//session_start();
	include('conn.php');
	
	if(isset($_POST['efullname']) && isset($_POST['enohp']) && isset($_POST['ealamat'])&& isset($_POST['eprovinsi']) && isset($_POST['ekabupaten']) && isset($_POST['ekodepos'])){
		pg_query("UPDATE anggota SET fullname= '$_POST[efullname]', nohp='$_POST[enohp]', alamat='$_POST[ealamat]', kabupaten='$_POST[ekabupaten]', provinsi='$_POST[eprovinsi]', kodepos='$_POST[ekodepos]' , password='$_POST[epwd1]' WHERE userid = '".$_SESSION['userid']."'");
?>
<article class="lifted_content_box">
		<h1>Edit Profil</h1>
		<div id="itemcontent">	
<?php
		echo "SUKSES EDIT!";
		$query = pg_query("SELECT * FROM anggota where userid = '".$_SESSION['userid']."'");
				$row = pg_fetch_array($query);	
				echo "<form action='index.php'  method='post'>";
				echo "<table border=0>";
					echo "<tr><td>Username</td><td>: ".$row['userid']."</td></tr>";
					echo "<tr><td>Nama Lengkap</td><td>: ". $row['fullname']."</td></tr>";
					echo "<tr><td>Nomor Handphone</td><td>: ".$row['nohp']."</td></tr>";
					echo "<tr><td>Alamat</td><td>: ".$row['alamat']."</td></tr>";
					echo "<tr><td>Provinsi</td><td>: ".$row['provinsi']."</td></tr>";
					echo "<tr><td>Kabupaten/Kota</td><td>: ".$row['kabupaten']."</td></tr>";
					echo "<tr><td>Kode Pos</td><td>: ".$row['kodepos']."</td></tr>";
					echo "<tr><td>E-mail</td><td>: ".$row['email']."</td></tr>";
				echo "</table>";
				echo "</form>";
	}
	else{
		echo "belum berhasil";
	}
?>
</div>
</article>