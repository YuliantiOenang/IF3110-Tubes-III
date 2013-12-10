package model;

import java.util.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.*;

import javax.net.ssl.HttpsURLConnection;

import json.JSONArray;
import json.JSONObject;
import sun.org.mozilla.javascript.internal.json.JsonParser;

public class Model
{
	private final String USER_AGENT = "Mozilla/5.0";
	
	static final String WEBSERVICE_URL = "http://calvin-salvy.ap01.aws.af.cm/service";
	
	private Vector<HashMap<String,String>> data;
	
	private String tabelname;
	
	public Model(String tabel)
	{
		data = new Vector<HashMap<String,String>>();
		
		tabelname = tabel;
	}
	
	public Vector<HashMap<String,String>> findAll()
	{
		execute("");
		return getDataVector();
	}
	
	public Vector<HashMap<String,String>> findByCondition(String cond)
	{
		execute(cond);
		return getDataVector();
	}
	
	public HashMap<String,String> findById(int id)
	{
		findByCondition("id = " + id);
		return getDataVector().firstElement();
	}
	
	public Vector<HashMap<String,String>> executeSQL(String sql)
	{
		execute(sql);
		return getDataVector();
	}
	
	public Vector<HashMap<String,String>> updateSQL(String sql)
	{
		update(sql);
		return getDataVector();
	}
	
	protected void update(String sql){
		try {
			sendPost("table="+tabelname+"&sqlsyntax="+EscapeChars.forURL(sql));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void execute(String sql)
	{
		try {
			if (sql.length()>1)
				processJSON(sendGet("table="+tabelname+"&parameter="+EscapeChars.forURL(sql)));
			else
				processJSON(sendGet("table="+tabelname));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<HashMap<String,String>> getDataVector() {
		return data;
	}
	public int getDataCount() {
		return data.size();
	}
	public HashMap<String,String> getData(int idx) {
		if (idx<getDataCount())
			return data.elementAt(idx);
		else
			return null;
	}
	public String getDataColumn(int idx,String column) {
		return getData(idx).get(column);
	}
	public void newRecord(){
		data.clear();
		data.add(new HashMap<String,String>());
	}
	public void addValue(String column, String value){
		if (data.size()!=1)
		{
			data.clear();
			data.add(new HashMap<String,String>());
		}
		data.firstElement().put(column, value);
	}
	public void save(){
		java.sql.Connection con;
		java.sql.Statement stmt;
		ResultSet rs;
		ResultSetMetaData rsmd;
		String sql;
		
		// Generate Query
		sql = "INSERT INTO `" + tabelname + "` (";
		boolean first = true;
		for (String key : data.firstElement().keySet())
		{
			if (first) first = false;else sql = sql + ",";
			sql = sql + "`" + key + "`";
		}
		sql = sql + ") VALUES (";
		first = false;
		for (String key : data.firstElement().keySet())
		{
			if (first) first = false; else sql = sql + ",";
			sql = sql + "'" + data.firstElement().get(key) + "'";
		}
		sql = sql + ");";
		
		update(sql);
	}
	
	public static String rupiahFormatter(String raw)
	{
		int nchar = raw.length();
		String rp = "";
		for (int i = nchar-1;i>=0;i--)
		{
			rp = raw.charAt(i) + rp;
			if (((nchar-i)%3==0)&&(i!=0))
				rp = "." + rp;
		}
		return rp;
	}
	
	private String sendGet(String param) throws Exception {
		System.out.println(WEBSERVICE_URL + "?" + param);
		URL obj = new URL(WEBSERVICE_URL + "?" + param);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		return response.toString();
 
	}
 
	// HTTP POST request
	private String sendPost(String param) throws Exception {
		URL obj = new URL(WEBSERVICE_URL);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = param;
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		return response.toString();
 
	}
	
	private boolean processJSON(String json)
	{
		System.out.println(json);
		data.clear();
		JSONObject obj = new JSONObject(json);
		String status = obj.getString("status");
		if (status.equals("success"))
		{
			JSONArray datajson = obj.getJSONArray("data");
			for (int i = 0; i<datajson.length();i++)
			{
				HashMap<String, String> hashmap = new HashMap<>();
				JSONObject subdata = datajson.getJSONObject(i);
				System.out.println(subdata.length());
				Iterator<?> keys = subdata.keys();
				while (keys.hasNext())
				{
					String key = (String) keys.next();
			        String val = subdata.getString(key);
			        if (val == null){
			        	val = "";
			        }
			        System.out.println(key+" : "+val);
			        hashmap.put(key, val);
				}
				data.add(hashmap);
			}
			System.out.println(data.size());
			return true;
		}
		else
			return false;
	}
	
	public static int rupiahReverseFormatter(String str){
		int bil = 0;
		for (int i=0;i<str.length();i++){
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				bil*=10;
				bil+=Character.getNumericValue(str.charAt(i));
			}
		}
		return bil;
	}
}
