// AJAX untuk Modul User
// Author: Hafizh Adi Prasetya

// FUNGSI PAGE REDIRECTION
function LoginRedirection(){ // Redirection untuk user yang belum login
	if((localStorage.IsLogin === undefined))
		window.location.assign("home");
}
function LogoutRedirection(){ // Redirection untuk user yang sudah login (gabisa akses register dll)
	if(localStorage.IsLogin == 1)
		window.location.assign("home");
}

function tambahbarang(){
	window.location.href="inventori?action=add";
}

function editbarang(id){
	window.location.href="inventori?gid="+id+"&action=edit";
}

function InitializeBar(){
	if(localStorage.IsLogin == 1){
		document.getElementById("logbutton").value = "Log Out";
		document.getElementById("logbutton").onclick = function(){Logout();};
		document.getElementById("regislink").innerHTML = "Welcome, "+ localStorage.user_id;
		document.getElementById("regislink").setAttribute("href","Profile.jsp");
		
		if (localStorage.privilege === "Admin"){
			document.getElementById("special").innerHTML = "<input type='button' onclick='tambahbarang()' value='Tambah Barang' />";
		}
	}
}


// FUNGSI SUBMIT HTTPREQUEST
function SubmitRegistration(){	
	// Ambil data dari form 
	var data="";	
	data = "type=registration";
	data=data+"&id="+document.forms["registration"]["username"].value;
	data=data+"&email="+document.forms["registration"]["email"].value;
	data=data+"&password="+document.forms["registration"]["password"].value;
	data=data+"&fullname="+document.forms["registration"]["fullname"].value;
	data=data+"&alamat="+document.forms["registration"]["alamat"].value;
	data=data+"&provinsi="+document.forms["registration"]["provinsi"].value;
	data=data+"&kota="+document.forms["registration"]["kota"].value;
	data=data+"&kodepos="+document.forms["registration"]["kodepos"].value;
	data=data+"&hp="+document.forms["registration"]["hp"].value;
	
	//lakukan koneksi ke servlet
	var xmlhttp;
	if (window.XMLHttpRequest){
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	 }
	else{
	// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}	
	
	xmlhttp.onreadystatechange=function(){ProcessRegistrationResponse(xmlhttp);};
	xmlhttp.open("POST","servlet", false);
	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttp.send(data);
}
function SubmitCreditCard(){
	// Ambil data dari form 
	var data="";
	
	data = "type=creditcard";
	// TODO Ini harus diganti ketika implementasi session selesai
	data=data+"&id="+localStorage.user_id;
	data=data+"&cardnum="+document.forms["registration"]["cardnum"].value;
	data=data+"&cardname="+document.forms["registration"]["cardname"].value;
	data=data+"&expdate="+document.forms["registration"]["expdate"].value;
	
	//lakukan koneksi ke servlet
	var xmlhttp;
	if (window.XMLHttpRequest){
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	 }
	else{
	// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}	
	
	xmlhttp.onreadystatechange=function(){ProcessCCardResponse(xmlhttp);};
	xmlhttp.open("POST","servlet", false);
	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttp.send(data);
}
function SubmitNewProfile(){
	// Ambil data dari form
	if (CheckChange()){
		var data="";
		data = "type=profile";
		data=data+"&id="+document.getElementById("username").innerHTML;
		data=data+"&password="+document.forms["registration"]["password"].value;
		data=data+"&fullname="+document.forms["registration"]["fullname"].value;
		data=data+"&alamat="+document.forms["registration"]["alamat"].value;
		data=data+"&provinsi="+document.forms["registration"]["provinsi"].value;
		data=data+"&kota="+document.forms["registration"]["kota"].value;
		data=data+"&kodepos="+document.forms["registration"]["kodepos"].value;
		data=data+"&hp="+document.forms["registration"]["hp"].value;
		
		
		//lakukan koneksi ke servlet
		var xmlhttp;
		if (window.XMLHttpRequest){
			// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		 }
		else{
		// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}	
		
		xmlhttp.onreadystatechange=function(){ProcessProfileResponse(xmlhttp);};
		xmlhttp.open("POST","servlet", false);
		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlhttp.send(data);
	}
	else
		alert("Anda tidak melakukan perubahan!");
}
function Login(){
	// Ambil data dari form 	
	var data="";
	data = "type=login";
	data=data+"&id=" + document.getElementById("login").value;
	data=data+"&password=" + document.getElementById("password").value;
	
	//lakukan koneksi ke servlet
	var xmlhttp;
	if (window.XMLHttpRequest){
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	 }
	else{
	// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}	
	
	xmlhttp.onreadystatechange=function(){ProcessLoginResponse(xmlhttp);};
	xmlhttp.open("POST","servlet", false);
	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttp.send(data);
}
function Logout(){ // Tanpa HTTP Request sih
	localStorage.clear();
	alert("Logout Berhasil!");
	document.getElementById("logbutton").value = "Log In";
	document.getElementById("logbutton").onclick = function(){location.href="#login_form";};
	document.getElementById("regislink").innerHTML = "Register";
	document.getElementById("regislink").setAttribute("href", "Registration.jsp");
	window.location.href = "";
}

// FUNGSI HANDLE HTTPRESPONSE
function ProcessProfileResponse(xmlhttp){
	// alert("ReadyState: " + xmlhttp.readyState + " Status: " + xmlhttp.status + " Text: "+xmlhttp.responseText);
	if (xmlhttp.readyState=="4" && xmlhttp.status=="200"){
		var responsecode = xmlhttp.responseText;
		if(parseInt(responsecode)==0){
			window.alert("Edit Profile Berhasil!");
			// Update LocalStorage
			localStorage.password = document.forms["registration"]["password"].value;
			localStorage.fullname = document.forms["registration"]["fullname"].value ;
			localStorage.alamat = document.forms["registration"]["alamat"].value;
			localStorage.provinsi = document.forms["registration"]["provinsi"].value;
			localStorage.kota = document.forms["registration"]["kota"].value;
			localStorage.kodepos = document.forms["registration"]["kodepos"].value;
			localStorage.hp = document.forms["registration"]["hp"].value;
		}
		else{
			window.alert("Edit Profile Gagal");
		}			
	}
}
function ProcessLoginResponse(xmlhttp){
	// alert("ReadyState: " + xmlhttp.readyState + " Status: " + xmlhttp.status + " Text: "+xmlhttp.responseText);
	if (xmlhttp.readyState=="4" && xmlhttp.status=="200"){
		var responsecode = xmlhttp.responseText;
		if(parseInt(responsecode)==0){
			// Notifikasi
			window.alert("Login berhasil!");
			
			// Set Parameter
			localStorage.IsLogin = 1;		
			
			// Split Response
			var datas = responsecode.split("|", 99);
			
			// Masukkan data
			localStorage.user_id = datas[1];
			localStorage.password= datas[2];
			localStorage.email= datas[3];
			localStorage.fullname= datas[4];
			localStorage.alamat= datas[5];
			localStorage.provinsi= datas[6];
			localStorage.kota= datas[7];
			localStorage.kodepos= datas[8];
			localStorage.hp= datas[9];
			localStorage.cardnum= datas[10];
			localStorage.privilege= datas[11];
			localStorage.transaction= datas[12];
			
			// Ubah tombol Log
			document.getElementById("logbutton").value = "Log Out";
			document.getElementById("logbutton").onclick = function(){Logout();};
			document.getElementById("regislink").innerHTML = "Welcome, "+ datas[1];
			document.getElementById("regislink").setAttribute("href","Profile.jsp");
			window.location.href = "";
		}
		else{
			// notifikasi
			window.alert("Login Gagal", responsecode);
		}			
	}
}
function ProcessCCardResponse(xmlhttp){
	// alert("ReadyState: " + xmlhttp.readyState + " Status: " + xmlhttp.status + " Text: "+xmlhttp.responseText);
	if (xmlhttp.readyState=="4" && xmlhttp.status=="200"){
		var responsecode = xmlhttp.responseText;
		if(parseInt(responsecode)==0){
			window.alert("Registrasi Kartu Kredit Berhasil !");
			// Set LocalStorage creditcard
			localStorage.cardnum = document.forms["registration"]["cardnum"].value;
		}
		else if(parseInt(responsecode)==1){
			window.alert("Kartu Kredit telah digunakan");
		}
		else{
			window.alert("Registrasi Kartu Kredit Gagal");
		}			
	}
}
function ProcessRegistrationResponse(xmlhttp){
	// alert("ReadyState: " + xmlhttp.readyState + " Status: " + xmlhttp.status + " Text: "+xmlhttp.responseText);
	if (xmlhttp.readyState=="4" && xmlhttp.status=="200"){
		var responsecode = xmlhttp.responseText;
		if(parseInt(responsecode)==0){
			window.alert("Registrasi Berhasil !");

			// Set Parameter
			localStorage.IsLogin = 1;		
			
			// Split Response
			var datas = responsecode.split("|", 99);
			
			// Masukkan data
			localStorage.user_id = datas[1];
			localStorage.password= datas[2];
			localStorage.email= datas[3];
			localStorage.fullname= datas[4];
			localStorage.alamat= datas[5];
			localStorage.provinsi= datas[6];
			localStorage.kota= datas[7];
			localStorage.kodepos= datas[8];
			localStorage.hp= datas[9];
			localStorage.cardnum= datas[10];
			localStorage.privilege= datas[11];
			localStorage.transaction= datas[12];
			
			window.location.assign("CreditCard.jsp");
		}
		else if(parseInt(responsecode)==1){
			window.alert("Id sudah digunakan");
		}
		else if(parseInt(responsecode)==2){
			window.alert("email sudah digunakan");
		}
		else{
			window.alert("Registrasi Gagal");
		}			
	}
}

// FUNGSI LAINNYA
function InitializeValue(){
	document.getElementById("username2").innerHTML = localStorage.user_id;
	document.getElementById("email").innerHTML = localStorage.email;
	document.getElementById("transaksi").innerHTML = localStorage.transaction;
	document.forms["registration"]["password"].value = localStorage.password;
	document.forms["registration"]["confirm"].value = localStorage.password;
	document.forms["registration"]["fullname"].value = localStorage.fullname;
	document.forms["registration"]["alamat"].value = localStorage.alamat;
	document.forms["registration"]["provinsi"].value = localStorage.provinsi;
	document.forms["registration"]["kota"].value = localStorage.kota;
	document.forms["registration"]["kodepos"].value = localStorage.kodepos;
	document.forms["registration"]["hp"].value = localStorage.hp;
}
function CheckChange(){
	if(document.forms["registration"]["password"].value == localStorage.password &&
		document.forms["registration"]["fullname"].value == localStorage.fullname && 
		document.forms["registration"]["alamat"].value == localStorage.alamat &&
		document.forms["registration"]["provinsi"].value == localStorage.provinsi &&
		document.forms["registration"]["kota"].value == localStorage.kota && 
		document.forms["registration"]["kodepos"].value == localStorage.kodepos && 
		document.forms["registration"]["hp"].value == localStorage.hp)
	{
		return false;
	}
	else
		return true;
}