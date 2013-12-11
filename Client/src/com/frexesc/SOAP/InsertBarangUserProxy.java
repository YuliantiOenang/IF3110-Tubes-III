package com.frexesc.SOAP;

public class InsertBarangUserProxy implements InsertBarangUser {
  private String _endpoint = null;
  private InsertBarangUser insertBarangUser = null;
  
  public InsertBarangUserProxy() {
    _initInsertBarangUserProxy();
  }
  
  public InsertBarangUserProxy(String endpoint) {
    _endpoint = endpoint;
    _initInsertBarangUserProxy();
  }
  
  private void _initInsertBarangUserProxy() {
    try {
      insertBarangUser = (new InsertBarangUserServiceLocator()).getInsertBarangUser();
      if (insertBarangUser != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)insertBarangUser)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)insertBarangUser)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (insertBarangUser != null)
      ((javax.xml.rpc.Stub)insertBarangUser)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public InsertBarangUser getInsertBarangUser() {
    if (insertBarangUser == null)
      _initInsertBarangUserProxy();
    return insertBarangUser;
  }
  
  public void insertBarangUser(java.lang.String id, java.lang.String user, java.lang.String qty, java.lang.String desc) throws java.rmi.RemoteException{
    if (insertBarangUser == null)
      _initInsertBarangUserProxy();
    insertBarangUser.insertBarangUser(id, user, qty, desc);
  }
  
  
}