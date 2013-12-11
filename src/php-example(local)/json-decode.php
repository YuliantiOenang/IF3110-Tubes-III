<?php
	//next example will recieve all messages for specific conversation
	if (isset($_POST['username'])){
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check2.php?username='.$_POST['username'];
	}
	else if (isset($_GET['state'])){
		if ($_GET['state']==9){
			$service_url = 'http://destra.ap01.aws.af.cm/rest-delete-barang.php?id='.$_GET['id'];
		}
	}
	else if (isset($_POST['nama'])){
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check.php?nama='.$_POST['nama'];
	}
	else if (isset($_POST['buy'])){
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check.php?username='.$_POST['username'].'&buy='.$_POST['buy'];
	}
	else if (isset($_POST['id'])){
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check.php?id='.$_POST['id'];
	}
	else if (isset($_POST['username2'])){
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check.php?username='.$_POST['username2'];
	}
	else if (isset($_POST['email'])){
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check.php?email='.$_POST['email'];
	}
	else if (isset($_POST['card_number'])){
		$service_url = 'http://destra.ap01.aws.af.cm/add_credit_card.php?card_number='.$_POST['card_number'].'&username='.$_POST['username3'].'&expired_date='.$_POST['expired_date'].'&btn='.$_POST['btn'];
	}
	else if (isset($_POST['username4'])){
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check2.php?username2='.$_POST['username4'];
	}
	else if (isset($_POST['id2'])){
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check2.php?id2='.$_POST['id2'];
	}
	else if (isset($_POST['username6'])){
		$service_url = 'http://destra.ap01.aws.af.cm/rest-login-example.php?username='.$_POST['username6'].'&password='.$_POST['password'];
	}
	else if (isset($_POST['username7'])){
		$service_url = 'http://destra.ap01.aws.af.cm/rest-login-admin-example.php?username='.$_POST['username7'].'&password='.$_POST['password'];
	}
	else if (isset($_POST['bag'])){
		//$bag = json_decode($_POST['bag'], true);
		$service_url = 'http://destra.ap01.aws.af.cm/ajax_check.php?bag='.$_POST['bag'];
	}
	else if (isset($_POST['username5'])){
		for ($i=0; $i<mb_strlen($_POST['nama_lengkap']); $i++){
			if ($_POST['nama_lengkap']{$i}==' '){
				$_POST['nama_lengkap']{$i} = '+';
			}
		}
		for ($i=0; $i<mb_strlen($_POST['password']); $i++){
			if ($_POST['password']{$i}==' '){
				$_POST['password']{$i} = '+';
			}
		}
		for ($i=0; $i<mb_strlen($_POST['alamat']); $i++){
			if ($_POST['alamat']{$i}==' '){
				$_POST['alamat']{$i} = '+';
			}
		}
		for ($i=0; $i<mb_strlen($_POST['kota']); $i++){
			if ($_POST['kota']{$i}==' '){
				$_POST['kota']{$i} = '+';
			}
		}
		for ($i=0; $i<mb_strlen($_POST['provinsi']); $i++){
			if ($_POST['provinsi']{$i}==' '){
				$_POST['provinsi']{$i} = '+';
			}
		}
		$service_url = 'http://destra.ap01.aws.af.cm/update_account.php?username='.$_POST['username5'].'&password='.$_POST['password'].'&nama_lengkap='.$_POST['nama_lengkap'].'&handphone='.$_POST['handphone'].'&alamat='.$_POST['alamat'].'&provinsi='.$_POST['provinsi'].'&kodepos='.$_POST['kodepos'].'&kota='.$_POST['kota'];
	}
	else if (isset($_POST['id3'])){
		for ($i=0; $i<mb_strlen($_POST['namaB']); $i++){
			if ($_POST['namaB']{$i}==' '){
				$_POST['namaB']{$i} = '+';
			}
		}
		for ($i=0; $i<mb_strlen($_POST['kategori']); $i++){
			if ($_POST['kategori']{$i}==' '){
				$_POST['kategori']{$i} = '+';
			}
		}
		for ($i=0; $i<mb_strlen($_POST['deskripsi']); $i++){
			if ($_POST['deskripsi']{$i}==' '){
				$_POST['deskripsi']{$i} = '+';
			}
		}
		$service_url = 'http://destra.ap01.aws.af.cm/update_barang.php?id='.$_POST['id3'].'&nama='.$_POST['namaB'].'&kategori='.$_POST['kategori'].'&harga='.$_POST['harga'].'&stok='.$_POST['stok'].'&deskripsi='.$_POST['deskripsi'].'&path='.$_POST['path'];
	}
	else{
		if ($state == 0) $service_url = 'http://destra.ap01.aws.af.cm/rest-example.php';
		else if ($state == 1) $service_url = 'http://destra.ap01.aws.af.cm/rest-index-example.php';
		else if ($state < 0) {
			$pageid = ($state +1) * (-1);
			$service_url = 'http://destra.ap01.aws.af.cm/rest-detail-example.php?id='.$pageid;
		}
		else if (($state>=2)&&($state<=6)){
			$service_url = 'http://destra.ap01.aws.af.cm/rest-kategori-example.php?id='.$state;
		}
		else if ($state == 7){
			$service_url = 'http://destra.ap01.aws.af.cm/rest-search-example.php?nama='.$_POST['nama'];
		}
		else if ($state == 8){
			$service_url = 'http://destra.ap01.aws.af.cm/rest-index-admin-example.php';
		}
	}
	$curl = curl_init($service_url);
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
	$curl_response = curl_exec($curl);
	if ($curl_response === false) {
	    $info = curl_getinfo($curl);
	    curl_close($curl);
	    die('error occured during curl exec. Additioanl info: ' . var_export($info));
	}
	curl_close($curl);
	if (isset($_GET['state'])){
		if($_GET['state']==9){
			?>
			<script type="text/javascript">
				window.location="index-admin.php";
			</script>
			<?php
		}
		else if ($_GET['state']==10){
			?>
			<script type="text/javascript">
				window.location="index-admin.php";
			</script>
			<?php
		}
	}
	else if ((isset($_POST['username']))||(isset($_POST['id']))||(isset($_POST['username2']))||(isset($_POST['email']))||(isset($_POST['username4']))||(isset($_POST['bag']))||(isset($_POST['buy']))||(isset($_POST['username6']))||(isset($_POST['username7']))||(isset($_POST['nama']))||(isset($_POST['id2']))){
		$decoded = $curl_response;
		echo $decoded;
	}
	else if (isset($_POST['username5'])){
		$decoded = $curl_response;
		?>
			<script type="text/javascript">
				window.location="profile.php";
			</script>
		<?php
	}
	else if (isset($_POST['id3'])){
		$decoded = $curl_response;
		?>
			<script type="text/javascript">
				window.location="index-admin.php";
			</script>
		<?php
	}
	else if (isset($_POST['card_number'])){
		if ($_POST['btn']=="ok"){
			$decoded = $curl_response;
			if ($decoded == 1){
				?>
				<script type="text/javascript">
					window.location="index.php";
				</script>
			<?php
			}
			else {
				echo $decoded;
			}
		} else {
		?>
		<script type="text/javascript">
			window.location="index.php";
		</script>
		<?php	
		}
	}
	else{
		if (($state >= 0)||($state<=8)||($state < 0)){
			$decoded = json_decode($curl_response);
			if (isset($decoded->response->status) && $decoded->response->status == 'ERROR') {
	    		die('error occured: ' . $decoded->response->errormessage);
			}
		}
	}
?>