-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: isa-jee-auth
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `CarData`
--
USE isa-jee-auth;

DROP TABLE IF EXISTS `CarData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CarData` (
  `carID` int(11) NOT NULL,
  `capacity` varchar(255) DEFAULT NULL,
  `fuel` varchar(255) DEFAULT NULL,
  `ownerId` int(11) NOT NULL,
  `power` varchar(255) DEFAULT NULL,
  `prodYear` int(11) NOT NULL,
  `registryNumber` varchar(255) DEFAULT NULL,
  `vehicleMake` varchar(255) DEFAULT NULL,
  `vehicleModel` varchar(255) DEFAULT NULL,
  `vehicleVariant` varchar(255) DEFAULT NULL,
  `vehicleVersion` varchar(255) DEFAULT NULL,
  `vin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`carID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CarData`
--

LOCK TABLES `CarData` WRITE;
/*!40000 ALTER TABLE `CarData` DISABLE KEYS */;
INSERT INTO `CarData` VALUES (1,'1968,00cm3','D',3,'103,00KW',2007,'NOL 66WJ','MITSUBISHI','OUTLANDER','CW821','ABAAA6A6A','JMBXJCW8W7Z903938'),(2,'2477','Diesel',3,'75',2018,'NOL100','MITSUBISHI','ADVENTURE','2.5 D','---','VINNUMBER'),(3,'2477','Diesel',3,'75',2018,'NOL100','MITSUBISHI','ADVENTURE','2.5 D','---','VINNUMBER'),(4,'1368,00cm3','Petrol',3,'123,00KW',2016,'W','ABARTH','500 (312)','1.4','---','W'),(5,'7003,00cm3','Petrol',3,'257,00KW',1972,'FDSFS','AC','428 Fastback','7.0','---','FDF'),(6,'1368,00cm3','Petrol',3,'125,00KW',2016,'DSD','ABARTH','124 Spider (348_) (US)','1.4','---','DSD'),(7,'6211,00cm3','Diesel',3,'116,00KW',1993,'DFC','AM GENERAL','HUMMER Closed Off-Road Vehicle (US)','6.2 D 4WD','---','DF'),(8,'90,00cm3','Petrol',3,'5,00KW',1998,'fghj','AGRALE MOTORCYCLES','CITY','City 90','---','sdfgh'),(9,'1998,00cm3','Petrol',3,'104,00KW',1993,'','INFINITI','G20','2.0','---',''),(10,'4748,00cm3','Diesel',3,'121,00KW',2012,'','AGRALE','10-Series','10000 S','','');
/*!40000 ALTER TABLE `CarData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (11);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_login` varchar(64) DEFAULT NULL,
  `user_role` varchar(64) DEFAULT NULL,
  `role_group` varchar(64) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'adminUser','admin','admin',2),(3,'admin','admin','admin',3);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(64) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'adminUser','0192023a7bbd73250516f069df18b500','majkel','majkel','a@a.com'),(3,'admin','21232f297a57a5a743894a0e4a801fc3','majkel','majkel','b@b.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-18  0:31:41
