	//. Variabel global
	usernameflag, passwordflag, fullnameflag, emailflag, confirmflag = false;

	// Fungsi validasi format input di registrasi
	function validate(type){
		if (type == "username"){ // Username
			var pattern = /.....+/; // Regex
			var x = document.forms["registration"]["username"].value; // Ambil Value
			var z = document.forms["registration"]["password"].value; // Ambil Value
			var y = document.getElementById("username"); // Ambil elemen tulisan di sebelah form
			
			// Cek value dengan regex
			if(!pattern.test(x)){
				y.innerHTML=" *username minimal 5 karakter";
				usernameflag = false;
			}else{
				y.innerHTML="";
				usernameflag = true;

				// Cek kesamaan dengan password
				if(z == x){
					y.innerHTML=" *username tidak boleh sama dengan password";
					usernameflag = false;
				}else{
					y.innerHTML="";
					usernameflag = true;
				}
			}			
		}else if(type == "password"){ // Password
			var pattern = /........+/; // Regex
			var x = document.forms["registration"]["password"].value; // Ambil Value
			var y = document.getElementById("password2"); // Ambil elemen tulisan di sebelah form
			var z = document.forms["registration"]["username"].value; // Ambil Value
			var a = document.forms["registration"]["email"].value; // Ambil Value
			
			// Cek value dengan regex
			if(!pattern.test(x)){
				y.innerHTML="*password minimal 8 karakter";				
				passwordflag = false;
			}else{
				y.innerHTML="";
				passwordflag = true;
			
				// Cek kesamaan dengan username
				if(z == x){
					y.innerHTML=" *password tidak boleh sama dengan username";
					passwordflag = false;
				}else{
					y.innerHTML="";
					passwordflag = true;
		
					// Cek kesamaan dengan email
					if(a == x){
						y.innerHTML=" *password tidak boleh sama dengan email";
						passwordflag = false;
					}else{
						y.innerHTML="";
						passwordflag = true;
					}
				}
			}	
		}else if(type == "confirm"){ // Confirm password
			var password = document.forms["registration"]["password"].value; // Ambil Value form Password
			var x = document.forms["registration"]["confirm"].value; // Ambil Value form Confirm
			var y = document.getElementById("confirm"); // Ambil elemen tulisan di sebelah form
			
			// Cek kesamaan dengan password
			if(password == x){
				y.innerHTML="";
				confirmflag = true;
			}else{
				y.innerHTML=" *konfirmasi password salah";
				confirmflag = false;
			}
		}else if(type == "fullname"){ // Full name
			var pattern = /.+ .+/; // Regex
			var x = document.forms["registration"]["fullname"].value; // Ambil Value
			var y = document.getElementById("fullname"); // Ambil elemen tulisan di sebelah form
			
			// Cek value dengan regex
			if(!pattern.test(x)){
				y.innerHTML=" *nama minimal 2 kata dipisahkan spasi";
				fullnameflag = false;
			}else{
				y.innerHTML="";
				fullnameflag = true;
			}
		}else if(type == "email"){ // email
			var pattern = /.+@.+\...+/; // Regex
			var x = document.forms["registration"]["email"].value; // Ambil Value
			var y = document.getElementById("email"); // Ambil elemen tulisan di sebelah form
			var z = document.forms["registration"]["password"].value; // Ambil Value
			
			// Cek value dengan regex
			if(!pattern.test(x)){
				y.innerHTML=" *format minimal email x@x.xx";
				emailflag = false;
			}else{
				y.innerHTML="";
				emailflag = true;
			
				// Cek kesamaan dengan password
				if(z == x){
					y.innerHTML=" *email tidak boleh sama dengan password";
					emailflag = false;
				}else{
					y.innerHTML="";
					emailflag = true;
				}
			}
		}
		
		enablebutton();
	}
	
	// Fungsi validasi format input di form edit profile
	function validatep(type){
		if(type == "password"){ // Password
			var pattern = /........+/; // Regex
			var x = document.forms["registration"]["password"].value; // Ambil Value
			var y = document.getElementById("password2"); // Ambil elemen tulisan di sebelah form
			var z = document.getElementById("username2").innerHTML; // Ambil Value
			var a = document.getElementById("email").innerHTML; // Ambil Value
			
			// Cek value dengan regex
			if(!pattern.test(x)){
				y.innerHTML=" *password minimal 8 karakter";
				passwordflag = false;
			}else{
				y.innerHTML="";
				passwordflag = true;
			
				// Cek kesamaan dengan username
				if(z == x){
					y.innerHTML=" *password tidak boleh sama dengan username";
					passwordflag = false;
				}else{
					y.innerHTML="";
					passwordflag = true;
		
					// Cek kesamaan dengan email
					if(a == x){
						y.innerHTML=" *password tidak boleh sama dengan email";
						passwordflag = false;
					}else{
						y.innerHTML="";
						passwordflag = true;
					}
				}
			}	
		}else if(type == "confirm"){ // Confirm password
			var password = document.forms["registration"]["password"].value; // Ambil Value form Password
			var x = document.forms["registration"]["confirm"].value; // Ambil Value form Confirm
			var y = document.getElementById("confirm"); // Ambil elemen tulisan di sebelah form
			
			// Cek kesamaan dengan password
			if(password == x){
				y.innerHTML="";
				confirmflag = true;
			}else{
				y.innerHTML=" *konfirmasi password salah";
				confirmflag = false;
			}
		}else if(type == "fullname"){ // Full name
			var pattern = /.+ .+/; // Regex
			var x = document.forms["registration"]["fullname"].value; // Ambil Value
			var y = document.getElementById("fullname"); // Ambil elemen tulisan di sebelah form
			
			// Cek value dengan regex
			if(!pattern.test(x)){
				y.innerHTML=" *nama minimal 2 kata dipisahkan spasi";
				fullnameflag = false;
			}else{
				y.innerHTML="";
				fullnameflag = true;
			}
		}
		
		penablebutton();
	}
	
	
	// Fungsi disable/enable confirm button
	function enablebutton(){
			var button = document.getElementById("submitbutton");
		if (usernameflag && passwordflag && fullnameflag && emailflag && confirmflag){
			button.disabled=false;
		}else
			button.disabled=true;
	}
	
	function penablebutton(){
		var button = document.getElementById("submitbutton");
	if (passwordflag && fullnameflag&& confirmflag){
		button.disabled=false;
	}else
		button.disabled=true;
}