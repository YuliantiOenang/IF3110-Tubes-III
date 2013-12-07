package model;

import java.util.HashMap;
import java.util.Vector;
import javax.servlet.RequestDispatcher;


public class Barang extends Model {

	public Barang() {
		super("barang");
	}
	
	public Vector<HashMap<String,String>> findByCategory(int kat_id)
	{
		return findByCondition( "id_kategori = " + kat_id );
	}
	
	public Vector<HashMap<String,String>> getFourBestCategory(int kat_id)
	{
		return executeSQL("id_kategori = " +kat_id +" ORDER BY counter DESC LIMIT 4");
	}
	
	public void formatAllCurrency()
	{
		for (HashMap<String, String> iterable_element : getDataVector()) {
			String hargabaru = rupiahFormatter(iterable_element.get("harga"));
			iterable_element.remove("harga");
			iterable_element.put("harga", hargabaru);
		}
	}
	
	public String paginasi(int total, int hal, int count, String query)
	{
		int jumhal = total/count + 1;
		String str = "<ul class='paginasi'>";
		for (int i=1; i <= jumhal; i++) { 
            str += "<li>";
            if (i == hal)
                str += i;
            else 
                str += "<a href=\"?hal=" +i+"&"+ query+ "\">" +i + "</a>";
            str += "</li>";
        }
        str += "<ul>";
        return str;
	}
	
	//TODO implement another function
}