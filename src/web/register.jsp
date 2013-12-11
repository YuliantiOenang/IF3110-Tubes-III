<%-- 
    Document   : register
    Created on : Nov 27, 2013, 1:53:03 AM
    Author     : A46CB
--%>

<%
String user = null;
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                userName = cookie.getValue();
            }
            if (cookie.getName().equals("JSESSIONID")) {
                sessionID = cookie.getValue();
            }
        }
    }
if((session.getAttribute("user") != null) || (userName !=null)){
    response.sendRedirect("index.jsp");
}
%>

<jsp:include page="header.jsp"> 
<jsp:param name="pageTitle" value="Register"/> 
</jsp:include> 
    <div class="section page">
    <div class="wrapper">
        <h1>Registration</h1>
        <form class="formreg" name="register" method="post" action="register">
            <label class="labelreg">Username</label>
            <input class="inputreg" type="text" name="username" oninput="validateUsername()" id="username">
            <span id="usernameInfo"></span>
            <label class="labelreg">Nama Lengkap</label>
            <input class="inputreg" type="text" name="namalengkap" id="namalengkap" oninput="validateNamaLengkap()">
            <span id="namaInfo"></span>
            <label class="labelreg">No Handphone</label>
            <input class="inputreg" type="text" name="nomor" id="nomor">
            <label class="labelreg">Alamat</label>
            <input class="inputreg" type="text" name="alamat" id="alamat">
            <label class="labelreg">Provinsi</label>
            <input class="inputreg" type="text" name="provinsi" id="provinsi">
            <label class="labelreg">Kabupaten/Kota</label>
            <input class="inputreg" type="text" name="kota" id="kota">
            <label class="labelreg">Kodepos</label>
            <input class="inputreg" type="text" name="kodepos" id="kodepos">
            <label class="labelreg">Email</label>
            <input class="inputreg" type="text" name="email" id="email" oninput="validateEmail()">
            <span id="emailInfo"></span>
            <label class="labelreg">Password</label>
            <input class="inputreg" type="password" name="password1" id="password1" oninput="validatePassword1()">
            <span id="password1Info"></span>
            <label class="labelreg">Confirm Password</label>
            <input class="inputreg" type="password" name="password2" id="password2" oninput="validatePassword2()">
            <span id="password2Info"></span>
            <input class="inputreg" type="submit" value="Register" id="submit" name="submit" class="register">
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>
