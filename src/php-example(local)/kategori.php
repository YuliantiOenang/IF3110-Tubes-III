		<?php include('header.php'); ?>
		<?php $state = $_GET['id']; ?>
		<?php include('json-decode.php'); ?>
		<div id="apa">
			<br>
			<script>
				function gantiUrutan(){
					var a = document.getElementById("comboA").value;
					var b = document.getElementById("comboB").value;
					window.location.href = "sayur.php?sort=" + a + "&order=" + b;
				}
				
			</script>
						
			<?php
				echo '<p> Urut Berdasarkan : 
					<select id="comboA">
						<option value="name">nama</option>
						<option value="price">harga</option>
					</select>
					<select id="comboB">
						<option value="Asc">Asc</option>
						<option value="Desc">Desc</option>
					</select>
					<button type="button" onclick="gantiUrutan()">Ok</button><br><br><p>';
				for($i=0; $i<10&&$i<sizeof($decoded); $i++){
					echo '<img src=".'.$decoded[$i][3].'" width="250" height="250">';
					echo '<div class="ex"><center><a href="Detail_Barang.php?id='.$decoded[$i][0].'">'.$decoded[$i][1].'</a><center>';
					echo $decoded[$i][2];
					echo '<form action="proses_form.php" method="POST" >
					Jumlah Pembelian: <input type="text" name="jumlah" id="jumlah">
					<br>
					<span id="status"></span>
					</form>';
					echo '<center><button type="button" onclick="jumlah_check('.$decoded[$i][0].')">Add To Shooping Bag</button><center></div>';
					echo "<br>";
					echo "<br>";
					echo "<br>";
				}
			?>
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
		<script>
			 var nama_barang = [];
			 var image = [];
			 var harga = [];
			 var id = [];
			 var b;
			 
			 <?php
				for ($i=0; $i < sizeof($decoded); $i++){
					echo "image[".$i."] = '".$decoded[$i][3]."';\n";
					echo "nama_barang[".$i."] ='".$decoded[$i][1]."';\n";
					echo "harga[".$i."] = '".$decoded[$i][2]."';\n";
					echo "id[".$i."] = '".$decoded[$i][0]."';\n";
				}
				echo "b = '".sizeof($decoded)."';\n";
			 ?>
				
				var page = 1;
				
				document.addEventListener('scroll', function (event) {
				if (document.body.scrollHeight == 
				document.body.scrollTop +        
				window.innerHeight) {
					
					var apa = document.getElementById("apa");
					for(var i = page*10; (i < page*10+10 && i < b); i++){
						var s = ""
						s += '<img src="'+image[i]+'" width="250" height="250">'+"<br/>";
						s += '<div class="ex"><center><a href="Detail_Barang.php?id='+id[i]+'">'+nama_barang[i]+'</a><center>';
						s += harga[i]+"<br/>";
						s += 	'<form action="proses_form.php" method="POST" >';
						s +=	'Jumlah Pembelian: <input type="text" name="jumlah" id="jumlah">'+ "<br/>";
						s +=	'<span id="status"></span>';
						s += 	'</form>';
						s += '<center><button type="button" onclick="jumlah_check('+id[i]+')">Add To Shooping Bag</button><center></div>'+ "<br/>"+ "<br/>"+ "<br/>";
						apa.innerHTML += s;
					}
						
					page++;
				}
			});
		</script>
	</body>
</html>
