/**
 * InsertBarangServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.SOAP;

public class InsertBarangServiceLocator extends org.apache.axis.client.Service implements InsertBarangService {

    public InsertBarangServiceLocator() {
    }


    public InsertBarangServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InsertBarangServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for InsertBarang
    private java.lang.String InsertBarang_address = "http://coba-soap.ap01.aws.af.cm/services/InsertBarang";

    public java.lang.String getInsertBarangAddress() {
        return InsertBarang_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String InsertBarangWSDDServiceName = "InsertBarang";

    public java.lang.String getInsertBarangWSDDServiceName() {
        return InsertBarangWSDDServiceName;
    }

    public void setInsertBarangWSDDServiceName(java.lang.String name) {
        InsertBarangWSDDServiceName = name;
    }

    public InsertBarang getInsertBarang() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(InsertBarang_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getInsertBarang(endpoint);
    }

    public InsertBarang getInsertBarang(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            InsertBarangSoapBindingStub _stub = new InsertBarangSoapBindingStub(portAddress, this);
            _stub.setPortName(getInsertBarangWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setInsertBarangEndpointAddress(java.lang.String address) {
        InsertBarang_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (InsertBarang.class.isAssignableFrom(serviceEndpointInterface)) {
                InsertBarangSoapBindingStub _stub = new InsertBarangSoapBindingStub(new java.net.URL(InsertBarang_address), this);
                _stub.setPortName(getInsertBarangWSDDServiceName());
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
        if ("InsertBarang".equals(inputPortName)) {
            return getInsertBarang();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webService", "InsertBarangService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webService", "InsertBarang"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("InsertBarang".equals(portName)) {
            setInsertBarangEndpointAddress(address);
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
