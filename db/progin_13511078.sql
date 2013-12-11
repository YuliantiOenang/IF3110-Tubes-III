-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: ap01-user01.c0ye1hvnkw6z.ap-southeast-1.rds.amazonaws.com
-- Generation Time: Dec 11, 2013 at 04:18 AM
-- Server version: 5.5.27-log
-- PHP Version: 5.3.10-1ubuntu3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `d0238bb1ba27d4af5ae5230fcffc38db5`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE IF NOT EXISTS `anggota` (
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `nomorhp` varchar(15) NOT NULL,
  `alamat` text NOT NULL,
  `provinsi` varchar(20) NOT NULL,
  `kota` varchar(20) NOT NULL,
  `kodepos` int(11) NOT NULL,
  `email` text NOT NULL,
  `foto` text NOT NULL,
  `jmlhtransaksi` int(11) NOT NULL DEFAULT '0',
  `tipe` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`username`, `password`, `nama`, `nomorhp`, `alamat`, `provinsi`, `kota`, `kodepos`, `email`, `foto`, `jmlhtransaksi`, `tipe`) VALUES
('rifki', 'kikikiki', 'Rifki Afina', '0890980999', 'jalan mana aja', 'jawa tengah', 'cimahi', 490940, 'rifki@fina-put.ri', '1378714_10201562960288197_1397267956_a.jpg', 1, 0),
('identityope', 'opeopeope', 'Taufik Hidayat', '087825996141-1', 'jalan ganesha 10', 'jawa barat', 'Bandung', 40262, 'identityope@gmail.com', 'avatars-000051574937-7m4ugf-t200x200.jpg', 0, 1),
('cgunardi', 'opeopeope', 'Taufik Hidayat', '08997978829', 'jakarta', 'dki', 'jakarta', 11111, 'christian_gunardi@hotmail.com', '', 6, 0),
('albhi', '123123123', 'albhi kautsar', '123123', 'qwe', 'qwe', 'qwe', 123, 'qwe@d.com', 'user.png', 0, 0),
('azalea', 'destra123', 'azalea fisitania', '089090', 'agugu', 'jabar', 'bandung', 9090, 'azal@destra.com', 'azal.jpg', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `gambar` varchar(50) NOT NULL,
  `kategori` varchar(30) NOT NULL,
  `harga` double NOT NULL,
  `jumlah` int(11) NOT NULL,
  `keterangan` text NOT NULL,
  `terjual` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1005 ;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `nama`, `gambar`, `kategori`, `harga`, `jumlah`, `keterangan`, `terjual`) VALUES
