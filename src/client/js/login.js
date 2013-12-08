var xmlhttp;
if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttp=new XMLHttpRequest();
} else {// code for IE6, IE5
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
function login() {	
	var parameters = "username=" + encodeURI( document.getElementById("login_username").value ) + "&password=" + encodeURI( document.getElementById("login_password").value );
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			var data = JSON.parse(xmlhttp.responseText);
			if (data.success) {
				// alert('Anda berhasil login');
				document.getElementById('loading').innerHTML = "Anda berhasil login";
				window.location = "/ruserba/profile";
			} else {
				document.getElementById('loading').innerHTML = "Username atau password salah";
				// alert('Username atau password salah');
			}
			document.getElementById('loading').classList.remove('loading');
		}
	};
	document.getElementById('loading').innerHTML = "";
	document.getElementById('loading').classList.add('loading');
	xmlhttp.open("POST","/ruserba/api/login",true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	// xmlhttp.setRequestHeader("Content-length", parameters.length);
	// xmlhttp.setRequestHeader("Connection", "close");
	xmlhttp.send(parameters);
}