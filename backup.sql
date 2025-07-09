/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.5.29-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: appdb
-- ------------------------------------------------------
-- Server version	5.6.51

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `appdb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `appdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `appdb`;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `booking_date` varchar(255) DEFAULT NULL,
  `number_of_passengers` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `flight_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FK546eybei9q7dsna94vryofrbr` (`flight_id`),
  KEY `FKkgseyy7t56x7lkjgu3wah5s3t` (`user_id`),
  CONSTRAINT `FK546eybei9q7dsna94vryofrbr` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`flight_id`),
  CONSTRAINT `FKkgseyy7t56x7lkjgu3wah5s3t` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (4,'2025-07-06T18:59:10.545Z',2,'Approved',5,27),(7,'2025-07-06T19:47:31.977Z',0,'Rejected',7,27),(8,'2025-07-06T19:47:31.977Z',5,'Approved',7,27),(9,'2025-07-07T14:16:33.745Z',1,'Rejected',7,30),(10,'2025-07-07T18:54:31.597Z',2,'Rejected',7,27),(11,'2025-07-08T04:39:14.053Z',2,'Approved',1,32);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flight_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `airline` varchar(255) DEFAULT NULL,
  `arrival_location` varchar(255) DEFAULT NULL,
  `arrival_time` varchar(255) DEFAULT NULL,
  `departure_location` varchar(255) DEFAULT NULL,
  `departure_time` varchar(255) DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `total_seats` int(11) NOT NULL,
  PRIMARY KEY (`flight_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'Air India','Mumbai','2024-10-21T15:05','Delhi','2024-10-24T10:03','AI202',7500,77),(5,'Indigo','Lucknow','2025-07-06T14:17','Dublin','2025-07-05T13:15','BK409',167000,120),(7,'Indigo','Mumbai','2025-07-08T13:44','Diu','2025-07-08T12:17','DF340',5600,30),(12,'SpiceJet','Kolkata','2025-07-02T23:43','Bhubaneswar','2025-07-01T23:42','DM890',5600,56);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (26,'demo@example.com','8240115019','$2a$10$eHY1jTbNnyP8qgCBEo56uOCiA6OOWbP3R3y1H.iP/WxhU4ym8w6ZG','Admin','biyasghosh'),(27,'user@gmail.com','8240115019','$2a$10$yFRItYFJBgfDC7wrXY/TnewF1LoMg5KRIbxh3BbtsUJuW0XYAcidq','Traveller','bguser'),(28,'nain@gmail.com','7004794034','$2a$10$TkD8y2pnzRuAoXfxn.LOi.WPI7/Ig6Aee4.UJZT1tdUX.gG9l8yR6','Traveller','nain'),(29,'nain@gmail.com','7004794034','$2a$10$AO56Qtdg6oL17ezK1q.7kewpAyCGFc6lY/WH25v/siCJDYlQmdHvW','Traveller','nain'),(30,'vig@gmail.com','7004794034','$2a$10$axW7wsPkez1IQLN/5dLVE.hy12DA5JRp3b5Oquw/yIpZTtNCxiPs.','Traveller','vig '),(31,'demo12345@example.com','8240115019','$2a$10$skJzXb2CZv8pkW4TssAtNeSRELFaJRD11laESDCMEfAieLp5.MlDy','Admin','demo123'),(32,'biyasghosh290@gmail.com','8240115010','$2a$10$pf/ThDrBIqTRVei2QwtNue4MPWl/nNWjAUAG5urdqn59YPjAQ.Q5q','Traveller','biyas');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-09 18:43:35
