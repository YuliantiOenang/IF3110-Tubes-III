package Data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tubesII.wbd.GlobalConfig;

import com.google.gson.Gson;

public class creditcard extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			/*EXAMPLE CODE*/
			/*Used for query .. DONT CHANGE THIS LINES*/
			String action=request.getParameter("action");
			String parameters=request.getParameter("parameters").trim();
			String parameter[]=parameters.split(",");
			GlobalConfig GC = new GlobalConfig();
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			Connection con = DriverManager.getConnection (GC.geturl(), GC.getuser(), GC.getpass());
			//Connection con = DriverManager.getConnection ("jdbc:mysql://localhost/progin_13511059", "root", "");
			PrintWriter out =  response.getWriter();
			// End OF DONT CHANGE
			
			
			response.setContentType("text/html");
	        response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");
			response.setHeader("Access-Control-Allow-Origin","*");
			response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE,OPTIONS");
			response.setHeader("Access-Control-Allow-Headers","X-Requested-With, Content-Type, Content-Length");
			
			if(action.equals("cari_by_id")){
				
				// TODO customize for funtion 
				// FORMAT INPUT : action = register & parameters = username , nama_lengkap , password, email ,handphone , address , province , state , postcode , n_pembelian
				// FORMAT OUTPUT : {Status_operasi: Success/Failed}
				// Silahakan GOoogling explorasi syntax SQL untuk insert, soalnya beda sama con.executeSQL kalau gak salah con.updateSQL
				
				Statement statement = con.createStatement();
				
				
				
				Integer id = Integer.parseInt(parameter[0]);
				String query = "SELECT * FROM `creditcard` WHERE card_id="+id;
				
				ResultSet rs = statement.executeQuery(query);
				boolean status = rs.next();
				
				creditcard_data c = new creditcard_data();
				String output = new String();
				if(status){
					c.setCard_id(rs.getObject(1).toString());
				  	c.setCard_nameon(rs.getObject(2).toString());
				  	c.setCard_expdate(rs.getObject(3).toString());
				  	c.setCard_owner(rs.getObject(4).toString());

				  	Gson gson=new Gson();
				  	output = gson.toJson(c);
				}
			  	
				if (status)
					out.print("{ \"Status_operasi\" : \"success\" , \"output_search\" : \""+output+"\"}");
				else
					out.print("{ \"Status_operasi\" : \"failed\" }");
							  
			}else if(action.equals("cari_by_card_owner")){
				Statement statement = con.createStatement();
				
				String owner = parameter[0];
				String query = "SELECT * FROM `creditcard` WHERE card_owner=\'"+owner+"\'";
				
				ResultSet rs = statement.executeQuery(query);
				boolean status = rs.next();
				
				creditcard_data c = new creditcard_data();
				String output = new String();
				if(status){
					c.setCard_id(rs.getObject(1).toString());
				  	c.setCard_nameon(rs.getObject(2).toString());
				  	c.setCard_expdate(rs.getObject(3).toString());
				  	c.setCard_owner(rs.getObject(4).toString());

				  	Gson gson=new Gson();
				  	output = gson.toJson(c);

				}
			  	
				if (status)
					out.print("{ \"Status_operasi\" : \"success\" , \"output_search\" : \""+output+"\"}");
				else
					out.print("{ \"Status_operasi\" : \"failed\" }");
					
				
			}else if(action.equals("insert")){
				Statement statement = con.createStatement();
				
				Integer card_id = Integer.parseInt(parameter[0]);
				String card_name_on = parameter[1];
				String card_expdate = parameter[2];
				String card_owner =parameter[3];
				
				
				String query = "INSERT INTO `creditcard` (card_id,card_nameon,card_expdate,card_owner) VALUES ("+card_id+",\'"+card_name_on+"\',\'"+card_expdate+"\',\'"+card_owner+"\')";
				
				
				int status = statement.executeUpdate(query);
				
				if(status==1){
					out.print("{ \"status\" : \"success\" }");
				}else{
					out.print("{ \"status\" : \"failed\" }");
				}
				
					
			}else if(action.equals("update")){
				Statement statement = con.createStatement();
				
				Integer card_id = Integer.parseInt(parameter[0]);
				String card_name_on = parameter[1];
				String card_expdate = parameter[2];
				String card_owner =parameter[3];				
				
				String query = "UPDATE `creditcard` SET card_id="+card_id+",card_nameon=\'"+card_name_on+"\',card_expdate=\'"+card_expdate+"\',card_owner=\'"+card_owner+"\'";
				
				
				int status = statement.executeUpdate(query);
				
				if(status==1){
					out.print("{ \"status\" : \"success\" }");
				}else{
					out.print("{ \"status\" : \"failed\" }");
				}
			}
		}catch(Exception e){
			
		}
	}
}
