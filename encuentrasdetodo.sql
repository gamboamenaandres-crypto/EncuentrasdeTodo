-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2025 a las 04:30:53
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `encuentrasdetodo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `Id_estado` int(11) NOT NULL,
  `des_estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`Id_estado`, `des_estado`) VALUES
(1, 'disponible'),
(2, 'Agotado'),
(3, 'pendiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_categoria`
--

CREATE TABLE `tbl_categoria` (
  `id_categoria` int(11) NOT NULL,
  `nom_categoria` varchar(100) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_categoria`
--

INSERT INTO `tbl_categoria` (`id_categoria`, `nom_categoria`, `id_proveedor`) VALUES
(5, 'Juguetes', 1),
(6, 'Camas', 1),
(7, 'Globos', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_detalles_factura`
--

CREATE TABLE `tbl_detalles_factura` (
  `id_detalles_factura` int(11) NOT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `id_factura` int(11) DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_detalles_factura`
--

INSERT INTO `tbl_detalles_factura` (`id_detalles_factura`, `id_producto`, `id_factura`, `Cantidad`, `Total`) VALUES
(1, 2, 2, 3, 0),
(2, 2, 2, 3, 1800000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_factura`
--

CREATE TABLE `tbl_factura` (
  `id_factura` int(11) NOT NULL,
  `Total` double DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_factura`
--

INSERT INTO `tbl_factura` (`id_factura`, `Total`, `id_usuario`) VALUES
(1, 2000000, 13),
(2, 2000000, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_genero`
--

CREATE TABLE `tbl_genero` (
  `id_genero` int(11) NOT NULL,
  `des_genero` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_genero`
--

INSERT INTO `tbl_genero` (`id_genero`, `des_genero`) VALUES
(2, 'Masculino'),
(3, 'Femenino'),
(10, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_municipios`
--

CREATE TABLE `tbl_municipios` (
  `id_municipio` int(11) NOT NULL,
  `nom_municipio` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_municipios`
--

INSERT INTO `tbl_municipios` (`id_municipio`, `nom_municipio`) VALUES
(1, 'Turbo'),
(9, 'Carepa'),
(10, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_productos`
--

CREATE TABLE `tbl_productos` (
  `id_producto` int(11) NOT NULL,
  `descripcion_producto` varchar(150) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `Id_estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_productos`
--

INSERT INTO `tbl_productos` (`id_producto`, `descripcion_producto`, `precio`, `id_categoria`, `Id_estado`) VALUES
(2, 'batman', 600000, 5, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_proveedores`
--

CREATE TABLE `tbl_proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nom_proveedor` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_proveedores`
--

INSERT INTO `tbl_proveedores` (`id_proveedor`, `nom_proveedor`) VALUES
(1, 'Hasbro'),
(4, 'Logicthech');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_tipo_usuario`
--

CREATE TABLE `tbl_tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL,
  `des_tipo_usuario` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_tipo_usuario`
--

INSERT INTO `tbl_tipo_usuario` (`id_tipo_usuario`, `des_tipo_usuario`) VALUES
(3, 'empleado'),
(4, 'Admin'),
(12, '1'),
(13, 'empleado'),
(16, 'empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `id_usuario` int(11) NOT NULL,
  `Identificacion_usuario` varchar(10) NOT NULL,
  `nombre_usuario` varchar(55) DEFAULT NULL,
  `apellido_usuario` varchar(55) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(55) DEFAULT NULL,
  `id_genero` int(11) DEFAULT NULL,
  `id_municipio` int(11) DEFAULT NULL,
  `id_tipo_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`id_usuario`, `Identificacion_usuario`, `nombre_usuario`, `apellido_usuario`, `telefono`, `correo`, `id_genero`, `id_municipio`, `id_tipo_usuario`) VALUES
(13, '1', 'Keyner', 'Rivas', '313', 'keynrv@gmail', 3, 1, 4),
(14, '14', 'Andres', 'Arbelaez', '3136554', 'keke@hot', 2, 1, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`Id_estado`);

--
-- Indices de la tabla `tbl_categoria`
--
ALTER TABLE `tbl_categoria`
  ADD PRIMARY KEY (`id_categoria`),
  ADD KEY `FK_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `tbl_detalles_factura`
--
ALTER TABLE `tbl_detalles_factura`
  ADD PRIMARY KEY (`id_detalles_factura`),
  ADD KEY `FK_producto` (`id_producto`),
  ADD KEY `FK_factura` (`id_factura`);

--
-- Indices de la tabla `tbl_factura`
--
ALTER TABLE `tbl_factura`
  ADD PRIMARY KEY (`id_factura`),
  ADD KEY `FK_Usuario` (`id_usuario`);

--
-- Indices de la tabla `tbl_genero`
--
ALTER TABLE `tbl_genero`
  ADD PRIMARY KEY (`id_genero`);

--
-- Indices de la tabla `tbl_municipios`
--
ALTER TABLE `tbl_municipios`
  ADD PRIMARY KEY (`id_municipio`);

--
-- Indices de la tabla `tbl_productos`
--
ALTER TABLE `tbl_productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `FK_categoria` (`id_categoria`),
  ADD KEY `FKjslio9cgo0r0m74fbysmolet6` (`Id_estado`);

--
-- Indices de la tabla `tbl_proveedores`
--
ALTER TABLE `tbl_proveedores`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `tbl_tipo_usuario`
--
ALTER TABLE `tbl_tipo_usuario`
  ADD PRIMARY KEY (`id_tipo_usuario`);

--
-- Indices de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `Identificacion_usuario` (`Identificacion_usuario`),
  ADD UNIQUE KEY `Unique_correo` (`correo`),
  ADD KEY `FK_genero` (`id_genero`),
  ADD KEY `FK_municipio` (`id_municipio`),
  ADD KEY `FK_tipo_usuario` (`id_tipo_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estados`
--
ALTER TABLE `estados`
  MODIFY `Id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tbl_categoria`
--
ALTER TABLE `tbl_categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tbl_detalles_factura`
--
ALTER TABLE `tbl_detalles_factura`
  MODIFY `id_detalles_factura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_factura`
--
ALTER TABLE `tbl_factura`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_genero`
--
ALTER TABLE `tbl_genero`
  MODIFY `id_genero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tbl_municipios`
--
ALTER TABLE `tbl_municipios`
  MODIFY `id_municipio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tbl_productos`
--
ALTER TABLE `tbl_productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_proveedores`
--
ALTER TABLE `tbl_proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tbl_tipo_usuario`
--
ALTER TABLE `tbl_tipo_usuario`
  MODIFY `id_tipo_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_categoria`
--
ALTER TABLE `tbl_categoria`
  ADD CONSTRAINT `FK_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `tbl_proveedores` (`id_proveedor`);

--
-- Filtros para la tabla `tbl_detalles_factura`
--
ALTER TABLE `tbl_detalles_factura`
  ADD CONSTRAINT `FK_factura` FOREIGN KEY (`id_factura`) REFERENCES `tbl_factura` (`id_factura`),
  ADD CONSTRAINT `FK_producto` FOREIGN KEY (`id_producto`) REFERENCES `tbl_productos` (`id_producto`);

--
-- Filtros para la tabla `tbl_factura`
--
ALTER TABLE `tbl_factura`
  ADD CONSTRAINT `FK_Usuario` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuarios` (`id_usuario`);

--
-- Filtros para la tabla `tbl_productos`
--
ALTER TABLE `tbl_productos`
  ADD CONSTRAINT `FK_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `tbl_categoria` (`id_categoria`),
  ADD CONSTRAINT `FKjslio9cgo0r0m74fbysmolet6` FOREIGN KEY (`Id_estado`) REFERENCES `estados` (`Id_estado`);

--
-- Filtros para la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD CONSTRAINT `FK_genero` FOREIGN KEY (`id_genero`) REFERENCES `tbl_genero` (`id_genero`),
  ADD CONSTRAINT `FK_municipio` FOREIGN KEY (`id_municipio`) REFERENCES `tbl_municipios` (`id_municipio`),
  ADD CONSTRAINT `FK_tipo_usuario` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tbl_tipo_usuario` (`id_tipo_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
