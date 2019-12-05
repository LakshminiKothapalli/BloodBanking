-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: online_blood_bank
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `addr_id` int(11) NOT NULL AUTO_INCREMENT,
  `addr_state` varchar(45) NOT NULL,
  `addr_area` varchar(45) NOT NULL,
  `addr_pincode` varchar(45) NOT NULL,
  PRIMARY KEY (`addr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'TamilNadu','Chennai','600001'),(2,'TamilNadu','Vellore','600002'),(3,'TamilNadu','Madurai','600003'),(4,'TamilNadu','Kanchipuram','600004'),(5,'Telangana','Hyderabad','500001'),(6,'Telangana','Secunderabad','500002'),(7,'Telangana','Suriyapet','500003'),(8,'Telangana','Warangal','500004'),(9,'Karnataka','Bangalore','700001'),(10,'Karnataka','Mysore','700002'),(11,'Karnataka','Mangalore','700003'),(12,'Karnataka','Hubli','700004');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blood_request`
--

DROP TABLE IF EXISTS `blood_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blood_request` (
  `req_id` int(11) NOT NULL AUTO_INCREMENT,
  `req_bloodgroup` varchar(5) DEFAULT NULL,
  `req_name` varchar(45) DEFAULT NULL,
  `req_contactnumber` varchar(11) DEFAULT NULL,
  `req_us_id_fk` int(11) DEFAULT NULL,
  `req_area` varchar(255) DEFAULT NULL,
  `req_pincode` int(11) DEFAULT NULL,
  `req_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`req_id`),
  KEY `req_us_id_fk` (`req_us_id_fk`),
  CONSTRAINT `req_us_id_fk` FOREIGN KEY (`req_us_id_fk`) REFERENCES `user` (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_request`
--

LOCK TABLES `blood_request` WRITE;
/*!40000 ALTER TABLE `blood_request` DISABLE KEYS */;
INSERT INTO `blood_request` VALUES (34,'B-','user','1234567898',2,'Hyderabad',600089,'karnataka'),(36,'AB+','user','12134454',2,'Bangalore',700001,'Karnataka'),(37,'O-','user','223356',2,'Madurai',600003,'TamilNadu'),(38,'B+','user','1234567898',2,'Vellore',600002,'TamilNadu'),(46,'B+','user','345654326',2,'Chennai',600001,'TamilNadu'),(47,'B+','user','345654326',2,'Chennai',600001,'TamilNadu'),(48,'B+','user','345654326',2,'Chennai',600001,'TamilNadu');
/*!40000 ALTER TABLE `blood_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donor_slot`
--

DROP TABLE IF EXISTS `donor_slot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donor_slot` (
  `ds_id` int(11) NOT NULL AUTO_INCREMENT,
  `ds_us_id_fk` int(11) NOT NULL,
  `ds_sl_id_fk` int(11) NOT NULL,
  PRIMARY KEY (`ds_id`),
  KEY `ds_sl_id_fk_idx` (`ds_sl_id_fk`),
  KEY `ds_us_id_fk_idx` (`ds_us_id_fk`),
  CONSTRAINT `ds_sl_id_fk` FOREIGN KEY (`ds_sl_id_fk`) REFERENCES `slot_booking` (`sl_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ds_us_id_fk` FOREIGN KEY (`ds_us_id_fk`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor_slot`
--

LOCK TABLES `donor_slot` WRITE;
/*!40000 ALTER TABLE `donor_slot` DISABLE KEYS */;
/*!40000 ALTER TABLE `donor_slot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience_sharing`
--

DROP TABLE IF EXISTS `experience_sharing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience_sharing` (
  `es_id` int(11) NOT NULL AUTO_INCREMENT,
  `es_hp_name` varchar(50) NOT NULL,
  `es_hp_area` varchar(50) NOT NULL,
  `es_feedback` varchar(500) NOT NULL,
  `es_us_id_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`es_id`),
  KEY `es_hp_id_fk_idx` (`es_hp_name`),
  KEY `es_us_id_fk_idx` (`es_feedback`),
  KEY `FKbfbb0ixpnhldpw6oxoy434xfm` (`es_us_id_fk`),
  CONSTRAINT `FKbfbb0ixpnhldpw6oxoy434xfm` FOREIGN KEY (`es_us_id_fk`) REFERENCES `user` (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience_sharing`
--

LOCK TABLES `experience_sharing` WRITE;
/*!40000 ALTER TABLE `experience_sharing` DISABLE KEYS */;
INSERT INTO `experience_sharing` VALUES (6,'Apollo','Chennai','good',NULL),(32,'Appolo','Vijayawada','fine',NULL),(33,'Pradhma','Hyderabad','klkjljio',NULL),(35,'Appolo','Vijayawada','awesome',2),(39,'','Chennai','super',2),(40,'Apollo Hospital','Chennai','marvelous',2),(41,'Kani Hospital','Secunderabad','greatt',2),(42,'Kauvery Hospital','Vellore','good',2),(43,'AIMS Hospital','Mangalore','good',2),(44,'Continental Hospital','Suriyapet','good',2),(45,'Kauvery Hospital','Vellore','great',2);
/*!40000 ALTER TABLE `experience_sharing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faq`
--

DROP TABLE IF EXISTS `faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faq` (
  `faq_id` int(11) NOT NULL AUTO_INCREMENT,
  `faq_question` varchar(100) NOT NULL,
  `faq_answer` varchar(100) NOT NULL,
  PRIMARY KEY (`faq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faq`
--

LOCK TABLES `faq` WRITE;
/*!40000 ALTER TABLE `faq` DISABLE KEYS */;
/*!40000 ALTER TABLE `faq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (49);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `hp_id` int(11) NOT NULL AUTO_INCREMENT,
  `hp_name` varchar(45) DEFAULT NULL,
  `hp_area` varchar(45) DEFAULT NULL,
  `hp_state` varchar(45) DEFAULT NULL,
  `hp_pincode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,'Apollo Hospital','Chennai','TamilNadu','600001'),(2,'Kauvery Hospital','Vellore','TamilNadu','600002'),(3,'Agarwal Hospital','Madurai','TamilNadu','600003'),(4,'SRM Hospital','Kanchipuram','TamilNadu','600004'),(5,'KIMS Hospital','Hyderabad','Telangana','500001'),(6,'Kani Hospital','Secunderabad','Telangana','500002'),(7,'Continental Hospital','Suriyapet','Telangana','500003'),(8,'ADHS Hospital','Warangal','Telangana','500004'),(9,'Global Hospital','Bangalore','Karnataka','700001'),(10,'MIMS Hospital ','Mysore','Karnataka','700002'),(11,'AIMS Hospital','Mangalore','Karnataka','700003'),(12,'CHS Hospital','Hubli','Karnataka','700004');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ro_id` int(11) NOT NULL AUTO_INCREMENT,
  `ro_name` varchar(45) NOT NULL,
  PRIMARY KEY (`ro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slot_booking`
--

DROP TABLE IF EXISTS `slot_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slot_booking` (
  `sl_id` int(11) NOT NULL AUTO_INCREMENT,
  `sl_hp_id_fk` int(11) DEFAULT NULL,
  `sl_time` time DEFAULT NULL,
  `sl_date` date DEFAULT NULL,
  PRIMARY KEY (`sl_id`),
  KEY `sl_hp_id_fk_idx` (`sl_hp_id_fk`),
  CONSTRAINT `sl_hp_id_fk` FOREIGN KEY (`sl_hp_id_fk`) REFERENCES `hospital` (`hp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slot_booking`
--

LOCK TABLES `slot_booking` WRITE;
/*!40000 ALTER TABLE `slot_booking` DISABLE KEYS */;
INSERT INTO `slot_booking` VALUES (13,1,'01:00:00','2019-11-20'),(14,8,'11:00:00','2019-11-13'),(15,6,'01:00:00','2019-11-12'),(16,6,'01:00:00','2019-11-12'),(17,6,'01:00:00','2019-11-12'),(18,6,'01:00:00','2019-11-12'),(19,6,'01:00:00','2019-11-12'),(20,6,'01:00:00','2019-11-12'),(21,6,'01:00:00','2019-11-12'),(22,4,'03:00:00','2019-11-19'),(23,4,'03:00:00','2019-11-19'),(24,4,'03:00:00','2019-11-19'),(25,6,'09:00:00','2019-11-12'),(26,6,'09:00:00','2019-11-12');
/*!40000 ALTER TABLE `slot_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_firstname` varchar(50) NOT NULL,
  `us_lastname` varchar(50) NOT NULL,
  `us_age` int(11) NOT NULL,
  `us_gender` varchar(10) NOT NULL,
  `us_contactnumber` varchar(10) NOT NULL,
  `us_email` varchar(45) NOT NULL,
  `us_password` varchar(450) NOT NULL,
  `us_weight` int(3) NOT NULL,
  `us_bloodgroup` varchar(5) NOT NULL,
  `us_username` varchar(255) NOT NULL,
  `us_state` varchar(45) NOT NULL,
  `us_area` varchar(45) NOT NULL,
  `us_pincode` int(11) NOT NULL,
  PRIMARY KEY (`us_id`),
  KEY `us_addr_id_idx` (`us_state`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin',25,'Female','9876543212','admin@cognizant.com','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK',56,'O+','admin','TamilNadu','Chennai',600001),(2,'user','user',23,'Male','9877236566','user@gmail.com','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK',45,'A+','user','Telangana','Hyderabad',500001),(3,'sony','sony',21,'Female','187598','ghsgdfhf','$2a$10$DoaezK8gOkI7OZvyhStJGOaYsxH9Pvk6nprFNatr6CQSDsYseezeq',32,'A+','sony','Telangana','ap',234567),(4,'2','2',23,'Male','3576768','fghfuy','$2a$10$QsbRcAiMhZ6Z/4KxWjwnBub7cx/fDaDVTyOeP0tT9XQ04DIklxhXe',456,'A-','2','Telangana','Secunderabad',5656758);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `ur_us_id_fk` int(11) NOT NULL,
  `ur_ro_id_fk` int(11) NOT NULL,
  PRIMARY KEY (`ur_id`),
  KEY `ur_us_id_fk_idx` (`ur_us_id_fk`),
  KEY `ur_ro_id_fk_idx` (`ur_ro_id_fk`),
  CONSTRAINT `ur_ro_id_fk` FOREIGN KEY (`ur_ro_id_fk`) REFERENCES `role` (`ro_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ur_us_id_fk` FOREIGN KEY (`ur_us_id_fk`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2),(9,3,2),(10,4,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-01  1:14:12
