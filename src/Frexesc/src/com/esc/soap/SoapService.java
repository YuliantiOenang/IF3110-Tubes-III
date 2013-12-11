/**
 * SoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.esc.soap;

public interface SoapService extends java.rmi.Remote {
    public java.lang.String createBarang(int id, int id_kategori, java.lang.String nama, java.lang.String gambar, int harga_barang, java.lang.String keterangan, int jumlah_barang) throws java.rmi.RemoteException;
    public java.lang.String createUser(int id, java.lang.String username, java.lang.String password, java.lang.String handphone, java.lang.String alamat, java.lang.String provinsi, java.lang.String kota, java.lang.String kodepos, java.lang.String email, int role, java.lang.String nama, java.lang.String nomor_kartu, java.lang.String nama_kartu, java.lang.String expire_kartu, int transaksi) throws java.rmi.RemoteException;
    public java.lang.String createBarangUser(int id, int id_barang, int id_user, int status, int jumlah_barang, java.lang.String tanggal_pembelian, java.lang.String deskripsi_tambahan) throws java.rmi.RemoteException;
}
