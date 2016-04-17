-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2016 at 08:53 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_petugas` int(3) NOT NULL,
  `id_ktp` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL,
  `jabatan` varchar(10) NOT NULL,
  `nick` varchar(10) NOT NULL,
  `alamat` varchar(20) NOT NULL,
  `tlp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_petugas`, `id_ktp`, `password`, `jabatan`, `nick`, `alamat`, `tlp`) VALUES
(1, '1301140', 'admin', 'operator', 'Resa', 'Klaten', '09083540934'),
(2, '112233', 'qwerty', 'sopir', 'Paijo', 'Bayat', '08654564567'),
(4, '13400', 'sopir', 'sopir', 'Pahlevi', 'Solo Baru', '08542274532'),
(5, '1301144', 'admin', 'operator', 'Gina', 'Manokwari', '087543456345'),
(6, '1301145', 'admin', 'operator', 'Budi', 'Denpasar', '098453474676');

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id_kendaraan` int(2) NOT NULL,
  `id_polisi` varchar(8) NOT NULL,
  `Nama` varchar(20) NOT NULL,
  `kursi` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`id_kendaraan`, `id_polisi`, `Nama`, `kursi`) VALUES
(1, 'AD6353R', 'Suzuki APV', 6),
(2, 'AD6534SL', 'Suzuki Carry', 8),
(3, 'Ad6452E', 'Suzuki A', 6);

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `id_paket` varchar(10) NOT NULL,
  `nama_paket` varchar(10) NOT NULL,
  `harga` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paket`
--

INSERT INTO `paket` (`id_paket`, `nama_paket`, `harga`) VALUES
('pkg001', 'Rum Indah', 500000),
('Pkg002', 'Rumh', 420000),
('pkg003', 'were', 220000),
('pkg005', 'zxcc', 520000),
('pkg012', 'Rum', 220000);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `idpelanggan` varchar(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `id_ktp` varchar(20) NOT NULL,
  `alamat` varchar(20) NOT NULL,
  `tlp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`idpelanggan`, `nama`, `id_ktp`, `alamat`, `tlp`) VALUES
('plg001', 'Painem', '1301140134', 'Sabrang', '085743324543');

-- --------------------------------------------------------

--
-- Table structure for table `tampung_paket_wisata`
--

CREATE TABLE `tampung_paket_wisata` (
  `id_paket` varchar(10) NOT NULL,
  `id_wisata` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tampung_paket_wisata`
--

INSERT INTO `tampung_paket_wisata` (`id_paket`, `id_wisata`) VALUES
('asd', 0),
('asd', 0),
('Pkg002', 1),
('Pkg002', 2),
('Pkg002', 2),
('pkg003', 1),
('pkg003', 2),
('pkg005', 1),
('pkg005', 2),
('pkg005', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tb_wisata`
--

CREATE TABLE `tb_wisata` (
  `id_wisata` int(2) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `kab` varchar(20) NOT NULL,
  `biaya` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_wisata`
--

INSERT INTO `tb_wisata` (`id_wisata`, `nama`, `kab`, `biaya`) VALUES
(1, 'Sugaya', 'Denpasar', 20000),
(2, 'Subadiyah', 'Klaten', 200000),
(3, 'BuruDeh', 'KarangAsem', 300000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_pejalanan`
--

CREATE TABLE `tr_pejalanan` (
  `id_transaksi` varchar(10) NOT NULL,
  `idpelanggan` varchar(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `id_paket` varchar(10) NOT NULL,
  `tanggal_br` date NOT NULL,
  `id_kendaraan` varchar(10) NOT NULL,
  `id_petugas` varchar(10) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tr_pejalanan`
--

INSERT INTO `tr_pejalanan` (`id_transaksi`, `idpelanggan`, `nama`, `id_paket`, `tanggal_br`, `id_kendaraan`, `id_petugas`, `total`) VALUES
('trx001', '1', 'Resa', 'Rum Indah', '2016-02-02', 'Suzuki APV', 'Paijo', 123),
('trx002', '2', 'Plp', 'Rum Indah', '2016-03-03', 'Suzuki APV', 'Paijo', 123),
('trx003', 'plg001', 'Rsa', 'Rum Indah', '2016-09-09', 'Suzuki APV', 'Paijo', 123),
('tx002', 'plg001', 'Reas', 'Rum Indah', '2016-09-09', 'Suzuki APV', 'Pahlevi', 123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id_kendaraan`);

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`idpelanggan`);

--
-- Indexes for table `tb_wisata`
--
ALTER TABLE `tb_wisata`
  ADD PRIMARY KEY (`id_wisata`);

--
-- Indexes for table `tr_pejalanan`
--
ALTER TABLE `tr_pejalanan`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_petugas` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `id_kendaraan` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_wisata`
--
ALTER TABLE `tb_wisata`
  MODIFY `id_wisata` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
