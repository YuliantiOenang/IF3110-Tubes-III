package javaModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            DBA.executeQuery(query);
            result = DBA.getQueryResult();
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
            DBA.executeQuery(query);
            result = DBA.getQueryResult();
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
        DBA.insertQuery(query);
    }

    // delete kredit from db
    public void delete() {
        String query = "DELETE FROM kredit WHERE id=" + id;
        DBA.deleteQuery(query);
    }
}