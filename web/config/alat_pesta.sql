-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2013 at 10:12 PM
-- Server version: 5.6.11
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `alat_pesta`
--
CREATE DATABASE IF NOT EXISTS `alat_pesta` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `alat_pesta`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `no_customer` int(10) NOT NULL AUTO_INCREMENT,
  `nama` char(35) NOT NULL,
  `kota` char(35) DEFAULT NULL,
  `kodepos` int(20) DEFAULT NULL,
  `email` char(35) NOT NULL,
  `hp` int(12) DEFAULT NULL,
  `password` varchar(15) NOT NULL,
  `username` varchar(12) NOT NULL,
  `provinsi` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`no_customer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`no_customer`, `nama`, `kota`, `kodepos`, `email`, `hp`, `password`, `username`, `provinsi`, `alamat`) VALUES
(1, 'Rizky Hendrawan', 'Semarang', 553224, 'rizky@gmail.com', 2147483647, '', '', '', ''),
(2, 'Rina Purlinawati', 'Semarang', 55344, 'rina@gmail.com', 2147483647, '', '', '', ''),
(3, 'Indah', 'Semarang', 55355, 'indah@yahoo.com', 2147483647, '', '', '', ''),
(4, 'Andrian Octavianus', 'Kudus', 59319, 'andrian.octo@gmail.com', 0, '31023102', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `kembali`
--

CREATE TABLE IF NOT EXISTS `kembali` (
  `no_kembali` int(10) NOT NULL AUTO_INCREMENT,
  `no_sewa` int(10) DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  PRIMARY KEY (`no_kembali`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `kembali`
--

INSERT INTO `kembali` (`no_kembali`, `no_sewa`, `tgl_kembali`) VALUES
(1, 2, '2013-05-30'),
(2, 3, '2013-07-27');

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE IF NOT EXISTS `keranjang` (
  `id_customer` int(10) NOT NULL,
  `id_alat` int(10) NOT NULL,
  `Id_Keranjang` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id_Keranjang`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `keranjang`
--

INSERT INTO `keranjang` (`id_customer`, `id_alat`, `Id_Keranjang`) VALUES
(0, 4, 2),
(4, 3, 3),
(4, 2, 4),
(4, 2, 5),
(4, 2, 6);

-- --------------------------------------------------------

--
-- Table structure for table `peralatan`
--

CREATE TABLE IF NOT EXISTS `peralatan` (
  `no_alat` int(10) NOT NULL AUTO_INCREMENT,
  `nama` char(25) DEFAULT NULL,
  `kategori` char(20) DEFAULT NULL,
  `jumlah` int(10) DEFAULT NULL,
  `harga` int(20) DEFAULT NULL,
  `deskripsi` tinytext,
  `foto` char(50) DEFAULT NULL,
  `status` char(20) DEFAULT NULL,
  PRIMARY KEY (`no_alat`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `peralatan`
--

INSERT INTO `peralatan` (`no_alat`, `nama`, `kategori`, `jumlah`, `harga`, `deskripsi`, `foto`, `status`) VALUES
(1, 'Tenda Pelangi', 'Sweater', 2000, 400000, 'tenda canopy / lengkung. Tenda ini berbentuk lengkung dibagian atasnya. Biasanya dipakai untuk acara-acara disekolah, ulang tahun, seminar, acara rumah, dan kantor yang dilaksanakan di luar ruangan (outdoor) ataupun lapangan terbuka. ', 'images/Sweater1.jpg', 'Tersedia'),
(2, 'Dekorasi Taman', 'TShirt', 2000, 350000, 'tenda canopy / lengkung. Tenda ini berbentuk lengkung dibagian atasnya. Biasanya dipakai untuk acara-acara disekolah, ulang tahun, seminar, acara rumah, dan kantor yang dilaksanakan di luar ruangan (outdoor) ataupun lapangan terbuka. ', 'images/TShirt1.jpg', 'Tersedia'),
(3, 'Meja Dan Kursi', 'Misc', 2000, 30000, 'tenda canopy / lengkung. Tenda ini berbentuk lengkung dibagian atasnya. Biasanya dipakai untuk acara-acara disekolah, ulang tahun, seminar, acara rumah, dan kantor yang dilaksanakan di luar ruangan (outdoor) ataupun lapangan terbuka.', 'images/Misc1.jpg', 'Tersedia'),
(4, 'jaket hood1', 'Jaket', 2000, 200000, 'jaket yang terbuat dari kuwlit kelapa', 'images/Jaket1.jpg', 'tersedia'),
(5, 'pokemon1', 'Pokemon', 2000, 300000, 'pokemon langka', 'images/Pokemon1.jpg', 'tersedia'),
(6, 'sweater2', 'Sweater', 2000, 230001, 'sweater 1', 'images/Sweater2.jpg', 'tersedia'),
(7, 'TShirt2', 'TShirt', 2000, 200000, 'Tshirt 2', 'images/TShirt2.jpg', 'tersedia'),
(8, 'Misc2', 'Misc', 2000, 203300, 'Misc2', 'images/Misc2.jpg', 'tersedia'),
(9, 'jaket2', 'Jaket', 2000, 200000, 'jaket 2', 'images/Jaket2.jpg', 'tersedia'),
(10, 'Pokemon2', 'Pokemon', 2000, 200000, 'Pokemon 2', 'images/Pokemon2.jpg', 'tersedia'),
(11, 'Sweater3', 'Sweater', 2000, 20000, 'Sweater 3', 'images/Sweater3.jpg', 'tersedia'),
(12, 'TShirt3', 'TShirt', 2000, 20000, 'TShirt 3', 'images/TShirt3.jpg', 'tersedia'),
(13, 'Misc3', 'Misc', 2000, 30000, 'Misc 3', 'images/Misc3.jpg', 'tersedia'),
(14, 'jaket 3', 'Jaket', 2000, 300000, 'jaket 3', 'images/jaket3.jpg', 'tersedia'),
(15, 'Pokemon 3', 'Pokemon', 2500, 200000, 'Pokemon 3', 'images/Pokemon3.jpg', 'tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `terbayar`
--

CREATE TABLE IF NOT EXISTS `terbayar` (
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `terbayar`
--

INSERT INTO `terbayar` (`id_barang`, `jumlah`) VALUES
(1, 3),
(2, 4),
(3, 5),
(4, 5),
(5, 5),
(6, 4),
(7, 5),
(8, 9),
(9, 12),
(10, 4),
(11, 6),
(12, 4),
(13, 7),
(14, 6),
(15, 9);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
