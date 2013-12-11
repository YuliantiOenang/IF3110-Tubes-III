var usernamestate = false;
var namastate = false;
var emailstate = false;
var pass1state = false;
var pass2state = false;
var namastate2 = false;
var emailstate2 = false;
var pass1state2 = false;
var pass2state2 = false;

function validateUsername() {
	// holds the remote server address
	var serverAddress = "validateRegister";
	// when set to true, display detailed error messages
	var showErrors = true;
	var username = document.register.username.value;
	var password1 = document.register.password1.value;
	var info = document.getElementById("usernameInfo");
	if (username.length < 5) {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Jumlah karakter username minimal 5';
		usernamestate = false;
		disableSubmit();
	} else {
		if (username == password1) {
			info.removeAttribute("class");
			info.setAttribute("class","error");
			info.innerHTML = 'username tidak boleh sama dengan password';
			usernamestate = false;
			disableSubmit();
		} else {
			// the data to be sent to the server through POST
			var data = "names=" + username;
			// build the settings object for the XmlHttp object
			var settings =
				{
				url: serverAddress,
				type: "POST",
				async: true,
				complete: function (xhr, response, status)
					{
					if (xhr.responseText.indexOf("ERRNO") >= 0
					|| xhr.responseText.indexOf("error:") >= 0
					|| xhr.responseText.length == 0)
					{
					alert(xhr.responseText.length == 0 ?
					"Server error." : response);
					}

					if (response == "yes") {
						info.removeAttribute("class");
						info.setAttribute("class","valid");
						info.innerHTML = "";
						usernamestate = true;
						enableSubmit();
					} else {
						info.removeAttribute("class");
						info.setAttribute("class","error");
						info.innerHTML = 'username sudah dipakai';
						usernamestate = false;
						disableSubmit();
					}
					},
				data: data,
				showErrors: showErrors
				};
			// make a server request to validate the input data
			var xmlHttp = new XmlHttp(settings);
			
		}
	}
}





function validatePassword1() {
	var password1 = document.register.password1.value;
	var username = document.register.username.value;
	var email = document.register.email.value;
	var info = document.getElementById("password1Info");
	if (password1.length < 8) {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Jumlah karakter password minimal 8';
		pass1state = false;
		disableSubmit();
	} else {
		if (password1 == username) {
			info.removeAttribute("class");
			info.setAttribute("class","error");
			info.innerHTML = 'Password tidak boleh sama dengan username';
			pass1state = false;
			disableSubmit();
		} else if (password1 == email) {
			info.removeAttribute("class");
			info.setAttribute("class","error");
			info.innerHTML = 'Password tidak bole sama dengan email';
			pass1state = false;
			disableSubmit();
		} else {
			//valid

			info.removeAttribute("class");
			info.setAttribute("class","valid");
			info.innerHTML = "";
			pass1state = true;
			enableSubmit();
			// validatePassword2();
		}
	}
}

function validatePassword2() {
	var password1 = document.register.password1.value;
	var password2 = document.register.password2.value;
	var info = document.getElementById("password2Info");
	if (password1 != password2) {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Password harus sama';
		pass2state = false;
		disableSubmit();
	} else {
			//valid
			info.removeAttribute("class");
			info.setAttribute("class","valid");
			info.innerHTML = "";
			pass2state = true;
			enableSubmit();
	}
}

function validateEmail(){
	var filter = /^[a-zA-Z0-9]+(\[a-zA-Z0-9_.-]+)*(\[a-zA-Z0-9_-]+)*@[a-zA-Z0-9]+.[a-z]{2,4}$/;
	// holds the remote server address
	var serverAddress = "validateRegister";
	// when set to true, display detailed error messages
	var showErrors = true;
	var email = document.register.email.value;
	var password1 = document.register.password1.value;
	var info = document.getElementById("emailInfo");
	if (!filter.test(email)) {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Format email tidak valid';
		emailstate = false;
		disableSubmit();
	} else {
		if (email == password1) {
			info.removeAttribute("class");
			info.setAttribute("class","error");
			info.innerHTML = 'email tidak boleh sama dengan password';
			emailstate = false;
			disableSubmit();
		} else {
			// the data to be sent to the server through POST
			var data = "emails=" + email;
			// build the settings object for the XmlHttp object
			var settings =
				{
				url: serverAddress,
				type: "POST",
				async: true,
				complete: function (xhr, response, status)
					{
					if (xhr.responseText.indexOf("ERRNO") >= 0
					|| xhr.responseText.indexOf("error:") >= 0
					|| xhr.responseText.length == 0)
					{
					alert(xhr.responseText.length == 0 ?
					"Server error." : response);
					}

					if (response == "yes") {
						info.removeAttribute("class");
						info.setAttribute("class","valid");
						info.innerHTML = "";
						emailstate = true;
						enableSubmit();
					} else {
						info.removeAttribute("class");
						info.setAttribute("class","error");
						info.innerHTML = 'email sudah dipakai';
						emailstate = false;
						disableSubmit();
					}
					},
				data: data,
				showErrors: showErrors
				};
			// make a server request to validate the input data
			var xmlHttp = new XmlHttp(settings);
			
		}
	}
	
} 

