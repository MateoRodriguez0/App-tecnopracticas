-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 02-11-2023 a las 12:24:57
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tecnopracticas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admins_practicas`
--

DROP TABLE IF EXISTS `admins_practicas`;
CREATE TABLE IF NOT EXISTS `admins_practicas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `sexo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

DROP TABLE IF EXISTS `carreras`;
CREATE TABLE IF NOT EXISTS `carreras` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre_carrera` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

DROP TABLE IF EXISTS `empresas`;
CREATE TABLE IF NOT EXISTS `empresas` (
  `NIT` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`NIT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
CREATE TABLE IF NOT EXISTS `estudiantes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `sexo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas_practicas`
--

DROP TABLE IF EXISTS `ofertas_practicas`;
CREATE TABLE IF NOT EXISTS `ofertas_practicas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre_oferta` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci NOT NULL,
  `idAdministrador` int DEFAULT NULL,
  `idEmpresa` int NOT NULL,
  `IdCarrera` int NOT NULL,
  `fecha_publicacion` datetime NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_idAdministrador` (`idAdministrador`),
  KEY `fk_idEmpresa` (`idEmpresa`),
  KEY `fk_idCarrera` (`IdCarrera`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `postulaciones`
--

DROP TABLE IF EXISTS `postulaciones`;
CREATE TABLE IF NOT EXISTS `postulaciones` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `idEstudiante` int NOT NULL,
  `idOferta` int NOT NULL,
  `fecha_postulacion` datetime NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_idEstudiante` (`idEstudiante`),
  KEY `fk_idOferta` (`idOferta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`ID`, `nombre`) VALUES
(1, 'Estudiante'),
(2, 'Administrador');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ofertas_practicas`
--
ALTER TABLE `ofertas_practicas`
  ADD CONSTRAINT `fk_idAdministrador` FOREIGN KEY (`idAdministrador`) REFERENCES `admins_practicas` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idCarrera` FOREIGN KEY (`IdCarrera`) REFERENCES `carreras` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idEmpresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresas` (`NIT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `postulaciones`
--
ALTER TABLE `postulaciones`
  ADD CONSTRAINT `fk_idEstudiante` FOREIGN KEY (`idEstudiante`) REFERENCES `estudiantes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idOferta` FOREIGN KEY (`idOferta`) REFERENCES `ofertas_practicas` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
