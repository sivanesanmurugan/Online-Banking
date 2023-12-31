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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2023-11-30 17:29:46.388835','$2a$10$Wk0XIEC9wqAV072zDTXWOueH5jNPunlSzwVAQac8fGZvcFagYn1Za','user',1),(2,'2023-11-30 17:29:46.567359','$2a$10$Pfao3RiI5V.3GJ.DnDcCPuQYX2QtuS81crlrZLE7c7tfl3pveHjuO','admin',2),(3,'2023-11-30 17:33:52.304063','$2a$10$b7x3xVSSXejqDRiFV/YfZOmgQ7aqtq91CgrV7H6uSIfLtyd09x37u','sanjay',1),(4,'2023-11-30 17:35:13.654655','$2a$10$JyOvTHg7Xh6i6uCRjhJwN.tWxyvH9ADinkIc2WF72u7HHA1K5Or.u','karan',1),(5,'2023-11-30 17:36:19.249672','$2a$10$BA.4/yBiD2KXLMi.RH67vuCEn77WtMjA14G5kSZiASKOlpKkfx5RC','addwin',1),(6,'2023-11-30 17:37:17.503107','$2a$10$DEJtuBb1pmPAKTaxNnT20OkUUsagowNUcb/f.0fLcFM.rIlZ9Sa6q','raj',1),(7,'2023-11-30 17:39:01.713594','$2a$10$XRqVVSctfHj5VYEAJenyoe/YOBinPxvQD7bBmzwsR6Fvus0dtsG3K','sathish',1),(8,'2023-11-30 17:52:40.506940','$2a$10$ITBx6RygSj9ykllTR.O1KORLTpCd8adrWhzYiOrDl0U9Nlpw16rCi','murugan',1),(9,'2023-12-01 12:41:54.537013','$2a$10$ujp3W7b911A/QKBT.p6u1.WSoro2fNTNNk1Airf3wpGqubExAO1Y2','reena',1),(10,'2023-12-01 14:45:33.917647','$2a$10$HruHYmKF5VLpkTyqJ/YrZeTDRwOv6l7gchE.z./.ImNgRoQIlPTHW','hari',1),(11,'2023-12-01 14:48:47.379459','$2a$10$0j9CEbzQCyTS9EUXWEwiT.Ew/eSrNmiq/NrKZDDP0881LG5BsvM7y','nishad',1),(12,'2023-12-01 15:24:24.354197','$2a$10$CXVxr3WyaVKbs1ACRESzzuiiOc253i2euf82ybz5K4qxgXwH7hWw6','balu',1);
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

-- Dump completed on 2023-12-01 17:24:25
