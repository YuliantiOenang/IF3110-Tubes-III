<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/latihan.css"> <!--pemanggilan file css-->
<script src="js/AjaxCreateObject.js" language="javascript"></script>
<script src="js/function.js" language="javascript"></script>
<script type="text/javascript">

function startRead(evt) {  
  var file = document.getElementById('file').files[0];
  if(file){
    if(file.type.match("image.*"))
    {
    getAsImage(file);
   /*  alert("Name: "+file.name +"\n"+"Last Modified Date :"+file.lastModifiedDate); */
    }
    else
    {
    getAsText(file);
    alert("Name: "+file.name +"\n"+"Last Modified Date :"+file.lastModifiedDate);
    }
    }
    evt.stopPropagation();
    evt.preventDefault();
}

function startReadFromDrag(evt) {
    var file = evt.dataTransfer.files[0];
    if (file) {
        if (file.type.match("image.*")) {
            getAsImage(file);
            alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
        }
        else {
            getAsText(file);
            alert("Name: " + file.name + "\n" + "Last Modified Date :" + file.lastModifiedDate);
        }
    }
    evt.stopPropagation();
    evt.preventDefault();
}


function getAsText(readFile) {
        
  var reader = new FileReader();
  
  // Read file into memory as UTF-16      
  reader.readAsText(readFile, "UTF-8");
  
  // Handle progress, success, and errors
  reader.onprogress = updateProgress;
  reader.onload = loaded;
  reader.onerror = errorHandler;
}

function getAsImage(readFile) {
        
  var reader = new FileReader();
  
  // Read file into memory as UTF-16      
  reader.readAsDataURL(readFile);
  
  // Handle progress, success, and errors
  reader.onload = addImg;
}

function updateProgress(evt) {
  if (evt.lengthComputable) {
    // evt.loaded and evt.total are ProgressEvent properties
    var loaded = (evt.loaded / evt.total);
    
    if (loaded < 1) {
      // Increase the prog bar length
      // style.width = (loaded * 200) + "px";
    }
  }
}


function errorHandler(evt) {
  if(evt.target.error.name == "NotReadableError") {
    // The file could not be read
  }
}

function addImg(imgsrc){
 var img = document.createElement('img');
  img.setAttribute("src",imgsrc.target.result);
  img.setAttribute("height","300");
  img.setAttribute("width","300");
  document.getElementById("output").insertBefore(img);
}

  var dropingDiv = document.getElementById('draghere');
  dropingDiv.addEventListener('dragover', domagic, false);
  dropingDiv.addEventListener('drop', startReadFromDrag, false);

</script>
</head>

<meta charset=utf-8 />
<body>
	<?php include "headeradmin.php"; ?>
<div class = "bodymain">
	<div class = "sidebar">
		
			<p class = "searchtitle"> Search it! </p>
		<form action="hasilsearch.php" method="get">
		<div class = "kategori">
			<select name="kategori">
				<option value="all">All</option>
				<option value="Jaket">Jacket</option>
				<option value="TShirt">T-shirt</option>
				<option value="Sweater">Sweater</option>
				<option value="Misc">Misc.</option>
				<option value="Pokemon">Pokemon</option>
			</select>
			<input type="text" id="user" name="key" required placeholder = "e.g. Mylo Xyloto" onkeyup="suggestSearch(this.value)" /></br>
	</div>
	
	<div class = "kategori">
	<label> Price Range: </label>
	<select name="range">
				<option value=1>< Rp50.000 </option>
				<option value=2>Rp50.000 - Rp100.000</option>
				<option value=3>Rp100.001 - Rp150.000</option>
				<option value=4>> Rp150.000</option>
				
			</select>
	</div>
	<div class = "kategori">
	<input type="submit" value="Search!"></input>
	</div>
	<label>Suggestion : <br><span id="search_suggestion" onclick="copySuggest()"></span></label>
	</form>
	</div>
	<div class = "boddy">
		<div class = "topfivetitle">
		<h1 id = "loginHeader"> TAMBAH BARANG</h1></br></br>
		</div>
		
			<div class = "registerspace">
			
			<form method="post" ACTION="insert.php" name="uploadForm"> 
		
				<label>Nama Barang </label> 
				<input type="text"  name ="nama_barang" id="nama_barang" onkeyup="checkSubmit()" required placeholder = "e.g. Pintu Kemana Saja" />
						
				</br></br>
				<label>Kategori Barang</label> 
				<select name="kategori_barang">
					<option value="Jaket">Jacket</option>
					<option value="TShirt">T-shirt</option>
					<option value="Sweater">Sweater</option>
					<option value="Misc">Misc.</option>
					<option value="Pokemon">Pokemon</option>
				</select>
						
				</br></br>
				<label>Jumlah Barang</label> 
				<input type="text" id="jumlah_barang" name="jumlah_barang" onkeyup="checkSubmit()" required placeholder = "1000" />

				</br></br>
				<label>Harga Barang</label> 
				<input type="text" id="harga_barang" name="harga_barang" onkeyup="checkSubmit()" required placeholder = "100000" />	
						
				</br></br>
				<label>Deskripsi Barang</label> 
				<textarea name="deskripsi_barang" rows = 3 cols = 35> Deskripsi Barang </textarea><br><br>
								
				<input type="submit" name="Submit" value="Submit"> 
				<input type="reset" name="Reset" value="Reset"> 
				<br><br>
			
			</form>
			
			<fieldset>      

					<legend>Upload Gambar Barang</legend>       

					<div id = "output" >
						
					</div>						
					<br>	
						
					<form method="post" ACTION="upload_foto_barang.jsp" name="uploadForm" ENCTYPE='multipart/form-data'> 

						<input type="file" name="uploadFile" id='file' onchange="startRead()"/> 
						<input type="submit" name="Submit" value="Submit"> 
						<input type="reset" name="Reset" value="Reset"> 

					</form>

			</fieldset>
			
			</div>
		  
	</div>
			
</div>
			
			
			
	
	<div class = "footer">
		<div class = "info">

		</div>
		
				
		
	</div>
</div>
</body>
</html>