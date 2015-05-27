-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 27 Mai 2015 à 14:21
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `cookme`
--

-- --------------------------------------------------------

--
-- Structure de la table `recipes`
--

CREATE TABLE IF NOT EXISTS `recipes` (
  `title` varchar(40) NOT NULL,
  `description` text NOT NULL,
  `expertise` int(11) NOT NULL,
  `nbpeople` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `type` varchar(40) NOT NULL,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `recipes`
--

INSERT INTO `recipes` (`title`, `description`, `expertise`, `nbpeople`, `duration`, `type`) VALUES
('Fish Salad', 'bla bla bal bla', 5, 10, 180, 'salad'),
('Fresh Meat', 'bla bla bal bla', 1, 1, 20, 'meat'),
('Lasagne', 'Lasagne à la viande', 1, 4, 3, 'plat'),
('pain', 'Faire du bon pain', 2, 1, 2, 'pain');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `age` int(11) NOT NULL,
  `mail` varchar(40) NOT NULL,
  `login` varchar(40) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`firstname`,`lastname`,`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='table des utilisateur' AUTO_INCREMENT=5 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`firstname`, `lastname`, `age`, `mail`, `login`, `pwd`, `id`) VALUES
('Doe', 'John', 55, 'jdoe@jdoe.com', 'jdoe', 'pwd', 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
