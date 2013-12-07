package npackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
/**
 * Servlet implementation class LoginServlet
 */
public class getadmin extends HttpServlet {


@Override
public void doGet(HttpServletRequest request,
				  HttpServletResponse response)
	throws IOException, ServletException
{
	doPost(request, response);
}
	   
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, java.io.IOException {

			try
			{	    

				UserBean user = new UserBean();
			
				user.setType("getsearch");
				
				
				user.setQuery("SELECT * FROM Barang Where Kategori = 'Beras'" );
				user = UserDAO.login(user);
				ArrayList<Barang> barangs = new ArrayList<Barang>();
				barangs = user.getsearch();
				
				HttpSession session = request.getSession(true);	  
				session.setAttribute("jumlahadmberas",barangs.size());
				for (int i = 0; i<barangs.size();i++){
					String snama = "admberasnama" + (i+1);
					String sid = "admberasid" + (i+1);
					String sharga = "admberasharga" + (i+1);
					String skategori = "admberaskategori" + (i+1);
					String sjumlah = "admberasjumlah" + (i+1);
					
					session.setAttribute(snama,barangs.get(i).getNama());
					session.setAttribute(sid,barangs.get(i).getId());
					session.setAttribute(sharga,barangs.get(i).getHarga());
					session.setAttribute(skategori,barangs.get(i).getKategori());
					session.setAttribute(sjumlah,barangs.get(i).getJumlah());	
					String sdeskripsi = "admberasdeskripsi" + (i+1);
					session.setAttribute(sdeskripsi,barangs.get(i).getDeskripsi());	
				}
				
				user.clearArraylist();
				user.setQuery("SELECT * FROM Barang Where Kategori = 'Daging'" );
				user = UserDAO.login(user);
				barangs = new ArrayList<Barang>();
				barangs = user.getsearch();
				
				session.setAttribute("jumlahadmdaging",barangs.size());
				for (int i = 0; i<barangs.size();i++){
					String snama = "admdagingnama" + (i+1);
					String sid = "admdagingid" + (i+1);
					String sharga = "admdagingharga" + (i+1);
					String skategori = "admdagingkategori" + (i+1);
					String sjumlah = "admdagingjumlah" + (i+1);
					session.setAttribute(snama,barangs.get(i).getNama());
					session.setAttribute(sid,barangs.get(i).getId());
					session.setAttribute(sharga,barangs.get(i).getHarga());
					session.setAttribute(skategori,barangs.get(i).getKategori());
					session.setAttribute(sjumlah,barangs.get(i).getJumlah());	

					String sdeskripsi = "admdagingdeskripsi" + (i+1);
					session.setAttribute(sdeskripsi,barangs.get(i).getDeskripsi());						
				}
				
				user.clearArraylist();
				user.setQuery("SELECT * FROM Barang Where Kategori = 'Sayuran'" );
				user = UserDAO.login(user);
				barangs = new ArrayList<Barang>();
				barangs = user.getsearch();
				
				session.setAttribute("jumlahadmsayuran",barangs.size());
				for (int i = 0; i<barangs.size();i++){
					String snama = "admsayurannama" + (i+1);
					String sid = "admsayuranid" + (i+1);
					String sharga = "admsayuranharga" + (i+1);
					String skategori = "admsayurankategori" + (i+1);
					String sjumlah = "admsayuranjumlah" + (i+1);
					session.setAttribute(snama,barangs.get(i).getNama());
					session.setAttribute(sid,barangs.get(i).getId());
					session.setAttribute(sharga,barangs.get(i).getHarga());
					session.setAttribute(skategori,barangs.get(i).getKategori());
					session.setAttribute(sjumlah,barangs.get(i).getJumlah());	

					String sdeskripsi = "admsayurandeskripsi" + (i+1);
					session.setAttribute(sdeskripsi,barangs.get(i).getDeskripsi());						
				}
				
				user.clearArraylist();
				user.setQuery("SELECT * FROM Barang Where Kategori = 'Frozen Food'" );
				user = UserDAO.login(user);
				barangs = new ArrayList<Barang>();
				barangs = user.getsearch();
				
				session.setAttribute("jumlahadmfrozen",barangs.size());
				for (int i = 0; i<barangs.size();i++){
					String snama = "admfrozennama" + (i+1);
					String sid = "admfrozenid" + (i+1);
					String sharga = "admfrozenharga" + (i+1);
					String skategori = "admfrozenkategori" + (i+1);
					String sjumlah = "admfrozenjumlah" + (i+1);
					session.setAttribute(snama,barangs.get(i).getNama());
					session.setAttribute(sid,barangs.get(i).getId());
					session.setAttribute(sharga,barangs.get(i).getHarga());
					session.setAttribute(skategori,barangs.get(i).getKategori());
					session.setAttribute(sjumlah,barangs.get(i).getJumlah());	

					String sdeskripsi = "admfrozendeskripsi" + (i+1);
					session.setAttribute(sdeskripsi,barangs.get(i).getDeskripsi());						
				}
				
				user.clearArraylist();
				user.setQuery("SELECT * FROM Barang Where Kategori = 'Snack'" );
				user = UserDAO.login(user);
				barangs = new ArrayList<Barang>();
				barangs = user.getsearch();
				
				session.setAttribute("jumlahadmsnack",barangs.size());
				for (int i = 0; i<barangs.size();i++){
					String snama = "admsnacknama" + (i+1);
					String sid = "admsnackid" + (i+1);
					String sharga = "admsnackharga" + (i+1);
					String skategori = "admsnackkategori" + (i+1);
					String sjumlah = "admsnackjumlah" + (i+1);
					session.setAttribute(snama,barangs.get(i).getNama());
					session.setAttribute(sid,barangs.get(i).getId());
					session.setAttribute(sharga,barangs.get(i).getHarga());
					session.setAttribute(skategori,barangs.get(i).getKategori());
					session.setAttribute(sjumlah,barangs.get(i).getJumlah());

					String sdeskripsi = "admsnackdeskripsi" + (i+1);
					session.setAttribute(sdeskripsi,barangs.get(i).getDeskripsi());						
				}
				
				
				response.sendRedirect("admin.jsp");
			}		
			catch (Throwable theException) 	    
			{
				 System.out.println(theException); 
			}
    }
}
