-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2013 at 09:27 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tubes1`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_kategori` int(11) NOT NULL,
  `gambar` varchar(100) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `keterangan` text NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `id_kategori`, `gambar`, `nama_barang`, `harga_barang`, `keterangan`, `jumlah_barang`) VALUES
(3, 1, 'sembako/beras.jpg', 'Beras', 8500, 'Ini beras per 1 kg', 999949),
(4, 1, 'sembako/gulapasir.jpg', 'Gula Pasir', 12000, 'Ini gula pasir per 1 kg', 0),
(5, 1, 'sembako/minyakgoreng.jpg', 'Minyak Goreng', 11000, 'Minyak Goreng per 1 liter', 999988),
(6, 1, 'sembako/telurayam.jpg', 'Telur Ayam', 15000, 'Telur Ayam per 1 kg', 999877),
(7, 2, 'handphone/blackberrycdmahitam.jpg', 'Blackberry CDMA 9930 Hitam', 1500000, '', 99),
(8, 2, 'handphone/acerliquide2.jpg', 'Acer Liquid E2', 2500000, '', 125),
(9, 2, 'handphone/samsunggalaxys4.jpg', 'Samsung Galaxy S4', 7000000, '', 90),
(10, 2, 'handphone/blackberryq5.jpg', 'BlackBerry Q5', 4500000, '', 190),
(11, 3, 'elektronik/brocofitting.jpg', 'BROCO Fitting', 10000, '', 340),
(12, 3, 'elektronik/brocosocketantennatv.jpg', 'BROCO Socket Antenna TV', 50000, '', 150),
(13, 3, 'elektronik/homeelectricsaver.jpg', 'HOME Electric Saver', 285000, 'Alat hemat listrik daya 450-1300 W', 175),
(14, 3, 'elektronik/klik-itstopkontak.jpg', 'KLIK-IT Stop Kontak ', 100000, 'Injeksi 1 lubang seri KL5N2', 231),
(15, 4, 'komputer/opticaldriveasusdvdrwexternalslim.jpg', 'Optical Drive Asus DVDRW External Slim SDRW-08D2SU-LITE', 350000, '', 85),
(16, 4, 'komputer/memoryddr3corsair.jpg', 'Memory DDR3 Corsair CMD8GX3M2A1600C9 (2x4Gb) DDR3 ', 1600000, '', 110),
(17, 4, 'komputer/lcdmonitoracer24inch.jpg', 'LCD Monitor Acer 24 Inch S243HL Size 24 inch', 3000000, '', 95),
(18, 4, 'komputer/harddiskexternaladata.jpg', 'Harddisk External A-Data HD-710 1 TB Ext.2.5 Inch', 950000, '', 145),
(19, 5, 'perabot/panasonicdishdryer.jpg', 'PANASONIC Dish Dryer [FD-S03S1-W]', 850000, '', 84),
(20, 5, 'perabot/domostandwaterdispenser.jpg', 'DOMO Stand Water Dispenser [DI 2020]', 1400000, '', 78),
(21, 5, 'perabot/panasonicmesincucitwintub.jpg', 'PANASONIC Mesin Cuci Twin Tub [NA-W75BC1A]', 2000000, 'Warna Biru', 65),
(22, 5, 'perabot/philipssetrika.jpg', 'PHILIPS Setrika [HD1172]', 200000, '', 55),
(23, 6, 'alat_tulis/fabercastell.jpg', 'FABER-CASTELL 119043', 13500, '3 buah', 500),
(24, 6, 'alat_tulis/stabiloboss.jpg', 'STABILO Boss Set 2 [B-104]', 19000, '2 Warna, kuning dan orange', 259),
(25, 6, 'alat_tulis/crosscalaischrome.jpg', 'CROSS Calais Chrome Blue Lacquer [AT0112-3]', 210000, '', 167),
(26, 6, 'alat_tulis/moleskineclassicnotebook.jpg', 'MOLESKINE Classic Notebook Squared Soft Cover', 200000, 'Buku tulis ini ada 192 Halaman', 231);

-- --------------------------------------------------------

--
-- Table structure for table `barang_card`
--

CREATE TABLE IF NOT EXISTS `barang_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_barang` int(11) NOT NULL,
  `id_card` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `tgl_pembelian` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deskripsi_tambahan` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `barang_card`
--

INSERT INTO `barang_card` (`id`, `id_barang`, `id_card`, `status`, `jumlah_barang`, `id_user`, `tgl_pembelian`, `deskripsi_tambahan`) VALUES
(9, 6, 1, 0, 123, 4, '2013-10-27 01:38:40', 'test'),
(10, 3, 4, 1, 1, 7, '2013-10-28 12:05:35', 'test'),
(12, 4, 5, 1, 1, 7, '2013-10-28 16:36:08', 'Gula manis\r\n'),
(19, 3, 4, 1, 1, 7, '2013-10-29 12:58:02', ''),
(20, 7, 4, 1, 1, 7, '2013-10-29 14:25:53', '');

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE IF NOT EXISTS `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `card_number` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `expired_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`id`, `id_user`, `card_number`, `name`, `expired_date`) VALUES
(1, 4, '082031465812', 'ganteng', '2013-10-30'),
(2, 4, '128391012345', 'ahay', '2014-09-12'),
(3, 9, '213168745676', 'iseng', '2014-12-09'),
(4, 7, '1223456789012', 'Iskandar Setiadi', '2012-01-31'),
(5, 7, '2345678901234', 'Iskandar Setiadi', '2013-12-31');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id`, `name`) VALUES
(1, 'Sembako'),
(2, 'Handphone'),
(3, 'Peralatan Listrik'),
(4, 'Aksesoris Komputer'),
(5, 'Perabotan Rumah'),
(6, 'Alat Tulis');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `HP` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `provinsi` varchar(100) NOT NULL,
  `kodepos` int(6) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `kota` varchar(100) NOT NULL,
  `isCreditCard` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `nama_lengkap`, `HP`, `alamat`, `provinsi`, `kodepos`, `email`, `password`, `kota`, `isCreditCard`) VALUES
(4, 'habibie', 'Habibie Faried', '08561435232', 'Jl. Pelesirann', 'Jawa Barat', 40114, 'habibiefaried@gmail.com', 'habibie', 'Bandung', 1),
(7, 'iskandar', 'Iskandar S.', '085697681829', 'Jl. Tubis', 'Jawa Barat', 40132, 'iseng@test.com', '12345678', 'Bandung', 1),
(8, 'haha', 'haha', '0856', 'JL. haha', 'haha', 18124, 'haha@haha.com', 'haha', 'haha', 0),
(9, 'iseng', 'iseng', '08961', 'Jl. iseng', 'iseng', 15123, 'iseng@iseng.com', 'iseng', 'iseng', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
