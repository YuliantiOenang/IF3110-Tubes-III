// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
 
public class Logout extends HttpServlet{ 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		Cookie[] cookies = request.getCookies();
        for(int i = 0; i< cookies.length ; ++i){
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
        }
		response.sendRedirect("home.jsp");
		return;
	} 
}