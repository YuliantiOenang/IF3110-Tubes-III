-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 11, 2013 at 12:08 
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ruserba`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE IF NOT EXISTS `anggota` (
  `fullname` varchar(50) NOT NULL,
  `userid` varchar(50) NOT NULL,
  `nohp` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `provinsi` varchar(20) NOT NULL,
  `kabupaten` varchar(30) NOT NULL,
  `kodepos` varchar(10) NOT NULL,
  `password` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`fullname`, `userid`, `nohp`, `email`, `alamat`, `provinsi`, `kabupaten`, `kodepos`, `password`) VALUES
('Diona', 'dio', '9090', 'kkk', 'kjkj ', 'jkkk', 'kkkk', 'kkk', 'kk'),
('Dinah Kamilah', 'dinah', '090909', 'kk', 'kkk ', 'kk', 'kkk', 'kk', 'kk'),
('risma arby', 'risma', '909090', 'kharisma.arby@gmail.com', '0909', '0900', '9090', '9090', 'kharismaarby'),
('Kharisma Arby', 'arbyy', 'k', 'kharisma.arby@gmail.com', 'k', 'k', 'k', 'k', 'kharisma'),
('Isabella Julia Putri', 'isabel', '085667219328', 'isbel.kirei@yahoo.co.id', 'ganesa', 'jabar', 'bandung', '89891', 'isabellakirei'),
('Sofiala Juba', 'sofia', '087563842', 'sofi.o@gmail.co.id', 'jakarta', 'jakarta', 'jakarta', '89891', 'sofisofi'),
('Nurul Ewanis', 'ewanis', '078738234', 'nurul@yho.com', 'plesiran', 'Jawa Barat', 'bandung', '1234', 'kodokngorek'),
('Khelwa Khairani', ' wawa', '0821212121', 'helwa@yahoo.com', 'kakakaka', 'jateng', 'semarang', '89891', 'helwacantik'),
('Eki Setiawan', ' eqiset', '00921219', 'eki@yy.co.id', 'jdaksdjkasd', 'jska', 'jkajs', 'kjsdks', 'ekisetiawan'),
('Kharisma Arby', ' kharisma', '23123', 'kharisma.dinus10@yahoo.com', 'sadssdasd', 'jateng', 'kendal', '898989', '123456789'),
('Mutiara Permana', ' mutiara', '07863432423', 'tiara@gmail.com', 'Semarang', 'jateng', 'semarang', '89897', 'mutiarapermana'),
('Putri Afina', ' Putriafina', '02932238237', 'putri@yahoo.com', 'Jakarta', 'Jakarta', 'Jakarta', '89787', 'kharisma');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `nama_barang` varchar(100) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `stok_barang` int(11) NOT NULL,
  `gambar_barang` varchar(100) NOT NULL,
  `kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`nama_barang`, `harga_barang`, `stok_barang`, `gambar_barang`, `kategori`) VALUES
('Bayam', 4000, 50, 'bayam.png', 'Sayur'),
('Cheese cake', 100000, 10, 'cheesecake.png', 'Snack'),
('Ayam', 5000, 10, 'ayam.jpg', 'Daging'),
('Daging_Sapi', 15000, 15, 'beef-meat.jpg', 'Daging'),
('Brokoli', 3000, 40, 'brokoli.png', 'Sayur'),
('Paprika Kuning', 28000, 20, 'Paprikakuning.png', 'Sayur'),
('Kentang', 4000, 70, 'kentang.png', 'Sayur'),
('Kangkung', 20000, 50, 'kangkung.png', 'Sayur'),
('Kubis', 5000, 10, 'Kubis.png', 'Sayur'),
('Paprika Hijau', 25000, 10, 'paprikahijau.png', 'Sayur'),
('Paprika  Merah', 28000, 10, 'paprikamerah.png', 'Sayur'),
('Beras', 15000, 100, 'beras.jpg', 'Sembako'),
('Mie', 10000, 100, 'mie.jpg', 'Sembako'),
('Gula Merah', 15000, 100, 'gula-merah.jpg', 'Sembako'),
('Telur Ayam Kampung', 15000, 100, 'telurayamkampung.JPG', 'Sembako'),
('Alpukat', 20000, 50, 'alpukat.png', 'Buah'),
('Anggur Hijau', 30000, 10, 'anggurhijau.png', 'Buah'),
('Asam Jawa', 10000, 10, 'asam-jawa-150x150.jpg', 'Bumbu Dapur'),
('Bawang Putih', 8000, 200, 'BawangPutih.jpg', 'Bumbu Dapur'),
('Activia Stroberi', 10000, 50, 'activia-stroberi.jpg', 'Minuman');

-- --------------------------------------------------------

--
-- Table structure for table `det_pesan`
--

CREATE TABLE IF NOT EXISTS `det_pesan` (
  `no_pesan` varchar(20) NOT NULL,
  `kd_buku` varchar(6) NOT NULL,
  `total_pesan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `det_pesan`
--


-- --------------------------------------------------------

--
-- Table structure for table `kartukredit`
--

CREATE TABLE IF NOT EXISTS `kartukredit` (
  `nokartu` varchar(20) NOT NULL,
  `namakartu` varchar(50) NOT NULL,
  `tglkadaluwarsa` varchar(30) NOT NULL,
  `userid` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kartukredit`
--

INSERT INTO `kartukredit` (`nokartu`, `namakartu`, `tglkadaluwarsa`, `userid`) VALUES
('89809', 'bella', '9-9-2013', 'isabel'),
('01291029102910', 'eki', '7-6-2013', 'eqiset'),
('12172128128', 'nurul ewanis', '8-10-2015', 'ewanis'),
('3489234234', 'risma', '7-7-2014', 'kharisma'),
('4563782937', 'afina putri', '8-9-2015', 'Putriafina');

-- --------------------------------------------------------

--
-- Table structure for table `pesan`
--

CREATE TABLE IF NOT EXISTS `pesan` (
  ` 	no_det_pesan` int(4) NOT NULL AUTO_INCREMENT,
  `kd_pesan` varchar(30) NOT NULL,
  `tgl_pesan` datetime NOT NULL,
  `total_bayar` int(11) NOT NULL,
  PRIMARY KEY (` 	no_det_pesan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `pesan`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
