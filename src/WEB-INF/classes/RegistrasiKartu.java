// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
 
public class RegistrasiKartu extends HttpServlet{ 
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		String DataNama=request.getParameter("cardname");
		String DataNomor=request.getParameter("cardnumber");
		String DataExpire=request.getParameter("expiredate");
		HttpSession session=request.getSession(true);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			String username=(String)session.getAttribute("username");
			s.executeUpdate("UPDATE user SET nocredit="+"'"+DataNomor+"'"+" WHERE username="+"'"+username+"'"+";");
			
			session.setAttribute("creditcard", DataNomor);
			session.setAttribute("creditcardNama", DataNama);
			session.setAttribute("creditcardExpireDate", DataExpire);
			
			Cookie CreditCookie = new Cookie("creditcard", DataNomor); //Add cookie Credit
			response.addCookie(CreditCookie);
			Cookie CreditNamaCookie = new Cookie("creditcardNama", DataNama); //Add cookie Credit
			response.addCookie(CreditNamaCookie);
			Cookie CreditExpireDateCookie = new Cookie("creditcardExpireDate", DataExpire); //Add cookie Credit
			response.addCookie(CreditExpireDateCookie);
			
			s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}
		response.sendRedirect("credit-card.jsp");
		return;
	} 
}