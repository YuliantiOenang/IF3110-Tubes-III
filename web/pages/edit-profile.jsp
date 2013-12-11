<%-- 
    Document   : edit-profile
    Created on : Dec 1, 2013, 2:06:31 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Class.GetConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Profile</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<script type="text/javascript" src="../scripts/edit-profile.js"></script>
	</head>
	<body>
                <%
                    // Get Session
                    String user_check = "";
                    String user_name = "";
                    if(request.getSession().getAttribute("user_check")==null){
                        user_check = "";
                    }else{
                        user_check  = request.getSession().getAttribute("user_check").toString();
                        user_name   = request.getSession().getAttribute("user_name").toString();
                    }
                %>
            
                <% 
                    // Get Database
                    GetConnection getCon = new GetConnection();
                    Connection conn = getCon.getConnection();
                    Statement stt = conn.createStatement();

                    ResultSet rs;
                    
                    String query = "SELECT * FROM userprofil WHERE profil_ID='" + user_check + "'";
                    
                    rs = stt.executeQuery(query);
                %>
                
                <!--Header-->
			<div id="header">
                            <jsp:include page="header.jsp" />
			</div>
			<!--Body-->
			<div id="profile-page-body">
				<h1>Edit Profil
                </h1>
				<div id="profil">
					Nama:<br /><br />
					Ganti Password:<br /><br />
					Konfirmasi Password:<br /><br />
					Alamat:<br /><br />
					Provinsi:<br /><br />
					Kabupaten:<br /><br />
					Kode Pos:<br /><br />
					No HP:<br /><br />
				</div>
				<div id="register-form">
				<form enctype="multipart/form-data" method="post" action="changeprofile">
					
                                    <% if (rs.next()) { %>
                                        <!--Name-->
					<div id="spacing-nama">
                                            <input type="text" id="gantinama" onKeyUp="check_nama(<% out.println("'" + rs.getString("profil_name") + "'"); %>)" name="textgantinama" value="<% out.println(rs.getString("profil_name")); %>" /> <div id="warning-nama"></div> <br /><br />
					</div>
					<!--Name-->
					<div id="spacing-password">
					<input type="password" id="gantipassword" onKeyUp="check_password(<% out.println("'" + rs.getString("profil_password") + "'"); %>)" name="textgantipassword" value="<% out.println(rs.getString("profil_password")); %>" /><div id="warning-password"></div> <br /><br />
					</div>
					<!--HP-->
					<div id="spacing-konfirmasipassord">
					<input type="password" id="konfirmasigantipassword" onKeyUp="check_confirmpassword()" name="textkonfirmasigantipassword"/><div id="warning-konfirmasi"></div> <br /><br />
					</div>
					<!--Alamat-->
					<div id="spacing-alamat">
					<input type="text" id="alamat" onKeyUp="check_alamat(<% out.println("'" + rs.getString("profil_address") + "'"); %>)" name="textalamat" value="<% out.println(rs.getString("profil_address")); %>" /><div id="warning-alamat"></div> <br /><br />
					</div>
					<!--Provinsi-->
					<div id="spacing-provinsi">
					<input type="text" id="provinsi" onKeyUp="check_provinsi(<% out.println("'" + rs.getString("profil_province") + "'"); %>)" name="textprovinsi" value="<% out.println(rs.getString("profil_province")); %>" /><div id="warning-provinsi"></div> <br /><br />
					</div>
					<!--Kabupaten-->
					<div id="spacing-kabupaten">
					<input type="text" id="kabupaten" onKeyUp="check_kabupaten(<% out.println("'" + rs.getString("profil_district") + "'"); %>)" name="textkabupaten" value="<% out.println(rs.getString("profil_district")); %>" /><div id="warning-kabupaten"></div> <br /><br />
					</div>
					<!--Pos-->
					<div id="spacing-pos">
					<input type="text" id="pos" onKeyUp="check_pos(<% out.println("'" + rs.getString("profil_zipcode") + "'"); %>)" name="textpos" value="<% out.println(rs.getString("profil_zipcode")); %>" /><div id="warning-pos"></div> <br /><br />
					</div>
					<div id="spacing-HP">
					<input type="text" id="HP" onKeyUp="check_HP(<% out.println("'" + rs.getString("profil_mobile") + "'"); %>)" name="textHP" value="<% out.println(rs.getString("profil_mobile")); %>" /><div id="warning-HP"></div> <br /><br />
					</div>
					<button id="create">Confirm Edit</button>
                                    <% } %>
				</form>
				<form method="post" action="profile.jsp"><input type="submit" value="Back" ></form>
				</div>

			</div>
	</body>
</html>
