-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema arabakiralama
--

CREATE DATABASE IF NOT EXISTS arabakiralama;
USE arabakiralama;

--
-- Definition of table `arabalar`
--

DROP TABLE IF EXISTS `arabalar`;
CREATE TABLE `arabalar` (
  `Arabaid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Afiyat` int(10) unsigned NOT NULL,
  `Marka` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  `ModelYili` int(10) unsigned NOT NULL,
  `Yakit` varchar(45) NOT NULL,
  `Sinif` varchar(45) NOT NULL,
  `Renk` varchar(45) NOT NULL,
  `Vites` varchar(45) NOT NULL,
  PRIMARY KEY (`Arabaid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `arabalar`
--

/*!40000 ALTER TABLE `arabalar` DISABLE KEYS */;
INSERT INTO `arabalar` (`Arabaid`,`Afiyat`,`Marka`,`Model`,`ModelYili`,`Yakit`,`Sinif`,`Renk`,`Vites`) VALUES 
 (1,2500,'Audi','Q7',1993,'dizel','a','beyaz','5');
/*!40000 ALTER TABLE `arabalar` ENABLE KEYS */;


--
-- Definition of table `kiralama`
--

DROP TABLE IF EXISTS `kiralama`;
CREATE TABLE `kiralama` (
  `kiralamaid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ad` varchar(45) NOT NULL,
  `Soyad` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Telefon` int(10) unsigned NOT NULL,
  `BaslangicTarihi` varchar(45) NOT NULL,
  `BitisTarihi` varchar(45) NOT NULL,
  PRIMARY KEY (`kiralamaid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kiralama`
--

/*!40000 ALTER TABLE `kiralama` DISABLE KEYS */;
INSERT INTO `kiralama` (`kiralamaid`,`Ad`,`Soyad`,`Email`,`Telefon`,`BaslangicTarihi`,`BitisTarihi`) VALUES 
 (1,'Talha','Badik','talha559@',552,'12.05.2008','13.05.2008'),
 (2,'Talha','Badik','talha559@',552,'12.05.2008','13.05.2008'),
 (3,'asas','asdsa','talha559@gmail.com',545,'12.24.45','12.24.45');
/*!40000 ALTER TABLE `kiralama` ENABLE KEYS */;


--
-- Definition of table `kullanici`
--

DROP TABLE IF EXISTS `kullanici`;
CREATE TABLE `kullanici` (
  `kid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `KullaniciAdi` varchar(45) NOT NULL,
  `Sifre` varchar(45) NOT NULL,
  `KAdi` varchar(45) NOT NULL,
  `KSadi` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Yetki` int(10) unsigned NOT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kullanici`
--

/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` (`kid`,`KullaniciAdi`,`Sifre`,`KAdi`,`KSadi`,`Email`,`Yetki`) VALUES 
 (1,'admin','admin','Admin','Admin','admin@admin.com.tr',1),
 (2,'talhabadik','1234','Talha','Badik','talha559@gmail.com',0);
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
