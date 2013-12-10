package com.frexesc.soap;

public class BarangUserSoapProxy implements com.frexesc.soap.BarangUserSoap {
	private String _endpoint = null;
	private com.frexesc.soap.BarangUserSoap barangUserSoap = null;

	public BarangUserSoapProxy() {
		_initBarangUserSoapProxy();
	}

	public BarangUserSoapProxy(String endpoint) {
		_endpoint = endpoint;
		_initBarangUserSoapProxy();
	}

	private void _initBarangUserSoapProxy() {
		try {
			barangUserSoap = (new com.frexesc.soap.BarangUserSoapServiceLocator())
					.getBarangUserSoap();
			if (barangUserSoap != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) barangUserSoap)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) barangUserSoap)
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
		if (barangUserSoap != null)
			((javax.xml.rpc.Stub) barangUserSoap)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.frexesc.soap.BarangUserSoap getBarangUserSoap() {
		if (barangUserSoap == null)
			_initBarangUserSoapProxy();
		return barangUserSoap;
	}

	public void addCart(long id_item, long id_user, int total_item,
			java.lang.String description) throws java.rmi.RemoteException {
		if (barangUserSoap == null)
			_initBarangUserSoapProxy();
		barangUserSoap.addCart(id_item, id_user, total_item, description);
	}

}