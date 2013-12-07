package javaModel;

import java.sql.ResultSet;
import java.util.ArrayList;

import databaseLib.DatabaseAdapter;

public class Kategori {
	private DatabaseAdapter DBA;
	public ArrayList<String> id = new ArrayList<String>();
	public ArrayList<String> nama_kategori = new ArrayList<String>();
	public ArrayList<String> gambar = new ArrayList<String>();
	public ArrayList<String> deskripsi = new ArrayList<String>();
	public ArrayList<String> sub_deskripsi = new ArrayList<String>();
	
	public Kategori(DatabaseAdapter _DBA)
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
				nama_kategori.add(RS.getObject(2).toString());
				gambar.add(RS.getObject(3).toString());
				deskripsi.add(RS.getObject(4).toString());
				sub_deskripsi.add(RS.getObject(5).toString());
			}
		}catch (Exception e){}
	}
}
