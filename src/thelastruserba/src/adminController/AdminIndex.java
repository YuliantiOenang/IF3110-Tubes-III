package adminController;

//URL MAP : @WebServlet("/AdminIndex")
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
 * Servlet implementation class AdminIndex
 */

public class AdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DatabaseAdapter DBA;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndex() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

    private String genQuery(HttpServletRequest request)
    {
    	String Query = "select barang.id, barang.nama, barang.harga, " +
				"barang.gambar, barang.stok, kategori.nama_kategori, kategori.gambar from barang" +
				" join kategori on barang.id_kategori = kategori.id";
		
		/* Berdasarkan nama */
		String nameSearch = request.getParameter("search");
		if ((nameSearch != null) && (!nameSearch.equals("")))
		{
			Query = Query + " AND barang.nama LIKE '%"+nameSearch+"%' ";
		}
		
		/* Berdasarkan kategori */
		String kategori = request.getParameter("kategori");
		if ((kategori != null) && (!kategori.equals("")))
		{
			Query = Query + " AND kategori.nama_kategori LIKE '%"+kategori+"%' ";
		}
		
		/* Berdasarkan harga */
		String harga = request.getParameter("harga");
		String operator = request.getParameter("operator");
		
		if ((harga != null) && (operator != null) && (!harga.equals("")) && (!operator.equals("")))
		{
			if (operator.equals("L"))
				Query = Query + " AND barang.harga < " + harga + " ";
			else if (operator.equals("E"))
				Query = Query + " AND barang.harga = " + harga + " ";
			else if (operator.equals("G"))
				Query = Query + " AND barang.harga > " + harga + " ";
		}
		/* Sorting */
		String sort = request.getParameter("sort");
		String JenisSort = request.getParameter("jenisSort");
		if ((sort != null) && (JenisSort != null))
		{
			if (sort.equals("nama")) Query = Query + " order by barang.nama ";
			else if (sort.equals("kategori")) Query = Query + " order by kategori.nama_kategori ";
			else if (sort.equals("harga")) Query = Query + " order by barang.harga ";
			
			Query = Query + " "+JenisSort;
		}
    	return Query;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String page = request.getParameter("page");
				if (page == null) page="1";
				
				try
				{
					Barang B2 = new Barang(DBA);
					B2.executeQuery("select * from barang");
					int jmlData = B2.nama.size();
					
					response.setContentType("application/json");
					response.setHeader("Access-Control-Allow-Origin", "*");
					//header harus diset
					PrintWriter out = response.getWriter();
					Integer limit = Integer.parseInt(page) * 10;
					Integer offset = limit - 10;
					String Query = genQuery(request);
					Query = Query + " LIMIT "+offset+",10 ";

					Barang B = new Barang(DBA);
					B.executeQuery2(Query);
//						System.out.println(Query);
					
					int size = B.nama.size();
					int i;
					String str="";
					for (i=0;i<size;i++)
					{
						str += "<div class=\"itembox\">";
						str += "	<div class=\"pict\" id=\"item"+B.id.get(i)+"\">";
						str += "		<div title=\"Ready Stock\" class=\"itembox_img\">";
						str += "			<img onload=\"fitbarang(this)\" src=\""+new GlobalConfig().URLService+"/images/barang/"+B.gambar.get(i)+"\">";
						str += "		</div>";
						str += "		<div class=\"minicart_menu\">";
						str += "			<a href='adminEditBarang.php?id="+B.id.get(i)+"' class=\"btn small\" >Edit</a>";
						str += "			<a href='#"+B.id.get(i)+"' onclick=\'deleteBarangConfirm("+B.id.get(i)+")" + "' class=\"btn small\" >Delete</a>";
						str += "		</div>";
						str += "		<div class=\"item_name\"><a href=\"/detailBarang.php?id="+B.id.get(i)+"\">"+B.nama.get(i)+"</a><br>IDR "+B.harga.get(i)+"</div>";
						str += "	</div>";
						str += "</div>";
					}
					JSONObject json = new JSONObject();
					json.put("content",str);
					json.put("pageOf",page);
					json.put("jmlPage", jmlData/10);
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
