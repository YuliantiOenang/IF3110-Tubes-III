package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginServlet
 */
public class getbestbuy extends HttpServlet {


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
				 
				user.setType("getbestbuy");
				user.setQuery("SELECT namabarang FROM transactionlog WHERE kategori='Beras' GROUP BY namabarang ORDER BY sum(Jumlah) DESC");
				user = UserDAO.login(user);
				
				HttpSession session = request.getSession(true);	    
				session.setAttribute("BestBuy1",user.getbestbuy1()); 
				session.setAttribute("BestBuy2",user.getbestbuy2()); 
				session.setAttribute("BestBuy3",user.getbestbuy3()); 
				
				
				user.setQuery("SELECT namabarang FROM transactionlog WHERE kategori='daging' GROUP BY namabarang ORDER BY sum(Jumlah) DESC");
				user = UserDAO.login(user);
				session.setAttribute("BestBuy4",user.getbestbuy1()); 
				session.setAttribute("BestBuy5",user.getbestbuy2()); 
				session.setAttribute("BestBuy6",user.getbestbuy3()); 

				user.setQuery("SELECT namabarang FROM transactionlog WHERE kategori='sayuran' GROUP BY namabarang ORDER BY sum(Jumlah) DESC");
				user = UserDAO.login(user);
				session.setAttribute("BestBuy7",user.getbestbuy1()); 
				session.setAttribute("BestBuy8",user.getbestbuy2()); 
				session.setAttribute("BestBuy9",user.getbestbuy3()); 
				
				user.setQuery("SELECT namabarang FROM transactionlog WHERE kategori='frozen food' GROUP BY namabarang ORDER BY sum(Jumlah) DESC");
				user = UserDAO.login(user);
				session.setAttribute("BestBuy10",user.getbestbuy1()); 
				session.setAttribute("BestBuy11",user.getbestbuy2()); 
				session.setAttribute("BestBuy12",user.getbestbuy3()); 
				
				user.setQuery("SELECT namabarang FROM transactionlog WHERE kategori='snack' GROUP BY namabarang ORDER BY sum(Jumlah) DESC");
				user = UserDAO.login(user);
				session.setAttribute("BestBuy13",user.getbestbuy1()); 
				session.setAttribute("BestBuy14",user.getbestbuy2()); 
				session.setAttribute("BestBuy15",user.getbestbuy3()); 
				
				response.sendRedirect("index.jsp");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
