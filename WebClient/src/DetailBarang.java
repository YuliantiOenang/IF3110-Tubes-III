

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kelas.Barang;
import kelas.Database;

/**
 * Servlet implementation class DetailBarang
 */
public class DetailBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailBarang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String db = "toko_imba";
		java.sql.Connection con = null;
		int barangId = -1;
		try{
			barangId = Integer.parseInt(request.getParameter("gid"));
		} catch(Exception e){
			e.printStackTrace();
		}
		
		Barang barang = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+db, Database.getUser(), Database.getPass());
			System.out.println (db+ "database successfully opened.");
			
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM inventori NATURAL JOIN kategori WHERE id_inventori = " + barangId);

			while(rs.next()){
				String name = rs.getString("nama_inventori");
				barang = new Barang(name);
				barang.setId_cat(rs.getInt("id_kategori"));
				barang.setId_inven(rs.getInt("id_inventori"));
				barang.setDesc(rs.getString("description"));
				barang.setHarga(rs.getInt("harga"));
				barang.setGambar(rs.getString("gambar"));
				barang.setJumlah(rs.getInt("jumlah"));
			}
			
			request.setAttribute("barang", barang);
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("SQLException caught: " +e.getMessage());
		}
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
