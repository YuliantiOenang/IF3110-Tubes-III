package com.frexesc.SOAP;

public class InsertBarangProxy implements InsertBarang {
  private String _endpoint = null;
  private InsertBarang insertBarang = null;
  
  public InsertBarangProxy() {
    _initInsertBarangProxy();
  }
  
  public InsertBarangProxy(String endpoint) {
    _endpoint = endpoint;
    _initInsertBarangProxy();
  }
  
  private void _initInsertBarangProxy() {
    try {
      insertBarang = (new InsertBarangServiceLocator()).getInsertBarang();
      if (insertBarang != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)insertBarang)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)insertBarang)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (insertBarang != null)
      ((javax.xml.rpc.Stub)insertBarang)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public InsertBarang getInsertBarang() {
    if (insertBarang == null)
      _initInsertBarangProxy();
    return insertBarang;
  }
  
  public void insertBarang(java.lang.String id_kategori, java.lang.String nama_barang, java.lang.String gambar, java.lang.String harga_barang, java.lang.String keterangan, java.lang.String jumlah_barang) throws java.rmi.RemoteException{
    if (insertBarang == null)
      _initInsertBarangProxy();
    insertBarang.insertBarang(id_kategori, nama_barang, gambar, harga_barang, keterangan, jumlah_barang);
  }
  
  
}