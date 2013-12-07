package controller.barang;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Render;
import model.Barang;

@WebServlet("/barang/search")
public class search extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public search() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	private Vector<HashMap<String,String>> data;
	private Barang barang;
	
	String q;
	String kat;
	String h1, h2;
	int hal;
	String sort;
	int total;
	String paging;
	private static final String[] sortby = new String[] {"nama asc", "nama desc", "harga asc", "harga desc"};
	String query;
	String searchurl;
	String searchquery;
	String sorting;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		searchurl = "";
		if ((request.getParameter("q")!=null)&&(!request.getParameter("q").equals(""))) {
			query = "( (`nama` LIKE '%" + request.getParameter("q") + "%')";
			searchurl = searchurl + "q="+ request.getParameter("q")+"&";
		}
		else
			query = "( (`nama` LIKE '%%')";
		if ((request.getParameter("kat")!=null)&&(!request.getParameter("kat").equals(""))&&(!request.getParameter("kat").equals("0"))) {
			query = query + "AND ( `id_kategori` = " + request.getParameter("kat") + " )";
			searchurl = searchurl + "kat="+ request.getParameter("kat")+"&";
		}
		if ((request.getParameter("h1")!=null)&&(!request.getParameter("h1").equals(""))) {
			query = query + "AND ( `harga` >= " + request.getParameter("h1") + " )";
			searchurl = searchurl + "h1="+ request.getParameter("h1")+"&";
		}
		if (request.getParameter("h2")!=null&&(!request.getParameter("h2").equals(""))){
			query = query + "AND ( `harga` <= " + request.getParameter("h2") + " )";
			searchurl = searchurl + "h2="+ request.getParameter("h2")+"&";
		}
		query = query + ") ";
		sorting = "";
		searchquery = searchurl;
		if ((request.getParameter("sort")!=null)&&((request.getParameter("sort").equals("harga ASC"))||(request.getParameter("sort").equals("harga DESC"))||(request.getParameter("sort").equals("nama ASC"))||(request.getParameter("sort").equals("nama DESC")))){
			query = query + " ORDER BY " + request.getParameter("sort");
			searchurl = searchurl + "sort="+ request.getParameter("sort");
			sorting = request.getParameter("sort");
		}
		
		if (request.getParameter("hal")!=null)
			hal = Integer.parseInt(request.getParameter("hal"));
		else
			hal = 1;
		
		System.out.println(query);
		barang = new Barang();
		barang.findByCondition(query);
		barang.formatAllCurrency();
		data = barang.getDataVector();
		
		total = data.size();
		
		paging = barang.paginasi(total,hal,10, searchurl);
		request.setAttribute("title", "Search");
		request.setAttribute("model", data);
		request.setAttribute("paging", paging);
		request.setAttribute("halaman", hal);
		request.setAttribute("searchquery", searchquery);
		request.setAttribute("sorting", sorting);
		Render.Show(request, response, "../browse.jsp");

	}

}