function validateNamaLengkap() {
	var filter = /^[a-zA-Z]+ [a-zA-Z]+([a-zA-Z ])*$/;
	var nama = document.register.namalengkap.value;
	var info = document.getElementById("namaInfo");
	if (filter.test(nama)) {
		info.removeAttribute("class");
		info.setAttribute("class","valid");
		info.innerHTML = "";
		namastate = true;
		enableSubmit();
	} else {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Nama harus terdiri nama depan dan belakang';
		namastate = false;
		disableSubmit();
	}

}

function enableSubmit() {
	var submit = document.register.submit;
	if (usernamestate && namastate && pass1state && pass2state && emailstate) {
		submit.disabled = false;
	}
}

function disableSubmit() {
	var submit = document.register.submit;
		submit.disabled = true;
}

function setFocus()
	{
	document.getElementById("username").focus();
	var submit = document.register.submit;
	submit.disabled = true;
	}

// function checkValid() {
// 	var username = document.getElementById("usernameInfo").getAttribute("class");
// 	var name = document.getElementById("namaInfo").getAttribute("class");
// 	var email = document.getElementById("emailInfo");.getAttribute("class");
// 	var password1 = document.getElementById("password1Info").getAttribute("class");
// 	var password2 = document.getElementById("password2Info").getAttribute("class");
// 	var submit = document.getElementById("submit");

// 	if ((username == "valid") && (name == "valid") && (email == "valid")  && (password1 == "valid") && (password2 == "valid")) {
// 		submit.removeAttribute(disabled);
// 	}
// }

function validateLogin() {
	// holds the remote server address
	var serverAddress = "validateLogin";
	// when set to true, display detailed error messages
	var showErrors = true;
	var username = document.login.username.value;
	var password = document.login.password.value;
	var unameInfo = document.getElementById("unameInfo");
	var passInfo = document.getElementById("passInfo");
	var info = document.getElementById("loginInfo");
	if ((username == "") || (password == "")) {
		if (username == "") {
			unameInfo.removeAttribute("class");
			unameInfo.setAttribute("class","error");
			unameInfo.innerHTML = 'Username harus diisi';
		}
		if (password == "") {
			passInfo.removeAttribute("class");
			passInfo.setAttribute("class","error");
			passInfo.innerHTML = 'Password harus diisi';
		}
	} else {
			unameInfo.removeAttribute("class");
			unameInfo.setAttribute("class","valid");
			unameInfo.innerHTML = '';
			passInfo.removeAttribute("class");
			passInfo.setAttribute("class","valid");
			passInfo.innerHTML = '';
			// the data to be sent to the server through POST
			var data = "username=" + username + "&password="+password;
			// build the settings object for the XmlHttp object
			var settings =
				{
				url: serverAddress,
				type: "POST",
				async: true,
				complete: function (xhr, response, status)
					{
					if (xhr.responseText.indexOf("ERRNO") >= 0
					|| xhr.responseText.indexOf("error:") >= 0
					|| xhr.responseText.length == 0)
					{
					alert(xhr.responseText.length == 0 ?
					"Server error." : response);
					}

					if (response == "success") {
						info.removeAttribute("class");
						info.setAttribute("class","valid");
						info.innerHTML = "";
						window.opener.location.reload();
						self.close();
					} else if (response=="register") {
						info.removeAttribute("class");
						info.setAttribute("class","error");
						info.innerHTML = 'username belum terdaftar';
					}else if (response=="password") {
						info.removeAttribute("class");
						info.setAttribute("class","error");
						info.innerHTML = 'password yang Anda masukkan salah';
					}
					},
				data: data,
				showErrors: showErrors
				};
			// make a server request to validate the input data
			var xmlHttp = new XmlHttp(settings);
	}
}

