<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
<head>
<title>Modifikasi Daftar Barang</title>
</head>
<body>
<div>
Pilih bagian yang ingin diedit, tanda * berarti wajib diisi
</div>
<br><div>
ID Barang: <input type="text" id="id_barang" required> <br>
ID Kategori: <input type="text" id="id_kategori" required> <br>
Nama Barang: <input type="text" id="nama_barang" required> <br>
Harga: <input type="text" id="harga" required> <br>
Satuan: <input type="text" id="satuan"> <br>
Deskripsi: <input type="text" id="deskripsi"> <br>
Jumlah Pembelian: <input type="text" id="jumlah_pembelian"> <br>
Jumlah Stok: <input type="text" id="jumlah_stok"> <br>
Nama Gambar: <input type="text" id="nama_gambar"> <br>
Nama Thumbnail: <input type="text" id="nama_gambar_thumb"> <br>
</div>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/phpmyadmin/tubes2"
     user="root"  password=""/>
 
<c:set var="id_barang" value=id_barang/>
 
<sql:update dataSource="${snapshot}" var="count">
  UPDATE barang SET id_barang = id_barang, id_kategori=id_kategori, nama_barang=nama_barang,harga=harga,satuan=satuan,deskripsi=deskripsi,jumlah_pembelian=jumlah_pembelian,jumlah_stok=jumlah_stok,nama_gambar=nama_gambar,nama_gambar_thumb=nama_gambar_thumb;
  <sql:param value="${id_barang}" />
</sql:update>
<div>
<button onclick="location.href='admindisplay.jsp'">Execute</button>
</div>
</body>
</html>