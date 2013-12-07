<?php require_once "config.php"; 

require_once "lib/rest_request.php";

$data["text"] = "hello";
$data["number"] = 1234;

$res = sendRestRequest("PUT", "test/res1/res2", $data);

print_r($res);

/*
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
*/
?>