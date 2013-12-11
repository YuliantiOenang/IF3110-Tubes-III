<%-- 
    Document   : index
    Created on : Nov 30, 2013, 10:25:22 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="Class.GetConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>RuSerBa Online</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<script type="text/javascript" src="../scripts/index.js"></script>
		<script src="../scripts/calendar.js"></script>
		<link href="../styles/calendar.css" rel="stylesheet">
	</head>
	<body>
		<div id="header">
				<jsp:include page="header.jsp" />
		</div>
		<div id="index-page-body">
		<div id="index-body">
		<div id="left-body">
                        <% 
                            // Initiation
                            GetConnection getCon = new GetConnection();
                            Connection conn = getCon.getConnection();
                            Statement stt = conn.createStatement();

                            ResultSet rs;
                            int count = 0;
                        %>
                        
                        Makanan:
			<div id=\"user-result\">
                                    
                                    <%
                                    count = 0;
                                    String query = "SELECT goods_name,goods_sold,goods_ID FROM goods WHERE goods_category LIKE '%Makanan%' ORDER BY goods_sold DESC";
                                    
                                    rs = stt.executeQuery(query);
                        
                                               while (rs.next() && (count < 3)) { 
                                        out.println("<a href=\"detailbarang.jsp?namabarang=" + rs.getString("goods_name") + "&hasil=\"><img id=\"photo\" src=\"../image/goods/" + rs.getString("goods_ID") + ".jpg\" width=\"100\" height=\"120\"/></a>");
                                        count++;
                                    }
                                    %>
                        </div>
			
			Minuman:
			<div id=\"user-result\">
                                    <%
                                    count = 0;
                                    String query2 = "SELECT goods_name,goods_sold,goods_ID FROM goods WHERE goods_category LIKE '%Minuman%' ORDER BY goods_sold DESC";
                                    
                                    rs = stt.executeQuery(query2);
                                    
                                    while (rs.next() && (count < 3)) { 
                                        out.println("<a href=\"detailbarang.jsp?namabarang=" + rs.getString("goods_name") + "&hasil=\"><img id=\"photo\" src=\"../image/goods/" + rs.getString("goods_ID") + ".jpg\" width=\"100\" height=\"120\"/></a>");
                                        count++;
                                    }
                                    %>
			</div>
			
			Perawatan Anak-Anak:
			<div id=\"user-result\">
                                    <%
                                    count = 0;
                                    String query3 = "SELECT goods_name,goods_sold,goods_ID FROM goods WHERE goods_category LIKE '%Anak-Anak%' ORDER BY goods_sold DESC";
                                    
                                    rs = stt.executeQuery(query3);
                                    
                                    while (rs.next() && (count < 3)) { 
                                        out.println("<a href=\"detailbarang.jsp?namabarang=" + rs.getString("goods_name") + "&hasil=\"><img id=\"photo\" src=\"../image/goods/" + rs.getString("goods_ID") + ".jpg\" width=\"100\" height=\"120\"/></a>");
                                        count++;
                                    }
                                    %>
			</div>
			
			Perawatan Pribadi:
			<div id=\"user-result\">
                                    <%
                                    count = 0;
                                    String query4 = "SELECT goods_name,goods_sold,goods_ID FROM goods WHERE goods_category LIKE '%Perawatan Pribadi%' ORDER BY goods_sold DESC";
                                    
                                    rs = stt.executeQuery(query4);
                                    
                                    while (rs.next() && (count < 3)) { 
                                        out.println("<a href=\"detailbarang.jsp?namabarang=" + rs.getString("goods_name") + "&hasil=\"><img id=\"photo\" src=\"../image/goods/" + rs.getString("goods_ID") + ".jpg\" width=\"100\" height=\"120\"/></a>");
                                        count++;
                                    }
                                    %>
			</div>
			
			Perlengkapan Rumah:
			<div id=\"user-result\">
                                    <%
                                    count = 0;
                                    String query5 = "SELECT goods_name,goods_sold,goods_ID FROM goods WHERE goods_category LIKE '%Perlengkapan Rumah%' ORDER BY goods_sold DESC";
                                    
                                    rs = stt.executeQuery(query5);
                                    
                                    while (rs.next() && (count < 3)) { 
                                        out.println("<a href=\"detailbarang.jsp?namabarang=" + rs.getString("goods_name") + "&hasil=\"><img id=\"photo\" src=\"../image/goods/" + rs.getString("goods_ID") + ".jpg\" width=\"100\" height=\"120\"/></a>");
                                        count++;
                                    }
                                    %>
			</div>
		</div>
		<div id="right-body">
			Mekanisme Pembelian:</br>
			1.Mendaftar sebagai user.</br>
			2.Login.</br>
			3.Pilih barang yang dibeli serta jumlahnya.</br>
			4.Lihat barang yang dibeli pada cart.</br>
			5.Konfirmasi pembelian dengan mendaftar kartu kredit.</br>
			6.Barang yang anda pesan sudah dibeli dan akan diantar ke alamat anda.</br>
		</div>
		</div>
		</div>
	</body>
</html>

