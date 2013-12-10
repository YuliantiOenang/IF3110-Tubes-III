/**
 * BarangUserSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.soap;

public interface BarangUserSoap extends java.rmi.Remote {
	public void addCart(long id_item, long id_user, int total_item,
			java.lang.String description) throws java.rmi.RemoteException;
}
