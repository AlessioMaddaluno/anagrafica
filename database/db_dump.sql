-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: anagrafica
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `citta` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `data_nascita` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (3,'Milano','Verdi','Nicola','1990-04-01 00:00:00'),(4,'San Giorgio','Rossi','Mario','1990-04-01 00:00:00'),(5,'Napoli','Rossi','Mario','1990-04-01 00:00:00'),(6,'Roma','Verdi','Mario','1966-10-15 00:00:00'),(7,'Portici','Neri','Luigi','1990-04-01 00:00:00'),(8,'Brindisi','Neri','Davide','1950-10-14 00:00:00'),(9,'Bari','Bianchi','Gennaro','1990-04-01 00:00:00'),(10,'Firenze','Bianchi','Simone','1990-04-01 00:00:00'),(11,'Firenze','Russo','Francesca','1966-10-15 00:00:00'),(12,'Napoli','Russo','Rosa','1969-03-31 00:00:00'),(13,'San Giorgio','Russo','Marco','1990-04-01 00:00:00'),(14,'Pollena','Esposito','Marco','1966-10-15 00:00:00'),(15,'Milano','Esposito','Davide','1990-04-01 00:00:00'),(16,'Milano','Esposito','Ivan','1990-04-01 00:00:00'),(17,'Brindisi','Russo','Mario','1990-04-01 00:00:00'),(18,'Roma','Russo','Anna','1966-10-15 00:00:00'),(19,'Roma','Neri','Ivan','1990-04-01 00:00:00'),(20,'Roma','Neri','Anna','1990-04-01 00:00:00'),(21,'Napoli','Verdi','Luisa','1990-04-01 00:00:00'),(22,'Napoli','Verdi','Maria','1990-04-01 00:00:00'),(23,'Milano','Baudo','Pippo','1966-10-15 00:00:00');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('alessio','test'),('mario','test');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-19 16:35:09
