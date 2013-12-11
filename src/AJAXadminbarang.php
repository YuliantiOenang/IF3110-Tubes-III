<?php
include "koneksi.inc.php";

$sort = $_GET['sort'];
if($sort == null){
	$sort = "nama";
}
$page=($_GET['page']-1)*10;;
if ($page == null){
	$page = 1;
}
if(isset($_GET['kategori'])){ $kategori = $_GET['kategori']; }else{ $kategori=null; }
if ($kategori != null){
	$sql = "select * from barang where kategori = '".$kategori."' order by ".$sort." limit ".$page.", 10";
} else {
	$sql = "select * from barang order by ".$sort." limit ".$page.", 10";
}
$hasil = mysql_query($sql,$koneksi);
while($row = mysql_fetch_array($hasil)){
	echo '<div class="view">';
	echo '<div class="imgattr">';
	echo '<img width="120" height="100" src="'.$row['gambar'].'" />';
	echo '<div class="attribute">';
	echo 'ID : '.$row['id'].'<br>';
	echo $row['nama'].'<br>';
	echo 'Rp '.$row['harga'].'<br>';
	echo 'Jml '.$row['jumlah'].' <a href="editbarang.php?id='.$row['id'].'">Edit</a>';
	echo '</div>';
	echo '</div>';
	echo '<div class="tools">';
	echo '<a href="editbarang.php?id='.$row['id'].'"> <img src=images/Edit.jpg id="edit"></a><br>';
	echo '<input type="checkbox" name='.$row['id'].' id='.$row['id'].'><br>';
	echo '<input type="image" src=images/Delete.png id="delete" onclick="submitdelete2(document.forms[\"check\"],0,\"'.$row['id'].'\")>';
	echo '</div>';
	echo '<div class="description">';
	echo $row['keterangan'];
	echo '</div>';
}
?>