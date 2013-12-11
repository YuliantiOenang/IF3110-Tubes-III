package tubes2wbd;

public class SoapProxy implements tubes2wbd.Soap {
  private String _endpoint = null;
  private tubes2wbd.Soap soap = null;
  
  public SoapProxy() {
    _initSoapProxy();
  }
  
  public SoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSoapProxy();
  }
  
  private void _initSoapProxy() {
    try {
      soap = (new tubes2wbd.SoapServiceLocator()).getsoap();
      if (soap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)soap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (soap != null)
      ((javax.xml.rpc.Stub)soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tubes2wbd.Soap getSoap() {
    if (soap == null)
      _initSoapProxy();
    return soap;
  }
  
  public java.lang.String registeruser(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String nohp, java.lang.String alamat, java.lang.String provinsi, java.lang.String kota, java.lang.String kodepos, java.lang.String email) throws java.rmi.RemoteException{
    if (soap == null)
      _initSoapProxy();
    return soap.registeruser(username, password, nama, nohp, alamat, provinsi, kota, kodepos, email);
  }
  
  public java.lang.String additem(java.lang.String nama, java.lang.String img, java.lang.String harga, java.lang.String kategori, java.lang.String jumlah, java.lang.String deskripsi) throws java.rmi.RemoteException{
    if (soap == null)
      _initSoapProxy();
    return soap.additem(nama, img, harga, kategori, jumlah, deskripsi);
  }
  
  
}