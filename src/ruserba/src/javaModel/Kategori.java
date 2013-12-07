package javaModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class Kategori {
    public int id;
    public String nama_kategori, gambar, deskripsi, sub_deskripsi;
    private static DatabaseAdapter DBA = new DatabaseAdapter();
    private static ResultSet result;

    public Kategori() {
        id = -1;
    }


    // find 1 row data of kategori based on query
    public static Kategori find(String query) {
        Kategori kategori = null;
        try {
            DBA = new DatabaseAdapter();
            DBA.executeQuery(query);
            result = DBA.getQueryResult();
            if (!result.isBeforeFirst()) return kategori;
            if (result.next()) {
                kategori = new Kategori();
                kategori.id = Integer.parseInt(result.getString(1));
                kategori.nama_kategori = result.getString(2);
                kategori.gambar = result.getString(3);
                kategori.deskripsi = result.getString(4);
                kategori.sub_deskripsi = result.getString(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBA.endQuery();
        }
        return kategori;
    }

    // find 1 row data of kategori based on primary key
    public static Kategori findByPk(int id) {
        return find("SELECT * FROM kategori WHERE id=" + id);
    }

    // find all data of kategori based on query
    public static ArrayList<Kategori> findAll(String query) {
        ArrayList<Kategori> kategoris = new ArrayList<Kategori>();
        try {
            DBA = new DatabaseAdapter();
            DBA.executeQuery(query);
            result = DBA.getQueryResult();
            if (!result.isBeforeFirst()) return kategoris;
            while (result.next()) {
                Kategori kategori = new Kategori();
                kategori.id = Integer.parseInt(result.getString(1));
                kategori.nama_kategori = result.getString(2);
                kategori.gambar = result.getString(3);
                kategori.deskripsi = result.getString(4);
                kategori.sub_deskripsi = result.getString(5);
                kategoris.add(kategori);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBA.endQuery();
        }
        return kategoris;
    }


    // save kategori to db
    public void save() {
        String query;
        if (id == -1) // new
            query = "INSERT INTO kategori (nama_kategori, gambar, deskripsi, sub_deskripsi) VALUES ('" + nama_kategori + "', '" + gambar + "', '" + deskripsi + "', '" + sub_deskripsi + "')";
        else
            query = "UPDATE kategori SET nama_kategori = '" + nama_kategori + "', gambar = '" + gambar + "', deskripsi = '" + deskripsi + "', sub_deskripsi = '" + sub_deskripsi + "' WHERE id = " + id;
        DBA = new DatabaseAdapter();
        DBA.insertQuery(query);
        DBA.endQuery();
    }

    // delete kategori from db
    public void delete() {
        String query = "DELETE FROM kategori WHERE id=" + id;
        DBA = new DatabaseAdapter();
        DBA.deleteQuery(query);
        DBA.endQuery();
    }
    
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("nama_kategori", nama_kategori);
            json.put("gambar", gambar);
            json.put("deskripsi", deskripsi);
            json.put("sub_deskripsi", sub_deskripsi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}