function login() {
	openlogin = window.open("login.jsp", "loginWindow", "width=800, height=400, status=no, toolbar=no, menubar=no");
	if (window.focus) {newwindow.focus()}
}


function validatePassword12() {
	var password1 = document.register.password1.value;
	var username = document.register.username.value;
	var email = document.register.email.value;
	var info = document.getElementById("password1Info");
	if (password1.length < 8) {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Jumlah karakter password minimal 8';
		pass1state2 = false;
		
	} else {
		if (password1 == username) {
			info.removeAttribute("class");
			info.setAttribute("class","error");
			info.innerHTML = 'Password tidak boleh sama dengan username';
			pass1state2 = false;
			
		} else if (password1 == email) {
			info.removeAttribute("class");
			info.setAttribute("class","error");
			info.innerHTML = 'Password tidak bole sama dengan email';
			pass1state2 = false;
			
		} else {
			//valid

			info.removeAttribute("class");
			info.setAttribute("class","valid");
			info.innerHTML = "";
			pass1state2 = true;
			
			// validatePassword2();
		}
	}
}

function validatePassword22() {
	var password1 = document.register.password1.value;
	var password2 = document.register.password2.value;
	var info = document.getElementById("password2Info");
	if (password1 != password2) {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Password harus sama';
		pass2state2 = false;
		
	} else {
			//valid
			info.removeAttribute("class");
			info.setAttribute("class","valid");
			info.innerHTML = "";
			pass2state2 = true;
			
	}
}

function validateEmail2(){
	var filter = /^[a-zA-Z0-9]+(\[a-zA-Z0-9_.-]+)*(\[a-zA-Z0-9_-]+)*@[a-zA-Z0-9]+.[a-z]{2,4}$/;
	// holds the remote server address
	var serverAddress = "validateRegister";
	// when set to true, display detailed error messages
	var showErrors = true;
	var email = document.register.email.value;
	var password1 = document.register.password1.value;
	var info = document.getElementById("emailInfo");
	if (!filter.test(email)) {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Format email tidak valid';
		emailstate2 = false;
		
	} else {
		if (email == password1) {
			info.removeAttribute("class");
			info.setAttribute("class","error");
			info.innerHTML = 'email tidak boleh sama dengan password';
			emailstate2 = false;
			
		} else {
			// the data to be sent to the server through POST
			var data = "emails=" + email;
			// build the settings object for the XmlHttp object
			var settings =
				{
				url: serverAddress,
				type: "POST",
				async: true,
				complete: function (xhr, response, status)
					{
					if (xhr.responseText.indexOf("ERRNO") >= 0
					|| xhr.responseText.indexOf("error:") >= 0
					|| xhr.responseText.length == 0)
					{
					alert(xhr.responseText.length == 0 ?
					"Server error." : response);
					}

					if (response == "yes") {
						info.removeAttribute("class");
						info.setAttribute("class","valid");
						info.innerHTML = "";
						emailstate2 = true;
						
					} else {
						info.removeAttribute("class");
						info.setAttribute("class","error");
						info.innerHTML = 'email sudah dipakai';
						emailstate2 = false;
						
					}
					},
				data: data,
				showErrors: showErrors
				};
			// make a server request to validate the input data
			var xmlHttp = new XmlHttp(settings);
			
		}
	}
	
} 

function validateNamaLengkap2() {
	var filter = /^[a-zA-Z]+ [a-zA-Z]+([a-zA-Z ])*$/;
	var nama = document.register.namalengkap.value;
	var info = document.getElementById("namaInfo");
	if (filter.test(nama)) {
		info.removeAttribute("class");
		info.setAttribute("class","valid");
		info.innerHTML = "";
		namastate2 = true;
		
	} else {
		info.removeAttribute("class");
		info.setAttribute("class","error");
		info.innerHTML = 'Nama harus terdiri nama depan dan belakang';
		namastate2 = false;
		
	}

}

function enableSubmit2() {
	var submit = document.register.submit;
	if (namastate2 && pass1state2 && pass2state2 && emailstate2) {
		submit.disabled = false;
	}
}

function disableSubmit2() {
	var submit = document.register.submit;
		submit.disabled = true;
}