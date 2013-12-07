<%-- 
    Document   : profile
    Created on : Nov 25, 2013, 3:51:08 PM
    Author     : Ahmad Fauzan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/desktop.css">
        <script src='js/profile.js'></script>
        <title>Profil</title>
    </head>
    <body>
        <% 
            if(session.getAttribute("user") == null ) {  
                    String redirectURL = "";
                    response.sendRedirect(redirectURL);
            } 
        %> 
        <jsp:useBean id="user" class="ruserba.beans.User" scope="session"> </jsp:useBean>
        <div class='formcontainer'>
            <h2 id='formtitle'>Profil <jsp:getProperty name="user" property="username"/> </h2>
            <br />
            <form id='formprofile' method='post' action='SaveProfileServlet'>
                <span class='formlabel'>Nama lengkap</span><input type='text' name='name'value = '<jsp:getProperty name="user" property="name"/>'><br />
                <span id='errorname' class='formerrortext'>Nama lengkap harus terdiri dari paling sedikit 2 kata</span><br />

                <span class='formlabel'>Kata sandi</span><input type='password' name='password' value='<jsp:getProperty name="user" property="password"/>'><br />
                <span id='errorpass' class='formerrortext'>Kata sandi paling sedikit 8 karakter</span>
                <span id='errorpassuser' class='formerrortext'>Kata sandi tidak boleh sama dengan username</span>
                <span id='errorpassemail' class='formerrortext'>Kata sandi tidak boleh sama dengan alamat email</span><br />

                <span class='formlabel'>Konfirmasi kata sandi</span><input type='password' name='confirm' value='<jsp:getProperty name="user" property="password"/>'><br />
                <span id='errorcpass' class='formerrortext'>Kata sandi tidak cocok</span><br />

                <span class='formlabel'>Alamat</span><input type='text' name='alamat' value="<jsp:getProperty name="user" property="alamat"/>"><br />
                <br />

                <span class='formlabel'>Kota/kabupaten</span><input type='text' name='kotakabupaten' value="<jsp:getProperty name="user" property="kota"/>"><br />
                <br />

                <span class='formlabel'>Kode pos</span><input type='text' name='kodepos' value="<jsp:getProperty name="user" property="kodepos"/>"><br />
                <span id='errorposint' class='formerrortext'>Format kode pos salah</span>
                <br />

                <span class='formlabel'>Provinsi</span><input type='text' name='provinsi' value="<jsp:getProperty name="user" property="provinsi"/>"><br />
                <br />

                <span class='formlabel'>Nomor ponsel</span><input type='text' name='nohp' value='<jsp:getProperty name="user" property="ponsel"/>'><br />
                <span id='errorjumlah' class='formerrortext'>Nomor ponsel tidak boleh melebihi 15 angka</span>
                <span id='errornoint' class='formerrortext'>Format nomor ponsel salah</span>
                <br />

                <br />
                <input type='submit' name='esubmit' value='Simpan'>
            </form>
        </div>
    </body>
</html>
