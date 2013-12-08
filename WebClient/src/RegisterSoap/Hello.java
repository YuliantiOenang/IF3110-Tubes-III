/**
 * Hello.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package RegisterSoap;

public interface Hello extends java.rmi.Remote {
    public java.lang.String sayHello(java.lang.String name) throws java.rmi.RemoteException;
    public void addUser(java.lang.String id, java.lang.String email, java.lang.String password, java.lang.String fullname, java.lang.String alamat, java.lang.String provinsi, java.lang.String kota, int kodepos, int hp) throws java.rmi.RemoteException;
}
