<?php 
if(isset($_GET['cari'])){ $cari = $_GET['cari']; }
if(isset($_GET['suggest'])){ $suggest = $_GET['suggest']; }
if(isset($_GET['page'])){ $page=($_GET['page']-1)*10; }else{ $page=0; }
include "koneksi.inc.php";
$query = "select * from barang order by kategori";
$hasil = mysql_query($query,$koneksi);
$p = -1;
$a = array();
while($row = mysql_fetch_array($hasil)){
	$p++;
    $a[$p] = array($row["id"],$row["nama"],$row["gambar"],$row["kategori"],$row["harga"]);
}
if (strlen($cari) > 0){
	if($suggest=="true"){
		$hint="";
		$acc =-1;
		$kat="";
		$inc=0;
		for($i=0; $i<count($a); $i++)
		{
			if (strtolower($cari)==strtolower(substr($a[$i][1],0,strlen($cari))) || strtolower($cari)==strtolower(substr($a[$i][3],0,strlen($cari)))
				|| strtolower($cari)==$a[$i][4])
			{
				$acc++;
				if($kat!=$a[$i][3]){ $hint = $hint."<li><a style='background:grey;color:white' href='halamanbarang.php?kategori=".$a[$i][3]."'>".$a[$i][3]."</a></li>"; $kat=$a[$i][3]; }
				$temp = '<li><a href="detailbarang.php?id='.$a[$i][0].'">'.$a[$i][1].'</a></li>';
				$hint=$hint.$temp;
			}
		}
		echo $hint;
	}else{
		$query2 = "select * from barang limit $page,10";
		$hasil2 = mysql_query($query2,$koneksi);
		while($row = mysql_fetch_array($hasil2)){
			echo '<div class="view">';
			echo '<img src="'.$row["gambar"].'" width="318" height="238"/>';
			echo '<div class="mask">';
			echo '<h2><a href="detailbarang.php?id='.$row["id"].'">'.$row["nama"].'</a></h2>';
			echo '<p>Harga: '.$row["harga"].'</p>';
			echo '<form action="shoppingbag.php" method="GET">Masukkan jumlah yang akan dibeli: ';
			echo '<input type="number" name="quantity" min="0" id="qty"><input type="button" value="Beli!" id="buy" onclick="tempBuy('.$row["id"].',qty.value)"></form>';
			echo '</div></div>';
		}
	}
}	
?>