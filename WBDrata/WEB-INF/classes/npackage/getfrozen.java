package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
/**
 * Servlet implementation class LoginServlet
 */
public class getfrozen extends HttpServlet {


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
				user.setType("getfrozen");
				if(request.getParameter("sort") != null){
					String sort = (String)request.getParameter("sort");
					if(sort.equals("namabarang")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Frozen Food' order by NamaBarang");
					}else if(sort.equals("harga")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Frozen Food' order by Harga");
					}else if(sort.equals("urutkan")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Frozen Food'");
					}
				}else{
					user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Frozen Food'");
				}
				user = UserDAO.login(user);
				ArrayList<Barang> frozenes = new ArrayList<Barang>();
				frozenes = user.getfrozen(); 
				HttpSession session = request.getSession(true);	
				session.setAttribute("jumlahfrozen",frozenes.size());				
				for (int i = 0; i<frozenes.size();i++){
					String bnama = "fnama" + (i+1);
					String bid = "fid" + (i+1);
					String bharga = "fharga" + (i+1);
					String bkategori = "fkategori" + (i+1);
					String bjumlah = "fjumlah" + (i+1);
					session.setAttribute(bnama,frozenes.get(i).getNama());
					session.setAttribute(bid,frozenes.get(i).getId());
					session.setAttribute(bharga,frozenes.get(i).getHarga());
					session.setAttribute(bkategori,frozenes.get(i).getKategori());
					session.setAttribute(bjumlah,frozenes.get(i).getJumlah());
				
				}
				
				response.sendRedirect("Frozen.jsp?f=1&l=10");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
