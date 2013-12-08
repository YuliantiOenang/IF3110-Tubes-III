 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
 <html> 
 	<head> 
 	<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
	<script src="assets/js/header.js"></script>
 		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
 		<title> My first JSP </title> 
 	</head> 
 	<body> 
 		<form action="indexcontent" method="post"> 
 			Please enter a color 
 			<input type="text" name="color"size="20px"> 
 			<input type="submit" value="submit"> 
 		</form> 
 		<H1>LOGIN FORM</H1>
        <%
        String myname =  (String)session.getAttribute("username");
        
        if(myname!=null)
            {
             out.println("Welcome  "+myname+"  , <a href=\"logout.jsp\" >Logout</a>");
            }
        else 
            {
        	
            %>
            <form action="checkLogin.jsp">
                <table>
                    <tr>
                        <td> Username  : </td><td> <input name="username" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Password  : </td><td> <input name="password" size=15 type="text" /> </td> 
                    </tr>
                </table>
                <input type="submit" value="login" />
            </form>
            <% 
            }
         
             
            %>
- See more at: http://www.codemiles.com/jsp-examples/login-using-jsp-t3417.html#sthash.sSGztEIK.dpuf
 	</body> 
 </html>