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

public class Barang {
	private DatabaseAdapter DBA;
	public ArrayList<String> nama= new ArrayList<String>();
	public ArrayList<String> harga = new ArrayList<String>();
	public ArrayList<String> gambar = new ArrayList<String>();
	public ArrayList<String> stok = new ArrayList<String>();
	public ArrayList<String> counter = new ArrayList<String>();
	public ArrayList<String> keterangan = new ArrayList<String>();
	public ArrayList<String> id = new ArrayList<String>();
	public ArrayList<String> id_kat = new ArrayList<String>();
	
	public Barang(DatabaseAdapter _DBA)
	{
		DBA = _DBA;
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
				id_kat.add(RS.getObject(2).toString());
				nama.add(RS.getObject(3).toString());
				harga.add(RS.getObject(4).toString());
				gambar.add(RS.getObject(5).toString());
				stok.add(RS.getObject(6).toString());
				counter.add(RS.getObject(7).toString());
				keterangan.add(RS.getObject(8).toString());
			}
		}catch (Exception e){}
	}
	public void findTopThreeRest() {
        String output = "";
        try {
            output = RestClient.doGet("barang?action=readTopThree");
        } catch (HttpException | IOException | URISyntaxException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JSONObject json;
        try {
            json = new JSONObject(output);
            if (json.getBoolean("status")) {
                JSONArray data = (JSONArray) json.get("data");
                for (int i = 0; i < data.length(); i++) {
                    JSONObject brg = (JSONObject) data.get(i);
                    id.add(brg.get("id").toString());
                    nama.add(brg.get("nama").toString());
                    harga.add(brg.get("harga").toString());
                    gambar.add(brg.get("gambar").toString());
                    stok.add(brg.get("stok").toString());
                    counter.add(brg.get("counter").toString());
                    keterangan.add(brg.get("keterangan").toString());
                    id_kat.add(brg.get("id_kategori").toString());
                }
            }   
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
	public void executeQuery2(String query)
	{
		DBA.executeQuery(query);
		ResultSet RS = DBA.getQueryResult();
		try
		{
			while (RS.next())
			{
				harga.add(RS.getObject(3).toString());
				nama.add(RS.getObject(2).toString());
				id.add(RS.getObject(1).toString());
				gambar.add(RS.getObject(4).toString());
				stok.add(RS.getObject(5).toString());
			}
		}catch (Exception e){}
	}
}
