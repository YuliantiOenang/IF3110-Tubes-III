<?php
include "koneksi.inc.php";
$query3 = "select * from barang group by kategori";
$hasil3 = mysql_query($query3,$koneksi);
$slideid = 0;
while($row3 = mysql_fetch_array($hasil3)){
	$rank=1;
	$query4 = "select * from barang where kategori='".$row3["kategori"]."' order by terjual desc limit 0,3";
	$hasil4 = mysql_query($query4,$koneksi);
	while($row4 = mysql_fetch_array($hasil4)){
	$slideid++;
	?>
		<li id ="slide-<?php echo $slideid; ?>">
			<img src="http://localhost:8081/tubeswbd3/<?php echo $row4['gambar']; ?>"/>
			<div class="description">
				<input type="checkbox" id="show-description-<?php echo $slideid; ?>"/>
                      <label for="show-description-<?php echo $slideid; ?>" class="show-description-label">
					<?php echo $row3["kategori"]." #".$rank; ?>
				</label>
                      <div class="description-text">
                          <a href="detailbarang.php?id=<?php echo $row4['id']; ?>"><?php echo $row4['nama']; ?></a>
                          <p><?php echo $row4['keterangan']; ?></p>
                      </div>
			</div>
		</li>
	<?php 
	$rank++;
	}
}
?>