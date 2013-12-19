<%-- 
    Document   : admin
    Created on : Nov 25, 2013, 4:01:08 PM
    Author     : Ahmad Fauzan
--%>

<%@page import="ruserba.services.RuserbaServices"%>
<%@page import="org.json.JSONObject"%>
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
                    %>
                    <jsp:forward page="/home" />
                    <%
            } 
            
        %> 
        <div id="popup">
            <span id="warning">Do you want to delete it ? </span>
            <form id="formdelete" method="post" action="DeleteItemServlet">
                <input type ="hidden" value="" name="id_popup" id="id_popup" />
                <input type ="submit" value="yes"/>
            </form>
            <button onclick="closePopup();">No</button>
        </div>
        <%
            
            JSONObject result = RuserbaServices.GetKategori();
            for(int i=0; i < result.getInt("length"); i++) {
                JSONObject kategori = result.getJSONObject(""+i);
        %>
        <div class ="main">
            <span class='category'>
                <img src='assets/icon_recommend.png' height='16'/> <a href='/ruserba/kategori/<%= kategori.getInt("id_kategori") %>'><%= kategori.getString("nama_kategori") %></a>
            </span><br/><br/>
            <div class = "bottom" >
                <%
                    //query = "select * from barang where barang.id_kategori=" + result.getInt("id_kategori") ;
                    JSONObject resultKategori = RuserbaServices.GetBarangByKategori(kategori.getInt("id_kategori"));
                    for(int j=0; j < resultKategori.getInt("length"); j++) {
                        JSONObject barang = resultKategori.getJSONObject(""+j);
                %>
                <div class="small_bottom">
                    <a href='/ruserba/barang/<%= barang.getInt("id_barang") %>'>
                        <img src='/ruserba/assets/barang/<%= barang.getString("gambar") %>' height='50%'/>
                    </a><br/>
                    <span class='barang_nama'>
                        <a href='/ruserba/barang/<%= barang.getInt("id_barang") %>'><%= barang.getString("nama_barang") %></a>
                    </span><br/>
                    <span>
                        <%
                            int tersedia = barang.getInt("tersedia");
                            if (tersedia == 0) {
                                out.println("Barang tidak tersedia");
                            }
                            else {
                                out.println("Barang tersedia (" + barang.getInt("tersedia") + " unit)");
                            }
                        %>
                    </span><br/>
                    <div >Rp <%= barang.getInt("harga_barang") %>,00</div><br/>
                    <form method="post" action="EditItemServlet">
                        <input type="hidden" value='<%= barang.getInt("id_barang") %>' name="id_barang" />
                        <input type="submit" name="edit" value="Edit" />
                    </form>
                        <button onclick="delete_item(<%= barang.getInt("id_barang") %>)">Delete</button>
                </div>
                
                <%
                    }
                %>
                <div class="small_bottom">
                    <form method="post" action="EditItemServlet">
                        <input type="hidden" name="id_kategori" value="<%= kategori.getInt("id_kategori") %>"/>
                        <input type="submit" name="edit" value="Add" />
                    </form>
                </div>
                <br/><br/>
            </div>
        </div>
        <hr/>
        <%
            }
        %>
    </body>
</html>
