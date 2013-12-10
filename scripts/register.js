window.addEventListener('load', function() {
	if (localStorage.getItem('auth_token') !== null) {
		window.location.href = '/ruserba';
	}

	var username = document.getElementsByName('username')[0];
	var password = document.getElementsByName('password')[0];
	var confirm = document.getElementsByName('confirm')[0];
	var name = document.getElementsByName('name')[0];
	var email = document.getElementsByName('email')[0];
	var submit = document.getElementsByName('submit')[0];
	
	var erroruser5 = document.getElementById('erroruser5');
	var erroruser = document.getElementById('erroruser');
	var errorpass = document.getElementById('errorpass');
	var errorpassuser = document.getElementById('errorpassuser');
	var errorpassemail = document.getElementById('errorpassemail');
	var errorcpass = document.getElementById('errorcpass');
	var errorname = document.getElementById('errorname');
	var erroremailformat = document.getElementById('erroremailformat');
	var erroremail = document.getElementById('erroremail');
	
	username.focus();
	submit.disabled = true;
	
	var formOk = [false, false, false, false, false];

	username.onkeyup = function() {
		if (username.value.length >= 5) {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/ruserba/scripts/php/check_user.php', true);
			xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			xhr.send('username=' + username.value);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var response = JSON.parse(xhr.responseText);
					if (response['status'] == 'exists') {
						username.className = 'formerror';
						formOk[0] = false;
						submitButton(formOk, submit);
						erroruser5.style.display = 'none';
						erroruser.style.display = 'inline';
					}
					else {
						formOk[0] = true;
						username.className = 'formok';
						submitButton(formOk, submit);
						erroruser5.style.display = 'none';
						erroruser.style.display = 'none';
					}
				}
			}
		}
		else {
			username.className = 'formerror';
			formOk[0] = false;
			submitButton(formOk, submit);
			erroruser5.style.display = 'inline';
			erroruser.style.display = 'none';
		}
	};

	password.onkeyup = function() {
		if (password.value.length >= 8) {
			if (password.value != username.value) {
				if (password.value != email.value) {
					formOk[1] = true;
					password.className = 'formok';
					submitButton(formOk, submit);
					errorpass.style.display = 'none';
					errorpassuser.style.display = 'none';
					errorpassemail.style.display = 'none';
				}
				else {
					formOk[1] = false;
					password.className = 'formerror';
					submitButton(formOk, submit);
					errorpass.style.display = 'none';
					errorpassuser.style.display = 'none';
					errorpassemail.style.display = 'inline';
				}
			}
			else {
				formOk[1] = false;
				password.className = 'formerror';
				submitButton(formOk, submit);
				errorpass.style.display = 'none';
				errorpassuser.style.display = 'inline';
				errorpassemail.style.display = 'none';
			}
		}
		else {
			formOk[1] = false;
			password.className = 'formerror';
			submitButton(formOk, submit);
			errorpass.style.display = 'inline';
			errorpassuser.style.display = 'none';
			errorpassemail.style.display = 'none';
		}
	};

	confirm.onkeyup = function() {
		if (confirm.value == password.value) {
			formOk[2] = true;
			confirm.className = 'formok';
			submitButton(formOk, submit);
			errorcpass.style.display = 'none';
		}
		else {
			formOk[2] = false;
			confirm.className = 'formerror';
			submitButton(formOk, submit);
			errorcpass.style.display = 'inline';
		}
	};

	name.onkeyup = function() {
		var splitname = name.value.split(' ');
		if (splitname.length > 1 && splitname[0] != '' && splitname[splitname.length - 1] != '') {
			formOk[3] = true;
			name.className = 'formok';
			submitButton(formOk, submit);
			errorname.style.display = 'none';
		}
		else {
			formOk[3] = false;
			name.className = 'formerror';
			submitButton(formOk, submit);
			errorname.style.display = 'inline';
		}
	};

	email.onkeyup = function() {
		var splitusername = email.value.split('@');
		if (splitusername.length == 2 && splitusername[0] != '' && splitusername[1] != '') {
			var splitdomain = splitusername[1].split('.');
			if (splitdomain.length > 1 && splitdomain[0] != '' && splitdomain[splitdomain.length - 1] != '') {
				var xhr = new XMLHttpRequest();
				xhr.open('POST', '/ruserba/scripts/php/check_user.php', true);
				xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
				xhr.send('email=' + email.value);
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						var response = JSON.parse(xhr.responseText);
						if (response['status'] == 'exists') {
							email.className = 'formerror';
							formOk[4] = false;
							submitButton(formOk, submit);
							erroremailformat.style.display = 'none';
							erroremail.style.display = 'inline';
						}
						else {
							formOk[4] = true;
							email.className = 'formok';
							submitButton(formOk, submit);
							erroremailformat.style.display = 'none';
							erroremail.style.display = 'none';
						}
					}
				}
			}
			else {
				email.className = 'formerror';
				formOk[4] = false;
				submitButton(formOk, submit);
				erroremailformat.style.display = 'inline';
				erroremail.style.display = 'none';
			}
		}
		else {
			email.className = 'formerror';
			formOk[4] = false;
			submitButton(formOk, submit);
			erroremailformat.style.display = 'inline';
			erroremail.style.display = 'none';
		}
	};
	
	document.getElementById('registerform').onsubmit = function() {
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/ruserba/scripts/php/register.php', true);
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		var postParams = 'username=' + username.value;
		postParams += '&password=' + password.value;
		postParams += '&name=' + name.value;
		postParams += '&email=' + email.value;
		xhr.send(postParams);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var response = JSON.parse(xhr.responseText);
				if (response['status'] == 'success') {
					localStorage.setItem('username', username.value);
					localStorage.setItem('auth_token', response['token']);
					window.location.href = '/ruserba/registerkartu';
				}
			}
		}
		return false;
	};
});

function submitButton(formOk, button) {
	if (formOk.indexOf(false) == -1) {
		button.disabled = false;
	}
	else {
		button.disabled = true;
	}
}