<%-- 
    Document   : detailbarang
    Created on : Dec 1, 2013, 2:40:32 AM
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
		<title>Detail Barang</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<script type="text/javascript" src="../scripts/detailbarang.js"></script>
	</head>
	<body>
                <%
                    // Get Session
                    String user_check = "";
                    if(request.getSession().getAttribute("user_check")==null){
                        user_check = "";
                    }else{
                        user_check  = request.getSession().getAttribute("user_check").toString();
                    }
                %>

                <% 
                    String namabarang = request.getParameter("namabarang");
                %>
                
                <% 
                    // Get Database
                    GetConnection getCon = new GetConnection();
                    Connection conn = getCon.getConnection();
                    Statement stt = conn.createStatement();

                    ResultSet rs;
                    
                    String query = "SELECT * FROM goods WHERE goods_name='" + namabarang + "'";
                    
                    rs = stt.executeQuery(query);
                    
                    if (rs.next()) {
                    
                %>

			<!--Header-->
			<div id="header">
                            <jsp:include page="header.jsp" />
			</div>
			<div><hr id="border"></div>
			<!--Body-->
			<div id="detail-body">
				<div id="detail-pic">
					<img alt="" id="photo" src="../image/goods/<% out.println(rs.getString("goods_ID") + ".jpg"); %>" width="120" height="150"/>
   					
					<br />
                                        <b><% out.println(namabarang); %></b></a>
				</div>
				<div id="main-detail">
					<div id="detail-information">
                                            
						<b>Keterangan</b><br />
						<% out.println(rs.getString("goods_detail")); %><br/><br/>
						<b>Harga</b><br />
						<% out.println("Rp. " + rs.getString("goods_price") + ",00"); %><br/><br/>
						<b>Stok</b><br />
						<% out.println(rs.getString("goods_available") + " buah"); %><br/><br/>
						<b>Pembelian</b><br />
                                                
                                                <form enctype="multipart/form-data" method="post" action="beli?namabarang=<% out.println(namabarang); %>">
							Notes :<input type="text" id="notes" name="textnotes" /><br />
							jumlah:<input type="text" id="jumlah" name="textjumlah" /><br />
							<input type="submit" value="Beli">
                                                        <% 
                                                            String hasil = request.getParameter("hasil");
                                                        %>
							<div id="warning-message"><% out.println(hasil); %></div>
						</form>
                                            <% }%>
					</div>
				</div>
			</div>
		
	</body>
</html>

