<%-- 
    Document   : result
    Created on : Nov 25, 2013, 3:08:14 PM
    Author     : Setyo Legowo <setyo.legowo@live.com>
--%>

<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            List styles = (List) request.getAttribute("styles");
            Iterator it = styles.iterator();
            while(it.hasNext()) {
                out.print("<br>try: " + it.next());
            }
        %>
    </body>
</html>
