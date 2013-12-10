/**
 * BarangSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.soap;

import com.frexesc.Constants;

public class BarangSoapServiceLocator extends org.apache.axis.client.Service
		implements com.frexesc.soap.BarangSoapService {
	
	// Use to get a proxy class for BarangSoap
	private java.lang.String BarangSoap_address = Constants.HOSTNAME + "services/BarangSoap";

	public BarangSoapServiceLocator() {
	}

	public BarangSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public BarangSoapServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	public java.lang.String getBarangSoapAddress() {
		return BarangSoap_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String BarangSoapWSDDServiceName = "BarangSoap";

	public java.lang.String getBarangSoapWSDDServiceName() {
		return BarangSoapWSDDServiceName;
	}

	public void setBarangSoapWSDDServiceName(java.lang.String name) {
		BarangSoapWSDDServiceName = name;
	}

	public com.frexesc.soap.BarangSoap getBarangSoap()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(BarangSoap_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getBarangSoap(endpoint);
	}

	public com.frexesc.soap.BarangSoap getBarangSoap(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		try {
			com.frexesc.soap.BarangSoapSoapBindingStub _stub = new com.frexesc.soap.BarangSoapSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getBarangSoapWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setBarangSoapEndpointAddress(java.lang.String address) {
		BarangSoap_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (com.frexesc.soap.BarangSoap.class
					.isAssignableFrom(serviceEndpointInterface)) {
				com.frexesc.soap.BarangSoapSoapBindingStub _stub = new com.frexesc.soap.BarangSoapSoapBindingStub(
						new java.net.URL(BarangSoap_address), this);
				_stub.setPortName(getBarangSoapWSDDServiceName());
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
		if ("BarangSoap".equals(inputPortName)) {
			return getBarangSoap();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"http://soap.frexescwebservice.com", "BarangSoapService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"http://soap.frexescwebservice.com", "BarangSoap"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("BarangSoap".equals(portName)) {
			setBarangSoapEndpointAddress(address);
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
