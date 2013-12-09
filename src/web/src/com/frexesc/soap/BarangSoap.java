/**
 * BarangSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.soap;

public interface BarangSoap extends java.rmi.Remote {
	public void addBarang(long id_category, java.lang.String name,
			java.lang.String picture, int price, java.lang.String description,
			int total_item) throws java.rmi.RemoteException;
}
