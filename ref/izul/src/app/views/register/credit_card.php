<?php

/*** begin our session ***/
if (session_id() == '') session_start();

/*** set a form token ***/
$form_token = md5( uniqid('auth', true) );

/*** set the session form token ***/
$_SESSION['form_token'] = $form_token;
?>

<?php require SITEPATH . '/app/views/head.php' ?>

<body> 
    
        <?php require SITEPATH . '/app/views/header.php' ?>
    <div id="container">
		<form action="<?php echo SITEURL . '/register/new_creditcard' ?>" method="post">
            <h2>Credit Card Register</h2>
            <p>Registrasi sebelumnya sudah disimpan, jangan khawatir</p>
            <div class="form-group">
                <label for="card_name">Name in Card: </label>
                <input type="text" id="card_name" name="card_name" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="card_number">Card Number: </label>
                <input type="text" id="card_number" name="card_number" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="card_expired">Expired: </label>
                <input type="date" id="card_expired" name="card_expired" class="form-control"/>
            </div>
            <input type="hidden" name="form_token" value="<?php echo $form_token; ?>" />
            <button type="submit" class="btn">Register</button>
            <a href="<?php echo SITEURL?>">Skip</a>
        </form>
	</div>
</body>
</html>