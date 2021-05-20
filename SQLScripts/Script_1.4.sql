-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema encuestas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema encuestas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `encuestas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `encuestas` ;

-- -----------------------------------------------------
-- Table `encuestas`.`creador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `encuestas`.`creador` (
  `Nombre_Usuario` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NULL DEFAULT NULL,
  `Contrasenya` VARCHAR(16) NULL DEFAULT NULL,
  `Saldo` DOUBLE NULL DEFAULT '0',
  PRIMARY KEY (`Nombre_Usuario`),
  UNIQUE INDEX `Nombre_Usuario_UNIQUE` (`Nombre_Usuario` ASC) VISIBLE,
  UNIQUE INDEX `Correo_UNIQUE` (`Correo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `encuestas`.`encuestas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `encuestas`.`encuestas` (
  `ID_Encuesta` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NULL DEFAULT NULL,
  `Numero_Preguntas` INT NULL DEFAULT NULL,
  `Remuneracion` DOUBLE NULL DEFAULT NULL,
  `Nombre_Usuario` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Encuesta`),
  INDEX `encuestas_creador_Nombre_Usuario_fk` (`Nombre_Usuario` ASC) VISIBLE,
  CONSTRAINT `encuestas_creador_Nombre_Usuario_fk`
    FOREIGN KEY (`Nombre_Usuario`)
    REFERENCES `encuestas`.`creador` (`Nombre_Usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `encuestas`.`pregunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `encuestas`.`pregunta` (
  `ID_Pregunta` INT NOT NULL AUTO_INCREMENT,
  `Texto` VARCHAR(200) NULL DEFAULT NULL,
  `ID_Encuesta` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Pregunta`),
  INDEX `pregunta_encuestas_ID_Encuesta_fk` (`ID_Encuesta` ASC) VISIBLE,
  CONSTRAINT `pregunta_encuestas_ID_Encuesta_fk`
    FOREIGN KEY (`ID_Encuesta`)
    REFERENCES `encuestas`.`encuestas` (`ID_Encuesta`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `encuestas`.`respuesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `encuestas`.`respuesta` (
  `ID_Respuesta` INT NOT NULL AUTO_INCREMENT,
  `ID_Pregunta` INT NULL DEFAULT NULL,
  `Texto` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Respuesta`),
  INDEX `respuesta_pregunta_ID_Pregunta_fk` (`ID_Pregunta` ASC) VISIBLE,
  CONSTRAINT `respuesta_pregunta_ID_Pregunta_fk`
    FOREIGN KEY (`ID_Pregunta`)
    REFERENCES `encuestas`.`pregunta` (`ID_Pregunta`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `encuestas`.`respuesta_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `encuestas`.`respuesta_usuario` (
  `ID_Pregunta` INT NULL DEFAULT NULL,
  `Nombre_Usuario` VARCHAR(45) NULL DEFAULT NULL,
  `ID_Respuesta` INT NULL DEFAULT NULL,
  INDEX `respuesta-usuario_pregunta_ID_Pregunta_fk` (`ID_Pregunta` ASC) VISIBLE,
  INDEX `respuesta-usuario_respuesta_ID_Respuesta_fk` (`ID_Respuesta` ASC) VISIBLE,
  INDEX `respuesta-pregunta_creador_Nombre_Usuario_fk` (`Nombre_Usuario` ASC) VISIBLE,
  CONSTRAINT `respuesta-usuario_pregunta_ID_Pregunta_fk`
    FOREIGN KEY (`ID_Pregunta`)
    REFERENCES `encuestas`.`pregunta` (`ID_Pregunta`),
  CONSTRAINT `respuesta-usuario_respuesta_ID_Respuesta_fk`
    FOREIGN KEY (`ID_Respuesta`)
    REFERENCES `encuestas`.`respuesta` (`ID_Respuesta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
