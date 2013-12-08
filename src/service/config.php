<?php

//  tobe deleted

header('Pragma: no-cache');
header('Cache-Control: s-maxage=0, max-age=0, must-revalidate, no-cache');

/*** Service Configuration ***/

/** Database Parameter **/

function db_parameter(){
	global $RELEASE; $param = array();
	
	if (getenv("RUKO_RELEASE_VERSION")){
		$env = json_decode(getenv("VCAP_SERVICES"), true);
		$mysqls = $env["mysql-5.1"];
		
		foreach($mysqls as $mysql){
			if ($mysql["name"] == "rukoonline"){
				$param["host"] = $mysql["credentials"]["host"];
				$param["name"] = $mysql["credentials"]["name"];
				$param["user"] = $mysql["credentials"]["username"];
				$param["pass"] = $mysql["credentials"]["password"];
				break;
			}
		}
		
	}else{
		$param["host"] = "localhost";
		$param["name"] = "wbd3";
		$param["user"] = "root";
		$param["pass"] = "";
	}
	return $param;
}

function db_connect(){
	$dbparam = db_parameter();
	return new mysqli($dbparam["host"], $dbparam["user"], $dbparam["pass"], $dbparam["name"]);
}

?>