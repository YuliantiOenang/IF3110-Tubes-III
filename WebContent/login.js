function verLogin(){
				var username = document.forms['login']['username'].value;
				var password = document.forms['login']['password'].value;
				var err_login = document.getElementById("err_login");
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

						if(err_login==""){
							//Handle SESSION & LOCAL STORAGE
						}
					}
				};
				xmlhttp.open("POST","verifyLogin",true);
				xmlhttp.send(data);
			}