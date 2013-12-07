package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
public class insertdata extends HttpServlet {


@Override
public void doGet(HttpServletRequest request,
				  HttpServletResponse response)
	throws IOException, ServletException
{
	doPost(request, response);
}
	   
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) 
	   throws ServletException, java.io.IOException {

try
{	    

     UserBean user = new UserBean();
	user.setType("insertdata");
	  user.setQuery("INSERT INTO user (username,password,email,namalengkap,nohp,provinsi,kotakabupaten,alamat,kodepos)VALUES('"+
					request.getParameter("rusername")+"', '"+
					request.getParameter("rpassword")+"', '"+
					request.getParameter("email")+"', '"+
					request.getParameter("namalengkap")+"', '"+
					request.getParameter("nohp")+"', '"+
					request.getParameter("provinsi")+"','"+
					request.getParameter("kotakabupaten")+"','"+
					request.getParameter("alamat")+"','"+
					request.getParameter("kodepos")+"')");

	user = UserDAO.login(user);
	 	
		boolean coba = user.isValid();
		
    /* if (!user.isValid())
     {    
         
		  response.getWriter().print(true);
     }
	        
     else 
         response.getWriter().print(false);*/
		  Cookie username = new Cookie("username",request.getParameter("rusername"));
		  Cookie password = new Cookie("password", request.getParameter("rpassword"));

		  // Set expiry date after 30 days
		  username.setMaxAge(60*60*24*30); 
		  password.setMaxAge(60*60*24*30); 

		  // Add both the cookies in the response header.
		  response.addCookie(username);
		  response.addCookie(password);
		  
		  response.setContentType("text/html");
		  
		  HttpSession session = request.getSession(true);	    
          session.setAttribute("username",request.getParameter("rusername")); 
		  session.setAttribute("password",request.getParameter("rpassword")); 
		  response.sendRedirect("creditcard.jsp");//harusnya ke creditcard.jsp


} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	   
	   
	   
	   
	   
	}
