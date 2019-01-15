-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 15, 2019 at 09:07 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.39

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tni`
--

-- --------------------------------------------------------

--
-- Table structure for table `batalyon`
--

CREATE TABLE `batalyon` (
  `id_batalyon` bigint(20) NOT NULL,
  `nama_batalyon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batalyon`
--

INSERT INTO `batalyon` (`id_batalyon`, `nama_batalyon`) VALUES
(1, 'Kompi A'),
(2, 'Kompi B');

-- --------------------------------------------------------

--
-- Table structure for table `tentara`
--

CREATE TABLE `tentara` (
  `id_tentara` bigint(20) NOT NULL,
  `nama_tentara` varchar(255) NOT NULL,
  `pangkat` varchar(255) NOT NULL,
  `matra` varchar(255) NOT NULL,
  `is_perwira` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tentara`
--

INSERT INTO `tentara` (`id_tentara`, `nama_tentara`, `pangkat`, `matra`, `is_perwira`) VALUES
(1, 'Joni', 'kolonel', 'Angkatan Darat', b'1'),
(2, 'elsa', 'sersan', 'Angkatan Laut', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `tentara_aktif`
--

CREATE TABLE `tentara_aktif` (
  `id_tentara_aktif` bigint(20) NOT NULL,
  `status_tentara` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tentara_aktif`
--

INSERT INTO `tentara_aktif` (`id_tentara_aktif`, `status_tentara`) VALUES
(1, 'aktif'),
(2, 'nonaktif');

-- --------------------------------------------------------

--
-- Table structure for table `tni`
--

CREATE TABLE `tni` (
  `id_tni` bigint(20) NOT NULL,
  `id_tentara` bigint(20) NOT NULL,
  `id_batalyon` bigint(20) NOT NULL,
  `id_tentara_aktif` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tni`
--

INSERT INTO `tni` (`id_tni`, `id_tentara`, `id_batalyon`, `id_tentara_aktif`) VALUES
(2, 2, 2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `batalyon`
--
ALTER TABLE `batalyon`
  ADD PRIMARY KEY (`id_batalyon`);

--
-- Indexes for table `tentara`
--
ALTER TABLE `tentara`
  ADD PRIMARY KEY (`id_tentara`);

--
-- Indexes for table `tentara_aktif`
--
ALTER TABLE `tentara_aktif`
  ADD PRIMARY KEY (`id_tentara_aktif`);

--
-- Indexes for table `tni`
--
ALTER TABLE `tni`
  ADD PRIMARY KEY (`id_tni`),
  ADD KEY `fk_tni_tentara` (`id_tentara`),
  ADD KEY `fk_tni_tentaraaktif` (`id_tentara_aktif`),
  ADD KEY `fk_tni_batalyon` (`id_batalyon`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `batalyon`
--
ALTER TABLE `batalyon`
  MODIFY `id_batalyon` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tentara`
--
ALTER TABLE `tentara`
  MODIFY `id_tentara` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tentara_aktif`
--
ALTER TABLE `tentara_aktif`
  MODIFY `id_tentara_aktif` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tni`
--
ALTER TABLE `tni`
  MODIFY `id_tni` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tni`
--
ALTER TABLE `tni`
  ADD CONSTRAINT `fk_tni_batalyon` FOREIGN KEY (`id_batalyon`) REFERENCES `batalyon` (`id_batalyon`),
  ADD CONSTRAINT `fk_tni_tentara` FOREIGN KEY (`id_tentara`) REFERENCES `tentara` (`id_tentara`),
  ADD CONSTRAINT `fk_tni_tentaraaktif` FOREIGN KEY (`id_tentara_aktif`) REFERENCES `tentara_aktif` (`id_tentara_aktif`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
