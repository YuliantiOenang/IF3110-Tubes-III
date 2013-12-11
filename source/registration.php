<article class="lifted_content_box">
		<h1>Pendaftaran </h1>
		<div id="itemcontent">
			
			<form id="formdaftar" class="styled" action="sukses.php" method="post" onsubmit="return checkForm(this);">
		    <fieldset>
			  <!--<legend>Contact Form</legend>  -->
			  <ol>
				<li class="form-row">
				  <label>Username:</label>
				  <input type="text" name="userid" class="userid" autocomplete="off">
								<span class="check" style="color:red;" ></span><br>
				  <!--<input id="userid" type="text" class = "username" name="userid" autocomplete="off" value="" title="Masukkan Username Anda" />
				  -->
				</li>
				<li class="form-row">
				  <label>Nama Lengkap:</label>
				  <input id="fullname" type="text" class="text-input required name default" name="fullname" value="" title="Masukkan Nama Lengkap Anda" />
				</li>
			    <li class="form-row">
				  <label>Email:</label>
				  <input type="text" name="email" class="email" autocomplete="off">
             <span class="checkemail" style="color:red;" ></span>
				  <!--<input id="email" type="text" class="text-input required email default" name="email" value="" title="Masukkan Alamat E-mail Anda" onchange="if(this.value != '') callAjax('checkEmail', this.value, this.id); />
					 <span id="statusemail"></span>-->
				</li>
				<li class="form-row">
				  <label>Phone:</label>
				  <input id="nohp" type="text" class="text-input required phone default" name="nohp" value="" />
				</li>
				<li class="form-row">
				  <label>Alamat:</label>
				  <textarea id="alamat" class="text-area required alamat default" name="alamat" cols="40" rows="8"></textarea>
				</li>
				
				<li class="form-row">
				  <label>Provinsi:</label>
				  <input id="provinsi" type="text" class="text-input required provinsi default" name="provinsi" value="" />
				</li>
				<li class="form-row">
				  <label>Kabupaten:</label>
				  <input id="kabupaten" type="text" class="text-input required kabupaten default" name="kabupaten" value="" />
				</li>
				<li class="form-row">
				  <label>Kode pos:</label>
				  <input id="kodepos" type="text" class="text-input required kodepos default" name="kodepos" value="" />
				</li>
				<li class="form-row">
				  <label>Password:</label>
				  <input id="pwd1" type="password" class="text-input required password default" name="pwd1" value="" />
				</li>
				<li class="form-row">
				  <label>Confirm Password:</label>
				  <input id="pwd2" type="password" class="text-input required cpassword default" name="pwd2" value="" />
				</li>
				<li class="button-row text-right">
				  <input class="btn-submit" type="submit" value="Register" name="submit" id="submit" />
				</li>
			  </ol>
			</fieldset>
		  </form>
		</div>
</article>

	
<script type="text/javascript">


	function checkPassword(str) 
	{ 
		var pwReg = /^[0-9a-zA-Z_-]{8,}$/;
		return pwReg.test(str); 
	} 
	function checkForm(form) 
	{ 
		if(form.userid.value == "") 
		{ 
			alert("Username tidak boleh kosong"); 
			form.userid.focus(); return false; 
		} 
		if(form.fullname.value == "") 
		{ 
			alert("Nama Lengkap tidak boleh kosong"); 
			form.fullname.focus(); return false; 
		} 
		if(form.email.value == "") 
		{ 
			alert("E-mail tidak boleh kosong"); 
			form.email.focus(); return false; 
		} 
		if(form.nohp.value == "") 
		{ 
			alert("No HP tidak boleh kosong"); 
			form.nohp.focus(); return false; 
		} 
		if(form.alamat.value == "") 
		{ 
			alert("Alamat tidak boleh kosong"); 
			form.alamat.focus(); return false; 
		} 
		if(form.provinsi.value == "") 
		{ 
			alert("Provinsi tidak boleh kosong"); 
			form.provinsi.focus(); return false; 
		} 
		if(form.pwd1.value == "") 
		{ 
			alert("Password harus diisi"); 
			form.pwd1.focus(); return false; 
		} 
		if(form.pwd2.value == "") 
		{ 
			alert("Confirm Password harus diisi"); 
			form.pwd2.focus(); return false; 
		} 
		
		var unReg = /^[0-9a-zA-Z_]{5,}$/; 
		if(!unReg.test(form.userid.value)) 
		{ 
			alert("Username minimal 5 karakter"); 
			form.userid.focus(); 
			return false; 
		}
		
		var nameReg = /^[a-zA-Z ]+\s+[a-zA-Z ]+$/;
		if(!nameReg.test(form.fullname.value)) 
		{ 
			alert("Nama lengkap minimal mengandung nama depan dan nama belakang"); 
			form.fullname.focus(); 
			return false; 
		} 
		var emailReg = /^([\w-\.]+[\w-\.]+@+([\w-]+[\w-\.]+\.)+[\w-]{2,4})?$/;
		if(!emailReg.test(form.email.value)) 
		{ 
			alert("Email tidak valid"); 
			form.email.focus(); 
			return false; 
		} 
		if(form.userid.value == form.pwd1.value) 
		{ 
			alert("Username tidak boleh sama dengan password"); 
			form.pwd1.focus(); 
			return false; 
		}
		if(form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) 
		{ 
			if(!checkPassword(form.pwd1.value)) 
			{ 
				alert("Password yang Anda masukkan tidak valid! Minimal 8 karakter."); 
				form.pwd1.focus(); 
				return false; 
			} 
		} 
		else 
		{ 
			alert("Tolong periksa password dan confirm password yang Anda masukkan"); 
			form.pwd1.focus(); 
			return false; 
		} 
		return true; 
		} 
</script>

