

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
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		ArrayList<Barang> barangs = new ArrayList<Barang>();
		String query_name, query_category, query_price;
		
		query_name = request.getParameter("query_name");
		query_category = request.getParameter("query_category");
		query_price = request.getParameter("query_price");
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+db, Database.getUser(), Database.getPass());
			System.out.println (db+ "database successfully opened.");
			
			Statement state = con.createStatement();
			
			String query = "SELECT * FROM inventori, kategori WHERE inventori.id_kategori = kategori.id_kategori";
			
			if(!query_name.equals("")){
				query += " AND inventori.nama_inventori LIKE \"%" + query_name + "%\"";
			}
			
			if(!query_category.equals("")){
				query += " AND kategori.nama_kategori LIKE \"%" + query_category + "%\"";
			}
			
			if(!query_price.equals("")){
				query += " AND inventori.harga = " + query_price;
			}
			
			
			System.out.println("Query: " + query);
			ResultSet rs = state.executeQuery(query);
			
			while(rs.next()){
				String name = rs.getString("nama_inventori");
				Barang brg = new Barang(name);
				brg.setId_cat(rs.getInt("id_kategori"));
				brg.setId_inven(rs.getInt("id_inventori"));
				brg.setDesc(rs.getString("description"));
				brg.setHarga(rs.getInt("harga"));
				brg.setGambar(rs.getString("gambar"));
				brg.setJumlah(rs.getInt("jumlah"));
				barangs.add(brg);
				//request.setAttribute("name", name);
			}
			
			request.setAttribute("barangs", barangs);
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("SQLException caught: " +e.getMessage());
		}
		
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
