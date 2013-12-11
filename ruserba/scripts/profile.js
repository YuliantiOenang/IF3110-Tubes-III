window.addEventListener('load', function() {
	if (localStorage.getItem('auth_token') === null) {
		window.location.href = '/ruserba/register';
	}
	
	document.getElementById('formtitle').innerHTML = 'Profil ' + localStorage.getItem('username');

	var name = document.getElementsByName('name')[0];
	var password = document.getElementsByName('password')[0];
	var confirm = document.getElementsByName('confirm')[0];
	var alamat = document.getElementsByName('alamat')[0];
	var provinsi = document.getElementsByName('provinsi')[0];
	var kotakabupaten = document.getElementsByName('kotakabupaten')[0];
	var kodepos= document.getElementsByName('kodepos')[0];
	var nohp = document.getElementsByName('nohp')[0];
	var submit = document.getElementsByName('esubmit')[0];

	var record;

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/ruserba/scripts/php/retrieve_profile.php', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send('username=' + localStorage.getItem('username'));
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var response = JSON.parse(xhr.responseText);
			if (response['status'] == 'success') {
				record = response['record'];
				name.value = record['nama'];
				password.value = record['password'];
				confirm.value = record['password'];
				alamat.value = record['alamat'];
				provinsi.value = record['provinsi'];
				kotakabupaten.value = record['kota'];
				kodepos.value = record['kode_pos'];
				nohp.value = record['nomor_ponsel'];
			}
		}
	}
	
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
		if (record['alamat'] == null) {
			record['alamat'] = '';
		}
		if (record['kota'] == null) {
			record['kota'] = '';
		}
		if (record['kode_pos'] == null) {
			record['kode_pos'] = '';
		}
		if (record['provinsi'] == null) {
			record['provinsi'] = '';
		}
		if (record['nomor_ponsel'] == null) {
			record['nomor_ponsel'] = '';
		}
		if (name.value != record['nama'] || password.value != record['password'] || alamat.value != record['alamat'] || provinsi.value != record['provinsi'] || kotakabupaten.value != record['kota'] || kodepos.value != record['kode_pos'] || nohp.value != record['nomor_ponsel']) {
			if (record['username'] != password.value) {
				if (record['email'] != password.value) {
					if (password.value == confirm.value) {
						var xhr = new XMLHttpRequest();
						xhr.open('POST', '/ruserba/scripts/php/save_profile.php', true);
						xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
						var postParams = 'username=' + record['username'];
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