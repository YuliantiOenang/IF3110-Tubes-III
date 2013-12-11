-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: ruserba
-- ------------------------------------------------------
-- Server version	5.5.16
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO,POSTGRESQL' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table "barang"
--

DROP TABLE IF EXISTS "barang";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "barang" (
  "id_barang" int(11) NOT NULL,
  "nama_barang" varchar(256) NOT NULL,
  "id_kategori" int(11) NOT NULL,
  "harga_barang" bigint(20) NOT NULL,
  "gambar" varchar(256) NOT NULL,
  "tersedia" int(11) NOT NULL,
  "dibeli" int(11) NOT NULL,
  PRIMARY KEY ("id_barang"),
  KEY "id_kategori" ("id_kategori"),
  CONSTRAINT "barang_ibfk_1" FOREIGN KEY ("id_kategori") REFERENCES "kategori" ("id_kategori") ON DELETE CASCADE ON UPDATE CASCADE
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "barang"
--

LOCK TABLES "barang" WRITE;
/*!40000 ALTER TABLE "barang" DISABLE KEYS */;
INSERT INTO "barang" VALUES (1,'Giordano',1,300000,'giordano.jpg',10,1),(2,'Polo',1,150000,'polo.jpg',10,1),(3,'Dagadu',1,50000,'dagadu.jpg',30,10),(4,'Joger',1,40000,'joger.jpg',5,1),(5,'Samsung',2,1500000,'samsung.jpg',13,10),(6,'Iphone',2,5000000,'iphone.jpg',5,0),(7,'Nokia',2,2000000,'nokia.jpg',6,3),(8,'Mito',2,200000,'mito.jpg',7,3),(9,'Cubitus',3,150000,'cubitus.jpg',6,3),(10,'Levis',3,400000,'Levis.jpg',5,1),(11,'Lee',3,300000,'lee.jpg',4,2),(12,'Ayam Bawang',4,2000,'ayambawang.png',50,10),(13,'Rendang',4,2500,'rendang.png',10,50),(14,'Kari Ayam',4,2000,'kariayam.jpg',40,15),(15,'Cabe Ijo',4,2000,'cabeijo.jpg',40,20),(16,'Soto',4,2000,'soto.jpg',25,10),(17,'Aqua',5,3000,'aqua.jpg',10,20),(18,'Mizone',5,5000,'mizone.jpg',20,1),(19,'Kiranti',5,6000,'kiranti.jpg',1,1),(20,'Mix Max',5,20000,'mixmax.jpg',1,60),(21,'Vit',5,1000,'vit.jpg',10,0);
/*!40000 ALTER TABLE "barang" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "kartu_kredit"
--

DROP TABLE IF EXISTS "kartu_kredit";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "kartu_kredit" (
  "username" varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  "no_kartu" varchar(16) NOT NULL,
  "nama" varchar(256) NOT NULL,
  "kadaluarsa" date NOT NULL,
  PRIMARY KEY ("username"),
  CONSTRAINT "kartu_kredit_ibfk_1" FOREIGN KEY ("username") REFERENCES "user" ("username") ON DELETE CASCADE ON UPDATE CASCADE
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "kartu_kredit"
--

LOCK TABLES "kartu_kredit" WRITE;
/*!40000 ALTER TABLE "kartu_kredit" DISABLE KEYS */;
INSERT INTO "kartu_kredit" VALUES ('admin','1732979879817329','admin ga ganteng','2013-10-31');
/*!40000 ALTER TABLE "kartu_kredit" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "kategori"
--

DROP TABLE IF EXISTS "kategori";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "kategori" (
  "id_kategori" int(11) NOT NULL,
  "nama_kategori" varchar(256) NOT NULL,
  PRIMARY KEY ("id_kategori")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "kategori"
--

LOCK TABLES "kategori" WRITE;
/*!40000 ALTER TABLE "kategori" DISABLE KEYS */;
INSERT INTO "kategori" VALUES (1,'Baju'),(2,'Gadget'),(3,'Celana'),(4,'Indomie'),(5,'Minuman');
/*!40000 ALTER TABLE "kategori" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "user"
--

DROP TABLE IF EXISTS "user";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "user" (
  "username" varchar(20) COLLATE utf8_bin NOT NULL,
  "password" varchar(256) COLLATE utf8_bin NOT NULL,
  "token" varchar(20) COLLATE utf8_bin DEFAULT NULL,
  "last_login" date DEFAULT NULL,
  PRIMARY KEY ("username"),
  UNIQUE KEY "token" ("token")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "user"
--

LOCK TABLES "user" WRITE;
/*!40000 ALTER TABLE "user" DISABLE KEYS */;
INSERT INTO "user" VALUES ('admin','asdfasdf',NULL,NULL);
/*!40000 ALTER TABLE "user" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "user_profile"
--

DROP TABLE IF EXISTS "user_profile";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "user_profile" (
  "username" varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  "nama" varchar(256) NOT NULL,
  "email" varchar(100) NOT NULL,
  "alamat" varchar(256) DEFAULT NULL,
  "kota" varchar(256) DEFAULT NULL,
  "kode_pos" varchar(5) DEFAULT NULL,
  "provinsi" varchar(256) DEFAULT NULL,
  "nomor_ponsel" varchar(15) DEFAULT NULL,
  PRIMARY KEY ("username"),
  UNIQUE KEY "email" ("email"),
  CONSTRAINT "user_profile_ibfk_1" FOREIGN KEY ("username") REFERENCES "user" ("username") ON DELETE CASCADE ON UPDATE CASCADE
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "user_profile"
--

LOCK TABLES "user_profile" WRITE;
/*!40000 ALTER TABLE "user_profile" DISABLE KEYS */;
INSERT INTO "user_profile" VALUES ('admin','admin ganteng','admin@ruserba.com','alamat admin','kota admin','13452','prov admin','0987654321');
/*!40000 ALTER TABLE "user_profile" ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-10 21:13:59
