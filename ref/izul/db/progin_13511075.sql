-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 29 Okt 2013 pada 15.18
-- Versi Server: 5.6.11
-- Versi PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `tubes1_wbd`
--
CREATE DATABASE IF NOT EXISTS `tubes1_wbd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tubes1_wbd`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int(9) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `email` varchar(32) NOT NULL,
  `password` char(64) NOT NULL,
  `fullname` varchar(64) NOT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `province` varchar(32) DEFAULT NULL,
  `postcode` char(5) DEFAULT NULL,
  `transaction` int(5) NOT NULL,
  `card_number` varchar(16) DEFAULT NULL,
  `card_name` varchar(32) DEFAULT NULL,
  `card_expired` date DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(9) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(32) NOT NULL,
  `category` varchar(16) NOT NULL,
  `price` int(12) NOT NULL,
  `stock_count` int(9) NOT NULL,
  `image_link` varchar(64) DEFAULT NULL,
  `description` text,
  `sold` int(9) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `category`, `price`, `stock_count`, `image_link`, `description`, `sold`) VALUES
(1, 'Altec Lansing VS4261', 'Elektronik', 800000, 10, 'images/barang1.jpg', 'Sebuah speaker system yang memiliki banyak kelebihan. Selain walaupun harganya tidak terlalu mahal, speaker ini memiliki kelebihan pada banyak sisi, seperti kejelasan suara dan desainnya yang unik', 1),
(2, 'Fiat 500', 'Otomotif', 1500000, 5, 'images/barang2.jpg', 'Mobil mini menarik dan unik', 1),
(3, 'Jack Wolfskin', 'Fashion', 1500000, 10, 'images/barang3.jpg', 'Jaket tebal dengan desain yang sangat menarik ini cocok sekali digunakan didaerah kutub dan di dataran tinggi.', 1),
(4, 'Acer 4652 G', 'Elektronik', 5000000, 10, 'images/barang4.jpg', 'Sebuah laptop handal yang mampu memenami anda dalam menjelajahi semua multimedia yang ada. Didukung dengan processor super cepat up to 3.1GHz, sangat cocok bagi anda yang menyukai dunia Game. Produk ini tersedia dalam beberapa warna', 5),
(5, 'Rumah Mewah Bogor Tipe 21', 'Properti', 1000000000, 1, 'images/barang5.jpg', 'Rumah mewah yang terletak di Bogor ini mempunyai 4 buah ruangan yang sangat nyaman dan full furnish', 0),
(6, 'Gitar Yamaha YZR 200', 'Musik', 600000, 8, 'images/barang6.jpg', 'Gitar yamaha ini adalah gitar paling terkenal dikelasnya, setiap pembelian gitar ini akan diberikan garansi 3 bulan. Selain itu gitar ini terdapat pada bermacam-macam warna yang menarik.', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `shopping_bag`
--

CREATE TABLE IF NOT EXISTS `shopping_bag` (
  `customer_id` int(9) NOT NULL,
  `product_id` int(9) NOT NULL,
  `request_count` int(9) NOT NULL,
  `request_description` text,
  `is_purchased` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
