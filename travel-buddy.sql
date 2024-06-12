-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2024 at 05:12 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel-buddy`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `email`, `first_name`, `last_name`, `mobile_number`, `password`) VALUES
(1, '123@gmail.com', 'Josh', 'Ambrose', '123', '123'),
(2, 'josh.ambrose@gmail.com', 'Joshua', 'Ambrose', '3365091955', ''),
(3, '123@gmail.com', 'Laith', 'Almesad', '123456789', 'password123'),
(4, '12345@gmail.com', 'naithan', 'something', '987654321', '123');

-- --------------------------------------------------------

--
-- Table structure for table `customer_trip`
--

CREATE TABLE `customer_trip` (
  `customer_id` int(11) NOT NULL,
  `trip_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_trip`
--

INSERT INTO `customer_trip` (`customer_id`, `trip_id`) VALUES
(1, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 7),
(4, 8);

-- --------------------------------------------------------

--
-- Table structure for table `provider`
--

CREATE TABLE `provider` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `provider`
--

INSERT INTO `provider` (`id`, `email`, `mobile_number`, `name`, `password`) VALUES
(1, 'joshambrose', NULL, 'Josh', '12345'),
(302, 'american@aol.com', '12345678', 'American', '123'),
(1002, 'delta@gmail.com', '123', 'Delta', '123,123');

-- --------------------------------------------------------

--
-- Table structure for table `provider_seq`
--

CREATE TABLE `provider_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `provider_seq`
--

INSERT INTO `provider_seq` (`next_val`) VALUES
(1101);

-- --------------------------------------------------------

--
-- Table structure for table `response`
--

CREATE TABLE `response` (
  `id` int(11) NOT NULL,
  `response` varchar(255) DEFAULT NULL,
  `review_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `response`
--

INSERT INTO `response` (`id`, `response`, `review_id`) VALUES
(2, 'ok cool', 5);

-- --------------------------------------------------------

--
-- Table structure for table `response_seq`
--

CREATE TABLE `response_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `response_seq`
--

INSERT INTO `response_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `comment`, `rating`, `customer_id`, `trip_id`) VALUES
(5, '/this was tooo cold', 2, 4, 8);

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `id` int(11) NOT NULL,
  `departure` varchar(255) DEFAULT NULL,
  `departuredate` date DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `providerid` int(11) NOT NULL,
  `returndate` date DEFAULT NULL,
  `specials` bit(1) NOT NULL,
  `city` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `departure`, `departuredate`, `location`, `price`, `providerid`, `returndate`, `specials`, `city`) VALUES
(752, 'Greensboro', '2024-06-14', 'Russia', 500, 1002, '2024-06-28', b'0', 'Moscow'),
(753, 'Raleigh', '2024-06-14', 'Brazil', 600, 1002, '2024-06-22', b'0', 'Braziland');

-- --------------------------------------------------------

--
-- Table structure for table `services_seq`
--

CREATE TABLE `services_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `services_seq`
--

INSERT INTO `services_seq` (`next_val`) VALUES
(851);

-- --------------------------------------------------------

--
-- Table structure for table `trip`
--

CREATE TABLE `trip` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `special_flag` bit(1) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `departure` varchar(255) DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  `providerid` int(11) NOT NULL,
  `return_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trip`
--

INSERT INTO `trip` (`id`, `description`, `destination`, `price`, `special_flag`, `city`, `customer_id`, `departure`, `departure_date`, `providerid`, `return_date`) VALUES
(3, NULL, 'Brazil', 500, b'1', 'Rio de Janeiro', 1, 'Greensboro', '2024-06-20', 302, '2024-06-30'),
(4, NULL, 'China', 500000, b'1', 'Beijing', 2, 'Greensboro', '2024-06-28', 302, '2024-07-04'),
(5, NULL, 'Russia', 800, b'0', 'Moscow', 2, 'Raleigh', '2024-07-04', 953, '2024-07-06'),
(6, NULL, 'Thailand', 700, b'0', 'Thailand place', 2, 'Greensboro', '2024-07-04', 953, '2024-07-06'),
(7, NULL, 'Brazil', 600, b'0', 'Braziland', 3, 'Raleigh', '2024-06-14', 1002, '2024-06-22'),
(8, NULL, 'Russia', 500, b'0', 'Moscow', 4, 'Greensboro', '2024-06-14', 1002, '2024-06-28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_trip`
--
ALTER TABLE `customer_trip`
  ADD KEY `FK17qqjqjb4no3twx9kp5ejhx12` (`trip_id`),
  ADD KEY `FKk840pt3wlgex4tyl0f9l38kan` (`customer_id`);

--
-- Indexes for table `provider`
--
ALTER TABLE `provider`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `response`
--
ALTER TABLE `response`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9otefep1uaeu0j643qjsa0u4v` (`review_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgce54o0p6uugoc2tev4awewly` (`customer_id`),
  ADD KEY `FKsdujhwxnw678xtqnvqre9gl3h` (`trip_id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `trip`
--
ALTER TABLE `trip`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer_trip`
--
ALTER TABLE `customer_trip`
  ADD CONSTRAINT `FK17qqjqjb4no3twx9kp5ejhx12` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`),
  ADD CONSTRAINT `FKk840pt3wlgex4tyl0f9l38kan` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Constraints for table `response`
--
ALTER TABLE `response`
  ADD CONSTRAINT `FK9otefep1uaeu0j643qjsa0u4v` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FKgce54o0p6uugoc2tev4awewly` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKsdujhwxnw678xtqnvqre9gl3h` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
