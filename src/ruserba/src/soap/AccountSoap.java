package soap;

import javaModel.Account;

public class AccountSoap {
	
	public void createAcc(String username, String password, String nama, String email, String alamat, String provinsi, String kota, String kodepos, String telepon, Integer role, Integer transaksi){
		Account A = new Account();
		A.username = username;
		A.password = password;
		A.email = email;
		A.alamat = alamat;
		A.provinsi = provinsi;
		A.kota = kota;
		A.kodepos = kodepos;
		A.telepon = telepon;
		A.role = role;
		A.transaksi = transaksi;
		A.save();
		//return username + " " + password;
	}
}
