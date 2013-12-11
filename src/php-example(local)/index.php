		<?php include('header.php'); ?>		
		<?php $state = 1; ?>
		<?php include('json-decode.php');?>
		<br>
		Daftar / Login -> pilih barang -> add to shopping bag -> buy all
		<div class="table">
		    <div class="row">
				<?php
					for($i=0; $i<3; $i++){
						echo '<div class="cell tricol">';
						echo 'ALAT TULIS';
						echo "<br>";
						echo '<img src=".'.$decoded[0][$i][4].'" width="250" height="250">';
						echo '<div class="ex"><center><a href="Detail_Barang.php?id='.$decoded[0][$i][0].'">'.$decoded[0][$i][1].'</a><center>';
						echo $decoded[0][$i][2];
						echo "<br>";
						echo $decoded[0][$i][3];
						echo '<form action="proses_form.php" method="POST" >
						Jumlah Pembelian: <input type="text" name="jumlah" id="jumlah">
						<br>
						<span id="status"></span>
						</form>';
						echo '<center><button type="button" onclick="jumlah_check('.$decoded[0][$i][0].')">Add To Shooping Bag</button><center></div>';
						echo "<br>";
						echo "<br>";
						echo "<br>";
						echo '</div>';
					}
				?>
		    </div>
		    <div class="row">
				<?php
					for($i=0; $i<3; $i++){
						echo '<div class="cell tricol">';
						echo 'DAGING';
						echo "<br>";
						echo '<img src=".'.$decoded[1][$i][4].'" width="250" height="250">';
						echo '<div class="ex"><center><a href="Detail_Barang.php?id='.$decoded[1][$i][0].'">'.$decoded[1][$i][1].'</a><center>';
						echo $decoded[1][$i][2];
						echo "<br>";
						echo $decoded[1][$i][3];
						echo '<form action="proses_form.php" method="POST" >
						Jumlah Pembelian: <input type="text" name="jumlah" id="jumlah">
						<br>
						<span id="status"></span>
						</form>';
						echo '<center><button type="button" onclick="jumlah_check('.$decoded[1][$i][0].')">Add To Shooping Bag</button><center></div>';
						echo "<br>";
						echo "<br>";
						echo "<br>";
						echo '</div>';
					}
				?>
		    </div>
		    <div class="row">
				<?php
					for($i=0; $i<3; $i++){
						echo '<div class="cell tricol">';
						echo 'SAYUR';
						echo "<br>";
						echo '<img src=".'.$decoded[2][$i][4].'" width="250" height="250">';
						echo '<div class="ex"><center><a href="Detail_Barang.php?id='.$decoded[2][$i][0].'">'.$decoded[2][$i][1].'</a><center>';
						echo $decoded[2][$i][2];
						echo "<br>";
						echo $decoded[2][$i][3];
						echo '<form action="proses_form.php" method="POST" >
						Jumlah Pembelian: <input type="text" name="jumlah" id="jumlah">
						<br>
						<span id="status"></span>
						</form>';
						echo '<center><button type="button" onclick="jumlah_check('.$decoded[2][$i][0].')">Add To Shooping Bag</button><center></div>';
						echo "<br>";
						echo "<br>";
						echo "<br>";
						echo '</div>';
					}
				?>
		    </div>
		    <div class="row">
				<?php
					for($i=0; $i<3; $i++){
						echo '<div class="cell tricol">';
						echo 'BUAH';
						echo "<br>";
						echo '<img src=".'.$decoded[3][$i][4].'" width="250" height="250">';
						echo '<div class="ex"><center><a href="Detail_Barang.php?id='.$decoded[3][$i][0].'">'.$decoded[3][$i][1].'</a><center>';
						echo $decoded[3][$i][2];
						echo "<br>";
						echo $decoded[3][$i][3];
						echo '<form action="proses_form.php" method="POST" >
						Jumlah Pembelian: <input type="text" name="jumlah" id="jumlah">
						<br>
						<span id="status"></span>
						</form>';
						echo '<center><button type="button" onclick="jumlah_check('.$decoded[3][$i][0].')">Add To Shooping Bag</button><center></div>';
						echo "<br>";
						echo "<br>";
						echo "<br>";
						echo '</div>';
					}
				?>
		    </div>
		    <div class="row">
				<?php
					for($i=0; $i<3; $i++){
						echo '<div class="cell tricol">';
						echo 'PAKAIAN';
						echo "<br>";
						echo '<img src=".'.$decoded[4][$i][4].'" width="250" height="250">';
						echo '<div class="ex"><center><a href="Detail_Barang.php?id='.$decoded[4][$i][0].'">'.$decoded[4][$i][1].'</a><center>';
						echo $decoded[4][$i][2];
						echo "<br>";
						echo $decoded[4][$i][3];
						echo '<form action="proses_form.php" method="POST" >
						Jumlah Pembelian: <input type="text" name="jumlah" id="jumlah">
						<br>
						<span id="status"></span>
						</form>';
						echo '<center><button type="button" onclick="jumlah_check('.$decoded[4][$i][0].')">Add To Shooping Bag</button><center></div>';
						echo "<br>";
						echo "<br>";
						echo "<br>";
						echo '</div>';
					}
				?>
		    </div>
		</div>		
				
		<script type="text/javascript">
			var xmlhttp;
			if (window.XMLHttpRequest)
  			{// code for IE7+, Firefox, Chrome, Opera, Safari
  				xmlhttp=new XMLHttpRequest();
  			}
			else
  			{// code for IE6, IE5
  				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  			}
  			function jumlah_check (id) {
  				var jumlah = document.getElementById('jumlah').value;
  				xmlhttp.open("POST","json-decode.php",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send("id="+id);
				xmlhttp.onreadystatechange = function () {
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
					{
						if (parseInt(xmlhttp.responseText) >= parseInt(jumlah)) {
							var bag;
							if (localStorage.shoppingbag) {
								var getShoppingBag = localStorage.getItem('shoppingbag');
								bag = JSON.parse(getShoppingBag);
							} else {
								bag={};	
							}
							if (bag[id]===undefined)
								bag[id]=0;
							bag[id]=parseInt(bag[id])+parseInt(jumlah);
							localStorage.setItem('shoppingbag', JSON.stringify(bag))
						} else {
		
							document.getElementById("status").innerHTML='<font color="red">Jumlah tersisa ='+xmlhttp.responseText+' </font>';
						}
					}
				}
			}
		</script>
	</body>
</html>
