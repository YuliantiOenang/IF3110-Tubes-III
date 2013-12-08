-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2013 at 06:33 AM
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=11 ;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga`, `stok`, `kategori`, `deskripsi`, `jumlah_beli`) VALUES
(1, 'sate padang', 100, 7, 'makanan', 'lololo', 4),
(2, 'soto', 6000, 93, 'makanan', '', 100),
(3, 'ikan teri', 1000, 10, 'makanan', '', 0),
(4, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 7),
(5, 'hongli', 50200, 32, 'Model Kit', 'ini kw woy :v', 80),
(6, 'Monster Hunter 4', 500000, 40, 'game', 'MH 4 masih jap bahkan -_-', 76),
(7, 'barang_test1', 1000000, 100, 'mainan', 'test aja :v', 12),
(8, 'barang_test2', 1000000, 100, 'mainan', 'test aja :v', 35),
(9, 'barang_test2', 1000000, 100, 'mainan', 'test aja :v', 91),
(10, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 124),
(11, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 33),
(12, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 29),
(13, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 93),
(14, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 21),
(15, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 22),
(16, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 11),
(17, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 5),
(18, 'barang_test', 1000000, 100, 'mainan', 'test aja :v', 2),
(19, 'Fam Fan Fan A', 50000, 25, 'Prototype', 'Kartu Fam Fan Fan A!', 8),
(20, 'Fam Fan Fan B', 25000, 56, 'Prototype', 'Kartu Fam Fan Fan B!', 10),
(21, 'Fam Fan Fan J', 8500, 23, 'Grunts', 'Kartu Fam Fan Fan J!', 11),
(22, 'Fam Fan Fan C', 25000, 22, 'Prototype', 'Kartu Fam Fan Fan C!', 1),
(23, 'Fam Fan Fan D', 32500, 76, 'Prototype', 'Kartu Fam Fan Fan D!', 50),
(24, 'Fam Fan Fan E', 10000, 10, 'Prototype', 'Kartu Fam Fan Fan E!', 36),
(25, 'Fam Fan Fan F', 58500, 18, 'Grunts', 'Kartu Fam Fan Fan F!', 11),
(26, 'Fam Fan Fan G', 80000, 91, 'Grunts', 'Kartu Fam Fan Fan G!', 64),
(27, 'Fam Fan Fan H', 100000, 64, 'Grunts', 'Kartu Fam Fan Fan H!', 22),
(28, 'Fam Fan Fan I', 34500, 76, 'Grunts', 'Kartu Fam Fan Fan I!', 6),
(29, 'Fam Fan Fan K', 56500, 54, 'Ver. Ka', 'Kartu Fam Fan Fan K!', 12),
(30, 'Fam Fan Fan L', 23250, 78, 'Ver. Ka', 'Kartu Fam Fan Fan L!', 12),
(31, 'Mermaid Idol Flute', 25000, 33, 'Ver. Ka', 'Kartu Mermaid Idol Flute!', 21),
(32, 'Mermaid Idol Sedna', 87500, 94, 'Ver. Ka', 'Kartu Mermaid Idol Sedna!', 12),
(33, 'Blazers Pleasures', 57500, 54, 'Ver. Ka', 'Kartu Blazer Pleasures!', 21),
(34, 'Bewitching Lady Butterfy', 125000, 4, 'Special Paint Version', 'Kartu Bewitching Officer, Lady Butterfly!', 1),
(35, 'Mermaid Idol Felucca', 90000, 8, 'Special Paint Version', 'Kartu Mermaid Idol Felucca!', 5),
(36, 'White Coral Princess Claire', 55500, 5, 'Special Paint Version', 'Kartu Snow White Coral Princess Claire!', 4),
(37, 'Mermaid Idol Salem', 12500, 120, 'Special Paint Version', 'Kartu Mermaid Idol Salem!', 100),
(38, 'Pearl Sisters, Perla', 250000, 34, 'Special Paint Version', 'Kartu Pearl Sisters, Perla!', 12),
(39, 'Pearl Sisters, Perle', 250000, 1, 'Zeon Obsolete Units', 'Kartu Pearl Sisters, Perle!', 0),
(40, 'Top Idol, Flores', 14500, 111250, 'Zeon Obsolete Units', 'Kartu Top Idol, Flores!', 4),
(41, 'Top Idol Pacifica', 332500, 74, 'Zeon Obsolete Units', 'Kartu Top Idol, Pacifica!', 5),
(42, 'Bermuda Cadet, Caravelle', 1000, 99, 'Zeon Obsolete Units', 'Kartu Bermuda Cadet, Caravelle!', 12),
(43, 'Drive Quartet, Paburin', 5000, 90, 'Zeon Obsolete Units', 'Kartu Drive Quartet, Paburin!', 10),
(44, 'Drive Quartet Flows', 6000, 98, 'Prototype', 'Kartu Drive Quartet, Flows!', 21),
(45, 'Drive Quartet Risakka', 7000, 97, 'Prototype', 'Kartu Drive Quartet, Risakka!', 26),
(46, 'Drive Quartet Shupuryu', 8000, 96, 'Prototype', 'Kartu Drive Quartet, Shupuryu!', 11),
(47, 'Girls Rock, Rio', 9000, 95, 'Prototype', 'Kartu Girls Rock, Rio!', 76),
(48, 'Top Idol Aqua', 10000, 94, 'Prototype', 'Kartu Top Idol, Aqua!', 55),
(49, 'Akira, Alicia, and Athena', 11000, 94, 'Grunts', 'Kartu Akira, Alicia, dan Athena!', 12),
(50, 'Hime, Maa, and Aria', 12000, 93, 'Grunts', 'Kartu Hime, Maa, dan Aria!', 23),
(51, 'Akari, Aika, and Alice A', 13000, 94, 'Grunts', 'Kartu Akari, Aika, dan Alice A!', 34),
(52, 'Akari, Aika, and Alice B', 14000, 93, 'Grunts', 'Kartu Akari, Aika dan Alice B!', 45),
(53, 'Ametsuchi Akino', 15000, 92, 'Grunts', 'Kartu Ametsuchi Akino!', 56),
(54, 'Akari, Aika and Alice C', 16500, 91, 'Zeon Obsolete Units', 'Kartu Akari, Aika and Alice C!', 67),
(55, 'Alice Caroll A', 17250, 50, 'Zeon Obsolete Units', 'Kartu Alice Carroll A!', 19),
(56, 'Alice Carroll B', 18750, 60, 'Zeon Obsolete Units', 'Kartu Alice Carroll B!', 17),
(57, 'Athena Glory A', 19500, 70, 'Zeon Obsolete Units', 'Kartu Athena Glory A!', 15),
(58, 'Alice Carroll C', 20250, 80, 'Zeon Obsolete Units', 'Kartu Alice Carroll C!', 13),
(59, 'Alice Carroll D', 21500, 86, 'Special Paint Version', 'Kartu Alice Carroll D!', 21),
(60, 'Athena Glory B', 22250, 13, 'Special Paint Version', 'Kartu Athena Glory B!', 3),
(61, 'Athena Glory C', 24750, 15, 'Special Paint Version', 'Kartu Athena Glory C', 5),
(62, 'Athena Glory D', 26750, 156, 'Special Paint Version', 'Kartu Athena Glory D', 56),
(63, 'Woody Ayanokouji the 51st', 27500, 115, 'Special Paint Version', 'Kartu Woody Ayanokouji the 51st!', 15),
(64, 'Alice Carroll E', 28000, 74, 'Ver. Ka', 'Kartu Alice Carroll E!', 14),
(65, 'Athena Glory E', 19500, 24, 'Ver. Ka', 'Kartu Athena Glory E!', 20),
(66, 'Alice Carroll F', 25700, 22, 'Ver. Ka', 'Kartu Alice Carroll F!', 15),
(67, 'Alice Carroll G', 33750, 16, 'Ver. Ka', 'Kartu Alice Carroll G!', 6),
(68, 'Athena Glory F', 18500, 2, 'Ver. Ka', 'Kartu Athena Glory F!', 2),
(69, 'Athena Glory G', 22200, 36, 'Prototype', 'Kartu Athena Glory G!', 35),
(70, 'Kartu Alice Carroll H', 115000, 1, 'Prototype', 'Kartu Alice Carroll H!', 1),
(71, 'Alice Carroll I', 250000, 11, 'Prototype', 'Kartu Alice Carroll I!', 6),
(72, 'Alice Carroll J', 68750, 25, 'Prototype', 'Kartu Alice Carroll J!', 20),
(73, 'Akira E Ferarri', 36000, 23, 'Prototype', 'Kartu Aika E Ferarri A!', 18),
(74, 'Albert Pitt', 500000, 35, 'Grunts', 'Kartu Albert Pitt!', 20),
(75, 'Aika S Granzchesta A', 25000, 23, 'Grunts', 'Kartu Aika S Granzchesta A!', 3),
(76, 'Aika S Granzchesta B', 2000, 11, 'Grunts', 'Kartu Aika S Granzchesta B', 9),
(77, 'Akira E Ferarri B', 55000, 21, 'Grunts', 'Kartu Akira E Ferarri B!', 19),
(78, 'Akira E Ferarri C', 150000, 8, 'Grunts', 'Kartu Akira E Ferarri C!', 5),
(79, 'Aika S Granzchesta C', 14000, 22, 'Special Paint Version', 'Kartu Aika S Granzchesta C!', 16),
(80, 'Aika S Granzchesta D', 12250, 55, 'Special Paint Version', 'Kartu Aika S Granzchesta D!', 54),
(81, 'Aika S Granzchesta E', 35000, 21, 'Special Paint Version', 'Kartu Aika S Granzchesta E!', 17),
(82, 'Akira E Ferrari D', 25000, 25, 'Special Paint Version', 'Kartu Akira E Ferrari D!', 23),
(83, 'Aika S Granzchesta F', 33500, 25, 'Special Paint Version', 'Kartu Aika S Granzchesta F!', 24),
(84, 'Akira E Ferrari E', 45600, 89, 'Zeon Obsolete Suits', 'Kartu Akira E Ferrari F', 78),
(85, 'Aika and Hime', 78500, 4, 'Zeon Obsolete Suits', 'Kartu Aika dan Hime-sachou!', 2),
(86, 'Aika S Granzchesta G', 47650, 43, 'Zeon Obsolete Suits', 'Kartu Aika S Granzchesta G!', 13),
(87, 'Akira E Ferrari G', 125000, 250, 'Zeon Obsolete Suits', 'Kartu Akira E Ferarri G!', 225),
(88, 'Aika S Granzchesta H', 33850, 65, 'Zeon Obsolete Suits', 'Kartu Aika S Granzchesta H!', 60);
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
('abcd', 'abcd', 'abcd@email.com', '', 'alamat2', 'p1', 'kota1', '', '', 2, 'user', 'abcd', '14543', '12/21'),
('admin', 'admin', 'admin@a.com', '', '', '', '', '', '', 1, 'admin', 'abcde', 'asdasd', 'asdad'),
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
