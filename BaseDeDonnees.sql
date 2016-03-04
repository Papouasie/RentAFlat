-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: 127.0.0.1
-- Généré le : Ven 04 Mars 2016 à 00:04
-- Version du serveur: 5.1.54
-- Version de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `utilisateurs`
--

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `contact_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contact_mail` varchar(255) DEFAULT NULL,
  `contact_msg` text,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=32 ;

--
-- Contenu de la table `contact`
--


-- --------------------------------------------------------

--
-- Structure de la table `logement`
--

CREATE TABLE IF NOT EXISTS `logement` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT,
  `l_ville` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_pays` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_adresse` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_CP` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_region` varchar(255) NOT NULL,
  `l_title` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_img` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_type` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_reference` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_price` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_charges` varchar(50) NOT NULL DEFAULT 'non connu(e)',
  `l_quarter` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_description` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_surface` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_parution` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_pieces` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_ascence` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_terrasse` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_mandat` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_wc` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_sdb` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_chauffage` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_build` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_nameL` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_emailL` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_surnameL` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_numberL` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_etat` varchar(255) NOT NULL DEFAULT 'non connu(e)',
  `l_enabled` int(3) NOT NULL,
  `l_total_commands` varchar(255) DEFAULT NULL,
  `l_username` varchar(255) NOT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=108 ;

--
-- Contenu de la table `logement`
--

INSERT INTO `logement` (`l_id`, `l_ville`, `l_pays`, `l_adresse`, `l_CP`, `l_region`, `l_title`, `l_img`, `l_type`, `l_reference`, `l_price`, `l_charges`, `l_quarter`, `l_description`, `l_surface`, `l_parution`, `l_pieces`, `l_ascence`, `l_terrasse`, `l_mandat`, `l_wc`, `l_sdb`, `l_chauffage`, `l_build`, `l_nameL`, `l_emailL`, `l_surnameL`, `l_numberL`, `l_etat`, `l_enabled`, `l_total_commands`, `l_username`) VALUES
(67, 'STRASBOURG', 'FRANCE', '6, rue de la paix', '67090', '', 'Location Appartement 2 pièces 58 m², Strasbourg (67000)', '/img/slider1.jpg', 'Appartement', '69707MX1146', '875,00€', '80,00€', 'Quartier Contades - République', 'Quai Mullenheim, au calme dans la verdure, à proximité des institutions européennes et du centre-ville, beau 2 pièces avec magnifique jardin privatif récent à louer. Il se compose : - d''un séjour avec accès direct à la terrasse sur jardin- d''une cuisine a', '58 m²', '05/02/2016', '2', 'OUI', '32', 'Exclusif', '2', '2', 'Non inclus dans les charges', '10ans', 'MEYER', 'meyer.maxime@email.com', 'MAXIME', '0666302414', 'Disponible', 1, NULL, ''),
(68, 'SCHILTIGHEIM', 'FRANCE', '15, grand rue', '67080', '', 'Petit studio pour étudiant(s)', '/img/slider1.jpg', 'Studio', 'OIKD5X35', '380€', '50,00€', 'Centre ville', 'Petit studio en plein centre ville. Parfait pour un étudiant.', '35 m²', '28/02/2016', '2', 'NON', 'NON', 'Exclusif', '1', '1', 'Non inclus dans les charges', '31/05/2010', 'MEYER', 'nedjma.benelhadj@gmail.com', 'Paul', '0666302414', 'Disponible dès mai 2016', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(69, 'STRASBOURG', 'France', '1, rue d''éguisheim', '67100', '', 'Superbe 5 pièces à Neudorf', '/img/slider1.jpg', 'Appartement Duplex', 'Exclusif', '1090,00€', '90,00€', 'Neudorf, Strasbourg', 'Suberbe 2 pièces à Strasbourg Neudorf. Près des commerce, avec Jardin pour enfants. Boulangerie, pharmacie, et supermarché à proximité', '180 m²', '12/02/2016', '5', 'NON', '2', 'Exclusif', '2', '2', 'Non inclus dans les charges', '31/12/2013', 'BENELHADJ', 'nedjma.benelhadj@gmail.com', 'Nedjma', '0666302414', 'Dès juin 2016', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(75, 'MULHOUSE', 'FRANCE', '13, rue du bonhomme', '68100', 'Alsace', 'Charmant 4 pièces près de la gare à Mulhouse', '/img/slider1.jpg', 'Appartement duplex', 'OEJNINRG59C', '580,00€', '85,00€', 'Rebberg', 'Charmant duplex en bas du Rebberg à Mulhouse. A 5min à pied de la gare. Quartier calme. Commerces de proximités', '85 m²', '28/01/2016', '4', 'NON', 'NON', 'Exclusif', '1', '1', 'Inclus dans les charges', '28/05/2008', 'ZIMMERMANN', 'charles.zimmermann.10@gmail.com', 'Charles', '0612652578', 'Disponible', 1, NULL, ''),
(76, 'STRASBOURG', 'FRANCE', '33, avenue Jean Jaurès', '67100', 'Alsace', 'Superbe 2 pièces à Neudorf', '/img/slider1.jpg', 'Appartement', 'CLEJRNFB28', '940,00€', '76,00€', 'Neudorf', 'Superbe 2 pièces à Neudorf. Tram D, C et E à proximité', '87 m²', '02/01/2016', '2', 'OUI', 'OUI', 'Exclusif', '1', '1', 'Inclus dans les charges', '10/10/2002', 'ZIMMERMANN', 'charles.zimmermann.10@gmail.com', 'Charles', '0612652578', 'Disponible', 1, NULL, ''),
(78, 'STRASBOURG', 'France', '1, place de Zurich', '67020', 'Alsace', 'Appartement en plein coeur de la krutenau', '/img/slider1.jpg', 'Appartement', 'ELRO55OKX', '650,00€', '94,00€', 'Krutenau', 'Spacieux 2 pièces au centre ville, à la Krutenau. Commerces/supermarché, Boulanger, Restaurants à proximité - Proche du quai des bateliers et de la place d''austerlitz', '68 m²', '12/02/2016', '2', 'OUI', 'OUI, balcon', 'Exclusif', '1', '1', 'Inclus dans les charges', '10/12/2003', 'Keila', 'keila@locavacances.fr', 'Le Chat', '0666302414', 'Disponible dès septembre 2016', 1, NULL, ''),
(95, '', '', '', '', '', 'jujujuju', '/img/slider1.jpg', '', '1L3GGWW8GE3LB2C', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'BENELHADJ', 'nedjma.benelhadj@gmail.com', 'Nedjma', '0666302414', '', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(96, '', '', '', '', '', 'essai', 'images/mmdh3vjmqmxpujn.png', '', 'MMDH3VJMQMXPUJN', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'test', '', '', '', '', 1, NULL, ''),
(97, '', '', '', '', '', 'mon logement avec mon adresse', 'images/fueh59hfw5w7erh.png', '', 'FUEH59HFW5W7ERH', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'BENELHADJ', 'nedjma.benelhadj@gmail.com', 'Nedjma', '0666302414', '', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(98, 'Mulhouse', 'France', '13 rue des frères lumière', '68200', 'Haut-Rhin', 'Studio étudiant à côté du campus', 'images/2vnq6a6qj9jbssk.png', 'Studio', '2VNQ6A6QJ9JBSSK', '250', '10', 'Illberg', 'Petit studio juste à côté du campus de l''Illberg, idéal pour un étudiant', '20', '02/03/2016', '1', 'NON', 'non', '', '1', '1', 'inclus', '28/05/2008', 'ZIMMERMANN', 'charles.zimmermann.10@gmail.com', 'Charles', '0612652578', 'immédiate', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(99, 'Paris', 'France', '13 rue des épées', '75007', 'Ile de france', '2 pièces tout confort dans le marais', 'images/c5dhtxql3d8jbqg.png', 'Appartement', 'C5DHTXQL3D8JBQG', '850', '50', 'Le marais', '2 pièces très lumineux et entièrement rénové', '42', '', '2', 'NON', 'NON', '', '1', '1', 'Oui', '12/12/1897', 'Antoine', 'a.bruere@hotmail.fr', 'BRUERE', '0123456789', 'Immédiate', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(100, 'Paris', 'France', '12 rue de l''école', '75018', 'Ile de france', 'Grand studio à Barbes', 'images/6vns2c3gl2eqof3.png', 'Studio', '6VNS2C3GL2EQOF3', '650', '36', 'Barbes Rochefort', 'Grand studio avec garage à vélo', '32', '', '1', 'NON', 'NON', '', '1', '1', 'oui', '30/06/1895', 'Francois', 'F.Behr@hotmail.fr', 'BEHR', '9876543210', 'A partir du 01/04/2016', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(101, 'Mulhouse', 'France', '41 rue reichenstein', '68100', 'Haut-Rhin', 'Maison dans le rebberg', 'images/l2jasqa9z1pbzff.png', 'Maison', 'L2JASQA9Z1PBZFF', '800', '200', 'Rebberg', 'Grand maison idéalement placée au centre du pâté de maison', '320', '', '11', 'NON', 'OUI', '', '2', '2', 'Oui', '23/03/1994', 'Keller', 'dcazimmer@evhr.net', 'Laurence', '0389650650', 'A partir du 01/06/2016', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(102, 'Mulhouse', 'France', '11 ru gustave scheiffer', '68200', 'Haut-Rhin', 'Petite maison accolée', 'images/22eiiyy7iodt3sj.png', 'Maisonnette', '22EIIYY7IODT3SJ', '650', '100', 'Dornach', 'Petite maisonette accolée à son homologue dans un quartier calme de Dornach. Commerces et transports à proximité', '120', '', '5', 'NON', 'NON', '', '2', '1', 'Oui', '03/05/1946', 'Zimmermann', 'd.zim@aol.net', 'Daniel', '7946132580', 'Immédiate', 1, NULL, 'nedjma.benelhadj@gmail.com'),
(106, '', '', '', '', '', 'Valérie propose un logement', 'img/aucunvisuel.jpg', '', 'HIJHHKAYXIPGVIS', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Valérie', 'valerie@gmail.com', '', '', '', 1, NULL, 'valerie@gmail.com'),
(105, '', '', '', '', '', 'test photo vide', 'img/aucunvisuel.jpg', 'test photo vide', 'GQJUWC9BUL8T62U', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'admin@locavacances.fr', 'Admin', '0666302414', '', 1, NULL, 'admin@locavacances.fr'),
(107, '', '', '', '', '', 'kkk', 'img/aucunvisuel.jpg', '', 'VK9735JBEFW2F2V', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Administrateur', 'admin@rent-a-flat.fr', 'Administrateur', '0666302414', '', 0, NULL, 'admin@rent-a-flat.fr');

-- --------------------------------------------------------

--
-- Structure de la table `newsletter`
--

CREATE TABLE IF NOT EXISTS `newsletter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_n` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `newsletter`
--

INSERT INTO `newsletter` (`id`, `email_n`) VALUES
(1, 'nedjma.benelhadj@gmail.com'),
(2, 'nedjma.benelhadj@gmail.com'),
(3, 'charles@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `oublimdp`
--

CREATE TABLE IF NOT EXISTS `oublimdp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `hashcde` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=52 ;

