//DEPENDENCIES: ajax.js
function login(){
	var username = prompt("Username:");
	if(username==null) return;
	var password = prompt("Password:");
	if(password==null) return;

	var data = {"action": "login", "user": username, "pass": password};
	
	var callback = function(response){
		if(response.status=="ok"){
			var hasil = {"user": username, "id": response.id};
			localStorage.setItem("logininfo", JSON.stringify(hasil));
			location.reload(true)
		}else{
			alert("Username atau password salah!");
		}	
	}
	
	sendAjax(data, "lib/login_lib.php", callback);
}

function redirect_login(){
	if(getLoginInfo() == null){
		window.location = "registration.php";
		return true;
	}
	
	return false;
}

function logout(){
	localStorage.removeItem("logininfo");
	localStorage.removeItem("shoppingbag");
	
	window.location = "index.php";
}

function getLoginInfo(){
	if (localStorage.getItem("logininfo") === null){
		return null;
	}
	
	return JSON.parse(localStorage.logininfo);
}

function searchBoxFocus(sbox){
	sbox.classList.remove("search-grey");
	
	if (sbox.value == "Search"){
		sbox.value = "";
	}
}

function searchBoxBlur(sbox){
	if(sbox.value == ""){
		sbox.classList.add("search-grey");
		sbox.value = "Search";
	}
}
