<?php require_once "config.php"; ?>

<html>
<head>

<script src="js/rest_ajax.js"></script>

<script>
	function send(){
		
		
	}
	
	function onfilechange(){
		callback = function(result){
			document.getElementById("display").src = result;
		}
	
		loadBase64Image('imgfile', callback);
	}
</script>
</head>

<body>
	<img id="display" />
	<input type="file" id="imgfile" onchange="onfilechange()" />
	<button type="button" onclick="send()">test</button>
</body>
</html>