package npackage;

public class CartItem{
	private String nama;
	private int harga;
	private String kategori;
	private int jumlah;	//banyaknya pembelian
	private String detail;	
	private int jumHarga;
	private int jumProduk; //sisa produk di DB
	
	public CartItem(){
		nama="";
		harga=-1;
		kategori="";
		jumlah=-1;
		detail="";
		jumHarga=0;
		jumProduk=0;
	}
	
	public CartItem(int id_,String nama_, int harga_,String kategori_,int jumlah_, String detail_, int jumHarga_, int jumProduk_,String index_){
		nama=nama_;
		harga=harga_;
		kategori=kategori_;
		jumlah=jumlah_;
		detail=detail_;
		jumHarga=jumHarga_;
		jumProduk = jumProduk_;
	}
	
	public String getNama(){
		return nama;
	}
	
	public int getHarga(){
		return harga;
	}
	
	public String getKategori(){
		return kategori;
	}
	
	public int getJumlah(){
		return jumlah;
	}
	
	public String getDeatail(){
		return detail;
	}
	
	public int getJumHarga(){
		return jumHarga;
	}
	public int getJumProduk(){
		return jumProduk;
	}

	public void setNama(String nama_){
		nama=nama_;
	}
	public void setHarga(int harga_){
		harga=harga_;
	}
	public void setKategori(String kategori_){
		kategori=kategori_;
	}
	public void setJumlah(int jumlah_){
		jumlah=jumlah_;
	}
	
	public void setDetail(String detail_){
		detail=detail_;
	}
	public void setJumHarga(int jumHarga_){
		jumHarga=jumHarga_;
	}
	public void setJumProduk(int jumProduk_){
		jumProduk=jumProduk_;
	}
}