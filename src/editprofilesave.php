<?php
if(isset($_POST['username'])){$username=$_POST['username'];}
if(isset($_POST['password'])){$password=$_POST['password'];}
if(isset($_POST['nama'])){$nama=$_POST['nama'];}
if(isset($_POST['nomorhp'])){$nomorhp=$_POST['nomorhp'];}
if(isset($_POST['alamat'])){$alamat=$_POST['alamat'];}
if(isset($_POST['provinsi'])){$provinsi=$_POST['provinsi'];}
if(isset($_POST['kota'])){$kota=$_POST['kota'];}
if(isset($_POST['kodepos'])){$kodepos=$_POST['kodepos'];}
if(isset($_POST['email'])){$email=$_POST['email'];}
if(isset($_FILES['foto'])){
    $file_name = $_FILES['foto']['name'];
    $file_tmp =$_FILES['foto']['tmp_name'];
}
if(file_exists("images/".$_FILES["foto"]["name"])){
	echo $_FILES["foto"]["name"] . " already exists. ";
}else{
    move_uploaded_file($_FILES["foto"]["tmp_name"],"images/". $_FILES["foto"]["name"]);
}
//meminta autentifikasi user dengan REST
$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/resteditprofile.php';
$curl = curl_init($service_url);
$curl_post_data = array(
        'username' => $username,
        'password' => $password,
		'nama' => $nama,
        'nomorhp' => $nomorhp,
		'alamat' => $alamat,
        'provinsi' => $provinsi,
		'kota' => $kota,
        'kodepos' => $kodepos,
		'email' => $email,
        'foto' => $file_name,
);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_POST, true);
curl_setopt($curl, CURLOPT_POSTFIELDS, $curl_post_data);
$curl_response = curl_exec($curl);
if ($curl_response === false) {
    $info = curl_getinfo($curl);
    curl_close($curl);
    die('error occured during curl exec. Additioanl info: ' . var_export($info));
}
curl_close($curl);
echo $curl_response;
?>