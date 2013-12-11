-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2013 at 03:29 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `datauser`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `IdBarang` int(11) DEFAULT NULL,
  `NamaBarang` varchar(20) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  `Kategori` varchar(20) DEFAULT NULL,
  `Jumlah` int(11) DEFAULT NULL,
  `Deskripsi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`IdBarang`, `NamaBarang`, `Harga`, `Kategori`, `Jumlah`, `Deskripsi`) VALUES
(1, 'DagingSapi', 80000, 'Daging', 4, NULL),
(2, 'IceCream', 10000, 'Snack', 8, NULL),
(3, 'ChickenNugget', 30000, 'Frozen Food', 8, NULL),
(4, 'BayamItali', 5000, 'Sayuran', 1, 'null'),
(5, 'BerasCarrefour', 11000, 'Beras', 0, 'ini beras carrefour'),
(6, 'DagingYak', 85000, 'Daging', 1, NULL),
(7, 'BerasTajMahal', 25000, 'Beras', 5, 'ini beras tajmahal'),
(8, 'BerasHCSR04', 22000, 'Beras', 1, NULL),
(9, 'BerasRaskin', 7000, 'Beras', 5, 'ini beras raskin'),
(10, 'DagingAyam', 122000, 'Daging', 1, NULL),
(11, 'DagingDomba', 92000, 'Daging', 5, NULL),
(12, 'PetaiCHINA', 2500, 'Sayuran', 1, NULL),
(13, 'SeledriHongkong', 4500, 'Sayuran', 12, NULL),
(14, 'TimunAustralia', 14500, 'Sayuran', 5, NULL),
(15, 'SOZZZZZZIS', 32000, 'Frozen Food', 24, NULL),
(16, 'FIESTANIGGA', 22000, 'Frozen Food', 9, NULL),
(17, 'BAKSOSOGOOD', 28000, 'Frozen Food', 40, NULL),
(18, 'BerasA-KING', 3000, 'Beras', 19, 'null'),
(19, 'DagingBebek', 15000, 'Daging', 8, NULL),
(20, 'SiomayMantap', 20500, 'Frozen Food', 10, NULL),
(21, 'Kangkung', 5300, 'Sayuran', 9, NULL),
(22, 'ToKaeNoi', 5400, 'Snack', 7, NULL),
(23, 'LeoKripikKentang', 3100, 'Snack', 8, NULL),
(24, 'MiGemez', 1200, 'Snack', 19, NULL),
(25, 'Bengbeng', 2050, 'Snack', 9, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `creditcard`
--

CREATE TABLE IF NOT EXISTS `creditcard` (
  `number` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `expiredate` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `creditcard`
--

INSERT INTO `creditcard` (`number`, `name`, `expiredate`) VALUES
('12341234', 'budi lagi', '2014-04-07');

-- --------------------------------------------------------

--
-- Table structure for table `transactionlog`
--

CREATE TABLE IF NOT EXISTS `transactionlog` (
  `NamaBarang` varchar(20) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  `Jumlah` int(11) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Kategori` varchar(20) DEFAULT NULL,
  `DetailPesanan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactionlog`
--

