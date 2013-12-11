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

function hide_create_button() {
	document.getElementById("create").style.display = 'none';
}

function show_create_button() {
		document.getElementById("create").style.display = 'block';
}

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

function check_task_name() {
	if (document.getElementById("taskname").value.length > 0 && document.getElementById("taskname").value.length < 26) {
		chktaskname = check_string();
		if (chktaskname == true) {
			document.getElementById("warning-message").innerHTML="";			
		} else {
			document.getElementById("warning-message").innerHTML="Task name contains special characters";
		}
	} else {
		chktaskname = false;
		document.getElementById("warning-message").innerHTML="Task name is not valid";
	}
}

function check_user_name() {
	var str = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if(str!=""){
		if(str.length>4){
			if(str!=password){
			chkusername=true;
			document.getElementById("warning-message").innerHTML="";
			}else{
				chkusername=false;
				hide_create_button();
				document.getElementById("warning-message").innerHTML="Username Tidak Boleh Sama Dengan Password";
			}
		}
		else{
			chkusername=false;
			hide_create_button();
			document.getElementById("warning-message").innerHTML="Username minimal 5 karakter";
		}
	}
}

function check_password() {
	var str = document.getElementById("password").value;
	if(str!=""){
		if(str.length>=8){
			chkpassword1=true;
			document.getElementById("warning-message").innerHTML="";
			
		}
		else{
			chkpassword1=false;
			hide_create_button();
			document.getElementById("warning-message").innerHTML="Password minimal 8 karakter";
		}
	}
}

function check_HP() {
	var str = document.getElementById("HP").value;
	if(str!=""){
		if(is_only_number(str)){
			chkHP=true;
			document.getElementById("warning-message").innerHTML="";
			
		}
		else{
			chkHP=false;
			hide_create_button();
			document.getElementById("warning-message").innerHTML="Nomor Telepon Harus Angka";
		}
	}
}

function check_pos() {
	var str = document.getElementById("pos").value;
	if(str!=""){
		if(is_only_number(str)){
			chkpos=true;
			document.getElementById("warning-message").innerHTML="";
			
		}
		else{
			chkpos=false;
			hide_create_button();
			document.getElementById("warning-message").innerHTML="Kode Pos Harus Angka";
		}
	}
}

function check_lengkap() {
	var str = document.getElementById("alamat").value;
	var str2 = document.getElementById("provinsi").value;
	var str3 = document.getElementById("kabupaten").value;
	if(str!="" && str2!="" && str3!=""){
		show_create_button();
		document.getElementById("warning-message").innerHTML="";
	}
	else
	{
		hide_create_button();
		document.getElementById("warning-message").innerHTML="Isi seluruh Form";
	}
}

function check_nama() {
	var str = document.getElementById("namalengkap").value;
	if(str!=""){
		if(str.substring(0,str.lastIndexOf(' ')).length>0 && str.substring(str.lastIndexOf(' ')+1,str.length).length>0){
			chknama=true;
			document.getElementById("warning-message").innerHTML="";
		}
		else{
			chknama=false;
			hide_create_button();
			document.getElementById("warning-message").innerHTML="Format nama masih salah";
		}
	}
}

function check_confirmpassword() {
	var str = document.getElementById("password").value;
	var str2 = document.getElementById("confirmpassword").value;
	if(str2!=""){
		if(str==str2){
			chkpassword2=true;
			document.getElementById("warning-message").innerHTML="";
		}
		else{
			chkpassword2=false;
			hide_create_button();
			document.getElementById("warning-message").innerHTML="Password gagal dikonfirmasi";
		}
	}
}

function check_email() {
	var str = document.getElementById("email").value;
	if(str!=""){
		var password = document.getElementById("password").value;
		var emailadress = str.substring(0,str.lastIndexOf('@'));
		
		var domain="";
		var domain2="";
		if(str.lastIndexOf('.')>str.lastIndexOf('@')) 
		{
		domain=str.substring(str.lastIndexOf('@')+1,str.lastIndexOf('.'));
		domain2=str.substring(str.lastIndexOf('.')+1,str.length);
		}
		if(emailadress.length>0 && domain.length>0 && domain2.length>1 && is_only_character(emailadress) && is_only_character(domain) && is_only_character(domain2)) {
			if(str!=password){
			chkemail=true;
			document.getElementById("warning-message").innerHTML="";
			}else{
				chkemail=false;
				hide_create_button();
				document.getElementById("warning-message").innerHTML="Alamat Email Tidak Boleh Sama Dengan Password";
			}
		}
		else{
		chkemail=false;
		hide_create_button();
		document.getElementById("warning-message").innerHTML="Alamat Email Belum Benar";
		}
	}
}

function checker()
{
	check_user_name();
	if(chkusername==true)
	{
		check_nama();
		if(chknama==true)
		{
			check_HP();
			if(chkHP==true)
			{
				check_pos();
				if(chkpos==true)
				{
					check_password();
					if(chkpassword1==true)
					{
						check_confirmpassword();
						if(chkpassword2==true){
							check_email();
							if(chkemail){
								check_lengkap();
							}
						}
					}
				}
			}
		}
	}
}


function addAssignee() {
	check_assignee();
	autoCompleteAsignee();
}

function getAjax() //a function to get AJAX from browser
{
	try
	{
		ajaxRequest = new XMLHttpRequest();
	}
	catch (e)
	{
		try
		{
			ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e) 
		{
			try
			{
				ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e)
			{
				alert("Can't get AJAX, browser error");
				return false;
			}
		}
	}
}