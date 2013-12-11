/**
 * SOAPWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soaptest;

public interface SOAPWS extends java.rmi.Remote {
    public java.lang.String animalType(java.lang.String animal) throws java.rmi.RemoteException;
    public void addtoDB(java.lang.String table, java.lang.String query) throws java.rmi.RemoteException;
}
