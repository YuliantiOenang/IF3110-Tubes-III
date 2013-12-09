// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
 
public class BestBuy extends HttpServlet{ 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		ArrayList<String> DataNamaBeras=new ArrayList<String>();
		ArrayList<String> DataNamaDaging=new ArrayList<String>();
		ArrayList<String> DataNamaSayuran=new ArrayList<String>();
		ArrayList<String> DataNamaFrozen=new ArrayList<String>();
		String Req;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			ResultSet rs;	
			int ResultSize=0;
			//AMBIL BESTBUY BERAS
			rs = s.executeQuery("SELECT NamaBarang,sum(Jumlah) FROM TransactionLog WHERE Kategori='Beras' GROUP BY IdBarang ORDER BY sum(Jumlah) DESC;");
			while(rs.next() && ResultSize<3){ 
				//Retrieve by column name 
				String Name = rs.getString("NamaBarang"); 
				ResultSize++;
				DataNamaBeras.add(Name);
			}
			request.setAttribute("BestBeras", DataNamaBeras);
			ResultSize=0;
			//AMBIL BESTBUY DAGING
			rs = s.executeQuery("SELECT NamaBarang,sum(Jumlah) FROM TransactionLog WHERE Kategori='Daging' GROUP BY IdBarang ORDER BY sum(Jumlah) DESC;");
			while(rs.next() && ResultSize<3){ 
				String Name = rs.getString("NamaBarang"); 
				DataNamaDaging.add(Name);
				ResultSize++;
			}
			request.setAttribute("BestDaging", DataNamaDaging);
			//DataNama.clear();
			ResultSize=0;
			//AMBIL BESTBUY Sayuran
			rs = s.executeQuery("SELECT NamaBarang,sum(Jumlah) FROM TransactionLog WHERE Kategori='Sayuran' GROUP BY IdBarang ORDER BY sum(Jumlah) DESC;");
			while(rs.next() && ResultSize<3){ 
				//Retrieve by column name 
				String Name = rs.getString("NamaBarang"); 
				ResultSize++;				
				DataNamaSayuran.add(Name);
			}
			request.setAttribute("BestSayuran", DataNamaSayuran);
			//DataNama.clear();
			ResultSize=0;
			//AMBIL BESTBUY FROZEN FOOD
			rs = s.executeQuery("SELECT NamaBarang,sum(Jumlah) FROM TransactionLog WHERE Kategori='Frozen Food' GROUP BY IdBarang ORDER BY sum(Jumlah) DESC;");
			while(rs.next() && ResultSize<3){ 
				//Retrieve by column name 
				String Name = rs.getString("NamaBarang"); 
				ResultSize++;
				DataNamaFrozen.add(Name);
			}
			request.setAttribute("BestFrozenFood", DataNamaFrozen);
			//DataNama.clear();
			ResultSize=0;
			request.setAttribute("BestBuyProduct","true");
			s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	} 
}