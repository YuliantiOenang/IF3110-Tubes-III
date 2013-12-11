/**
 * InsertBarangUserServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.frexesc.SOAP;

public class InsertBarangUserServiceLocator extends org.apache.axis.client.Service implements InsertBarangUserService {

    public InsertBarangUserServiceLocator() {
    }


    public InsertBarangUserServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InsertBarangUserServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for InsertBarangUser
    private java.lang.String InsertBarangUser_address = "http://localhost:8080/web-services/services/InsertBarangUser";

    public java.lang.String getInsertBarangUserAddress() {
        return InsertBarangUser_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String InsertBarangUserWSDDServiceName = "InsertBarangUser";

    public java.lang.String getInsertBarangUserWSDDServiceName() {
        return InsertBarangUserWSDDServiceName;
    }

    public void setInsertBarangUserWSDDServiceName(java.lang.String name) {
        InsertBarangUserWSDDServiceName = name;
    }

    public InsertBarangUser getInsertBarangUser() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(InsertBarangUser_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getInsertBarangUser(endpoint);
    }

    public InsertBarangUser getInsertBarangUser(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            InsertBarangUserSoapBindingStub _stub = new InsertBarangUserSoapBindingStub(portAddress, this);
            _stub.setPortName(getInsertBarangUserWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setInsertBarangUserEndpointAddress(java.lang.String address) {
        InsertBarangUser_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (InsertBarangUser.class.isAssignableFrom(serviceEndpointInterface)) {
                InsertBarangUserSoapBindingStub _stub = new InsertBarangUserSoapBindingStub(new java.net.URL(InsertBarangUser_address), this);
                _stub.setPortName(getInsertBarangUserWSDDServiceName());
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
        if ("InsertBarangUser".equals(inputPortName)) {
            return getInsertBarangUser();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webService", "InsertBarangUserService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webService", "InsertBarangUser"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("InsertBarangUser".equals(portName)) {
            setInsertBarangUserEndpointAddress(address);
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
