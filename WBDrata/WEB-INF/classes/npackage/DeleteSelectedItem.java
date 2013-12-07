package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
public class DeleteSelectedItem extends HttpServlet {


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
	
	String[] checkdel = request.getParameterValues("cdelete");
	if (request.getParameterValues("cdelete")!=null){
	for(int i=0;i<checkdel.length;i++){
		response.getWriter().println(checkdel[i]);
		user.setQuery("DELETE FROM barang WHERE namabarang='"+checkdel[i]+"'");
		user = UserDAO.login(user);
	}
	}
	response.sendRedirect("getadmin");


} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	   
	   
	   
	   
	   
	}
