function cekUsername(){
	var valid = true;
	var username = document.getElementById("username").value;
	var text = "User name harus terdiri atas 5 karakter dan belum terpakai dalam database. Silakan coba lagi.";
	if (username.length >= 5)	{
		// Periksa apakah username sudah ada.
		var reqobj = {};

		reqobj['username'] = username;

		var req = createXMLHttpRequest();
		req.onreadystatechange = function()	{
			if (req.readyState == 4 && req.status == 200)	{
				var ret = req.responseText.split("\n");
				if (ret[0] == "1")
				{
					text = "Username sudah digunakan."
					valid = false;
				}
				else
				{
					text = "Username valid."
				}
			}
		}
		req.open("POST","checkusername",false); // Bad...
		req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		req.send(getRequestString(reqobj));
	} else {
		valid = false;
	}
	document.getElementById("responseUsername").innerHTML = text;
	return valid;
}

function cekEmail(){
	var valid = true;
	var email = document.getElementById("email").value.split('@');
	var text = "Email tidak valid.";
	if (email.length == 2 && email[0].length > 0){
		var email1 = email[1].split('.');
		if (email1.length > 1 && email1[0].length > 0 && email1[email1.length-1].length > 0)	{
			text = "Email valid.";
		} else valid = false;
	} else valid = false;
	document.getElementById("responseEmail").innerHTML = text;

	return valid;
}

function cekPassword(){
	var valid = true;
	var pass = document.getElementById("password").value;
	var cpass = document.getElementById("confirm_pwd").value;
	var text = "";

	if (pass === "")
	{
		text = "Password tidak boleh kosong."
		valid = false;
	}
	else if (pass.length < 8)
	{
		text = "Password harus minimal terdiri dari 8 karakter."
		valid = false;
	}
	else
	{
		if (pass === cpass)
		{
			var email = document.getElementById("email").value;
			var username = document.getElementById("username").value;

			if (pass === email)
			{
				text = "Password tidak boleh sama dengan email";
				valid = false;
			}
			else if (pass === username)
			{
				text = "Password tidak boleh sama dengan username";
				valid = false;
			}
			else
			{
				text = "Password sama";
			}
		}
		else
		{
			text = "Password tidak sama";
			valid = false;
		}
	}

	document.getElementById("responsePassword").innerHTML = text;

	return valid;
}

function cekFullname(){
	var valid = true;
	var nama_lengkap = document.getElementById("nama_lengkap").value;
	if (nama_lengkap.indexOf(" ") == -1)
	{
		document.getElementById("responseFullname").innerHTML = "Nama lengkap harus terdiri dari minimal dua kata.";
		valid = false;
	} else {
		document.getElementById("responseFullname").innerHTML = "Nama lengkap valid.";
	}
	return valid;
}

