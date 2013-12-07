package controller;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class coba
 */
@WebServlet("/coba")
public class coba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order model = new Order();
		model.findAll();
		request.setAttribute("styles",model.getDataCount());
		System.out.println(model.getDataCount());
		Barang modelA = new Barang();
		modelA.findAll();
		System.out.println(modelA.getDataCount()+" Barang");
		//request.setAttribute("provinsi", Provinsi);
	    //RequestDispatcher view = request.getRequestDispatcher("Register.jsp");
	    //view.forward(request, response); 
	}
}
