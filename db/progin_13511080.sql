-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2013 at 03:35 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `wbd`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(30) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah_terbeli` int(11) NOT NULL,
  `kategori` varchar(30) NOT NULL,
  `deskripsi` varchar(150) NOT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `stok`, `harga`, `jumlah_terbeli`, `kategori`, `deskripsi`) VALUES
(1, 'Daging Kraken', 1050, 50000, 200, 'Makanan', 'Daging kraken segar, mengandung Omega 3. Cocok untuk dibuat sushi.'),
(2, 'Oran Berry', 2057, 20000, 504, 'Makanan', 'Menambah HP Pokemon.'),
(3, 'Kodok Hijau', 132, 15000, 7351, 'Peralatan Sekolah', 'Peralatan wajib sekolah dasar sihir. Dapat disihir hingga 5000 kali.'),
(4, 'Kapur', 1240, 500, 12030, 'Peralatan Sekolah', 'Peralatan wajib sekolah dasar sihir. Untuk pembuatan pentagram.'),
(5, 'Muon Collider', 13, 2000000000, 44, 'Peralatan Sekolah', 'Collider partikel muon. Untuk lab fisika SMA.'),
(6, 'One-Handed Sword', 2, 200000, 10073, 'Peralatan Sekolah', 'Peralatan wajib sekolah militer. Untuk SMP kelas 2-3'),
(7, 'Mini GN-Drive', 134, 2000000, 271, 'Mainan', 'Miniatur sistem propulsi berbasis GN-Particle. Dapat dipasang di sepatu roda, skateboard dan sepeda.'),
(8, 'AK-47', 1202, 300000, 25456, 'Peralatan Sekolah', 'Peralatan keamanan diri dasar wanita umur 16-23 tahun. Dapat digunakan untuk mengusir stalker.'),
(10, 'Little Boy', 208, 100000000, 2508, 'Mainan', 'Versi Hiroshima. Hati-hati dalam penggunaan; mudah meledak.'),
(11, 'Incubator', 209, 1000000, 2020, 'Peralatan Serbaguna', 'Dapat mengabulkan permintaan apapun dan mengubah anda menjadi Magical Girl, tentunya dengan imbalan yang "pantas"'),
(12, 'Doraemon', 51, 100000000, 1081, 'Peralatan Serbaguna', 'Robot dari abad 22. Mempunyai banyak peralatan ajaib. Jauhkan dari jangkauan tikus.'),
(13, 'Genie Lamp', 100, 1000000, 502, 'Peralatan Serbaguna', 'Hanya bisa mengabulkan 3 permintaan. Tidak dapat dipakai untuk meminta tambahan permintaan.'),
(14, 'AT Field Generator', 120, 500000000, 3307, 'Peralatan Rumah', 'Generator AT Field. Cukup kuat untuk menjaga rumah dari serangan Angels.'),
(15, 'Cerberus', 54, 20000000, 3010, 'Peralatan Rumah', 'Anjing penjaga. Berkepala tiga. Jangan lupa untuk memberi makan setiap pagi.'),
(16, 'Russian Roulette', 305, 50000, 1200, 'Mainan', 'Versi pisau-dalam-gelas. Untuk dimainkan 4-5 orang.'),
(17, 'Pokeball', 1059, 20000, 13030, 'Mainan', 'Dapat digunakan untuk menangkap pokemon.'),
(18, 'Dakimakura', 201, 1000000, 7451, 'Mainan', 'Dapat digunakan jika anda kesepian.'),
(19, 'Pensil', 1002, 1000, 1023, 'Peralatan Serbaguna', 'Dapat digunakan untuk menulis, menekan tombol reset router, menggaruk punggung, mencoblos aqua gelas, dan sebagainya.'),
(20, 'Nokia 3310', 341, 300000, 5880, 'Peralatan Serbaguna', 'Durabilitas tinggi. Dapat digunakan untuk meruntuhkan gedung, mendongkrak truk, dan membuat terowongan. Jangan sampai terlempar ke manusia dan hewan!'),
(21, 'Permen Rendang', 3200, 10000, 3460, 'Makanan', 'Permen rasa rendang. Lezat dan mengenyangkan.'),
(22, 'AIM Field Dispersion Sensor', 120, 10000000, 410, 'Peralatan Sekolah', 'Untuk pengukuran dispersi medan AIM pada tes esper.'),
(23, 'Kartu Tarot', 1020, 30000, 4005, 'Peralatan Sekolah', 'Peralatan wajib sekolah dasar sihir. Untuk peramalan dasar.'),
(24, 'Electric Stun Gun', 1239, 100000, 2031, 'Peralatan Sekolah', 'Peralatan keamanan diri dasar perempuan umur 10-13 tahun. Dapat digunakan untuk mengusir lolicon.'),
(25, 'Automatic Rifle', 120, 500000, 1230, 'Peralatan Rumah', 'Efektif untuk mengusir tamu yang tidak diinginkan.'),
(26, 'Kamui', 1980, 5000000, 16192, 'Peralatan Sekolah', 'Seragam sekolah super. Untuk wanita umur 16-18 tahun.'),
(27, 'Goku Uniform', 1239, 2000000, 12039, 'Peralatan Sekolah', 'Seragam sekolah super. Lebih lemah dari Kamui.'),
(28, 'Roti Tawar', 1091, 3000, 8501, 'Makanan', 'Untuk dimakan sambil berlari ke sekolah saat terlambat.'),
(29, '3D Maneuver Gear ', 1230, 500000, 9015, 'Peralatan Sekolah', 'Peralatan wajib sekolah militer. Untuk praktikum melawan Titan.'),
(30, 'Buku Tulis', 210, 5000, 1403, 'Peralatan Sekolah', 'Untuk mengisi tas sekolah.'),
(31, 'Microwave-Phone', 103, 1500000, 2012, 'Peralatan Sekolah', 'Alat praktikum fisika. Salah satu model mesin waktu sederhana.'),
(32, 'Coca-Cola', 102, 5000, 1438, 'Peralatan Rumah', 'Pembersih lantai dan toilet. Hati-hati dalam menggunakan; cairan bersifat korosif.'),
(33, 'Kopi', 1002, 3000, 3292, 'Makanan', 'Dapat diubah menjadi kode.'),
(34, 'Lemari Rahasia', 301, 300000, 2483, 'Peralatan Rumah', 'Lemari rahasia yang ditanam di dalam dinding. Dapat digunakan untuk menyembunyikan uang, koleksi doujin, benda keramat ataupun korban pembunuhan.');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `mem_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact` varchar(30) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(60) NOT NULL,
  `no_credit` varchar(16) DEFAULT NULL,
  `nama_credit` varchar(50) DEFAULT NULL,
  `expired_date` varchar(30) DEFAULT NULL,
  `jumlah_transaksi` int(11) NOT NULL,
  `role` varchar(11) NOT NULL,
  PRIMARY KEY (`mem_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`mem_id`, `name`, `address`, `contact`, `email`, `username`, `password`, `no_credit`, `nama_credit`, `expired_date`, `jumlah_transaksi`, `role`) VALUES
(1, 'Faiz', NULL, NULL, 'faiz@faiz.com', 'faiz', 'root', '1234567890123456', 'faizilham', '12/15', 1, 'admin'),
(4, 'abcd abcd', 'asaasd', '23213', 'a@a.cc', 'abcdabcd', '12345678', NULL, NULL, NULL, 0, 'user'),
(5, 'akbar saputra', 'a', '01234', 'a@a.com', 'akbar', '12345678', NULL, NULL, NULL, 0, 'user'),
(6, 'a a', 'a', '1', 'a@e.eee', 'eeeeee', '12345678', NULL, NULL, NULL, 0, 'user'),
(7, 'abcd a', 'aa', '1', 'qwe@qe.qq', 'qwerty', '12345678', NULL, NULL, NULL, 0, 'user'),
(8, 'qwe dasd', 'adas', '123', 'asd@asd.aaa', 'zxcvb', '12345678', '1234567890123456', 'faizz', '12/14', 0, 'user');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
