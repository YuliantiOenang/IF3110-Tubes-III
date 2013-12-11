		<?php include('header.php'); ?>
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
			var username = localStorage.username;
			function setAll() {
				xmlhttp.open("POST","json-decode.php",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send("username="+username);

				xmlhttp.onreadystatechange = function () {
					if (xmlhttp.readyState==4 && xmlhttp.status==200)
					{
						document.getElementById("content").innerHTML=xmlhttp.responseText;
					}
				}
			}
		</script>
		<script type="text/javascript">
			setAll();
		</script>
		<div id="content">
		</div>
	</body>
</html>