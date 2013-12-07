package Config;
import org.json.JSONArray;
import org.json.JSONObject;

public class GlobalConfig {

	public String URLSQL = "jdbc:mysql://localhost:3306/tugas_wbd3";
	public String SQLUser = "wbd_user3";
	public String SQLPass = "wbd@if3110";
	public String Path = "/home/habibie/IF3110-Tubes-II/src/ruserba/";
	public String URLService = "http://localhost:8080/thelastruserba/";
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
					URLService = "http://thelastruserba.ap01.aws.af.cm/";
				}
			}
		}catch (Exception e){}
	}
}
