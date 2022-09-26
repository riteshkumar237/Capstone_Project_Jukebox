create DATABASE  IF NOT EXISTS `jukebox` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jukebox`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `playlist`
--

drop table IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `playlist` (
  `paylist_id` int NOT NULL AUTO_INCREMENT,
  `playlist_name` varchar(100) NOT NULL,
  `song_list` varchar(100) NOT NULL,
  PRIMARY KEY (`paylist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

lock TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
insert into `playlist` VALUES (1,'new list','3');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

drop table IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `song` (
  `song_id` int NOT NULL AUTO_INCREMENT,
  `song_name` varchar(100) NOT NULL,
  `song_path` varchar(1000) NOT NULL,
  `artist_name` varchar(100) NOT NULL,
  `duration` double NOT NULL,
  `genre` varchar(30) NOT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

lock TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
insert into `song` VALUES (1,'Taare Zameen Par','C:\\\\Users\\\\rites\\\\IdeaProjects\\\\Capstone_Project_Jukebox\\\\src\\\\main\\\\resources\\\\song\\\\Taare Zameen Par.wav','Shankar Mahadevan',7.13,'Drama'),(2,'Bheed Mein Tanhai Mein','C:\\\\Users\\\\rites\\\\IdeaProjects\\\\Capstone_Project_Jukebox\\\\src\\\\main\\\\resources\\\\song\\\\Bheed Mein Tanhai Mein.wav','Udit Narayan',6,'Sad'),(3,'Hum Tumko Nigahon Mein','C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Hum Tumko Nigahon Mein.wav','Udit Narayan',6.03,'Pop'),(4,'Rok Sako To Rok Lo','C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Rok Sako To Rok Lo.wav','Shaan',4.42,'Comedy'),(5,'Sapna Koi','C:\\Users\\rites\\IdeaProjects\\Capstone_Project_Jukebox\\src\\main\\resources\\song\\Sapna Koi.wav','Asha Bhosle',3.39,'Drama');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-26  9:35:46
