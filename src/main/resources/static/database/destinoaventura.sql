-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-04-2025 a las 10:47:28
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `destinoaventura`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `id_actividad` int(11) NOT NULL,
  `id_tipo` int(5) NOT NULL,
  `duracion` int(10) NOT NULL,
  `precio` double(10,2) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  `id_empresa` int(10) NOT NULL,
  `plazas` int(5) NOT NULL,
  `hora` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `actividades`
--

INSERT INTO `actividades` (`id_actividad`, `id_tipo`, `duracion`, `precio`, `localidad`, `id_empresa`, `plazas`, `hora`) VALUES
(1, 1, 3, 15.00, 'Ribadesella', 2, 20, '11:00'),
(2, 14, 5, 20.00, 'Ribadesella', 2, 15, '10:00'),
(3, 11, 2, 60.00, 'Ribadesella', 1, 6, '16:00'),
(4, 2, 8, 12.00, 'Ribadesella', 1, 30, '8:00'),
(5, 5, 2, 50.00, 'Ribadesella', 1, 10, '12:00'),
(6, 1, 4, 15.00, 'Luarca', 7, 40, '11:00'),
(7, 14, 5, 20.00, 'Luarca', 7, 10, '16:00'),
(8, 17, 5, 25.00, 'Luarca', 7, 10, '10:00'),
(9, 12, 4, 30.00, 'Somiedo', 11, 6, '10:00'),
(10, 11, 2, 75.00, 'Somiedo', 11, 4, '11:00'),
(11, 2, 6, 12.00, 'Somiedo', 14, 15, '9:00'),
(12, 6, 2, 75.00, 'Gijón', 6, 8, '11:00'),
(13, 9, 3, 60.00, 'Cabrales', 15, 5, '12:00'),
(14, 8, 7, 120.00, 'Somiedo', 14, 15, '9:00'),
(15, 10, 1, 80.00, 'Llanes', 8, 4, '17:00'),
(16, 19, 4, 16.00, 'Llanes', 9, 25, '10:00'),
(17, 20, 4, 25.00, 'Llanes', 9, 30, '12:00'),
(18, 7, 1, 75.00, 'Colunga', 12, 3, '11:00'),
(19, 3, 7, 70.00, 'Navia', 3, 8, '17:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

CREATE TABLE `ciudades` (
  `cp` varchar(5) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `provincia` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ciudades`
--

INSERT INTO `ciudades` (`cp`, `localidad`, `provincia`) VALUES
('33001', 'Oviedo', 'Asturias'),
('33111', 'Teverga', 'Asturias'),
('33114', 'Proaza', 'Asturias'),
('33115', 'Quirós', 'Asturias'),
('33120', 'Pravia', 'Asturias'),
('33125', 'Soto del Barco', 'Asturias'),
('33138', 'Muros de Nalón', 'Asturias'),
('33150', 'Cudillero', 'Asturias'),
('33160', 'Riosa', 'Asturias'),
('33161', 'Morcín', 'Asturias'),
('33170', 'Ribera de Arriba', 'Asturias'),
('33180', 'Noreña', 'Asturias'),
('33190', 'Regueras (Las)', 'Asturias'),
('33201', 'Gijón', 'Asturias'),
('33300', 'Villaviciosa', 'Asturias'),
('33310', 'Cabranes', 'Asturias'),
('33320', 'Colunga', 'Asturias'),
('33344', 'Caravia', 'Asturias'),
('33404', 'Corvera de Asturias', 'Asturias'),
('33405', 'Castrillón', 'Asturias'),
('33411', 'Illas', 'Asturias'),
('33418', 'Gozón', 'Asturias'),
('33424', 'Llanera', 'Asturias'),
('33430', 'Carreño', 'Asturias'),
('33500', 'Llanes', 'Asturias'),
('33510', 'Siero', 'Asturias'),
('33518', 'Sariego', 'Asturias'),
('33519', 'Avilés', 'Asturias'),
('33520', 'Nava', 'Asturias'),
('33527', 'Bimenes', 'Asturias'),
('33530', 'Piloña', 'Asturias'),
('33540', 'Parres', 'Asturias'),
('33550', 'Cangas de Onís', 'Asturias'),
('33555', 'Cabrales', 'Asturias'),
('33556', 'Onís', 'Asturias'),
('33557', 'Ponga', 'Asturias'),
('33558', 'Amieva', 'Asturias'),
('33560', 'Ribadesella', 'Asturias'),
('33576', 'Peñamellera Alta', 'Asturias'),
('33579', 'Peñamellera Baja', 'Asturias'),
('33590', 'Ribadedeva', 'Asturias'),
('33600', 'Mieres', 'Asturias'),
('33620', 'Lena', 'Asturias'),
('33683', 'Aller', 'Asturias'),
('33700', 'Valdés', 'Asturias'),
('33710', 'Navia', 'Asturias'),
('33717', 'Villayón', 'Asturias'),
('33720', 'Boal', 'Asturias'),
('33730', 'Grandas de Salime', 'Asturias'),
('33732', 'Illano', 'Asturias'),
('33735', 'Pesoz', 'Asturias'),
('33740', 'Tapia de Casariego', 'Asturias'),
('33746', 'Franco (El)', 'Asturias'),
('33760', 'Castropol', 'Asturias'),
('33770', 'Vegadeo', 'Asturias'),
('33774', 'San Tirso de Abres', 'Asturias'),
('33775', 'Taramundi', 'Asturias'),
('33776', 'Santa Eulalia de Oscos', 'Asturias'),
('33777', 'San Martín de Oscos', 'Asturias'),
('33795', 'Coaña', 'Asturias'),
('33800', 'Cangas del Narcea', 'Asturias'),
('33810', 'Ibias', 'Asturias'),
('33812', 'Degaña', 'Asturias'),
('33815', 'Allande', 'Asturias'),
('33820', 'Grado', 'Asturias'),
('33826', 'Yernes y Tameza', 'Asturias'),
('33828', 'Candamo', 'Asturias'),
('33830', 'Belmonte de Miranda', 'Asturias'),
('33840', 'Somiedo', 'Asturias'),
('33860', 'Salas', 'Asturias'),
('33870', 'Tineo', 'Asturias'),
('33930', 'Langreo', 'Asturias'),
('33950', 'San Martín del Rey Aurelio', 'Asturias'),
('33970', 'Laviana', 'Asturias'),
('33990', 'Caso', 'Asturias'),
('33993', 'Sobrescobio', 'Asturias');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(75) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `apellidos`, `telefono`, `email`, `password`) VALUES
(20, 'Juan', 'Soto Torres', '652254784', 'juansoto@gmail.com', '$2a$10$f5NESTITztPS3TqiAHQQKOlz/6/UaklHw0JANlRxtBNz/Uzo94Kju'),
(21, 'Pilar', 'Hernández Torres', '625523658', 'ptorres@gmail.com', '$2a$10$rl7HmErTjT2vzeSggdR0Z.2JjJGhWK1ydlhV3FJK0Y3jH0Y8snWzy'),
(22, 'Lucas', 'Díez Rodríguez ', '625487513', 'lucas@hotmail.com', '$2a$10$WxT1aJaDGiiz8tavucMBAubvIkLXbQg3mR1ddRAZ3qmJwgJMnxou2'),
(23, 'Paloma', 'Rey Huerta', '652457893', 'palomareyh@gmail.com', '$2a$10$.7QX7pUkkPmO17mpvEVsDuM/eoMysv.1pOHYTDysS1PjUo8CxjVYi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `id_empresa` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`id_empresa`, `nombre`, `direccion`, `cp`, `telefono`, `email`, `latitud`, `longitud`) VALUES
(1, 'Astur Aventura', 'Calle de la amistad, 15', '33560', '666777888', 'astur@aventura.com', 43.466049, -5.063184),
(2, 'Kayak Ribadesella', 'Paseo del arroyo, 17', '33560', '666777888', 'kayak@aventura.com', 43.467887, -5.076392),
(3, 'Costa Norte Vela', 'Mirador del mar, S/N', '33710', '666777888', 'costa@aventura.com', 43.554675, -6.720822),
(4, 'Naranjo Escalada', 'Calle Vera, 1', '33710', '666777888', 'naranjo@aventura.com', 43.537046, -6.723365),
(5, 'Aventura Norte', 'Paseo de la luna, 9', '33201', '666777888', 'aventura@aventura.com', 43.540491, -5.652595),
(6, 'Deportes de agua Gijón', 'Camin del monte alto, 45', '33201', '666777888', 'deportes@aventura.com', 43.54819, -5.609615),
(7, 'Luarca Aventura', 'Calle de los fruteros , 12', '33700', '666777888', 'luarca@aventura.com', 43.560087, -6.623297),
(8, 'Valle Verde', 'Calle San Antony , 24', '33500', '666777888', 'valle@aventura.com', 43.42023, -4.750342),
(9, 'Ocio y Aventura Picos de Europa', 'Avenida de las estrellas, 13', '33500', '666777888', 'ocio@aventura.com', 43.420822, -4.755278),
(10, 'Descensos Sella', 'Paseo  Princesa , 8', '33560', '666777888', 'descensos@aventura.com', 43.46351, -5.058582),
(11, 'Somiedo Aventura', 'Calle Río , 6', '33840', '666777888', 'somiedo@aventura.com', 43.094716, -6.256864),
(12, 'Multiaventura Norte', 'Calle de la aventura , 5', '33320', '666777888', 'multiaventura@aventura.com', 43.303113, -4.817178),
(13, 'Cangas Multiaventura', 'Calle Puente 12', '33550', '666777888', 'cangas@aventura.com', 43.350579, -5.13205),
(14, 'Turismo Activo Senda de Oso', 'Calle Lorem, 3', '33840', '666777888', 'turismo@aventura.com', 43.092788, -6.25511),
(15, 'Asturias Adventure', 'Senda Río Lorem, 6', '33555', '666777888', 'asturias@aventura.com', 43.301477, -4.816094);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL,
  `id_empresa` int(45) NOT NULL,
  `id_actividad` int(45) NOT NULL,
  `id_cliente` int(45) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `num_plazas` int(11) NOT NULL,
  `prereserva` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id_reserva`, `id_empresa`, `id_actividad`, `id_cliente`, `fecha_reserva`, `num_plazas`, `prereserva`) VALUES
(46, 2, 2, 20, '2025-01-12', 2, 0),
(47, 6, 12, 22, '2025-01-15', 3, 0),
(48, 1, 4, 20, '2025-01-19', 3, 0),
(49, 3, 19, 23, '2025-01-19', 8, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposaventura`
--

CREATE TABLE `tiposaventura` (
  `id_tipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tiposaventura`
--

INSERT INTO `tiposaventura` (`id_tipo`, `nombre`) VALUES
(1, 'kayak'),
(2, 'Senderismo'),
(3, 'Paseo en barco'),
(5, 'Montar a caballo'),
(6, 'Buceo'),
(7, 'Paracaidismo'),
(8, 'Esquí'),
(9, 'Barranquismo'),
(10, 'Puenting'),
(11, 'Parapente'),
(12, 'Escalada'),
(13, 'Vela'),
(14, 'Surf'),
(15, 'Windfoil'),
(16, 'Kitesurf'),
(17, 'Windsurf'),
(18, 'Tiro con arco'),
(19, 'Rutas en bici'),
(20, 'Rafting');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`id_actividad`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD PRIMARY KEY (`cp`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`id_empresa`),
  ADD KEY `cp` (`cp`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `id_empresa` (`id_empresa`),
  ADD KEY `id_actividad` (`id_actividad`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `tiposaventura`
--
ALTER TABLE `tiposaventura`
  ADD PRIMARY KEY (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `id_actividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `empresas`
--
ALTER TABLE `empresas`
  MODIFY `id_empresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `tiposaventura`
--
ALTER TABLE `tiposaventura`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `id_tipo` FOREIGN KEY (`id_tipo`) REFERENCES `tiposaventura` (`id_tipo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD CONSTRAINT `cp` FOREIGN KEY (`cp`) REFERENCES `ciudades` (`cp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `id_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividades` (`id_actividad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_empresa` FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id_empresa`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
