package barangController;

//URL MAP : /barang/detail?id=X

import java.io.IOException;
import java.io.PrintWriter;

import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Config.GlobalConfig;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class DetailBarang
 */
@WebServlet("/barang/detail")
public class DetailBarang extends HttpServlet {
	//Debug agar ridho punya library
	private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailBarang() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			String detail = request.getParameter("id");
			response.setContentType("application/json");
			response.setHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			if (detail == null)
			{
				json.put("status", false);
			}
			else
			{
				Barang B = new Barang(DBA);
				B.executeQuery("select * from barang where id="+detail);
				json.put("status", true);
				/*
				json.put("id", B.id.get(0));
				json.put("nama", B.nama.get(0));
				json.put("stok", B.stok.get(0));
				json.put("harga", B.harga.get(0));
				json.put("keterangan", B.keterangan.get(0));
				json.put("gambar", B.keterangan.get(0));
				*/
				String str="";
				str += "<h1 class=\"small-header\">"+B.nama.get(0)+"</h1>";
				str += "<div class=\"item_pict\"><img width=\"340\" height=\"340\" onload=\"fitpict(this)\" src=\""+new GlobalConfig().URLService+"/images/barang/"+B.gambar.get(0)+"\"></div>";
				str += "<div class=\"item_detail\"><h4>product description</h4><p>"+B.keterangan.get(0)+"</p></div>";
				str += "<div class=\"item_price\"><p>get it for :</p><h4>IDR "+B.harga.get(0)+"</h4><p>stok : "+B.stok.get(0)+"</p>";
				str += "<form id=\"form-shop\" action=\"#\" onsubmit=\"pertanyaan('"+B.nama.get(0)+"',"+B.id.get(0)+","+B.stok.get(0)+","+B.harga.get(0)+"); window.location.href='cart.php';\" method=\"post\">";
				str += "<label class=\"qty\">Quantity</label><input type=\"number\" value=\"1\" class=\"qty\" id=\"quantity_"+B.id.get(0)+"\" name=\"quantity\">";
				str += "<input type=\"hidden\" id=\"keterangan_"+B.id.get(0)+"\" name=\"id_barang\">";
				str += "<p>Request Message :</p>";
				str += "<textarea name=\"req_msg\" class=\"req_msg\"></textarea>";
				str += "<input type=\"submit\" value=\"Add to Cart\" class=\"cart\"></form></div>";
				json.put("content", str);
			}
			out.write(json.toString());
			out.close();
		}catch (Exception e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
