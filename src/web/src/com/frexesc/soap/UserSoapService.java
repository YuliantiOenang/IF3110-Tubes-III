/**
 * UserSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.soap;

public interface UserSoapService extends javax.xml.rpc.Service {
	public java.lang.String getUserSoapAddress();

	public com.frexesc.soap.UserSoap getUserSoap()
			throws javax.xml.rpc.ServiceException;

	public com.frexesc.soap.UserSoap getUserSoap(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException;
}
