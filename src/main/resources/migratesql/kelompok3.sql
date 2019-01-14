/*
SQLyog Professional v12.5.1 (32 bit)
MySQL - 10.1.13-MariaDB : Database - kelompok3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kelompok3` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `kelompok3`;

/*Table structure for table `anjing` */

DROP TABLE IF EXISTS `anjing`;

CREATE TABLE `anjing` (
  `id_anjing` int(2) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) NOT NULL,
  `jenis` enum('pitbul','husky','pug','buldog','chow chow','pudel') NOT NULL,
  `kebiasaan` varchar(25) NOT NULL,
  PRIMARY KEY (`id_anjing`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `anjing` */

insert  into `anjing`(`id_anjing`,`nama`,`jenis`,`kebiasaan`) values 
(1,'Roger','husky','ngupil'),
(2,'Kimmi','pug','mencuri'),
(3,'Layla','pudel','menabung');

/*Table structure for table `narasi` */

DROP TABLE IF EXISTS `narasi`;

CREATE TABLE `narasi` (
  `id_narasi` int(11) NOT NULL AUTO_INCREMENT,
  `id_anjing` int(2) DEFAULT NULL,
  `id_obat` int(11) DEFAULT NULL,
  `id_smartphone` int(5) DEFAULT NULL,
  `id_tentara` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_narasi`),
  KEY `id_anjing` (`id_anjing`),
  KEY `id_obat` (`id_obat`),
  KEY `id_smartphone` (`id_smartphone`),
  KEY `id_tentara` (`id_tentara`),
  CONSTRAINT `narasi_ibfk_1` FOREIGN KEY (`id_anjing`) REFERENCES `anjing` (`id_anjing`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `narasi_ibfk_2` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `narasi_ibfk_3` FOREIGN KEY (`id_smartphone`) REFERENCES `smartphone` (`smartphone_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `narasi_ibfk_4` FOREIGN KEY (`id_tentara`) REFERENCES `tentara` (`id_tentara`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `narasi` */

insert  into `narasi`(`id_narasi`,`id_anjing`,`id_obat`,`id_smartphone`,`id_tentara`) values 
(1,1,3,6,2),
(2,2,1,9,3),
(3,3,4,6,1);

/*Table structure for table `obat` */

DROP TABLE IF EXISTS `obat`;

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL AUTO_INCREMENT,
  `nama_obat` varchar(255) DEFAULT NULL,
  `dosis` varchar(255) DEFAULT NULL,
  `Keterangan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_obat`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `obat` */

insert  into `obat`(`id_obat`,`nama_obat`,`dosis`,`Keterangan`) values 
(1,'Antangin','3X Sehari','Untuk Meredakan Masuk Angin'),
(2,'Bodrex','2X Sehari','Untuk meringankan Sakit Kepala'),
(3,'Salompas','1X Sehari','Untuk mengobati Hati'),
(4,'Kiranti','2X Sehari','Untuk Datang Bulan');

/*Table structure for table `smartphone` */

DROP TABLE IF EXISTS `smartphone`;

CREATE TABLE `smartphone` (
  `smartphone_id` int(5) NOT NULL AUTO_INCREMENT,
  `merk` varchar(25) NOT NULL,
  `type` varchar(25) NOT NULL,
  `ram` int(2) NOT NULL,
  `camera` int(2) NOT NULL,
  PRIMARY KEY (`smartphone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `smartphone` */

insert  into `smartphone`(`smartphone_id`,`merk`,`type`,`ram`,`camera`) values 
(3,'Nokia','6',4,2),
(4,'Nokia','5',2,2),
(5,'Nokia','3',4,1),
(6,'Nokia','2',2,1),
(7,'Nokia','8',6,2),
(8,'Iphone','X',8,2),
(9,'Asus','Zenfone 8',16,3),
(10,'Motrolla','E3 Power',4,2);

/*Table structure for table `tentara` */

DROP TABLE IF EXISTS `tentara`;

CREATE TABLE `tentara` (
  `id_tentara` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `matra` varchar(255) NOT NULL,
  `pangkat` varchar(255) NOT NULL,
  PRIMARY KEY (`id_tentara`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tentara` */

insert  into `tentara`(`id_tentara`,`nama`,`matra`,`pangkat`) values 
(1,'Ucok','Angkatan Udara','Kapten'),
(2,'Asep','Angkatan Laut','Mayor'),
(3,'Tono','Angkatan Darat','Kolonel');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
