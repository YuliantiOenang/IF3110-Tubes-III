package soap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KreditSoapClient
 */
@WebServlet("/KreditSoapClient")
public class KreditSoapClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KreditSoapClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private String username;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		for (int i=0;i<cookies.length;i++){
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("isLogin")){
				username = cookie.getValue();
			}
		}
		/*if (username!=null){
			Profile p = new Profile();
			p.executeQuery("SELECT id WHERE username = " + username);
		}
		*/
		KreditSoapProxy kss = new KreditSoapProxy();
		Integer id_account = Integer.parseInt("");
		String card_number = request.getParameter("card_number");
		String name_of_card = request.getParameter("name_of_card"); 
		String expired_date = request.getParameter("expired_date");
		kss.createKredit(id_account, card_number, name_of_card, expired_date);
	}

}
