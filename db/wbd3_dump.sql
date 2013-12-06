-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2013 at 04:17 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `wbd3`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `kategori` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `deskripsi` text COLLATE latin1_general_ci NOT NULL,
  `jumlah_beli` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_barang`),
  UNIQUE KEY `nama_barang` (`nama_barang`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga`, `stok`, `kategori`, `deskripsi`, `jumlah_beli`) VALUES
(1, 'sate padang', 100, 7, 'makanan', 'lololo', 4),
(2, 'soto', 6000, 93, 'makanan', '', 107),
(6, 'ikan teri', 1000, 10, 'makanan', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE IF NOT EXISTS `token` (
  `token_id` varchar(80) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `waktu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`token_id`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`token_id`, `username`, `waktu`) VALUES
('12345', 'admin', '2013-12-06 11:02:49'),
('abcde', 'abcd', '2013-12-06 11:51:10');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `password` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `email` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `nama_lengkap` varchar(40) COLLATE latin1_general_ci NOT NULL,
  `alamat` varchar(40) COLLATE latin1_general_ci NOT NULL,
  `provinsi` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `kota` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `kodepos` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `telepon` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `jumlah_transaksi` int(11) NOT NULL DEFAULT '0',
  `role` varchar(20) COLLATE latin1_general_ci NOT NULL DEFAULT 'user',
  `card_name` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `card_number` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `card_date` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `email`, `nama_lengkap`, `alamat`, `provinsi`, `kota`, `kodepos`, `telepon`, `jumlah_transaksi`, `role`, `card_name`, `card_number`, `card_date`) VALUES
('abcd', 'abcd', 'abcd@email.com', '', '', '', '', '', '', 2, 'user', NULL, NULL, NULL),
('admin', 'admin', 'admin@a.com', '', '', '', '', '', '', 1, 'admin', NULL, NULL, NULL),
('user', 'user', 'user@a.com', '', '', '', '', '', '', 0, 'user', NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `token_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
