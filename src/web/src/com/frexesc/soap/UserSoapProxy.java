package com.frexesc.soap;

public class UserSoapProxy implements com.frexesc.soap.UserSoap {
	private String _endpoint = null;
	private com.frexesc.soap.UserSoap userSoap = null;

	public UserSoapProxy() {
		_initUserSoapProxy();
	}

	public UserSoapProxy(String endpoint) {
		_endpoint = endpoint;
		_initUserSoapProxy();
	}

	private void _initUserSoapProxy() {
		try {
			userSoap = (new com.frexesc.soap.UserSoapServiceLocator())
					.getUserSoap();
			if (userSoap != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) userSoap)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) userSoap)
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
		if (userSoap != null)
			((javax.xml.rpc.Stub) userSoap)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.frexesc.soap.UserSoap getUserSoap() {
		if (userSoap == null)
			_initUserSoapProxy();
		return userSoap;
	}

	public void register(java.lang.String username, java.lang.String password,
			java.lang.String email, java.lang.String name,
			java.lang.String telephone, java.lang.String address,
			java.lang.String province, java.lang.String city,
			java.lang.String postal) throws java.rmi.RemoteException {
		if (userSoap == null)
			_initUserSoapProxy();
		userSoap.register(username, password, email, name, telephone, address,
				province, city, postal);
	}

}