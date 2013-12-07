package javaModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class Account {
    public int id, role, transaksi;
    public String username, password, nama, email, alamat, provinsi, kota, kodepos, telepon, auth_key;
    private static DatabaseAdapter DBA = new DatabaseAdapter();
    private static ResultSet result;

    public Account() {
        id = -1;
    }


    // find 1 row data of account based on query
    public static Account find(String query) {
        Account account = null;
        try {
            DBA = new DatabaseAdapter();
            DBA.executeQuery(query);
            result = DBA.getQueryResult();
            if (!result.isBeforeFirst()) return account;
            if (result.next()) {
                account = new Account();
                account.id = Integer.parseInt(result.getString(1));
                account.username = result.getString(2);
                account.password = result.getString(3);
                account.nama = result.getString(4);
                account.email = result.getString(5);
                account.alamat = result.getString(6);
                account.provinsi = result.getString(7);
                account.kota = result.getString(8);
                account.kodepos = result.getString(9);
                account.telepon = result.getString(10);
                account.auth_key = result.getString(11);
                account.role = Integer.parseInt(result.getString(12));
                account.transaksi = Integer.parseInt(result.getString(13));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBA.endQuery();
        }
        return account;
    }

    // find 1 row data of account based on primary key
    public static Account findByPk(int id) {
        return find("SELECT * FROM account WHERE id=" + id);
    }

    // find all data of account based on query
    public static ArrayList<Account> findAll(String query) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            DBA = new DatabaseAdapter();
            DBA.executeQuery(query);
            result = DBA.getQueryResult();
            if (!result.isBeforeFirst()) return accounts;
            while (result.next()) {
                Account account = new Account();
                account.id = Integer.parseInt(result.getString(1));
                account.username = result.getString(2);
                account.password = result.getString(3);
                account.nama = result.getString(4);
                account.email = result.getString(5);
                account.alamat = result.getString(6);
                account.provinsi = result.getString(7);
                account.kota = result.getString(8);
                account.kodepos = result.getString(9);
                account.telepon = result.getString(10);
                account.auth_key = result.getString(11);
                account.role = Integer.parseInt(result.getString(12));
                account.transaksi = Integer.parseInt(result.getString(13));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBA.endQuery();
        }
        return accounts;
    }

    // save account to db
    public void save() {
        String query;
        if (id == -1) // new
            query = "INSERT INTO account (username, password, nama, email, alamat, provinsi, kota, kodepos, telepon, auth_key, role, transaksi) VALUES ('" + username  + "', '" + password  + "', '" + nama  + "', '" + email  + "', '" + alamat  + "', '" + provinsi  + "', '" + kota  + "', '" + kodepos  + "', '" + telepon  + "', '" + auth_key  + "', '" + role  + "', '" + transaksi  + "')";
        else
            query = "UPDATE account SET username = '" + username + "', password = '" + password + "', nama = '" + nama + "', email = '" + email + "', alamat = '" + alamat + "', provinsi = '" + provinsi + "', kota = '" + kota + "', kodepos = '" + kodepos + "', telepon = '" + telepon + "', auth_key = '" + auth_key + "', role = '" + role + "', transaksi = '" + transaksi + "' WHERE id = " + id;
        DBA = new DatabaseAdapter();
        DBA.insertQuery(query);
        DBA.endQuery();
    }

    // delete account from db
    public void delete() {
        String query = "DELETE FROM account WHERE id=" + id;
        DBA = new DatabaseAdapter();
        DBA.deleteQuery(query);
        DBA.endQuery();
    }
    
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("username", username);
            json.put("password", password);
            json.put("nama", nama);
            json.put("email", email);
            json.put("alamat", alamat);
            json.put("provinsi", provinsi);
            json.put("kota", kota);
            json.put("kodepos", kodepos);
            json.put("telepon", telepon);
            json.put("role", role);
            json.put("transaksi", transaksi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}