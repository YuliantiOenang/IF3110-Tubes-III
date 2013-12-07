package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
/**
 * Servlet implementation class LoginServlet
 */
public class getsnack extends HttpServlet {


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
				user.setType("getsnack");
				if(request.getParameter("sort") != null){
					String sort = (String)request.getParameter("sort");
					if(sort.equals("namabarang")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Snack' order by NamaBarang");
					}else if(sort.equals("harga")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Snack' order by Harga");
					}else if(sort.equals("urutkan")){
						user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Snack'");
					}
				}else{
					user.setQuery("SELECT * FROM Barang WHERE Kategori = 'Snack'");
				}
				user = UserDAO.login(user);
				ArrayList<Barang> snackes = new ArrayList<Barang>();
				snackes = user.getsnack(); 
				HttpSession session = request.getSession(true);	
				session.setAttribute("jumlahsnack",snackes.size());				
				for (int i = 0; i<snackes.size();i++){
					String bnama = "snnama" + (i+1);
					String bid = "snid" + (i+1);
					String bharga = "snharga" + (i+1);
					String bkategori = "snkategori" + (i+1);
					String bjumlah = "snjumlah" + (i+1);
					session.setAttribute(bnama,snackes.get(i).getNama());
					session.setAttribute(bid,snackes.get(i).getId());
					session.setAttribute(bharga,snackes.get(i).getHarga());
					session.setAttribute(bkategori,snackes.get(i).getKategori());
					session.setAttribute(bjumlah,snackes.get(i).getJumlah());
				
				}
				
				response.sendRedirect("Snack.jsp?f=1&l=10");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
