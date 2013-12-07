package soap;

public class AccountSoapProxy implements soap.AccountSoap {
  private String _endpoint = null;
  private soap.AccountSoap accountSoap = null;
  
  public AccountSoapProxy() {
    _initAccountSoapProxy();
  }
  
  public AccountSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountSoapProxy();
  }
  
  private void _initAccountSoapProxy() {
    try {
      accountSoap = (new soap.AccountSoapServiceLocator()).getAccountSoap();
      if (accountSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accountSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accountSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accountSoap != null)
      ((javax.xml.rpc.Stub)accountSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soap.AccountSoap getAccountSoap() {
    if (accountSoap == null)
      _initAccountSoapProxy();
    return accountSoap;
  }
  
  public void createAcc(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String email, java.lang.String alamat, java.lang.String provinsi, java.lang.String kota, java.lang.String kodepos, java.lang.String telepon, int role, int transaksi) throws java.rmi.RemoteException{
    if (accountSoap == null)
      _initAccountSoapProxy();
    accountSoap.createAcc(username, password, nama, email, alamat, provinsi, kota, kodepos, telepon, role, transaksi);
  }
  
  
}