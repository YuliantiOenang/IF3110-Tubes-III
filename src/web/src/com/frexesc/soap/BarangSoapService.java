/**
 * BarangSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.soap;

public interface BarangSoapService extends javax.xml.rpc.Service {
	public java.lang.String getBarangSoapAddress();

	public com.frexesc.soap.BarangSoap getBarangSoap()
			throws javax.xml.rpc.ServiceException;

	public com.frexesc.soap.BarangSoap getBarangSoap(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException;
}
