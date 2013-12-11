var IsLogin = false;
var currUsername;
var LoginClicked = false;
var NamaDepan = "Yanuar";
var KategoriBarang = new Array();
KategoriBarang[0] = "makanan";
KategoriBarang[1] = "aksesoris";
KategoriBarang[2] = "pakaian";
KategoriBarang[3] = "furnitur";
KategoriBarang[4] = "mainan";
var activeUser = "";


function IsLogin(){
	currUsername=getCookie("username");
	if (currUsername!=null && currUsername!="") {
		return true;
	} else {
		return false;
	}
}

function drawHeaderContent(){
	document.getElementById('header').innerHTML="";
	document.getElementById('header').innerHTML+="<a href=\"index.jsp\"> <img src=\"assets/img/logo.png\" /> </a>";
	document.getElementById('header').innerHTML+="<form  id='searchform' method='get' action='searchresult.jsp'><input id='hilang' name='sortBy' value=priority><input id='hilang' name='currentPage' value =1><input class=\"textInput\" id='searchBar' type=\"text\" name=\"keyword\">";
	document.getElementById('searchform').innerHTML+="<input class=\"headerItem\" id='searchButton' type=\"submit\" value=\"cari!\">";
	document.getElementById('searchform').innerHTML+="<select class=\"dropDown\" id='kategoriDropDown' name='category'>";
	document.getElementById('kategoriDropDown').innerHTML+="<option value=\"\">kategori...</option>";
	for (var i=0;i<5;i++){
		var opt = document.createElement("option");
        opt.value = KategoriBarang[i];
        opt.text= KategoriBarang[i];
        document.getElementById('kategoriDropDown').appendChild(opt);
	}
	document.getElementById('searchform').innerHTML+="</select></form>";
	document.getElementById('header').innerHTML+="<a href=\"shoppingbag.jsp\"><button class=\"headerItem\" id='shoppingBag' type=\"button\">tas belanja</button></a>";
	
	if (localStorage.getItem('activeUser') != "" && localStorage.getItem('activeUser') != null) {
		document.getElementById('header').innerHTML+="<button class=\"headerItem\" id='login' type=\"button\" onclick=\"logout()\">keluar</button>";
		document.getElementById('header').innerHTML+="<a href=\"profile.html\"><button class=\"headerItem\" id='register' type=\"button\">selamat datang, " + localStorage.getItem('activeUser') +"!</button></a>";
	} else {
		document.getElementById('header').innerHTML+="<a href=\"register.jsp\"><button class=\"headerItem\" id='register' type=\"button\" >daftar!</button></a>";
		document.getElementById('header').innerHTML+="<button class=\"headerItem\" id='login' type=\"button\" onclick=\"triggerPopupLogin()\">masuk</button>";
		if (LoginClicked){
			drawPopupLogin();
		}
	}
}

function triggerPopupLogin(){
	LoginClicked =!LoginClicked;
	drawHeaderContent(); 
}

function drawPopupLogin(){
	document.getElementById('header').innerHTML+="<div id='popupLoginBubble'><div id='popupLoginContent'>";
	document.getElementById('popupLoginContent').innerHTML+="username </br><form id='popupLoginForm' action=\"checkLogin\">";
	document.getElementById('popupLoginForm').innerHTML+="<input class=\"textInput\" id='loginUsername' type=\"text\" name=\"username\"></br></br>";
	document.getElementById('popupLoginForm').innerHTML+="password</br>";
	document.getElementById('popupLoginForm').innerHTML+="<input class=\"textInput\" id='loginPassword' type=\"password\" name=\"password\"></br>";
	document.getElementById('popupLoginForm').innerHTML+="<input type='submit' class=\"button\" value='Masuk'> <input class=\"button\" id='cancelButton' type=\"submit\" value=\"batal\" onclick=\"triggerPopupLogin()\">";
	document.getElementById('popupLoginForm').innerHTML+="</form><div id='failLogin'></div>";
	document.getElementById('popupLoginContent').innerHTML+="</div></div>";
}


function login(){
	postForm(
		"checkLogin.jsp",
		function() {
			if (xmlhttp.readyState==4) {
				var validate = xmlhttp.responseText;
				if (validate) {
					localStorage.setItem('activeUser', validate);
					IsLogin = true;
					drawHeaderContent();
				}
				else alert("Login gagal, periksa kembali username dan password anda");
			}
		},
		document.forms['popupLoginForm']
	);
}

function logout(){
	LoginClicked = false;
	localStorage.setItem('activeUser', '');
	drawHeaderContent();
	
}

function addItemToBag(IdBarang, JumlahBarang, NamaBarang, HargaBarang){
	var listBelanja = JSON.parse(localStorage.getItem('shopList'));
	var itemFounded = false;
	JumlahBarang = document.getElementById("t"+IdBarang).value;
	var i =0;
	if (listBelanja==null || listBelanja==''){
		listBelanja = new Array();
	}
	while (itemFounded==false && i<listBelanja.length){
		if (listBelanja[i].Id==IdBarang){
			listBelanja[i].Jumlah=parseInt(listBelanja[i].Jumlah)+parseInt(JumlahBarang);
			itemFounded=true;
		}
		i++;
	}
	if (itemFounded==false && JumlahBarang > 0){
		listBelanja.push({Id:IdBarang,Jumlah:JumlahBarang,Nama:NamaBarang,Harga:parseInt(HargaBarang)});
	}
	localStorage.setItem('shopList',JSON.stringify(listBelanja));
	alert(JumlahBarang+" buah "+NamaBarang+" berhasil ditambahkan\n"+NamaBarang+" di tas : "+listBelanja.length);
}

function deleteItemFromBag(IdxList){
	var listBelanja = JSON.parse(localStorage.getItem('shopList'));
	alert(listBelanja[IdxList].Nama+" berhasil dikeluarkan dari tas belanja!");
	listBelanja.splice(parseInt(IdxList),1);
	localStorage.setItem('shopList',JSON.stringify(listBelanja));
	showShoppingBag();
	document.location.reload(true);
}

function payItemBag(){
	var listBelanja = JSON.parse(localStorage.getItem('shopList'));
	listBelanja.splice(1,listBelanja.length);
	localStorage.setItem('shopList',JSON.stringify(listBelanja));
}

function getQuantity(id){
	return getElementById(id).value;
}