<%@include file="/include/header.jsp" %>
<h1>Pendaftaran Pelanggan</h1>
<form id="pendaftaran" method="post" onSubmit="return submitPendaftaran(this)">
    <h2>Data untuk login</h2>
    <p><label>Username</label>: <input type="text" name="nama_pengguna" size="40" onKeyUp="pendaftaranUsername(this)"></p>
    <p><label>Password</label>: <input type="password" name="katasandi_1" size="40" onKeyUp="pendaftaranPassword(this)"></p>
    <p><label>Confirm Password</label>: <input type="password" name="katasandi_2" size="40" onKeyUp="pendaftaranConfirmPassword(this)"></p>
    <h2>Identitas Pelanggan</h2>
    <p><label>Nama Lengkap</label>: <input type="text" name="nama_lengkap" size="40" onKeyUp="pendaftaranFullName(this)"></p>
    <p><label>E-mail</label>: <input type="text" name="email" size="40" onKeyUp="pendaftaranEmail(this)"></p>
    <p><label>&nbsp;</label>&nbsp; <input type="submit" name="submit" value="Buat Akun" disabled="disabled"></p>
</form>
<%@include file="/include/footer.jsp" %>