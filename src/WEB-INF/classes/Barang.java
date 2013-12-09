package KelasBarang; 
import java.util.*;
public class Barang {
	String Nama;
	String Kategori;
	int Harga;
	int Id;
	public Barang(){}
	public Barang(String N,String Kat,int H,int I){
		Id=I;
		Harga=H;
		Kategori=Kat;
		Nama=N;}
	public void setNama(String N){
		Nama=N;}
	public String getNama(){
		return Nama;}
	
}