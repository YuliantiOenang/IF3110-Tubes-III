/**
 * KreditSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public interface KreditSoapService extends javax.xml.rpc.Service {
    public java.lang.String getKreditSoapAddress();

    public soap.KreditSoap getKreditSoap() throws javax.xml.rpc.ServiceException;

    public soap.KreditSoap getKreditSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
