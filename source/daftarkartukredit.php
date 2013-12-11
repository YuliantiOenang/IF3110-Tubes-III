<article class="lifted_content_box">
		<h1>Pendaftaran Kartu Kredit </h1>
		<div id="itemcontent">
			<form id="formdaftarkartukredit" class="styled" action="sukses.php" method="post" onsubmit="return checkForm(this);">
		    <fieldset>
			  <!--<legend>Contact Form</legend>-->
			  <ol>
				<li class="form-row">
				  <label>No Kartu:</label>
				  <input type="text" name="nokartu" id="nokartu" class="nokartu" autocomplete="off">
					<span class="checknokartu" style="color:red;" ></span> 
				  
				</li>
				<li class="form-row">
				  <label>Nama pada Kartu:</label>
				  
				  <input id="namakartu" type="text" class="namakartu" name="namakartu" value=""/>
				</li>
			    <li class="form-row">
				  <label>Tanggal Kadaluwarsa:</label>
				  <input id="tglkadaluwarsa" type="text" class="text-input required tanggal default" name="tglkadaluwarsa" value="" />
				</li>
				<li class="button-row text-right">
				  <input class="btn-ok" type="submit" value="OK" name="btn-ok" id="btn-ok" />
				 <!-- <input class="btn-skip" type="submit" value="Skip" name="btn-skip" />-->
				</li>
			  </ol>
			</fieldset>
		  </form>
		</div>
</article>
<script type="text/javascript"> 
	
	function checkForm(form) 
	{ 
		if(form.nokartu.value == "") 
		{ 
			alert("No Kartu Kredit tidak boleh kosong"); 
			form.nokartu.focus(); return false; 
		} 
		if(form.namakartu.value == "") 
		{ 
			alert("Nama tidak boleh kosong"); 
			form.namakartu.focus(); return false; 
		} 
		if(form.tglkadaluwarsa.value == "") 
		{ 
			alert("Tanggal kadaluwarsa tidak boleh kosong"); 
			form.tglkadaluwarsa.focus(); return false; 
		} 
		
		return true; 
	} 
</script>