// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class DetailBarang extends HttpServlet{
	String DataNama;
	Integer DataHarga;
	public static String httpGet(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn =(HttpURLConnection) url.openConnection();
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}
		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return sb.toString();
	}
	public void Parse_Response(String Resp,HttpServletResponse response) throws ServletException,IOException {
		StringTokenizer st = new StringTokenizer(Resp,";");
		int i=0;
		while (st.hasMoreTokens()) {
			if (i%2==0){
				DataNama=st.nextToken();}
			else{
				DataHarga=Integer.parseInt(st.nextToken());}
			i++;
		}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		DataNama=new String();
		DataHarga=new Integer(0);
		
		String NamaReq = (String)request.getParameter("Nama");
		String URL=new String();
		URL="http://wbd032.ap01.aws.af.cm/DetailBarangServer.php?Nama="+URLEncoder.encode(NamaReq, "UTF-8");
		response.getWriter().println(URL);
		String Resp=httpGet(URL);
		response.getWriter().println(Resp);
		Parse_Response(Resp,response);
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			NamaReq = (String)request.getParameter("Nama");
			ResultSet rs;
			rs = s.executeQuery("SELECT * FROM BARANG WHERE NamaBarang="+"\""+NamaReq+"\""+";");
			while(rs.next()){ 
				//Retrieve by column name 
				int id = rs.getInt("IdBarang"); 
				int harga = rs.getInt("Harga"); 
				String Name = rs.getString("NamaBarang"); 
				String Kategori= rs.getString("Kategori"); 
				DataNama=Name;
				DataHarga=harga;
				DataKategori=Kategori;
			}
			s.close();
			con.close();
			request.setAttribute("DetailKategoriBarang",DataKategori);
			request.setAttribute("DetailNamaBarang", DataNama);
			request.setAttribute("DetailHargaBarang",DataHarga);
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}*/
		request.setAttribute("DetailNamaBarang", DataNama);
		request.setAttribute("DetailHargaBarang",DataHarga);
		request.getRequestDispatcher("DetailBarang.jsp").forward(request, response);
	} 
}