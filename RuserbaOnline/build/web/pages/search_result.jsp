<%-- 
    Document   : search_result
    Created on : Dec 1, 2013, 10:41:19 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page import="java.util.Iterator"%>
<%@page import="org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItemFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Class.GetConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Search Result</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css">
		<script type="text/javascript" src="../scripts/search_result.js"></script>
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
                
                <!--Header-->
			<div id="header">
                            <jsp:include page="header.jsp" />
			</div><hr id="border"></div>
			<!--Body-->
			<div id="search-result-body">
				<%
                                    int dataperpage = 10;
                                    int nopage      = 0;
                                    int mode        = 0;
                                    int sortmode    = 0;
                                    
                                    String text;
                                    String sortsearch = "";
                                    
                                    String pricemin = "";
                                    String pricemax = "";
                                    
                                    
                                    
                                    if (request.getParameter("page") == null) {
                                        nopage      = 1;
                                        if (request.getParameter("category") == null) {
                                            mode        = Integer.parseInt(request.getParameter("modesearch"));
                                            sortmode    = Integer.parseInt(request.getParameter("sortsearch"));
                                            
                                            if (sortmode == 1) {
                                                sortsearch = "ASC";
                                            } else {
                                                sortsearch = "DESC";
                                            }
                                            
                                            if (mode == 1) {
                                                text     = request.getParameter("search_text");
                                            } else {
                                                pricemin = request.getParameter("search_pricemin");
                                                pricemax = request.getParameter("search_pricemax");
                                                
                                                text     = pricemin + "*" + pricemax;
                                            }
                                        } else {
                                            text    = request.getParameter("category");
                                            mode    = 3;
                                        }
                                    } else {
                                        nopage      = Integer.parseInt(request.getParameter("page"));
                                        text        = request.getParameter("q");
                                        mode        = Integer.parseInt(request.getParameter("mod"));
                                        sortsearch  = request.getParameter("sort");
                                        if (mode == 2) {
                                            pricemin    = text.substring(0, text.indexOf("*"));
                                            if (text.endsWith("*")) {
                                                pricemax    = "";
                                            } else {
                                                pricemax    = text.substring(text.indexOf("*") + 1);
                                            }
                                        }
                                    }
                                    
