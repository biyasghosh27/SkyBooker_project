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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'Air India','Mumbai','2024-10-21T12:00:00','Delhi','2024-10-21T10:00:00','AI202',7500,75),(2,'Vistara','Bangalore','20:30 PM','London','13:30 PM','45678',3400.23,70),(3,'Vistara','Bangalore','20:30 PM','London','13:30 PM','45678',3400.23,70),(4,'Vistara','Bangalore','20:30 PM','London','13:30 PM','45678',3400.23,70);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'biyas@example.com','9876543210','$2a$10$vdCldw1Eu1KeVNI.ExacheaHoAT3r.EpflEh.m0nzInPv6TWPa5qi','Traveller','bgfh'),(4,'biyassfqwe@example.com','9876543210','$2a$10$YTmDY/U5gjnnM9D9RutV3ujSNs6.ZkZ/qwM10NLDkG0wmeetlWtAm','Traveller','bgfh'),(5,'demo@example.com','9876543210','$2a$10$1ORdKEFDLXTUhzqQCpHR0.b87K0xKy/7QxK/WjPJZJgcmb5ouXuuW','Traveller','demoUser'),(6,'demo@example.com','9876543210','$2a$10$YL7FF5vkAYpaM/38liAB1ePRO1smYulqfBPLClYBVANK6H0P5S6AS','Traveller','demoUser'),(7,'dem32o@example.com','987632543210','$2a$10$yF6r5NJJsbaJ9N9FWzdP3.0S3BxaPYmnZG25..7BxoqtoWP9rkr1C','Traveller','demo32User'),(8,'demo@example.com','8240115019','$2a$10$qQvU5hmWQQ/3JG2CCA9CUevBPwZM6sr1aQsvvTKfXoKbQTAdSQH/y','Traveller','biyasghosh'),(9,'demo@example.com','8240115019','$2a$10$nCojpboLCIiXv665QUM9husYSZt3moqraYB7AEIlTjn6FczFpeGlC','Traveller','biyasghosh'),(10,'demo123@example.com','8240115019','$2a$10$ngCPmz8NfodI8qTMgcmxIO2.khjhsKSR7LnOwJayqqUw4bN24kE.O','Traveller','biyasghosh');
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

-- Dump completed on 2025-07-04  5:23:07
