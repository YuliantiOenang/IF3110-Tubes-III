package soap;

import javaModel.Kredit;

public class KreditSoap {
	
	public void createKredit(Integer id_account, String card_number, String name_of_card, String expired_date){
		Kredit K = new Kredit();
		K.id_account = id_account;
		K.card_number = card_number;
		K.name_of_card = name_of_card;
		K.expired_date = expired_date;
		K.save();
	}
}