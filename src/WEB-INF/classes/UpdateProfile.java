// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
 
public class UpdateProfile extends HttpServlet{ 
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		String DataNama=new String();
		String DataPass=new String();
		String DataCredit=new String();
		String DataEmail=new String();
		String DataNamaLengkap=new String();
		String DataHp=new String();
		String DataProvinsi=new String();
		String DataKota=new String();
		String DataAlamat=new String();
		String DataKodePos=new String();
		HttpSession session=request.getSession(true);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			DataNama=request.getParameter("username");
			DataPass=request.getParameter("password");
			DataEmail=request.getParameter("email");
			DataNamaLengkap=request.getParameter("namalengkap");
			DataHp=request.getParameter("nohp");
			DataProvinsi=request.getParameter("provinsi");
			DataKota=request.getParameter("kotakabupaten");
			DataAlamat=request.getParameter("alamat");
			DataKodePos=request.getParameter("kodepos");
			PrintWriter out=response.getWriter();	
			s.executeUpdate("UPDATE user SET username="+"'"+DataNama+"'"+",password="+"'"+DataPass+"'"+",email="+"'"+DataEmail+"'"+",namalengkap="+"'"+DataNamaLengkap+"'"+",nohp="+"'"+DataHp+"'"+",provinsi="+"'"+DataProvinsi+"'"+",kotakabupaten="+"'"+DataKota+"'"+",alamat="+"'"+DataAlamat+"'"+",kodepos="+"'"+DataKodePos+"'"+" WHERE username="+"'"+DataNama+"'"+ ";"); 
			session.setAttribute("username", DataNama);
			session.setAttribute("email", DataEmail);
			session.setAttribute("password", DataPass);
			session.setAttribute("NamaLengkap", DataNamaLengkap);
			session.setAttribute("NomerHp", DataHp);
			session.setAttribute("Provinsi", DataProvinsi);
			session.setAttribute("Kota", DataKota);
			session.setAttribute("Alamat", DataAlamat);
			session.setAttribute("KodePos", DataKodePos);
			s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}
		request.getRequestDispatcher("edit-profile.jsp").forward(request, response);
	} 
}