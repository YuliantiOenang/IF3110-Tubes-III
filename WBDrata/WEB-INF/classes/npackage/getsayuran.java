package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
/**
 * Servlet implementation class LoginServlet
 */
public class getsayuran extends HttpServlet {


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
				user.setType("getsayuran");
				if(request.getParameter("sort") != null){
					String sort = (String)request.getParameter("sort");
					if(sort.equals("namabarang")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Sayuran' order by NamaBarang");
					}else if(sort.equals("harga")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Sayuran' order by Harga");
					}else if(sort.equals("urutkan")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Sayuran'");
					}
				}else{
					user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Sayuran'");
				}
				user = UserDAO.login(user);
				ArrayList<Barang> sayuranes = new ArrayList<Barang>();
				sayuranes = user.getsayuran(); 
				HttpSession session = request.getSession(true);	
				session.setAttribute("jumlahsayuran",sayuranes.size());				
				for (int i = 0; i<sayuranes.size();i++){
					String bnama = "synama" + (i+1);
					String bid = "syid" + (i+1);
					String bharga = "syharga" + (i+1);
					String bkategori = "sykategori" + (i+1);
					String bjumlah = "syjumlah" + (i+1);
					session.setAttribute(bnama,sayuranes.get(i).getNama());
					session.setAttribute(bid,sayuranes.get(i).getId());
					session.setAttribute(bharga,sayuranes.get(i).getHarga());
					session.setAttribute(bkategori,sayuranes.get(i).getKategori());
					session.setAttribute(bjumlah,sayuranes.get(i).getJumlah());
					System.out.println(sayuranes.get(i).getJumlah());
				
				}
				
				response.sendRedirect("Sayuran.jsp?f=1&l=10");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
