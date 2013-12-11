-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: 10.0.22.169
-- Generation Time: Dec 10, 2013 at 06:27 PM
-- Server version: 5.5.29-0ubuntu0.12.04.2
-- PHP Version: 5.3.10-1ubuntu3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `df8047b27ce874500869c152dc74bcee8`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `gambar` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `tersedia` int(11) NOT NULL,
  `dibeli` int(11) NOT NULL,
  PRIMARY KEY (`id_barang`),
  KEY `id_kategori` (`id_kategori`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=77 ;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `id_kategori`, `harga_barang`, `gambar`, `tersedia`, `dibeli`) VALUES
(1, 'Beras Cap Kembang Bandung', 1, 8000, '1.jpg', 9, 1),
(2, 'Beras Guci Mas', 1, 9000, '2.jpg', 7, 3),
(3, 'Beras BMW', 1, 10000, '3.jpg', 10, 0),
(4, 'Beras Pinguin', 1, 11000, '4.jpg', 8, 2),
(5, 'Beras Capit', 1, 12000, '5.jpg', 9, 1),
(6, 'Beras Tiga Jambu', 1, 13000, '6.jpg', 9, 1),
(7, 'Beras Panda', 1, 14000, '7.jpg', 10, 0),
(8, 'Beras VIP', 1, 8000, '8.jpg', 10, 0),
(9, 'Beras Walet', 1, 9000, '9.jpg', 10, 0),
(10, 'Beras Kingrice Merah Solo', 1, 10000, '10.jpg', 10, 0),
(11, 'Beras Kingrice Hijau Solo', 1, 11000, '11.jpg', 10, 0),
(12, 'Beras Goldrice Merah', 1, 12000, '12.jpg', 10, 0),
(13, 'Beras Goldrice Hijau', 1, 13000, '13.jpg', 10, 0),
(14, 'Beras Cap Louhan', 1, 14000, '14.jpg', 10, 0),
(15, 'Beras Myrice', 1, 8000, '15.jpg', 10, 0),
(16, 'Sayur Bayam', 2, 6000, '16.jpg', 8, 2),
(17, 'Sawi', 2, 6000, '17.jpg', 10, 0),
(18, 'Kangkung', 2, 7000, '18.jpg', 10, 0),
(19, 'Timun', 2, 8000, '19.jpg', 10, 0),
(20, 'Seledri', 2, 4000, '20.jpg', 10, 0),
(21, 'Daun Singkong', 2, 5000, '21.jpg', 10, 0),
(22, 'Peria', 2, 6000, '22.jpg', 10, 0),
(23, 'Brokoli', 2, 7000, '23.jpg', 10, 0),
(24, 'Bok Choy', 2, 8000, '24.jpg', 10, 0),
(25, 'Buncis', 2, 4000, '25.jpg', 10, 0),
(26, 'Wortel', 2, 5000, '26.jpg', 10, 0),
(27, 'Kol', 2, 6000, '27.jpg', 10, 0),
(28, 'Petai', 2, 7000, '28.jpg', 10, 0),
(29, 'Asparagus', 2, 8000, '29.jpg', 10, 0),
(30, 'Kacang Panjang', 2, 4000, '30.jpg', 9, 1),
(31, 'Kunyit', 3, 1000, '31.jpg', 10, 0),
(32, 'Lada Hitam', 3, 1000, '32.jpg', 0, 10),
(33, 'Kayu Manis', 3, 2000, '33.jpg', 10, 0),
(34, 'Jahe', 3, 3000, '34.jpg', 10, 0),
(35, 'Bawang Merah', 3, 4000, '35.jpg', 10, 0),
(36, 'Bawang Putih', 3, 5000, '36.jpg', 10, 0),
(37, 'Daun Bawang', 3, 1000, '37.jpg', 10, 0),
(38, 'Daun Pandan', 3, 2000, '38.jpg', 10, 0),
(39, 'Daun Salam', 3, 3000, '39.jpg', 10, 0),
(40, 'Jintan', 3, 4000, '40.jpg', 10, 0),
(41, 'Kemiri', 3, 5000, '41.jpg', 10, 0),
(42, 'Ketumbar', 3, 1000, '42.jpg', 10, 0),
(43, 'Lengkuas', 3, 2000, '43.jpg', 10, 0),
(44, 'Serai', 3, 3000, '44.jpg', 10, 0),
(45, 'Pala', 3, 4000, '45.jpg', 10, 0),
(46, 'Wijen', 3, 5000, '46.jpg', 10, 0),
(47, 'C&H Sugar', 4, 10000, '47.jpg', 10, 0),
(48, 'Tate Lyle Sugar', 4, 11000, '48.jpg', 7, 3),
(49, 'Gula Piramid Kristal', 4, 12000, '49.jpg', 9, 1),
(50, 'Gula Prai', 4, 13000, '50.jpg', 10, 0),
(51, 'Raja Gula', 4, 14000, '51.jpg', 10, 0),
(52, 'Gula Kwala Madu', 4, 15000, '52.jpg', 10, 0),
(53, 'Gula PSM', 4, 10000, '53.jpg', 10, 0),
(54, 'Gula Legiku', 4, 11000, '54.jpg', 10, 0),
(55, 'Gua Ragula', 4, 12000, '55.jpg', 10, 0),
(56, 'Gulaku', 4, 13000, '56.jpg', 10, 0),
(57, 'Gula Indosugar', 4, 14000, '57.jpg', 10, 0),
(58, 'Gula Indolampung', 4, 15000, '58.jpg', 10, 0),
(59, 'Pioneer Sugar', 4, 10000, '59.jpg', 10, 0),
(60, 'C&H Granulated Sugar', 4, 11000, '60.jpg', 10, 0),
(61, 'Silver Spoon Sugar', 4, 12000, '61.jpg', 10, 0),
(62, 'Sapi Lokal', 5, 96000, '62.jpg', 10, 0),
(63, 'Sapi Australia', 5, 100000, '63.jpg', 0, 10),
(64, 'Sapi USA', 5, 110000, '64.jpg', 10, 0),
(65, 'Sapi New Zealand', 5, 105000, '65.jpg', 9, 1),
(66, 'Sapi Lokal High Grade', 5, 120000, '66.jpg', 10, 0),
(67, 'Rusa Lokal', 5, 140000, '67.jpg', 10, 0),
(68, 'Rusa Impor', 5, 160000, '68.jpg', 10, 0),
(69, 'Ayam Kampung', 5, 78000, '69.jpg', 10, 0),
(70, 'Ayam Potong', 5, 70000, '70.jpg', 10, 0),
(71, 'Bebek', 5, 85000, '71.jpg', 10, 0),
(72, 'Kambing ', 5, 14000, '72.jpg', 10, 90000),
(73, 'Kambing Giling', 5, 15000, '73.jpg', 93000, 0),
(74, 'Kambing Potong', 5, 10000, '74.jpg', 92000, 0),
(75, 'Kerbau', 5, 95000, '75.jpg', 10, 0),
(76, 'Kelinci', 5, 50000, '76.jpg', 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `kartu_kredit`
--

CREATE TABLE IF NOT EXISTS `kartu_kredit` (
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `no_kartu` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `nama` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `kadaluarsa` date NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `kartu_kredit`
--

INSERT INTO `kartu_kredit` (`username`, `no_kartu`, `nama`, `kadaluarsa`) VALUES
('admin', '1732979879817329', 'admin ga ganteng', '2013-10-31');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `id_kategori` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kategori` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Beras'),
(2, 'Sayuran'),
(3, 'Bumbu'),
(4, 'Gula'),
(5, 'Daging');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', 'asdfasdf'),
('ditra77', 'milanisti77');

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE IF NOT EXISTS `user_profile` (
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `nama` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `alamat` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `kota` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `provinsi` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kode_pos` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nomor_ponsel` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`username`, `nama`, `email`, `alamat`, `kota`, `provinsi`, `kode_pos`, `nomor_ponsel`) VALUES
('admin', 'admin ganteng', 'admin@ruserba.com', 'alamat admin', 'kota admin', 'prov admin', '13452', '0987654321'),
('ditra77', 'Aidil Syaputra', 'dil_syaputra@yahoo.com', 'Jln. Cisitu Lama', 'Bandung', 'Jawa Barat', '41241', '083829812292');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kartu_kredit`
--
ALTER TABLE `kartu_kredit`
  ADD CONSTRAINT `kartu_kredit_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD CONSTRAINT `user_profile_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