--
-- Contenu de la table `oublimdp`
--


-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_description` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `product`
--


-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `userdate` varchar(255) NOT NULL,
  `enabled` int(1) NOT NULL DEFAULT '1',
  `surname` varchar(50) NOT NULL,
  `tel` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=90 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `password`, `lastname`, `userdate`, `enabled`, `surname`, `tel`) VALUES
(77, 'nedjma.benelhadj@gmail.com', 'nedjma.benelhadj@gmail.com', '$2a$10$7F9KwGhPdVyM/ug.7b1rsuuYar.ewGHROT7zgA/pi210JuN.WJEHm', 'BENELHADJ', '1991-01-08', 1, 'Nedjma', '0666302414'),
(76, 'admin@rent-a-flat.fr', 'admin@rent-a-flat.fr', '$2a$10$p5fYAWlALPAi7Fb8LsN0sOrlORyyCugz.uh14/nYg9jL5PDMWpZAu', 'Administrateur', '1991-01-08', 1, 'Administrateur', '0666302414'),
(66, 'charles.zimmermann.10@gmail.com', 'charles.zimmermann.10@gmail.com', '$2a$10$Cp9DEl/dS7qbMRqje06tZu1Veag479dqNgBC8L5zzHltd4VxORObC', 'zimmermann', '1991-07-24', 1, 'charles', '0666302414'),
(67, 'ldcazimmer@evhr.net', 'ldcazimmer@evhr.net', '$2a$10$1Zb.5g/ddQa9O8jRzIiRIOr/Wl61dVqx6Upf8IlrA5omu/M1wQUjG', 'KELLER', '1961-02-02', 1, 'Laurence', '0666302414'),
(68, 'charles.zimmermann@uha.Fr', 'charles.zimmermann@uha.fr', '$2a$10$UoTDnLitpR/U7zfWUzEXSuq5iZh5vuE/q3tfYMh8OfB8Jhk1JWxi2', 'Marc', '1991-07-24', 1, 'Zimmermann', '0666302414');

-- --------------------------------------------------------

--
-- Structure de la table `user_attempts`
--

CREATE TABLE IF NOT EXISTS `user_attempts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `attempts` varchar(255) NOT NULL,
  `lastModified` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `user_attempts`
