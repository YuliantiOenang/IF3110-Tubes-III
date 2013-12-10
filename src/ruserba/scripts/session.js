window.addEventListener('load', function() {
	var loginbutton = document.getElementById('loginbutton');
	var registerbutton = document.getElementById('registerbutton');
	var logoutbutton = document.getElementById('logoutbutton');
	var loginform = document.getElementById('loginform');
	var loginsubmit = document.getElementById('loginsubmit');
	
	loginbutton.onclick = function() {
		loginbutton.style.display = 'none';
		loginform.style.display = 'inline-block';
		loginform.getElementsByTagName('input')[0].focus();
	};
	
	registerbutton.onclick = function() {
		window.location.href = '/ruserba/register';
	}
	
	document.onmouseup = function(e) {
		if (localStorage.getItem('auth_token') == null) {
			if (loginform.style.display != 'none' && e.target.id != 'loginform' && e.target.parentNode.id != 'loginform' && e.target.parentNode.parentNode.id != 'loginform') {
				loginbutton.style.display = 'inline-block';
				loginform.style.display = 'none';
				document.getElementById('loginerror').style.visibility = 'hidden';
			}
		}
	}
	
	loginsubmit.onclick = function() {
		loginform.onsubmit();
	}
	
	loginform.onsubmit = function() {
		var loginuser = document.getElementsByName('loginuser')[0].value;
		var loginpass = document.getElementsByName('loginpass')[0].value;
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/ruserba/scripts/php/login.php', true);
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		var postParams = 'username=' + loginuser;
		postParams += '&password=' + loginpass;
		xhr.send(postParams);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var response = JSON.parse(xhr.responseText);
				if (response['status'] == 'success') {
					window.location.replace('/ruserba');
				}
				else {
					document.getElementById('loginerror').style.visibility = 'visible';
				}
			}
		}
		return false;
	}
});