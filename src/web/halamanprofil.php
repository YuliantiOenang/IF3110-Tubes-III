<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Profil</title>
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width; initial-scale=1.0" />
        <!-- <link rel="stylesheet" href="style.css" type="text/css"/> -->
        <script type="text/javascript" src="Profile.js"></script>

    </head>
    <body>
        <div class ="header" id="headerother">
                <p><a href="home.html" title="RuSerBa" target="blank">
             		<img src="image/logoPNG.png" alt="RuSerBa" title="Ruko Serba Ada" border="0"/>
         		</a></p>
				
                <!-- <a href="dashboard.html">PRODUCTS</a> -->
				<select>
						<option value="Select">PRODUCTS</option>
						<option value="product1">MosquitoMissile</option>
						<option value="product2">WaspMissile</option>
						<option value="product3">SilkwormMissile</option>
						<option value="product4">DragonflyMissile</option>
						<option value="product5">HornetMissile</option>
						<option value="product6">FirestormTorpedo</option>
				</select>
				<input type="text" name="search" class="sfield" value="" align = "right">
				<a href="javascript:win1()">LOGIN</a>
                <a href=>REGISTER</a>
                <a href=>SHOPPING BAG</a>
                <a href="index.html">Logout</a></p>
				</form>

		</div>
		<div class="body">
            <div class="profile">
                <p class="nama">Halaman Profil.</p>
                <input type="submit" id="editprofilebutton" value="Edit Profile" onclick="editProfile()">
                omgwat // @testing
                <div class="atributprofile">Nama Lengkap</div>
                    <div id="atributfullname">herp derper mk-IV</div>
                <br>
                
                <div class="atributprofile">Address</div>
                <div id="atributaddress">where  </div>
                <br>
                
                <div class="atributprofile">Provinsi</div>
                <div id="atributprovinsi"> omg</div>
                <br>
                <div class="atributprofile">Kota/Kabupaten</div>
                <div id="atributkota"> wtf</div>
                <br>
                <div class="atributprofile">Kode Pos</div>
                <div id="atributkodepos"> 999999</div>
                <br>
                <div class="atributprofile">No. HP</div>
                <div id="atributHP"> 12351235123</div>
                <br>

                <div class="atributprofile">Password</div>
                <div id="atributpassword">(tidak ditampilkan)</div>
                <br>
                <div class="atributprofile">Confirm Password</div>
                <div id="atributconfirmpassword">(tidak ditampilkan)</div>
            </div>  
    </body>

</html>
