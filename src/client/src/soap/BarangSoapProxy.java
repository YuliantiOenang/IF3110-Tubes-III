package soap;

public class BarangSoapProxy implements soap.BarangSoap {
  private String _endpoint = null;
  private soap.BarangSoap barangSoap = null;
  
  public BarangSoapProxy() {
    _initBarangSoapProxy();
  }
  
  public BarangSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initBarangSoapProxy();
  }
  
  private void _initBarangSoapProxy() {
    try {
      barangSoap = (new soap.BarangSoapServiceLocator()).getBarangSoap();
      if (barangSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)barangSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)barangSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (barangSoap != null)
      ((javax.xml.rpc.Stub)barangSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soap.BarangSoap getBarangSoap() {
    if (barangSoap == null)
      _initBarangSoapProxy();
    return barangSoap;
  }
  
  public void createBarang(int id_kategori, java.lang.String nama, int harga, java.lang.String gbr, int stock, int ctr, java.lang.String ket) throws java.rmi.RemoteException{
    if (barangSoap == null)
      _initBarangSoapProxy();
    barangSoap.createBarang(id_kategori, nama, harga, gbr, stock, ctr, ket);
  }
  
  
}