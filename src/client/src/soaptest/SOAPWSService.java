/**
 * SOAPWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soaptest;

public interface SOAPWSService extends javax.xml.rpc.Service {
    public java.lang.String getSOAPWSAddress();

    public soaptest.SOAPWS getSOAPWS() throws javax.xml.rpc.ServiceException;

    public soaptest.SOAPWS getSOAPWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
