package npackage;

   import java.text.*;
   import java.util.*;
   import java.sql.*;

   public class UserDAO 	
   {
      static Connection currentCon = null;
      static ResultSet rs = null;  
	
	
	
      public static UserBean login(UserBean bean) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
	
       
	    
         String searchQuery =bean.getQuery();
		
	    
     
	    
      try 
      {
         //connect to DB 
         currentCon = ConnectionManager.getConnection();
         stmt=currentCon.createStatement();
		
         stmt.execute(searchQuery);	
		 
		 
		 boolean more = false;
		rs = stmt.getResultSet();
		if (rs!=null){
			more = rs.next();
		}
	       
         // if user does not exist set the isValid variable to false	        
         //if user exists set the isValid variable to true
        if (more){
			if (bean.getType()=="login"){
			
				bean.setUserName(rs.getString("username"));
				bean.setPassword(rs.getString("password"));			
				bean.setNoCredit(rs.getString("nocredit"));
			   
			}
			if (bean.getType()=="getdatamember"){
				bean.setUserName(rs.getString("username"));
				bean.setPassword(rs.getString("password"));			
				bean.setNoCredit(rs.getString("nocredit"));
				bean.setEmail(rs.getString("email"));
				bean.setNamaLengkap(rs.getString("namalengkap"));
				bean.setNoHP(rs.getString("nohp"));
				bean.setProvinsi(rs.getString("provinsi"));
				bean.setKotaKabupaten(rs.getString("kotakabupaten"));
				bean.setAlamat(rs.getString("alamat"));
				bean.setKodePos(rs.getString("kodepos"));
			}
			if (bean.getType()=="getjumlahtransaksi"){
				bean.setJumlahTransaksi(rs.getString("COUNT"));
			}
			if(bean.getType()=="getbestbuy"){
				bean.setbestbuy1(rs.getString(1));
				rs.next();
				bean.setbestbuy2(rs.getString(1));
				rs.next();
				bean.setbestbuy3(rs.getString(1));
			}
			if (bean.getType()=="getsearch"){
				Barang barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				barang.setDeskripsi(rs.getString("Deskripsi"));
				bean.setsearch(barang);
				while (rs.next()){
				//ambil hasil result search	
				barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				barang.setDeskripsi(rs.getString("Deskripsi"));
				bean.setsearch(barang);
				
				}
			
				
			}
			if (bean.getType()=="getberas"){
				Barang barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setberas(barang);
				while (rs.next()){
				//ambil hasil result search	
				barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setberas(barang);
				
				}
			}
			if (bean.getType()=="getdaging"){
				Barang barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setdaging(barang);
				while (rs.next()){
				//ambil hasil result search	
				barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setdaging(barang);
				
				}
			}
			if (bean.getType()=="getsayuran"){
				Barang barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setsayuran(barang);
				while (rs.next()){
				//ambil hasil result search	
				barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setsayuran(barang);
				
				}
			}
			if (bean.getType()=="getfrozen"){
				Barang barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setfrozen(barang);
				while (rs.next()){
				//ambil hasil result search	
				barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setfrozen(barang);
				
				}
			}
			if (bean.getType()=="getsnack"){
				Barang barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setsnack(barang);
				while (rs.next()){
				//ambil hasil result search	
				barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				bean.setsnack(barang);
				
				}
			}
			if (bean.getType()=="getbarang"){
				Barang barang = new Barang(rs.getInt("IdBarang"),rs.getString("NamaBarang"),rs.getInt("Harga"),rs.getString("Kategori"),rs.getInt("Jumlah"));
				barang.setDeskripsi(rs.getString("Deskripsi"));
				bean.setbarang(barang);
			}
			
			
            bean.setValid(true);
         }else{
			 bean.setValid(false);
		 
		 }
		 
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

return bean;
	
      }	
   }