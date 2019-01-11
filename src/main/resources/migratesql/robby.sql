-- MySQL dump 10.16  Distrib 10.1.25-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: learn_komputer
-- ------------------------------------------------------
-- Server version	10.1.25-MariaDB

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
-- Table structure for table `komputer`
--

DROP TABLE IF EXISTS `komputer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `komputer` (
  `id_komputer` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `procie` varchar(255) NOT NULL,
  `mobo` varchar(255) NOT NULL,
  `memory` varchar(255) NOT NULL,
  `monitor` varchar(255) DEFAULT NULL,
  `key_mouse` bit(1) NOT NULL,
  `id_tipe` int(1) NOT NULL,
  `tanggal_bangun` date NOT NULL,
  PRIMARY KEY (`id_komputer`),
  KEY `fk_idTipe` (`id_tipe`),
  CONSTRAINT `fk_idTipe` FOREIGN KEY (`id_tipe`) REFERENCES `tipe` (`id_tipe`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `komputer`
--

LOCK TABLES `komputer` WRITE;
/*!40000 ALTER TABLE `komputer` DISABLE KEYS */;
INSERT INTO `komputer` VALUES (1,'workstation1','intel i3','asus','4GB','14\"','',2,'2018-01-01'),(2,'workstation2','intel i3','msi','4GB','14\"','',2,'2018-01-02'),(3,'workstation3','intel i3','ecs','8GB','17\"','',2,'2018-01-03'),(4,'workstation4','intel i3','ecs','8GB','17\"','',2,'2018-01-04'),(5,'server1','xeon e3','intel','64GB',NULL,'\0',1,'2018-01-01'),(6,'server2','xeon e3','intel','64GB',NULL,'\0',1,'2018-01-02'),(7,'server3','xeon e5','intel','128GB',NULL,'\0',1,'2018-01-03'),(8,'server4','xeon e5','intel','128GB',NULL,'\0',1,'2018-01-04'),(9,'gaming1','ryzen 5','asus','8GB','22\"','',3,'2018-01-01'),(10,'gaming2','ryzen 5','asus','8GB','22\"','',3,'2018-01-02'),(11,'gaming3','ryzen 7','gigabyte','8GB','24\"','',3,'2018-01-03'),(12,'gaming4','ryzen 7','gigabyte','8GB','24\"','',3,'2018-01-04'),(13,'workstation5','intel i7','asus','4GB','14\"','',2,'2018-01-05'),(14,'workstation6','intel i7','msi','4GB','14\"','',2,'2018-01-06'),(15,'workstation7','intel i5','ecs','8GB','17\"','',2,'2018-01-07'),(16,'workstation8','intel i5','ecs','8GB','17\"','',2,'2018-01-08'),(17,'server5','xeon e3','intel','64GB',NULL,'\0',1,'2018-01-05'),(18,'server6','xeon e3','intel','64GB',NULL,'\0',1,'2018-01-06'),(19,'server7','xeon e5','intel','128GB',NULL,'\0',1,'2018-01-07'),(20,'server8','xeon e5','intel','128GB',NULL,'\0',1,'2018-01-08'),(21,'gaming5','ryzen 5','asus','8GB','22\"','',3,'2018-01-05'),(22,'gaming6','ryzen 5','asus','16GB','22\"','',3,'2018-01-06'),(23,'gaming7','ryzen 7','gigabyte','32GB','24\"','',3,'2018-01-07'),(24,'gaming8','ryzen 7','gigabyte','32GB','24\"','',3,'2018-01-08');
/*!40000 ALTER TABLE `komputer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pemilik`
--

DROP TABLE IF EXISTS `pemilik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pemilik` (
  `id_pemilik` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `id_komputer` int(11) NOT NULL,
  PRIMARY KEY (`id_pemilik`),
  KEY `fk_idKomputer` (`id_komputer`),
  CONSTRAINT `fk_idKomputer` FOREIGN KEY (`id_komputer`) REFERENCES `komputer` (`id_komputer`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pemilik`
--

LOCK TABLES `pemilik` WRITE;
/*!40000 ALTER TABLE `pemilik` DISABLE KEYS */;
INSERT INTO `pemilik` VALUES (1,'Agus',1),(2,'Asep',2),(3,'Ado',3),(4,'Andi',4),(5,'Abi',5),(6,'Aldi',6),(7,'Aldo',7),(8,'bagus',8),(9,'Basil',9),(10,'Burhan',10);
/*!40000 ALTER TABLE `pemilik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipe`
--

DROP TABLE IF EXISTS `tipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipe` (
  `id_tipe` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  PRIMARY KEY (`id_tipe`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipe`
--

LOCK TABLES `tipe` WRITE;
/*!40000 ALTER TABLE `tipe` DISABLE KEYS */;
INSERT INTO `tipe` VALUES (1,'server'),(2,'workstation'),(3,'gaming');
/*!40000 ALTER TABLE `tipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'learn_komputer'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-11 13:17:53
