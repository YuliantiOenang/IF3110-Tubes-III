package javafiles;
import java.io.IOException; 

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import java.io.PrintWriter; 

public class HelloWorld extends HttpServlet { 
	/**
	 * 
	 */
	

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
       

        // Do your Java job here.
        System.out.println(color);
        
        PrintWriter out = response.getWriter(); 
        //out.println ( "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" + "<html> \n" + "<head> \n" + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" + "<title> My first jsp </title> \n" + "</head> \n" + "<body> \n" + "<font size=\"12px\" color=\"" + color + "\">" + "Hello World" + "</font> \n" + "</body> \n" + "</html>" );
        
        
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
	
	public void coba (){
		System.out.println("wew");
	}
	
}
