-- MySQL Script generated by MySQL Workbench
-- Sun May 13 20:51:04 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema social_network
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `social_network` ;

-- -----------------------------------------------------
-- Schema social_network
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `social_network` DEFAULT CHARACTER SET utf8 ;
USE `social_network` ;

-- -----------------------------------------------------
-- Table `social_network`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`user_role` ;

CREATE TABLE IF NOT EXISTS `social_network`.`user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`user` ;

CREATE TABLE IF NOT EXISTS `social_network`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `blocked` TINYINT NOT NULL DEFAULT 0,
  `user_role_id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_user_role_user_idx` (`user_role_id` ASC),
  CONSTRAINT `fk_user_role_user`
    FOREIGN KEY (`user_role_id`)
    REFERENCES `social_network`.`user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`profile` ;

CREATE TABLE IF NOT EXISTS `social_network`.`profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birth_date` DATE NULL,
  `gender` ENUM('MALE', 'FEMALE') NOT NULL,
  `address` VARCHAR(100) NULL,
  `martial_status` ENUM('NONE', 'SINGLE', 'ENGAGED', 'MARRIED') NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  CONSTRAINT `fk_user_profile`
    FOREIGN KEY (`user_id`)
    REFERENCES `social_network`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`group` ;

CREATE TABLE IF NOT EXISTS `social_network`.`group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `owner_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `access` TINYINT NOT NULL DEFAULT 0,
  `description` VARCHAR(1000) NULL,
  `logo_url` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_prodile_group_idx` (`owner_id` ASC),
  CONSTRAINT `fk_prodile_group`
    FOREIGN KEY (`owner_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`group_wall_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`group_wall_message` ;

CREATE TABLE IF NOT EXISTS `social_network`.`group_wall_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_id` INT NOT NULL,
  `owner_id` INT NOT NULL,
  `message` VARCHAR(1000) NULL,
  `date` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  INDEX `fk_group_group_wall_idx` (`group_id` ASC),
  INDEX `fk_profile_group_wall_message_idx` (`owner_id` ASC),
  CONSTRAINT `fk_group_group_wall_message`
    FOREIGN KEY (`group_id`)
    REFERENCES `social_network`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_group_wall_message`
    FOREIGN KEY (`owner_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`personal_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`personal_message` ;

CREATE TABLE IF NOT EXISTS `social_network`.`personal_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(1000) NOT NULL,
  `readed` TINYINT NOT NULL DEFAULT 0,
  `date` DATETIME NOT NULL DEFAULT NOW(),
  `edit_end_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`personal_message_profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`personal_message_profile` ;

CREATE TABLE IF NOT EXISTS `social_network`.`personal_message_profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  `personal_message_id` INT NOT NULL,
  `group_chat` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_profile_pers_message_profile_idx` (`profile_id` ASC),
  INDEX `fk_pers_message_pers_message_profile_idx` (`personal_message_id` ASC),
  CONSTRAINT `fk_profile_pers_message_profile`
    FOREIGN KEY (`profile_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pers_message_pers_message_profile`
    FOREIGN KEY (`personal_message_id`)
    REFERENCES `social_network`.`personal_message` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`profile_friend`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`profile_friend` ;

CREATE TABLE IF NOT EXISTS `social_network`.`profile_friend` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  `friend_id` INT NOT NULL,
  `status` ENUM('SUBSCRIBER', 'FRIEND', 'BLOCKED') NOT NULL DEFAULT 'SUBSCRIBER',
  PRIMARY KEY (`id`),
  INDEX `fk_profile_profile_friend_idx` (`profile_id` ASC),
  INDEX `fk_friend_profile_friend_idx` (`friend_id` ASC),
  CONSTRAINT `fk_profile_profile_friend`
    FOREIGN KEY (`profile_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_friend_profile_friend`
    FOREIGN KEY (`friend_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`profile_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`profile_group` ;

CREATE TABLE IF NOT EXISTS `social_network`.`profile_group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_id` INT NOT NULL,
  `profile_id` INT NOT NULL,
  `confirmed` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_group_profile_group_idx` (`group_id` ASC),
  INDEX `fk_profile_profile_group_idx` (`profile_id` ASC),
  CONSTRAINT `fk_group_profile_group`
    FOREIGN KEY (`group_id`)
    REFERENCES `social_network`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_profile_group`
    FOREIGN KEY (`profile_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`profile_photo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`profile_photo` ;

CREATE TABLE IF NOT EXISTS `social_network`.`profile_photo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  `url` VARCHAR(200) NOT NULL,
  `current` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_profile_profile_photo_idx` (`profile_id` ASC),
  CONSTRAINT `fk_profile_profile_photo`
    FOREIGN KEY (`profile_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`profile_wall_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `social_network`.`profile_wall_message` ;

CREATE TABLE IF NOT EXISTS `social_network`.`profile_wall_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  `owner_id` INT NOT NULL,
  `message` VARCHAR(1000) NOT NULL,
  `date` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  INDEX `fk_profile_profile_wall_idx` (`profile_id` ASC),
  INDEX `fk_profile_owner_profile_wall_message_idx` (`owner_id` ASC),
  CONSTRAINT `fk_profile_profile_wall_message`
    FOREIGN KEY (`profile_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_owner_profile_wall_message`
    FOREIGN KEY (`owner_id`)
    REFERENCES `social_network`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `social_network`;

DELIMITER $$

USE `social_network`$$
DROP TRIGGER IF EXISTS `social_network`.`personal_message_profile_BEFORE_INSERT` $$
USE `social_network`$$
CREATE DEFINER = CURRENT_USER TRIGGER `social_network`.`personal_message_profile_BEFORE_INSERT` BEFORE INSERT ON `personal_message_profile` FOR EACH ROW
BEGIN

END
$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;