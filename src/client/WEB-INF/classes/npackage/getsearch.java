package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
/**
 * Servlet implementation class LoginServlet
 */
public class getsearch extends HttpServlet {


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
				String SearchQuery = request.getParameter("src");
				String SearchQueryKategori = request.getParameter("search-kategori");
				String SearchQueryHarga1 = request.getParameter("search-harga1");
				String SearchQueryHarga2 = request.getParameter("search-harga2");
				user.setType("getsearch");
				
				if (SearchQuery.equals("ketikkan yang ingin dicari..") ){
					SearchQuery="%";
				}
				
				user.setQuery("SELECT * FROM Barang WHERE (NamaBarang LIKE '%"+SearchQuery+
				"%') AND (Kategori LIKE '"+SearchQueryKategori+"') AND (Harga<"+SearchQueryHarga2+") AND (Harga>"+SearchQueryHarga1+")" );
			
				
				
				
				user = UserDAO.login(user);
				ArrayList<Barang> barangs = new ArrayList<Barang>();
				barangs = user.getsearch();
				HttpSession session = request.getSession(true);	  
				session.setAttribute("jumlahsearch",barangs.size());
				for (int i = 0; i<barangs.size();i++){
					String snama = "snama" + (i+1);
					String sid = "sid" + (i+1);
					String sharga = "sharga" + (i+1);
					String skategori = "skategori" + (i+1);
					String sjumlah = "sjumlah" + (i+1);
					session.setAttribute(snama,barangs.get(i).getNama());
					session.setAttribute(sid,barangs.get(i).getId());
					session.setAttribute(sharga,barangs.get(i).getHarga());
					session.setAttribute(skategori,barangs.get(i).getKategori());
					session.setAttribute(sjumlah,barangs.get(i).getJumlah());
				
				}
				session.setAttribute("squery", SearchQuery);
				
				
				
				response.sendRedirect("search.jsp?f=1&l=10");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
