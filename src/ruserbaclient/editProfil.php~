<?php
	if (isset($_COOKIE['isLogin']))
	{
	require_once('header.php');
?>
    <div onload="RefreshCartandShow()" id="content_frame">
    <form id="editRefreshProfil" method="post" onsubmit="return sendEditProfil()">
	<div class="register_div">
		<h1 class="header">Edit Profile</h1>
		<div class="per_form">
			<label>Nama Lengkap</label><input type="text" onkeyup="Register.cekNama()" required="" id="nama" name="prof_nama" value="habibie faried">
			<span id="error-nama" class="error"></span>
		</div>
		<div class="per_form">
			<label>Username</label><input type="text" disabled="disabled" id="username" name="prof_username" value="habibie">
		</div>
		<div class="per_form">
			<label>Email</label><input type="text" disabled="disabled" id="email" name="prof_email" value="sdasdas@as.com">
		</div>
		<div class="per_form">
			<label>Password Baru</label><input type="password" onkeyup="Register.cekPassword()" id="password" name="prof_password" value="">
			<span id="error-password" class="error"></span>
		</div>
		<div class="per_form">
			<label>Confirm Pass.</label><input type="password" onkeyup="Register.cekConfirm()" id="confirm" name="prof_confirm" value="">
			<span id="error-confirm" class="error"></span>
		</div>
	</div>
	<div class="register_div">
		<div class="per_form">
			<label>Alamat</label><input type="text" required="" id="alamat" name="prof_alamat" value="Jl. pelesiran 6">
			<span id="error-alamat"></span>
		</div>
		<div class="per_form">
			<label>Provinsi</label>
			<select required="" id="provinsi" name="prof_provinsi">
				<option value="">Pilih Provinsi :</option>				
                <option>Aceh</option>
                <option>Bali</option>
                <option>Bangka Belitung</option>
                <option>Banten</option>
                <option>Bengkulu</option>
                <option>Gorontalo</option>
                <option>Jakarta</option>
                <option>Jambi</option>
                <option>Jawa Barat</option>
                <option>Jawa Tengah</option>
                <option>Jawa Timur</option>
                <option>Kalimantan Barat</option>
                <option>Kalimantan Selatan</option>
                <option>Kalimantan Tengah</option>
                <option>Kalimantan Timur</option>
                <option>Kepulauan Riau</option>
                <option>Lampung</option>
                <option>Maluku</option>
                <option>Maluku Utara</option>
                <option>Nusa Tenggara Barat</option>
                <option>Nusa Tenggara Timur</option>
                <option>Papua</option>
                <option>Papua Barat</option>
                <option>Riau</option>
                <option>Sulawesi Barat</option>
                <option>Sulawesi Selatan</option>
                <option>Sulawesi Tengah</option>
                <option>Sulawesi Tenggara</option>
                <option>Sulawesi Utara</option>
                <option>Sumatera Barat</option>
                <option>Sumatera Selatan</option>
                <option>Sumatera Utara</option>
                <option>Yogyakarta</option>
			</select>
			<span id="error-provinsi"></span>
		</div>
		<div class="per_form">
			<label>Kota</label><input type="text" required="" id="kota" name="prof_kota" value="kenangan">
			<span id="error-kota"></span>
		</div>
		<div class="per_form">
			<label>Kode Pos</label><input type="text" required="" id="kodepos" name="prof_kodepos" value="11111">
			<span id="error-kodepos"></span>
		</div>
		<div class="per_form">
			<label>Telepon</label><input type="text" required="" id="telepon" name="prof_telepon" value="08213121">
			<span id="error-telepon"></span>
		</div>
		<button class="btn" onclick="return Register.compareDefault()" id="btn" type="submit">Simpan</button>
	</div>
<script>
    function editRefreshProfil() {
        var form = document.getElementById("editRefreshProfil");
        var xmlHttpEditProfil;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlHttpEditProfil = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlHttpEditProfil = new ActiveXObject("Microsoft.XMLHTTP");
        }
        
        xmlHttpEditProfil.onreadystatechange=function() {
            if (xmlHttpEditProfil.readyState==4 && xmlHttpEditProfil.status==200) {
                var data = JSON.parse(xmlHttpEditProfil.responseText);
                form.prof_nama.value = data.nama;
                form.prof_username.value = data.username;
                form.prof_email.value = data.email;
                form.prof_alamat.value = data.alamat;
                form.prof_provinsi.value = data.provinsi;
                form.prof_kota.value = data.kota;
                form.prof_kodepos.value = data.kode_pos;
                form.prof_telepon.value = data.no_telp;
                if(Register != null)
                    for (var key in Register.validForm) {
                        if (Register.validForm.hasOwnProperty(key)) {
                            defaultForm[key] = document.getElementById(key).value;
                        }
                    }
            }
        }
        xmlHttpEditProfil.open("GET","http://localhost:8080/thelastruserba/profile/edit?username="+getCookie('username'),true);
		xmlHttpEditProfil.send();
    }
    function sendEditProfil()
    {
        var form = document.getElementById("editRefreshProfil");
        var xmlHttpEditProfil;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlHttpEditProfil = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlHttpEditProfil = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlHttpEditProfil.onreadystatechange=function() {
            if (xmlHttpEditProfil.readyState==4 && xmlHttpEditProfil.status==200) {
                var data = JSON.parse(xmlHttpEditProfil.responseText);
                if(data.status === "success")
                    window.location.href = "http://localhost/ruserbaclient/profil.php";
                else
                    alert("Something wrong...");
            }
        }
        xmlHttpEditProfil.open("POST","http://localhost:8080/thelastruserba/profile/edit",true);
        xmlHttpEditProfil.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        var data = "username=" + form.prof_username.value + 
            "&prof_nama=" + form.prof_nama.value + 
            "&prof_password=" + form.prof_password.value + 
            "&prof_alamat=" + form.prof_alamat.value + 
            "&prof_provinsi=" + form.prof_provinsi.value + 
            "&prof_kota=" + form.prof_kota.value + 
            "&prof_kodepos=" + form.prof_kodepos.value + 
            "&prof_telepon=" + form.prof_telepon.value;
		xmlHttpEditProfil.send(data);
        return false;
    }
    editRefreshProfil();
</script>
</form>


<script src="js/register.js"></script>
<script>
	var server = "";
	var defaultForm = {};
</script>
			</div>
		</div>
		<?php
		require_once('footer.php');
		}else
		{
			header("Location: register.php");
		}
		?>
