package javaModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.http.HttpException;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class Profile {
	private DatabaseAdapter DBA;
	public ArrayList<String> id = new ArrayList<String>();
	public ArrayList<String> username = new ArrayList<String>();
	public ArrayList<String> password = new ArrayList<String>();
	public ArrayList<String> nama = new ArrayList<String>();
	public ArrayList<String> email = new ArrayList<String>();
	public ArrayList<String> alamat = new ArrayList<String>();
	public ArrayList<String> provinsi = new ArrayList<String>();
	public ArrayList<String> kota = new ArrayList<String>();
	public ArrayList<String> kodepos = new ArrayList<String>();
	public ArrayList<String> telepon = new ArrayList<String>();
	public ArrayList<String> auth_key = new ArrayList<String>();
	public ArrayList<String> role = new ArrayList<String>();
	public ArrayList<String> transaksi = new ArrayList<String>();
	
	public Profile(DatabaseAdapter _DBA)
	{
		DBA = _DBA;
	}
	
	public void fromRest(Integer id_account) {
	    String output = "";
        try {
            output = RestClient.doGet("account?id="+id_account);
        } catch (HttpException | IOException | URISyntaxException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
	    JSONObject json;
        try {
            json = new JSONObject(output);
            if (json.getBoolean("status")) {
                JSONObject data = (JSONObject) json.get("data");
                id.add(data.get("id").toString());
                username.add(data.get("username").toString());
                password.add(data.get("password").toString());
                nama.add(data.get("nama").toString());
                email.add(data.get("email").toString());
                alamat.add(data.get("alamat").toString());
                provinsi.add(data.get("provinsi").toString());
                kota.add(data.get("kota").toString());
                kodepos.add(data.get("kodepos").toString());
                telepon.add(data.get("telepon").toString());
                auth_key.add("");
                role.add(data.get("role").toString());
                transaksi.add(data.get("transaksi").toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}
	
	public static void updateRest(String params) {
        Boolean output = false;
        try {
            output = RestClient.doPut("account", params);
        } catch (URISyntaxException | HttpException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(output);
	}
	
	public void executeQuery(String query)
	{
		DBA.executeQuery(query);
		ResultSet RS = DBA.getQueryResult();
		try
		{
			while (RS.next())
			{
				id.add(RS.getObject(1).toString());
				username.add(RS.getObject(2).toString());
				password.add(RS.getObject(3).toString());
				nama.add(RS.getObject(4).toString());
				email.add(RS.getObject(5).toString());
				alamat.add(RS.getObject(6).toString());
				provinsi.add(RS.getObject(7).toString());
				kota.add(RS.getObject(8).toString());
				kodepos.add(RS.getObject(9).toString());
				telepon.add(RS.getObject(10).toString());
				auth_key.add(RS.getObject(11).toString());
				role.add(RS.getObject(12).toString());
				transaksi.add(RS.getObject(13).toString());
			}
		}catch (Exception e){}
	}
}
