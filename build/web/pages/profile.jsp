<%-- 
    Document   : profil
    Created on : Dec 1, 2013, 1:50:19 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Class.GetConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Profile</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
	</head>
	<body onload="select()">
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
				<div id="profil">
					<% 
					out.println("Nama Lengkap<br /><br />");
                                        out.println("No HP<br /><br />");
                                        out.println("Alamat<br /><br />");
                                        out.println("Provinsi<br /><br />");
                                        out.println("Kabupaten<br /><br />");
                                        out.println("Kode Pos<br /><br />");
                                        out.println("Email<br /><br />");
                                        out.println("Transaksi<br /><br />");
                                        
					%>
					<form method="post" action="edit-profile.jsp"><input type="submit" value="Edit" ></form>
				</div>
				<div id="profil">
					<%
					if (rs.next()) {
                                            out.println(" : " + rs.getString("profil_name") + "<br /><br />");
                                            out.println(" : " + rs.getString("profil_mobile") + "<br /><br />");
                                            out.println(" : " + rs.getString("profil_address") + "<br /><br />");
                                            out.println(" : " + rs.getString("profil_province") + "<br /><br />");
                                            out.println(" : " + rs.getString("profil_district") + "<br /><br />");
                                            out.println(" : " + rs.getString("profil_zipcode") + "<br /><br />");
                                            out.println(" : " + rs.getString("profil_email") + "<br /><br />");
                                            out.println(" : " + rs.getString("profil_transaction") + "<br /><br />");
                                        }
					%>
				</div>
			</div>
	</body>
</html>
