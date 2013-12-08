-- MySQL dump 10.13  Distrib 5.5.32, for Win32 (x86)
--
-- Host: localhost    Database: ruserba
-- ------------------------------------------------------
-- Server version	5.5.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `id_kategori` int(11) NOT NULL,
  `nama_barang` varchar(256) NOT NULL,
  `harga` int(11) NOT NULL,
  `satuan` varchar(32) NOT NULL,
  `deskripsi` varchar(1024) DEFAULT NULL,
  `jumlah_pembelian` int(11) DEFAULT '0',
  `jumlah_stok` int(11) DEFAULT '0',
  `nama_gambar` varchar(256) NOT NULL,
  `nama_gambar_thumb` varchar(256) NOT NULL,
  PRIMARY KEY (`id_barang`),
  KEY `id_kategori` (`id_kategori`),
  CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` VALUES (1,4,'Apel',3390,'100 gram','Buah yang berkhasiat untuk menjauhkan dokter dari Anda.',43,73,'buah_apel.jpg','buah_apel_thumb.jpg'),(2,3,'Brokoli',1390,'100 gram','Sayuran yang mengandung banyak vitamin C dan serat. Menurut Wikipedia, sebaiknya diolah dengan cara dikukus agar nutrisinya tetap terjaga.',24,16,'sayur_brokoli.jpg','sayur_brokoli_thumb.jpg'),(3,1,'Beras',8900,'kilogram','Makanan pokok',53,134,'beras_putih.jpg','beras_putih_thumb.jpg'),(4,4,'Ceri',2300,'100 gram','Deskripsi ceri disini.',85,41,'buah_cherry.jpg','buah_cherry_thumb.jpg'),(5,4,'Durian',2900,'100 gram','Deskripsi durian disini.',41,42,'buah_durian.jpg','buah_durian_thumb.jpg'),(6,4,'Jambu batu',2490,'100 gram','Deskripsi jambu batu disini.',35,31,'buah_jambubatu.jpg','buah_jambubatu_thumb.jpg'),(7,4,'Jeruk',3280,'100 gram','Deskripsi jeruk disini.',53,31,'buah_jeruk.jpg','buah_jeruk_thumb.jpg'),(8,4,'Kiwi',5190,'100 gram','Deskripsi kiwi disini.',56,56,'buah_kiwi.jpg','buah_kiwi_thumb.jpg'),(9,4,'Mangga',2390,'100 gram','Deskripsi mangga disini.',73,76,'buah_mangga.jpg','buah_mangga_thumb.jpg'),(10,4,'Manggis',2290,'100 gram','Deskripsi manggis disini.',86,24,'buah_manggis.jpg','buah_manggis_thumb.jpg'),(11,4,'Melon',2470,'100 gram','Deskripsi melon disini.',41,41,'buah_melon.jpg','buah_melon_thumb.jpg'),(12,4,'Nanas',3190,'100 gram','Deskripsi nanas disini.',96,67,'buah_nanas.jpg','buah_nanas_thumb.jpg'),(13,4,'Pisang',2340,'100 gram','Deskripsi pisang disini.',45,87,'buah_pisang.jpg','buah_pisang_thumb.jpg'),(14,4,'Semangka',3500,'100 gram','Deskripsi semangka disini.',65,31,'buah_semangka.jpg','buah_semangka_thumb.jpg'),(15,4,'Stroberi',4120,'100 gram','Deskripsi stroberi disini.',32,41,'buah_stroberi.jpg','buah_stroberi_thumb.jpg'),(16,4,'Zaitun',2340,'100 gram','Deskripsi zaitun disini.',52,23,'buah_zaitun.jpg','buah_zaitun_thumb.jpg'),(17,1,'Kacang hijau',2320,'100 gram','Kacang hijau baik untuk kesehatan.',41,49,'kacang_hijau.jpg','kacang_hijau_thumb.jpg'),(18,1,'Beras merah',3890,'100 gram','Deskripsi untuk beras merah disini',34,41,'beras_merah.jpg','beras_merah_thumb.jpg'),(19,5,'Bawang putih',2340,'100 gram','Deskripsi untuk bawang putih disini',34,41,'bumbu_bawangputih.jpg','bumbu_bawangputih_thumb.jpg'),(20,5,'Bawang merah',2190,'100 gram','Deskripsi untuk bawang merah disini',41,87,'bumbu_bawangmerah.jpg','bumbu_bawangmerah_thumb.jpg'),(21,5,'Kayu manis',3430,'100 gram','Deskripsi untuk kayu manis disini',12,32,'bumbu_kayumanis.jpg','bumbu_kayumanis_thumb.jpg'),(22,2,'Daging ayam',4290,'100 gram','Deskripsi untuk daging ayam disini',76,46,'daging_ayam.jpg','daging_ayam_thumb.jpg'),(23,2,'Daging sapi',6890,'100 gram','Deskripsi untuk daging sapi disini',32,21,'daging_sapi.jpg','daging_sapi_thumb.jpg'),(24,2,'Daging ikan',5470,'100 gram','Deskripsi untuk daging ikan disini',67,32,'daging_ikan.jpg','daging_ikan_thumb.jpg'),(25,3,'Bayam',3290,'100 gram','Deskripsi untuk bayam disini',58,32,'sayur_bayam_hijau.jpg','sayur_bayam_hijau_thumb.jpg'),(26,3,'Buncis',2990,'100 gram','Deskripsi untuk buncis disini',46,31,'sayur_buncis.jpg','sayur_buncis_thumb.jpg');
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategori`
--

DROP TABLE IF EXISTS `kategori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kategori` varchar(256) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategori`
--

LOCK TABLES `kategori` WRITE;
/*!40000 ALTER TABLE `kategori` DISABLE KEYS */;
INSERT INTO `kategori` VALUES (1,'Beras dan kacang-kacangan'),(2,'Daging dan telur'),(3,'Sayur-mayur'),(4,'Buah-buahan'),(5,'Bumbu dapur');
/*!40000 ALTER TABLE `kategori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `nama_lengkap` varchar(256) NOT NULL,
  `provinsi` varchar(256) DEFAULT NULL,
  `kota` varchar(256) DEFAULT NULL,
  `alamat` varchar(32) DEFAULT NULL,
  `kode_pos` varchar(32) DEFAULT NULL,
  `kontak` varchar(32) DEFAULT NULL,
  `nomor_kartu` varchar(256) DEFAULT NULL,
  `nama_kartu` varchar(256) DEFAULT NULL,
  `ekspirasi_kartu` date DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'johnny','john@yahoo.com','0d107d09f5bbe40cade3de5c71e9e9b7','John Smith','Jawa Barat','Bandung','Jl. Ganeca No.42A','14562','081347556202','3141-5156-1425-5421','John Smith','2016-09-01',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-11-27 18:47:08
