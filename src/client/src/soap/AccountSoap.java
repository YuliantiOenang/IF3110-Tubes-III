/**
 * AccountSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public interface AccountSoap extends java.rmi.Remote {
    public void createAcc(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String email, java.lang.String alamat, java.lang.String provinsi, java.lang.String kota, java.lang.String kodepos, java.lang.String telepon, int role, int transaksi) throws java.rmi.RemoteException;
}
