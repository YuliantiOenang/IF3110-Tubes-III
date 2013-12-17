<?php require SITEPATH . '/app/views/head.php' ?>

<body> 
    <?php require SITEPATH . '/app/views/header.php' ?>
    
    <div id="container">
        
        <h2>Profile</h2>
            <p>Username: <?php echo $customer['username'] ?> </p>
            <p>Email: <?php echo $customer['email'] ?> </p>
            <p>Fullname: <?php echo $customer['fullname'] ?> </p>
            <p>Handphone: <?php echo $customer['phone'] ?> </p>
            <p>Address: <?php echo $customer['address'] ?> </p>
            <p>City: <?php echo $customer['city'] ?> </p>
            <p>Province: <?php echo $customer['province'] ?> </p>
            <p>Post Code: <?php echo $customer['postcode'] ?> </p>
            <p>Number of Transaction: <?php echo $customer['transaction'] ?> </p>

        <form method="post" action="<?php echo SITEURL . "/profile/edit/" ?>">
             <button  class="btn">Edit</button>
        </form>
        
	</div>
</body>
</html>