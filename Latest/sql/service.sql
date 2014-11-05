-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 18, 2014 at 11:21 PM
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
-- Table structure for table `service`
--

CREATE TABLE IF NOT EXISTS `service` (
  `service_no` int(11) NOT NULL,
  `rcm_id` int(11) NOT NULL,
  `time_emptyed` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `weight` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`service_no`, `rcm_id`, `time_emptyed`, `weight`) VALUES
(1, 1, '2014-01-02 08:00:00', 250),
(2, 2, '2014-01-08 08:00:00', 790),
(3, 1, '2014-03-19 07:00:00', 890),
(4, 2, '2014-02-05 08:00:00', 900),
(5, 2, '2014-02-11 08:00:00', 850),
(6, 1, '2014-02-19 08:00:00', 970),
(7, 2, '2014-02-25 08:00:00', 940),
(7, 2, '2014-02-26 08:00:00', 920),
(8, 1, '2014-03-02 08:00:00', 770),
(9, 1, '2014-03-11 07:00:00', 690),
(10, 2, '2014-03-14 07:00:00', 980);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
