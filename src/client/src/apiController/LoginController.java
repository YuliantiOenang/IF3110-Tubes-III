package apiController;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javaModel.RestClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/api/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA = new DatabaseAdapter();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String input = "username=" + username + "&password=" + password;
            String output = RestClient.doPost("account", input);
            System.out.println(output);
            JSONObject json = new JSONObject(output);
            if (Boolean.parseBoolean(json.get("status").toString())) {
                JSONObject user = (JSONObject) json.get("data");

                // login berhasil
                HttpSession session = request.getSession();
                session.setAttribute("isLogin", true);
                session.setAttribute("username", user.get("username").toString());
                session.setAttribute("id", Integer.parseInt(user.get("id").toString()));
                session.setAttribute("role", Integer.parseInt(user.get("role").toString()));
                session.setMaxInactiveInterval(0);

                Cookie C = new Cookie("isLogin", username);
                C.setMaxAge(60 * 60 * 24 * 30); // 30 Hari
                C.setPath("/");
                response.addCookie(C);

                JSONObject jsons = new JSONObject();
                jsons.put("success", true);
                out.write(jsons.toString());
            } else {
                // login gagal
                JSONObject jsons = new JSONObject();
                jsons.put("success", false);
                out.write(jsons.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.close();
    }

}
