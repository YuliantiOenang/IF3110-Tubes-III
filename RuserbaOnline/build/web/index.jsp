<%-- 
    Document   : index
    Created on : Nov 30, 2013, 10:16:31 AM
    Author     : Mahdan Ahmad F A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en-US">
    <head>
        <%
            // Get Session
            String user_check = "";
            if(request.getSession().getAttribute("user_check")==null){
                user_check = "";
            }else{
                user_check  = request.getSession().getAttribute("user_check").toString();
            }
        %>
        <meta charset="UTF-8">
        <meta http-equiv="refresh" content="1;url=pages/index.jsp">
        <%
            if (user_check.equals("admin")) {
                response.sendRedirect("pages/adminpage.jsp");
            } else {
                response.sendRedirect("pages/index.jsp");
            }
        %>
        
        <!--script type="text/javascript">
            
            
            window.location.href = "pages/index.jsp"
            
        </script-->
        <title>Page Redirection</title>
    </head>
    <body>
        <!-- Note: don't tell people to `click` the link, just tell them that it is a link. -->
        If you are not redirected automatically, follow the link to <a href='pages/index.jsp'>home</a>
    </body>
</html>