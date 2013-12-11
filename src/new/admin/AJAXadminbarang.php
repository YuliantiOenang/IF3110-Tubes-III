<?php
$con=mysqli_connect("localhost","root","","ruserba");
// Check connection
if (mysqli_connect_errno()) {
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
//Query from database
		if($_GET['sort'] != null){
			$sort = $_GET['sort'];
		} else 
			$sort = "nama";
			
		if ($_GET['page'] != null){
			$page = ($_GET['page']-1)*10;
		} else {
			$page = 0;
		}

		if ($_GET['kategori']){
			$kategori = $_GET['kategori'];
			$sql = "SELECT * FROM barang WHERE kategori = '"$_GET['kategori']"' order by " + $sort+ " limit "+$page+", 10";
		} else {
			$kategori = null;
			$sql = "SELECT * FROM barang order by "+ $sort +" limit " +$page+ ", 10";
		}
		
		<div class='view'>
		        	<div class='imgattr'>
					<img src="+$_GET{'gambar']+" width='120' height=100'/>
					<div class='attribute'>
						ID : +$_GET['id'] + <br>
						$_GET['nama'] + <br>
						Rp +$_GET['harga']+<br>
						Jml +$_GET['jumlah']
						</div>
					</div>
					<div class='tools'>
						<input type='checkbox' name= +$_GET['id']+ id= + $_GET['id']><br> 
						<a href='editbarang.php?id=+$_GET['id']'>
							+ <img src=images/Edit.jpg id='edit'></a>"+"<br>
						<input type='image' src=images/Delete.png id='delete' onclick='submitdelete2(document.forms[\"check\"],0,\""+$_GET['id']+"\")'>
						</div>
					<div class='description'>
						$_GET['keterangan']
					</div>
				</div>
?>