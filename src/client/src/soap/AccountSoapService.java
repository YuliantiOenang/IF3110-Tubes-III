/**
 * AccountSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public interface AccountSoapService extends javax.xml.rpc.Service {
    public java.lang.String getAccountSoapAddress();

    public soap.AccountSoap getAccountSoap() throws javax.xml.rpc.ServiceException;

    public soap.AccountSoap getAccountSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
