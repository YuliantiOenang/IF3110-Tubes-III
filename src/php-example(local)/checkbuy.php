<?php
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
	xmlhttp.open("POST","json-decode.php",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("buy="+localStorage.getItem('shoppingbag')+"&username="+localStorage.getItem('username'));
	var resp;
	xmlhttp.onreadystatechange = function () {
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			alert(xmlhttp.responseText);
			if (xmlhttp.responseText == "Pembelian sukses") {
				localStorage.removeItem('shoppingbag');
				window.location="shopping_bag.php";
			} else if (xmlhttp.responseText == "Belum registrasi credit card") {
				window.location="registrasi_kartu_kredit.php"
			} else {
				window.location="shopping_bag.php";
			}
		}
	}
	alert("Proses Pembelian");
</script>
<?php
?>