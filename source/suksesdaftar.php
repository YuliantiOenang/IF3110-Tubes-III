<article class="lifted_content_box">
		<h1>Pendaftaran </h1>
		<div id="itemcontent">
			<p>
			<?php 
				include('conn.php');
				//INSERT NEW MEMBER INTO DATABASE
				pg_query("INSERT INTO anggota (username, fullname, nohp, email, alamat, kabupaten, provinsi, kodepos, password ) VALUES (' $_POST[username]', '$_POST[fullname]', '$_POST[nohp]', '$_POST[email]', '$_POST[alamat]', '$_POST[kabupaten]', '$_POST[provinsi]', '$_POST[kodepos]', '$_POST[password]' )");
				//TO SHOW THE NAME OF THE PATIENT
				

			?>
				<table border=0>
					<tr><td>Username</td><td>: <?php print $_POST['username']; ?></td></tr>
					<tr><td>Nama Lengkap</td><td>: <?php print $_POST['fullname']; ?></td></tr>
					<tr><td>Nomor Handphone</td><td>: <?php print $_POST['nohp']; ?></td></tr>
					<tr><td>Alamat</td><td>: <?php print  $_POST['alamat']; ?></td></tr>
					<tr><td>Provinsi</td><td>: <?php print  $_POST['provinsi']; ?></td></tr>
					<tr><td>Kabupaten/Kota</td><td>: <?php print  $_POST['kabupaten']; ?></td></tr>
					<tr><td>Kode Pos</td><td>: <?php print  $_POST['kodepos']; ?></td></tr>
					<tr><td>E-mail</td><td>: <?php print  $_POST['email']; ?></td></tr>
				</table>
				<?php
					//Close specified connection
					pg_close($conn);
				?>
			</p>
		</div>
</article>