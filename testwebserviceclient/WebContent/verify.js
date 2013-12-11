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
		 		alert('Masuk kok :v');
				var reg_error = document.getElementById('reg_error');
				var uquery = "SELECT * FROM user where username ='"+username+"'";
				var equery = "SELECT * FROM user where email ='"+email+"'";
				var regquery = "insert into `user` (`username`, `nama_lengkap`, `password`, `email`, `handphone`, `address`, `province`, `state`, `postcode`) VALUES ('"+username+"','"+namalengkap+"','"+password+"','"+email+"','"+hpnum+"','"+address+"','"+province+"','"+kecamatan+"','"+postcode+"')";
				reg_error.innerHTML = "";
				
				sendQuery(uquery, function() {
					var jsonArray = JSON.parse(xmlhttp.responseText);
					if(jsonArray.result.length > 0){
						reg_error.innerHTML = "The Username is Taken";
					}
				});
				sendQuery(equery, function() {
					var jsonArray = JSON.parse(xmlhttp.responseText);
					if(jsonArray.result.length > 0){
						if(reg_error.innerHTML.valueOf()== "")
							reg_error.innerHTML = "The Email is Taken";
						else reg_error.innerHTML = "The Username And Email is Taken";
					}
				});
				if(reg_error.innerHTML.valueOf() == ""){
					sendQuery(regquery, function() {
						var jsonArray = JSON.parse(xmlhttp.responseText);
						alert(jsonArray.result[0]);
						if(jsonArray.result[0] > -1){
							window.location = "registercreditcard.jsp";
						}
						else{
							reg_error.innerHTML = "Unable To add to Database";
						}
					});
				}
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