<%-- 
    Document   : header
    Created on : Nov 30, 2013, 10:23:29 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Header</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<link href="../styles/modal.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../scripts/header.js"></script>
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
                
		<div id="header-left-side"><a href="index.jsp"><img src="../image/logo.png" width="222px" height="60px"/></a>
			<div id="header-bottom-side">
				<div id="space"><a href="search_result.jsp?category=makanan">Makanan</a></div>
				<div id="space"><a href="search_result.jsp?category=minuman">Minuman</a></div>
				<div id="space"><a href="search_result.jsp?category=anak">Perawatan Anak-Anak</a></div>
				<div id="space"><a href="search_result.jsp?category=pribadi">Perawatan Pribadi</a></div>
				<div id="space"><a href="search_result.jsp?category=rumah">Perlengkapan Rumah</a></div>
			</div>
		</div>
		
		<div id="header-right-side">
			<div id="header-right-search">
				<form action="search_result.jsp" method="post">
					<select name="modesearch" id="modesearch" onChange="filter()">
						<option value="1">Nama Barang</option>
						<option value="2">Harga</option>
					</select> 
					<input type="text" name="search_text" id="search_text" list="searching-auto" value=""" />
					<input type="text" name="search_pricemin" id="search_pricemin" list="searching-auto" style="display: none;" value=""" />
					<input type="text" name="search_pricemax" id="search_pricemax" list="searching-auto" style="display: none;" value=""" />
                                        <select name="sortsearch" id="sortsearch">
                                                <option value="1">ASC</option>
                                                <option value="2">DESC</option>
                                        </select>
                                        <input type="submit" value="Search"/>
					<div id="list-search"></div> 

				</form>
            
			<% if(user_check == "") { %>
                        	
				<div id="login">
					<div id="add-category"><a href="#login_button"><button>LOGIN</button></a>&nbsp;
					
					</div>				
					<!-- popup form #1 -->
                                                <a href="#x" class="overlay" id="login_button"></a>
                                                <div class="popup">
                                                        <h2>Login</h2>
                                                        <br />
                                                        <form enctype="multipart/form-data" action="checklogin" method="post">
                                                        <div>
                                                                <label for="login">Username :</label>
                                                                <input type="text" id="loginusername" value="" name="username"/>
                                                        </div>
                                                        <div>
                                                                <label for="asignee">Password : </label>
                                                                <input type="password" id="loginPassword" value="" name="password"/>
                                                        </div>
                                                        <div>
                                                                <input type="submit" value="Login"/>
                                                                <a href="register.jsp">Register</a>
                                                        </div>
                                                        </form>

                                                        <a class="close" href="#close"></a>
                                                </div>
					
				</div>
			<% } else {%>
                        <div id="login">
					Welcome, <a href="profile.jsp"><% out.println(user_name); %></a>
				</div>			
				
				<div id="logout">
					<input type="button" value="LOGOUT" onclick="window.location.href='logout'; return false;" />
					 <a href="cart.jsp">Keranjang Belanja</a>
				</div>    
                        
                        <% }%>

			</div>
		</div>
	</body>
</html>