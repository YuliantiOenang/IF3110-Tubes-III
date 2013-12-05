package javaModel;

import java.sql.ResultSet;
import java.util.ArrayList;

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
