-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: cm
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `seatId` bigint(20) NOT NULL AUTO_INCREMENT,
  `seatName` varchar(4) DEFAULT NULL,
  `seatStatus` tinyint(1) DEFAULT NULL,
  `scheduleId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`seatId`),
  KEY `fk_schedule` (`scheduleId`),
  CONSTRAINT `fk_schedule` FOREIGN KEY (`scheduleId`) REFERENCES `schedules` (`scheduleId`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,'A1',0,1),(2,'A2',0,1),(3,'A3',0,1),(4,'A4',0,1),(5,'A5',0,1),(6,'A6',0,1),(7,'A7',0,1),(8,'A8',0,1),(9,'A9',0,1),(10,'A10',0,1),(11,'B1',0,1),(12,'B2',0,1),(13,'B3',0,1),(14,'B4',0,1),(15,'B5',0,1),(16,'B6',0,1),(17,'B7',0,1),(18,'B8',0,1),(19,'B9',0,1),(20,'B10',0,1),(21,'C1',0,1),(22,'C2',0,1),(23,'C3',0,1),(24,'C4',0,1),(25,'C5',0,1),(26,'C6',0,1),(27,'C7',0,1),(28,'C8',0,1),(29,'C9',0,1),(30,'C10',0,1),(31,'D1',0,1),(32,'D2',0,1),(33,'D3',0,1),(34,'D4',0,1),(35,'D5',0,1),(36,'D6',0,1),(37,'D7',0,1),(38,'D8',0,1),(39,'D9',0,1),(40,'D10',0,1),(41,'E1',0,1),(72,'E2',0,1),(73,'E3',0,1),(74,'E4',0,1),(75,'E5',0,1),(76,'E6',0,1),(77,'E7',0,1),(78,'E8',0,1),(79,'E9',0,1),(80,'E10',0,1);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-17 15:19:47
