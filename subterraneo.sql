-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 11, 2018 at 04:04 AM
-- Server version: 8.0.13
-- PHP Version: 7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `subterraneo`
--

-- --------------------------------------------------------

--
-- Table structure for table `edge`
--

CREATE TABLE `edge` (
  `edge_id` int(11) NOT NULL,
  `nodea_node_id` int(11) DEFAULT NULL,
  `nodeb_node_id` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `edge`
--

INSERT INTO `edge` (`edge_id`, `nodea_node_id`, `nodeb_node_id`, `weight`) VALUES
(7, 5, 9, 1),
(6, 5, 8, 1),
(5, 5, 7, 1),
(4, 5, 6, 1),
(3, 1, 4, 1),
(2, 1, 3, 1),
(1, 1, 2, 1),
(8, 10, 11, 1),
(9, 10, 12, 1),
(10, 10, 13, 1),
(11, 14, 15, 1),
(12, 14, 16, 1),
(13, 17, 18, 1),
(14, 17, 19, 1),
(15, 20, 21, 1),
(16, 20, 22, 1),
(17, 23, 24, 1),
(18, 23, 25, 1),
(19, 23, 26, 1),
(20, 23, 27, 1),
(21, 23, 28, 1),
(22, 29, 30, 1),
(23, 29, 31, 1),
(24, 29, 32, 1),
(25, 33, 34, 1),
(26, 33, 35, 1),
(27, 33, 36, 1),
(28, 33, 37, 1),
(29, 38, 39, 1),
(30, 38, 40, 1),
(31, 41, 42, 1),
(32, 41, 43, 1),
(33, 41, 44, 1),
(34, 41, 45, 1),
(35, 46, 47, 1),
(36, 46, 48, 1),
(37, 46, 49, 1),
(38, 50, 51, 1),
(39, 50, 52, 1),
(40, 50, 53, 1),
(41, 54, 55, 1),
(42, 54, 56, 1),
(43, 54, 57, 1),
(44, 54, 58, 1),
(45, 59, 60, 1),
(46, 59, 61, 1),
(47, 2, 6, 4),
(48, 6, 11, 4),
(49, 11, 24, 4),
(50, 24, 15, 4),
(51, 15, 18, 4),
(52, 18, 21, 4),
(53, 3, 7, 4),
(54, 7, 42, 4),
(55, 42, 47, 4),
(56, 47, 51, 4),
(57, 51, 55, 4),
(58, 55, 34, 4),
(59, 34, 39, 4),
(60, 4, 8, 4),
(61, 8, 12, 4),
(62, 12, 25, 4),
(63, 25, 43, 4),
(64, 43, 48, 4),
(65, 48, 52, 4),
(66, 52, 56, 4),
(67, 56, 60, 4),
(68, 40, 35, 4),
(69, 35, 30, 4),
(70, 30, 26, 4),
(71, 26, 44, 4),
(72, 22, 19, 4),
(73, 19, 16, 4),
(74, 16, 27, 4),
(75, 27, 31, 4),
(76, 31, 36, 4),
(77, 36, 57, 4),
(78, 57, 61, 4),
(79, 9, 13, 4),
(80, 13, 28, 4),
(81, 28, 32, 4),
(82, 32, 37, 4),
(83, 37, 58, 4),
(84, 58, 53, 4),
(85, 53, 49, 4),
(86, 49, 45, 4),
(87, 45, 9, 4);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2),
(2);

-- --------------------------------------------------------

--
-- Table structure for table `node`
--

CREATE TABLE `node` (
  `node_id` int(11) NOT NULL,
  `route_route_id` int(11) DEFAULT NULL,
  `station_station_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `node`
--

INSERT INTO `node` (`node_id`, `route_route_id`, `station_station_id`) VALUES
(1, 0, 1),
(2, 1, 1),
(3, 2, 1),
(4, 3, 1),
(5, 0, 2),
(6, 1, 2),
(7, 2, 2),
(8, 3, 2),
(9, 6, 2),
(10, 0, 3),
(11, 1, 3),
(12, 3, 3),
(13, 6, 3),
(14, 0, 4),
(15, 1, 4),
(16, 5, 4),
(17, 0, 5),
(18, 1, 5),
(19, 5, 5),
(20, 0, 6),
(21, 1, 6),
(22, 5, 6),
(23, 0, 7),
(24, 1, 7),
(25, 3, 7),
(26, 4, 7),
(27, 5, 7),
(28, 6, 7),
(29, 0, 8),
(30, 4, 8),
(31, 5, 8),
(32, 6, 8),
(33, 0, 9),
(34, 2, 9),
(35, 4, 9),
(36, 5, 9),
(37, 6, 9),
(38, 0, 10),
(39, 2, 10),
(40, 4, 10),
(41, 0, 11),
(42, 2, 11),
(43, 3, 11),
(44, 4, 11),
(45, 6, 11),
(46, 0, 12),
(47, 2, 12),
(48, 3, 12),
(49, 6, 12),
(50, 0, 13),
(51, 2, 13),
(52, 3, 13),
(53, 6, 13),
(54, 0, 14),
(55, 2, 14),
(56, 3, 14),
(57, 5, 14),
(58, 6, 14),
(59, 0, 15),
(60, 3, 15),
(61, 5, 15);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `route_id` int(11) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`route_id`, `color`, `name`) VALUES
(1, '#ff0000', 'Ruta A'),
(2, '#663300', 'Ruta B'),
(3, '#008000', 'Ruta C'),
(4, '#ffff00', 'Ruta D'),
(5, '#0000ff', 'Ruta E'),
(6, '#000000', 'Ruta F'),
(0, 'DEFAULT', 'DEFAULT');

-- --------------------------------------------------------

--
-- Table structure for table `station`
--

CREATE TABLE `station` (
  `station_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `station`
--

INSERT INTO `station` (`station_id`, `name`) VALUES
(1, '1'),
(2, '2'),
(3, '3'),
(4, '4'),
(5, '5'),
(6, '6'),
(7, '7'),
(8, '8'),
(9, '9'),
(10, '10'),
(11, '11'),
(12, '12'),
(13, '13'),
(14, '14'),
(15, '15');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `active`, `email`, `last_name`, `name`, `password`) VALUES
(1, 1, 'eeeee@eee.com', 'Ospina', 'Daniel', '$2a$10$d0gbwEm4YS8jjcEI8taLKOt4pYhrFA88Vu0l7xLy5qW6.bftGBjMO');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `edge`
--
ALTER TABLE `edge`
  ADD PRIMARY KEY (`edge_id`),
  ADD KEY `FKg3xkt4adesffhpydp9e8ancgl` (`nodea_node_id`),
  ADD KEY `FKn884i2sirc110qw9jbdldxs1` (`nodeb_node_id`);

--
-- Indexes for table `node`
--
ALTER TABLE `node`
  ADD PRIMARY KEY (`node_id`),
  ADD KEY `FK8gqsaopxi1ycgtv3eg3rfo5w2` (`route_route_id`),
  ADD KEY `FKtgasrlhk8hlxmxi39nuioi5v7` (`station_station_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`station_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