INSERT INTO `transactionlog` (`NamaBarang`, `Harga`, `Jumlah`, `Username`, `Kategori`, `DetailPesanan`) VALUES
('DagingSapi', 80000, 3, 'budie', 'Daging', NULL),
('DagingSapi', 80000, 2, 'budie', 'Daging', NULL),
('IceCream', 10000, 3, 'budie', 'Snack', NULL),
('IceCream', 10000, 4, 'budie', 'Snack', NULL),
('ChickenNugget', 30000, 1, 'budie', 'Frozen Food', NULL),
('ChickenNugget', 30000, 1, 'budie', 'Frozen Food', NULL),
('BayamItali', 5000, 7, 'budie', 'Sayuran', NULL),
('BerasCarrefour', 12000, 2, 'budie', 'Beras', NULL),
('DagingYak', 85000, 7, 'budie', 'Daging', NULL),
('DagingYak', 85000, 5, 'budie', 'Daging', NULL),
('DagingYak', 85000, 5, 'budie', 'Daging', NULL),
('BerasCarrefour', 12000, 3, 'budie', 'Beras', NULL),
('BerasTajMahal', 25000, 5, 'budie', 'Beras', NULL),
('DagingSapi', 80000, 2, 'budie', 'Daging', NULL),
('DagingAyam', 122000, 3, 'budie', 'Daging', NULL),
('BayamItali', 5000, 2, 'budie', 'Sayuran', NULL),
('PetaiCHINA', 2500, 3, 'budie', 'Sayuran', NULL),
('ChickenNugget', 30000, 2, 'budie', 'Frozen Food', NULL),
('BerasCarrefour', 12000, 1, 'Boci', 'Beras', NULL),
('IceCream', 10000, 2, 'budie', 'Snack', NULL),
('BerasCarrefour', 12000, 2, 'budie', 'Beras', NULL),
('ChickenNugget', 30000, 2, 'budie', 'Frozen Food', NULL),
('BayamItali', 5000, 2, 'yuhustore', 'Sayuran', NULL),
('DagingSapi', 80000, 1, 'budie', 'Daging', NULL),
('BayamItali', 5000, 1, 'budie', 'Sayuran', NULL),
('BerasCarrefour', 12000, 1, 'budie', 'Beras', NULL),
('BerasA-KING', 200, 3, 'budie', 'Beras', NULL),
('BayamItali', 5000, 4, 'budie', 'Sayuran', NULL),
('IceCream', 10000, 1, 'budie', 'Snack', NULL),
('DagingSapi', 80000, 1, 'budie', 'Daging', NULL),
('DagingSapi', 80000, 20, 'budie', 'Daging', NULL),
('DagingYak', 85000, 1, 'aditya2', 'Daging', NULL),
('DagingSapi', 80000, 1, 'aditya2', 'Daging', NULL),
('BayamItali', 5000, 1, 'budie', 'Sayuran', NULL),
('BerasHCSR04', 22000, 1, 'Budie', 'Beras', NULL),
('BerasRaskin', 20000, 1, 'Budie', 'Beras', NULL),
('Kangkung', 5300, 1, 'Budie', 'Sayuran', NULL),
('Kangkung', 5300, 1, 'Budie', 'Sayuran', NULL),
('TimunAustralia', 14500, 1, 'Budie', 'Sayuran', NULL),
('LeoKripikKentang', 3100, 1, 'Budie', 'Snack', NULL),
('IceCream', 10000, 1, 'Budie', 'Snack', NULL),
('Bengbeng', 2050, 2, 'Budie', 'Snack', NULL),
('SiomayMantap', 20500, 1, 'Budie', 'Frozen Food', NULL),
('BAKSOSOGOOD', 28000, 1, 'Budie', 'Frozen Food', NULL),
('DagingHiu', 50000, 1, 'bebek', 'Daging', ''),
('DagingDomba', 92000, 1, 'bebek', 'Daging', ''),
('LeoKripikKentang', 3100, 1, 'bebek', 'Snack', ''),
('BerasHCSR04', 22000, 1, 'bebek', 'Beras', ''),
('BerasCarrefour', 11000, 20, 'bebek', 'Beras', ''),
('BerasCarrefour', 11000, 23, 'bebek', 'Beras', ''),
('BerasCarrefour', 11000, 1, 'bebek', 'Beras', ''),
('BerasCarrefour', 11000, 20, 'bebek', 'Beras', ''),
('BerasCarrefour', 11000, 30, 'bebek', 'Beras', ''),
('BerasTajMahal', 25000, 50, 'bebek', 'Beras', ''),
('BerasRaskin', 7000, 10, 'bebek', 'Beras', ''),
('BerasHCSR04', 22000, 10, 'bebek', 'Beras', ''),
('BerasHCSR04', 22000, 50, 'bebek', 'Beras', ''),
('BerasHCSR04', 22000, 50, 'bebek', 'Beras', ''),
('BerasHCSR04', 22000, 5, 'bebek', 'Beras', ''),
('BerasCarrefour', 11000, 4, 'bebek', 'Beras', ''),
('IceCream', 10000, 4, 'budie', 'Snack', ''),
('DagingSapi', 80000, 4, 'budie', 'Daging', ''),
('DagingDomba', 92000, 2, 'budie', 'Daging', ''),
('DagingYak', 85000, 1, 'budie', 'Daging', ''),
('DagingYak', 85000, 5, 'budie', 'Daging', ''),
('DagingSapi', 80000, 1, 'budie', 'Daging', ''),
('ChickenNugget', 30000, 1, 'budie', 'Frozen Food', ''),
('SOZZZZZZIS', 32000, 1, 'budie', 'Frozen Food', ''),
('ChickenNugget', 30000, 1, 'budie', 'Frozen Food', ''),
('BAKSOSOGOOD', 28000, 2, 'budie', 'Frozen Food', ''),
('FIESTANIGGA', 22000, 6, 'budie', 'Frozen Food', ''),
('BayamItali', 5000, 1, 'budie', 'Sayuran', ''),
('PetaiCHINA', 2500, 1, 'budie', 'Sayuran', ''),
('DagingBebek', 15000, 1, 'budie', 'Daging', ''),
('ToKaeNoi', 5400, 1, 'budie', 'Snack', ''),
('IceCream', 10000, 1, 'budie', 'Snack', ''),
('ChickenNugget', 30000, 1, 'budie', 'Frozen Food', ''),
('DagingSapi', 80000, 1, 'budie', 'Daging', ''),
('DagingYak', 85000, 3, 'budie', 'Daging', ''),
('DagingAyam', 122000, 1, 'budie', 'Daging', ''),
('DagingBebek', 15000, 1, 'budie', 'Daging', ''),
('BayamItali', 5000, 1, 'budie', 'Sayuran', ''),
('PetaiCHINA', 2500, 3, 'budie', 'Sayuran', ''),
('IceCream', 10000, 1, 'budie', 'Snack', ''),
('DagingYak', 85000, 1, 'budie', 'Daging', ''),
('ToKaeNoi', 5400, 1, 'budie', 'Snack', ''),
('BerasCarrefour', 11000, 1, 'budie', 'Beras', ''),
('BerasHCSR04', 22000, 1, 'budie', 'Beras', ''),
('BerasCarrefour', 11000, 5, 'budie', 'Beras', ''),
('ChickenNugget', 30000, 1, 'budie', 'Frozen Food', ''),
('MiGemez', 1200, 4, 'budie', 'Snack', ''),
('Bengbeng', 2050, 1, 'yuhustore', 'Snack', ''),
('LeoKripikKentang', 3100, 1, 'yuhustore', 'Snack', ''),
('Kangkung', 5300, 1, 'yuhustore', 'Sayuran', ''),
('BayamItali', 5000, 4, 'yuhustore', 'Sayuran', ''),
('ChickenNugget', 30000, 1, 'yuhustore', 'Frozen Food', ''),
('PetaiCHINA', 2500, 1, 'yuhustore', 'Sayuran', ''),
('ToKaeNoi', 5400, 1, 'yuhustore', 'Snack', ''),
('MiGemez', 1200, 1, 'yuhustore', 'Snack', '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
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

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `email`, `namalengkap`, `nohp`, `provinsi`, `kotakabupaten`, `alamat`, `kodepos`, `nocredit`) VALUES
('aditya', '12345678', 'adt@adit.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', '12341234'),
('aditya2', '12345678', 'aditya@yahoo.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', '12341234'),
('aditya3', '12345678', 'aditya3@yahoo.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', '12341234'),
('admin', 'admin123', 'admin@admin.com', 'admin admin', '0000', '-', '-', '-', '0000', NULL),
('bebek', '12345678', 'bebek@bebek.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('budibro', '12341234', 'budi@budi.com', 'budi bro', '0000', 'prov', '-', '-', '0000', NULL),
('budie', '12341234', 'budie@gmail.com', 'budi budi', '0', '-', '-', '-', '0', '12341234'),
('budih', '12345678', 'budie@budi.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', '12341234'),
('coba2', '12341234', 'coba2@coba2.com', 'coba dua', '0', '-', '-', '-', '0', '12341234'),
('coba3', '12345678', 'coba3@coba.com', 'coba 3', '0', '-', '-', '-', '0', '12341234'),
('cobabaru', '123123123', 'coba@baru.com', 'coba baru', '0', '-', '-', '-', '0', '12341234'),
('cobabro', '12345678', 'coba@bro.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('cobadulu', '12345678', 'coba@dulu.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', '12341234'),
('cobalagi', '12345678', 'cobalagi@lagi.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('heybro', '12345678', 'hey@bro.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('kucing', '12345678', 'kucing@kucing.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', '12341234'),
('lalaye', '12345678', 'lalaye@lalaye.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('lalayeye', '12345678', 'lala@yeye.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('popop', '12345678', 'pop@pop.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('riandy', '12345678', 'riandy@riandy.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', '123123123'),
('testtest', '12345678', 'test@test.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('username1', '12345678', 'username@username.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('username2', '12345678', 'usernam2@com.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('username4', '12345678', 'username4@com.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('yanti', '12345678', 'yanti@yanti.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', '12341234'),
('yoibro', '12345678', 'yoi@bro.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4001', NULL),
('yuhustore', '12345678', 'yuhu@store.com', 'budi doang', '2134', 'Jawa Barat', 'Bandung', 'Bandung', '4000', '12341234');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
