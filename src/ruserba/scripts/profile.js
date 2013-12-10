window.addEventListener('load', function() {
	var name = document.getElementsByName('name')[0];
	var password = document.getElementsByName('password')[0];
	var confirm = document.getElementsByName('confirm')[0];
	var alamat = document.getElementsByName('alamat')[0];
	var provinsi = document.getElementsByName('provinsi')[0];
	var kotakabupaten = document.getElementsByName('kotakabupaten')[0];
	var kodepos = document.getElementsByName('kodepos')[0];
	var nohp = document.getElementsByName('nohp')[0];
	var submit = document.getElementsByName('esubmit')[0];
	var name_old = document.getElementsByName('name_old')[0];
	var password_old = document.getElementsByName('password_old')[0];
	var alamat_old = document.getElementsByName('alamat_old')[0];
	var provinsi_old = document.getElementsByName('provinsi_old')[0];
	var kotakabupaten_old = document.getElementsByName('kotakabupaten_old')[0];
	var kodepos_old = document.getElementsByName('kodepos_old')[0];
	var nohp_old = document.getElementsByName('nohp_old')[0];
	var username = document.getElementsByName('username')[0];
	var email = document.getElementsByName('email')[0];
	name.value=name_old.value;
	password.value=password_old.value;
	confirm.value=password_old.value;
	alamat.value=alamat_old.value;
	provinsi.value=provinsi_old.value;
	kotakabupaten.value=kotakabupaten_old.value;
	kodepos.value=kodepos_old.value;
	nohp.value=nohp_old.value;
	
	var errorname = document.getElementById('errorname');
	var errorpass = document.getElementById('errorpass');
	var errorpassuser = document.getElementById('errorpassuser');
	var errorpassemail = document.getElementById('errorpassemail');
	var errorcpass = document.getElementById('errorcpass');
	var errorjumlah = document.getElementById('errorjumlah');
	var errorposint = document.getElementById('errorposint');
	var errornoint = document.getElementById('errornoint');
	
	name.onkeyup = function() {
		var splitname = name.value.split(' ');
		if (splitname.length > 1 && splitname[0] != '' && splitname[splitname.length - 1] != '') {
			name.className = 'formok';
			errorname.style.display = 'none';
		}
		else {
			name.className = 'formerror';
			errorname.style.display = 'inline';
		}
	};
	
	password.onkeyup = function() {
		if (password.value.length >= 8) {
			if (password.value != username.value) {
				if (password.value != email.value) {
					password.className = 'formok';
					submitButton(formOk, submit);
					errorpass.style.display = 'none';
					errorpassuser.style.display = 'none';
					errorpassemail.style.display = 'none';
				}
				else {
					password.className = 'formerror';
					submitButton(formOk, submit);
					errorpass.style.display = 'none';
					errorpassuser.style.display = 'none';
					errorpassemail.style.display = 'inline';
				}
			}
			else {
				password.className = 'formerror';
				errorpass.style.display = 'none';
				errorpassuser.style.display = 'inline';
				errorpassemail.style.display = 'none';
			}
		}
		else {
			password.className = 'formerror';
			errorpass.style.display = 'inline';
			errorpassuser.style.display = 'none';
			errorpassemail.style.display = 'none';
		}
	};
	
	confirm.onkeyup = function() {
		if (confirm.value == password.value) {
			confirm.className = 'formok';
			errorcpass.style.display = 'none';
		}
		else {
			confirm.className = 'formerror';
			errorcpass.style.display = 'inline';
		}
	};
	
	kodepos.onkeyup= function(){
		var intRegex = /^\d+$/;
		if (intRegex.test(kodepos.value)) {
			kodepos.className = 'formok'
			errorposint.style.display = 'none';
		}
		else{
			kodepos.className = 'formerror'
			errorposint.style.display = 'inline';
		}
	};
	
	nohp.onkeyup = function(){
		var intRegex = /^\d+$/;
		if (nohp.value.length <= 15){
			if (intRegex.test(nohp.value)) {
				nohp.className = 'formok'
				errorjumlah.style.display = 'none';
				errornoint.style.display = 'none';
			}
			else{
				nohp.className = 'formerror'
				errorjumlah.style.display = 'none';
				errornoint.style.display = 'inline';
			}
		}
		else{
			nohp.className = 'formerror'
			errorjumlah.style.display = 'inline';
			errornoint.style.display = 'none';
		}
	};
	
	document.getElementById('formprofile').onsubmit = function() {
		if (alamat_old.value == null) {
			alamat_old.value = '';
		}
		if (kotakabupaten_old.value == null) {
			kotakabupaten_old.value = '';
		}
		if (kodepos_old.value == null) {
			kodepos_old.value = '';
		}
		if (provinsi_old.value == null) {
			provinsi_old.value = '';
		}
		if (nohp_old.value == null) {
			nohp_old = '';
		}
		if (name.value != name_old.value || password.value != password_old.value || alamat.value != alamat_old.value || provinsi.value != provinsi_old.value || kotakabupaten.value != kotakabupaten_old.value || kodepos.value != kodepos_old.value || nohp.value != nohp_old.value) {
			if (username.value != password.value) {
				if (email.value != password.value) {
					if (password.value == confirm.value) {
						var xhr = new XMLHttpRequest();
						xhr.open('POST', '/ruserba/scripts/php/save_profile.php', true);
						xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
						var postParams = 'username=' + username.value;
						postParams += '&password=' + password.value;
						postParams += '&nama=' + name.value;
						postParams += '&alamat=' + alamat.value;
						postParams += '&kota=' + kotakabupaten.value;
						postParams += '&kodepos=' + kodepos.value;
						postParams += '&provinsi=' + provinsi.value;
						postParams += '&nohp=' + nohp.value;
						xhr.send(postParams);
						xhr.onreadystatechange = function() {
							if (xhr.readyState == 4 && xhr.status == 200) {
								var response = JSON.parse(xhr.responseText);
								if (response['status'] == 'success') {
									window.location.reload();
								}
							}
						}
					}
					else {
						alert('Kata sandi tidak cocok');
					}
				}
				else {
					alert('Kata sandi tidak boleh sama dengan email');
				}
			}
			else {
				alert('Kata sandi tidak boleh sama dengan username');
			}
		}
		else {
			alert('Data tidak berubah');
		}
		return false;
	};
});