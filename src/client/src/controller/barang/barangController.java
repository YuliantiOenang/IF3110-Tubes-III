package controller.barang;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import controller.Render;
import model.*;

@WebServlet("/barang/barangController")
public class barangController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public barangController() {
		super();
        // TODO Auto-generated constructor stub
    }
	
	private HashMap<String,String> data;
	private Barang barang;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		barang = new Barang();
		data = barang.findById((int) request.getAttribute("id"));
		if (data.isEmpty()) {
			Render.Show(request, response, "Home.jsp");
		}
		request.setAttribute("model", data);
		Render.Show(request, response, "barang.jsp"); 
		
	}
	

}
