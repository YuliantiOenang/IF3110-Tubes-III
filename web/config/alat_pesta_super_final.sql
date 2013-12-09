-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 29, 2013 at 11:21 AM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `alat_pesta`
--

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
  `card_number` varchar(16) NOT NULL,
  PRIMARY KEY (`no_customer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`no_customer`, `nama`, `kota`, `kodepos`, `email`, `hp`, `password`, `username`, `provinsi`, `alamat`, `card_number`) VALUES
(4, 'Andrian Octavianus', 'Kudus', 59319, 'andrian.octo@gmail.com', 0, '31023102', 'gtsquadron', '', '', ''),
(13, 'hhh', '', 0, 'krisdayanto@t.cd', 0, '312312312', 'andrian', 'brasdasd', 'asdasd', ''),
(14, 'adasdasdasdasd afasdasd', 'asdasdasd', 123123, 'asdasd@das.dsf', 1213123123, '123123123', 'aasdasdasd', 'asdasdasd', '1312asdasdasd', ''),
(15, 'tukul aja', '', 0, 'qwe@kj.mp', 0, '123123123', 'tukulArwana', '', '', ''),
(16, 'Raden Fajar Hadria Putra', 'bandung', 14045, 'f@f.com', 2147483647, '1234', 'Fazkool', 'jaabra', 'kajaa', '');

-- --------------------------------------------------------

--
-- Table structure for table `kartu__kredit`
--

CREATE TABLE IF NOT EXISTS `kartu__kredit` (
  `card_number` varchar(16) NOT NULL,
  `card_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kartu__kredit`
--

INSERT INTO `kartu__kredit` (`card_number`, `card_name`) VALUES
('1234567891234567', 'andrian'),
('9876543219876543', 'joko');

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE IF NOT EXISTS `keranjang` (
  `id_customer` int(10) NOT NULL,
  `id_alat` int(10) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `pesan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `keranjang`
--

INSERT INTO `keranjang` (`id_customer`, `id_alat`, `jumlah`, `pesan`) VALUES
(0, 25, 0, 'standart'),
(0, 25, 0, 'standart'),
(0, 25, 0, 'standart'),
(0, 25, 0, 'standart'),
(0, 25, 0, 'standart'),
(0, 25, 4, 'standart'),
(4, 6, 79, 'standart'),
(4, 11, 90, 'standart'),
(4, 1, 78, 'standart');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=58 ;

--
-- Dumping data for table `peralatan`
--

INSERT INTO `peralatan` (`no_alat`, `nama`, `kategori`, `jumlah`, `harga`, `deskripsi`, `foto`, `status`) VALUES
(1, 'Browny', 'Sweater', 2000, 400000, 'You like brown? THIS is brown! The silk is out of this world!', 'images/Sweater1.jpg', 'Tersedia'),
(2, 'Coldplay 1', 'TShirt', 2000, 75000, 'For Coldplay Fans out there!', 'images/TShirt1.jpg', 'Tersedia'),
(3, 'Coldplay Mugs', 'Misc', 2000, 60000, 'A sleek black mug for your drinking pleasure', 'images/Misc1.jpg', 'Tersedia'),
(4, 'Devil''s Jacket', 'Jaket', 1965, 150000, 'Jacket for Daredevils, I mean YOU!', 'images/Jaket1.jpg', 'tersedia'),
(5, 'Pokemon HeartGold Version', 'Pokemon', 2000, 400000, 'Lets go back to Johto!', 'images/Pokemon1.jpg', 'tersedia'),
(6, 'Viva la Vida', 'Sweater', 2000, 150000, 'Taken from limited cover art of Viva la Vida, it will show everyone that you hear Jerussalem bells are ringing!', 'images/Sweater2.jpg', 'tersedia'),
(7, 'Coldplay 2', 'TShirt', 2000, 75000, 'For Coldplay Fans out there!', 'images/TShirt2.jpg', 'tersedia'),
(8, 'Coldplay Pins', 'Misc', 2000, 30000, 'Pins for your Coldplay-ish stationary', 'images/Misc2.jpg', 'tersedia'),
(9, 'Ghost Jacket', 'Jaket', 2000, 200000, 'Your choice for eerie fashion', 'images/Jaket2.jpg', 'tersedia'),
(10, 'Pokemon Ruby Version', 'Pokemon', 2000, 300000, 'Experience the beautiful Hoenn Region!', 'images/Pokemon2.jpg', 'tersedia'),
(11, 'Live2012', 'Sweater', 2000, 200000, 'You''ve seen Coldplay Live 2012? Tell everyone you''ve seen it with this sweater!', 'images/Sweater3.jpg', 'tersedia'),
(12, 'Coldplay 3', 'TShirt', 2000, 75000, 'For Coldplay Fans out there!', 'images/TShirt3.jpg', 'tersedia'),
(13, 'Coldplay Hat', 'Misc', 2000, 80000, 'Wear your hat to proclaim yourself as a Coldplayer!', 'images/Misc3.jpg', 'tersedia'),
(14, 'Dark Jacket', 'Jaket', 2000, 200000, 'The darkest jacket there is', 'images/Jaket3.jpg', 'tersedia'),
(15, 'Pokemon SoulSilver', 'Pokemon', 2500, 400000, 'Lets go back to Johto!', 'images/Pokemon3.jpg', 'tersedia'),
(16, 'Pure Jacket', 'Jaket', 34, 80000, 'For Purists who like pure white', 'images/Jaket4.jpg', 'tersedia'),
(17, 'Steve Jacket', 'Jaket', 2323, 400000, 'A jacket who belonged to Steve Austin', 'images/Jaket7.jpg', 'tersedia'),
(18, 'Mr. Jacket', 'Jaket', 700, 100000, 'Jacket for big guys and brave young men', 'images/Jaket5.jpg', 'aasdasd'),
(19, 'Jajaccket', 'Jaket', 80, 40000, 'Weird name, cool style!', 'images/Jaket6.jpg', 'tersedia'),
(20, 'Jacketron', 'Jaket', 909, 180000, 'Welcome to the future with this futuristic wear!', 'images/Jaket8.jpg', ''),
(21, 'Lady Jacketine', 'Jaket', 80, 150000, 'Just for Ladies and Pinky Men', 'images/Jaket9.jpg', ''),
(22, 'JJJ Jacket', 'Jaket', 7070, 70000, 'For the frugals', 'images/Jaket10.jpg', ''),
(23, 'Sub-Lime', 'Jaket', 80, 120000, 'Sooo Limy!! For you who likes brightness', 'images/Jaket11.jpg', ''),
(24, 'Orange', 'Jaket', 80, 200000, 'For fruity people, we mean like eating fruit!', 'images/Jaket12.jpg', ''),
(25, 'Racer''s Armor', 'Jaket', 804, 500000, 'Wear your armor, racers!', 'images/Jaket13.jpg', ''),
(26, 'Mylo Xyloto', 'Sweater', 200, 150000, 'Share your favorite Coldplay concept album with this sweater!!', 'images/Sweater4.jpg', NULL),
(27, 'Northlane', 'Sweater', 200, 90000, 'For Northlane fans out there', 'images/Sweater5.jpg', NULL),
(28, 'Marceline', 'Sweater', 200, 100000, 'For Marceline fans out there', 'images/Sweater6.jpg', NULL),
(29, 'Jem and the Holograms', 'Sweater', 200, 130000, 'For Jam and the Holograms Fans out there!', 'images/Sweater7.jpg', NULL),
(30, 'Slipknot', 'Sweater', 200, 70000, 'For Slipknot Fans out there!', 'images/Sweater8.jpg', ''),
(31, 'Sleeping with Sir', 'Sweater', 200, 190000, 'Watch your favorite Sleeping with Sir with this sweater!', 'images/Sweater9.jpg', ''),
(32, 'Led Zeppelin', 'Sweater', 200, 170000, 'For Led Zeppelin Fans out there!', 'images/Sweater10.jpg', ''),
(33, 'KISS', 'Sweater', 200, 100000, 'For KISS Fans out there!', 'images/Sweater11.jpg', ''),
(34, 'Viva la Vida Cup', 'Misc', 2000, 50000, 'White Coldplay coffe for your white feeling', 'images/Misc4.jpg', ''),
(35, 'ETIAW Handbag', 'Misc', 20000, 30000, 'Shop with every teardrop in your head!', 'images/Misc5.jpg', ''),
(36, 'Fuzzy Man Hadbag', 'Misc', 20000, 30000, 'Fuzzy man will help you with your shopping!', 'images/Misc6.jpg', ''),
(37, 'Viva la Vida Mug', 'Misc', 2000, 40000, 'Hear the Jerussalem bells ringing while drinking with this sleek mug!', 'images/Misc7.jpg', ''),
(38, 'Coldplay Stainless Bottle', 'Misc', 2000, 130000, 'Going to Violet Hill? You should bring this nice Coldplay bottle!', 'images/Misc8.jpg', ''),
(39, 'Buckland Hat', 'Misc', 2000, 80000, 'Be Jon Buckland with this Buckland hat!', 'images/Misc9.jpg', ''),
(40, 'Coldplay Mug 2', 'Misc', 2000, 40000, 'Dont like black? Why not buy the white one?', 'images/Misc10.jpg', ''),
(41, 'Coldplay Blue Handbag', 'Misc', 2000, 50000, 'Lets go to the Paradise of shopping with this handbag!', 'images/Misc11.jpg', ''),
(42, 'Coldplay 4', 'TShirt', 200, 75000, 'A Great Coldplayish design just for you', 'images/TShirt4.jpg', ''),
(43, 'Coldplay 5', 'TShirt', 200, 75000, 'A Great Coldplayish design just for you', 'images/TShirt5.jpg', ''),
(44, 'Coldplay 6', 'TShirt', 200, 75000, 'A Great Coldplayish design just for you', 'images/TShirt6.jpg', ''),
(45, 'Coldplay 7', 'TShirt', 200, 75000, 'A Great Coldplayish design just for you', 'images/TShirt7.jpg', ''),
(46, 'Coldplay 8', 'TShirt', 200, 75000, 'A Great Coldplayish design just for you', 'images/TShirt8.jpg', ''),
(47, 'Coldplay 9', 'TShirt', 200, 75000, 'A Great Coldplayish design just for you', 'images/TShirt9.jpg', ''),
(48, 'Coldplay 10', 'TShirt', 200, 75000, 'A Great Coldplayish design just for you', 'images/TShirt10.jpg', ''),
(49, 'Coldplay 11', 'TShirt', 200, 75000, 'A Great Coldplayish design just for you', 'images/TShirt11.jpg', ''),
(50, 'Pokemon White Version', 'Pokemon', 200, 400000, 'Start from the beginning with Pokemon White Version', 'images/Pokemon4.jpg', ''),
(51, 'Pokemon Diamond Version', 'Pokemon', 200, 400000, 'Explore the mythical Sinnoh Region!', 'images/Pokemon5.jpg', ''),
(52, 'Pokemon Emerald Version', 'Pokemon', 200, 300000, 'Go back to Hoenn to save the world with Rayquaza!', 'images/Pokemon6.jpg', ''),
(53, 'Pokemon Pearl Version', 'Pokemon', 200, 400000, 'Explore the mythical Sinnoh Region!', 'images/Pokemon7.jpg', ''),
(54, 'Pokemon Sapphire Version', 'Pokemon', 200, 300000, 'Experience the beautiful Hoenn Region!', 'images/Pokemon8.jpg', ''),
(55, 'Pokemon Y', 'Pokemon', 200, 450000, 'See the beauty of Kalos Region with full 3D!', 'images/Pokemon9.jpg', ''),
(56, 'Pokemon X', 'Pokemon', 200, 450000, 'See the beauty of Kalos Region with full 3D!', 'images/Pokemon10.jpg', ''),
(57, 'Pokemon LeafGreen Version', 'Pokemon', 200, 3000000, 'Lets go back to Kanto! Start your journey all over again!', 'images/Pokemon11.jpg', '');

-- --------------------------------------------------------

--
-- Table structure for table `terbayar`
--

CREATE TABLE IF NOT EXISTS `terbayar` (
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `id_costumer` int(11) NOT NULL,
  `pesan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `terbayar`
--

INSERT INTO `terbayar` (`id_barang`, `jumlah`, `id_costumer`, `pesan`) VALUES
(25, 4, 16, 'standart');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
