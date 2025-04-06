-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: instapark
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records` (
  `location` varchar(45) NOT NULL,
  `locNumber` varchar(45) NOT NULL,
  `Date` varchar(45) NOT NULL,
  `In-Time` varchar(45) NOT NULL,
  `Time duration` varchar(45) NOT NULL,
  `Vehicle Type` varchar(45) NOT NULL,
  `VehicleNumber` varchar(45) NOT NULL,
  PRIMARY KEY (`VehicleNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
INSERT INTO `records` VALUES ('imcc college','10','04/Dec/2023','10:24:38 AM','5hr','2 - Wheeler','1234'),('campus','10','01/Dec/2023','11:47:15 AM','1hr','2 - Wheeler','1234565'),('suryadatta college','15','04/Dec/2023','10:32:24 AM','7hr','2 - Wheeler','4568789'),('MIT kothrud campus','50','04/Dec/2023','10:33:28 AM','5hr','2 - Wheeler','45687890'),('campus','10','04/Dec/2023','10:26:17 AM','','4-Wheeler','541216'),('imcc college','15','05/Dec/2023','09:32:13 PM','','2 - Wheeler','adfa'),('campus','20','15/Dec/2023','07:41:36 PM','','4-Wheeler','MH-1234'),('MIT kothrud campus','15','02/Dec/2023','12:45:52 AM','1hr','2 - Wheeler','mh-18-3536'),('campus','15','15/Dec/2023','01:23:44 PM','','2 - Wheeler','mh-523648'),('imcc college','15','13/Dec/2023','04:49:51 PM','','2 - Wheeler','mh14-2546'),('imcc college','15','02/Dec/2023','09:25:09 AM','3hr','2 - Wheeler','mh35-6589');
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15 23:33:15
