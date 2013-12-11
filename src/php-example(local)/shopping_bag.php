		<?php include('header.php'); ?>		

		<?php
			include('database_connection.php'); 
			$result1 = mysql_query("select * from catalog_product where category = 'beras'");
			$result1a = mysql_query("select path from catalog_product where category = 'beras'");
			while ($row = mysql_fetch_array($result1)) {
			    $new_array1[] = $row;
			}
			while ($row1 = mysql_fetch_array($result1a)) {
			    $new_array1a[] = $row1;
			}
			mysql_close($link);// close mysql then do other job with set_time_limit(59)
		?>

		<div class="table" onLoad="load()">
		    <div class="row">
				<div id="cell" onLoad="load()">
				</div>
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
							document.getElementById("status").innerHTML='<font color="Green"> jumlah tersedia </font>';
						} else {
		
							document.getElementById("status").innerHTML='<font color="red">Jumlah tersisa ='+xmlhttp.responseText+' </font>';
						}
					}
				}
			}
				var username=localStorage.getItem('username');
				if (localStorage.shoppingbag) {
					var getShoppingBag=localStorage.getItem('shoppingbag');
					xmlhttp.open("POST","json-decode.php",true);
					xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xmlhttp.send("bag="+getShoppingBag);
					xmlhttp.onreadystatechange = function () {
					if (xmlhttp.readyState==4 && xmlhttp.status==200)
						{
							document.getElementById("cell").innerHTML=xmlhttp.responseText;
						}
					}
				} else {
					document.getElementById("cell").innerHTML="Tidak ada barang pada shopping bag Anda";
				}
		</script>
	</body>
</html>
