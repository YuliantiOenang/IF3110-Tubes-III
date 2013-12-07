package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
/**
 * Servlet implementation class LoginServlet
 */
public class getberas extends HttpServlet {


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
				user.setType("getberas");
				if(request.getParameter("sort") != null){
					String sort = (String)request.getParameter("sort");
					if(sort.equals("namabarang")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Beras' order by NamaBarang");
					}else if(sort.equals("harga")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Beras' order by Harga");
					}else if(sort.equals("urutkan")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Beras'");
					}
				}else{
					user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Beras'");
				}
				user = UserDAO.login(user);
				ArrayList<Barang> berases = new ArrayList<Barang>();
				berases = user.getberas(); 
				HttpSession session = request.getSession(true);	
				session.setAttribute("jumlahberas",berases.size());				
				for (int i = 0; i<berases.size();i++){
					String bnama = "bnama" + (i+1);
					String bid = "bid" + (i+1);
					String bharga = "bharga" + (i+1);
					String bkategori = "bkategori" + (i+1);
					String bjumlah = "bjumlah" + (i+1);
					session.setAttribute(bnama,berases.get(i).getNama());
					session.setAttribute(bid,berases.get(i).getId());
					session.setAttribute(bharga,berases.get(i).getHarga());
					session.setAttribute(bkategori,berases.get(i).getKategori());
					session.setAttribute(bjumlah,berases.get(i).getJumlah());
				
				}
				
				response.sendRedirect("Beras.jsp?f=1&l=10");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
