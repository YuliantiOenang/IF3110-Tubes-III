<%-- 
    Document   : adminpage
    Created on : Dec 2, 2013, 10:03:52 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" type="text/css" href="../styles/style.css">
        <script type="text/javascript" src="../scripts/adminpage.js"></script>
    </head>
    <body>
        <div id="header">
            <jsp:include page="headeradmin.jsp" />
        </div>
        <div><hr id="border"></div>
        
        <div id="admin-body">
            <% 
                // Initiation
                GetConnection getCon = new GetConnection();
                Connection conn = getCon.getConnection();
                Statement stt = conn.createStatement();

                ResultSet rs;
            %>
                                    
            <%
            out.println("<div id=\"admin-makanan\">");
              // Makanan
              out.println("<h1>MAKANAN</h1>");
              String query_makanan  = "SELECT * FROM goods WHERE goods_category LIKE '%Makanan%'";
              
              rs = stt.executeQuery(query_makanan);
              
              while(rs.next()) {
                    String path_image = "../image/goods/" + rs.getString("goods_ID") + ".jpg";
                    out.println("<div class=\"goods-category-body\">");
                    out.println("<div id=\"goods-result\">");
                        out.println("<div id=\"goods-image\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\"><img alt=\"image\" id=\"photo\" src=\" " + path_image + " \" width=\"100\" height=\"120\"/></a>");
                        out.println("</div>");

                        out.println("<div id=\"goods-detail\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\">" + rs.getString("goods_detail") + "</a>");
                            out.println("<br /> <br />");

                            out.println("Harga    : Rp. " + rs.getString("goods_price") + ",00<br />");
                            out.println("Tersedia : "  + rs.getString("goods_available") + " buah<br />");
                            out.println("Terjual : "  + rs.getString("goods_sold") + " buah<br />");
                            
                            out.println("<button onclick=\"confirmdelete('" + rs.getString("goods_name") +"')\">Delete Item</button>");
                            /*    out.println("<a href=\"#delete_button\"><button>Delete item</button></a>");
				out.println("<a href=\"#x\" class=\"overlay\" id=\"delete_button\"></a>");
                                out.println("<div class=\"popup\">");
                                    out.println("<h2>DELETE ITEM</h2>");
                                    out.println("Apakah anda yakin akan menghapus " + rs.getString("goods_name") + "?");
                                    out.println("<br /><br />");
                                    out.println("<a href=\"deleteitem?=namabarang=" + rs.getString("goods_name") + "\"><button>YES</button></a>");
                                    out.println("<a href=\"#close\"><button>NO</button></a>");
                                    out.println("<br />");
                                    out.println("<a class=\"close\" href=\"#close\"></a>");
                                out.println("</div>"); // */
                            
                        out.println("</div><br />");

                    out.println("</div>");
                    out.println("</div>");
              }
            out.println("</div>");
            %>
            
            <%
            out.println("<div id=\"admin-minuman\">");
              // Minuman
              out.println("<h1>MINUMAN</h1>");
              String query_minuman  = "SELECT * FROM goods WHERE goods_category LIKE '%Minuman%'";
              
              rs = stt.executeQuery(query_minuman);
              
              while(rs.next()) {
                    String path_image = "../image/goods/" + rs.getString("goods_ID") + ".jpg";
                    out.println("<div class=\"goods-category-body\">");
                    out.println("<div id=\"goods-result\">");
                        out.println("<div id=\"goods-image\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\"><img alt=\"image\" id=\"photo\" src=\" " + path_image + " \" width=\"100\" height=\"120\"/></a>");
                        out.println("</div>");

                        out.println("<div id=\"goods-detail\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\">" + rs.getString("goods_detail") + "</a>");
                            out.println("<br /> <br />");

                            out.println("Harga    : Rp. " + rs.getString("goods_price") + ",00<br />");
                            out.println("Tersedia : "  + rs.getString("goods_available") + " buah<br />");
                            out.println("Terjual : "  + rs.getString("goods_sold") + " buah");
                        out.println("</div><br />");

                    out.println("</div>");
                    out.println("</div>");
              }
            out.println("</div>");
            %>
            
            <%
            out.println("<div id=\"admin-anakanak\">");
              // PERAWATAN ANAK-ANAK
              out.println("<h1>PERAWATAN ANAK-ANAK</h1>");
              String query_anakanak  = "SELECT * FROM goods WHERE goods_category LIKE '%Anak%'";
              
              rs = stt.executeQuery(query_anakanak);
              
              while(rs.next()) {
                    String path_image = "../image/goods/" + rs.getString("goods_ID") + ".jpg";
                    out.println("<div class=\"goods-category-body\">");
                    out.println("<div id=\"goods-result\">");
                        out.println("<div id=\"goods-image\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\"><img alt=\"image\" id=\"photo\" src=\" " + path_image + " \" width=\"100\" height=\"120\"/></a>");
                        out.println("</div>");

                        out.println("<div id=\"goods-detail\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\">" + rs.getString("goods_detail") + "</a>");
                            out.println("<br /> <br />");

                            out.println("Harga    : Rp. " + rs.getString("goods_price") + ",00<br />");
                            out.println("Tersedia : "  + rs.getString("goods_available") + " buah<br />");
                            out.println("Terjual : "  + rs.getString("goods_sold") + " buah");
                        out.println("</div><br />");

                    out.println("</div>");
                    out.println("</div>");
              }
            out.println("</div>");
            %>
            
            <%
            out.println("<div id=\"admin-pribadi\">");
              // PERWATAN PRIBADI
              out.println("<h1>PERWATAN PRIBADI</h1>");
              String query_pribadi  = "SELECT * FROM goods WHERE goods_category LIKE '%Pribadi%'";
              
              rs = stt.executeQuery(query_pribadi);
              
              while(rs.next()) {
                    String path_image = "../image/goods/" + rs.getString("goods_ID") + ".jpg";
                    out.println("<div class=\"goods-category-body\">");
                    out.println("<div id=\"goods-result\">");
                        out.println("<div id=\"goods-image\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\"><img alt=\"image\" id=\"photo\" src=\" " + path_image + " \" width=\"100\" height=\"120\"/></a>");
                        out.println("</div>");

                        out.println("<div id=\"goods-detail\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\">" + rs.getString("goods_detail") + "</a>");
                            out.println("<br /> <br />");

                            out.println("Harga    : Rp. " + rs.getString("goods_price") + ",00<br />");
                            out.println("Tersedia : "  + rs.getString("goods_available") + " buah<br />");
                            out.println("Terjual : "  + rs.getString("goods_sold") + " buah");
                        out.println("</div><br />");

                    out.println("</div>");
                    out.println("</div>");
              }
            out.println("</div>");
            %>
            
            <%
            out.println("<div id=\"admin-rumahtangga\">");
              // PERLENGKAPAN RUMAH TANGGA
              out.println("<h1>PERLENGKAPAN RUMAH TANGGA</h1>");
              String query_rumahtangga  = "SELECT * FROM goods WHERE goods_category LIKE '%Rumah%'";
              
              rs = stt.executeQuery(query_rumahtangga);
              
              while(rs.next()) {
                    String path_image = "../image/goods/" + rs.getString("goods_ID") + ".jpg";
                    out.println("<div class=\"goods-category-body\">");
                    out.println("<div id=\"goods-result\">");
                        out.println("<div id=\"goods-image\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\"><img alt=\"image\" id=\"photo\" src=\" " + path_image + " \" width=\"100\" height=\"120\"/></a>");
                        out.println("</div>");

                        out.println("<div id=\"goods-detail\">");
                            out.println("<a href=\"editbarang.jsp?namabarang=" + rs.getString("goods_name") + "\">" + rs.getString("goods_detail") + "</a>");
                            out.println("<br /> <br />");

                            out.println("Harga    : Rp. " + rs.getString("goods_price") + ",00<br />");
                            out.println("Tersedia : "  + rs.getString("goods_available") + " buah<br />");
                            out.println("Terjual  : "  + rs.getString("goods_sold") + " buah");
                        out.println("</div><br />");

                    out.println("</div>");
                    out.println("</div>");
              }
            out.println("</div>");
            %>
            
            
        </div>
    </body>
</html>
