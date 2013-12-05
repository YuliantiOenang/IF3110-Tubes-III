package Config;
import org.json.JSONArray;
import org.json.JSONObject;

public class GlobalConfig {

	public String URLSQL = "jdbc:mysql://localhost:3306/ruserba";
	public String SQLUser = "root";
	public String SQLPass = "tkislam123";
	public String Path = "/home/habibie/IF3110-Tubes-II/src/ruserba/";
	
	public GlobalConfig()
	{
		try
		{
			if (java.lang.System.getenv("VCAP_SERVICES") != null)
			{
				if (java.lang.System.getenv("VCAP_SERVICES").equals(""))
				{
					JSONObject jsonVCAP = new JSONObject(java.lang.System.getenv("VCAP_SERVICES"));
					JSONArray mysql = jsonVCAP.getJSONArray("mysql-5.1");
					String table = mysql.getJSONObject(0).getJSONObject("credentials").getString("name");
					URLSQL = "jdbc:mysql://"+mysql.getJSONObject(0).getJSONObject("credentials").getString("hostname")+":3306/"+table;
					SQLUser = mysql.getJSONObject(0).getJSONObject("credentials").getString("username");
					SQLPass = mysql.getJSONObject(0).getJSONObject("credentials").getString("password");
				}
			}
		}catch (Exception e){}
	}
}
