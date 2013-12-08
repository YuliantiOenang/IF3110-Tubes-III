package tubesII.wbd.kay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tubesII.wbd.kay.barang.Barang;
import tubesII.wbd.GlobalConfig;
import org.json.*;

import com.google.gson.Gson;
/**
 * Servlet implementation class verifyRegister
 */
@WebServlet(description = "To Verify the registration input", urlPatterns = { "/verifyRegister" })
public class barang extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public barang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			/*EXAMPLE CODE*/
			/*Used for query .. DONT CHANGE THIS LINES*/
			String action=request.getParameter("action");
			String parameters=request.getParameter("parameters").trim();
			String parameter[]=parameters.split(",");
			GlobalConfig GC = new GlobalConfig();
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			Connection con = DriverManager.getConnection (GC.geturl(), GC.getuser(), GC.getpass());
			PrintWriter out =  response.getWriter();
			// End OF DONT CHANGE
			
			
			if(action.equals("insert")){
				// TODO customize for funtion 
				// FORMAT INPUT : action = register & parameters = username , nama_lengkap , password, email ,handphone , address , province , state , postcode , n_pembelian
				// FORMAT OUTPUT : {Status_operasi: Success/Failed}
				// Silahakan GOoogling explorasi syntax SQL untuk insert, soalnya beda sama con.executeSQL kalau gak salah con.updateSQL
				
				Statement statement = con.createStatement();
				
				String nama_barang = parameter[0];
				String gambar_barang = parameter[1];
				String harga_barang = parameter[2];
				String kategori_barang = parameter[3];
				String n_beli = parameter[4];
				String keterangan = parameter[5];
				String stok = parameter[6];
				
				String query = "INSERT INTO barang (nama_barang, gambar_barang, harga_barang, kategori_barang, n_beli, keterangan, stok) VALUES ('" + nama_barang + "','" + gambar_barang + "','" + harga_barang + "','" + kategori_barang + "','" + n_beli + "','" + keterangan + "','" + stok + "')";
				
				int status;
				status = statement.executeUpdate(query);
				
				if(status==0){
					out.print("{ \"Status_operasi\" : \"berhasil\" }");
				}else{
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				}
				
				
			}else if(action.equals("update")){
			
				Statement statement = con.createStatement();
				
				String nama_barang = parameter[0];
				String gambar_barang = parameter[1];
				String harga_barang = parameter[2];
				String kategori_barang = parameter[3];
				String n_beli = parameter[4];
				String keterangan = parameter[5];
				String stok = parameter[6];
				
				String query = "UPDATE barang SET nama_barang='" + nama_barang + "', gambar_barang='" + gambar_barang + "', harga_barang=" + harga_barang + ", kategori_barang=" + kategori_barang + ", n_beli=" + n_beli + ", keterangan='" + keterangan + "', stok=" + stok + " WHERE id_barang=" + id_barang;
				
				int status;
				status = statement.executeUpdate(query);
				
				if(status==0){
					out.print("{ \"Status_operasi\" : \"berhasil\" }");
				}else{
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				}
				
			}else if(action.equals("delete")){
			
				Statement statement = con.createStatement();
				
				String id_barang = parameter[0];
				
				String query = "DELETE FROM barang WHERE id_barang=" + id_barang;
				
				int status;
				status = statement.execute(query);
				
				if(status==0){
					out.print("{ \"Status_operasi\" : \"berhasil\" }");
				}else{
					out.print("{ \"Status_operasi\" : \"gagal\" }");
					
			}else if(action.equals("find")){
				Statement statement = con.createStatement();
				
				String query = parameter[0];
				
				boolean status = false;
				ResultSet result = null;
				
				result = executeQuery(query);
				status = result.next();
				
				if (status) {
					barang = new Barang();
					barang.id_barang = Integer.parseInt(result.getString(1));
					barang.nama_barang = result.getString(2);
					barang.gambar_barang = result.getString(3);
					barang.harga_barang = Integer.parseInt(result.getString(4));
					barang.kategori_barang = Integer.parseInt(result.getString(5));
					barang.n_beli = Integer.parseInt(result.getString(6));
					barang.keterangan = result.getString(7);
					barang.stok = Integer.parseInt(result.getString(8));
					Gson gson = new Gson();
					out.print(gson.toJson(barang));
				} else {
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				}
			}else if(action.equals("findByPK")){
				Statement statement = con.createStatement();
				
				String id = parameter[0];
				
				boolean status = false;
				ResultSet result = null;
				
				result = executeQuery("SELECT * FROM barang WHERE id_barang=" + id);
				status = result.next();
				
				if (status) {
					barang = new Barang();
					barang.id_barang = Integer.parseInt(result.getString(1));
					barang.nama_barang = result.getString(2);
					barang.gambar_barang = result.getString(3);
					barang.harga_barang = Integer.parseInt(result.getString(4));
					barang.kategori_barang = Integer.parseInt(result.getString(5));
					barang.n_beli = Integer.parseInt(result.getString(6));
					barang.keterangan = result.getString(7);
					barang.stok = Integer.parseInt(result.getString(8));
					Gson gson = new Gson();
					out.print(gson.toJson(barang));
				} else {
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				}
			}else if(action.equals("findAll")){
				Statement statement = con.createStatement();
				
				String query = parameter[0];
				
				boolean status = false;
				ResultSet result = null;
				
				result = executeQuery(query);
				
				while(result.next()){
					barang = new Barang();
					barang.id_barang = Integer.parseInt(result.getString(1));
					barang.nama_barang = result.getString(2);
					barang.gambar_barang = result.getString(3);
					barang.harga_barang = Integer.parseInt(result.getString(4));
					barang.kategori_barang = Integer.parseInt(result.getString(5));
					barang.n_beli = Integer.parseInt(result.getString(6));
					barang.keterangan = result.getString(7);
					barang.stok = Integer.parseInt(result.getString(8));
					Gson gson = new Gson();
					out.print(gson.toJson(barang));
				}
			}
		}catch(Exception e){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
