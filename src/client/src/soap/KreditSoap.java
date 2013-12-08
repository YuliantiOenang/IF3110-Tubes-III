/**
 * KreditSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public interface KreditSoap extends java.rmi.Remote {
    public void createKredit(int id_account, java.lang.String card_number, java.lang.String name_of_card, java.lang.String expired_date) throws java.rmi.RemoteException;
}
