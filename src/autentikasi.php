<?php
if(isset($_POST['username'])){$username=$_POST['username'];}
if(isset($_POST['password'])){$password=$_POST['password'];}
//meminta autentifikasi user dengan REST
$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restuser.php';
$curl = curl_init($service_url);
$curl_post_data = array(
        'username' => $username,
        'password' => $password,
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
$decoded = $curl_response;
echo $decoded;
?>