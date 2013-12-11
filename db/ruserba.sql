-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: ruserba
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `username` char(30) DEFAULT NULL,
  `password` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','administrator');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barang` (
  `nama` char(30) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `kategori` char(20) DEFAULT NULL,
  `terjual` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` VALUES ('Beras Jepang',10000,1000,'beras',0),('Beras Pandan Wangi',11000,1000,'beras',0),('Beras Sentra Ramos',12000,1000,'beras',0),('Beras Rojolele',12500,1000,'beras',0),('Beras C4',13000,1000,'beras',0),('Tenderloin Beef',110000,1000,'daging',0),('Sirloin Beef',98000,1000,'daging',0),('Eyron Beef',95000,1000,'daging',0),('Rump Beef',95000,1000,'daging',0),('Lamosir',65000,1000,'daging',0),('Bandeng',26000,1000,'ikan',0),('Kembung',20000,1000,'ikan',0),('Banyar',22000,1000,'ikan',0),('Tongkol',20000,1000,'ikan',0),('Tengiri',40000,1000,'ikan',0),('Tomat',10000,1000,'sayur',0),('Wortel Lokal',8000,1000,'sayur',0),('Kentang Dieng',14000,1000,'sayur',0),('Brokoli',12000,1000,'sayur',0),('Kembang Kol',12000,1000,'sayur',0),('Sunkiest',24000,1000,'buah',0),('Apel Fuji',18000,1000,'buah',0),('Semangka',4000,1000,'buah',0),('Melon',8000,1000,'buah',0),('Pir',25000,1000,'buah',0);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` char(50) NOT NULL DEFAULT '',
  `nama` char(50) DEFAULT NULL,
  `nohp` char(50) DEFAULT NULL,
  `alamat` char(50) DEFAULT NULL,
  `provinsi` char(50) DEFAULT NULL,
  `kota` char(50) DEFAULT NULL,
  `kodepos` char(50) DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  `password` char(50) DEFAULT NULL,
  `cardno` char(50) DEFAULT NULL,
  `nameoncard` char(50) DEFAULT NULL,
  `expdate` char(50) DEFAULT NULL,
  `transaksi` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('mathsci','Muhammad Furqan Habibi','085311283819','Jalan Paus IV no 4','Sumatera Barat','Padang','25134','islamic_scientist@yahoo.com','matematika','12345678','M F Habibi','20/12/2012',1);
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

-- Dump completed on 2013-11-27  0:23:39
