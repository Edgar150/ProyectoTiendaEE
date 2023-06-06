-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdtiendaeee
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bdtiendaeee` ;

-- -----------------------------------------------------
-- Schema bdtiendaeee
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdtiendaeee` DEFAULT CHARACTER SET utf8 ;
USE `bdtiendaeee` ;

-- -----------------------------------------------------
-- Table `bdtiendaeee`.`cortecaja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`cortecaja` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ingresado` FLOAT NULL DEFAULT NULL,
  `retirado` FLOAT NULL DEFAULT NULL,
  `total` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`detalleventa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`detalleventa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NULL,
  `cantidad` INT NULL,
  `precio` FLOAT NULL,
  `total` FLOAT NULL,
  `ventasid` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`perfil` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`permisos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`permisos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_permiso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`permisoperfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`permisoperfil` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Permisos_id` INT NOT NULL,
  `Perfil_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PermisoPerfil_Permisos1_idx` (`Permisos_id` ASC) VISIBLE,
  INDEX `fk_PermisoPerfil_Perfil1_idx` (`Perfil_id` ASC) VISIBLE,
  CONSTRAINT `fk_PermisoPerfil_Perfil1`
    FOREIGN KEY (`Perfil_id`)
    REFERENCES `bdtiendaeee`.`perfil` (`id`),
  CONSTRAINT `fk_PermisoPerfil_Permisos1`
    FOREIGN KEY (`Permisos_id`)
    REFERENCES `bdtiendaeee`.`permisos` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clave` INT NOT NULL,
  `nombre` VARCHAR(200) NOT NULL,
  `preciopublico` FLOAT NOT NULL,
  `existencia` INT NOT NULL,
  `proveedor` VARCHAR(100) NOT NULL,
  `categoria` VARCHAR(100) NOT NULL,
  `preciocompra` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`tipodepago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`tipodepago` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipodepago` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`tipodeventa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`tipodeventa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `CorteCaja_id` INT NOT NULL,
  `TipoDePago_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_TipoDeVenta_CorteCaja1_idx` (`CorteCaja_id` ASC) VISIBLE,
  INDEX `fk_TipoDeVenta_TipoDePago1_idx` (`TipoDePago_id` ASC) VISIBLE,
  CONSTRAINT `fk_TipoDeVenta_CorteCaja1`
    FOREIGN KEY (`CorteCaja_id`)
    REFERENCES `bdtiendaeee`.`cortecaja` (`id`),
  CONSTRAINT `fk_TipoDeVenta_TipoDePago1`
    FOREIGN KEY (`TipoDePago_id`)
    REFERENCES `bdtiendaeee`.`tipodepago` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `nombreUsuario` VARCHAR(20) NOT NULL,
  `passwordUsuario` VARCHAR(15) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `municipio` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bdtiendaeee`.`ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdtiendaeee`.`ventas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `descripcion` VARCHAR(145) NOT NULL,
  `total` FLOAT NOT NULL,
  `usuario` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
