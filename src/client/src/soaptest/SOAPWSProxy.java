package soaptest;

public class SOAPWSProxy implements soaptest.SOAPWS {
  private String _endpoint = null;
  private soaptest.SOAPWS sOAPWS = null;
  
  public SOAPWSProxy() {
    _initSOAPWSProxy();
  }
  
  public SOAPWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOAPWSProxy();
  }
  
  private void _initSOAPWSProxy() {
    try {
      sOAPWS = (new soaptest.SOAPWSServiceLocator()).getSOAPWS();
      if (sOAPWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOAPWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOAPWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOAPWS != null)
      ((javax.xml.rpc.Stub)sOAPWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soaptest.SOAPWS getSOAPWS() {
    if (sOAPWS == null)
      _initSOAPWSProxy();
    return sOAPWS;
  }
  
  public java.lang.String animalType(java.lang.String animal) throws java.rmi.RemoteException{
    if (sOAPWS == null)
      _initSOAPWSProxy();
    return sOAPWS.animalType(animal);
  }
  
  public void addtoDB(java.lang.String table, java.lang.String query) throws java.rmi.RemoteException{
    if (sOAPWS == null)
      _initSOAPWSProxy();
    sOAPWS.addtoDB(table, query);
  }
  
  
}