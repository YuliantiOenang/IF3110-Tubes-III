<%-- 
    Document   : profil
    Created on : Nov 27, 2013, 5:22:21 PM
    Author     : A46CB
--%>

<%@ page import="myfunction.function" %>
<%@ page import="myfunction.user" %>

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
<jsp:param name="pageTitle" value="Profil"/> 
</jsp:include> 

<% String uname = (String) session.getAttribute("user"); 
    user profil = new user();
    function func = new function();
    profil = func.getProfil(uname);
%>
<div class="section page">
			<div class="wrapper">
                            <a href="editprofile.jsp"><h1>Edit Profil</h1></a><hr />
				<h1>Profil</h1>
				<h2>Username : </h2>
				<%= profil.username %>
				<h2>Nama : </h2>
				<%= profil.nama %>
				<h2>No HP : </h2><%= profil.nohp %>
				<h2>Alamat : </h2><%= profil.alamat %>
				<h2>Provinsi : </h2><%= profil.provinsi %>
				<h2>Kota : </h2><%= profil.kota %>
				<h2>Kodepos : </h2><%= profil.kodepos %>
				<h2>Email : </h2><%= profil.email %>
                                <h2>Jumlah transaksi : </h2><%= profil.transaksi %>
			</div>
		</div>

<%@include file="footer.jsp" %>

