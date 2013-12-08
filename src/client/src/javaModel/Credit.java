package javaModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class Credit {
	private DatabaseAdapter DBA;
	public ArrayList<String> id = new ArrayList<String>();
	public ArrayList<String> id_account = new ArrayList<String>();
	public ArrayList<String> card_number = new ArrayList<String>();
	public ArrayList<String> name_of_card = new ArrayList<String>();
	public ArrayList<String> expired_date = new ArrayList<String>();
	
	public Credit(DatabaseAdapter _DBA)
	{
		DBA = _DBA;
	}
	public void findByAccountRest(Integer id_acc) {
        String output = "";
        try {
            output = RestClient.doGet("kredit?id_account="+id_acc);
        } catch (HttpException | IOException | URISyntaxException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            JSONObject json = new JSONObject(output);
            if (json.getBoolean("status")) {
                JSONObject crd = (JSONObject) json.get("data");
                id.add(crd.get("id").toString());
                id_account.add(crd.get("id_account").toString());
                card_number.add(crd.get("card_number").toString());
                name_of_card.add(crd.get("name_of_card").toString());
                expired_date.add(crd.get("expired_date").toString());
            }   
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
				id_account.add(RS.getObject(2).toString());
				card_number.add(RS.getObject(3).toString());
				name_of_card.add(RS.getObject(4).toString());
				expired_date.add(RS.getObject(5).toString());
			}
		}catch (Exception e){}
	}
}
