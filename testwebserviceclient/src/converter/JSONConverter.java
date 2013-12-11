package converter;

import java.rmi.RemoteException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONConverter {
	public static String[][] JSONConverter(String json) {
		String[][] temp = null;
		JSONParser parser = new JSONParser();
		JSONObject obj = new JSONObject();
		try {
			obj = (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray result = (JSONArray) obj.get("result");
		for (int i = 0; i < result.size(); i++) {
			JSONArray row = new JSONArray();
			row = (JSONArray) result.get(i);
			for (int j = 0; j<row.size();j++){
				temp[i][j] = (String) row.get(j);
			}
		}
		return temp;
	}
}
