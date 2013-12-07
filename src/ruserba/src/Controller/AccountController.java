package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import javaModel.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Account user = Account.findByPk(id);
            if (user != null) {
                JSONObject json = new JSONObject();
                json.put("status", "true");
                json.put("data", user.toJSON());
                out.println(json.toString());
            } else {
                out.println("{\"status\":\"false\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // out.println(java.lang.System.getenv("VCAP_SERVICES"));
        // out.println(GlobalConfig.SQLUser);
        // out.println(GlobalConfig.SQLPass);
        // out.println(GlobalConfig.URLSQL);
        // out.println(GlobalConfig.check);
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account user = Account.find("SELECT * FROM account WHERE username = '" + username + "' AND password = '" + password + "'");
        try {
            if (user != null) {
                JSONObject json = new JSONObject();
                json.put("status", "true");
                json.put("data", user.toJSON());
                out.println(json.toString());
            } else {
                out.println("{\"status\":\"false\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = resp.getWriter();
        BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String input = in.readLine();
        String[] datas = input.split("&");
        HashMap<String, String> map = new HashMap<String, String>();
        for (String data : datas) {
            System.out.println(data);
            String[] tuple = data.split("=");
            String key = URLDecoder.decode(tuple[0], "UTF-8");
            String value = URLDecoder.decode(tuple[1], "UTF-8");
            map.put(key, value);
        }
        
        Integer id = Integer.parseInt(map.get("id"));
        Account user = Account.findByPk(id);
        try {
            if (user != null) {
                // parameter atribut account
                // user.username = map.get("username");
                if (map.get("password")!=null)
                    user.password = map.get("password");
                if (map.get("nama")!=null)
                    user.nama = map.get("nama");
                // user.email = map.get("email");
                if (map.get("alamat")!=null)
                    user.alamat = map.get("alamat");
                if (map.get("provinsi")!=null)
                    user.provinsi = map.get("provinsi");
                if (map.get("kota")!=null)
                    user.kota = map.get("kota");
                if (map.get("kodepos")!=null)
                    user.kodepos = map.get("kodepos");
                if (map.get("telepon")!=null)
                    user.telepon = map.get("telepon");
                // user.role = Integer.parseInt(map.get("role"));
                if (map.get("transaksi")!=null)
                    user.transaksi = Integer.parseInt(map.get("transaksi"));
                System.out.println(user.kota);
                user.save();
                JSONObject json = new JSONObject();
                json.put("status", true);
                out.write(json.toString());
            } else {
                JSONObject json = new JSONObject();
                json.put("status", false);
                out.write(json.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }
}
