<%-- 
    Document   : tambahitem
    Created on : Dec 3, 2013, 3:33:57 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Item Baru</title>
        <link rel="stylesheet" type="text/css" href="../styles/style.css">
        <script type="text/javascript" src="../scripts/adminpage.js"></script>
    </head>
    <body>
        <div id="header">
            <jsp:include page="headeradmin.jsp" />
        </div>
        <div><hr id="border"></div>
            <div id="profile-page-body">
                <h1>Input Item Baru</h1> <br />
                
                <div id ="newitem-detail">
                    Kategory<br /><br />
                    Nama Barang<br /><br />
                    Keterangan<br /><br /><br /><br />
                    Harga<br /><br />
                    Barang Tersedia<br /><br />
                    Gambar<br /><br />
                </div>

                <div id="newitem-form">
                    <form id="formedit" enctype="multipart/form-data" method="post" action="tambahitem">
                         : <select name="newkategori" id="newkategori">
                                                    <option value="1">Makanan</option>
                                                    <option value="2">Minuman</option>
                                                    <option value="3">Perawatan Anak-Anak</option>
                                                    <option value="4">Perawatan Pribadi</option>
                                                    <option value="5">Perlengkapan Rumah</option>
                        </select>
                        <br /> <br />
                         : <input type="text" id="editnama" name="newnama" /><br/><br/>
                         : <input type="text" id="editketerangan" name="newketerangan" form="formedit"><br/><br/>
                         : Rp. <input type="text" id="editharga" name="newharga"/>,00<br/><br/>
                         : <input type="text" id="editjumlah" name="newjumlah"/> buah<br/><br/>
                         : <input type="file" id="newgambar" name="newgambar"/><br /><br />
                         
                        <input type="submit" value="Input">

                    </form>
                </div>
                
            </div>

    </body>
</html>
