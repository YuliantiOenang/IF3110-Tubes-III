<?php require_once "config.php"; ?>

<html>
<head>

<script src="js/rest_ajax.js"></script>

<script>
	function send(){
		
		callback = function(result){
			document.getElementById("display").src = result;
			cb = function(res){alert(JSON.stringify(res));};
			
			sendRestAjax("PUT", "image", {"imgdata" : result}, cb);
		}
	
		loadBase64Image('imgfile', callback);
	}
</script>
</head>

<body>
	<img id="display" />
	<input type="file" id="imgfile" />
	<button type="button" onclick="send()">test</button>
</body>
</html>