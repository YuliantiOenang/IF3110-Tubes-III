function emailHint(str,pass) {
	if (str.length==0) { 
		document.getElementById("txtHint").innerHTML="";
		return;
	}
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","gethint.php?q="+str+"&jenis=email&pass="+pass,true);
	xmlhttp.send();
}

function userHint(str,pass) {
	if (str.length==0) { 
		document.getElementById("userHint").innerHTML="";
		return;
	}
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			document.getElementById("userHint").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","gethint.php?q="+str+"&jenis=user&pass="+pass,true);
	xmlhttp.send();
}

function passHint(str,username) {
	if (str.length==0) { 
		document.getElementById("passHint").innerHTML="";
		return;
	}
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			document.getElementById("passHint").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","gethint.php?q="+str+"&jenis=pass&user="+username,true);
	xmlhttp.send();
}

function cpassHint(str,password) {
	if (str.length==0) { 
		document.getElementById("cpassHint").innerHTML="";
		return;
	}
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			document.getElementById("cpassHint").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","gethint.php?q="+str+"&jenis=cpass&password="+password,true);
	xmlhttp.send();
}

function namaHint(str) {
	if (str.length==0) { 
		document.getElementById("namaHint").innerHTML="";
		return;
	}
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			document.getElementById("namaHint").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","gethint.php?q="+str+"&jenis=nama",true);
	xmlhttp.send();
}


