<?php 
	include('conn.php');
	//if(isset($_SESSION['userid'])){
	//isset($_SESSION['efullname']) && isset($_SESSION['enohp']) && isset($_SESSION['ealamat']) && isset($_SESSION['eprovinsi']) && isset($_SESSION['ekabupaten']) && isset($_SESSION['ekodepos']) && isset($_SESSION['epassword'])
?>				
<article class="lifted_content_box">
		<h1>Edit Profil</h1>
		<div id="itemcontent">
			<form id="formeditprofil" class="styled" action="index.php" method="post" onsubmit="return checkEditProfil(this);">
		    <fieldset>
			  <!--<legend>Contact Form</legend>-->
			  <ol>
				<li class="form-row">
				  <label>Nama Lengkap:</label>
				  <input id="efullname" type="text" class="text-input required name default" name="efullname" value="<?php echo $_SESSION['efullname'];?>"/>
				</li>
				<li class="form-row">
				  <label>Phone:</label>
				  <input id="enohp" type="text" class="text-input required phone default" name="enohp" value="<?php echo $_SESSION['enohp'];?>"/>
				</li>
				<li class="form-row">
				  <label>Alamat:</label>
				  <textarea id="ealamat" class="text-area required alamat default" name="ealamat" cols="40" rows="8"><?php echo $_SESSION['ealamat'];?></textarea>
				</li>
				
				<li class="form-row">
				  <label>Provinsi:</label>
				  <input id="eprovinsi" type="text" class="text-input required provinsi default" name="eprovinsi" value="<?php echo $_SESSION['eprovinsi'];?>" />
				</li>
				<li class="form-row">
				  <label>Kabupaten:</label>
				  <input id="ekabupaten" type="text" class="text-input required kabupaten default" name="ekabupaten" value="<?php echo $_SESSION['ekabupaten'];?>" />
				</li>
				<li class="form-row">
				  <label>Kode pos:</label>
				  <input id="ekodepos" type="text" class="text-input required kodepos default" name="ekodepos" value="<?php echo $_SESSION['ekodepos'];?>" />
				</li>
				<li class="form-row">
				  <label>Password:</label>
				  <input id="epwd1" type="password" class="text-input required password default" name="epwd1" value="" />
				</li>
				<li class="form-row">
				  <label>Confirm Password:</label>
				  <input id="epwd2" type="password" class="text-input required cpassword default" name="epwd2" value="" />
				</li>
				<li class="button-row text-right">
				  <input class="btn-edit" type="submit" value="Update" name="btn-edit" />
				</li>
			  </ol>
			</fieldset>
		  </form>
		</div>
</article>

<script type="text/javascript"> 
	function checkPassword(str) 
	{ 
		//var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/; 
		var pwReg = /^[0-9a-zA-Z_-]{8,}$/;
		return pwReg.test(str); 
	} 
	function checkEditProfil(form) 
	{ 	
		var usrnm = "<?php echo $_SESSION['userid']; ?>";
		
		if(form.efullname.value == "") 
		{ 
			alert("Nama Lengkap tidak boleh kosong"); 
			form.efullname.focus(); return false; 
		} 
		if(form.enohp.value == "") 
		{ 
			alert("No HP tidak boleh kosong"); 
			form.enohp.focus(); return false; 
		} 
		if(form.ealamat.value == "") 
		{ 
			alert("Alamat tidak boleh kosong"); 
			form.ealamat.focus(); return false; 
		} 
		if(form.eprovinsi.value == "") 
		{ 
			alert("Provinsi tidak boleh kosong"); 
			form.eprovinsi.focus(); return false; 
		} 
		if(form.epwd1.value == "") 
		{ 
			alert("Password harus diisi"); 
			form.epwd1.focus(); return false; 
		} 
		if(form.epwd2.value == "") 
		{ 
			alert("Confirm Password harus diisi"); 
			form.epwd2.focus(); return false; 
		} 
		
		
		
		var nameReg = /^[a-zA-Z ]+\s+[a-zA-Z ]+$/;
		if(!nameReg.test(form.efullname.value)) 
		{ 
			alert("Nama lengkap minimal mengandung nama depan dan nama belakang"); 
			form.efullname.focus(); 
			return false; 
		} 
		if( usrnm == form.epwd1.value) 
		{ 
			alert("Username tidak boleh sama dengan password"); 
			form.epwd1.focus(); 
			return false; 
		}
		if(form.epwd1.value != "" && form.epwd1.value == form.epwd2.value) 
		{ 
			if(!checkPassword(form.epwd1.value)) 
			{ 
				alert("Password yang Anda masukkan tidak valid!"); 
				form.epwd1.focus(); 
				return false; 
			} 
		} 
		else 
		{ 
			alert("Tolong periksa password dan confirm password yang Anda masukkan"); 
			form.epwd1.focus(); 
			return false; 
		} 
		return true; 
	} 
</script>
