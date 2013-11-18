-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2013 at 09:21 AM
-- Server version: 5.6.11
-- PHP Version: 5.5.3

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `progin_13511059`
--
CREATE DATABASE IF NOT EXISTS `progin_13511059` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `progin_13511059`;

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` int(10) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(30) NOT NULL,
  `gambar_barang` varchar(100) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `kategori_barang` int(11) NOT NULL,
  `n_beli` int(100) NOT NULL,
  `keterangan` varchar(500) NOT NULL,
  `stok` int(10) NOT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
CREATE TABLE IF NOT EXISTS `creditcard` (
  `card_id` int(11) NOT NULL,
  `card_nameon` varchar(100) NOT NULL,
  `card_expdate` datetime NOT NULL,
  `card_owner` int(10) NOT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(30) NOT NULL,
  `handphone` int(15) NOT NULL,
  `address` varchar(40) NOT NULL,
  `province` text NOT NULL,
  `state` text NOT NULL,
  `postcode` int(10) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Tabel Anggota Website' AUTO_INCREMENT=7 ;
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
