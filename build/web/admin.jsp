<%-- 
    Document   : admin
    Created on : Nov 26, 2013, 4:10:13 PM
    Author     : IHSAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.if3110.web.JSONResponder" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! JSONResponder jsr = new JSONResponder(); %>
        <% String jstr = jsr.subkategori(); %>
        <p id="pilihan"></p>
    <script>
        var categ = JSON.parse('<%= jstr%>');
        var htmlout = "<h1>Lihat Kategori</h1>";
        for (var i=0; i<categ.data.length; i++) {
            htmlout += "<p><a href=\"http://localhost:8080/tugas_web2/barangadmin.jsp?cat=" + i + "\">" + categ.data[i] + "</a></p>";
        }
        document.getElementById("pilihan").innerHTML = htmlout;
    </script>
        
    </body>
</html>
