<?php 
				include('conn.php');
				//where username='".$_SESSION['userid']."'"
				if(isset($_SESSION['userid'])){
?>				
<article class="lifted_content_box">
		<h1>Profil </h1>
		<div id="itemcontent">
			<p>
<?php			//echo $_SESSION['userid'];
				$un = $_SESSION["userid"];
				$query = mysql_query("SELECT * FROM anggota where userid = '".$_SESSION['userid']."'");
				$row = mysql_fetch_array($query);
				$_SESSION['efullname']= $row['fullname'];
				$_SESSION['enohp']= $row['nohp'];
				$_SESSION['ealamat']= $row['alamat'];
				$_SESSION['eprovinsi']= $row['provinsi'];
				$_SESSION['ekabupaten']= $row['kabupaten'];
				$_SESSION['ekodepos']= $row['kodepos'];
				$_SESSION['epassword']= $row['password'];
			
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
					echo "<tr><td></td><td><input class='btn-edit' type='submit' value='Edit Profil' name='btn-edit' /></td></tr>";
				echo "</table>";
				echo "</form>";
					mysql_close($conn);
				?>
			</p>
		</div>
</article>
<?php
				}else{
					include("index.php");
				}
?>