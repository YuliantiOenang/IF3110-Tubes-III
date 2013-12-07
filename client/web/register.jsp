<%-- 
    Document   : register.jsp
    Created on : Nov 25, 2013, 10:20:22 AM
    Author     : Ahmad Fauzan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/desktop.css">
        <script src='js/register.js'></script>
        <title>Registrasi</title>
    </head>
    <body>
        <div class='formcontainer'>
            <h2>Pendaftaran RuSerbA</h2>
            <br />
            <form id='registerform' method='post' action="RegisterServlet">
                <span class='formlabel'>Username</span><input type='text' name='username'><br />
                <span id='erroruser5' class='formerrortext'>Username paling sedikit 5 karakter</span>
                <span id='erroruser' class='formerrortext'>Username sudah digunakan</span><br />

                <span class='formlabel'>Kata sandi</span><input type='password' name='password'><br />
                <span id='errorpass' class='formerrortext'>Kata sandi paling sedikit 8 karakter</span>
                <span id='errorpassuser' class='formerrortext'>Kata sandi tidak boleh sama dengan username</span>
                <span id='errorpassemail' class='formerrortext'>Kata sandi tidak boleh sama dengan alamat email</span><br />

                <span class='formlabel'>Konfirmasi kata sandi</span><input type='password' name='confirm'><br />
                <span id='errorcpass' class='formerrortext'>Kata sandi tidak cocok</span><br />

                <span class='formlabel'>Nama lengkap</span><input type='text' name='name'><br />
                <span id='errorname' class='formerrortext'>Nama lengkap harus terdiri dari paling sedikit 2 kata</span><br />

                <span class='formlabel' class='formlabel'>Alamat email</span><input type='text' name='email'><br />
                <span id='erroremailformat' class='formerrortext'>Format alamat email salah</span>
                <span id='erroremail' class='formerrortext'>Alamat email sudah digunakan</span><br />

                <br />
                <input type='submit' name='submit' value='Daftarkan'>
            </form>
        </div>
    </body>
</html>
