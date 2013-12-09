package userController;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javaModel.Helper;
import javaModel.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.entity.StringEntity;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class ProfileEditController
 */
@WebServlet("/profile/edit")
public class ProfileEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseAdapter DBA = new DatabaseAdapter();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String username = Helper.getUserLogged(request.getSession());
        if (username.isEmpty()) {
            response.sendRedirect("/ruserba/register");
            return;
        }
        Profile P = new Profile(DBA);
        P.fromRest(Helper.getUserId(request.getSession()));
        request.setAttribute("profile", P);
        request.setAttribute("includeJspContent", "profile_edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // String username = Helper.getUserLogged(request.getSession());
        Integer id = Helper.getUserId(request.getSession());
        String nama = request.getParameter("prof_nama");
        String password = request.getParameter("prof_password");
        String alamat = request.getParameter("prof_alamat");
        String provinsi = request.getParameter("prof_provinsi");
        String kota = request.getParameter("prof_kota");
        String kodepos = request.getParameter("prof_kodepos");
        String telepon = request.getParameter("prof_telepon");

        String params = "id="+id+"&nama=" + nama + "&password=" + password + "&alamat=" + alamat + "&provinsi=" + provinsi + "&kota=" + kota + "&kodepos=" + kodepos + "&telepon=" + telepon;
        System.out.println(params);
        Profile.updateRest(params);
        // String Query =
        // "UPDATE account SET nama = '"+prof_nama+"', alamat = '"+prof_alamat+"', provinsi = '"+prof_provinsi+"', kota = '"+prof_kota+"', kodepos = '"+prof_kodepos+"', telepon = '"+prof_telepon+"'";
        //
        // if (!prof_password.isEmpty()) Query +=
        // ", password = '"+prof_password+"'";
        //
        // Query += " WHERE username = '" + username + "'";
        // DBA.insertQuery(Query);

        response.sendRedirect("/ruserba/profile");
    }

}
