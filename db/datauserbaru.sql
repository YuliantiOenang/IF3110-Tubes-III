-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: datauser
-- ------------------------------------------------------
-- Server version	5.5.27

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
  `IdBarang` int(11) DEFAULT NULL,
  `NamaBarang` varchar(20) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  `Kategori` varchar(20) DEFAULT NULL,
  `Jumlah` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` VALUES (1,'DagingSapi',80000,'Daging',13),(3,'ChickenNugget',30000,'Frozen Food',15),(4,'BayamItali',5000,'Sayuran',14),(6,'DagingYak',85000,'Daging',12),(7,'BerasTajMurah',100,'Beras',0),(8,'BerasHCSR04',22000,'Beras',7),(9,'BerasRaskin',20000,'Beras',12),(10,'DagingAyam',122000,'Daging',2),(11,'DagingDomba',92000,'Daging',8),(12,'PetaiCHINA',2500,'Sayuran',6),(13,'SeledriHongkong',4500,'Sayuran',12),(14,'TimunAustralia',14500,'Sayuran',5),(15,'SOZZZZZZIS',32000,'Frozen Food',25),(16,'FIESTANIGGA',22000,'Frozen Food',15),(17,'BAKSOSOGOOD',28000,'Frozen Food',42),(18,'Beras A-KING',200,'Beras',22),(NULL,'BerasBaru',15000,'Beras',2),(NULL,'BerasCarrefour',20000,'Beras',5),(NULL,'BerasTajMahal',25000,'Beras',3),(NULL,'IceCream',10000,'Frozen Food',5);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcard` (
  `number` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `expiredate` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES ('12341234','budi lagi','2014-04-07');
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionlog`
--

DROP TABLE IF EXISTS `transactionlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionlog` (
  `IdBarang` int(11) DEFAULT NULL,
  `NamaBarang` varchar(20) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  `Jumlah` int(11) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Kategori` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionlog`
--

LOCK TABLES `transactionlog` WRITE;
/*!40000 ALTER TABLE `transactionlog` DISABLE KEYS */;
INSERT INTO `transactionlog` VALUES (1,'DagingSapi',80000,3,'budie','Daging'),(1,'DagingSapi',80000,2,'budie','Daging'),(2,'IceCream',10000,3,'budie','Snack'),(2,'IceCream',10000,4,'budie','Snack'),(3,'ChickenNugget',30000,1,'budie','Frozen Food'),(3,'ChickenNugget',30000,1,'budie','Frozen Food'),(4,'BayamItali',5000,7,'budie','Sayuran'),(5,'BerasCarrefour',12000,2,'budie','Beras'),(6,'DagingYak',85000,7,'budie','Daging'),(6,'DagingYak',85000,5,'budie','Daging'),(6,'DagingYak',85000,5,'budie','Daging'),(5,'BerasCarrefour',12000,3,'budie','Beras'),(7,'BerasTajMahal',25000,5,'budie','Beras'),(1,'DagingSapi',80000,2,'budie','Daging'),(10,'DagingAyam',122000,3,'budie','Daging'),(4,'BayamItali',5000,2,'budie','Sayuran'),(12,'PetaiCHINA',2500,3,'budie','Sayuran'),(3,'ChickenNugget',30000,2,'budie','Frozen Food'),(5,'BerasCarrefour',12000,1,'Boci','Beras'),(4,'BayamItali',5000,1,'budie','Sayuran'),(7,'BerasTajMurah',100,1,'buudi','Beras'),(7,'BerasTajMurah',100,1,'buudi','Beras'),(7,'BerasTajMurah',100,1,'buudi','Beras'),(7,'BerasTajMurah',100,2,'buudi','Beras'),(1,'DagingSapi',80000,1,'buudi','Daging'),(1,'DagingSapi',80000,1,'buudi','Daging');
/*!40000 ALTER TABLE `transactionlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `namalengkap` varchar(50) DEFAULT NULL,
  `nohp` varchar(50) DEFAULT NULL,
  `provinsi` varchar(50) DEFAULT NULL,
  `kotakabupaten` varchar(50) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `kodepos` varchar(50) DEFAULT NULL,
  `nocredit` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('aditya','12341234','adt@adit.com','adit ya','1234123048','aksjdfkansd','kansdknf','kjjdinfoa','2134123','12341234'),('admin','admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('budie','12345678','budie@gmail.com','budi budi','2134','Jawa Barat','Bandung','Bandung','4001',NULL),('budih','12341234','budie@budi.com','budi handoko','12345','lalala','lalala','lalala','4444','12341234'),('buudi','password','budi@budi.com','Budi Ini','08181818132','Jawa Barat','Bandung','Gataw','4444','NULL'),('cobabro','12341234','coba@bro.com','coba bro','081508150815','Jambi','Jambi','Jambi','3000',NULL),('cobadulu','12345678','coba@dulu.com','coba dulu','01234','SULAWESI','sulawesi','sulawesi','7000','12341234'),('cobalagi','12341234','cobalagi@lagi.com','coba dong','085708570857','Jambi','Jambi','Jambi','31365',NULL),('lalayeye','12345678','lala@yeye.com','lala yeye','981379134','asdfgs','asdgs','adfhgs','345',NULL),('testtest','12341234','test@test.com','test test','0102030405','jawa','jawa','jawa','1234',NULL),('username1','12345678','username@username.com','username satu','12344312','Jawa Barat','Jawa','Jawa','1000',NULL),('yanti','1234512345','yanti@yanti.com','yanti yanti','08080909','Kalimantan Barat','Jakarta','Jalan layang no 44','5000','12341234'),('yoibro','12345678','yoi@bro.com','yoi bro','0101010101','lalala','yeyeye','layelaye','000',NULL);
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

-- Dump completed on 2013-11-27 17:17:32
