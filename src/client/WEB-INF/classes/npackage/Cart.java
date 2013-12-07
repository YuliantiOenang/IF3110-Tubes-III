package npackage;
 
import java.util.ArrayList;
  
public class Cart{
	private ArrayList allCartItems = new ArrayList();
	private int hargaTotal ;
  
	public int getItemCount() {
		return allCartItems.size();
	}
	
	public void remove() {
		allCartItems.clear();
		hargaTotal = 0;
	}
	
	public void deleteCartItem(String index) {
		int itemIndex = 0;
		try {
			itemIndex = Integer.parseInt(index);
			allCartItems.remove(itemIndex - 1);
			calculateHargaTotal();
		}catch(NumberFormatException nfe) {
			System.out.println("Error while deleting cart item: "+nfe.getMessage());
			nfe.printStackTrace();
		}
	}
	
	public void updateCartItem(String strItemIndex, String strQuantity) {
		int jumHarga = 0;
		int harga = 0;
		int jumlah = 0;
		int index = 0;
		CartItem cartItem = null;
		try {
			index = Integer.parseInt(strItemIndex);
			jumlah = Integer.parseInt(strQuantity);
			if(jumlah>0) {
				cartItem = (CartItem)allCartItems.get(index-1);
				harga = cartItem.getHarga();
				jumHarga = harga*jumlah;
				cartItem.setJumlah(jumlah);
				cartItem.setJumHarga(jumHarga);
				calculateHargaTotal();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while updating cart: "+nfe.getMessage());
			nfe.printStackTrace();
		}
	
	}
	
	public void addCartItem(String nama, String strHarga, String kategori, String strQuantity, String detail, String strJumProduk) {
		int jumHarga = 0;
		int harga = 0;
		int jumlah = 0;
		int jumProduk = 0;
		CartItem cartItem = new CartItem();
		boolean ada = false;
		try {
			harga = Integer.parseInt(strHarga);
			jumlah = Integer.parseInt(strQuantity);
			jumProduk = Integer.parseInt(strJumProduk);
			
			CartItem item = new CartItem();
			int i = 0;
			while(i<allCartItems.size() && ada == false){
				item = (CartItem)allCartItems.get(i);
				if(item.getNama().equals(nama)){
					int jum = item.getJumlah();
					item.setJumlah(jum+jumlah);
					ada = true;
					calculateHargaTotal();
				}
				i++;
			}
			
			if(jumlah>0 && ada==false) {
				jumHarga = harga*jumlah;
				cartItem.setNama(nama);
				cartItem.setHarga(harga);
				cartItem.setKategori(kategori);
				cartItem.setJumlah(jumlah);
				cartItem.setDetail(detail);
				cartItem.setJumHarga(jumHarga);
				cartItem.setJumProduk(jumProduk);
				allCartItems.add(cartItem);
				calculateHargaTotal();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while parsing from String to primitive types when adding item: "+nfe.getMessage());
			nfe.printStackTrace();
		}
	}
	
	public void addCartItem(CartItem cartItem) {
		allCartItems.add(cartItem);
	}
	
	public CartItem getCartItem(int index) {
		CartItem cartItem = null;
		if(allCartItems.size()>index) {
			cartItem = (CartItem) allCartItems.get(index);
		}
		return cartItem;
	}
	
	public ArrayList getCartItems() {
		return allCartItems;
	}
	public void setCartItems(ArrayList allCartItems_) {
		allCartItems = allCartItems_;
	}
	public int getHargaTotal() {
		return hargaTotal;
	}
	public void setHargaTotal(int hargaTotal_) {
		hargaTotal = hargaTotal_;
	}
	
	protected void calculateHargaTotal() {
		int hargaTotal = 0;
		for(int counter=0;counter<allCartItems.size();counter++){
			CartItem cartItem = (CartItem) allCartItems.get(counter);
			hargaTotal+=cartItem.getJumHarga();
		}
		setHargaTotal(hargaTotal);
	}
}