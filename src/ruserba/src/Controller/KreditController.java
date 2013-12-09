package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javaModel.Kredit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class KreditController
 */
@WebServlet("/KreditController")
public class KreditController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KreditController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        try {
            if (action.equals("cekKredit")) {
                String credit_number = request.getParameter("credit_number");
                String name_of_card = request.getParameter("name_of_card");
                Kredit K = Kredit.find("select * from kredit where card_number = '" + credit_number + "' or name_of_card = '" + name_of_card + "'");
                JSONObject json = new JSONObject();
                if (K != null) {
                    json.put("success", false);
                    json.put("error", "Card Number atau Name of Card sudah dipakai");
                } else {
                    json.put("success", true);
                }
                out.write(json.toString());
            } else {
                String id_account = request.getParameter("id_account");
                Kredit kredit = Kredit.find("SELECT * FROM kredit WHERE id_account = '" + id_account + "'");
                if (kredit != null) {
                    JSONObject json = new JSONObject();
                    json.put("status", "true");
                    json.put("data", kredit.toJSON());
                    out.println(json.toString());
                } else {
                    out.println("{\"status\":\"false\"}");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
