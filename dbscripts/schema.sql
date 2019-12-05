-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema online_blood_bank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema online_blood_bank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_blood_bank` DEFAULT CHARACTER SET utf8 ;
USE `online_blood_bank` ;

-- -----------------------------------------------------
-- Table `online_blood_bank`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_firstname` VARCHAR(50) NOT NULL,
  `us_lastname` VARCHAR(50) NOT NULL,
  `us_age` INT(11) NOT NULL,
  `us_gender` VARCHAR(10) NOT NULL,
  `us_contactnumber` VARCHAR(10) NOT NULL,
  `us_email` VARCHAR(45) NOT NULL,
  `us_password` VARCHAR(450) NOT NULL,
  `us_weight` INT(3) NOT NULL,
  `us_bloodgroup` VARCHAR(5) NOT NULL,
  `us_username` VARCHAR(255) NOT NULL,
  `us_state` VARCHAR(45) NOT NULL,
  `us_area` VARCHAR(45) NOT NULL,
  `us_pincode` INT(11) NOT NULL,
  PRIMARY KEY (`us_id`),
  INDEX `us_addr_id_idx` (`us_state` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`blood_request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`blood_request` (
  `req_id` INT(11) NOT NULL AUTO_INCREMENT,
  `req_bloodgroup` VARCHAR(5) NULL DEFAULT NULL,
  `req_name` VARCHAR(45) NULL DEFAULT NULL,
  `req_contactnumber` VARCHAR(11) NULL DEFAULT NULL,
  `req_us_id_fk` INT(11) NULL DEFAULT NULL,
  `req_area` VARCHAR(255) NULL DEFAULT NULL,
  `req_pincode` INT(11) NULL DEFAULT NULL,
  `req_state` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`req_id`),
  INDEX `req_us_id_fk` (`req_us_id_fk` ASC),
  CONSTRAINT `req_us_id_fk`
    FOREIGN KEY (`req_us_id_fk`)
    REFERENCES `online_blood_bank`.`user` (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`hospital` (
  `hp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `hp_name` VARCHAR(45) NULL DEFAULT NULL,
  `hp_area` VARCHAR(45) NULL DEFAULT NULL,
  `hp_state` VARCHAR(45) NULL DEFAULT NULL,
  `hp_pincode` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`hp_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`slot_booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`slot_booking` (
  `sl_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sl_hp_id_fk` INT(11) NULL DEFAULT NULL,
  `sl_time` TIME NULL DEFAULT NULL,
  `sl_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`sl_id`),
  INDEX `sl_hp_id_fk_idx` (`sl_hp_id_fk` ASC),
  CONSTRAINT `sl_hp_id_fk`
    FOREIGN KEY (`sl_hp_id_fk`)
    REFERENCES `online_blood_bank`.`hospital` (`hp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`donor_slot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`donor_slot` (
  `ds_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ds_us_id_fk` INT(11) NOT NULL,
  `ds_sl_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`ds_id`),
  INDEX `ds_sl_id_fk_idx` (`ds_sl_id_fk` ASC),
  INDEX `ds_us_id_fk_idx` (`ds_us_id_fk` ASC),
  CONSTRAINT `ds_sl_id_fk`
    FOREIGN KEY (`ds_sl_id_fk`)
    REFERENCES `online_blood_bank`.`slot_booking` (`sl_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ds_us_id_fk`
    FOREIGN KEY (`ds_us_id_fk`)
    REFERENCES `online_blood_bank`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`experience_sharing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`experience_sharing` (
  `es_id` INT(11) NOT NULL AUTO_INCREMENT,
  `es_hp_name` VARCHAR(50) NOT NULL,
  `es_hp_area` VARCHAR(50) NOT NULL,
  `es_feedback` VARCHAR(500) NOT NULL,
  `es_us_id_fk` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`es_id`),
  INDEX `es_hp_id_fk_idx` (`es_hp_name` ASC),
  INDEX `es_us_id_fk_idx` (`es_feedback` ASC),
  INDEX `FKbfbb0ixpnhldpw6oxoy434xfm` (`es_us_id_fk` ASC),
  CONSTRAINT `FKbfbb0ixpnhldpw6oxoy434xfm`
    FOREIGN KEY (`es_us_id_fk`)
    REFERENCES `online_blood_bank`.`user` (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 36
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`faq`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`faq` (
  `faq_id` INT(11) NOT NULL AUTO_INCREMENT,
  `faq_question` VARCHAR(100) NOT NULL,
  `faq_answer` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`faq_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`user_role` (
  `ur_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ur_us_id_fk` INT(11) NOT NULL,
  `ur_ro_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `ur_us_id_fk_idx` (`ur_us_id_fk` ASC),
  INDEX `ur_ro_id_fk_idx` (`ur_ro_id_fk` ASC),
  CONSTRAINT `ur_ro_id_fk`
    FOREIGN KEY (`ur_ro_id_fk`)
    REFERENCES `online_blood_bank`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ur_us_id_fk`
    FOREIGN KEY (`ur_us_id_fk`)
    REFERENCES `online_blood_bank`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`address` (
  `addr_id` INT NOT NULL AUTO_INCREMENT,
  `addr_state` VARCHAR(45) NOT NULL,
  `addr_area` VARCHAR(45) NOT NULL,
  `addr_pincode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`addr_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
