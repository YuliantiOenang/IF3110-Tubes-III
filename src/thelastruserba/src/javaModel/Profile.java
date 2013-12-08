package javaModel;

import java.sql.ResultSet;
import java.util.ArrayList;

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
