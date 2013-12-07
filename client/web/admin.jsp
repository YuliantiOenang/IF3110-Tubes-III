<%-- 
    Document   : admin
    Created on : Nov 25, 2013, 4:01:08 PM
    Author     : Ahmad Fauzan
--%>

<%@page import="ruserba.beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="ruserba.database.DatabaseHelper"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/desktop.css">
        <script src='js/admin.js'></script>
        <title>Admin Page</title>
    </head>
    <body>
        <% 
            if(session.getAttribute("user") == null || !((User) session.getAttribute("user")).getUsername().equalsIgnoreCase("admin")) {  
                    String redirectURL = "";
                    response.sendRedirect(redirectURL);
            } 
        %> 
        <div id="popup">
            <span id="warning">Do you want to delete it ? </span>
            <form id="formdelete" method="post" action="DeleteItemServlet">
                <input type ="hidden" value="" name="id_popup" id="id_popup" />
                <input type ="submit" value="yes"/>
            </form>
            <button onclick="closePopup()">No</button>
        </div>
        <%
            String query = "select * from kategori";
            DatabaseHelper.Connect();
            ResultSet result = DatabaseHelper.executeQuery(query);
            while (result.next()) {
        %>
        <div class ="main">
            <span class='category'>
                <img src='assets/icon_recommend.png' height='16'/> <a href='/ruserba/kategori/<%= result.getInt("id_kategori") %>'><%= result.getString("nama_kategori") %></a>
            </span><br/><br/>
            <div class = "bottom" >
                <%
                    query = "select * from barang where barang.id_kategori=" + result.getInt("id_kategori") ;
                    ResultSet resultKategori = DatabaseHelper.executeQuery(query);
                    while (resultKategori.next()) {
                %>
                <div class="small_bottom">
                    <a href='/ruserba/barang/<%= resultKategori.getInt("id_barang") %>'>
                        <img src='/ruserba/assets/barang/<%= resultKategori.getString("gambar") %>' height='50%'/>
                    </a><br/>
                    <span class='barang_nama'>
                        <a href='/ruserba/barang/<%= resultKategori.getInt("id_barang") %>'><%= resultKategori.getString("nama_barang") %></a>
                    </span><br/>
                    <span>
                        <%
                            int tersedia = resultKategori.getInt("tersedia");
                            if (tersedia == 0) {
                                out.println("Barang tidak tersedia");
                            }
                            else {
                                out.println("Barang tersedia (" + resultKategori.getInt("tersedia") + " unit)");
                            }
                        %>
                    </span><br/>
                    <div >Rp <%= resultKategori.getInt("harga_barang") %>,00</div><br/>
                    <form method="post" action="EditItemServlet">
                        <input type="hidden" value='<%= resultKategori.getInt("id_barang") %>' name="id_barang" />
                        <input type="submit" name="edit" value="Edit" />
                    </form>
                        <button onclick="delete_item(<%= resultKategori.getInt("id_barang") %>)">Delete</button>
                </div>
                
                <%
                    }
                    resultKategori.close();
                %>
                <div class="small_bottom">
                    <form method="post" action="EditItemServlet">
                        <input type="hidden" name="id_kategori" value="<%= result.getInt("id_kategori") %>"/>
                        <input type="submit" name="edit" value="Add" />
                    </form>
                </div>
                <br/><br/>
            </div>
        </div>
        <hr/>
        <%
            }
            result.close();
            DatabaseHelper.Disconnect();
        %>
    </body>
</html>
