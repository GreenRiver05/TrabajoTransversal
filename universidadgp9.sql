-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2023 a las 00:18:15
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidadgp9`
--
CREATE DATABASE IF NOT EXISTS `universidadgp9` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `universidadgp9`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `idAlumno` int(20) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idAlumno`, `dni`, `nombre`, `apellido`, `nacimiento`, `estado`) VALUES
(1, '39156898', 'Maximiliano', 'Sosa', '2000-01-06', 1),
(2, '40265985', 'Martina', 'Zaballa', '2002-05-10', 1),
(3, '34658985', 'Franco', 'Pepito', '1990-12-28', 0),
(15, '36556946', 'Ruperta', 'Rodriguez', '1994-05-10', 0),
(20, '26554946', 'Agustin', 'Sosa', '1999-05-15', 1),
(21, '38554946', 'Agustina', 'Rojos', '2002-01-05', 0),
(25, '36564546', 'Fernando', 'Sosa', '2000-04-01', 0),
(26, '36546968', 'Pepe', 'Urquiza', '2000-05-10', 1),
(32, '36564111', 'Coquito', 'Palmera', '2000-04-01', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `idInscripcion` int(20) NOT NULL,
  `idAlumnos` int(20) NOT NULL,
  `idMaterias` int(20) NOT NULL,
  `nota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripciones`
--

INSERT INTO `inscripciones` (`idInscripcion`, `idAlumnos`, `idMaterias`, `nota`) VALUES
(1, 1, 3, 9),
(2, 1, 4, 0),
(3, 2, 1, 8),
(4, 2, 5, 8),
(5, 3, 2, 5),
(6, 3, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `idMaterias` int(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `año` int(10) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`idMaterias`, `nombre`, `año`, `estado`) VALUES
(1, 'Matematica', 1, 1),
(2, 'Ingles', 2, 1),
(3, 'EDA', 1, 0),
(4, 'WEB 1', 1, 0),
(5, 'Laboratorio 1', 1, 0),
(38, 'Historia', 1, 0),
(39, 'Video Juego', 2, 0),
(42, 'Algebra', 2, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `DNI` (`dni`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`idInscripcion`),
  ADD KEY `idAlumnos` (`idAlumnos`),
  ADD KEY `idMaterias` (`idMaterias`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`idMaterias`),
  ADD UNIQUE KEY `Nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `idAlumno` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `idInscripcion` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `materias`
--
ALTER TABLE `materias`
  MODIFY `idMaterias` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD CONSTRAINT `inscripciones_ibfk_1` FOREIGN KEY (`idAlumnos`) REFERENCES `alumnos` (`idAlumno`),
  ADD CONSTRAINT `inscripciones_ibfk_2` FOREIGN KEY (`idMaterias`) REFERENCES `materias` (`idMaterias`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
