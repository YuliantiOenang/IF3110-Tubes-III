package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
public class getdatamember extends HttpServlet {


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
	 
	user.setType("getdatamember");
	user.setQuery("SELECT * FROM  user WHERE username='"
                        + request.getSession().getAttribute("username")
                        + "'");
						
	
   user = UserDAO.login(user);
	 	
		boolean coba = user.isValid();
		
    if (user.isValid())
    {    
		HttpSession session = request.getSession(true);	    
        session.setAttribute("username",user.getUsername()); 
		session.setAttribute("password",user.getPassword()); 
		session.setAttribute("cardnumber",user.getNoCredit());
        session.setAttribute("email",user.getEmail()); 
		session.setAttribute("namalengkap",user.getNamaLengkap()); 
		session.setAttribute("nohp",user.getNoHP());
        session.setAttribute("provinsi",user.getProvinsi()); 
		session.setAttribute("kotakabupaten",user.getKotaKabupaten()); 
		session.setAttribute("alamat",user.getAlamat());	
		session.setAttribute("kodepos",user.getKodePos());	
		
		
		user.setType("getjumlahtransaksi");
		user.setQuery("SELECT count(*) AS COUNT FROM  transactionlog WHERE Username='"
                        + request.getSession().getAttribute("username")
                        + "'");
		user = UserDAO.login(user);

		session.setAttribute("jumlahtransaksi",user.getJumlahTransaksi());	
		
		response.sendRedirect("edit-profile.jsp");
    }
	       
    else 
       response.sendRedirect("index.jsp");


} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	   
	   
	   
	   
	   
	}
