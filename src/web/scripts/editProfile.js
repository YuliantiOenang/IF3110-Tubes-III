function cekUsername(){
	var username = getElementById("username").value;
	var text = "User name harus terdiri atas 5 karakter dan belum terpakai dalam database. Silakan coba lagi.";
	if (username.length > 5){
		if (){
			text = "User name tersedia.";
		}
	}
	getElementById("responseUsername").innerHTML = text;
}

function cekEmail(){
	var email = getElementById("email").value.split('@');
	var text = "Email tidak valid.";
	if (email.length == 2 && email[0].length > 0){
		var email1 = email.split('.');
		if (email1.length > 1 && email1[0].length > 0
				&& email1[email1.length-1].length > 1){
			text = "Email valid.";
		}
	}
	getElementById("responseEmail").innerHTML = text;
}

function cekPasswordMatch(pass, passC){
	var text = "";
	if (pass.localeCompare(passC) != 0){
		text = "";
	}
	getElementById("responsePassword").innerHTML = text;
}

function cekFullname(){
	var username = getElementById("fullname").value;

	if (x != null)
}

function cekAngka(angka){
	if (!isNaN(parseFloat(angka)) && isFinite(angka)){
		
	} else {
		
	}
}
