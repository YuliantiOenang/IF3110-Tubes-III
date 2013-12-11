// global.js
// Deklarasi fungsi-fungsi Javascript yang umum.

// Fungsi untuk membuat XMLHttpRequest.
function createXMLHttpRequest()	{
	var xmlhttp;
	if (window.XMLHttpRequest)
		{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}

// Credit goes to quirksmode.org.
function createCookie(name,value,days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+"; path=/";
}
function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}
function eraseCookie(name) {
	createCookie(name,"",-1);
}

function getOkSmall(message)	{
	return "<span class=\"systemmessagesmall\"><img src=\"images/icon_ok_small.png\" alt=\"OK\" />" + message + "</span>";
}

function getWarningSmall(message)	{
	return "<span class=\"systemmessagesmall\"><img src=\"images/icon_warning_small.png\" alt=\"Warning\" />" + message + "</span>";
}

function getErrorSmall(message)	{
	return "<span class=\"systemmessagesmall\"><img src=\"images/icon_error_small.png\" alt=\"Error\" />" + message + "</span>";
}

function getUsername()	{
	return readCookie("username");
}

function getUserId()	{
	return parseInt(readCookie("id"));
}

function isLoggedIn()	{
	return readCookie("id_user") !== null && getUsername() != null;
}

function setShoppingBag(bag)	{
	localStorage.setItem("bag", JSON.stringify(bag));
}
function getShoppingBag()	{
	if (localStorage.getItem("bag") === null) setShoppingBag({});
	return JSON.parse(localStorage.getItem("bag"));
}
function deleteShoppingBag()	{
	localStorage.removeItem("bag");
}
function setProductQuantity(product_id, quantity)	{
	var bag = getShoppingBag();
	if (bag[product_id] === undefined)	{
		bag[product_id] = {};
		bag[product_id]["note"] = "";
	}
	bag[product_id]["quantity"] = quantity;
	setShoppingBag(bag);
}
function setProductNote(product_id, note)	{
	var bag = getShoppingBag();
	if (bag[product_id] === undefined)	{
		bag[product_id] = {};
		bag[product_id]["quantity"] = 0;
	}
	bag[product_id]["note"] = note;
	setShoppingBag(bag);
}
function getProductQuantity(product_id)	{
	var bag = getShoppingBag();
	if (bag[product_id] === undefined) return 0;
	else return bag[product_id]["quantity"];
}
function getProductNote(product_id)	{
	var bag = getShoppingBag();
	if (bag[product_id] === undefined) return "";
	else return bag[product_id]["note"];
}

// Fungsi-fungsi untuk core
// ------------------------------

window.addEventListener("load", function()	{
	document.getElementById("headerloginbutton").onclick = showLogin;
	document.getElementById("headerlogoutbutton").onclick = requestLogout;
	updateHeaderLogin();
});

// Insialisasi komponen login dari header.
function updateHeaderLogin()	{
	var divloggedin = document.getElementById("headerloggedin");
	var divnotloggedin = document.getElementById("headernotloggedin");
	if (isLoggedIn())	{
		divloggedin.style.display = "block"; divnotloggedin.style.display = "none";
		// Tuliskan username.
		document.getElementById("headerusername").innerHTML = getUsername();
	} else {
		divloggedin.style.display = "none"; divnotloggedin.style.display = "block";
	}
}

function getRequestString(requestobject) {
	var dataArray = [];
	for (var key in requestobject) {
		var encodedData = encodeURIComponent(key);
		encodedData += "=";
		encodedData += encodeURIComponent(requestobject[key]);
		dataArray.push(encodedData);
	}
	return dataArray.join("&");
}

function showLogin()	{
	var popuplayer = document.getElementById("popuplayer");
	var loginelmtstr =
		'<div id="cover"></div> \
		<div id="logindialog"> \
			<div id="logindialoginvisible"><img src="images/blank.jpg" alt="Blank" /></div> \
			<div id="logindialogclose"><a href="javascript:;" id="logindialogclosebutton"> \
			<img src="images/close.png" alt="Close button" /></a></div> \
			<h1>Login Form</h1> \
			<p><input type="text" id="logindialogusername" placeholder="Username" /></p> \
			<p><input type="password" id="logindialogpassword" placeholder="Password" /></p>  \
			<p><input type="submit" id="logindialogbutton" value="Login" /></p>  \
			<div id="logindialogmessage"> </div> \
		</div>';
	popuplayer.innerHTML = loginelmtstr;
	document.getElementById("logindialogclosebutton").onclick = hideLogin;
	document.getElementById("logindialogbutton").onclick = requestLogin;
}

function hideLogin()	{
	var popuplayer = document.getElementById("popuplayer");
	popuplayer.innerHTML = "";
}

function requestLogin()	{
	var username = document.getElementById("logindialogusername").value;
	var password = document.getElementById("logindialogpassword").value;
	var reqobj = {};
	reqobj['username'] = username;
	reqobj['password'] = password;
	var req = createXMLHttpRequest();
	req.onreadystatechange = function()	{
		if (req.readyState == 4 && req.status == 200)	{
			var ret = req.responseText.split("\n");
			if (ret[0] == "1") { hideLogin(); updateHeaderLogin(); }
			else document.getElementById("logindialogmessage").innerHTML = getErrorSmall("Login tidak berhasil dilakukan.");
		}
	}
	req.open("POST","login",true); // Bad...
	req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	req.send(getRequestString(reqobj));
	document.getElementById("logindialogmessage").innerHTML = getRequestString(reqobj);
}

function requestLogout()	{
	eraseCookie("id_user"); eraseCookie("username"); updateHeaderLogin();
}
