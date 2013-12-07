<%-- 
    Document   : headeradmin
    Created on : Dec 2, 2013, 10:20:30 PM
    Author     : Mahdan Ahmad F A
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Header</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<link href="../styles/modal.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../scripts/headeradmin.js"></script>
	</head>
	<body onLoad="initialize()">
                <%
                /*session management  */
                String user_check = "";
                String user_name = "";
                if(request.getSession().getAttribute("user_check")==null){
                    user_check = "";
                }else{
                    user_check  = request.getSession().getAttribute("user_check").toString();
                    user_name   = request.getSession().getAttribute("user_name").toString();
                }
                %>		
                
		<div id="header-left-side"><a href="adminpage.jsp"><img src="../image/logo.png" width="222px" height="60px"/></a>
                    
		</div>
		
                <div id="signature"><h1>Admin Page!</h1> </div>
                
		<div id="header-right-side">
			<div id="header-right-search">
                        <div id="login">
					Welcome, <% out.println(user_name); %>
				</div>			
				
				<div id="logout">
					<input type="button" value="LOGOUT" onclick="window.location.href='logout'; return false;" />
					 
				</div>    
                                
                                <div>
                                        <a href="tambahitem.jsp"/>Tambah Item</a>
                                </div>
                                
			</div>
		</div>
	</body>
</html>