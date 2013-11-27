/**
 * 
 */
function confirmAll(){
				var username = document.forms['register']['username'].value;
				var password = document.forms['register']['password'].value;
				var repassword = document.forms['register']['repassword'].value;
				var namalengkap = document.forms['register']['fullname'].value;
				var hpnum = document.forms['register']['hpnum'].value;
				var address = document.forms['register']['address'].value;
				var province = document.forms['register']['province'].value;
				var kecamatan = document.forms['register']['kecamatan'].value;
				var postcode = document.forms['register']['postalcode'].value;
				var email = document.forms['register']['Email'].value;
				var emailRegexStr = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
				var isEmailValid = emailRegexStr.test(email);
				var fullNameRegexStr = /^[A-Z][a-z]+([\ ][A-Za-z]+)+$/;
				var isNameValid = fullNameRegexStr.test(namalengkap);
				var isValid = true;
				var button = document.getElementById('daftar');
					if(username.length<5){
						isValid= false;
					}	
					else if (password.length<8){
						isValid = false;
					}
					else if (password!=repassword){
						isValid = false;
					}
					else if (!isNameValid){
						isValid = false;
					}
					else if (!isEmailValid){
						isValid = false;
					}
					
					if(isValid){
						button.disabled = false;	
					}
					else{
						button.disabled = true;
					}
			}
		 	function verifRegis(){
		 		var username = document.forms['register']['username'].value;
				var password = document.forms['register']['password'].value;
				var repassword = document.forms['register']['repassword'].value;
				var namalengkap = document.forms['register']['fullname'].value;
				var hpnum = document.forms['register']['hpnum'].value;
				var address = document.forms['register']['address'].value;
				var province = document.forms['register']['province'].value;
				var kecamatan = document.forms['register']['kecamatan'].value;
				var postcode = document.forms['register']['postalcode'].value;
				var email = document.forms['register']['Email'].value;
				var reg_error = document.getElementById('reg_error');
				var data = "username="+username+"&password="+password+"&repassword="+repassword
							+"&namalengkap="+namalengkap+"&hpnum="+hpnum+"&address="+address+
							"&province="+province+"&kecamatan="+kecamatan+"&postcode="+postcode+
							"&email="+email;
				if(window.XMLHttpRequest){
					xmlhttp = new XMLHttpRequest();
				}
				else{
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.onreadystatechange=function(){
					if(xmlhttp.readyState==4&&xmlhttp.status==200){
						reg_error.innerHTML = xmlhttp.responseText;
						if(reg_error.innerHTML==""){
							//Handle SESSION & LOCAL STORAGE
							window.location = "registercreditcard.jsp";
						}
					}
				};
				xmlhttp.open("POST","verifyRegister",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send(data);
			}
		 	function checkUsername(fld){
				var err_username = document.getElementById("err_username");
				confirmAll();
				if(fld.value.length<5){
					err_username.innerHTML = "The username is invalid!";
					return false;
				}
				else{
					err_username.innerHTML = "";
					return true;
				}
			}
			function checkEmail(fld){
				var err_email = document.getElementById("err_email");
				var emailStr = fld.value;
				var emailRegexStr = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
				var isValid = emailRegexStr.test(emailStr);
				confirmAll();
				if(!isValid){
					err_email.innerHTML = "The Email Address is not Valid";
					return false;
				}
				else{
					err_email.innerHTML = "";
					return true;
				}
			}
			function checkFullName(fld){
				var err_fullname = document.getElementById("err_fullname");
				var fullNameStr = fld.value;
				var fullNameRegexStr = /^[A-Z][a-z]+([\ ][A-Za-z]+)+$/;
				var isValid = fullNameRegexStr.test(fullNameStr);
				confirmAll();
				if(!isValid){
					err_fullname.innerHTML= "The Full Name must be 2 words and only alphabets";
					return false;
				}
				else{
					err_fullname.innerHTML= "";
					return true;
				}
			}
			function checkPass(fld){
				var err_pass = document.getElementById("err_pass");
				confirmAll();
				if (document.forms['register']['password'].value == document.forms['register']['username'].value)
				{
					err_pass.innerHTML = "Password can not be the same with username";
					return false;
				}
				if (document.forms['register']['password'].value == document.forms['register']['Email'].value)
				{
					err_pass.innerHTML = "Password can not be the same with email";
					return false;
				}
				if(fld.value.length<8){
					err_pass.innerHTML = "Password must be longer than 8 characters";
					return false;
				}
				else{
					err_pass.innerHTML = "";
					return true;
				}
			}
			function confirmPassword(fld){
				var err_repass = document.getElementById("err_repass");
				var firstPass = document.forms['register']['password'].value;
				var nowPass = fld.value;
				confirmAll();
				if(firstPass!= nowPass){
					err_repass.innerHTML = "The Second Password is Different";
					return false;
				}
				else{
					err_repass.innerHTML = "";
					return true;
				}
			}