
package npackage;

import java.util.ArrayList;
    public class UserBean {
	
    private String username;
    private String password;
	private String email;
	private String namalengkap;
	private String nohp;
	private String provinsi;
	private String kotakabupaten;
	private String alamat;
	private String kodepos;
	private String nocredit;
	private String jumlahtransaksi;
	private String query;
	private String querydua;
	private String type;
	
	private String bestbuy1;
	private String bestbuy2;
	private String bestbuy3;
	private String bestbuy4;
	private String bestbuy5;
	private String bestbuy6;
	private String bestbuy7;
	private String bestbuy8;
	private String bestbuy9;
	ArrayList<Barang> search = new ArrayList<Barang>();
	ArrayList<Barang> beras = new ArrayList<Barang>();
	ArrayList<Barang> daging = new ArrayList<Barang>();
	ArrayList<Barang> sayuran = new ArrayList<Barang>();
	ArrayList<Barang> frozen = new ArrayList<Barang>();
	ArrayList<Barang> snack = new ArrayList<Barang>();
	Barang barang = new Barang();
    
    public boolean valid;
	

	public ArrayList<Barang> getberas(){
		return beras;
	}
	
	public void clearArraylist(){
		search = new ArrayList<Barang>();
		beras = new ArrayList<Barang>();
		daging = new ArrayList<Barang>();
		sayuran = new ArrayList<Barang>();
		frozen = new ArrayList<Barang>();
		snack = new ArrayList<Barang>();
	
	}
	public void setberas(Barang newberas){	
		beras.add(newberas);
	}
	public ArrayList<Barang> getdaging(){
		return daging;
	}
	
	public void setdaging(Barang newdaging){	
		daging.add(newdaging);
	}
	public ArrayList<Barang> getsayuran(){
		return sayuran;
	}
	
	public void setsayuran(Barang newsayuran){	
		sayuran.add(newsayuran);
	}
	public ArrayList<Barang> getfrozen(){
		return frozen;
	}
	
	public void setfrozen(Barang newfrozen){	
		frozen.add(newfrozen);
	}
	public ArrayList<Barang> getsnack(){
		return snack;
	}
	
	public void setsnack(Barang newsnack){	
		snack.add(newsnack);
	}
	public Barang getbarang(){
		return barang;
	}
	
	public void setbarang(Barang newbarang){	
		barang = newbarang;
	}
	
	
	
	
	public ArrayList<Barang> getsearch(){
		return search;
	}
	
	public void setsearch(Barang newsearch){	
		search.add(newsearch);
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String newType){	
		type = newType;
	}
	
	public String getbestbuy1(){
		return bestbuy1;
	}
	public void setbestbuy1(String newbestbuy1){	
		bestbuy1 = newbestbuy1;
	}
	
	public void setbestbuy2(String newbestbuy2){	
		bestbuy2 = newbestbuy2;
	}

	public String getbestbuy2(){
		return bestbuy2;
	}	
	public String getbestbuy3(){
		return bestbuy3;
	}
	
	public void setbestbuy3(String newbestbuy3){	
		bestbuy3 = newbestbuy3;
	}
	
    public String getQuery() {
        return query;
	}
	
	public void setQuery(String newQuery) {
        query = newQuery;
	}
	public String getQueryDua() {
        return querydua;
	}
	
	public void setQueryDua(String newQuerydua) {
        querydua = newQuerydua;
	}

	
	public void setJumlahTransaksi(String newJT) {
        jumlahtransaksi = newJT;
	}
	
	public String getJumlahTransaksi() {
        return jumlahtransaksi;
	}
	
    public void setEmail(String newEmail) {
        email = newEmail;
	}
	
	public String getEmail() {
        return email;
	}

    public void setNamaLengkap(String newNamaLengkap) {
        namalengkap = newNamaLengkap;
	}
    public String getNamaLengkap() {
        return namalengkap;
	}

    public void setNoHP(String newNoHP) {
        nohp = newNoHP;
	}
    public String getNoHP() {
        return nohp;
	}

	public void setProvinsi(String newProvinsi) {
        provinsi = newProvinsi;
	}
    public String getProvinsi() {
        return provinsi;
	}
	public void setKotaKabupaten(String newKotaKabupaten) {
        kotakabupaten = newKotaKabupaten;
	}
    public String getKotaKabupaten() {
        return kotakabupaten;
	}
	
	public void setAlamat(String newAlamat) {
        alamat = newAlamat;
	}
    public String getAlamat() {
        return alamat;
	}
	
    public void setKodePos(String newKodePos) {
        kodepos = newKodePos;
	}
    public String getKodePos() {
        return kodepos;
	}


    public String getPassword() {
       return password;
	}

    public void setPassword(String newPassword) {
       password = newPassword;
	}
	
	public String getNoCredit() {
         return nocredit;
	}

      public void setNoCredit(String newNoCredit) {
         nocredit = newNoCredit;
	}
	
			
      public String getUsername() {
         return username;
			}

      public void setUserName(String newUsername) {
         username = newUsername;
			}

				
      public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}	
}