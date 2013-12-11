		<?php include('header.php'); ?>		
		<?php $state = $_GET['id']*(-1) - 1; ?>
		<?php include('json-decode.php'); ?>
		<br>
		<?php
			echo '<img src=".'.$decoded[4].'" width="250" height="250">';
			echo '<div class="ex"><center>'.$decoded[1].'<center>';
			echo $decoded[2];
			echo "<br>";
			echo $decoded[3];
			echo '<form action="proses_form.php" method="POST" >
			<br>
			Tambahan Permintaan: <input type="text" name="jumlah" id="request">
			<br>
			Jumlah Pembelian: <input type="text" name="jumlah" id="jumlah">
			<br>
			<span id="status"></span>
			</form>';
			echo '<center><button type="button" onclick="jumlah_check('.$_GET['id'].')">Add To Shooping Bag</button><center></div>';
			echo "<br>";
			echo "<br>";
			echo "<br>";
		?>

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
