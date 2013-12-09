package com.frexesc.soap;

public class BarangSoapProxy implements com.frexesc.soap.BarangSoap {
	private String _endpoint = null;
	private com.frexesc.soap.BarangSoap barangSoap = null;

	public BarangSoapProxy() {
		_initBarangSoapProxy();
	}

	public BarangSoapProxy(String endpoint) {
		_endpoint = endpoint;
		_initBarangSoapProxy();
	}

	private void _initBarangSoapProxy() {
		try {
			barangSoap = (new com.frexesc.soap.BarangSoapServiceLocator())
					.getBarangSoap();
			if (barangSoap != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) barangSoap)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) barangSoap)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (barangSoap != null)
			((javax.xml.rpc.Stub) barangSoap)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.frexesc.soap.BarangSoap getBarangSoap() {
		if (barangSoap == null)
			_initBarangSoapProxy();
		return barangSoap;
	}

	public void addBarang(long id_category, java.lang.String name,
			java.lang.String picture, int price, java.lang.String description,
			int total_item) throws java.rmi.RemoteException {
		if (barangSoap == null)
			_initBarangSoapProxy();
		barangSoap.addBarang(id_category, name, picture, price, description,
				total_item);
	}

}