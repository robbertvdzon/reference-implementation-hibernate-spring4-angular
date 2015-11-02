-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 24 feb 2015 om 19:50
-- Serverversie: 5.6.12-log
-- PHP-versie: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `contact`
--
CREATE DATABASE IF NOT EXISTS `contact` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `contact`;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `contacts`
--

CREATE TABLE IF NOT EXISTS `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `UUID` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `contacts`
--


INSERT INTO `contacts` ( `id`, `user_id`, `name`, `email`, `UUID`) VALUES
( 0,1, 'john', 'john@gmail.com', '1234'),
( 1,1, 'cindy', 'cindy@gmail.com', '1235'),
( 2,0, 'peter', 'peter@gmail.com', '1236');


-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `sequences`
--

CREATE TABLE IF NOT EXISTS `sequences` (
  `SEQ_NAME` varchar(32) NOT NULL,
  `SEQ_NUMBER` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `sequences`
--

INSERT INTO `sequences` (`SEQ_NAME`, `SEQ_NUMBER`) VALUES
('CONTACT_ID', 6);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `passwd` varchar(255) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `users`
--

INSERT INTO  `users` (`id`, `username`, `passwd`, `uuid`) VALUES
( 0,'q', 'q', '2347'),
( 1,'robbert', 'robbert', '2345'),
( 2,'john', 'pw', '2346');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
