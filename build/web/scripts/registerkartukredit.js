//add_task javascript
var chkusername = false;
var chkpassword1 = false;
var chkpassword2 = false;
var chkemail = false;
var chknama = false;
var chkHP = false;
var chkpos = false;
var chklengkap = false;

var iskonkat = false;
var konkat = "";


function check_string() {
	var i;
	var str = document.getElementById("taskname").value;
	for (i = 0; i < str.length; i++) {
		if ((str.charAt(i) != ' ' && str.charCodeAt(i) < 48) || (str.charCodeAt(i) > 57 && str.charCodeAt(i) < 65) || (str.charCodeAt(i) > 90 && str.charCodeAt(i) < 97) || str.charCodeAt(i) > 122) {
			return false;
		}
	}
	return true;
}

function is_only_number(str){
	var i;
	for (i = 0; i < str.length; i++) {
		if ((str.charCodeAt(i) < 48) || (str.charCodeAt(i) > 57)) {
			return false;
		}
	}
	return true;
}

function is_only_character(str){
	var i;
	for (i = 0; i < str.length; i++) {
		if ((str.charAt(i) != ' ' && str.charCodeAt(i) < 48) || (str.charCodeAt(i) > 57 && str.charCodeAt(i) < 65) || (str.charCodeAt(i) > 90 && str.charCodeAt(i) < 97) || str.charCodeAt(i) > 122) {
			return false;
		}
	}
	return true;
}