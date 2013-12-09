/**
 * UserSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.soap;

public interface UserSoap extends java.rmi.Remote {
	public void register(java.lang.String username, java.lang.String password,
			java.lang.String email, java.lang.String name,
			java.lang.String telephone, java.lang.String address,
			java.lang.String province, java.lang.String city,
			java.lang.String postal) throws java.rmi.RemoteException;
}
