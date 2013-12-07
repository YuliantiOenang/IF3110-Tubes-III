package npackage;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
 
public class CartController extends HttpServlet {
  
 //public static final String addToCart

@Override 
public void doGet(HttpServletRequest request,
				  HttpServletResponse response)
	throws IOException, ServletException
{
	doPost(request, response);
}
 
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
	
	try
	{
		HttpSession session = request.getSession(true);
		String strAction = request.getParameter("action");
		
		if(strAction!=null && !strAction.equals("")) {
			if(strAction.equals("add")) {
				addToCart(request);
			} else if (strAction.equals("Update")) {
				updateCart(request);
			} else if (strAction.equals("Delete") && session.getAttribute("username")!=null) {
				deleteCart(request);
			} else if (strAction.equals("checkout")){
				buy(request,response);
			}
		}
		if(request.getParameter("pageasal")!=null){
			response.sendRedirect(request.getParameter("pageasal"));
		}else{
			response.sendRedirect("ShoppingBag.jsp");
		}
	}
	catch (Throwable theException) 	    
	{
		 System.out.println(theException); 
	}
}
 
protected void deleteCart(HttpServletRequest request) {
	HttpSession session = request.getSession();
	String strItemIndex = request.getParameter("itemIndex");
	Cart cart = null;
	
	Object objCart = session.getAttribute("cart");
	if(objCart!=null) {
		cart = (Cart) objCart ;
	} else {
		cart = new Cart();
	}
	cart.deleteCartItem(strItemIndex);
}
 
protected void updateCart(HttpServletRequest request) {
	HttpSession session = request.getSession();
	String strQuantity = request.getParameter("quantity");
	String strItemIndex = request.getParameter("itemIndex");
	
	Cart cart = null;
	
	Object objCart = session.getAttribute("cart");
	if(objCart!=null) {
		cart = (Cart) objCart ;
	} else {
		cart = new Cart();
	}
	cart.updateCartItem(strItemIndex, strQuantity);
}
 
protected void addToCart(HttpServletRequest request) {
	HttpSession session = request.getSession();
	String nama = request.getParameter("cartNama");
	String strHarga = request.getParameter("cartHarga");
	String kategori = request.getParameter("cartKategori");
	String strQuantity = request.getParameter("cartQuantity");
	String detail = request.getParameter("cartDetail");
	String jumProduk = request.getParameter("cartJumProduk");
	
	
	Cart cart = null;
	
	Object objCart = session.getAttribute("cart");
	
	if(objCart!=null) {
		cart = (Cart) objCart ;
	} else {
		cart = new Cart();
		session.setAttribute("cart", cart);
	}
	
	cart.addCartItem(nama, strHarga, kategori, strQuantity, detail, jumProduk);
}

public void updateDB(CartItem item, int sum){
	String nama = item.getNama();
	try
	{	
		int jum = sum;
	     UserBean user = new UserBean();
		 user.setType("updateDB");
		 user.setQuery("update barang set jumlah = "+jum+" where namabarang='"+nama+"' ");

		user = UserDAO.login(user);

	} catch (Throwable theException){
	     System.out.println(theException); 
	}
}

protected void buy(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession();
	Cart cart = null;
	Object objCart = session.getAttribute("cart");
	
	if(objCart!=null) {
		cart = (Cart) objCart ;
	} else {
		cart = new Cart();
		session.setAttribute("cart", cart);
	}
	
	String nama;   
	int harga;
	int quantity;
	String username;
	String kategori;
	String detail;
	int sum;
	
	try{
		for(int i = 0; i < cart.getItemCount(); i++){
			
			nama = cart.getCartItem(i).getNama();   
			harga = cart.getCartItem(i).getHarga();
			quantity = cart.getCartItem(i).getJumlah();
			username = (String)session.getAttribute("username");
			kategori = cart.getCartItem(i).getKategori();
			detail = cart.getCartItem(i).getDeatail();
			sum = cart.getCartItem(i).getJumProduk() - quantity;
			
			if (sum >= 0){
				UserBean user = new UserBean();
				user.setType("inserttransaction");
				user.setQuery("insert into transactionlog values('"+nama+"',"+harga+", "+quantity+", '"+username+"', '"+kategori+"', '"+detail+"')");
			
				user = UserDAO.login(user);
				updateDB(cart.getCartItem(i), sum);
			}
		}
		cart.remove();
		response.sendRedirect("ShoppingBag.jsp");
	}catch (Throwable theException){
		     System.out.println(theException); 
	}

}

}