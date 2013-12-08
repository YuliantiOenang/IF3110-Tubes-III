package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class BarangController
 */
public class BarangController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarangController() {
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
        if (action == null) action = "";
        try {
            if (action.equals("read")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Barang barang = Barang.findByPk(id);
                if (barang != null) {
                    JSONObject json = new JSONObject();
                    json.put("status", "true");
                    json.put("data", barang.toJSON());
                    out.write(json.toString());
                } else {
                    out.write("{\"status\":\"false\"}");
                }
            } else if (action.equals("readAll")) {
                String id_kategori = request.getParameter("id_kategori");
                ArrayList<Barang> barangs = Barang.findAll("SELECT * FROM barang WHERE id_kategori = '" + id_kategori + "'");
                if (barangs.size() > 0) {
                    ArrayList<JSONObject> jsons = new ArrayList<JSONObject>();
                    for (Barang barang : barangs)
                        jsons.add(barang.toJSON());
                    JSONObject json = new JSONObject();
                    json.put("status", "true");
                    json.put("data", new JSONArray(jsons));
                    out.write(json.toString());
                } else {
                    out.write("{\"status\":\"false\"}");
                }
            } else if (action.equals("readTopThree")) {
                ArrayList<JSONObject> jsons = new ArrayList<JSONObject>();
                JSONObject json = new JSONObject();
                json.put("status", "true");
                for (int i = 1; i <= 3; i++) {
                    ArrayList<Barang> barangs = Barang.findAll("SELECT * FROM barang WHERE id_kategori = '" + i + "' ORDER BY counter DESC LIMIT 0, 4");
                    for (Barang barang : barangs)
                        jsons.add(barang.toJSON());
                }
                json.put("data", new JSONArray(jsons));
                out.write(json.toString());
            } else if (action.equals("search")) {
                String nama = request.getParameter("search");
                String kategori = request.getParameter("kategori");
                String harga = request.getParameter("harga");
                String operator = request.getParameter("operator");
                String sort = request.getParameter("sort");
                String jenisSort = request.getParameter("jenisSort");
                String page = request.getParameter("page");

                String query = "SELECT barang.* FROM barang JOIN kategori ON barang.id_kategori = kategori.id";

                ArrayList<Barang> jumlah = Barang.findAll("SELECT * FROM barang");
                Integer jmlData = jumlah.size();

                if (nama != null && !nama.equals("")) {
                    query += " AND barang.nama like '%" + nama + "%' ";
                }
                if (kategori != null && !kategori.equals("")) {
                    query += " AND kategori.nama_kategori like '%" + kategori + "%' ";
                }
                if (harga != null && !harga.equals("") && operator != null && !operator.equals("")) {
                    if (operator.equals("L"))
                        query += " AND barang.harga < " + harga + " ";
                    else if (operator.equals("E"))
                        query += " AND barang.harga = " + harga + " ";
                    else if (operator.equals("G"))
                        query += " AND barang.harga > " + harga + " ";
                }
                if ((sort != null) && (jenisSort != null)) {
                    if (sort.equals("nama"))
                        query += " ORDER BY barang.nama ";
                    else if (sort.equals("kategori"))
                        query += " ORDER BY kategori.nama_kategori ";
                    else if (sort.equals("harga"))
                        query += " ORDER BY barang.harga ";
                    query += " " + jenisSort;
                }
                if (page != null && !page.equals("")) {
                    Integer limit = Integer.parseInt(page) * 10;
                    Integer offset = limit - 10;
                    query += " LIMIT " + offset + ", 10 ";
                }
                // ArrayList<JSONObject> jsons = new ArrayList<JSONObject>();
                ArrayList<Barang> barangs = Barang.findAll(query);
                // for (Barang barang : barangs)
                // jsons.add(barang.toJSON());
                // out.write(jsons.toString());
                int size = barangs.size();
                int i;
                String str = "";
                for (i = 0; i < size; i++) {
                    str += "<div class=\"itembox\">";
                    str += "    <div class=\"pict\" id=\"item" + barangs.get(i).id + "\">";
                    str += "        <div title=\"Ready Stock\" class=\"itembox_img\">";
                    str += "            <img onload=\"fitbarang(this)\" src=\"/ruserba/images/barang/" + barangs.get(i).gambar + "\">";
                    str += "        </div>";
                    str += "        <div class=\"minicart_icon\">";
                    str += "            <a href=\"#\" onclick=\"goToCart(" + barangs.get(i).id + "); return false;\"><img src=\"/ruserba/img/site/cart_black.png\"></a>";
                    str += "        </div>";
                    str += "        <div class=\"item_name\"><a href=\"/ruserba/barang/detail?id=" + barangs.get(i).id + "\">" + barangs.get(i).nama + "</a><br>IDR " + barangs.get(i).harga + "</div>";
                    str += "    </div>";
                    str += "    <div class=\"minicart hidden\" id=\"cart" + barangs.get(i).id + "\">";
                    str += "        <form id=\"form-shop-" + barangs.get(i).id + "\" method=\"post\" onsubmit=\"pertanyaan(" + barangs.get(i).id + "," + barangs.get(i).stok + "); return false;\">";
                    str += "            <label class=\"qty small\">Quantity</label>";
                    str += "            <input type=\"number\" name=\"quantity\" id=\"quantity_" + barangs.get(i).id + "\" class=\"qty\" value=\"1\">";
                    str += "            <input type=\"hidden\" name=\"id_barang\" id=\"id_barang_" + barangs.get(i).id + "\" value=\"" + barangs.get(i).id + "\">";
                    str += "            <p>Request Message :</p>";
                    str += "            <textarea class=\"req_msg small\" name=\"req_msg\" id=\"keterangan_" + barangs.get(i).id + "\"></textarea>";
                    str += "            <input type=\"submit\" class=\"cart small\" value=\"Add to Cart\">";
                    str += "            <p class=\"back\" href=\"#\" onclick=\"backToPict(" + barangs.get(i).id + ")\">back</p>";
                    str += "        </form>";
                    str += "    </div>";
                    str += "</div>";
                }
                JSONObject json = new JSONObject();
                json.put("content", str);
                json.put("pageOf", page);
                json.put("jmlPage", jmlData / 10);
                out.write(json.toString());
            } else if (action.equals("admin")) {
                String kateg = request.getParameter("kateg");
                String query = "SELECT * FROM barang WHERE id_kategori = '" + kateg + "'";
                ArrayList<JSONObject> jsons = new ArrayList<JSONObject>();
                ArrayList<Barang> barangs = Barang.findAll(query);
                for (Barang barang : barangs)
                    jsons.add(barang.toJSON());
                out.write(jsons.toString());
            } else if (action.equals("adminEdit")) {
                String id_barang = request.getParameter("id_barang");
                Barang barang = Barang.findByPk(Integer.parseInt(id_barang));
                if (barang != null) {
                    out.write(barang.toJSON().toString());
                }
            } else if (action.equals("cekNama")) {
                String nama_barang = request.getParameter("nama");
                Barang barang = Barang.find("SELECT * FROM barang WHERE nama = '" + nama_barang + "'");
                JSONObject json = new JSONObject();
                if (barang != null) {
                    json.put("content", "TIDAK UNIK");
                } else {
                    json.put("content", "UNIK");
                }
                out.write(json.toString());
            } else if (action.equals("suggestion")) {
                String name = request.getParameter("nama");
                String str = "";
                JSONObject json = new JSONObject();
                if (!name.equals("")) {
                    // String Query =
                    // "select * from barang where nama LIKE '%"+name+"%'";
                    // DBA.executeQuery(Query);
                    // System.out.println(Query);
                    ArrayList<Barang> barangs = Barang.findAll("SELECT * FROM barang WHERE nama LIKE '%" + name + "%'");

                    str = str + "<ul>";
                    for (Barang B : barangs) {
                        str = str + "<li>";
                        str = str + "<a href=\"#\" onclick=\"suggestions(this);\">";
                        str = str + B.nama;
                        str = str + "</a>";
                        str = str + "</li>";
                    }
                    str = str + "</ul>";
                }
                json.put("content", str);
                out.write(json.toString());
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
            String[] tuple = data.split("=");
            if (tuple.length > 1) {
                String key = URLDecoder.decode(tuple[0], "UTF-8");
                String value = URLDecoder.decode(tuple[1], "UTF-8");
                map.put(key, value);
            }
        }
        Integer id = Integer.parseInt(map.get("id"));

        Barang barang = Barang.findByPk(id);
        try {
            if (barang != null) {
                // parameter atribut account
                if (map.get("id_kategori") != null)
                    barang.id_kategori = Integer.parseInt(map.get("id_kategori"));
                if (map.get("nama") != null)
                    barang.nama = map.get("nama");
                if (map.get("harga") != null)
                    barang.harga = Integer.parseInt(map.get("harga"));
                if (map.get("gambar") != null)
                    barang.gambar = map.get("gambar");
                if (map.get("stok") != null)
                    barang.stok = Integer.parseInt(map.get("stok"));
                if (map.get("counter") != null)
                    barang.counter = Integer.parseInt(map.get("counter"));
                if (map.get("keterangan") != null)
                    barang.keterangan = map.get("keterangan");
                barang.save();
                JSONObject json = new JSONObject();
                json.put("status", "true");
                out.write(json.toString());
            } else {
                out.write("{\"status\":\"false\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = resp.getWriter();
        // BufferedReader in = new BufferedReader(new
        // InputStreamReader(req.getInputStream()));
        // String[] tuple = in.readLine().split("=");
        int id = Integer.parseInt(req.getParameter("id"));

        Barang barang = Barang.findByPk(id);
        try {
            if (barang != null) {
                barang.delete();
                JSONObject json = new JSONObject();
                json.put("status", "true");
                out.write(json.toString());
            } else
                out.write("{\"status\":\"false\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }
}
