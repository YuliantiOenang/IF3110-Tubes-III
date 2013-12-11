/**
 * SoapServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.esc.soap;

public class SoapServiceServiceLocator extends org.apache.axis.client.Service implements com.esc.soap.SoapServiceService {

    public SoapServiceServiceLocator() {
    }


    public SoapServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SoapServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SoapService
    private java.lang.String SoapService_address = "http://powerful-ravine-9200.herokuapp.com/services/SoapService";
    //private java.lang.String SoapService_address = "http://localhost:8080/escwbd/services/SoapService";

    public java.lang.String getSoapServiceAddress() {
        return SoapService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SoapServiceWSDDServiceName = "SoapService";

    public java.lang.String getSoapServiceWSDDServiceName() {
        return SoapServiceWSDDServiceName;
    }

    public void setSoapServiceWSDDServiceName(java.lang.String name) {
        SoapServiceWSDDServiceName = name;
    }

    public com.esc.soap.SoapService getSoapService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SoapService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoapService(endpoint);
    }

    public com.esc.soap.SoapService getSoapService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.esc.soap.SoapServiceSoapBindingStub _stub = new com.esc.soap.SoapServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSoapServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoapServiceEndpointAddress(java.lang.String address) {
        SoapService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.esc.soap.SoapService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.esc.soap.SoapServiceSoapBindingStub _stub = new com.esc.soap.SoapServiceSoapBindingStub(new java.net.URL(SoapService_address), this);
                _stub.setPortName(getSoapServiceWSDDServiceName());
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
        if ("SoapService".equals(inputPortName)) {
            return getSoapService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.esc.com", "SoapServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.esc.com", "SoapService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SoapService".equals(portName)) {
            setSoapServiceEndpointAddress(address);
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
