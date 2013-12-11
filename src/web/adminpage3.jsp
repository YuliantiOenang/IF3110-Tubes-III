<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
<head>
<title>ADMIN: ID3 Sayur-mayur</title>
<script>
function prompt()
{
var x;
var r=confirm("Yakin ingin menghapus entri dengan ID ini?");
if (r==true)
  {
  <c:set var="id_barang" value=id_barang/>
  <sql:update dataSource="${snapshot}" var="count">
  DELETE FROM barang WHERE id_barang = id_barang
  <sql:param value="${id_barang}" />
  </sql:update>
  alert("Entri barang dihapus.");
  }
else
  {
  
  }

}
</script>
</head>
<body>
 
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/phpmyadmin/tubes2"
     user="root"  password=""/>
<sql:query dataSource="${snapshot}" var="result">
SELECT * from barang WHERE ID_kategori=3;
</sql:query>
<div>
ID 3 : Sayur-mayur<br>
</div>
<br>
<div>
 
<table border="1" width="100%">
<tr>
   <th>ID_barang</th>
   <th>ID_kategori</th>
   <th>Nama_barang</th>
   <th>Harga</th>
   <th>Satuan</th>
   <th>Deskripsi</th>
   <th>Jumlah_pembelian</th>
   <th>Jumlah_stok</th>
   <th>Nama_gambar</th>
   <th>Nama_gambar_thumb</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.id_barang}"/></td>
   <td><c:out value="${row.id_kategori}"/></td>
   <td><c:out value="${row.nama_barang}"/></td>
   <td><c:out value="${row.harga}"/></td>
   <td><c:out value="${row.satuan}"/></td>
   <td><c:out value="${row.deskripsi}"/></td>
   <td><c:out value="${row.jumlah_pembelian}"/></td>
   <td><c:out value="${row.jumlah_stok}"/></td>
   <td><c:out value="${row.nama_gambar}"/></td>
   <td><c:out value="${row.nama_gambar_thumb}"/></td>
</tr>
</c:forEach>
</table>
</div>
<div>
Modifikasi entri barang: ID <input type="text" id="IDmodify"> <button onclick="location.href='adminedit.jsp'">Execute</button>
</div>
<br>
<div>
Hapus entri barang: ID <input type="text" id="IDdelete"> <button onclick="prompt()">Execute</button>
</div>
<br>
<div>
Tambah entri barang <button onclick="location.href='adminadd.jsp'">Execute</button>
</div>
<div>
<a href='admindisplay.jsp'>Kembali ke menu utama admin</a>
</div>
</body>
</html>