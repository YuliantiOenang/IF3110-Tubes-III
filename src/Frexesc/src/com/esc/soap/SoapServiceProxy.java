package com.esc.soap;

public class SoapServiceProxy implements com.esc.soap.SoapService {
	private String _endpoint = null;
	private com.esc.soap.SoapService soapService = null;

	public SoapServiceProxy() {
		_initSoapServiceProxy();
	}

	public SoapServiceProxy(String endpoint) {
		_endpoint = endpoint;
		_initSoapServiceProxy();
	}

	private void _initSoapServiceProxy() {
		try {
			soapService = (new com.esc.soap.SoapServiceServiceLocator()).getSoapService();
			if (soapService != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) soapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) soapService)._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (soapService != null)
			((javax.xml.rpc.Stub) soapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.esc.soap.SoapService getSoapService() {
		if (soapService == null)
			_initSoapServiceProxy();
		return soapService;
	}

	public java.lang.String createBarang(int id, int id_kategori, java.lang.String nama, java.lang.String gambar, int harga_barang, java.lang.String keterangan, int jumlah_barang) throws java.rmi.RemoteException {
		if (soapService == null)
			_initSoapServiceProxy();
		return soapService.createBarang(id, id_kategori, nama, gambar, harga_barang, keterangan, jumlah_barang);
	}

	public java.lang.String createUser(int id, java.lang.String username, java.lang.String password, java.lang.String handphone, java.lang.String alamat, java.lang.String provinsi, java.lang.String kota, java.lang.String kodepos, java.lang.String email, int role, java.lang.String nama, java.lang.String nomor_kartu, java.lang.String nama_kartu, java.lang.String expire_kartu, int transaksi) throws java.rmi.RemoteException {
		if (soapService == null)
			_initSoapServiceProxy();
		return soapService.createUser(id, username, password, handphone, alamat, provinsi, kota, kodepos, email, role, nama, nomor_kartu, nama_kartu, expire_kartu, transaksi);
	}

	public java.lang.String createBarangUser(int id, int id_barang, int id_user, int status, int jumlah_barang, java.lang.String tanggal_pembelian, java.lang.String deskripsi_tambahan) throws java.rmi.RemoteException {
		if (soapService == null)
			_initSoapServiceProxy();
		return soapService.createBarangUser(id, id_barang, id_user, status, jumlah_barang, tanggal_pembelian, deskripsi_tambahan);
	}

}