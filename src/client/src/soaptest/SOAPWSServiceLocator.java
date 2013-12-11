/**
 * SOAPWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soaptest;

public class SOAPWSServiceLocator extends org.apache.axis.client.Service implements soaptest.SOAPWSService {

    public SOAPWSServiceLocator() {
    }


    public SOAPWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SOAPWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SOAPWS
    private java.lang.String SOAPWS_address = "http://localhost:8080/calvinsalvy-webservice/services/SOAPWS";

    public java.lang.String getSOAPWSAddress() {
        return SOAPWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SOAPWSWSDDServiceName = "SOAPWS";

    public java.lang.String getSOAPWSWSDDServiceName() {
        return SOAPWSWSDDServiceName;
    }

    public void setSOAPWSWSDDServiceName(java.lang.String name) {
        SOAPWSWSDDServiceName = name;
    }

    public soaptest.SOAPWS getSOAPWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SOAPWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOAPWS(endpoint);
    }

    public soaptest.SOAPWS getSOAPWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            soaptest.SOAPWSSoapBindingStub _stub = new soaptest.SOAPWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getSOAPWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSOAPWSEndpointAddress(java.lang.String address) {
        SOAPWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (soaptest.SOAPWS.class.isAssignableFrom(serviceEndpointInterface)) {
                soaptest.SOAPWSSoapBindingStub _stub = new soaptest.SOAPWSSoapBindingStub(new java.net.URL(SOAPWS_address), this);
                _stub.setPortName(getSOAPWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SOAPWS".equals(inputPortName)) {
            return getSOAPWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soaptest", "SOAPWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soaptest", "SOAPWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SOAPWS".equals(portName)) {
            setSOAPWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
