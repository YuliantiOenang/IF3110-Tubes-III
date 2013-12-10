package Data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tubesII.wbd.GlobalConfig;

import com.google.gson.Gson;

public class barang extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			/*EXAMPLE CODE*/
			/*Used for query .. DONT CHANGE THIS LINES*/
			String action=request.getParameter("action");
			String parameters=request.getParameter("parameters").trim();
			String parameter[]=parameters.split(",");
			GlobalConfig GC = new GlobalConfig();
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			//Connection con = DriverManager.getConnection (GC.geturl(), GC.getuser(), GC.getpass());
			Connection con = DriverManager.getConnection ("jdbc:mysql://localhost/progin_13511059", "root", "");
			PrintWriter out =  response.getWriter();
			// End OF DONT CHANGE
			
			
			response.setContentType("text/html");
	        response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");
			response.setHeader("Access-Control-Allow-Origin","*");
			response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,OPTIONS");
			response.setHeader("Access-Control-Allow-Headers","X-Requested-With, Content-Type, Content-Length");
			
			if(action.equals("cari")){
				
				// TODO customize for funtion 
				// FORMAT INPUT : action = register & parameters = username , nama_lengkap , password, email ,handphone , address , province , state , postcode , n_pembelian
				// FORMAT OUTPUT : {Status_operasi: Success/Failed}
				// Silahakan GOoogling explorasi syntax SQL untuk insert, soalnya beda sama con.executeSQL kalau gak salah con.updateSQL
				
				Statement statement = con.createStatement();
				
				
				
				String name = parameter[0];
				String harga = parameter[1];
				String kategori = parameter[2];
				Integer laman=Integer.parseInt(parameter[3]);
				Integer i=(laman-1)*10;
				String order=parameter[4];
				//out.print("test aja : "+name+" "+harga+" "+kategori+" "+laman+" "+i+" "+order);
				
				String n_item_query=new String();
				String search_query=new String();
				
				
				if (!name.equals("")) {
					if(!harga.equals("")){ //ada harga
						if(!kategori.equals("")){
							n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+Integer.parseInt(harga)+" AND kategori_barang = \'"+kategori+"\'";
							search_query = "SELECT * FROM barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+Integer.parseInt(harga)+" AND kategori_barang = \'"+kategori+"\' ORDER BY \'"+order+"\' ASC LIMIT "+i+", 10";
						}else { //kategori kosong
							n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE nama_barang like \'%"+name+"%\' AND harga_barang BETWEEN 0 AND "+Integer.parseInt(harga);
							search_query = "SELECT * FROM barang WHERE nama_barang like \'%"+name+"%\' AND harga_barang BETWEEN 0 AND "+Integer.parseInt(harga)+" ORDER BY \'"+order+"\' ASC LIMIT "+i+", 10";
						}
					}else{ //harga kosong
						if(!kategori.equals("")) {
							 n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE nama_barang like \'%"+name+"%\' AND kategori_barang = \'"+kategori+"\'";
							 search_query = "SELECT * FROM barang WHERE nama_barang like \'%"+name+"%\' AND kategori_barang = \'"+kategori+"\' ORDER BY \'"+order+"\' ASC LIMIT "+i+", 10";
						} else {
							 n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE nama_barang like \'%"+name+"%\'";
							 search_query = "SELECT * FROM barang WHERE nama_barang like \'%"+name+"%\' ORDER BY \'"+order+"\' ASC LIMIT "+i+", 10";
						}
						
					}
				}else{// nama kosong
					if(!harga.equals("")){ //ada harga
						if(!kategori.equals("")){ //ada kategori
							n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = \'"+kategori+"\'";
							search_query = "SELECT * FROM barang WHERE harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = \'"+kategori+"\' ORDER BY "+order+" ASC LIMIT "+i+", 10";
						}else { //kategori kosong
							n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE harga_barang BETWEEN 0 AND "+harga;
							search_query = "SELECT * FROM barang WHERE harga_barang BETWEEN 0 AND "+harga+" ORDER BY \'"+order+"\' ASC LIMIT "+i+", 10";
						}
					} else { //gak ada harga
						if(!kategori.equals("")) {
							n_item_query = "SELECT COUNT(nama_barang) AS \'n_item\' FROM barang WHERE kategori_barang = \'"+kategori+"\'";
							search_query = "SELECT * FROM barang WHERE kategori_barang = \'"+kategori+"\' ORDER BY \'"+order+"\' ASC LIMIT "+i+", 10";
						}else{
							n_item_query = "SELECT COUNT(nama_barang) AS \'n_item\' FROM barang WHERE kategori_barang = \'\'";
							search_query = "SELECT * FROM barang WHERE kategori_barang = \'\' ORDER BY \'"+order+"\' ASC LIMIT "+i+", 10";
						}
					}
				}
				//out.print("query:"+n_item_query);
				//out.print("search:"+search_query);

				//out.print("TEST");
				Statement s1 = con.createStatement();
				Statement s2 = con.createStatement();
				ResultSet rs1 = s1.executeQuery(n_item_query);
				ResultSet rs2 = s2.executeQuery(search_query);
				
				Integer n_item=new Integer(0);
				
				ArrayList<barang_data> Hasil_search=new ArrayList<>();
				while(rs1.next()){
					n_item = Integer.parseInt(rs1.getString(1));
					//out.print("ada n _item:"+rs1.getString(1));
				}
				
				
				if(n_item.equals(0)){
					out.print("{\"status\":\"empty\",\"hasil\":\"[]\"}");
				}else{
					while (rs2.next()) {
					  	barang_data b=new barang_data();
					  	b.setId_barang(rs2.getObject(1).toString());
					  	b.setNama_barang(rs2.getObject(2).toString());
					  	b.setGambar_barang(rs2.getObject(3).toString());
					  	b.setHarga_barang(rs2.getObject(4).toString());
					  	b.setKategori_barang(rs2.getObject(5).toString());
					  	b.setN_beli(rs2.getObject(6).toString());
					  	b.setKeterangan(rs2.getObject(7).toString());
					  	b.setStok(rs2.getObject(8).toString());
					  	Hasil_search.add(b);
					  	
			  		}
				}
				
				
			  int nextLaman = laman+1;
			  int prevLaman = laman-1;
			  
			  Gson gson = new Gson();
			  String output_search=gson.toJson(Hasil_search);
			  out.print("{\"status\":\"success\",\"link\":{\"name\":\""+name+"\",\"harga\":\""+harga+"\",\"next_laman\":\""+nextLaman+"\",\"prev_laman\":\""+prevLaman+"\",\"kategori\":\""+kategori+"\",\"n_item\":\""+n_item+"\"},\"output_search\":\""+output_search+"\"}");
			  
				
				
				
			}else if(action.equals("insert")){
			
				Statement statement = con.createStatement();
				String nama = parameter[0];
				String gambar = parameter[1];
				Integer harga = Integer.parseInt(parameter[2]);
				Integer kategori = Integer.parseInt(parameter[3]);
				Integer n_beli = Integer.parseInt(parameter[4]);
				String keterangan = parameter[5];
				Integer stok = Integer.parseInt(parameter[6]);
				
				
				String query = "INSERT INTO `barang` (nama_barang,gambar_barang,harga_barang,kategori_barang,n_beli,keterangan,stok) VALUES (\'"+nama+"\',\'"+gambar+"\',"+harga+","+kategori+","+n_beli+",\'"+keterangan+"\',"+stok+")";
				
				
				int status = statement.executeUpdate(query);
				
				if(status==1){
					out.print("{ \"status\" : \"success\" }");
				}else{
					out.print("{ \"status\" : \"failed\" }");
				}
				
			}else if(action.equals("cari_by_id")){
			
				Statement statement = con.createStatement();
				
				String id = parameter[0];
				boolean status = false;
				
				ResultSet rs = statement.executeQuery("SELECT * FROM barang where id_barang="+id+"");
				status = rs.next();
				
				barang_data b = new barang_data();
				String output = new String();
				if(status){
					b.setId_barang(rs.getObject(1).toString());
				  	b.setNama_barang(rs.getObject(2).toString());
				  	b.setGambar_barang(rs.getObject(3).toString());
				  	b.setHarga_barang(rs.getObject(4).toString());
				  	b.setKategori_barang(rs.getObject(5).toString());
				  	b.setN_beli(rs.getObject(6).toString());
				  	b.setKeterangan(rs.getObject(7).toString());
				  	b.setStok(rs.getObject(8).toString());
				  	Gson gson=new Gson();
				  	output = gson.toJson(b);
				}
			  	
				if (status)
					out.print("{ \"Status_operasi\" : \"success\" , \"output_search\" : \""+output+"\"}");
				else
					out.print("{ \"Status_operasi\" : \"failed\" }");
					
			}else if(action.equals("update")){

				Statement statement = con.createStatement();
				String nama = parameter[0];
				String gambar = parameter[1];
				Integer harga = Integer.parseInt(parameter[2]);
				Integer kategori = Integer.parseInt(parameter[3]);
				Integer n_beli = Integer.parseInt(parameter[4]);
				String keterangan = parameter[5];
				Integer stok = Integer.parseInt(parameter[6]);
				
				
				String query = "UPDATE `barang` SET nama_barang=\'"+nama+"\',gambar_barang=\'"+gambar+"\',harga_barang=\'"+harga+"\',kategori_barang=\'"+kategori+"\',n_beli=\'"+n_beli+"\',keterangan=\'"+keterangan+"\',stok=\'"+stok+"\'";
				
				
				int status = statement.executeUpdate(query);
				
				if(status==1){
					out.print("{ \"status\" : \"success\" }");
				}else{
					out.print("{ \"status\" : \"failed\" }");
				}
			}else if(action.equals("delete")){
				Statement statement = con.createStatement();
				Integer id=Integer.parseInt(parameter[0]);
				
				String query = "DELETE FROM `barang` WHERE id_barang="+id;
				
				int status = statement.executeUpdate(query);
				
				if(status==1){
					out.print("{ \"status\" : \"success\" }");
				}else{
					out.print("{ \"status\" : \"failed\" }");
				}
			}
		}catch(Exception e){
			
		}
	}
}
