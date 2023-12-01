-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: online_banking
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  `zipcode` int NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_al4vy84pj6kshsqrsn9kc63sj` (`email`),
  KEY `FKr6i0t96qgu9l8l5nn2vqo8rcl` (`user_id`),
  CONSTRAINT `FKr6i0t96qgu9l8l5nn2vqo8rcl` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_detail`
--

LOCK TABLES `user_detail` WRITE;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` VALUES (1,'Gandhi nagar','Tvmalai','siva123@gmail.com','Sivanesan','M','6385310098','TAMIL NADU ',6060611,1),(2,' Sarvamangala Colony','Chennai','sanjay@gmail.com','Sanjay','SK','9361213535','TAMIL NADU',600083,3),(3,'Ramanathan St','Chennai','karan@gmail.com','Karan','S','8976452621','TAMIL NADU',606621,4),(4,'Sriman Srinivasa Road','Chennai','addwin@gmail.com','Addwin','J','8765434567','TAMIL NADU',602332,5),(5,'Gandhi Nagar','Tvmalai','raj@gmail.com','Raj','T','8759093321','TAMIL NADU',606601,6),(6,'BSRB Mall','Chennai','sathish@gmail.com','Sathish','M','8976543221','TAMIL NADU',600628,7),(7,'Gandhi Nagar','Tvmalai','murugan@gmail.com','Murugan','MM','9876534541','TAMIL NADU',606001,8),(8,' Sarvamangala Colony','Chennai','reena@gmail.com','Reena','JV','8446456743','TAMIL NADU',600021,9),(9,' Sarvamangala Colony','Chennai','hari@gmail.com','Hari','S','8976542632','TAMIL NADU',600604,10),(10,'gandhi nagar','tvmalai','nishad@gmail.com','Nishad','SK','8976567432','TAMIL NADU',608362,11),(11,' Sarvamangala Colony','Chennai','bala@pg.com','Balu','PG','9876543211','TAMIL NADU',694933,12);
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-01 17:24:24
