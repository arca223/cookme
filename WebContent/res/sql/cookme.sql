-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 11 Juin 2015 à 23:50
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
-- Structure de la table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `recipe_id` int(11) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `rate` int(11) NOT NULL,
  `commentDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `comments`
--

INSERT INTO `comments` (`id`, `user_id`, `recipe_id`, `comment`, `rate`, `commentDate`) VALUES
(1, 4, 1, 'So tasty :)', 4, '2015-06-11 21:45:06');

-- --------------------------------------------------------

--
-- Structure de la table `recipes`
--

CREATE TABLE IF NOT EXISTS `recipes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(70) NOT NULL,
  `description` varchar(500) NOT NULL,
  `expertise` int(11) NOT NULL,
  `nbpeople` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `recipes`
--

INSERT INTO `recipes` (`id`, `title`, `description`, `expertise`, `nbpeople`, `duration`, `type`) VALUES
(1, 'lasagne', 'Lasagne à la viande', 3, 4, 180, 'meat');

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

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vw_comments`
--
CREATE TABLE IF NOT EXISTS `vw_comments` (
`recipe_id` int(11)
,`login` varchar(40)
,`comment` varchar(500)
,`rate` int(11)
,`commentDate` timestamp
);
-- --------------------------------------------------------

--
-- Structure de la vue `vw_comments`
--
DROP TABLE IF EXISTS `vw_comments`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_comments` AS select `c`.`recipe_id` AS `recipe_id`,`u`.`login` AS `login`,`c`.`comment` AS `comment`,`c`.`rate` AS `rate`,`c`.`commentDate` AS `commentDate` from ((`comments` `c` join `recipes` `r` on((`r`.`id` = `c`.`recipe_id`))) join `users` `u` on((`u`.`id` = `c`.`user_id`)));

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
