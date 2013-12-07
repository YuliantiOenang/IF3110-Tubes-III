<%-- 
    Document   : editbarang
    Created on : Dec 2, 2013, 11:18:39 PM
    Author     : Mahdan Ahmad F A
--%>

<%@page import="Class.GetConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Edit Barang</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<script type="text/javascript" src="../scripts/editbarang.js"></script>
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
                            <jsp:include page="headeradmin.jsp" />
			</div>
			<div><hr id="border"></div>
			<!--Body-->
			<div id="detail-body">
				<div id="detail-pic">
                                    <img alt="" id="photo" src="../image/goods/<% out.println(rs.getString("goods_ID") + ".jpg"); %>" width="120" height="150"/>
   					
                                    <br /><br />
                                    <div id="detail-upload">
                                        <form action="uploadimage?ID=<% out.println(rs.getString("goods_ID")); %>" method="post" enctype="multipart/form-data">
                                        <input type="file" name="filename" /> <br />
                                        <input type="submit" value="Ubah Gambar" />
                                        </form>
                                    </div>  
				</div>
                                    
				<div id="main-detail">
					<div id="detail-information">
                                            
                                             <form id="formedit" enctype="multipart/form-data" method="post" action="edititem?namabarang=<% out.println(namabarang); %>">
                                                    <b>Nama Barang</b><br />
                                                    <input type="text" id="editnama" name="editnama" value="<% out.println(rs.getString("goods_name")); %>"/><br/><br/>
                                                    <b>Keterangan</b><br />
                                                    <textarea id="editketerangan" name="editketerangan" form="formedit"><% out.println(rs.getString("goods_detail")); %></textarea><br/><br/>
                                                    <b>Harga</b><br />
                                                    Rp. <input type="text" id="editharga" name="editharga" value="<% out.println(rs.getString("goods_price")); %>"/>,00<br/><br/>
                                                    <b>Stok</b><br />
                                                    <input type="text" id="editjumlah" name="editjumlah" value="<% out.println(rs.getString("goods_available"));%>"/> buah<br/><br/>
                                                    
                                                    <input type="submit" value="Edit">
                                                
                                            </form>
                                            <% }%>
					</div>
				</div>
			</div>
		
	</body>
</html>
