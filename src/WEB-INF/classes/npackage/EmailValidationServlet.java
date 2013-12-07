package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
public class EmailValidationServlet extends HttpServlet {


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
  
	  user.setQuery("select * from user where email='"
                        + request.getParameter("email")
                        + "'");

     user = UserDAO.login(user);
	 	
		boolean coba = user.isValid();
		
     if (!user.isValid())
     {    
         
		  response.getWriter().print(true);
     }
	        
     else 
         response.getWriter().print(false);


} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	   
	   
	   
	   
	   
	}
