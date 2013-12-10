/**
 * UserSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.soap;

import com.frexesc.Constants;

public class UserSoapServiceLocator extends org.apache.axis.client.Service
		implements com.frexesc.soap.UserSoapService {
	
	// Use to get a proxy class for UserSoap
	private java.lang.String UserSoap_address = Constants.HOSTNAME + "services/UserSoap";

	public UserSoapServiceLocator() {
	}

	public UserSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public UserSoapServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	public java.lang.String getUserSoapAddress() {
		return UserSoap_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String UserSoapWSDDServiceName = "UserSoap";

	public java.lang.String getUserSoapWSDDServiceName() {
		return UserSoapWSDDServiceName;
	}

	public void setUserSoapWSDDServiceName(java.lang.String name) {
		UserSoapWSDDServiceName = name;
	}

	public com.frexesc.soap.UserSoap getUserSoap()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(UserSoap_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getUserSoap(endpoint);
	}

	public com.frexesc.soap.UserSoap getUserSoap(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		try {
			com.frexesc.soap.UserSoapSoapBindingStub _stub = new com.frexesc.soap.UserSoapSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getUserSoapWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setUserSoapEndpointAddress(java.lang.String address) {
		UserSoap_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (com.frexesc.soap.UserSoap.class
					.isAssignableFrom(serviceEndpointInterface)) {
				com.frexesc.soap.UserSoapSoapBindingStub _stub = new com.frexesc.soap.UserSoapSoapBindingStub(
						new java.net.URL(UserSoap_address), this);
				_stub.setPortName(getUserSoapWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException(
				"There is no stub implementation for the interface:  "
						+ (serviceEndpointInterface == null ? "null"
								: serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
			Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("UserSoap".equals(inputPortName)) {
			return getUserSoap();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"http://soap.frexescwebservice.com", "UserSoapService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"http://soap.frexescwebservice.com", "UserSoap"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("UserSoap".equals(portName)) {
			setUserSoapEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(
					" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
