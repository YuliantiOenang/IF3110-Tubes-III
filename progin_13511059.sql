-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2013 at 03:26 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `progin_13511059`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` varchar(10) NOT NULL DEFAULT '',
  `nama_barang` varchar(30) NOT NULL,
  `gambar_barang` varchar(100) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `kategori_barang` int(11) NOT NULL,
  `n_beli` int(100) NOT NULL,
  `keterangan` varchar(500) NOT NULL,
  `stok` int(10) NOT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `gambar_barang`, `harga_barang`, `kategori_barang`, `n_beli`, `keterangan`, `stok`) VALUES
('101', 'Tahu Sumedang', './images/Tahu.png', 1000, 1, 10, 'tahu dari sumedang. wuenak', 10),
('102', 'Tahu Bandung', './images/Tahu.png', 2000, 1, 9, 'tahu dari Bandung. wuenak', 10),
('103', 'Tahu Medan', './images/Tahu.png', 3000, 1, 8, 'tahu dari Medan. wuenak', 10),
('104', 'Tahu Palembang', './images/Tahu.png', 4000, 1, 7, 'tahu dari Palembang. wuenak', 10),
('105', 'Tahu Jakarta', './images/Tahu.png', 5000, 1, 6, 'tahu dari Jakarta. wuenak', 10),
('106', 'Siomay Sumedang', './images/Siomay.png', 1000, 1, 11, 'Siomay dari sumedang. wuenak', 10),
('107', 'Siomay Bandung', './images/Siomay.png', 2000, 1, 19, 'Siomay dari Bandung. wuenak', 10),
('108', 'Siomay Medan', './images/Siomay.png', 3000, 1, 18, 'Siomay dari Medan. wuenak', 10),
('109', 'Siomay Palembang', './images/Siomay.png', 4000, 1, 17, 'Siomay dari Palembang. wuenak', 10),
('110', 'Siomay Jakarta', './images/Siomay.png', 5000, 1, 6, 'Siomay dari Jakarta. wuenak', 10),
('111', 'Beras Sumedang', './images/Beras.png', 10000, 1, 1, 'Beras dari sumedang. wuenak', 10),
('112', 'Beras Bandung', './images/Beras.png', 20000, 1, 9, 'Beras dari Bandung. wuenak', 10),
('113', 'Beras Medan', './images/Beras.png', 30000, 1, 8, 'Beras dari Medan. wuenak', 10),
('114', 'Beras Palembang', './images/Beras.png', 40000, 1, 7, 'Beras dari Palembang. wuenak', 10),
('115', 'Beras Jakarta', './images/Beras.png', 50000, 1, 6, 'Beras dari Jakarta. wuenak', 10),
('116', 'Tempe Sumedang', './images/Tempe.png', 1000, 1, 1, 'Tempe dari sumedang. wuenak', 10),
('117', 'Tempe Bandung', './images/Tempe.png', 2000, 1, 9, 'Tempe dari Bandung. wuenak', 10),
('118', 'Tempe Medan', './images/Tempe.png', 3000, 1, 8, 'Tempe dari Medan. wuenak', 10),
('119', 'Tempe Palembang', './images/Tempe.png', 4000, 1, 7, 'Tempe dari Palembang. wuenak', 10),
('120', 'Tempe Jakarta', './images/Tempe.png', 5000, 1, 6, 'Tempe dari Jakarta. wuenak', 10),
('121', 'Ayam Sumedang', './images/Ayam.png', 10000, 1, 1, 'Ayam dari sumedang. wuenak', 10),
('122', 'Ayam Bandung', './images/Ayam.png', 20000, 1, 9, 'Ayam dari Bandung. wuenak', 10),
('123', 'Ayam Medan', './images/Ayam.png', 30000, 1, 8, 'Ayam dari Medan. wuenak', 10),
('124', 'Ayam Palembang', './images/Ayam.png', 40000, 1, 7, 'Ayam dari Palembang. wuenak', 10),
('125', 'Ayam Jakarta', './images/Ayam.png', 50000, 1, 6, 'Ayam dari Jakarta. wuenak', 10),
('126', 'Sapi Sumedang', './images/Sapi.png', 1000, 1, 1, 'Sapi dari sumedang. wuenak', 10),
('127', 'Sapi Bandung', './images/Sapi.png', 2000, 1, 9, 'Sapi dari Bandung. wuenak', 10),
('128', 'Sapi Medan', './images/Sapi.png', 3000, 1, 8, 'Sapi dari Medan. wuenak', 10),
('129', 'Sapi Palembang', './images/Sapi.png', 4000, 1, 7, 'Sapi dari Palembang. wuenak', 10),
('130', 'Sapi Jakarta', './images/Sapi.png', 5000, 1, 6, 'Sapi dari Jakarta. wuenak', 10),
('201', 'jersey MU Home', './images/MUH.png', 100000, 2, 13, 'jersey MU homeyang keren KW Thailand', 5),
('202', 'jersey Chelsea Home', './images/ChelseaH.png', 75000, 2, 7, 'jersey Chelsea home yang keren KW Thailand', 10),
('203', 'jersey Barcelona Home', './images/BarcaH.png', 100000, 2, 8, 'jersey Barcelona home yang keren KW Thailand', 10),
('204', 'jersey Arsenal Home', './images/ArsenalH.png', 75000, 2, 7, 'jersey Arsenal home yang keren KW Thailand', 10),
('205', 'jersey Real Madrid H', './images/RealH.png', 100000, 2, 8, 'jersey real madrid home yang keren KW Thailand', 10),
('206', 'jersey MU away', './images/MUA.png', 100000, 2, 8, 'jersey MU away yang keren KW Thailand', 10),
('207', 'jersey Chelsea away', './images/ChelseaA.png', 75000, 2, 7, 'jersey Chelsea away yang keren KW Thailand', 10),
('208', 'jersey Barcelona away', './images/BarcaA.png', 100000, 2, 8, 'jersey Barcelona away yang keren KW Thailand', 10),
('209', 'jersey Arsenal away', './images/ArsenalA.png', 75000, 2, 7, 'jersey Arsenal away yang keren KW Thailand', 10),
('210', 'jersey Real Madrid A', './images/RealA.png', 100000, 2, 8, 'jersey real madrid away yang keren KW Thailand', 10),
('211', 'kaos1 T-Shirt ', './images/kaos.png', 75000, 2, 7, 'kaos T-shirt bergambar ...', 10),
('212', 'kaos1 T-Shirt v-neck', './images/kaos.png', 100000, 2, 8, 'kaos T-shirt bergambar ...model v-neck', 10),
('213', 'kaos2 T-Shirt', './images/kaos.png', 75000, 2, 7, 'kaos T-shirt bergambar ...', 10),
('214', 'kaos2 T-Shirt v-neck', './images/kaos.png', 100000, 2, 8, 'kaos T-shirt bergambar ...model v-neck', 10),
('215', 'kaos3 T-Shirt', './images/kaos.png', 75000, 2, 7, 'kaos T-shirt bergambar ...', 10),
('216', 'kaos3 T-Shirt v-neck', './images/kaos.png', 100000, 2, 8, 'kaos T-shirt bergambar ... model v-neck', 10),
('217', 'kaos4 T-Shirt', './images/kaos.png', 75000, 2, 7, 'kaos T-shirt bergambar ...', 10),
('218', 'kaos4 T-Shirt v-neck', './images/kaos.png', 75000, 2, 7, 'kaos T-shirt bergambar ... model v-neck', 10),
('219', 'kaos5 T-Shirt', './images/ArsenalA.png', 75000, 2, 7, 'jersey Arsenal away yang keren KW Thailand', 10),
('220', 'kaos5 T-Shirt v-neck', './images/RealA.png', 100000, 2, 8, 'jersey real madrid away yang keren KW Thailand', 10),
('221', 'jaket1 ', './images/jaket.png', 75000, 2, 7, 'jaket model 1 yang kece abis', 10),
('222', 'jaket2', './images/jaket.png', 100000, 2, 8, 'jaket model 2 yang kece abis', 10),
('223', 'jaket3', './images/jaket.png', 150000, 2, 8, 'jaket model 3 yang kece abis', 10),
('224', 'rompi1', './images/rompi.png', 100000, 2, 8, 'rompi model 1 yang kece abis', 10),
('225', 'rompi2', './images/rompi.png', 75000, 2, 7, 'rompi model 2 yang kece abis', 10),
('226', 'rompi3', './images/rompi.png', 100000, 2, 8, 'rompi model 3 yang kece abis', 10),
('227', 'jeans1 pendek', './images/jeanspendek.png', 75000, 2, 7, 'jeans pendek yang sangat gaol', 10),
('228', 'jeans2 panjang', './images/jeanspjg.png', 75000, 2, 7, 'jeans panjang yang sangat gaol', 10),
('229', 'jeans3 skinny', './images/skinny.png', 75000, 2, 7, 'jeans skinny yang sangat gaol', 10),
('230', 'jeans4 cut-bray', './images/cutbray.png', 75000, 2, 7, 'jeans cut-bray yang sangat gaol', 10),
('301', 'TV1 Sony', './images/tv.png', 500000, 3, 7, 'TV layar cembung berukuran 15 inch', 10),
('302', 'TV1 Sony flat', './images/tv.png', 1750000, 3, 7, 'TV layar flat berukuran 21 inch', 10),
('303', 'TV2 Sony', './images/tv.png', 1000000, 3, 7, 'TV layar cembung berukuran 15 inch', 10),
('304', 'TV2 Sony flat', './images/tv.png', 2500000, 3, 7, 'TV layar flat berukuran 21 inch', 10),
('305', 'TV3 LG', './images/tv.png', 2000000, 3, 7, 'TV layar flat berukuran 21 inch', 10),
('306', 'TV4 LG', './images/tv.png', 3000000, 3, 7, 'TV layar flat berukuran 28 inch', 10),
('307', 'hp Samsung', './images/hp.png', 500000, 3, 17, 'hp merk samsung yang keren ', 10),
('308', 'hp Nokia', './images/hp.png', 1750000, 3, 7, 'hp merk nokia yang sangat keren', 10),
('309', 'hp Soni', './images/hp.png', 1000000, 3, 7, 'hp merk soni yang sangat keren', 10),
('310', 'hp LG', './images/hp.png', 2500000, 3, 7, 'hp merk LG yang sangat keren', 10),
('311', 'hp Mito', './images/hp.png', 2000000, 3, 7, 'hp merk mito yang sangat keren', 10),
('312', 'hp Asus', './images/hp.png', 3000000, 3, 7, 'hp merk asus yang sangat keren', 10),
('313', 'laptop Samsung', './images/laptop.png', 500000, 3, 7, 'laptop merk samsung yang keren ', 10),
('314', 'laptop Nokia', './images/laptop.png', 1750000, 3, 7, 'laptop merk nokia yang sangat keren', 10),
('315', 'laptop Soni', './images/laptop.png', 1000000, 3, 7, 'laptop merk soni yang sangat keren', 10),
('316', 'laptop LG', './images/laptop.png', 2500000, 3, 7, 'laptop merk LG yang sangat keren', 10),
('317', 'laptop Mito', './images/laptop.png', 2000000, 3, 7, 'laptop merk mito yang sangat keren', 10),
('318', 'laptop Asus', './images/laptop.png', 3000000, 3, 7, 'laptop merk asus yang sangat keren', 10),
('319', 'hair dryer', './images/hairdrier.png', 500000, 3, 7, 'hair dryer yang dapat mengeringkan rambut anda super cepat', 10),
('320', 'power bank', './images/powerbank.png', 1750000, 3, 7, 'power bank dengan kapasitas yang besar', 10),
('321', 'Radio Sony', './images/Radio.png', 250000, 3, 12, 'Radio canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('322', 'Radio LG', './images/Radio.png', 150000, 3, 10, 'Radio canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('323', 'Radio Samsung', './images/Radio.png', 350000, 3, 16, 'Radio canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('324', 'Radio Mito', './images/Radio.png', 450000, 3, 20, 'Radio canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('325', 'Radio Cross', './images/Radio.png', 200000, 3, 35, 'Radio canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('326', 'Mesin Cuci Sony', './images/Mesin Cuci.png', 5000000, 3, 2, 'Mesin Cuci canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('327', 'Mesin Cuci LG', './images/Mesin Cuci.png', 4000000, 3, 0, 'Mesin Cuci canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('328', 'Mesin Cuci Samsung', './images/Mesin Cuci.png', 3500000, 3, 6, 'Mesin Cuci canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('329', 'Mesin Cuci Mito', './images/Mesin Cuci.png', 4500000, 3, 2, 'Mesin Cuci canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('330', 'Mesin Cuci Cross', './images/Mesin Cuci.png', 2000000, 3, 3, 'Mesin Cuci canggih, sangat cocok untuk anda yang mengikuti teknologi masa kini', 10),
('401', 'Pisau krisbow', './images/Pisau.png', 50000, 4, 6, 'Pisau kribow sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('402', 'Pisau olympic', './images/Pisau.png', 35000, 4, 5, 'Pisau olyimpic sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('403', 'Pisau index', './images/Pisau.png', 35000, 4, 4, 'Pisau index sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('404', 'Pisau lionstar', './images/Pisau.png', 45000, 4, 3, 'Pisau lionstar sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('405', 'Pisau matahari', './images/Pisau.png', 75000, 4, 1, 'Pisau matahari sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('406', 'Lemari krisbow', './images/Lemari.png', 60000, 4, 6, 'Lemari kribow sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('407', 'Lemari olympic', './images/Lemari.png', 75000, 4, 5, 'Lemari olyimpic sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('408', 'Lemari index', './images/Lemari.png', 85000, 4, 4, 'Lemari index sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('409', 'Lemari lionstar', './images/Lemari.png', 55000, 4, 3, 'Lemari lionstar sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('410', 'Lemari matahari', './images/Lemari.png', 95000, 4, 1, 'Lemari matahari sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('411', 'Kompor krisbow', './images/Kompor.png', 500000, 4, 1, 'Kompor kribow sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('412', 'Kompor olympic', './images/Kompor.png', 350000, 4, 1, 'Kompor olyimpic sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('413', 'Kompor index', './images/Kompor.png', 350000, 4, 1, 'Kompor index sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('414', 'Kompor lionstar', './images/Kompor.png', 450000, 4, 2, 'Kompor lionstar sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('415', 'Kompor matahari', './images/Kompor.png', 750000, 4, 1, 'Kompor matahari sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('416', 'Meja krisbow', './images/Meja.png', 30000, 4, 7, 'Meja kribow sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('417', 'Meja olympic', './images/Meja.png', 25000, 4, 3, 'Meja olyimpic sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('418', 'Meja index', './images/Meja.png', 55000, 4, 9, 'Meja index sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('419', 'Meja lionstar', './images/Meja.png', 41000, 4, 2, 'Meja lionstar sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('420', 'Meja matahari', './images/Meja.png', 35000, 4, 9, 'Meja matahari sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('421', 'Panci krisbow', './images/Panci.png', 50000, 4, 6, 'Panci kribow sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('422', 'Panci olympic', './images/Panci.png', 35000, 4, 7, 'Panci olyimpic sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('423', 'Panci index', './images/Panci.png', 30000, 4, 6, 'Panci index sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('424', 'Panci lionstar', './images/Panci.png', 45000, 4, 3, 'Panci lionstar sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('425', 'Panci matahari', './images/Panci.png', 75000, 4, 5, 'Panci matahari sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('426', 'Kursi krisbow', './images/Kursi.png', 15000, 4, 17, 'Kursi kribow sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('427', 'Kursi olympic', './images/Kursi.png', 20000, 4, 13, 'Kursi olyimpic sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('428', 'Kursi index', './images/Kursi.png', 25000, 4, 10, 'Kursi index sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('429', 'Kursi lionstar', './images/Kursi.png', 20000, 4, 12, 'Kursi lionstar sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('430', 'Kursi matahari', './images/Kursi.png', 17000, 4, 16, 'Kursi matahari sangat awet, sangat bagus, cocok untuk keharmonisan rumah tangga anda', 10),
('501', 'raket lingling', './images/Raket.png', 1000000, 5, 9, 'raket merk lingling sangat bagus antimaling', 10),
('502', 'raket yonex', './images/Raket.png', 1500000, 5, 6, 'raket merk yonex sangat bagus antimaling', 10),
('503', 'raket wilson', './images/Raket.png', 17500000, 5, 5, 'raket merk wilson sangat bagus antimaling', 10),
('504', 'raket astec', './images/Raket.png', 1800000, 5, 3, 'raket merk astec sangat bagus antimaling', 10),
('505', 'raket flypower', './images/Raket.png', 1200000, 5, 2, 'raket merk flypower sangat bagus antimaling', 10),
('506', 'sepatu badminton lingling', './images/SepatuBadminton.png', 100000, 5, 4, 'sepatu badminton merk lingling sangat bagus antimaling', 10),
('507', 'sepatu badminton yonex', './images/SepatuBadminton.png', 150000, 5, 2, 'sepatu badminton merk yonex sangat bagus antimaling', 10),
('508', 'sepatu badminton wilson', './images/SepatuBadminton.png', 1750000, 5, 1, 'sepatu badminton merk wilson sangat bagus antimaling', 10),
('509', 'sepatu badminton astec', './images/SepatuBadminton.png', 180000, 5, 0, 'sepatu badminton merk astec sangat bagus antimaling', 10),
('510', 'sepatu badminton flypower', './images/SepatuBadminton.png', 120000, 5, 11, 'sepatu badminton merk flypower sangat bagus antimaling', 10),
('511', 'shuttle cock lingling', './images/ShuttleCock.png', 10000, 5, 9, 'shuttle cock merk lingling sangat bagus antimaling', 10),
('512', 'shuttle cock yonex', './images/ShuttleCock.png', 15100, 5, 6, 'shuttle cock merk yonex sangat bagus antimaling', 10),
('513', 'shuttle cock wilson', './images/ShuttleCock.png', 17500, 5, 5, 'shuttle cock merk wilson sangat bagus antimaling', 10),
('514', 'shuttle cock astec', './images/ShuttleCock.png', 18000, 5, 3, 'shuttle cock merk astec sangat bagus antimaling', 10),
('515', 'shuttle cock flypower', './images/ShuttleCock.png', 12000, 5, 2, 'shuttle cock merk flypower sangat bagus antimaling', 10),
('516', 'senar raket lingling', './images/SenarRaket.png', 40000, 5, 4, 'senar raket merk lingling sangat bagus antimaling', 10),
('517', 'senar raket yonex', './images/SenarRaket.png', 50000, 5, 2, 'senar raket merk yonex sangat bagus antimaling', 10),
('518', 'senar raket wilson', './images/SenarRaket.png', 70000, 5, 1, 'senar raket merk wilson sangat bagus antimaling', 10),
('519', 'senar raket astec', './images/SenarRaket.png', 80000, 5, 0, 'senar raket merk astec sangat bagus antimaling', 10),
('520', 'senar raket flypower', './images/SenarRaket.png', 90000, 5, 11, 'senar raket merk flypower sangat bagus antimaling', 10),
('521', 'sepatu futsal lingling', './images/SepatuFutsal.png', 300000, 5, 9, 'sepatu futsal merk lingling sangat bagus antimaling', 10),
('522', 'sepatu futsal yonex', './images/SepatuFutsal.png', 452000, 5, 6, 'sepatu futsal merk yonex sangat bagus antimaling', 10),
('523', 'sepatu futsal wilson', './images/SepatuFutsal.png', 520000, 5, 5, 'sepatu futsal merk wilson sangat bagus antimaling', 10),
('524', 'sepatu futsal astec', './images/SepatuFutsal.png', 800000, 5, 3, 'sepatu futsal merk astec sangat bagus antimaling', 10),
('525', 'sepatu futsal flypower', './images/SepatuFutsal.png', 200000, 5, 2, 'sepatu futsal merk flypower sangat bagus antimaling', 10),
('526', 'bola lingling', './images/Bola.png', 40000, 5, 5, 'bola merk lingling sangat bagus antimaling', 10),
('527', 'bola yonex', './images/Bola.png', 50000, 5, 4, 'bola merk yonex sangat bagus antimaling', 10),
('528', 'bola wilson', './images/Bola.png', 70000, 5, 3, 'bola merk wilson sangat bagus antimaling', 10),
('529', 'bola astec', './images/Bola.png', 80000, 5, 2, 'bola merk astec sangat bagus antimaling', 10),
('530', 'bola flypower', './images/Bola.png', 90000, 5, 1, 'bola merk flypower sangat bagus antimaling', 10);

-- --------------------------------------------------------

--
-- Table structure for table `creditcard`
--

CREATE TABLE IF NOT EXISTS `creditcard` (
  `card_id` int(11) NOT NULL,
  `card_nameon` varchar(100) NOT NULL,
  `card_expdate` datetime NOT NULL,
  `card_owner` varchar(50) NOT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `creditcard`
--

INSERT INTO `creditcard` (`card_id`, `card_nameon`, `card_expdate`, `card_owner`) VALUES
(123111, 'Yogi Salomo Mangontang Pratama', '2013-10-23 00:00:00', 'codename'),
(123355, 'pya pya', '2014-01-01 00:00:00', 'codename');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(25) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(30) NOT NULL,
  `handphone` int(15) NOT NULL,
  `address` varchar(40) NOT NULL,
  `province` text NOT NULL,
  `state` text NOT NULL,
  `postcode` int(10) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabel Anggota Website';

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `nama_lengkap`, `password`, `email`, `handphone`, `address`, `province`, `state`, `postcode`) VALUES
('banggapardana', 'Gerangga Anggaparaldi', 'tangga', 'tangga@bangga.com', 0, '', '', '', 0),
('codename', 'Yogi Salomo Mangontang Pratama', '12345678', 'itu@gimal.com', 12, 'sana', 'sini', 'situ', 12345),
('fathan', 'Fathan Adi', '123', 'fathan@gmail.com', 12345, 'beke', 'keke', 'okok', 1111),
('pya', 'pya pya', 'pya', '1@2.com', 987, 'sana', 'sini', 'keca', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
