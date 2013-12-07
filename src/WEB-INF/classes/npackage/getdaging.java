package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
/**
 * Servlet implementation class LoginServlet
 */
public class getdaging extends HttpServlet {


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
				user.setType("getdaging");
				if(request.getParameter("sort") != null){
					String sort = (String)request.getParameter("sort");
					if(sort.equals("namabarang")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Daging' order by NamaBarang");
					}else if(sort.equals("harga")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Daging' order by Harga");
					}else if(sort.equals("urutkan")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Daging'");
					}
				}else{
					user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Daging'");
				}
				user = UserDAO.login(user);
				ArrayList<Barang> daginges = new ArrayList<Barang>();
				daginges = user.getdaging(); 
				HttpSession session = request.getSession(true);	
				session.setAttribute("jumlahdaging",daginges.size());				
				for (int i = 0; i<daginges.size();i++){
					String bnama = "dnama" + (i+1);
					String bid = "did" + (i+1);
					String bharga = "dharga" + (i+1);
					String bkategori = "dkategori" + (i+1);
					String bjumlah = "djumlah" + (i+1);
					session.setAttribute(bnama,daginges.get(i).getNama());
					session.setAttribute(bid,daginges.get(i).getId());
					session.setAttribute(bharga,daginges.get(i).getHarga());
					session.setAttribute(bkategori,daginges.get(i).getKategori());
					session.setAttribute(bjumlah,daginges.get(i).getJumlah());
				
				}
				
				response.sendRedirect("Daging.jsp?f=1&l=10");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
