<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.if3110.web.DBConnector"%>
<%@include file="/include/header.jsp" %>
<%! public static String HOME_URL = "http://localhost:8080/tugas_web2/"; %>
<%!
    public boolean isInteger( String input )  
    {  
       try  
       {  
          Integer.parseInt( input );  
          return true;  
       }  
       catch( Exception e)  
       {  
          return false;  
       }  
    }  
%>
<%
    String query = request.getParameter("query");
    String result = "";
    String title = "";
    String sql = "";
    // check input
    if(query.indexOf("less ") == 0){
        result = query.substring(5);
        title = "Hasil pencarian kurang dari Rp. " + NumberFormat.getInstance(Locale.GERMANY).format(Integer.valueOf(result));
        sql = "SELECT barang_data.barang_id, barang_data.nama, barang_kategori.kategori_nama, barang_data.harga, barang_data.image_url, barang_data.deskripsi ";
        sql += "FROM barang_data INNER JOIN barang_kategori ON barang_data.kategori_id = barang_kategori.kategori_id ";
        sql += "WHERE barang_data.harga < "+result;
    } else if(query.indexOf("more ") == 0){
        result = query.substring(5);
        title = "Hasil pencarian lebih dari Rp. " + NumberFormat.getInstance(Locale.GERMANY).format(Integer.valueOf(result));
        sql = "SELECT barang_data.barang_id, barang_data.nama, barang_kategori.kategori_nama, barang_data.harga, barang_data.image_url, barang_data.deskripsi ";
        sql += "FROM barang_data INNER JOIN barang_kategori ON barang_data.kategori_id = barang_kategori.kategori_id ";
        sql += "WHERE barang_data.harga > "+result;
    } else if(query.indexOf("category ") == 0){
        result = query.substring(9);
        title = "Hasil pencarian untuk kategori <i>"+result+"</i>";
        sql = "SELECT barang_data.barang_id, barang_data.nama, barang_kategori.kategori_nama, barang_data.harga, barang_data.image_url, barang_data.deskripsi ";
        sql += "FROM barang_data INNER JOIN barang_kategori ON barang_data.kategori_id = barang_kategori.kategori_id ";
        sql += "WHERE barang_kategori.kategori_nama LIKE '%"+result+"%'";
    } else {
        result = query;
        title = "Hasil pencarian untuk <i>"+result+"</i>";
        sql = "SELECT barang_data.barang_id, barang_data.nama, barang_kategori.kategori_nama, barang_data.harga, barang_data.image_url, barang_data.deskripsi ";
        sql += "FROM barang_data INNER JOIN barang_kategori ON barang_data.kategori_id = barang_kategori.kategori_id ";
        sql += "WHERE barang_data.nama LIKE '%"+result+"%'";
    }
    DBConnector dbCon = DBConnector.getInstance();
    Connection con = dbCon.getConnection();
    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet query2 = st.executeQuery(sql);
    query2.last();
    int total_row = query2.getRow();
    query2.beforeFirst();
    
    int start_number = 0;
    int this_page = 1;
    String temp ="";
    if(request.getParameter("page") != null) {
        if(isInteger(request.getParameter("page"))) {
            this_page = Integer.parseInt(request.getParameter("page"));
            if((total_row > (this_page - 1)*10) && (this_page > 0))
            {
                start_number = (this_page - 1)*10;
            }
            else
            {
                start_number = 0;
            }
        }
    }
%>
<h1><% out.print(title); %></h1>
<% 
    if(total_row == 0) {
        out.print ("<p><i>Hasil pencarian tidak ada.</i></p>");
    } else { 
        sql += " LIMIT "+start_number+", 10;";
        query2 = st.executeQuery(sql);
        while(query2.next()) {
    %>
<div class="table sresult" onSubmit="return addToShoppingChartBarang(this)">
    <div class="row">
        <span class="column"><img src="<% if(query2.getString("image_url") == "" || query2.getString("image_url") == null) out.print(HOME_URL+"assets/image/default.png"); else out.print(HOME_URL+URLDecoder.decode(query2.getString("image_url"),"UTF-8")); %>" alt="Default" width="100" height="100"></span>
        <span class="column" style="vertical-align: top">
            <h3><a href="<% out.print(HOME_URL+"barang/"+query2.getInt("barang_id")); %>"><% out.print(query2.getString("nama")); %></a></h3>
            <p>Rp.<% out.print(NumberFormat.getInstance(Locale.GERMANY).format(query2.getInt("harga"))); %><br>
            <% out.print(query2.getString("deskripsi")); %><br>
            <form onSubmit="return addToShoppingChart(this)"><span>Kuantitas: </span><input type="hidden" name="id_barang" value="<% out.print(query2.getInt("barang_id")); %>"><input type="text" name="qty" onKeyUp="validateQtyBarang(this)"> <input type="submit" value="+" disabled="disabled"></form></p>
        </span>
    </div>
</div>
<% 
        }
        int sisa = total_row % 10;
        int total_page = ((total_row - sisa) / 10) + 1;
        out.print("<div align=\"center\">Page");
        for(int i = 1; i <= total_page; i++) {
            if(i == this_page) out.print(" - <b>"+i+"</b>");
            else out.print(" - <a href=\"?query="+URLEncoder.encode(request.getParameter("query"))+"&page="+i+"\">"+i+"</a>");
        }
        out.print("</div>");
    }
%>
<%@include file="/include/footer.jsp" %>