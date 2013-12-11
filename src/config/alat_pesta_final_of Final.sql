-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Inang: localhost
-- Waktu pembuatan: 29 Okt 2013 pada 06.18
-- Versi Server: 5.5.24-log
-- Versi PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `alat_pesta`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`no_customer`, `nama`, `kota`, `kodepos`, `email`, `hp`, `password`, `username`, `provinsi`, `alamat`, `card_number`) VALUES
(4, 'Andrian Octavianus', 'Kudus', 59319, 'andrian.octo@gmail.com', 0, '31023102', 'gtsquadron', '', '', ''),
(13, 'hhh', '', 0, 'krisdayanto@t.cd', 0, '312312312', 'andrian', 'brasdasd', 'asdasd', ''),
(14, 'adasdasdasdasd afasdasd', 'asdasdasd', 123123, 'asdasd@das.dsf', 1213123123, '123123123', 'aasdasdasd', 'asdasdasd', '1312asdasdasd', ''),
(15, 'tukul aja', '', 0, 'qwe@kj.mp', 0, '123123123', 'tukulArwana', '', '', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kartu__kredit`
--

CREATE TABLE IF NOT EXISTS `kartu__kredit` (
  `card_number` varchar(16) NOT NULL,
  `card_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kartu__kredit`
--

INSERT INTO `kartu__kredit` (`card_number`, `card_name`) VALUES
('1234567891234567', 'andrian'),
('9876543219876543', 'joko');

-- --------------------------------------------------------

--
-- Struktur dari tabel `keranjang`
--

CREATE TABLE IF NOT EXISTS `keranjang` (
  `id_customer` int(10) NOT NULL,
  `id_alat` int(10) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `pesan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `keranjang`
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
-- Struktur dari tabel `peralatan`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Dumping data untuk tabel `peralatan`
--

INSERT INTO `peralatan` (`no_alat`, `nama`, `kategori`, `jumlah`, `harga`, `deskripsi`, `foto`, `status`) VALUES
(1, 'Tenda Pelangi', 'Sweater', 2000, 400000, 'tenda canopy / lengkung. Tenda ini berbentuk lengkung dibagian atasnya. Biasanya dipakai untuk acara-acara disekolah, ulang tahun, seminar, acara rumah, dan kantor yang dilaksanakan di luar ruangan (outdoor) ataupun lapangan terbuka. ', 'images/Sweater1.jpg', 'Tersedia'),
(2, 'Dekorasi Taman', 'TShirt', 2000, 350000, 'tenda canopy / lengkung. Tenda ini berbentuk lengkung dibagian atasnya. Biasanya dipakai untuk acara-acara disekolah, ulang tahun, seminar, acara rumah, dan kantor yang dilaksanakan di luar ruangan (outdoor) ataupun lapangan terbuka. ', 'images/TShirt1.jpg', 'Tersedia'),
(3, 'Meja Dan Kursi', 'Misc', 2000, 30000, 'tenda canopy / lengkung. Tenda ini berbentuk lengkung dibagian atasnya. Biasanya dipakai untuk acara-acara disekolah, ulang tahun, seminar, acara rumah, dan kantor yang dilaksanakan di luar ruangan (outdoor) ataupun lapangan terbuka.', 'images/Misc1.jpg', 'Tersedia'),
(4, 'jaket hood1', 'Jaket', 1965, 200000, 'jaket yang terbuat dari kuwlit kelapa', 'images/Jaket1.jpg', 'tersedia'),
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
(15, 'Pokemon 3', 'Pokemon', 2500, 200000, 'Pokemon 3', 'images/Pokemon3.jpg', 'tersedia'),
(16, 'Jaket2', 'Jaket', 34, 80000, 'jaket aja', 'images/Jaket4', 'tersedia'),
(17, 'Jaketttttt', 'Jaket', 2323, 80000, 'alkdjlkasjdklj', 'images/Jaket4', 'tersedia'),
(18, 'Jaket ajah', 'Jaket', 700, 70707, 'aasdasd', 'images/Jaket5', 'aasdasd'),
(19, 'Jaketkkkk', 'Jaket', 80, 808080, 'jaket terbuat dari kulit durian', 'images/Jaket6', 'tersedia'),
(20, 'JJ', 'Jaket', 909, 90909, '', '', ''),
(21, 'JJJ', 'Jaket', 80, 80, '', '', ''),
(22, 'JJJ', 'Jaket', 7070, 707070, '', '', ''),
(23, 'Jaket23', 'Jaket', 80, 80800, '', '', ''),
(24, 'Jakk', 'Jaket', 80, 800000, '', '', ''),
(25, 'jajaja', 'Jaket', 808, 808080, '', '', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `terbayar`
--

CREATE TABLE IF NOT EXISTS `terbayar` (
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `id_costumer` int(11) NOT NULL,
  `pesan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
