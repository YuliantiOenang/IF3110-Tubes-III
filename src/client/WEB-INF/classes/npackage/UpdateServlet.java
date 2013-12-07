package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
public class UpdateServlet extends HttpServlet {


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
	
	  user.setQuery("UPDATE user SET password='"+request.getParameter("epassword")+
					"', namalengkap='"+request.getParameter("namalengkap")+
					"', nohp='"+	request.getParameter("nohp")+
					"', provinsi='"+request.getParameter("provinsi")+
					"', kotakabupaten='"+request.getParameter("kotakabupaten")+
					"', alamat='"+request.getParameter("alamat")+
					"', kodepos='"+request.getParameter("kodepos")+
					"' WHERE username='"+request.getParameter("eusername")+"'");

	user = UserDAO.login(user);
	 	
		boolean coba = user.isValid();
		
    /* if (!user.isValid())
     {    
         
		  response.getWriter().print(true);
     }
	        
     else 
         response.getWriter().print(false);*/
		  Cookie username = new Cookie("username",request.getParameter("eusername"));
		  Cookie password = new Cookie("password", request.getParameter("epassword"));

		  // Set expiry date after 30 days
		  username.setMaxAge(60*60*24*30); 
		  password.setMaxAge(60*60*24*30); 

		  // Add both the cookies in the response header.
		  response.addCookie(username);
		  response.addCookie(password);
		  
		  response.setContentType("text/html");
		  
		  HttpSession session = request.getSession(true);	    
          session.setAttribute("username",request.getParameter("eusername")); 
		  session.setAttribute("password",request.getParameter("epassword")); 
		  response.sendRedirect("getdatamember");//harusnya ke creditcard.jsp


} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	   
	   
	   
	   
	   
	}
