package soap;

public class KreditSoapProxy implements soap.KreditSoap {
  private String _endpoint = null;
  private soap.KreditSoap kreditSoap = null;
  
  public KreditSoapProxy() {
    _initKreditSoapProxy();
  }
  
  public KreditSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initKreditSoapProxy();
  }
  
  private void _initKreditSoapProxy() {
    try {
      kreditSoap = (new soap.KreditSoapServiceLocator()).getKreditSoap();
      if (kreditSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)kreditSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)kreditSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (kreditSoap != null)
      ((javax.xml.rpc.Stub)kreditSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soap.KreditSoap getKreditSoap() {
    if (kreditSoap == null)
      _initKreditSoapProxy();
    return kreditSoap;
  }
  
  public void createKredit(int id_account, java.lang.String card_number, java.lang.String name_of_card, java.lang.String expired_date) throws java.rmi.RemoteException{
    if (kreditSoap == null)
      _initKreditSoapProxy();
    kreditSoap.createKredit(id_account, card_number, name_of_card, expired_date);
  }
  
  
}