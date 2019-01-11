-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 11 Jan 2019 pada 05.03
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_burung`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `burung`
--

CREATE TABLE `burung` (
  `id_burung` int(11) NOT NULL,
  `id_merpati` int(11) NOT NULL,
  `id_elang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `burung`
--

INSERT INTO `burung` (`id_burung`, `id_merpati`, `id_elang`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `elang`
--

CREATE TABLE `elang` (
  `id_elang` int(11) NOT NULL,
  `nama_elang` varchar(50) NOT NULL,
  `warna_elang` varchar(40) NOT NULL,
  `paruh_elang` varchar(40) NOT NULL,
  `tgl_elang` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `elang`
--

INSERT INTO `elang` (`id_elang`, `nama_elang`, `warna_elang`, `paruh_elang`, `tgl_elang`) VALUES
(1, 'Elang Jawa', 'Coklat', 'Kuat, Tajam', '2019-01-10');

-- --------------------------------------------------------

--
-- Struktur dari tabel `merpati`
--

CREATE TABLE `merpati` (
  `id_merpati` int(11) NOT NULL,
  `nama_merpati` varchar(50) NOT NULL,
  `warna_merpati` varchar(40) NOT NULL,
  `paruh_merpati` varchar(40) NOT NULL,
  `tgl_merpati` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `merpati`
--

INSERT INTO `merpati` (`id_merpati`, `nama_merpati`, `warna_merpati`, `paruh_merpati`, `tgl_merpati`) VALUES
(1, 'Merpati ODC', 'Abu putih', 'Runcing, Kecil', '2019-01-10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `burung`
--
ALTER TABLE `burung`
  ADD PRIMARY KEY (`id_burung`);

--
-- Indexes for table `elang`
--
ALTER TABLE `elang`
  ADD PRIMARY KEY (`id_elang`);

--
-- Indexes for table `merpati`
--
ALTER TABLE `merpati`
  ADD PRIMARY KEY (`id_merpati`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `burung`
--
ALTER TABLE `burung`
  MODIFY `id_burung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `elang`
--
ALTER TABLE `elang`
  MODIFY `id_elang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `merpati`
--
ALTER TABLE `merpati`
  MODIFY `id_merpati` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `burung`
--
ALTER TABLE `burung`
  ADD CONSTRAINT `burung_ibfk_1` FOREIGN KEY (`id_burung`) REFERENCES `merpati` (`id_merpati`),
  ADD CONSTRAINT `burung_ibfk_2` FOREIGN KEY (`id_burung`) REFERENCES `elang` (`id_elang`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
