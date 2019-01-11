-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jan 2019 pada 09.07
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
-- Database: `kelompok2`
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

-- --------------------------------------------------------

--
-- Struktur dari tabel `komputer`
--

CREATE TABLE `komputer` (
  `id_komputer` int(5) NOT NULL,
  `nama_komputer` varchar(255) NOT NULL,
  `merk_komputer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `komputer`
--

INSERT INTO `komputer` (`id_komputer`, `nama_komputer`, `merk_komputer`) VALUES
(1, 'ASUS GL505VD', 'ASUS'),
(2, 'HP BA026AX', 'HP'),
(3, 'Dell Inspiron 14', 'Dell'),
(4, 'Apple Macbook Pro Retina', 'Apple');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobil`
--

CREATE TABLE `mobil` (
  `id_mobil` int(5) NOT NULL,
  `nama_mobil` varchar(255) NOT NULL,
  `merk_mobil` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mobil`
--

INSERT INTO `mobil` (`id_mobil`, `nama_mobil`, `merk_mobil`) VALUES
(1, 'BMW M3', 'BMW'),
(2, 'Honda City', 'Honda'),
(3, 'Honda Accord', 'Honda'),
(4, 'Kijang Innova', 'Toyota');

-- --------------------------------------------------------

--
-- Struktur dari tabel `motor`
--

CREATE TABLE `motor` (
  `id_motor` int(5) NOT NULL,
  `nama_motor` varchar(255) NOT NULL,
  `merk_motor` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `motor`
--

INSERT INTO `motor` (`id_motor`, `nama_motor`, `merk_motor`) VALUES
(1, 'Mio Fino', 'Yamaha'),
(2, 'Mio J', 'Yamaha'),
(3, 'Jupiter MX', 'Yamaha'),
(4, 'Vario 125cc', 'Honda'),
(5, 'Beat Street', 'Honda');

-- --------------------------------------------------------

--
-- Struktur dari tabel `narasi`
--

CREATE TABLE `narasi` (
  `id_narasi` int(5) NOT NULL,
  `id_boothcamp` int(5) NOT NULL,
  `id_motor` int(5) NOT NULL,
  `id_komputer` int(5) NOT NULL,
  `id_mobil` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `narasi`
--

INSERT INTO `narasi` (`id_narasi`, `id_boothcamp`, `id_motor`, `id_komputer`, `id_mobil`) VALUES
(1, 1, 1, 1, 1),
(2, 1, 2, 3, 3),
(3, 1, 5, 4, 1),
(4, 1, 3, 1, 2),
(5, 2, 4, 3, 3),
(6, 2, 2, 4, 4),
(7, 2, 3, 1, 3),
(8, 2, 1, 2, 2),
(9, 2, 3, 2, 1),
(10, 2, 4, 3, 4),
(11, 3, 5, 1, 2),
(12, 3, 2, 1, 1),
(13, 3, 2, 3, 2),
(14, 3, 1, 3, 4),
(15, 1, 4, 4, 3);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `boothcamp`
--
ALTER TABLE `boothcamp`
  ADD PRIMARY KEY (`id_boothcamp`);

--
-- Indeks untuk tabel `komputer`
--
ALTER TABLE `komputer`
  ADD PRIMARY KEY (`id_komputer`);

--
-- Indeks untuk tabel `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id_mobil`);

--
-- Indeks untuk tabel `motor`
--
ALTER TABLE `motor`
  ADD PRIMARY KEY (`id_motor`);

--
-- Indeks untuk tabel `narasi`
--
ALTER TABLE `narasi`
  ADD PRIMARY KEY (`id_narasi`),
  ADD KEY `id_motor` (`id_motor`),
  ADD KEY `id_mobil` (`id_mobil`),
  ADD KEY `id_boothcamp` (`id_boothcamp`),
  ADD KEY `id_komputer` (`id_komputer`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `boothcamp`
--
ALTER TABLE `boothcamp`
  MODIFY `id_boothcamp` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `komputer`
--
ALTER TABLE `komputer`
  MODIFY `id_komputer` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `mobil`
--
ALTER TABLE `mobil`
  MODIFY `id_mobil` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `motor`
--
ALTER TABLE `motor`
  MODIFY `id_motor` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `narasi`
--
ALTER TABLE `narasi`
  MODIFY `id_narasi` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `narasi`
--
ALTER TABLE `narasi`
  ADD CONSTRAINT `narasi_ibfk_1` FOREIGN KEY (`id_motor`) REFERENCES `motor` (`id_motor`),
  ADD CONSTRAINT `narasi_ibfk_2` FOREIGN KEY (`id_mobil`) REFERENCES `mobil` (`id_mobil`),
  ADD CONSTRAINT `narasi_ibfk_3` FOREIGN KEY (`id_boothcamp`) REFERENCES `boothcamp` (`id_boothcamp`),
  ADD CONSTRAINT `narasi_ibfk_4` FOREIGN KEY (`id_komputer`) REFERENCES `komputer` (`id_komputer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
