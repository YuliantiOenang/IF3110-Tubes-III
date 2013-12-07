package javaModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.http.HttpException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class Kategori {
    private DatabaseAdapter DBA;
    public ArrayList<String> id = new ArrayList<String>();
    public ArrayList<String> nama_kategori = new ArrayList<String>();
    public ArrayList<String> gambar = new ArrayList<String>();
    public ArrayList<String> deskripsi = new ArrayList<String>();
    public ArrayList<String> sub_deskripsi = new ArrayList<String>();

    public Kategori(DatabaseAdapter _DBA) {
        DBA = _DBA;
    }

    public void executeQuery(String query) {
        DBA.executeQuery(query);
        ResultSet RS = DBA.getQueryResult();
        try {
            while (RS.next()) {
                id.add(RS.getObject(1).toString());
                nama_kategori.add(RS.getObject(2).toString());
                gambar.add(RS.getObject(3).toString());
                deskripsi.add(RS.getObject(4).toString());
                sub_deskripsi.add(RS.getObject(5).toString());
            }
        } catch (Exception e) {
        }
    }

    public void findAllRest() {
        String output = "";
        try {
            output = RestClient.doGet("kategori?action=readAll");
        } catch (HttpException | IOException | URISyntaxException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JSONObject json;
        try {
            json = new JSONObject(output);
            if (json.getBoolean("status")) {
                JSONArray jsarr = (JSONArray) json.get("data");
                for (int i = 0; i < jsarr.length(); i++) {
                    JSONObject kat = (JSONObject) jsarr.get(i);
                    id.add(kat.get("id").toString());
                    nama_kategori.add(kat.get("nama_kategori").toString());
                    gambar.add(kat.get("gambar").toString());
                    deskripsi.add(kat.get("deskripsi").toString());
                    sub_deskripsi.add(kat.get("sub_deskripsi").toString());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
