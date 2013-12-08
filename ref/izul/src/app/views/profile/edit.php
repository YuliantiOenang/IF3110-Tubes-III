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
		<form action="<?php echo SITEURL . '/profile/update_customer' ?>" method="post">
            <h2>Edit Profile</h2>
            <div class="form-group">
                <label for="username">Username: <span id="username-info"></span></label>
                <input type="text" id="username" name="username"  maxlength="16" onkeyup="checkUsername()" class="form-control" value="<?php echo $customer['username'] ?>"/>
            </div>
            <div class="form-group">
                <label for="email">Email: <span id="email-info"></span></label>
                <input type="email" id="email" name="email"  maxlength="32" onkeyup="checkEmail()" class="form-control" value="<?php echo $customer['email'] ?>"/>
            </div>
            <div class="form-group">
                <label for="password">Password: <span id="password-info"></span></label>
                <input type="password" id="password" name="password"  maxlength="32" onkeyup="checkPassword()" class="form-control" value=""/>
            </div>
            <div class="form-group">
                <label for="confirm-password">Confirm Password: <span id="confirm-password-info"></span></label>
                <input type="password" id="confirm-password"  maxlength="32" onkeyup="checkConfirmPassword()" class="form-control" value=""/>
            </div>
            <div class="form-group">
                <label for="fullname">Fullname: <span id="fullname-info"></span> </label>
                <input type="text" id="fullname" name="fullname"  maxlength="64" onkeyup="checkFullname()" class="form-control" value="<?php echo $customer['fullname'] ?>"/>
            </div>
            <div class="form-group">
                <label for="phone">Handphone: </label>
                <input type="tel" id="phone" name="phone"  maxlength="16" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="address">Address: </label>
                <input type="text" id="address" name="address"  maxlength="128" class="form-control" value="<?php echo $customer['phone'] ?>"/>
            </div>
            <div class="form-group">
                <label for="city">City: </label>
                <input type="text" id="city" name="city"  maxlength="32" class="form-control" value="<?php echo $customer['city'] ?>"/>
            </div>
            <div class="form-group">
                <label for="province">Province: </label>
                <input type="text" id="province" name="province"  maxlength="32" class="form-control" value="<?php echo $customer['province'] ?>"/>
            </div>
            <div class="form-group">
                <label for="postcode">Post Code: </label>
                <input type="tel" id="postcode" name="postcode"  maxlength="5" class="form-control" value="<?php echo $customer['postcode'] ?>"/>
            </div>
            <input type="hidden" name="form_token" value="<?php echo $form_token; ?>" />
            <button type="submit" class="btn" disabled="true" id="register-button">Submit</button>
        </form>
	</div>

<script src="<?php echo SITEURL . '/include/js/register.js' ?>"></script>
</body>
</html>