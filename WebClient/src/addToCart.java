

import java.awt.Point;
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
import javax.servlet.http.HttpSession;

import kelas.Database;

/**
 * Servlet implementation class addToCart
 */
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
        super();
        int ohoho;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String db = "toko_imba";
		java.sql.Connection con = null;
		int id = Integer.parseInt(request.getParameter("id_barang"));
		int jml = Integer.parseInt(request.getParameter("jumlah"));
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+db, Database.getUser(), Database.getPass());
			System.out.println (db+ "database successfully opened.");
		
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM inventori WHERE id_inventori = " + id);
			int jumlahDiDatabaseWow = 0;
			while(rs.next()){
				jumlahDiDatabaseWow = rs.getInt("jumlah");
				break;
			}
			
			int testYow;
			
			HttpSession session = request.getSession(true);
			if(session.getAttribute("cart") == null){
				System.out.println("masuk ke yg kosong");
				ArrayList<Point> cart = new ArrayList<Point>();
				cart.add(new Point(id, jml));
				response.getWriter().write("Sukses!");
				session.setAttribute("cart", cart);
			} else {
				System.out.println("masuk ke yg udah ada");
				boolean found = false;
				ArrayList<Point> cart = (ArrayList<Point>) session.getAttribute("cart");
				for(Point p: cart){
					if(p.x == id){
						found = true;
						if(p.y + jml <= jumlahDiDatabaseWow){
							response.getWriter().write("Sukses!");
							p.y += jml;
						} else {
							response.getWriter().write("Jumlah barang tidak mencukupi!");
						}
						break;
					}
				}
				if(!found){
					response.getWriter().write("Sukses!");
					cart.add(new Point(id, jml));
				} 
				session.setAttribute("cart", cart);
			}
		
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("SQLException caught: " +e.getMessage());
		}
	}
}