(2, 'Momogi Rasa Keju', 'images/momogikeju.jpg', 'Makanan Ringan', 1000, 100, 'Momogi rasa keju. Nagih abis lho.', 10),
(3, 'Momogi Rasa Jagung Bakar', 'images/momogijagung.jpg', 'Makanan Ringan', 1000, 100, 'Momogi rasa jagung bakar. Temennya momogi keju.', 10),
(4, 'Marimas', 'images/marimas.jpg', 'Minuman', 500, 35, 'Marimaaas~ aww! Minuman menyegarkan. Bukan telenovela.', 10),
(7, 'Katel', 'images/katel.jpg', 'Alat Dapur', 5000, 25, 'Katel atau disebut juga wajan, adalah alat untuk memasak.', 13),
(8, 'Panci', 'images/panci.jpg', 'Alat Dapur', 8000, 12, 'Panci untuk masak yang berkuah-kuah. Warnanya juga pink unyu lucu gitu.', 10),
(10, 'Popmie', 'images/popmie.jpg', 'Makanan Siap Saji', 2000, 23, 'Saingannya indomie, lebih portable, bisa dibawa kemana-mana.', 10),
(13, 'Tahu', 'images/tahu.jpg', 'Makanan Pokok', 500, 95, 'Makanan yang terbuat dari kedelai. Temennya tempe.', 15),
(14, 'Tempe', 'images/tempe.jpg', 'Makanan Pokok', 800, 88, 'Makanan yang terbuat dari kedelai. Temennya tahu.', 52),
(16, 'Kaos', 'images/kaos.jpg', 'Pakaian', 60000, 9, 'Kaos santai dengan berbagai pilihan warna dan ukuran.', 15),
(17, 'Kemeja', 'images/kemeja.jpg', 'Pakaian', 80000, 24, 'Kemeja rapi dan gaul. Ope banget super lah ini gila.', 10),
(18, 'Nyam', 'images/nyamnyam.jpg', 'Makanan', 1500, 61, 'Jajanan masa kecil. Gak sehat, tapi tetep laris.', 9),
(19, 'Pulpen', 'images/pulpen.jpg', 'Alat Kantor', 2000, 50, 'Pulpen dengan tinta pilihan yang cocok untuk semua kertas.', 0),
(20, 'Tempat Pensil', 'images/tempatpensil.jpg', 'Alat Kantor', 10000, 60, 'Tempat untuk menaruh pensil dan alat tulis lainnya.', 0),
(25, 'Mogu', 'images/mogumogu.jpg', 'Minuman', 5500, 48, 'Minuman manis aneka rasa. Ope suka banget nih minuman.', 2),
(26, 'Nescafe', 'images/nescafe.jpg', 'Minuman', 4000, 55, 'Minuman yang setia menemani untuk begadang ngerjain tubes.', 10),
(27, 'Nu', 'images/numilktea.jpg', 'Minuman', 5000, 60, 'Teh susu. Teh sama susu, dicampur, ada gulanya juga. enak bro.', 10),
(28, 'Okky', 'images/okkyjelly.jpg', 'Minuman', 1000, 100, 'Minuman penunda lapar. Ya habis itu lapar lagi.', 10),
(29, 'Pocari', 'images/pocarisweat.jpg', 'Minuman', 7000, 78, 'Minuman elektrolit. Minuman official Ope.', 12),
(30, 'Pop', 'images/popice.jpg', 'Minuman', 500, 79, 'Pop ice blender seger. Es seger banget diminum sama ope tiap hari.', 11),
(31, 'Sirup ABC', 'images/sirupabc.jpg', 'Minuman', 20000, 60, 'Sirup dengan berbagai pilihan rasa.', 10),
(32, 'Sirup', 'images/sirupmarjan.jpg', 'Minuman', 25000, 70, 'Temennya sirup ABC. Kayaknya enak ABC tapi.', 10),
(33, 'Sprite', 'images/sprite.jpg', 'Minuman', 12000, 54, 'Soda bening pembawa kegembiraan.', 1),
(34, 'Teh', 'images/tehbotol.jpg', 'Minuman', 3000, 80, 'Teh di dalam botol. Tapi lebih enak dari teh yang biasa.', 0),
(35, 'Teh', 'images/tehgelas.jpg', 'Minuman', 1000, 80, 'Teh di dalam gelas. Lebih enak dari di dalam botol.', 10),
(36, 'Teh', 'images/tehkotak.jpg', 'Minuman', 4000, 70, 'Teh di dalam kotak. Di tengah-tengah teh gelas dan teh botol.', 10),
(37, 'Ultra', 'images/ultramilk.jpg', 'Minuman', 5000, 69, 'Susu coklat di dalam kotak.  Sama enaknya sama susu coklat biasa.', 11),
(1004, 'laptop', 'images/laptop.jgp', 'elektronik', 4000000, 20, 'laptop buat nubes anak IF', 0);

-- --------------------------------------------------------

--
-- Table structure for table `kartu_kredit`
--

CREATE TABLE IF NOT EXISTS `kartu_kredit` (
  `owner` varchar(20) NOT NULL,
  `card_number` char(16) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `expired` varchar(10) NOT NULL,
  PRIMARY KEY (`card_number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kartu_kredit`
--

INSERT INTO `kartu_kredit` (`owner`, `card_number`, `nama`, `expired`) VALUES
('cgunardi', '1234567890123456', 'Christian Gunardi', '2013-10-31'),
('rifki', '1290091827819281', 'Rifki Afina Putri', '20-20-2020'),
('identityope', '1212123123123453', 'Taufik Hidayat', '2013-11-08'),
('azalea', '1231231231231231', 'azalea fisitania', '2013-12-27'),
('albhi', '3213213213213213', 'albhi kautsar', '2013-12-04');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `username` varchar(30) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tanggal` varchar(10) NOT NULL,
  `tambahan` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
