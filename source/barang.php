<?php
	$nama = $_GET['nama'];
	$sql = "SELECT * FROM barang WHERE nama_barang= '" . $nama."'";
	$result = pg_query($sql,$conn);
	if($result === FALSE) {
		die(pg_error()); // TODO: better error handling
	}
	$row = pg_fetch_array($result);
	$link = "images/".$row['kategori']."/".$row['gambar_barang'];
	$harga = $row['harga_barang'];
	$stok = $row['stok_barang'];
?>
<div id="transaksi">
	<table border=1 align="center" width="100%" style="border-spacing: 1px">
		<tr align="center">
			<th colspan="3" style="font-size:50px; border-width:2px; background-color:green; color: #9ACD32"> 
				<?php echo $row['kategori']?>
			</th>
		</tr>
		<tr align="center">
		
			<td rowspan="2" width='400px' heigth='400px' style="border-width: 0px">
				<img src=<?php echo $link?> width='350px' heigth='350px'>
			</td>
			
			<td style="border-width: 0px">
				Jumlah
					<input type="text" value="1" size="2" id="count" name="count" disabled="disabled">
					<input type="button" value="+" id="plus">
					<input type="button" value="-" id="minus">
			</td>
			
			<td style="border-width: 0px">
				Total : <input type="text" value="<?php echo $harga ?>" size="6" id="total" disabled="disabled" name="total">
			<td>
	  </tr>
	  <tr align="center">
		<td colspan="2" style="border-width: 0px">
			Keterangan Tambahan<textarea  id="keterangan" rows="10" cols="70" ></textarea>
		</td>
	  </tr>
	  <tr align="center">
		<td style="color: green;font-size:20px"> 
			<?php echo $nama ?>
			<br><?php echo "Rp ".$harga ?>
		</td>
		<td></td>
		<td style="border-width: 0px"> 
			<input type="button" 
					value="ADD" 
					style="height:40px; 
							width:80px; 
							font-family:'Monotype Corsiva'; 
							font-size:30px;
							color: #FFF; 
							background-color: #9ACD32" 
					onClick="parent.location='index.php?page=cart&action=add&nama=<?php echo $nama ?>'"
					> 
			
		</td>
	  </tr>
	</table>

	<input type="radio" id="jumlah" value="<?php echo $stok ?>">
</div>

<script>
(function() {

    var minusButton = document.getElementById("minus");
    var plusButton  = document.getElementById("plus");
    var addButton  = document.getElementById("add");
    var countBox    = document.getElementById("count");
	var totalhrg    = document.getElementById("total");
	var jumlah    = document.getElementById("jumlah");
	
	var count = countBox.value;
	var harga = totalhrg.value;
	var stok = jumlah.value;

    minusButton.onclick = function(e) {
		if (count>1)
        countBox.value = --count;
		totalhrg.value = count*harga;
	
    };

    plusButton.onclick = function(e) {
		if (count<stok)
        countBox.value = ++count;
		totalhrg.value = count*harga;
    };
	
})();
</script>