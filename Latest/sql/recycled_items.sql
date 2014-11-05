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
-- Table structure for table `recycled_items`
--

CREATE TABLE IF NOT EXISTS `recycled_items` (
  `transaction_id` int(11) NOT NULL,
  `rcm_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `weight` double NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `payment_type` text NOT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recycled_items`
--

INSERT INTO `recycled_items` (`transaction_id`, `rcm_id`, `item_id`, `weight`, `time`, `payment_type`) VALUES
(1, 2, 1, 35, '2014-01-02 08:00:00', 'COUPON'),
(2, 1, 3, 29, '2014-02-22 08:00:00', 'COUPON'),
(3, 1, 1, 15, '2014-02-18 08:00:00', 'CASH'),
(4, 2, 3, 56.5, '2014-02-20 08:00:00', 'COUPON'),
(5, 2, 2, 53, '2014-03-10 07:00:00', 'COUPON'),
(6, 1, 1, 66, '2014-03-09 08:00:00', 'CASH'),
(7, 1, 4, 36, '2014-01-07 08:00:00', 'COUPON'),
(8, 2, 2, 35, '2014-01-05 08:00:00', 'CASH'),
(9, 2, 3, 70, '2014-03-08 21:07:21', 'CASH'),
(10, 1, 1, 89, '2014-03-12 20:06:37', 'COUPON'),
(11, 2, 4, 25, '2014-03-11 07:00:00', 'COUPON'),
(12, 2, 2, 48, '2014-03-01 08:00:00', 'CASH'),
(13, 1, 1, 100, '2014-03-14 19:57:46', 'CASH'),
(14, 1, 2, 60, '2014-03-14 19:57:57', 'CASH'),
(15, 2, 3, 120, '2014-03-14 19:58:08', 'CASH'),
(16, 2, 2, 60, '2014-03-14 19:58:20', 'CASH'),
(17, 2, 1, 100, '2014-03-14 19:58:55', 'CASH'),
(18, 1, 2, 60, '2014-03-14 19:59:32', 'CASH'),
(19, 1, 1, 100, '2014-03-14 19:59:41', 'CASH'),
(20, 1, 2, 60, '2014-03-14 19:59:56', 'CASH'),
(21, 2, 3, 120, '2014-03-14 20:00:24', 'CASH'),
(22, 2, 2, 60, '2014-03-14 20:00:51', 'CASH'),
(23, 3, 1, 100, '2014-03-14 20:01:38', 'CASH'),
(24, 3, 2, 60, '2014-03-14 20:02:54', 'CASH');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
