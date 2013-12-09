/**
 * AccountSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public class AccountSoapServiceLocator extends org.apache.axis.client.Service implements soap.AccountSoapService {

    public AccountSoapServiceLocator() {
    }


    public AccountSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AccountSoap
    private java.lang.String AccountSoap_address = "http://calvinsalvy.ap01.aws.af.cm/services/AccountSoap";

    public java.lang.String getAccountSoapAddress() {
        return AccountSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AccountSoapWSDDServiceName = "AccountSoap";

    public java.lang.String getAccountSoapWSDDServiceName() {
        return AccountSoapWSDDServiceName;
    }

    public void setAccountSoapWSDDServiceName(java.lang.String name) {
        AccountSoapWSDDServiceName = name;
    }

    public soap.AccountSoap getAccountSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AccountSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAccountSoap(endpoint);
    }

    public soap.AccountSoap getAccountSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            soap.AccountSoapSoapBindingStub _stub = new soap.AccountSoapSoapBindingStub(portAddress, this);
            _stub.setPortName(getAccountSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAccountSoapEndpointAddress(java.lang.String address) {
        AccountSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (soap.AccountSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                soap.AccountSoapSoapBindingStub _stub = new soap.AccountSoapSoapBindingStub(new java.net.URL(AccountSoap_address), this);
                _stub.setPortName(getAccountSoapWSDDServiceName());
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
        if ("AccountSoap".equals(inputPortName)) {
            return getAccountSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap", "AccountSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap", "AccountSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AccountSoap".equals(portName)) {
            setAccountSoapEndpointAddress(address);
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
