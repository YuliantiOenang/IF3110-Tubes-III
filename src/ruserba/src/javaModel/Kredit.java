package javaModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class Kredit {
    public int id, id_account;
    public String card_number, name_of_card, expired_date;
    private static DatabaseAdapter DBA = new DatabaseAdapter();
    private static ResultSet result;

    public Kredit() {
        id = -1;
    }


    // find 1 row data of kredit based on query
    public static Kredit find(String query) {
        Kredit kredit = null;
        try {
            DBA = new DatabaseAdapter();
            DBA.executeQuery(query);
            result = DBA.getQueryResult();
            if (!result.isBeforeFirst()) return kredit;
            if (result.next()) {
                kredit = new Kredit();
                kredit.id = Integer.parseInt(result.getString(1));
                kredit.id_account = Integer.parseInt(result.getString(2));
                kredit.card_number = result.getString(3);
                kredit.name_of_card = result.getString(4);
                kredit.expired_date = result.getString(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBA.endQuery();
        }
        return kredit;
    }

    // find 1 row data of kredit based on primary key
    public static Kredit findByPk(int id) {
        return find("SELECT * FROM kredit WHERE id=" + id);
    }

    // find all data of kredit based on query
    public static ArrayList<Kredit> findAll(String query) {
        ArrayList<Kredit> kredits = new ArrayList<Kredit>();
        try {
            DBA = new DatabaseAdapter();
            DBA.executeQuery(query);
            result = DBA.getQueryResult();
            if (!result.isBeforeFirst()) return kredits;
            while (result.next()) {
                Kredit kredit = new Kredit();
                kredit.id = Integer.parseInt(result.getString(1));
                kredit.id_account = Integer.parseInt(result.getString(2));
                kredit.card_number = result.getString(3);
                kredit.name_of_card = result.getString(4);
                kredit.expired_date = result.getString(5);
                kredits.add(kredit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBA.endQuery();
        }
        return kredits;
    }


    // save kredit to db
    public void save() {
        String query;
        if (id == -1) // new
            query = "INSERT INTO kredit (id_account, card_number, name_of_card, expired_date) VALUES ('" + id_account + "', '" + card_number + "', '" + name_of_card + "', '" + expired_date + "')";
        else
            query = "UPDATE kredit SET id_account = '" + id_account + "', card_number = '" + card_number + "', name_of_card = '" + name_of_card + "', expired_date = '" + expired_date + "' WHERE id = " + id;
        DBA = new DatabaseAdapter();
        DBA.insertQuery(query);
        DBA.endQuery();
    }

    // delete kredit from db
    public void delete() {
        String query = "DELETE FROM kredit WHERE id=" + id;
        DBA = new DatabaseAdapter();
        DBA.deleteQuery(query);
        DBA.endQuery();

    }
    
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("id_account", id_account);
            json.put("card_number", card_number);
            json.put("name_of_card", name_of_card);
            json.put("expired_date", expired_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}