CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `library`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: library.cmpuah4ctyme.us-east-1.rds.amazonaws.com    Database: library
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `idadmin` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idadmin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_and_others`
--

DROP TABLE IF EXISTS `books_and_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `books_and_others` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `qTotal` int(11) NOT NULL DEFAULT '0',
  `qCheckedOut` int(11) NOT NULL DEFAULT '0',
  `qOrdered` int(11) DEFAULT NULL,
  `isRequested` tinyint(1) DEFAULT NULL,
  `qRequested` int(11) DEFAULT NULL,
  `isRef` tinyint(1) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `price` double NOT NULL DEFAULT '0',
  `reservingFaculty` varchar(255) DEFAULT NULL,
  `reservedTotal` int(11) DEFAULT NULL,
  `reservedBorrowed` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_and_others`
--

LOCK TABLES `books_and_others` WRITE;
/*!40000 ALTER TABLE `books_and_others` DISABLE KEYS */;
INSERT INTO `books_and_others` VALUES (1,'intro to seng','mr engineer',50,5,NULL,NULL,NULL,NULL,NULL,99.99,'Arts',30,1),(2,'harry potter','jk rowling',20,1,NULL,NULL,NULL,NULL,NULL,20.99,'Science',0,NULL),(3,'the hobbit','tolkein',5,0,NULL,NULL,NULL,NULL,NULL,10.59,'Arts',50,NULL),(4,'data structures & algorithms','savitch',20,-1,NULL,NULL,NULL,NULL,NULL,69.99,'Engineering',5,1);
/*!40000 ALTER TABLE `books_and_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrowed`
--

DROP TABLE IF EXISTS `borrowed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `borrowed` (
  `username` varchar(255) NOT NULL,
  `borrowed_id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `ISBN` int(11) NOT NULL,
  `date_borrowed` date NOT NULL,
  `date_returned` date DEFAULT NULL,
  PRIMARY KEY (`borrowed_id`),
  KEY `username_idx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowed`
--

LOCK TABLES `borrowed` WRITE;
/*!40000 ALTER TABLE `borrowed` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrowed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentalObj`
--

DROP TABLE IF EXISTS `rentalObj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rentalObj` (
  `userRenter` varchar(255) NOT NULL,
  `itemRented` int(11) NOT NULL,
  `dateRented` date NOT NULL,
  `dateReturned` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentalObj`
--

LOCK TABLES `rentalObj` WRITE;
/*!40000 ALTER TABLE `rentalObj` DISABLE KEYS */;
INSERT INTO `rentalObj` VALUES ('str',1,'2019-04-09',NULL),('me',1,'2019-04-09',NULL),('struan',1,'2019-04-09',NULL),('stru',1,'2019-04-09',NULL),('timmy',1,'2019-04-09','2019-04-09'),('a',1,'2019-04-09',NULL),('PLEASE',1,'2019-04-09',NULL),('MnM',1,'2019-04-09',NULL),('key',2,'2019-04-09',NULL),('test',1,'2019-04-10','2019-04-10'),('lior',4,'2019-04-10',NULL);
/*!40000 ALTER TABLE `rentalObj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentalObject`
--

DROP TABLE IF EXISTS `rentalObject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rentalObject` (
  `userRenter` varchar(255) NOT NULL,
  `itemRented` int(11) NOT NULL,
  `dateRented` date NOT NULL,
  PRIMARY KEY (`userRenter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentalObject`
--

LOCK TABLES `rentalObject` WRITE;
/*!40000 ALTER TABLE `rentalObject` DISABLE KEYS */;
INSERT INTO `rentalObject` VALUES ('1',9,'2019-04-03');
/*!40000 ALTER TABLE `rentalObject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shop` (
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES ('Hoodie','clothing',15),('Textbooks','books',10),('Pen','supplies',20);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_and_passwords`
--

DROP TABLE IF EXISTS `users_and_passwords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users_and_passwords` (
  `username` varchar(255) NOT NULL,
  `salt` varbinary(8000) NOT NULL,
  `hash` varbinary(8000) NOT NULL,
  `accountType` int(11) DEFAULT '1',
  `balance` double DEFAULT '0',
  `funds` double DEFAULT '0',
  `fees` double DEFAULT '0',
  `faculty` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ID` varchar(255) DEFAULT NULL,
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_and_passwords`
--

LOCK TABLES `users_and_passwords` WRITE;
/*!40000 ALTER TABLE `users_and_passwords` DISABLE KEYS */;
INSERT INTO `users_and_passwords` VALUES ('1',_binary 'Y�\�\�\�ͽ�\�r�',_binary '�\�6R*\��҈��ɕ�����U�i�V�笖�R\�',4,0,0,0,'Science','1 1','1'),('33',_binary '��V3�~A\�ئ/�X\�',_binary 'a�f�4J���4\�^L��&��ġc�֐v',4,0,0,0,'Arts','33 33','333'),('a',_binary '\�\r�+\���m\rl˝�',_binary 'A�\"ޞF2J\��[T�Y��\�\�E�?%�F\'\�.',0,1000,0,0,'Science','a a',NULL),('admin',_binary '\0Ӳ��\�\�&3\����i,',_binary '��J��	x�\"VS�\�	u��qpM�#A�q	��',2,0,0,0,'Science','admin admin','1'),('asd',_binary '�dP\�\�\�$��s&',_binary '\0e�\�)K\�\0�!\�O�k((�����D����\�\�f',0,0,0,0,'Business','asd asd','123123'),('bob',_binary '\�n\����\��˲�	*�\�',_binary '\�\�N�yTo~TLs1�\�\�\"\�,���M3\�\�v�',0,0,0,0,'Science','Bob Bob','100'),('chris',_binary '�ɏsjf\'\�=`<9',_binary '�\���~u�5J�gJ_]�G|\n\�V\ZT�_y�\�',1,619,4933,0,'Science','chris chris','123456'),('fac',_binary '��\�> O~*\���\�l',_binary 'g�C	r�o_����ex�?W`r��\�G\���m\�',4,0,0,0,'Science','f f','123'),('key',_binary 'c\�W*\�@\�\�8è��Ao',_binary 'eQ~\�8�3#%}է�(Gx\0�\�\�лI|\�	\�gW)�',1,0,0,0,'Arts','DJ Khaled','910283'),('lib',_binary 'r\���ۙ=��ye\�9\r',_binary 'a �\�\� zN^�F\�\�n�]\�\�.cTz>�*',0,0,0,0,NULL,NULL,NULL),('lior',_binary '����dda�.A\��i�',_binary '���do�dU�\��\�@/�\�p�\0f�B\r�\rf\�',0,23,0,0,'Engineering','li s','123'),('me',_binary 'ʡZ#�85W��\�YU�g',_binary '��%��+�:�_3��C>�J\0L\���8<�|',1,0,0,0,'Engineering','me me','112222'),('PLEASE',_binary '.т�\�;�U3:XM�A\�',_binary '����\��}Ƿf�me�6:�-D<�����\�\�U�N�',1,0,0,0,'Arts','Please GivemeanA','100'),('str',_binary '7؜G�\�\�\�d�-��_�',_binary '��\��HL8�\�,7jd���T�\��r&�p\0�',0,0,0,0,'Business','str str','111'),('stru',_binary 'r\��\�\�pl\�-U&��jN',_binary '�Y\���t\�!Ґ\0�\�XbрGJJ�us\�\�ʶj2',1,0,0,0,'Science','stru wood','10199'),('test',_binary '(dfӻ�������O',_binary 'd��W��v\�?cv\�<_���i\�p�<�f\�>ә4',4,0,0,0,'Business','asd asd','123'),('timmy',_binary '��U\"�uJ\�8�\�\r',_binary '�{>\�7CY��T;c\�><��x����\�FB�m',1,0,0,0,'Engineering','timmy tom','4444');
/*!40000 ALTER TABLE `users_and_passwords` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-12 20:16:11
