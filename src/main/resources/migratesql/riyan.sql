-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jan 2019 pada 08.23
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_boothcamp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `boothcamp`
--

CREATE TABLE `boothcamp` (
  `id_boothcamp` int(5) NOT NULL,
  `nama_boothcamp` varchar(255) NOT NULL,
  `lokasi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `boothcamp`
--

INSERT INTO `boothcamp` (`id_boothcamp`, `nama_boothcamp`, `lokasi`) VALUES
(1, 'Indonesia Android Kejar', 'UNIKOM'),
(2, 'Born to Protect', 'UNPAS'),
(3, 'Java Developer Boothcamp Multipolar', 'UNIKOM');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `boothcamp`
--
ALTER TABLE `boothcamp`
  ADD PRIMARY KEY (`id_boothcamp`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `boothcamp`
--
ALTER TABLE `boothcamp`
  MODIFY `id_boothcamp` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
