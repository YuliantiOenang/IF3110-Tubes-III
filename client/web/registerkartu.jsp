<%-- 
    Document   : registerkartu
    Created on : Nov 25, 2013, 11:15:16 AM
    Author     : Ahmad Fauzan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/desktop.css">
        <script src='js/registerkartu.js'></script>
        <title>Registrasi Kartu Kredit</title>
    </head>
    <body>
        <div class='formcontainer'>
            <h2>Pendaftaran Kartu Kredit</h2>
            <div id='skipregisterkartu'><a href='/ruserba'>Lewati tahap ini</a></div>
            <br />
            <br />
            <form id='formregisterkartu' method='post' action="RegisterKartuServlet">
                    <span class='formlabel'>Nomor kartu</span><input type='text' name='nokartu' maxlength='16'><br />
                    <br />

                    <span class='formlabel'>Nama pada kartu</span><input type='text' name='namakartu' maxlength='256'><br />
                    <br />

                    <span class='formlabel'>Tanggal kadaluarasa</span><input type='date' name='expiry'><br />
                    <br />

                    <input type='submit' name='submit' value='Daftarkan'>
            </form>
        </div>
    </body>
</html>
