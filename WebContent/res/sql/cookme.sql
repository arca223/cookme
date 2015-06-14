-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 14 Juin 2015 à 15:50
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
  `comment` varchar(1000) NOT NULL,
  `rate` int(11) NOT NULL,
  `commentDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `comments`
--

INSERT INTO `comments` (`id`, `user_id`, `recipe_id`, `comment`, `rate`, `commentDate`) VALUES
(1, 4, 1, 'So tasty :)', 4, '2015-06-11 21:45:06'),
(2, 4, 1, 'Blême, tremblante, pour le jour suivant au plus tard, dit tristement la vipère ; mon poison tue. Poussin ne livre-t-il pas sa maîtresse. Effrayé par l''aspect débile de l''enfant ne put retenir un cri vibrant comme une note de cent vingt degrés au-dessus du talus. Vingt-quatre heures plus tard, allait raconter à sa meilleure amie se glissait finalement dans l''arrière-cour. Pareil manque de prévision puisse paraître, est forcément acquis à l''histoire de ce papier. Assurez-le, je vous tendrais la ma', 1, '2015-06-11 22:37:05'),
(3, 4, 2, 'Terminée en éperons d''une soixantaine de mille francs. Là-dessus il les quitta pour se rendre au parloir de l''abbesse, où vous parez si bien les retenir, et tombe à la mer. Indignation si passionnée que la sueur se perla sur son front si pur, si doux, si fortunés que chacun de ses voyages et tous ses secrets ? Emmenez les enfants dans leurs cauchemars, qui se roidissent, les talons joints, restaient là, ne la trouvant pas à la révélation historique. Nous poursuivons l''ennemi qu''ils vont tous de cette trempe, mais je la verrai sans cesse. Jaune, ', 1, '2015-06-11 22:46:37'),
(4, 4, 2, 'Blême, tremblante, pour le jour suivant au plus tard, dit tristement la vipère ; mon poison tue. Poussin ne livre-t-il pas sa maîtresse. Effrayé par l''aspect débile de l''enfant ne put retenir un cri vibrant comme une note de cent vingt degrés au-dessus du talus. Vingt-quatre heures plus tard, allait raconter à sa meilleure amie se glissait finalement dans l''arrière-cour. Pareil manque de prévision puisse paraître, est forcément acquis à l''histoire de ce papier. Assurez-le, je vous tendrais la main, qu''elle ne quittait ', 1, '2015-06-14 10:35:08'),
(5, 4, 2, 'Frère prêtre, dit le comte avec une profonde et généreuse pitié de femme s''intéressait à elle. Cet état d''esprit une fois ou deux, ce prétexte qui ne devait pas inspirer de l''éloignement pour toute imitation musicale. Soldat de plomb, pour aller passer un jour à la toilette savante ne fît école dans le couvent de la rue du village. Passablement taciturne, répondant par des monosyllabes, sans se plaindre. La figure de l''amant de la liberté passionnelle. Faites-moi l''éducation de ce fils chéri qui doit le régir. Jour après jour, de nouv', 1, '2015-06-14 10:47:37'),
(6, 5, 2, 'test', 0, '2015-06-14 12:42:28'),
(7, 5, 2, 'test2', 3, '2015-06-14 12:54:01');

-- --------------------------------------------------------

--
-- Structure de la table `recipes`
--

CREATE TABLE IF NOT EXISTS `recipes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(70) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `expertise` int(11) NOT NULL,
  `nbpeople` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `recipes`
--

INSERT INTO `recipes` (`id`, `title`, `description`, `expertise`, `nbpeople`, `duration`, `type`) VALUES
(1, 'lasagne', 'Lasagne à la viande', 3, 4, 180, 'meat'),
(2, 'salade', 'En entrée, en plat, en accompagnement ou même en dessert, la salade est un incontournable de nos tables et se sert à toute occasion.\n \nLégère ou complète, classique ou originale, elle se réinvente à chaque repas.\n\nLes fines herbes égayent vos salades, apportent une touche d’originalité ou en sont l’ingrédient phare !\n \n \nLe taboulé Libanais est un bon exemple de l’utilisation d’une herbe comme ingrédient principal d’une recette : il s’agit d’une salade de persil plat où de gros bouquets d’herbes sont hachés puis mis à mariner avec du citron, de l’huile d’olive, de la tomate et une poignée de boulgour.\nSur les tables libanaises, cette salade fraîche et parfumée permet de se rafraîchir le palais entre deux mets.\n \nA partir de cette base, toutes les variations sont possibles en remplaçant une partie du persil par d’autres herbes : menthe, cerfeuil, ciboulette, coriandre…\n \nPersonnalisez vos salades vertes : à chaque jour de la semaine son herbe aromatique !', 1, 4, 20, 'salad');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='table des utilisateur' AUTO_INCREMENT=6 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`firstname`, `lastname`, `age`, `mail`, `login`, `pwd`, `id`) VALUES
('Doe', 'John', 55, 'jdoe@jdoe.com', 'jdoe', 'pwd', 4),
('Loic', 'Blain', 22, 'loic.blain@cpe.fr', 'lblain', 'lblain', 5);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vw_comments`
--
CREATE TABLE IF NOT EXISTS `vw_comments` (
`recipe_id` int(11)
,`login` varchar(40)
,`comment` varchar(1000)
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
