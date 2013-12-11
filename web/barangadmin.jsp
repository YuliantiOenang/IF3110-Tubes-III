<%!
   String url = "http://localhost:8080/tugas_web2/"; 
%>
<%-- 
    Document   : barangadmin
    Created on : Nov 27, 2013, 12:44:05 PM
    Author     : IHSAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.if3110.web.JSONResponder" %>
<%@page import="java.lang.*" %>
<!DOCTYPE html>
<%
   String kateg = request.getParameter( "cat" );
   int intkateg = Integer.parseInt(kateg);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=url %>assets/css/home.css" type="text/css">
        <link rel="stylesheet" href="<%=url %>assets/css/loginpopup.css" type="text/css">
        <script src="<%=url %>assets/use.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%! JSONResponder jsr = new JSONResponder(); %>
        <% String jstr = jsr.subkategori(); %>
        <% String jstrtabel = jsr.tabelbarang(intkateg+1); %>
        <p id="tabel"></p>
    <script>
        var categ = JSON.parse('<%= jstr%>');
        var tabel = JSON.parse('<%= jstrtabel%>');
        var htmlout = "<h1>" + categ.data[<%= intkateg %>] + "</h1>";
        for (var i=0; i<tabel.data.length; i++) {
            htmlout += "<div class=\"box_barang\">";
            htmlout += "<img class=\"gambar_barang\" src=\"<%=url %>" + tabel.img[i] + "\" alt=\"" + tabel.data[i] + "\" height=\"100\" width=\"100\">";
            htmlout += "<span class=\"harga\">Rp." + number_format(tabel.price[i],2,',','.') + "</span>";
            htmlout += "<p>" + tabel.data[i] + "</p>";
            htmlout += "<form method=\"get\" action=\"<%=url %>updateadmin.jsp\">";
            htmlout += "<input name=\"id\" type=\"hidden\" value=\"" + tabel.id[i] + "\">";
            htmlout += "<input name=\"cat\" type=\"hidden\" value=\"" + <%= intkateg %> + "\">";
            htmlout += "<input name=\"name\" type=\"hidden\" value=\"" + tabel.data[i] + "\">";
            htmlout += "<input name=\"price\" type=\"hidden\" value=\"" + tabel.price[i] + "\">";
            htmlout += "<input type=\"submit\" value=\"Ubah\">";
            htmlout += "</form>";
            htmlout += "<form method=\"get\" action=\"<%=url %>DeleteRedirection.jsp\">";
            htmlout += "<input name=\"id\" type=\"hidden\" value=\"" + tabel.id[i] + "\">";
            htmlout += "<input name=\"cat\" type=\"hidden\" value=\"" + <%= intkateg %> + "\">";
            htmlout += "<input type=\"submit\" value=\"Hapus\">";
            htmlout += "</form>";
            htmlout += "</div>";
        }
        htmlout += "<br><br><br><form method=\"get\" action=\"<%=url %>tambahbarang.jsp\">";
        htmlout += "<input name=\"cat\" type=\"hidden\" value=\"" + <%= intkateg %> + "\">";
        htmlout += "<input type=\"submit\" value=\"Tambah Barang\">";
        document.getElementById("tabel").innerHTML = htmlout;
    </script>
    </body>
</html>
