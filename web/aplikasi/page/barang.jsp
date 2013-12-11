<%@page import="java.util.HashMap"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.if3110.web.DBConnector"%>
<%@include file="../../include/header.jsp" %>
<%! public static String HOME_URL = "http://localhost:8080/tugas_web2/"; %>
<h1>Detail Barang</h1>
<form class="table barang" method="post" onSubmit="return addToShoppingChartBarang(this)">
    <div class="row">
        <% 
            HashMap<String, String> barang = (HashMap<String, String>) request.getAttribute("data");
            String imgsrc;
            if(barang.get("image_url").equals(""))
            {
                imgsrc=HOME_URL+"assets/image/default.big.png";
            }
            else
            {
                imgsrc=HOME_URL+URLDecoder.decode(barang.get("image_url"),"UTF-8");
            }
        %>
        <span class="column"><img src="<%=imgsrc %>" alt="Default" width="250" height="250"></span>
        <span class="column" style="vertical-align: top">
            <h2><%= barang.get("nama") %></h2>
            <p>Rp.<% out.print(NumberFormat.getInstance(Locale.GERMANY).format(Float.valueOf(barang.get("harga")))); %></p>
            <p><%= barang.get("deskripsi") %></p>
            <p><textarea name="pesan"></textarea></p>
            <p><span>Kuantitas: </span><input type="hidden" name="id_barang" value="<%=barang.get("barang_id") %>"><input type="text" name="qty" onKeyUp="validateQtyBarang(this)"> <input type="submit" value="+" disabled="disabled"></p>
        </span>
    </div>
</form>
<%@include file="../../include/footer.jsp" %>