--


-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `iduser` int(11) NOT NULL DEFAULT '99',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=46 ;

--
-- Contenu de la table `user_roles`
--

INSERT INTO `user_roles` (`id`, `role`, `username`, `iduser`) VALUES
(40, 'ROLE_ADMIN', 'admin@rent-a-flat.fr', 76),
(34, 'ROLE_USER', 'charles.zimmermann@uha.Fr', 68),
(33, 'ROLE_USER', 'ldcazimmer@evhr.net', 67),
(32, 'ROLE_USER', 'charles.zimmermann.10@gmail.com', 66),
(41, 'ROLE_USER', 'nedjma.benelhadj@gmail.com', 77);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `user_id` varchar(255) NOT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_born` varchar(255) DEFAULT NULL,
  `usercp` varchar(255) DEFAULT NULL,
  `user_city` varchar(255) DEFAULT NULL,
  `user_country` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone1` varchar(255) DEFAULT NULL,
  `user_phone2` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `user_sur_name` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateurs`
--


-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs_logements`
--

CREATE TABLE IF NOT EXISTS `utilisateurs_logements` (
  `utilisateurs_userId` bigint(20) NOT NULL,
  `logements_id` int(11) NOT NULL,
  `utilisateurs_userMail` varchar(255) NOT NULL,
  `logements_idLogement` int(11) NOT NULL,
  `logements_l_id` int(11) NOT NULL,
  `utilisateurs_userMailId` varchar(255) NOT NULL,
  UNIQUE KEY `UK_8r7268hlqw3wl5m8rssqfx07l` (`logements_id`),
  UNIQUE KEY `UK_fjqs3g5btoff65m1i356gq7bg` (`logements_idLogement`),
  UNIQUE KEY `UK_h1iwdwkqs34hyljtkj31xauky` (`logements_l_id`),
  KEY `FK_286lsxelul8qmuttw76h3bcrh` (`utilisateurs_userId`),
  KEY `FK_1ud7dm225k1eifv9pcq8qn1rk` (`utilisateurs_userMail`),
  KEY `FK_15jfh6ihlpu6lds6nf537098m` (`utilisateurs_userMailId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateurs_logements`
--