/*                                    out.println("Mode\t: " + mode + "<br />");
                                    out.println("Text\t: " + text + "<br />");
                                    out.println("Pricemin\t: " + pricemin + "<br />");
                                    out.println("Pricemax\t: " + pricemax + "<br />"); // */
                                    
                                    int offset  = (nopage - 1) * dataperpage;
                                    
                                    GetConnection getCon = new GetConnection();
                                    Connection conn = getCon.getConnection();
                                    Statement stt = conn.createStatement();

                                    ResultSet rs;
                                    ResultSet counter;
                                    
                                    String query = "";
                                    String query_counter = "";
                                    
                                    switch(mode) {
                                        case 1:
                                            query = "SELECT * FROM goods " + 
                                                    "WHERE goods_detail LIKE '%" + text + "%' " +
                                                    "ORDER BY goods_name " + sortsearch + " " +
                                                    "LIMIT " + offset + ", " + dataperpage;
                                            
                                            query_counter   =  "SELECT COUNT(*) " +
                                                               "AS result_count " +
                                                               "FROM goods " +
                                                               "WHERE goods_detail LIKE '%" + text + "%'";
                                            
                                            break;
                                        case 2:
                                            if (pricemax == "") {
                                                query = "SELECT * FROM goods " + 
                                                        "WHERE goods_price > '" + pricemin + "' " +
                                                        "ORDER BY goods_price " + sortsearch + " " +
                                                        "LIMIT " + offset + ", " + dataperpage;
                                                
                                                query_counter   =  "SELECT COUNT(*) " +
                                                                   "AS result_count " +
                                                                   "FROM goods " +
                                                                   "WHERE goods_price > '" + pricemin + "'";
                                                } else {
                                                query = "SELECT * FROM goods " + 
                                                        "WHERE goods_price > '" + pricemin + "' AND goods_price < '" + pricemax + "' " +
                                                        "ORDER BY goods_price " + sortsearch + " " +
                                                        "LIMIT " + offset + ", " + dataperpage;                                                
                                                
                                                query_counter   =  "SELECT COUNT(*) " +
                                                                   "AS result_count " +
                                                                   "FROM goods " +
                                                                   "WHERE goods_price > '" + pricemin + "' AND goods_price < '" + pricemax + "'";
                                                }
                                            break;
                                        case 3:
                                            query = "SELECT * FROM goods " + 
                                                    "WHERE goods_category LIKE '%" + text + "%' " +
                                                    "ORDER BY goods_name " + sortsearch + " " +
                                                    "LIMIT " + offset + ", " + dataperpage;
                                            
                                            query_counter   =  "SELECT COUNT(*) " +
                                                               "AS result_count " +
                                                               "FROM goods " +
                                                               "WHERE goods_category LIKE '%" + text + "%'";
                                            break;
                                        
                                    }
                                    
                                    //out.println(query);
                                    
                                    int result_count = 0;

                                    counter = stt.executeQuery(query_counter);
                                    if (counter.next()) {
                                        result_count = counter.getInt("result_count");
                                    } // */
                                     
                                    rs = stt.executeQuery(query);
                                    
                                    while (rs.next()) {
                                        String path_image = "../image/goods/" + rs.getString("goods_ID") + ".jpg";
                                        out.println("<div class=\"goods-category-body\">");
                                        out.println("<div id=\"goods-result\">");
                                            out.println("<div id=\"goods-image\">");
                                                out.println("<a href=\"detailbarang.jsp?namabarang=" + rs.getString("goods_name") + "&hasil=\"><img alt=\"image\" id=\"photo\" src=\" " + path_image + " \" width=\"100\" height=\"120\"/></a>");
                                            out.println("</div>");
                                            
                                            out.println("<div id=\"goods-detail\">");
                                                out.println("<a href=\"detailbarang.jsp?namabarang=" + rs.getString("goods_name") + "&hasil=\">" + rs.getString("goods_detail") + "</a>");
                                                out.println("<br /> <br />");
                                                        
                                                out.println("Harga    : Rp. " + rs.getString("goods_price") + ",00<br />");
                                                out.println("Kategori : " + "<a href=\"search_result.jsp?category=" + rs.getString("goods_category") + "\">" + rs.getString("goods_category") + "</a>");
                                            out.println("</div><br />");
                                            
                                            out.println("<div id=\"goods-buy\">");
                                        
                                            out.println("</div>");
                                        out.println("</div>");
                                        out.println("</div>");
                                        
                                    }
                                    
                                    out.println("<div id=\"page-number\">");
                                    out.println("<center>");
                                    
                                    if (result_count > dataperpage) {
                                        int totalpage = (int)Math.ceil(((double)result_count / (double)dataperpage));
                                        
                                        if (nopage > 1) {
                                            out.println("<a href='?mod=" + mode + "&q=" + text + "&page=" + (nopage - 1) + "&sort=" + sortsearch + "'><< Prev</a>");
                                            
                                            out.println(" ");
                                        }
                                        
                                        for (int pages = 1; pages <= totalpage; pages++) {
                                            if (nopage == pages) {
                                                out.println(" ");
                                                out.println("<a href='#'>" + pages + "</a>");
                                            } else {
                                                out.println(" ");
                                                out.println("<a href='?mod=" + mode + "&q=" + text + "&page=" + pages + "&sort=" + sortsearch + "'>" + pages + "</a>");
                                            }
                                        }

                                        if (nopage < totalpage) {
                                            out.println(" ");
                                            out.println("<a href='?mod=" + mode + "&q=" + text + "&page=" + (nopage + 1) + "&sort=" + sortsearch + "'>Next >></a>");
                                        }                                                                                  
                                        //out.println(totalpage);
                                    } else {
                                        out.println("<a href='#'>" + 1 + "</a>");
                                    }
                                    
                                    out.println("<br /><br /></center>");
                                    out.println("</div>");
                                    
                                %>
			</div>
	</body>
</html>
