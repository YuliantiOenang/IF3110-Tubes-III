<?php
	if(isset($_SESSION['admin'])){
	include('admin.php');
}
?>
	
	<article class="lifted_content_box">
		<h1>Pembelian Terbanyak</h1>
		<div id="itemcontent">
			<table border="0" width="100" align="center">
		<tr>
			<td align="center"> <b> Sembako </b> </td>
			<td align="center"> <b> Daging </b> </td>
			<td align="center"> <b> Snack </b> </td>
			<td align="center"> <b> Minuman </b> </td>
			<td align="center"> <b> Sayur </b> </td>
			<td align="center"> <b> Buah </b> </td>
			<td align="center"> <b> Bumbu Dapur </b> </td>
			<td align="center"> <b> Sabun </b> </td>
		</tr>
		<tr>
			<td>
				<a href="index.php">
				<img src="images/sembako/mie.jpg" alt="mie" width="100"/></a>
			</td>
			<td>
				<a href="index.php">
				<img src="images/daging/ayam.jpg" alt="ayam" width="100"/></a>
			</td>
			<td>
				<a href="index.php">
				<img src="images/Snack/biskuit/Biskuit Selamat.jpg" alt="Biskuit Selamat" width="100"/></a>
			</td>
			<td>
				<a href="index.php">
				<img src="images/Minuman/sari buah/buavita jeruk.jpg" alt="buavita jeruk" width="100"/></a>
			</td>
			<td>
				<a href="index.php">
				<img src="images/Sayur/bayam.png" alt="bayam" width="100"/></a>
			</td>
			<td>
				<a href="index.php">
				<img src="images/Buah/melon.png" alt="melon" width="100"/></a>
			</td>
			<td>
				<a href="index.php">
				<img src="images/Bumbu Dapur/FA_0016-Bawang-Merah-150x150.jpg" alt="bawang merah" width="100"/></a>
			</td>
			<td>
				<a href="index.php">
				<img src="images/Sabun/sabun mandi/Lifebuoy Bw Activefresh.jpg" alt="Lifebuoy Bw Activefresh" width="100"/></a>
			</td>
		</tr>
		</table>
		</div>
		</article>
		<article class="lifted_content_box">
		<br>
		<h1>Prosedur Belanja</h1>
		<div id="itemcontent">
		 <!--<h3 class="judul">Prosedur Belanja</h3>!>
		<!--echo "<marquee behavior='slide' direction='left'> <img src='images/Logo.png'> <img src='images/shoppingbag.png'> </marquee>";!-->
		<img class="linkprocedure" id = pic border=0 src="images/prosedure1.jpg"></br>
		<div id="linkprosedur">
		<a class="linkprocedure" style="border-left: 1px solid #666" onclick="start()">Start</a>
		<a class="linkprocedure" onclick="slideshow()">Next</a>
		<a class="linkprocedure" onclick="prev()">Prev</a>
		<a class="linkprocedure" onclick="end()">End</a>		
		</div>
		</div>
</article>