package soaptest;

import model.Model;
 
public class SOAPWS {
  public String animalType(String animal) {
    String animalType = "";
    if ("Lion".equals(animal)) {
      animalType = "Wild";
    } else if ("Dog".equals(animal)) {
      animalType = "Domestic";
    } else {
      animalType = "I don't know!";
    }
    return animalType;
  }
  
  public void addtoDB(String table, String query)
  {
  	Model model = new Model(table);
  	boolean success = model.runSQLSyntax(query);
  	String status;
  	if (success)
  		status = "SOAP success";
  	else {
  		status = "SOAP failed, "+"message: ";
  	System.out.println(status);
  	}
  }
}
