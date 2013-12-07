package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
/**
 * Servlet implementation class LoginServlet
 */
public class getbarang extends HttpServlet {


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
				HttpSession session = request.getSession(true);	  
				UserBean user = new UserBean();
				String SearchQuery = request.getParameter("namabarang");
				user.setType("getbarang");
				user.setQuery("SELECT * FROM Barang WHERE NamaBarang = '"+SearchQuery+"' ");
				user = UserDAO.login(user);
				Barang barang = new Barang();
				barang = user.getbarang();
				String snama = "namab";
				String sid = "idb";
				String sharga = "hargab";
				String skategori = "kategorib";
				String sjumlah = "jumlahb";
				String sdeskripsi ="deskripsib";
				session.setAttribute(snama,barang.getNama());
				session.setAttribute(sid,barang.getId());
				session.setAttribute(sharga,barang.getHarga());
				session.setAttribute(skategori,barang.getKategori());
				session.setAttribute(sjumlah,barang.getJumlah());
				session.setAttribute(sdeskripsi,barang.getDeskripsi());
				
				
				session.setAttribute("squery", SearchQuery);
				response.sendRedirect("detail-barang.jsp");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
