-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-01-2024 a las 02:32:37
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crud_java`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `dni` bigint(13) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `apellidos` varchar(35) DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `tfno` bigint(10) DEFAULT NULL,
  `id_cliente` int(11) NOT NULL,
  `eliminado` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`dni`, `nombre`, `apellidos`, `fecha_nac`, `tfno`, `id_cliente`, `eliminado`) VALUES
(53133848990, 'Gael', 'Limon', '2005-01-21', 4491790461, 1, b'0'),
(123456789, 'Ixcoatl', 'Limon', '1997-07-07', 4494121807, 2, b'0'),
(987654321, 'Axel', 'Limon', '2014-09-23', 100, 3, b'0'),
(123, 'Gael2', 'Limon', '2005-01-21', 123, 4, b'0'),
(1234, 'Ga', 'Li', '2005-01-21', 1234, 8, b'0'),
(1, 'G', 'L', '2000-01-01', 1, 9, b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigo` int(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `precio` int(6) DEFAULT NULL,
  `rfc` varchar(13) NOT NULL,
  `eliminado` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo`, `nombre`, `precio`, `rfc`, `eliminado`) VALUES
(1, 'GTA III', 300, '1234567890', b'0'),
(2, 'GTA IV', 300, '1234567890', b'0'),
(3, 'GTA V', 300, '1234567890', b'0'),
(4, 'GTA San Andreas', 350, '1234567890', b'0'),
(5, 'tetris', 10, '1234567890', b'0'),
(10, 'GTA', 1, '1234567890', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `rfc` varchar(13) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `eliminado` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`rfc`, `nombre`, `direccion`, `eliminado`) VALUES
('0987654321', 'Test', 'Test1', b'0'),
('1', 'Name1', 'Dir1', b'0'),
('1234567890', 'Rockstar Games', 'Carlsbad, California', b'0'),
('2', 'Nombre2', 'Direccion2', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_cliente` int(11) NOT NULL,
  `codigo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_cliente`, `codigo`) VALUES
(4, 1),
(4, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `rfc` (`rfc`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`rfc`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `codigo` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`rfc`) REFERENCES `proveedor` (`rfc`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`codigo`) REFERENCES `producto` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
