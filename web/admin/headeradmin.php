<div id="lightbox">	
		<div class="loginpoptop"><!--pop up-->
		<h4 id="loginHeader">LOGIN</h4>
		</div>
		<form id="test">
			<div class="forms">
			Username : <input type="text" id="user" required placeholder = "Username" /></br>
			</div>
			<div class="forms">
			Password : <input type="password" id="pass" required placeholder = "Password"></br>
			</div>
			<div class="forms">
			<input type="button" value="LogIn" onclick="login()"></input>
			<input type="button" value="Cancel" onclick="cancel()"></input>
			</div>
			<div class="error">
			<p id="Error"></p>
			</div>
			</form>

		</div>
<div class = "main">
	<div class = "header">
		
		<div class = "logohead">
			<div >
				<a href="homeadmin.php"><img src = "images/logo.png" class = "logo"></a>
				</img>
				</div>
			<div class = "loginplace">
				<div>                                
					<img src = "images/logout.png" class = "login" onclick="logout()" id="loginButton"></img>
				</div>
			</div>
        </div>

		<div class = "menu">
            <div class = "space"> 
				
			</div>
					
			<div class = "placetambahbarang" >
				
			</div>	
		</div>
		
		<div class = "main">
		</div>
	
</div>

<?php
		include "config/connect.php";
		
?>