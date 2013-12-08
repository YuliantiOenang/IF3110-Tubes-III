/**
 * KreditSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public class KreditSoapServiceLocator extends org.apache.axis.client.Service implements soap.KreditSoapService {

    public KreditSoapServiceLocator() {
    }


    public KreditSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public KreditSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for KreditSoap
    private java.lang.String KreditSoap_address = "http://localhost:8080/CalvinSalvyWebservice/services/KreditSoap";

    public java.lang.String getKreditSoapAddress() {
        return KreditSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String KreditSoapWSDDServiceName = "KreditSoap";

    public java.lang.String getKreditSoapWSDDServiceName() {
        return KreditSoapWSDDServiceName;
    }

    public void setKreditSoapWSDDServiceName(java.lang.String name) {
        KreditSoapWSDDServiceName = name;
    }

    public soap.KreditSoap getKreditSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(KreditSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getKreditSoap(endpoint);
    }

    public soap.KreditSoap getKreditSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            soap.KreditSoapSoapBindingStub _stub = new soap.KreditSoapSoapBindingStub(portAddress, this);
            _stub.setPortName(getKreditSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setKreditSoapEndpointAddress(java.lang.String address) {
        KreditSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (soap.KreditSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                soap.KreditSoapSoapBindingStub _stub = new soap.KreditSoapSoapBindingStub(new java.net.URL(KreditSoap_address), this);
                _stub.setPortName(getKreditSoapWSDDServiceName());
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
        if ("KreditSoap".equals(inputPortName)) {
            return getKreditSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap", "KreditSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap", "KreditSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("KreditSoap".equals(portName)) {
            setKreditSoapEndpointAddress(address);
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
