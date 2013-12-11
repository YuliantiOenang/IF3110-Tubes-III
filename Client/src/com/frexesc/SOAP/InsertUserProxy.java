package com.frexesc.SOAP;

public class InsertUserProxy implements InsertUser {
  private String _endpoint = null;
  private InsertUser insertUser = null;
  
  public InsertUserProxy() {
    _initInsertUserProxy();
  }
  
  public InsertUserProxy(String endpoint) {
    _endpoint = endpoint;
    _initInsertUserProxy();
  }
  
  private void _initInsertUserProxy() {
    try {
      insertUser = (new InsertUserServiceLocator()).getInsertUser();
      if (insertUser != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)insertUser)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)insertUser)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (insertUser != null)
      ((javax.xml.rpc.Stub)insertUser)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public InsertUser getInsertUser() {
    if (insertUser == null)
      _initInsertUserProxy();
    return insertUser;
  }
  
  public void insertUser(java.lang.String nama, java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String handphone, java.lang.String alamat, java.lang.String kota, java.lang.String provinsi, java.lang.String kodepos) throws java.rmi.RemoteException{
    if (insertUser == null)
      _initInsertUserProxy();
    insertUser.insertUser(nama, username, password, email, handphone, alamat, kota, provinsi, kodepos);
  }
  
  
}