function cobaRegister()	{
	var username = document.getElementById("username").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var nama_lengkap = document.getElementById("nama_lengkap").value;
	var provinsi = document.getElementById("provinsi").value;
	var kota = document.getElementById("kota").value;
	var alamat = document.getElementById("alamat").value;
	var kode_pos = document.getElementById("kode_pos").value;
	var telepon = document.getElementById("telepon").value;

	var valid1 = cekUsername();
	var valid2 = cekEmail();
	var valid3 = cekPassword();
	var valid4 = cekFullname();

	var valid = valid1 && valid2 && valid3 && valid4;

	if (!valid)
	{
		document.getElementById("responseRegister").innerHTML = "Terdapat masukan yang tidak valid; registrasi dibatalkan.";
	}
	else
	{
		document.getElementById("responseRegister").innerHTML = "Memroses form registrasi...";
		var user = {};

		user['username'] = username;
		user['email'] = email;
		user['password'] = password;
		user['namaLengkap'] = nama_lengkap;
		user['provinsi'] = provinsi;
		user['kota'] = kota;
		user['alamat'] = alamat;
		user['kodePos'] = kode_pos;
		user['kontak'] = telepon;

		var req = createXMLHttpRequest();
		req.onreadystatechange = function()	{
			if (req.readyState == 4 && req.status == 200)	{
				window.location = "credit.jsp";
				//alert(req.responseText);
				//var ret = req.responseText.split("\n");
				//if (ret[0] == "1") { hideLogin(); updateHeaderLogin(); }
				//else document.getElementById("logindialogmessage").innerHTML = getErrorSmall("Login tidak berhasil dilakukan.");
			}
		}
		req.open("POST","registeruser",true); // Bad...
		req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		req.send(getRequestString(user));
	}
}
function cobaEdit()	{
	var username = document.getElementById("username").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var nama_lengkap = document.getElementById("nama_lengkap").value;
	var provinsi = document.getElementById("provinsi").value;
	var kota = document.getElementById("kota").value;
	var alamat = document.getElementById("alamat").value;
	var kode_pos = document.getElementById("kode_pos").value;
	var telepon = document.getElementById("telepon").value;

	var valid1 = cekUsername();
	var valid2 = cekEmail();
	var valid3 = cekPassword();
	var valid4 = cekFullname();

	var valid = valid1 && valid2 && valid3 && valid4;

	if (!valid)
	{
		document.getElementById("responseRegister").innerHTML = "Terdapat masukan yang tidak valid; edit profil dibatalkan.";
	}
	else
	{
		document.getElementById("responseRegister").innerHTML = "Memroses form edit profil...";
		var user = {};

		user.setUserName(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setNamaLengkap(nama_lengkap);
		user.setProvinsi(provinsi);
		user.setKota(kota);
		user.setAlamat(alamat);
		user.setKodePos(kode_pos);
		user.setKontak(telepon);

		var req = createXMLHttpRequest();
		req.onreadystatechange = function()	{
			if (req.readyState == 4 && req.status == 200)	{
				window.location = "profil.jsp";
				//alert(req.responseText);
				//var ret = req.responseText.split("\n");
				//if (ret[0] == "1") { hideLogin(); updateHeaderLogin(); }
				//else document.getElementById("logindialogmessage").innerHTML = getErrorSmall("Login tidak berhasil dilakukan.");
			}
		}
		req.open("POST","edituser",true); // Bad...
		req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		req.send(getRequestString(user));
	}
}


function cekNoKartu(){
	var valid = true;
	var nomor_kartu = document.getElementById("nomor_kartu").value;
	var text = "No.Kartu harus memiliki panjang lebih dari 13 digit.";
	if (nomor_kartu.length >= 13)	{
		// Periksa apakah username sudah ada.
		var reqobj = {};

		reqobj['nomor_kartu'] = nomor_kartu;

		var req = createXMLHttpRequest();
		req.onreadystatechange = function()	{
			if (req.readyState == 4 && req.status == 200)	{
				var ret = req.responseText.split("\n");
				if (ret[0] == "1")
				{
					text = "Nomor kartu sudah ada."
					valid = false;
				}
				else
				{
					text = "Nomor kartu valid."
				}
			}
		}
		req.open("POST","checkusername",false); // Bad...
		req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		req.send(getRequestString(reqobj));
	} else {
		valid = false;
	}
	document.getElementById("responseNoKartu").innerHTML = text;
	return valid;
}

function cekNamaKartu(){
	var valid = true;
	var nama_kartu = document.getElementById("nama_kartu").value;
	var text = "Nama Kartu tidak boleh sama dengan yang sudah ada pada database.";
	if (nama_lengkap.indexOf(" ") == -1)
	{
		document.getElementById("responseFullname").innerHTML = "Nama lengkap harus terdiri dari minimal dua kata.";
		valid = false;
	} else {
            var reqobj = {};

		reqobj['nama_kartu'] = nama_kartu;

		var req = createXMLHttpRequest();
		req.onreadystatechange = function()	{
			if (req.readyState == 4 && req.status == 200)	{
				var ret = req.responseText.split("\n");
				if (ret[0] == "1")
				{
					text = "Nama pengguna sudah ada."
					valid = false;
				}
				else
				{
                                        document.getElementById("responseFullname").innerHTML = "Nama lengkap valid.";
					text = "Nama pengguna valid."
				}
			}
		}
		req.open("POST","checkusername",false); // Bad...
		req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		req.send(getRequestString(reqobj));
	}
        document.getElementById("responseNamaKartu").innerHTML = text;
	return valid;
}

function cekExpiryKartu(){
	var valid = true;
	var ekspirasi_kartu = document.getElementById("ekspirasi_kartu").value.split('/');;
	var text = "Format tanggal salah. Format tanggal yang seharusnya: DD/MM/YYYY";
	if (nomor_kartu.length >= 10)	{
		var daymonth = ekspirasi_kartu[0].split('/');
                var monthyear = ekspirasi_kartu[1].split('/');
		if (ekspirasi_kartu[0].length < 3 && ekspirasi_kartu[0] < 31 && ekspirasi_kartu[1].length < 3 && ekspirasi_kartu[1] < 13 && ekspirasi_kartu[2].length < 5)	{
			text = "Email valid.";
		} else valid = false;
	} 
        else valid = false;
	document.getElementById("responseEkspirasiKartu").innerHTML = text;
	return valid;
}

function cobaRegisterKartu()	{
	var nomor_kartu = document.getElementById("nomor_kartu").value;
	var nama_kartu = document.getElementById("nama_kartu").value;
	var ekspirasi_kartu = document.getElementById("ekspirasi_kartu").value;

	var valid1 = cekNoKartu();
	var valid2 = cekNamaKartu();
	var valid3 = cekExpiryKartu();

	var valid = valid1 && valid2 && valid3;

	if (!valid)
	{
		document.getElementById("responseRegister").innerHTML = "Terdapat masukan yang tidak valid; registrasi dibatalkan.";
	}
	else
	{
		document.getElementById("responseRegister").innerHTML = "Memroses form registrasi...";
		var user = {};

		user['nomor_kartu'] = nomor_kartu;
		user['nama_kartu'] = nama_kartu;
		user['ekspirasi_kartu'] = ekspirasi_kartu;

		var req = createXMLHttpRequest();
		req.onreadystatechange = function()	{
			if (req.readyState == 4 && req.status == 200)	{
				window.location = "index.jsp";
				//alert(req.responseText);
				//var ret = req.responseText.split("\n");
				//if (ret[0] == "1") { hideLogin(); updateHeaderLogin(); }
				//else document.getElementById("logindialogmessage").innerHTML = getErrorSmall("Login tidak berhasil dilakukan.");
			}
		}
		req.open("POST","registeruser",true); // Bad...
		req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		req.send(getRequestString(user));
	}
}