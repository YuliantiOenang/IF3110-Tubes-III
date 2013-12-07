

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
 * Servlet implementation class BarangPopuler
 */
public class BarangPopuler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarangPopuler() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String formalify(String name){
    	return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String db = "toko_imba";
		java.sql.Connection con = null;

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+db, Database.getUser(), Database.getPass());
			System.out.println (db+ "database successfully opened.");
			
			
			 
			for(int i=0;i<5;i++){
				ArrayList<Barang> barangKategori = new ArrayList<Barang>();
				Statement state = con.createStatement();
				ResultSet rs = state.executeQuery("SELECT * FROM inventori, kategori WHERE inventori.id_kategori = kategori.id_kategori AND inventori.id_kategori = " + (i+1) + " ORDER BY inventori.total_transaksi DESC LIMIT 3");
				
				String kategori = null;
				
				while(rs.next()){
					if(kategori == null){
						kategori = rs.getString("nama_kategori");
					}
					String name = rs.getString("nama_inventori");
					Barang brg = new Barang(name);
					brg.setId_cat(rs.getInt("id_kategori"));
					brg.setId_inven(rs.getInt("id_inventori"));
					brg.setDesc(rs.getString("description"));
					brg.setHarga(rs.getInt("harga"));
					brg.setGambar(rs.getString("gambar"));
					brg.setJumlah(rs.getInt("jumlah"));
					barangKategori.add(brg);
					//request.setAttribute("name", name);
				}
				
				//System.out.println("kategori:" + formalify(kategori));
				request.setAttribute("namaKategori" + i, formalify(kategori));
				request.setAttribute("barangKategori" + i, barangKategori);
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("SQLException caught: " +e.getMessage());
		}
				
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
