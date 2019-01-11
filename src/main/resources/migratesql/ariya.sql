-- MySQL dump 10.16  Distrib 10.1.30-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: boothcamp
-- ------------------------------------------------------
-- Server version	10.1.30-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `motor`
--
CREATE SCHEMA IF NOT EXISTS boothcamp;

DROP TABLE IF EXISTS `motor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motor` (
  `id_motor` int(15) NOT NULL AUTO_INCREMENT,
  `merk_motor` varchar(255) NOT NULL,
  `nama_motor` varchar(255) NOT NULL,
  `harga` int(15) NOT NULL,
  PRIMARY KEY (`id_motor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motor`
--

LOCK TABLES `motor` WRITE;
/*!40000 ALTER TABLE `motor` DISABLE KEYS */;
INSERT INTO `motor` VALUES (1,'Yamaha','Mio Fino',18400000),(2,'Honda','CBR150R',45000000);
/*!40000 ALTER TABLE `motor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pembeli`
--

DROP TABLE IF EXISTS `pembeli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pembeli` (
  `id_pembeli` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pembeli` varchar(255) NOT NULL,
  `pekerjaan` varchar(255) DEFAULT NULL,
  `alamat` text,
  PRIMARY KEY (`id_pembeli`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pembeli`
--

LOCK TABLES `pembeli` WRITE;
/*!40000 ALTER TABLE `pembeli` DISABLE KEYS */;
INSERT INTO `pembeli` VALUES (1,'Ariya Agustian','Wiraswasta','Jl. Babakan Tarogong');
/*!40000 ALTER TABLE `pembeli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_pembeli` int(11) NOT NULL,
  `id_motor` int(11) NOT NULL,
  `tanggal_pembelian` date NOT NULL,
  `jumlah_pembelian` int(11) NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `id_motor` (`id_motor`),
  KEY `id_pembeli` (`id_pembeli`),
  CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_motor`) REFERENCES `motor` (`id_motor`),
  CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksi`
--

LOCK TABLES `transaksi` WRITE;
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` VALUES (1,1,1,'2018-08-04',5),(2,1,2,'2019-04-01',1);
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'boothcamp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-11 10:31:42
