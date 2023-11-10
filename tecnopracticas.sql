-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 07-11-2023 a las 22:29:11
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
-- Estructura de tabla para la tabla `ofertas_practicas`
--

DROP TABLE IF EXISTS `ofertas_practicas`;
CREATE TABLE IF NOT EXISTS `ofertas_practicas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre_oferta` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `idAdministrador` int DEFAULT NULL,
  `idEmpresa` int NOT NULL,
  `IdCarrera` int NOT NULL,
  `fecha_publicacion` datetime NOT NULL,
  PRIMARY KEY (`Id`),
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
(1, 'ESTUDIANTE'),
(2, 'ADMINISTRADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `sexo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `IdRol` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FkIdRol` (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ofertas_practicas`
--
ALTER TABLE `ofertas_practicas`
  ADD CONSTRAINT `fk_idCarrera` FOREIGN KEY (`IdCarrera`) REFERENCES `carreras` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idEmpresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresas` (`NIT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `postulaciones`
--
ALTER TABLE `postulaciones`
  ADD CONSTRAINT `fk_idEstudiante` FOREIGN KEY (`idEstudiante`) REFERENCES `usuarios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idOferta` FOREIGN KEY (`idOferta`) REFERENCES `ofertas_practicas` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FkIdRol` FOREIGN KEY (`IdRol`) REFERENCES `roles` (`ID`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
