-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-11-2023 a las 04:32:47
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
  `urlImagen` text CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`ID`, `nombre_carrera`, `urlImagen`, `descripcion`) VALUES
(1, 'Tecnología en Gestión de Marketing', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-1.png?raw=true', 'Aplica a tus prácticas como Gestor de Marketing.'),
(3, 'Administración en seguridad y salud en el trabajo', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-3.jpg?raw=true', 'Aplica a tus prácticas como Administrador en Seguridad y Salud en el Trabajo.'),
(5, 'Ingeniería Civil', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-5.jpg?raw=true', 'Aplica a tus prácticas como Ingeniero Civil.'),
(6, 'Tecnología en Producción Industrial', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-6.jpeg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Producción Industrial.'),
(7, 'Tecnología en Seguridad e Higiene Ocupacional', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-7.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Seguridad e Higiene Ocupacional.'),
(8, 'Tecnología en Control de Calidad', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-8.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Control de Calidad.'),
(9, 'Tecnología en Gestión Ambiental Industrial', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-9.png?raw=true', 'Aplica a tus prácticas como Tecnólogo en Gestión Ambiental Industrial.'),
(10, 'Tecnología en Operación de Plantas y Procesos Industriales', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-10.png?raw=true', 'Aplica a tus prácticas como Tecnólogo en Operación de Plantas y Procesos Industriales.'),
(11, 'Tecnología en Control Electrónico de Procesos', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-11.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Control Electrónico de Procesos.'),
(12, 'Tecnoligía en Desarrollo de Software', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/desarrollosoftware.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Desarrollo de Software.'),
(13, 'Tecnología en Gestión de Redes de Computadores y Seguridad Informática', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-13.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Gestión de Redes de Computadores y Seguridad Informática.'),
(14, 'Derecho', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-14.jpg?raw=true', 'Aplica a tus prácticas como Abogado.'),
(15, 'Psicología', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-15.jpg?raw=true', 'Aplica a tus prácticas como Psicólogo.'),
(16, 'Trabajo Social', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-16.jpg?raw=true', 'Aplica a tus prácticas como Trabajador Social.'),
(17, 'Tecnología en Gestión Turística y Hotelera', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-17.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Gestión Turística y Hotelera.'),
(18, 'Tecnología en Gestión Logística y Portuaria', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-18.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Gestión Logística y Portuaria.'),
(19, 'Tecnología en Gestión de Negocios Internacionales', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-19.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Gestión de Negocios Internacionales.'),
(20, 'Tecnología en Gestión Financiera', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-20.jpg?raw=true', 'Aplica a tus prácticas como Tecnólogo en Gestión Financiera.'),
(21, 'Tecnología en Gestión Contable', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-21.png?raw=true', 'Aplica a tus prácticas como Tecnólogo en Gestión Contable.'),
(22, 'Contaduría Pública', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-22.jpg?raw=true', 'Aplica a tus prácticas como Contador Público.'),
(23, 'Ingeniería de Procesos', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-23.jpg?raw=true', 'Aplica a tus prácticas como Ingeniero de Procesos.'),
(24, 'Ingeniería de Sistemas', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-24.jpg?raw=true', 'Aplica a tus prácticas como Ingeniero de Sistemas.'),
(25, 'Administracíon de Empresas', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-25.png?raw=true', 'Aplica a tus prácticas como Administrador de Empresas.'),
(26, 'Ingeniería Electrónica', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-26.png?raw=true', 'Aplica a tus prácticas como Ingeniero Electrónico.'),
(27, 'Ingeniería Ambiental', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ingambiental.jpg?raw=true', 'Aplica a tus prácticas como Ingeniero Ambiental.'),
(28, 'Ingeniería Industrial', 'https://github.com/JeysonM11/tecnopracticas-img/blob/master/imagenes/carreras/ID-28.jpg?raw=true', 'Aplica para tus prácticas como Ingeniero Industrial.');

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
  `nit` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`Id`, `nombre_completo`, `telefono`, `direccion`, `email`, `nit`) VALUES
(1, 'Coosalud', '3054214789', 'Olaya ', 'coosalud@gmail.com', '7894561231'),
(2, 'Codis ci sa.', '3023456911', 'Pasacaballos', 'cois@gmail.com', '489413189-4'),
(3, 'Ecopetrol', '3025456781', 'mamonal km 8', 'ecopetrol@gmail.com', '94158791-41'),
(4, 'TENARIS TUBO CARIBE', '3023216854', 'ternera', 'tubocaribe@gmail.com', '84563178-41');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas_practicas`
--

DROP TABLE IF EXISTS `ofertas_practicas`;
CREATE TABLE IF NOT EXISTS `ofertas_practicas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre_oferta` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `idAdministrador` int DEFAULT NULL,
  `idEmpresa` int NOT NULL,
  `idCarrera` int NOT NULL,
  `fecha_publicacion` datetime NOT NULL,
  `detalles` text CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_idEmpresa` (`idEmpresa`),
  KEY `fk_idCarrera` (`idCarrera`),
  KEY `fk_idAdministrador` (`idAdministrador`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `ofertas_practicas`
--

INSERT INTO `ofertas_practicas` (`Id`, `nombre_oferta`, `descripcion`, `idAdministrador`, `idEmpresa`, `idCarrera`, `fecha_publicacion`, `detalles`) VALUES
(1, 'Desarrollador de Bases de Datos en Prácticas', 'Empresa líder en tecnología busca un estudiante entusiasta de informática para unirse a nuestro equipo como Desarrollador de Bases de Datos en prácticas. En esta posición, trabajarás mano a mano con nuestro equipo de desarrollo para diseñar, implementar y mantener bases de datos eficientes. Requisitos: Conocimientos básicos de SQL, interés en modelado de datos y capacidad para aprender rápidamente.', 3, 1, 12, '2023-11-23 06:18:40', '<p><strong>Detalles del Puesto:</strong> Estamos buscando estudiantes entusiastas y motivado para unirse a nuestro equipo como Desarrollador de Bases de Datos Junior en pr&aacute;cticas. En esta posici&oacute;n, tendr&aacute;s la oportunidad de trabajar en proyectos emocionantes, adquirir experiencia pr&aacute;ctica en el dise&ntilde;o, implementaci&oacute;n y mantenimiento de bases de datos, y colaborar con un equipo experimentado. Responsabilidades: Participar en el dise&ntilde;o y desarrollo de esquemas de bases de datos. Colaborar en la creaci&oacute;n de consultas SQL eficientes para satisfacer los requisitos del proyecto. Contribuir al rendimiento y la optimizaci&oacute;n de las bases de datos. Colaborar con el equipo de desarrollo en la integraci&oacute;n de bases de datos con aplicaciones. Realizar pruebas y documentar procesos relacionados con bases de datos. Aprender y aplicar las mejores pr&aacute;cticas de gesti&oacute;n de datos. Requisitos: Estudiante de inform&aacute;tica, ingenier&iacute;a inform&aacute;tica o campo relacionado. Conocimientos b&aacute;sicos de SQL y modelado de datos. Capacidad para trabajar en equipo y comunicarse de manera efectiva. Inter&eacute;s demostrado en el desarrollo de bases de datos. Deseo de aprender y crecer en un entorno din&aacute;mico. Familiaridad con conceptos b&aacute;sicos de sistemas de gesti&oacute;n de bases de datos (DBMS).</p>\r\n<p><span style=\"color: rgb(185, 106, 217); font-size: 24pt;\"><strong>Beneficios</strong></span></p>\r\n<p>Experiencia pr&aacute;ctica en un entorno profesional. Colaboraci&oacute;n directa con un equipo experimentado. Oportunidad de aprender y aplicar habilidades en el mundo real. Entrenamiento continuo y desarrollo profesional. Posibilidad de continuar como becario a tiempo parcial despu&eacute;s de las pr&aacute;cticas. Duraci&oacute;n y Ubicaci&oacute;n: Duraci&oacute;n de las pr&aacute;cticas: 3 a 6 meses (negociable). Ubicaci&oacute;n: [Nombre de la Ciudad/Ubicaci&oacute;n de la Empresa]. C&oacute;mo Aplicar: Los interesados deben enviar su curr&iacute;culum y carta de presentaci&oacute;n a [correo electr&oacute;nico de contacto] antes del [fecha l&iacute;mite de aplicaci&oacute;n]. Estamos emocionados de dar la bienvenida a un nuevo miembro al equipo y ofrecer una experiencia de pr&aacute;cticas enriquecedora en el desarrollo de bases de datos. &iexcl;Esperamos recibir tu solicitud y conocerte pronto!</p>'),
(2, 'Administrador de bases de datos junior.', '¿Eres un apasionado de las bases de datos? Únete a nuestro equipo como Practicante en Administración de Bases de Datos y adquiere experiencia práctica en la gestión y optimización de bases de datos. Trabajarás en proyectos reales, aprenderás a utilizar herramientas de administración de bases de datos y participarás en la resolución de problemas relacionados con el rendimiento de consultas. Requisitos: Conocimientos básicos de SQL y capacidad para trabajar en equipo.', 3, 4, 12, '2023-11-23 06:25:50', 'Descripción del Puesto:\r\nEstamos en búsqueda de un estudiante apasionado por la gestión de datos y administración de bases de datos para unirse a nuestro equipo como Practicante en Administración de Bases de Datos Junior. En este rol, tendrás la oportunidad de aprender y trabajar directamente con nuestros administradores de bases de datos experimentados, participando en proyectos clave y adquiriendo habilidades prácticas en la gestión eficiente de bases de datos.\r\n\r\nResponsabilidades:\r\n\r\nColaborar en la administración y mantenimiento de bases de datos.\r\nParticipar en la creación y optimización de consultas SQL.\r\nContribuir a la seguridad y respaldo de bases de datos.\r\nAsistir en la monitorización del rendimiento de bases de datos.\r\nAprender y aplicar las mejores prácticas en administración de bases de datos.\r\nRequisitos:\r\n\r\nEstudiante de informática, ingeniería informática o campo relacionado.\r\nConocimientos básicos de SQL y experiencia con algún sistema de gestión de bases de datos (preferiblemente MySQL, PostgreSQL, SQL Server, Oracle, etc.).\r\nHabilidades analíticas y capacidad para resolver problemas.\r\nInterés demostrado en la administración y optimización de bases de datos.\r\nCapacidad para trabajar en equipo y aprender de forma proactiva.\r\nDeseo de aprender y crecer en un entorno de administración de bases de datos.\r\nBeneficios:\r\n\r\nExperiencia práctica en la administración de bases de datos.\r\nColaboración directa con administradores de bases de datos experimentados.\r\nOportunidad de participar en proyectos estratégicos.\r\nEntrenamiento continuo y desarrollo profesional.\r\nPosibilidad de continuar como becario a tiempo parcial después de las prácticas.\r\nDuración y Ubicación:\r\n\r\nDuración de las prácticas: 3 a 6 meses (negociable).\r\nUbicación: [Nombre de la Ciudad/Ubicación de la Empresa].\r\nCómo Aplicar:\r\nLos interesados deben enviar su currículum y carta de presentación a [correo electrónico de contacto] antes del [fecha límite de aplicación].\r\n\r\nEstamos emocionados de dar la bienvenida a un nuevo miembro al equipo y ofrecer una experiencia de prácticas enriquecedora en la administración de bases de datos. ¡Esperamos recibir tu solicitud y conocerte pronto!'),
(3, 'Estudiante en Desarrollo de Software', 'Descripción del Puesto:\r\nEstamos en la búsqueda de un estudiante apasionado por el desarrollo de software para unirse a nuestro equipo como Estudiante en Prácticas de Desarrollo de Software. En este emocionante rol, trabajarás de cerca con nuestro equipo de desarrollo, participando en proyectos reales y adquiriendo experiencia práctica en el diseño, implementación y mantenimiento de aplicaciones innovadoras.', 3, 2, 12, '2023-11-23 06:33:47', 'Responsabilidades:\r\n\r\nColaborar en el diseño e implementación de código bajo la supervisión de desarrolladores senior.\r\nParticipar en el ciclo de vida completo del desarrollo de software, desde la concepción hasta la implementación.\r\nContribuir a la resolución de problemas y optimización de aplicaciones.\r\nAprender y aplicar las mejores prácticas de desarrollo de software.\r\nParticipar en reuniones de equipo y colaborar en proyectos multidisciplinarios.\r\nRequisitos:\r\n\r\nEstudiante de informática, ingeniería informática o campo relacionado.\r\nConocimientos básicos de programación en al menos un lenguaje (preferiblemente Java, Python, C++, etc.).\r\nHabilidades analíticas y capacidad para resolver problemas.\r\nCapacidad para trabajar en equipo y comunicarse efectivamente.\r\nInterés demostrado en el desarrollo de software.\r\nDeseo de aprender y crecer en un entorno de desarrollo dinámico.\r\nBeneficios:\r\n\r\nExperiencia práctica en el desarrollo de software.\r\nColaboración directa con un equipo experimentado.\r\nOportunidad de participar en proyectos impactantes.\r\nEntrenamiento continuo y desarrollo profesional.\r\nPosibilidad de continuar como becario a tiempo parcial después de las prácticas.\r\nDuración y Ubicación:\r\n\r\nDuración de las prácticas: 3 a 6 meses (negociable).\r\nUbicación: [Nombre de la Ciudad/Ubicación de la Empresa].\r\nCómo Aplicar:\r\nLos interesados deben enviar su currículum y carta de presentación a [correo electrónico de contacto] antes del [fecha límite de aplicación].\r\n\r\nEstamos emocionados de dar la bienvenida a un nuevo miembro al equipo y ofrecer una experiencia de prácticas enriquecedora en el desarrollo de software. ¡Esperamos recibir tu solicitud y conocerte pronto!'),
(4, 'Estudiante en Prácticas - Desar', 'Estamos buscando un estudiante entusiasta para unirse a nuestro equipo como Estudiante en Prácticas de Desarrollo Frontend. En este emocionante rol, tendrás la oportunidad de trabajar en proyectos web innovadores, aprender las últimas tecnologías frontend y contribuir al diseño y desarrollo de interfaces de usuario atractivas.', 3, 3, 12, '2023-11-23 06:36:36', 'Responsabilidades:\r\n\r\nColaborar en el desarrollo de interfaces de usuario responsivas y atractivas.\r\nImplementar y mantener código frontend eficiente y modular.\r\nTrabajar en estrecha colaboración con diseñadores y desarrolladores senior.\r\nParticipar en la resolución de problemas y optimización de la experiencia del usuario.\r\nAprender y aplicar las mejores prácticas de desarrollo frontend.\r\nRequisitos:\r\n\r\nEstudiante de informática, ingeniería informática o campo relacionado.\r\nConocimientos básicos de HTML, CSS y JavaScript.\r\nInterés demostrado en el desarrollo frontend y diseño de interfaces de usuario.\r\nHabilidades analíticas y capacidad para trabajar en equipo.\r\nDeseo de aprender y crecer en el desarrollo de software frontend.\r\nHabilidades Deseadas:\r\n\r\nExperiencia con frameworks frontend como React, Angular o Vue.\r\nConocimientos de control de versiones (Git).\r\nFamiliaridad con herramientas de diseño como Figma o Sketch.\r\nBeneficios:\r\n\r\nExperiencia práctica en el desarrollo frontend.\r\nColaboración directa con un equipo experimentado.\r\nOportunidad de participar en proyectos impactantes.\r\nEntrenamiento continuo y desarrollo profesional.\r\nPosibilidad de continuar como becario a tiempo parcial después de las prácticas.\r\nDuración y Ubicación:\r\n\r\nDuración de las prácticas: 3 a 6 meses (negociable).\r\nUbicación: [Nombre de la Ciudad/Ubicación de la Empresa].\r\nCómo Aplicar:\r\nLos interesados deben enviar su currículum y portafolio (si aplicable) a [correo electrónico de contacto] antes del [fecha límite de aplicación].\r\n\r\nEstamos emocionados de dar la bienvenida a un nuevo miembro al equipo y ofrecer una experiencia de prácticas enriquecedora en el desarrollo frontend. ¡Esperamos recibir tu solicitud y conocerte pronto!');

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
  `estado` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_idEstudiante` (`idEstudiante`),
  KEY `fk_idOferta` (`idOferta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `postulaciones`
--

INSERT INTO `postulaciones` (`Id`, `idEstudiante`, `idOferta`, `fecha_postulacion`, `estado`) VALUES
(1, 4, 1, '2023-11-23 10:58:56', 'No visto'),
(2, 4, 1, '2023-11-23 11:00:29', 'No visto'),
(3, 4, 1, '2023-11-23 11:15:16', 'No visto'),
(4, 4, 4, '2023-11-23 11:44:40', 'No visto');

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
  `password` varchar(60) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `idRol` int NOT NULL,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FkIdRol` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID`, `nombre_completo`, `sexo`, `telefono`, `fecha_nacimiento`, `email`, `password`, `idRol`, `enable`) VALUES
(3, 'jeyson miranda', 'masculino', '3046773870', '1996-07-11', 'mmazaj@tecnocomfenalco.edu.co', '$2a$10$kYJOH5DRk0oUWA2Tr2GrpeaCinDsbs8xAUwv7btiB2IBWpB1t24Me', 2, 0),
(4, 'mateo rodriguz', 'masculino', '3041234567', '1995-08-24', 'mateo@tecnocomfenalco.edu.co', '$2a$10$kYJOH5DRk0oUWA2Tr2GrpeaCinDsbs8xAUwv7btiB2IBWpB1t24Me', 1, 1),
(5, 'jesus tatis', 'masculino', '3114750124', '2002-05-20', 'tatis@tecnocomfenalco.edu.co', '$2a$10$kYJOH5DRk0oUWA2Tr2GrpeaCinDsbs8xAUwv7btiB2IBWpB1t24Me', 1, 1),
(6, 'Jorge borrego', 'masculino', '3216549877', '1994-11-30', 'borrego@tecnocomfenalco.edu.co', '$2a$10$kYJOH5DRk0oUWA2Tr2GrpeaCinDsbs8xAUwv7btiB2IBWpB1t24Me', 1, 1),
(7, 'cristian ramirez', 'masculino', '3012345782', '1995-05-23', 'ramirezc@tecnocomfenalco.edu.co', '$2a$10$kYJOH5DRk0oUWA2Tr2GrpeaCinDsbs8xAUwv7btiB2IBWpB1t24Me', 1, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ofertas_practicas`
--
ALTER TABLE `ofertas_practicas`
  ADD CONSTRAINT `fk_idAdministrador` FOREIGN KEY (`idAdministrador`) REFERENCES `usuarios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
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
