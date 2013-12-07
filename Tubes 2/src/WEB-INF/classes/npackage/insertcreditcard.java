package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
public class insertcreditcard extends HttpServlet {


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
	  user.setQuery("UPDATE user SET nocredit = '"+
	  request.getParameter("cardnumber")+"' WHERE username = '"+
	  request.getSession().getAttribute("username")+"' ");

	user = UserDAO.login(user);
	 	
		boolean coba = user.isValid();
		
    /* if (!user.isValid())
     {    
         
		  response.getWriter().print(true);
     }
	        
     else 
         response.getWriter().print(false);*/
		 Cookie cardnumber = new Cookie("cardnumber", request.getParameter("cardnumber"));

		  // Set expiry date after 30 days
		  cardnumber.setMaxAge(60*60*24*30); 

		  // Add both the cookies in the response header.
		  response.addCookie(cardnumber);
		  
		  response.setContentType("text/html");
		  
		  HttpSession session = request.getSession(true);	    
          session.setAttribute("cardnumber",request.getParameter("cardnumber"));
		  response.sendRedirect("index.jsp");


} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	   
	   
	   
	   
	   
	}
