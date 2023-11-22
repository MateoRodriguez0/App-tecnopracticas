-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-11-2023 a las 17:13:20
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
  `nombre_carrera` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `urlImagen` text COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`ID`, `nombre_carrera`, `urlImagen`, `descripcion`) VALUES
(1, 'Tecnología en Gestión de Marketing', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-1.png', 'Aplica a tus prácticas como Gestor de Marketing.'),
(3, 'Administración en seguridad y salud en el trabajo', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-3.jpg', 'Aplica a tus prácticas como Administrador en Seguridad y Salud en el Trabajo.'),
(5, 'Ingeniería Civil', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-5.jpg', 'Aplica a tus prácticas como Ingeniero Civil.'),
(6, 'Tecnología en Producción Industrial', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-6.jpeg', 'Aplica a tus prácticas como Tecnólogo en Producción Industrial.'),
(7, 'Tecnología en Seguridad e Higiene Ocupacional', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-7.jpg', 'Aplica a tus prácticas como Tecnólogo en Seguridad e Higiene Ocupacional.'),
(8, 'Tecnología en Control de Calidad', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-8.jpg', 'Aplica a tus prácticas como Tecnólogo en Control de Calidad.'),
(9, 'Tecnología en Gestión Ambiental Industrial', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-9.png', 'Aplica a tus prácticas como Tecnólogo en Gestión Ambiental Industrial.'),
(10, 'Tecnología en Operación de Plantas y Procesos Industriales', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-10.png', 'Aplica a tus prácticas como Tecnólogo en Operación de Plantas y Procesos Industriales.'),
(11, 'Tecnología en Control Electrónico de Procesos', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-11.jpg', 'Aplica a tus prácticas como Tecnólogo en Control Electrónico de Procesos.'),
(12, 'Tecnoligía en Desarrollo de Software', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/desarrollosoftware.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Desarrollo de Software.'),
(13, 'Tecnología en Gestión de Redes de Computadores y Seguridad Informática', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-13.jpg', 'Aplica a tus prácticas como Tecnólogo en Gestión de Redes de Computadores y Seguridad Informática.'),
(14, 'Derecho', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-14.jpg', 'Aplica a tus prácticas como Abogado.'),
(15, 'Psicología', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-15.jpg', 'Aplica a tus prácticas como Psicólogo.'),
(16, 'Trabajo Social', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-16.jpg', 'Aplica a tus prácticas como Trabajador Social.'),
(17, 'Tecnología en Gestión Turística y Hotelera', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-17.jpg', 'Aplica a tus prácticas como Tecnólogo en Gestión Turística y Hotelera.'),
(18, 'Tecnología en Gestión Logística y Portuaria', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-18.jpg', 'Aplica a tus prácticas como Tecnólogo en Gestión Logística y Portuaria.'),
(19, 'Tecnología en Gestión de Negocios Internacionales', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-19.jpg', 'Aplica a tus prácticas como Tecnólogo en Gestión de Negocios Internacionales.'),
(20, 'Tecnología en Gestión Financiera', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-20.jpg', 'Aplica a tus prácticas como Tecnólogo en Gestión Financiera.'),
(21, 'Tecnología en Gestión Contable', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-21.png', 'Aplica a tus prácticas como Tecnólogo en Gestión Contable.'),
(22, 'Contaduría Pública', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-22.jpg', 'Aplica a tus prácticas como Contador Público.'),
(23, 'Ingeniería de Procesos', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-23.jpg', 'Aplica a tus prácticas como Ingeniero de Procesos.'),
(24, 'Ingeniería de Sistemas', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-24.jpg', 'Aplica a tus prácticas como Ingeniero de Sistemas.'),
(25, 'Administracíon de Empresas', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-25.png', 'Aplica a tus prácticas como Administrador de Empresas.'),
(26, 'Ingeniería Electrónica', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-26.png', 'Aplica a tus prácticas como Ingeniero Electrónico.'),
(27, 'Ingeniería Ambiental', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ingambiental.jpg', 'Aplica a tus prácticas como Ingeniero Ambiental.'),
(28, 'Ingeniería Industrial', '', 'Aplica para tus practicas como Ingeniero Industrial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

DROP TABLE IF EXISTS `empresas`;
CREATE TABLE IF NOT EXISTS `empresas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `nit` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`Id`)
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
  `idCarrera` int NOT NULL,
  `fecha_publicacion` datetime NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_idEmpresa` (`idEmpresa`),
  KEY `fk_idCarrera` (`idCarrera`)
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
  `idRol` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FkIdRol` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ofertas_practicas`
--
ALTER TABLE `ofertas_practicas`
  ADD CONSTRAINT `fk_idCarrera` FOREIGN KEY (`idCarrera`) REFERENCES `carreras` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idEmpresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresas` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `FkIdRol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`ID`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
