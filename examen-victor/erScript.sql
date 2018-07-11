-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema examen_eon
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema examen_eon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `examen_eon` DEFAULT CHARACTER SET utf8 ;
USE `examen_eon` ;

-- -----------------------------------------------------
-- Table `examen_eon`.`FAMILIAR_TYPE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examen_eon`.`FAMILIAR_TYPE` (
  `ID_FAMILIAR_TYPE` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_FAMILIAR_TYPE`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examen_eon`.`USER_TYPE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examen_eon`.`USER_TYPE` (
  `ID_USER_TYPE` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_USER_TYPE`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examen_eon`.`GENERAL_DATA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examen_eon`.`GENERAL_DATA` (
  `NAME` VARCHAR(50) NOT NULL,
  `FIRST_NAME` VARCHAR(50) NOT NULL,
  `LAST_NAME` VARCHAR(50) NOT NULL,
  `PHONE_NUMER` VARCHAR(45) NOT NULL,
  `ADDRESS` VARCHAR(300) NULL,
  `ID_GENERAL_DATA` INT NOT NULL AUTO_INCREMENT,
  `FAMILIAR_TYPE_FK` INT NULL,
  `COMPANY` VARCHAR(45) NULL,
  `AREA` VARCHAR(45) NULL,
  `RUB` VARCHAR(45) NULL,
  `USER_TYPE_ID_USER_TYPE` INT NOT NULL,
  PRIMARY KEY (`ID_GENERAL_DATA`),
  INDEX `fk_GENERAL_DATA_USER_TYPE_idx` (`FAMILIAR_TYPE_FK` ASC),
  INDEX `fk_GENERAL_DATA_USER_TYPE1_idx` (`USER_TYPE_ID_USER_TYPE` ASC),
  CONSTRAINT `fk_GENERAL_DATA_USER_TYPE`
    FOREIGN KEY (`FAMILIAR_TYPE_FK`)
    REFERENCES `examen_eon`.`FAMILIAR_TYPE` (`ID_FAMILIAR_TYPE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GENERAL_DATA_USER_TYPE1`
    FOREIGN KEY (`USER_TYPE_ID_USER_TYPE`)
    REFERENCES `examen_eon`.`USER_TYPE` (`ID_USER_TYPE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `examen_eon`.`FAMILIAR_TYPE`
-- -----------------------------------------------------
START TRANSACTION;
USE `examen_eon`;
INSERT INTO `examen_eon`.`FAMILIAR_TYPE` (`ID_FAMILIAR_TYPE`, `DESCRIPTION`) VALUES (1, 'Amigo');
INSERT INTO `examen_eon`.`FAMILIAR_TYPE` (`ID_FAMILIAR_TYPE`, `DESCRIPTION`) VALUES (2, 'Familiar');

COMMIT;


-- -----------------------------------------------------
-- Data for table `examen_eon`.`USER_TYPE`
-- -----------------------------------------------------
START TRANSACTION;
USE `examen_eon`;
INSERT INTO `examen_eon`.`USER_TYPE` (`ID_USER_TYPE`, `DESCRIPTION`) VALUES (1, 'Familiares');
INSERT INTO `examen_eon`.`USER_TYPE` (`ID_USER_TYPE`, `DESCRIPTION`) VALUES (2, 'Companieros de Trabajo');

COMMIT;

