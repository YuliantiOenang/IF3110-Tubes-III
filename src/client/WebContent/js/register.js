var xmlhttp;
if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttp=new XMLHttpRequest();
} else {// code for IE6, IE5
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
var Register = {
	error: [],
	validForm: {
		'username': true,
		'email': true,
		'password': true,
		'confirm': true,
		'nama':true,
		'alamat':true,
		'provinsi':true,
		'kota':true,
		'kodepos':true,
		'telepon':true
	},
	defaultForm: {},
	cekNama: function(){
		var nama = document.getElementById('nama').value;
		var spasi = nama.trim().indexOf(' ');
		if (spasi == -1) {
			this.error['nama'] = "Nama Lengkap harus minimal mengandung satu spasi antara dua karakter (ada nama depan dan nama belakang)";
			this.validForm['nama'] = false;
		} else {
			this.validForm['nama'] = true;
		}
		this.validasi();
	},
	cekConfirm: function(){
		var password = document.getElementById('password').value;
		var confirm = document.getElementById('confirm').value;
		if (password != confirm) {
			this.error['confirm'] = "Password harus sama dengan Konfirmasi";
			this.validForm['confirm'] = false;
		} else {
			this.validForm['confirm'] = true;
		}
		this.validasi();
	},
	cekPassword: function(){
		var password = document.getElementById('password').value;
		var email = document.getElementById('email').value;
		var username = document.getElementById('username').value;
		if (username == password) {
			this.error['password'] = 'Password tidak boleh sama dengan Username';
			this.validForm['password'] = false;
		} else if (password.length < 8) {
			this.error['password'] = 'Password minimal 8 karakter';
			this.validForm['password'] = false;
		} else if (password == email) {
			this.error['password'] = "Password tidak boleh sama dengan email";
			this.validForm['password'] = false;
		} else {
			this.validForm['password'] = true;
		}
		this.validasi();
	},
	cekUsername: function(){
		var username = document.getElementById('username').value;
		var that = this;
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				var data = JSON.parse(xmlhttp.responseText);
				if (data.status) {
					that.validForm['username'] = true;
				} else {
					that.error['username'] = 'Username sudah terpakai';
					that.validForm['username'] = false;
				}
				that.validasi();
			}
		}
		if (username.length < 5) {
			this.error['username'] = 'Username minimal 5 karakter';
			this.validForm['username'] = false;
			this.validasi();
		} else {
			xmlhttp.open("GET",server+"/api/usernameAvailable?username="+username,true);
			xmlhttp.send();
		}
	},
	isValidEmail: function(email) {
		var atpos=email.indexOf("@");
		var dotpos=email.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length) {
			return false;
		}
		return true;
	},
	cekEmail: function(){
		var email = document.getElementById('email').value;
		var that = this;
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				var data = JSON.parse(xmlhttp.responseText);
				if (data.status) {
					that.validForm['email'] = true;
				} else {
					that.error['email'] = 'Email sudah terpakai';
					that.validForm['email'] = false;
				}
				that.validasi();
			}
		}
		if (!this.isValidEmail(email)) {
			this.error['email'] = 'Email harus memiliki format XX@XX.YY (XX adalah satu karakter atau lebih, YY adalah dua karakter atau lebih)';
			this.validForm['email'] = false;
			this.validasi();
		} else {
			xmlhttp.open("GET",server+"/api/emailAvailable?email="+email,true);
			xmlhttp.send();
		}
	},
	validasi: function(){
		var valid = true;
		for (var key in this.validForm) {
			if (this.validForm.hasOwnProperty(key)) {
				var keyError = document.getElementById('error-'+key);
				var a = document.getElementById(key);
				if (!a.disabled) {
					if (this.validForm[key] == false) {
						a.classList.add("error");
						if (this.error[key])
							keyError.innerHTML = this.error[key];
						valid = false;
					} else {
						keyError.innerHTML = "";
						a.classList.remove("error");
					}
				}
			}
		}
		if (!valid) {
			document.getElementById("btn").disabled = true;
		} else {
			document.getElementById("btn").disabled = false;
		}
		return valid;
	},
	compareDefault: function() {
		var res = false;
		for (var key in defaultForm) {
			if (defaultForm.hasOwnProperty(key)) {
				if (defaultForm[key] != document.getElementById(key).value) res = true;
			}
		}
		if (!res) {
			alert('Tidak ada field yang diubah');
		}
		return res;
	}
}

