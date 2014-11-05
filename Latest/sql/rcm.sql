-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 18, 2014 at 11:22 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `eco_recycle_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `rcm`
--

CREATE TABLE IF NOT EXISTS `rcm` (
  `rcm_id` int(11) NOT NULL,
  `location` text NOT NULL,
  `status` text,
  `total_items` int(255) DEFAULT NULL,
  `current_amount` double DEFAULT NULL,
  `max_weight` double DEFAULT NULL,
  `max_volume` double DEFAULT NULL,
  `current_weight` double DEFAULT NULL,
  `current_volume` double DEFAULT NULL,
  `last_removal_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`rcm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rcm`
--

INSERT INTO `rcm` (`rcm_id`, `location`, `status`, `total_items`, `current_amount`, `max_weight`, `max_volume`, `current_weight`, `current_volume`, `last_removal_date`) VALUES
(1, 'Santa Barbara', 'ACTIVE', 27, 600, 1000, 100, 700, 90, '2014-03-10 07:00:00'),
(2, 'Santa Clara', 'ACTIVE', 36, 500, 1000, 100, 800, 95, '2014-03-02 08:00:00'),
(3, 'San Francisco', 'ACTIVE', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'Santa Cruz', 'ACTIVE', 0, 7000, 600, 100, 0, 0, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
