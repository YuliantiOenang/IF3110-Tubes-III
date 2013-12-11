-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: ogitu
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Table structure for table `account_customer`
--

DROP TABLE IF EXISTS `account_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` char(32) NOT NULL,
  `nama_lengkap` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `site_id` smallint(5) unsigned NOT NULL,
  `phone` varchar(20) NOT NULL,
  `alamat` varchar(128) NOT NULL,
  `provinsi` varchar(64) NOT NULL,
  `postcode` varchar(10) NOT NULL,
  `city` varchar(64) NOT NULL,
  `cc_number` varchar(19) NOT NULL,
  `cc_expires` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_customer`
--

LOCK TABLES `account_customer` WRITE;
/*!40000 ALTER TABLE `account_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_product`
--

DROP TABLE IF EXISTS `catalog_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalog_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quantity` int(10) unsigned NOT NULL DEFAULT '0',
  `price` int(10) unsigned NOT NULL DEFAULT '0',
  `number_sold` int(10) NOT NULL DEFAULT '0',
  `name` varchar(128) NOT NULL,
  `description` text NOT NULL,
  `path` varchar(255) NOT NULL,
  `category` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_product`
--

LOCK TABLES `catalog_product` WRITE;
/*!40000 ALTER TABLE `catalog_product` DISABLE KEYS */;
INSERT INTO `catalog_product` VALUES (1,40,3000,0,'Bayam','Makanan popeye the sailorman.','/image/bayam.jpg','Sayur'),(2,20,500000,0,'Blazer','Mirip jas, tapi yang ini bisa bikin kamu \"terbakar\" :3','/image/blazer.jpg','Pakaian'),(3,40,40000,0,'Daging Sapi','Sapi-sapi terbaik bangsa','/image/sapi.jpg','Daging'),(4,30,3500,0,'Daging Unta','Unta-unta terbaik bangsa','/image/unta.jpg','Daging'),(5,40,5000,0,'Mangga','bukan cuma punten yang bisa menjawab mangga, Ruserba juga bisa.','/image/mangga.jpg','Buah'),(6,70,32000,0,'Anggur','bukan cuma ada Mangga di Ruserba, anggur juga ada','/image/anggur.jpg','Buah'),(7,20,6000,0,'Bawang Merah','Ngga sejahat ibu tiri','/image/bawang_merah.gif','Sayur'),(8,40,8000,0,'Bawang Bombay','Ngga secupu bawang putih','/image/bawang_bombay.jpg','Sayur'),(9,40,50000,0,'Jaket Geng Motor','harga toko, kualitas distro','/image/jaket_geng_motor.jpg','Pakaian'),(10,40,200000,0,'Gaun Balerina','Ragu juga ada yang mau beli ginian','/image/gaun_balerina.jpg','Pakaian'),(11,20,2000,0,'Apel','Semua apel dari apel malang sampai apel washington','/image/apel.jpg','Buah'),(12,20,5000,0,'Asparagus','Seperti namanya, ini asparagus. yang suka dijadiin sup itu lho..','/image/asparagus.jpg','Sayur'),(13,20,90000,0,'Daging Ayam','Bisa dijadiin ayam goreng','/image/ayam.jpg','Daging'),(14,20,2000,0,'Brokoli','Bukan Edi Brokoli, ini brokoli yang buat dibikin sop','/image/brokoli.jpg','Sayur'),(15,20,2000,0,'Buah Piiiiiip','Jangan mikir yang ngga2 ya','/image/buah_piiiiiip.png','Buah'),(16,20,2000,0,'Buku Dewasa','Hanya untuk 17 tahun ke atas','/image/buku_dewasa.gif','Alat Tulis'),(17,20,2000,0,'Buku Tulis','Untuk SD dan SMP','/image/buku_tulis.jpg','Alat Tulis'),(18,20,3000,0,'CD','Compact Disk. Kalo nyari celana dalam, cari di bagian Pakaian','/image/cd.png','Alat Tulis'),(19,20,50000,0,'Celana Jeans Pria','Celana jeans yang gombrong-gombrong.','/image/celana_jeans_pria.jpg','Pakaian'),(20,20,40000,0,'Celana Bahan','Baik dipakai untuk pria dan wanita. Semua ukuran.','/image/celana_bahan.jpg','Pakaian'),(21,20,50000,0,'Celana Jeans Wanita','Celana jeans  buat wanita dan cowok ngondek','/image/celana_jeans_wanita.jpg','Pakaian'),(22,20,10000,0,'Crayon','Crayon 12 warna','/image/crayon.jpg','Alat Tulis'),(23,20,10000,0,'Cumi','Cumi dengan merk Squid-guard','/image/cumi.jpg','Daging'),(24,20,9000,0,'Cutter','Cutter dengan isi 8 pisau','/image/cutter.jpg','Alat Tulis'),(25,20,25000,0,'Dasi','Dasi bekas Mr. Bean','/image/dasi.jpg','Pakaian'),(26,20,45000,0,'Durian','Durian Montong asli Thailand','/image/durian.jpg','Buah'),(27,20,45000,0,'Ikan','Ikan Gurame ~3kg','/image/ikan.jpg','Daging'),(28,20,45000,0,'Jaket Tebal','Jaket tebal cukup untuk di kutub. Dijual juga di Gasibu','/image/jaket_tebal.jpg','Pakaian'),(29,20,5000,0,'Jeruk','Jeruk Mandarin dari saudagar tiongkok.','/image/jeruk.jpg','Buah'),(30,20,150000,0,'Kalkun','Satu ekor ayam kalkun montok','/image/kalkun.jpg','Daging'),(31,20,750000,0,'Kambing','Satu ekor kambing jantan / betina','/image/kambing.jpg','Daging'),(32,20,20000,0,'Kaos Kaki','Kaos Kaki Mondo','/image/kaos_kaki.jpg','Pakaian'),(33,20,2000,0,'Kedondong','Kedondong tanpa duri','/image/kedondong.jpg','Buah'),(34,20,70000,0,'Kemeja','Kemeja lengan pendek bermacam warna','/image/kemeja.jpg','Pakaian'),(35,20,70000,0,'Kepiting','Kepiting mentah','/image/kepiting.jpg','Daging'),(36,20,10000,0,'Kerang','Kerang ijo dari kali ciliwung','/image/kerang.jpg','Daging'),(37,20,50000,0,'Kol','Kol jepang.','/image/kol.jpg','Sayur'),(38,20,12000,0,'Kuas Lukis','Kuas ukuran 9. tersedia juga ukuran lainnya','/image/kuas_lukis.jpg','Alat Tulis'),(39,20,300000,0,'Kuda','Kuda','/image/kuda.jpg','Daging'),(40,20,40000,0,'Melon','Melon hijau dan melon kuning','/image/melon.jpg','Buah'),(41,20,30000,0,'Nangka','Nangka lonjong','/image/nangka.png','Buah'),(42,20,30000,0,'Pakaian Dalam','No available preview','/image/pakaian_dalam.jpg','Pakaian'),(43,20,30000,0,'Paprika','Paprika Merah kuning dan hijau.','/image/paprika.jpg','Sayur'),(44,20,3000,0,'Penghapus','Penghapus steadler untuk pensil 2B','/image/penghapus.jpg','Alat Tulis'),(45,20,3000,0,'Pensil','Pensil 2B untuk penghapus steadtler','/image/pensil.jpg','Alat Tulis'),(46,20,30000,0,'Pepaya','Pepaya the sailorman *jayus*','/image/pepaya.jpg','Buah'),(47,20,3000,0,'Pulpen','Pulpen BIC untuk semua kertas*','/image/pulpen.jpg','Alat Tulis'),(48,20,5000,0,'Rambutan','Sekilo rambutan dari pasar kiaracondong','/image/rambutan.jpg','Buah'),(49,20,5000,0,'Salak','Sekilo salak podoh','/image/salak.jpg','Buah'),(50,20,10000,0,'Sayur Lodeh','Sayur Lodeh untuk 5 orang','/image/sayur_lodeh.jpg','Sayur'),(51,20,5000,0,'Seledri','Seledri biasa','/image/seledri.jpg','Sayur'),(52,20,50000,0,'Semut','Sekilo semut untuk tapir peliharaan anda','/image/semut.jpg','Daging'),(53,20,5000,0,'Serutan','Serutan pensil','/image/serutan.jpg','Alat Tulis'),(54,20,9000,0,'Stabilo','Stabilo dengan merk stabilo','/image/stabilo.jpg','Alat Tulis'),(55,20,20000,0,'Terong','Terong ungu untuk disayur','/image/terong.jpg','Sayur'),(56,20,2000,0,'Timun','Timun emas, canda ding','/image/timun.jpg','Sayur'),(57,20,3000,0,'Tip-X','Tip-X cepat kering','/image/tip_x.jpg','Alat Tulis'),(58,20,30000,0,'Udang','udang kering dari cirebon','/image/udang.jpg','Daging'),(59,20,80000,0,'Vest','Rompi pesta, ngga anti peluru','/image/vest.jpg','Pakaian'),(60,20,8000,0,'Wortel','Lima potong wortel','/image/wortel.jpg','Sayur');
/*!40000 ALTER TABLE `catalog_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-29 20:05:37
