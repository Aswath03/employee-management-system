-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: ems
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.22-MariaDB-0ubuntu0.22.04.1-log

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) NOT NULL,
  `reporting_manager_id` int(11) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `salary` decimal(14,2) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `role` varchar(300) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `bonus_percentage` decimal(14,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (3,1,NULL,'Admin','2000-08-30',75000.00,'Thiruvalla','Software Developer','2022-06-01',10.50),(4,3,NULL,'Admin1','2000-08-30',75000.00,'Tvm','Software Developer','2022-06-01',10.50),(5,4,NULL,'Admin3','2000-08-30',75000.00,'Mallapuram','Software Developer','2022-06-01',10.50),(6,5,NULL,'Admin3','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(7,6,NULL,'Admin4','1997-08-30',75000.00,'Kannur','Software Developer','2022-06-01',10.50),(8,7,NULL,'Admin5','1997-08-30',75000.00,'Kozhikode','HR','2022-06-01',10.50),(9,1,3,'Budget Dev 1','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(10,1,3,'Budget Dev 2','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(11,1,3,'Budget Dev 3','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(12,1,3,'Budget Dev 4','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(13,3,4,'Bill Dev 1','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(14,3,4,'Bill Dev 2','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(15,3,4,'Bill Dev 3','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(16,3,4,'Bill Dev 4','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(17,4,5,'Treasury Dev 1','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(18,4,5,'Treasury Dev 2','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(19,4,5,'Treasury Dev 3','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(20,4,5,'Treasury Dev 4','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(21,5,6,'Accounts Dev 1','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(22,5,6,'Accounts Dev 2','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(23,5,6,'Accounts Dev 3','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(24,5,6,'Accounts Dev 4','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(25,6,7,'Ceiling Dev 1','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(26,6,7,'Ceiling Dev 2','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(27,6,7,'Ceiling Dev 3','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(28,6,7,'Ceiling Dev 4','1997-08-30',75000.00,'Kerala','Software Developer','2022-06-01',10.50),(29,7,8,'HR 1','1997-08-30',75000.00,'Kerala','Hr Trainee','2022-06-01',10.50),(30,7,8,'HR 2','1997-08-30',75000.00,'Kerala','Hr Trainee','2022-06-01',10.50),(31,7,8,'HR 3','1997-08-30',75000.00,'Kerala','Hr Trainee','2022-06-01',10.50),(32,7,8,'HR 4','1997-08-30',75000.00,'Kerala','Hr Trainee','2022-06-01',10.50),(34,7,8,'HR 5','1997-08-30',75000.00,'Kerala','Hr Trainee','2022-06-01',10.50);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-03 20:12:38
