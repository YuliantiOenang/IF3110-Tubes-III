<?php

/*** Service Configuration ***/

/** Database Parameter **/

function db_parameter(){
	$RELEASE = false; $param = array();
	
	if ($RELEASE){
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
		$param["host"] = "localhost"; // to be changed
		$param["name"] = "wbd3";
		$param["user"] = "root"; // to be changed
		$param["pass"] = "root"; // to be changed
	}
	return $param;
}

function db_connect(){
	$dbparam = db_parameter();
	return new mysqli($dbparam["host"], $dbparam["user"], $dbparam["pass"], $dbparam["name"]);
}

?>