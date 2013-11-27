function verLogin(){
				var username = document.forms['login']['username'].value;
				var password = document.forms['login']['password'].value;
				var err_login = document.getElementById("err_login");
				var data = "username="+username+"&password="+password;
				var isLogin = false;
				if(window.XMLHttpRequest){
					xmlhttp = new XMLHttpRequest();
				}
				else{
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.onreadystatechange=function(){
					if(xmlhttp.readyState==4&&xmlhttp.status==200){
						err_login.innerHTML = xmlhttp.responseText;

						if(err_login.innerHTML==""){
							//Handle SESSION & LOCAL STORAGE
							window.location="index.jsp";
						}
					}
				};
				xmlhttp.open("POST","verifyLogin",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send(data);
			}