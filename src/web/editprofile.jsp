<%-- 
    Document   : editprofile
    Created on : Nov 27, 2013, 5:59:38 PM
    Author     : A46CB
--%>

<%
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
                                        if ((session.getAttribute("user") != null) || (userName != null)) {
                                   
                                            if (session.getAttribute("user") == null) {
                                                session.setAttribute("user", userName);
                                            }
                                          } else { 
                                            response.sendRedirect("index.jsp");
                                       } %>

<jsp:include page="header.jsp"> 
<jsp:param name="pageTitle" value="Edit Profile"/> 
</jsp:include> 
    <div class="section page">
    <div class="wrapper">
        <h1>Edit Profile</h1>
        <form class="formreg" name="register" method="post" action="editprofile">
            <input type="hidden" name="userlama" value="<%= (String) session.getAttribute("user") %>" >
            <span id="usernameInfo"></span>
            <label class="labelreg">Nama Lengkap</label>
            <input class="inputreg" type="text" name="namalengkap" id="namalengkap" oninput="validateNamaLengkap2()">
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
            <input class="inputreg" type="text" name="email" id="email" oninput="validateEmail2()">
            <span id="emailInfo"></span>
            <label class="labelreg">Password</label>
            <input class="inputreg" type="password" name="password1" id="password1" oninput="validatePassword12()">
            <span id="password1Info"></span>
            <label class="labelreg">Confirm Password</label>
            <input class="inputreg" type="password" name="password2" id="password2" oninput="validatePassword22()">
            <span id="password2Info"></span>
            <input class="inputreg" type="submit" value="Save" id="submit" name="submit" class="register">
        </form>
    </div>
</div>
<%@include file="footer.jsp" %>

