<!DOCTYPE html>
<html>
	<head>
		<title>RuSerBa Online</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="index.js"></script>
		<script src="calendar.js"></script>
		<link href="calendar.css" rel="stylesheet">
	</head>
	<body>
		<div id="header">
			<?php
				include "header.php";
			?>
		</div>
		<div id="index-page-body">
		<div id="index-body">
		<div id="left-body">
			Makanan:
			<div id=\"user-result\">
				<?php
				$con 	= getConnection();
				$sql	= "SELECT goods_name,goods_sold FROM goods,categorymeetup WHERE cata_ID='cata0001' and categorymeetup.goods_ID=goods.goods_ID ORDER BY goods_sold DESC";
	
				$result = mysql_query($sql);
				
				$count=0;
				while(($row	= mysql_fetch_array($result)) && $count<3){
				echo "<a href=\"detailbarang.php?namabarang=".$row["goods_name"]."&hasil=\"><img id=\"photo\" src=\"../img/goods/".$row["goods_name"].".jpg\" width=\"100\" height=\"120\"/></a>";
				$count=$count+1;
				}
			?>
			</div>
			
			Minuman:
			<div id=\"user-result\">
				<?php
				$con 	= getConnection();
				$sql	= "SELECT goods_name,goods_sold FROM goods,categorymeetup WHERE cata_ID='cata0002' and categorymeetup.goods_ID=goods.goods_ID ORDER BY goods_sold DESC";
	
				$result = mysql_query($sql);
				
				$result = mysql_query($sql);
				$count=0;
				while(($row	= mysql_fetch_array($result)) && $count<3){
				echo "<a href=\"detailbarang.php?namabarang=".$row["goods_name"]."&hasil=\"><img id=\"photo\" src=\"../img/goods/".$row["goods_name"].".jpg\" width=\"100\" height=\"120\"/></a>";
				$count=$count+1;
				}
			?>
			</div>
			
			Perawatan Anak-Anak:
			<div id=\"user-result\">
				<?php
				$con 	= getConnection();
				$sql	= "SELECT goods_name,goods_sold FROM goods,categorymeetup WHERE cata_ID='cata0003' and categorymeetup.goods_ID=goods.goods_ID ORDER BY goods_sold DESC";
	
				$result = mysql_query($sql);
				
				$result = mysql_query($sql);
				$count=0;
				while(($row	= mysql_fetch_array($result)) && $count<3){
				echo "<a href=\"detailbarang.php?namabarang=".$row["goods_name"]."&hasil=\"><img id=\"photo\" src=\"../img/goods/".$row["goods_name"].".jpg\" width=\"100\" height=\"120\"/></a>";
				$count=$count+1;
				}
			?>
			</div>
			
			Perawatan Pribadi:
			<div id=\"user-result\">
				<?php
				$con 	= getConnection();
				$sql	= "SELECT goods_name,goods_sold FROM goods,categorymeetup WHERE cata_ID='cata0004' and categorymeetup.goods_ID=goods.goods_ID ORDER BY goods_sold DESC";
	
				$result = mysql_query($sql);
				
				$result = mysql_query($sql);
				$count=0;
				while(($row	= mysql_fetch_array($result)) && $count<3){
				echo "<a href=\"detailbarang.php?namabarang=".$row["goods_name"]."&hasil=\"><img id=\"photo\" src=\"../img/goods/".$row["goods_name"].".jpg\" width=\"100\" height=\"120\"/></a>";
				$count=$count+1;
				}
			?>
			</div>
			
			Perlengkapan Rumah:
			<div id=\"user-result\">
				<?php
				$con 	= getConnection();
				$sql	= "SELECT goods_name,goods_sold FROM goods,categorymeetup WHERE cata_ID='cata0005' and categorymeetup.goods_ID=goods.goods_ID ORDER BY goods_sold DESC";
	
				$result = mysql_query($sql);
				
				$result = mysql_query($sql);
				$count=0;
				while(($row	= mysql_fetch_array($result)) && $count<3){
				echo "<a href=\"detailbarang.php?namabarang=".$row["goods_name"]."&hasil=\"><img id=\"photo\" src=\"../img/goods/".$row["goods_name"].".jpg\" width=\"100\" height=\"120\"/></a>";
				$count=$count+1;
				}
			?>
			</div>
		</div>
		<div id="right-body">
			Mekanisme Pembelian:</br>
			1.Mendaftar sebagai user.</br>
			2.Login.</br>
			3.Pilih barang yang dibeli serta jumlahnya.</br>
			4.Lihat barang yang dibeli pada cart.</br>
			5.Konfirmasi pembelian dengan mendaftar kartu kredit.</br>
			6.Barang yang anda pesan sudah dibeli dan akan diantar ke alamat anda.</br>
		</div>
		</div>
		</div>
	</body>
</html>
