-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 10, 2013 at 06:38 PM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `progin_13510023`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE IF NOT EXISTS `cart` (
  `profil_ID` varchar(20) NOT NULL,
  `cart_goods` varchar(50) NOT NULL,
  `cart_count` int(4) NOT NULL DEFAULT '0',
  `cart_note` varchar(255) DEFAULT NULL,
  KEY `profil_ID` (`profil_ID`,`cart_goods`,`cart_count`,`cart_note`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `cata_ID` varchar(8) NOT NULL,
  `cata_name` varchar(30) NOT NULL,
  `cata_detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cata_ID`),
  KEY `cata_name` (`cata_name`,`cata_detail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cata_ID`, `cata_name`, `cata_detail`) VALUES
('cata0001', 'Makanan', NULL),
('cata0002', 'Minuman', NULL),
('cata0003', 'Perawatan Anak-Anak', NULL),
('cata0004', 'Perawatan Pribadi', NULL),
('cata0005', 'Perlengkapan Rumah', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `categorymeetup`
--

CREATE TABLE IF NOT EXISTS `categorymeetup` (
  `cata_ID` varchar(8) NOT NULL,
  `goods_ID` varchar(8) NOT NULL,
  PRIMARY KEY (`cata_ID`,`goods_ID`),
  KEY `goods_ID` (`goods_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorymeetup`
--

INSERT INTO `categorymeetup` (`cata_ID`, `goods_ID`) VALUES
('cata0001', 'goods001'),
('cata0001', 'goods002'),
('cata0001', 'goods003'),
('cata0001', 'goods004'),
('cata0001', 'goods005'),
('cata0002', 'goods006'),
('cata0002', 'goods007'),
('cata0002', 'goods008'),
('cata0002', 'goods009'),
('cata0002', 'goods010'),
('cata0003', 'goods011'),
('cata0003', 'goods012'),
('cata0003', 'goods013'),
('cata0003', 'goods014'),
('cata0003', 'goods015'),
('cata0004', 'goods016'),
('cata0004', 'goods017'),
('cata0004', 'goods018'),
('cata0004', 'goods019'),
('cata0004', 'goods020'),
('cata0005', 'goods021'),
('cata0005', 'goods022'),
('cata0005', 'goods023'),
('cata0005', 'goods024'),
('cata0005', 'goods025');

-- --------------------------------------------------------

--
-- Table structure for table `goods`
--

CREATE TABLE IF NOT EXISTS `goods` (
  `goods_ID` varchar(8) NOT NULL,
  `goods_name` varchar(50) NOT NULL,
  `goods_price` int(9) NOT NULL DEFAULT '0',
  `goods_detail` varchar(255) DEFAULT NULL,
  `goods_available` int(3) NOT NULL DEFAULT '0',
  `goods_sold` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`goods_ID`),
  KEY `goods_name` (`goods_name`,`goods_price`,`goods_detail`,`goods_available`),
  KEY `goods_sold` (`goods_sold`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `goods`
--

INSERT INTO `goods` (`goods_ID`, `goods_name`, `goods_price`, `goods_detail`, `goods_available`, `goods_sold`) VALUES
('goods001', 'astor', 8320, 'Astor Double Coklat 150gr**Chocolate 150 GR x 1', 13, 2),
('goods002', 'oreo reguler', 6500, 'Oreo Reguler Bonus Pack 137 Gr**Reguler 137 GR x 1', 19, 12),
('goods003', 'selamat wafer chocolate', 11300, 'Selamat Wafer 198gr*Chocolate 198 GR x 1', 3, 0),
('goods004', 'twister', 4690, 'Selamat Twister Choco 45grTwist Choco 45g 45 GR x 1', 4, 4),
('goods005', 'tango chocolate', 6250, 'Tango Wafer Chocolate 114gr*Chocolate 114 GR x 1', 21, 0),
('goods006', 'buavita-orange', 23600, 'Buavita Orange T/p 1l*Orange 1000 ML x 1', 56, 0),
('goods007', 'fanta strawberry', 28030, 'Fanta Strawberry Can 6x250ml*Strawberry 250 ML x 6', 31, 0),
('goods008', 'sprite kaleng', 28030, 'Sprite Can 6x250 Ml*Lemon Lime 250 ML x 6', 82, 0),
('goods009', 'pepsi cola', 6150, 'Pepsi Cola Btl 500mlCola 500 ML x 1', 45, 0),
('goods010', 'luwak white coffee', 5510, 'Luwak Kopi White Koffie 5x20grKopi White 50 GR x 5', 67, 0),
('goods011', 'cerelac beras merah', 6850, 'Nestle Blue Beras Merah 120g*Rice 120 GR x 1', 14, 21),
('goods012', 'cussons maild gentle', 2130, 'Cussons Baby Soap 75g*Maild Gentle 75 GR x 1', 34, 0),
('goods013', 'dancow batita', 11950, 'Dancow Batita Vanilla Box 150 GrVanilla 150 GR x 1', 78, 0),
('goods014', 'johnson baby oil', 8240, 'Johnsons Baby Oil 50ml*Original 50 ML x 1', 64, 0),
('goods015', 'milna toodler', 11500, 'Milna Todler Coklat 110gr*Chocolate 110 GR x 1', 43, 0),
('goods016', 'axe-twist', 16690, 'Axe Deo Body Spray Twist 50ml*Twist 50 ML x 1', 27, 0),
('goods017', 'citra pearly white', 11740, 'Citra Hand Body Pearly White Uv 120ml**Pearly White 120 ML x 1', 29, 0),
('goods018', 'detol pine', 3400, 'Dettol Soap 70 Gr*Pine 70 GR x 1', 43, 0),
('goods019', 'nice', 9080, 'Nice Softpack Yellow 250s*Original 250 S x 1', 26, 0),
('goods020', 'paseo', 8960, 'Paseo Smart 250s *Softpack Reff 250 S x 1', 15, 0),
('goods021', 'rinso-original', 24250, 'Rinso Anti Noda 1400 Gr**Anti Noda 1400 GR x 1', 12, 0),
('goods022', 'wings-blue', 5180, 'Wings Creamw-900 690gr*Blue 690 GR x 1', 34, 0),
('goods023', 'baygon-yellow', 36850, 'Baygon Aerosol Yellow 750ml*Yellow 750 ML x 1', 56, 0),
('goods024', 'stellamatic-orange', 20300, 'Stella Matic Orange Refill 225 Ml*Orange 225 ML x 1', 68, 0),
('goods025', 'superpell-lemon', 17600, 'Superpell Floor Cleaner 1600ml*Lemon G 1600 ML x 1', 34, 0);

-- --------------------------------------------------------

--
-- Table structure for table `userprofil`
--

CREATE TABLE IF NOT EXISTS `userprofil` (
  `profil_ID` varchar(20) NOT NULL,
  `profil_name` varchar(30) NOT NULL,
  `profil_password` varchar(50) NOT NULL,
  `profil_email` varchar(50) NOT NULL,
  `profil_address` varchar(255) DEFAULT NULL,
  `profil_province` varchar(20) DEFAULT NULL,
  `profil_district` varchar(20) DEFAULT NULL,
  `profil_zipcode` int(6) DEFAULT NULL,
  `profil_mobile` int(12) DEFAULT NULL,
  `profil_transaction` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`profil_ID`),
  KEY `profil_name` (`profil_name`,`profil_password`,`profil_email`,`profil_address`,`profil_province`,`profil_district`,`profil_zipcode`,`profil_mobile`),
  KEY `profil_transaction` (`profil_transaction`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userprofil`
--

INSERT INTO `userprofil` (`profil_ID`, `profil_name`, `profil_password`, `profil_email`, `profil_address`, `profil_province`, `profil_district`, `profil_zipcode`, `profil_mobile`, `profil_transaction`) VALUES
('aldo.sem', 'Everaldo Sembiring', 'aldosembiring', '13510095@std.stei.itb.ac.id', NULL, NULL, NULL, NULL, NULL, 0),
('aurel.ma', 'Aurelia Matondang', 'aurelaurel', '13510023@std.stei.itb.ac.id', '', '', '', 123, 0, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `categorymeetup`
--
ALTER TABLE `categorymeetup`
  ADD CONSTRAINT `categorymeetup_ibfk_1` FOREIGN KEY (`goods_ID`) REFERENCES `goods` (`goods_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorymeetup_ibfk_2` FOREIGN KEY (`cata_ID`) REFERENCES `category` (`cata_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
