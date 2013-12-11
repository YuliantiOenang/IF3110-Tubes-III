-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 29, 2013 at 03:15 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ruserba`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(256) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `harga_barang` bigint(20) NOT NULL,
  `gambar` varchar(256) NOT NULL,
  `tersedia` int(11) NOT NULL,
  `dibeli` int(11) NOT NULL,
  PRIMARY KEY (`id_barang`),
  KEY `id_kategori` (`id_kategori`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `id_kategori`, `harga_barang`, `gambar`, `tersedia`, `dibeli`) VALUES
(1, 'Giordano', 1, 300000, 'giordano.jpg', 10, 1),
(2, 'Polo', 1, 150000, 'polo.jpg', 10, 1),
(3, 'Dagadu', 1, 50000, 'dagadu.jpg', 30, 10),
(4, 'Joger', 1, 40000, 'joger.jpg', 5, 1),
(5, 'Samsung', 2, 1500000, 'samsung.jpg', 13, 10),
(6, 'Iphone', 2, 5000000, 'iphone.jpg', 5, 0),
(7, 'Nokia', 2, 2000000, 'nokia.jpg', 6, 3),
(8, 'Mito', 2, 200000, 'mito.jpg', 7, 3),
(9, 'Cubitus', 3, 150000, 'cubitus.jpg', 6, 3),
(10, 'Levis', 3, 400000, 'levis.jpg', 5, 1),
(11, 'Lee', 3, 300000, 'lee.jpg', 4, 2),
(12, 'Ayam Bawang', 4, 2000, 'ayambawang.png', 50, 10),
(13, 'Rendang', 4, 2500, 'rendang.png', 10, 50),
(14, 'Kari Ayam', 4, 2000, 'kariayam.jpg', 40, 15),
(15, 'Cabe Ijo', 4, 2000, 'cabeijo.jpg', 40, 20),
(16, 'Soto', 4, 2000, 'soto.jpg', 25, 10),
(17, 'Aqua', 5, 3000, 'aqua.jpg', 10, 20),
(18, 'Mizone', 5, 5000, 'mizone.jpg', 20, 1),
(19, 'Kiranti', 5, 6000, 'kiranti.jpg', 1, 1),
(20, 'Mix Max', 5, 20000, 'mixmax.jpg', 1, 60),
(21, 'Vit', 5, 1000, 'vit.jpg', 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `kartu_kredit`
--

CREATE TABLE IF NOT EXISTS `kartu_kredit` (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `no_kartu` varchar(16) NOT NULL,
  `nama` varchar(256) NOT NULL,
  `kadaluarsa` date NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `nama_kategori` varchar(256) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Baju'),
(2, 'Gadget'),
(3, 'Celana'),
(4, 'Indomie'),
(5, 'Minuman');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(256) COLLATE utf8_bin NOT NULL,
  `token` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `last_login` date DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `token`, `last_login`) VALUES
('admin', 'asdfasdf', '9kWVGnZp6rxlYeUbrYYT', '2013-10-29');

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE IF NOT EXISTS `user_profile` (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nama` varchar(256) NOT NULL,
  `email` varchar(100) NOT NULL,
  `alamat` varchar(256) DEFAULT NULL,
  `kota` varchar(256) DEFAULT NULL,
  `kode_pos` varchar(5) DEFAULT NULL,
  `provinsi` varchar(256) DEFAULT NULL,
  `nomor_ponsel` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`username`, `nama`, `email`, `alamat`, `kota`, `kode_pos`, `provinsi`, `nomor_ponsel`) VALUES
('admin', 'admin ganteng', 'admin@ruserba.com', 'alamat admin', 'kota admin', '13452', 'prov admin', '0987654321');

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
