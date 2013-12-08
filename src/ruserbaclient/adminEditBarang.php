<?php
	require_once('header.php');
    $id = 17;
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				<script type="text/javascript" src="js/cekUnik.js"></script>

<hr>


<form id="editRefreshBarang" method="POST" onsubmit="return saveBarang()">
	<div class="register_div">
		<h1 class="header">Edit Barang</h1>
        <input type="hidden" name="id" value="<?=$id?>">
		<div class="per_form">
			<label>Nama</label>
			<input type="text" autocomplete="off" value="" name="nama_barang" onkeyup="cekUnik(this.value)" id="nama_barang"><span id="message"></span>
		</div>
		<div class="per_form">
			<label>Harga</label>
			<input type="text" value="" name="harga_barang">
		</div><!--
		<div class="per_form">
			<label>Gambar</label>
			<input type="file" name="file">
		</div> -->
		<button class="btn small full" name="submit" id="submitEditBarang" type="submit">Edit</button>
		<a class="btn small full" href="admin">Kembali</a>
	</div>
</form>
<script>
    function getBarangIdentity() {
        var form = document.getElementById("editRefreshBarang");
        var xmlEditBarangRequest;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlEditBarangRequest = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlEditBarangRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }
        
        xmlEditBarangRequest.onreadystatechange=function() {
            if (xmlEditBarangRequest.readyState==4 && xmlEditBarangRequest.status==200) {
                var data = JSON.parse(xmlEditBarangRequest.responseText);
                if(data.status === "success") {
                    form.nama_barang.value = data.nama_barang;
                    form.harga_barang.value = data.harga_barang;
                } else {
                    alert(data.status);
                }
            }
        }
        
        xmlEditBarangRequest.open("GET","http://localhost:8080/thelastruserba/admin/editbarang?id=" + form.id.value,true);
        xmlEditBarangRequest.send();
    }
    document.getElementById("submitEditBarang").disabled=true;
    getBarangIdentity();
    
    function saveBarang() {
        var form = document.getElementById("editRefreshBarang");
        var xmlEditBarangRequest;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlEditBarangRequest = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlEditBarangRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }
        
        xmlEditBarangRequest.onreadystatechange=function() {
            if (xmlEditBarangRequest.readyState==4 && xmlEditBarangRequest.status==200) {
                var data = JSON.parse(xmlEditBarangRequest.responseText);
                if(data.status === "updated") {
                    window.location.href = "http://localhost/ruserbaclient/adminIndex.php";
                } else {
                    alert(data.status);
                }
            }
        }
        
        xmlEditBarangRequest.open("POST","http://localhost:8080/thelastruserba/admin/editbarang",true);
        xmlEditBarangRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        var data_send = "id=" + form.id.value + 
            "&nama_barang=" + form.nama_barang.value +
            "&harga_barang=" + form.harga_barang.value;
        xmlEditBarangRequest.send(data_send);
        return false;
    }
</script>
			</div>
		</div>
		<?php
require_once('footer.php');
?>
