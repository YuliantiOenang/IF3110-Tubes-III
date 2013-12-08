// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
 
public class Checkout extends HttpServlet{ 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		ArrayList<String> DataNamaSession=new ArrayList<String>();
		ArrayList<Integer> DataHargaSession=new ArrayList<Integer>();
		ArrayList<Integer> DataJumlahSession=new ArrayList<Integer>();
		HttpSession session = request.getSession(true);
		if (session.getAttribute("CartNama")!=null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
				Statement s = (Statement) con.createStatement();
				DataNamaSession=(ArrayList<String>)session.getAttribute("CartNama");
				DataHargaSession=(ArrayList<Integer>)session.getAttribute("CartHarga");
				DataJumlahSession=(ArrayList<Integer>)session.getAttribute("CartJumlah");
				String CurrentUser=new String();
				Cookie[] cookies = request.getCookies();
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("username")){
						CurrentUser=cookies[i].getValue();}
				}
				for (int i=0;i<DataNamaSession.size();i++){
					String CurrentNama=new String();
					int CurrentHarga= new Integer(0);
					int CurrentJumlah= new Integer(0);
					int CurrentId= new Integer(0);
					String CurrentKategori=new String();
					ResultSet rs;
					rs = s.executeQuery("SELECT * FROM BARANG WHERE NamaBarang="+"\""+DataNamaSession.get(i)+"\""+";");
					while(rs.next()){ 
						//Retrieve by column name 
						CurrentNama=rs.getString("NamaBarang");
						CurrentKategori=rs.getString("Kategori");
						CurrentId = rs.getInt("IdBarang"); 
						CurrentHarga = rs.getInt("Harga");
						CurrentJumlah = rs.getInt("Jumlah");
					}
					int NewJumlah=CurrentJumlah-DataJumlahSession.get(i);
					s.executeUpdate("INSERT INTO TransactionLog VALUES('"+CurrentId+"',"+"'"+CurrentNama+"',"+"'"+CurrentHarga+"',"+"'"+DataJumlahSession.get(i)+"',"+"'"+CurrentUser+"',"+"'"+CurrentKategori+"');");
					s.executeUpdate("UPDATE Barang SET Jumlah='"+NewJumlah+"' WHERE IdBarang='"+CurrentId+"';");
				}
				session.removeAttribute("CartNama");
				session.removeAttribute("CartHarga");
				session.removeAttribute("CartJumlah");
				s.close();
				con.close();
			}catch(Exception e){
				throw new SecurityException("Class not found " + e.toString());
			}
		}
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	} 
}