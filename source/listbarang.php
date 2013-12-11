<?php
	if(isset($_SESSION['admin'])){
	include('admin.php');
}
?>
		<article class="lifted_content_box">
		<?php
		$kategori = $_GET['kategori'];
		echo "<h1>".$kategori."</h1>";
		?>
		<div id="itemcontent">
		<?php
			$sql = "SELECT * FROM barang WHERE kategori='".$kategori."'";
			$result = pg_query($sql,$conn);
			if($result === FALSE) {
				die(pg_error()); // TODO: better error handling
			}
			$i=1;			
			while($row = pg_fetch_array($result)){
				$link[$i] = "images/".$row['kategori']."/".$row['gambar_barang'];			
				$nama_barang[$i]= $row['nama_barang'];		
				//echo "<br>".$link[];
				$i++;
			}
			
			$j=1;
			echo "<table border='0' width='200' align='center'>";
			while($j<$i){
				if($j%4==1){
					echo "<tr>";
				}
				echo "<td align='center'>
				<a href='index.php?page=barang&nama=".$nama_barang[$j]."'>
				<img src='".$link[$j]."' width='200' height='200'/><br>
				</a>
				<input type='checkbox' name='namabarang' value='".$nama_barang[$j]."'>
				<a href='index.php?page=barang&nama=".$nama_barang[$j]."'>".$nama_barang[$j]."
				</a>
				</td>";
				if($j%4==0){
					echo "</tr>";
				}
				$j++;
			}
			echo "</table>";
		?>
		
		</div>
		</article>
