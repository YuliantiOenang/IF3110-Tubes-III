// JavaScript Document
var ajaxRequest;

function getAjax() //a function to get AJAX from browser
{
	try
	{
		ajaxRequest = new XMLHttpRequest();
	}
	catch (e)
	{
		try
		{
			ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e) 
		{
			try
			{
				ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e)
			{
				alert("Can't get AJAX, browser error");
				return false;
			}
		}
	}
}

			function login() {
				getAjax();
				
				if(document.getElementById("login1")!="" && document.getElementById("login2")!=""){
					ajaxRequest.open("GET","php/checkidexistence.php?id="+document.getElementById("login1").value+"&pass="+document.getElementById("login2").value,false);//+"&pass="+document.getElementById("input2").value
					ajaxRequest.onreadystatechange = function()
					{
						var loginresponse = ajaxRequest.responseText;
						if(loginresponse == "true"){
							self.location="page/dashboard.php";
						}else{
							alert("Username or password is wrong");
						}
						
					}
					ajaxRequest.send();
				}
			//if (document.getElementById("login1").value == 'meckyr' && document.getElementById("login2").value == 'meckyr') {
			//	self.location="page/dashboard.php";
			//}
			}
			function show_register_form() {
				document.getElementById("login-form").style.display = "none";
				document.getElementById("login-bottom").style.display = "none";
				document.getElementById("register-form").style.display = "block";
				document.getElementById("register-bottom").style.display = "block";
			}
			function show_login_form() {
				document.getElementById("register-form").style.display = "none";
				document.getElementById("register-bottom").style.display = "none";
				document.getElementById("login-form").style.display = "block";
				document.getElementById("login-bottom").style.display = "block";
			}
			
			function checkAutenthication(){
				
			}