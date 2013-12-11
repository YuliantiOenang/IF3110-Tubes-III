package com.esc.soap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SoapService {

	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String URL_MASTER = "http://esc-wbd.herokuapp.com/";
	
	private static String encode(String n) {
		try {
			return URLEncoder.encode(n, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String createUser(int id, String username, String password, String handphone, String alamat, String provinsi, String kota, String kodepos, String email, int role, String nama, String nomor_kartu, String nama_kartu, String expire_kartu, int transaksi) {
		try {
			String url = URL_MASTER + "create?action=user&username=" + encode(username) + "&password=" + encode(password) + "&email=" + encode(email) + "&name=" + encode(nama) + "&telephone=" + encode(handphone) + "&address=" + encode(alamat) + "&province=" + encode(provinsi) + "&city=" + encode(kota) + "&postal=" + kodepos;

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}

	public String createBarang(int id, int id_kategori, String nama, String gambar, int harga_barang, String keterangan, int jumlah_barang) {
		try {
			String url = URL_MASTER + "create?action=barang&idk=" + id_kategori + "&nama=" + encode(nama) + "&gambar=" + encode(gambar) + "&harga=" + harga_barang + "&keterangan=" + encode(keterangan) + "&jumlah=" + jumlah_barang;

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}

	public String createBarangUser(int id, int id_barang, int id_user, int status, int jumlah_barang, String tanggal_pembelian, String deskripsi_tambahan) {
		try {
			String url = URL_MASTER + "create?action=baranguser&idb=" + id_barang + "&idu=" + id_user + "&jumlah=" + jumlah_barang + "&deskripsi=" + encode(deskripsi_tambahan);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}
}
