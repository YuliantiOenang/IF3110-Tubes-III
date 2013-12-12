<%-- 
    Document   : cart
    Created on : Dec 1, 2013, 10:12:15 AM
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
		<title>Keranjang Belanja</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
	</head>
	<body onload="select()">
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
                    // Get Database
                    GetConnection getCon = new GetConnection();
                    Connection conn = getCon.getConnection();
                    Statement stt = conn.createStatement();

                    ResultSet rs;
                    
                    String query = "SELECT * FROM cart WHERE profil_ID='" + user_check + "'";
                    
                    rs = stt.executeQuery(query);
                    
                    int count = 0;
                    
                    if (rs.last()) {
                        count = rs.getRow();
                        rs.beforeFirst();

                    }
                    
                    //out.println(count);
                %>
                <!--Header-->
			<div id="header">
                            <jsp:include page="header.jsp" />
			</div>
			<!--Body-->
			<div id="cart-page-body">
				<div id="cart-header">
					<h1>Daftar Keranjang Belanja</h1>
				</div>
				
				<div id="cart-type">
					<%
                                            for (int i = 0; i < count; i ++ ) {
                                                out.println("Barang<br /><br />");
                                                out.println("Jumlah<br /><br />");
                                                out.println("Note<br /><br />");
                                                out.println("<br />");
                                            }
                                        %>
                                    					
                                        <%
                                            if (count == 0) {
                                                out.println("<div id=\"kosong\">");
                                                out.println("Keranjang Belanja Anda Kosong");
                                                out.println("</div>");
                                            } else {
                                                out.println("<form id=\"buttonbayar\" method=\"post\" action=\"checkkredit\"><input type=\"submit\" value=\"Bayar\" ></form>");
                                                out.println("<form id=\"buttoncancel\" method=\"post\" action=\"cancelcart\"><input type=\"submit\" value=\"Batal\" ></form>");
                                            }
                                        %>

				</div>
				
				<div id="cart-value">
					<%
                                            while(rs.next()) {
                                                out.println(" : " + rs.getString("cart_goods") + "<br /><br />");
                                                out.println(" : " + rs.getString("cart_count") + "<br /><br />");
                                                out.println(" : " + rs.getString("cart_note") + "<br /><br />");
                                                out.println("<br />");
                                            }
                                            rs.beforeFirst();
                                        %>

				</div>
				
				<div id="cart-cancel">
					<%
                                            while(rs.next()) {
                                                out.println("<br /><br />");
                                                out.println("<div id=\"cancel-good\">");
                                                out.println("<a href=\"cancelcart?namabarang=" + rs.getString("cart_goods") + "\">Batal</a>");
                                                out.println("</div>");
                                                out.println("<br /><br />");
                                                out.println("<br /><br />");
                                                //out.println("<br />");
                                            }                                        
                                        %>

				</div>
				
			</div>
	</body>
</html>
