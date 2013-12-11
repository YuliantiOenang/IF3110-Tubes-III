function verLogin(){
				var username = document.forms['login']['username'].value;
				var password = document.forms['login']['password'].value;
				var err_login = document.getElementById("err_login");
				var query = "SELECT * FROM user where username ='"+username+"' AND password = '"+password+"'";
				var isLogin = false;
				var kategorilist = document.getElementById("kategorilist");
				sendQuery(query, function() {
					var jsonArray = JSON.parse(xmlhttp.responseText);
					var result="";
					for (var i = 0; i < jsonArray.result.length; i++) {
						result += "<li> <a href='kategori.jsp?id="+jsonArray.result[i]+"&laman=1'>"+kategori[jsonArray.result[i]-1] + "</a></l1>"; 
					}
					kategorilist.innerHTML = result;
				});
			}