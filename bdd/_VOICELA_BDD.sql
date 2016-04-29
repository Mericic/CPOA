-- phpMyAdmin SQL Dump
-- version 4.0.10.15
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 29 Avril 2016 à 11:36
-- Version du serveur: 5.1.73
-- Version de PHP: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `p1406760`
--

-- --------------------------------------------------------

--
-- Structure de la table `Casting`
--

CREATE TABLE IF NOT EXISTS `Casting` (
  `numVIP` int(6) NOT NULL,
  `numVisa` int(25) NOT NULL,
  KEY `cleetrangereVIP` (`numVIP`),
  KEY `cleetrangereVISA` (`numVisa`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Casting`
--

INSERT INTO `Casting` (`numVIP`, `numVisa`) VALUES
(1, 315554);

-- --------------------------------------------------------

--
-- Structure de la table `Categorie`
--

CREATE TABLE IF NOT EXISTS `Categorie` (
  `catId` int(11) NOT NULL,
  `nomCat` varchar(250) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`catId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Categorie`
--

INSERT INTO `Categorie` (`catId`, `nomCat`) VALUES
(1, 'Animaux'),
(2, 'Bouffe'),
(3, 'Monuments');

-- --------------------------------------------------------

--
-- Structure de la table `Evenement`
--

CREATE TABLE IF NOT EXISTS `Evenement` (
  `numVIP` int(6) NOT NULL,
  `dateMariage` date NOT NULL,
  `numVIPConjoint` int(6) NOT NULL,
  `lieuMariage` varchar(50) NOT NULL,
  `DateDivorce` varchar(10) NOT NULL,
  PRIMARY KEY (`numVIP`,`dateMariage`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Evenement`
--

INSERT INTO `Evenement` (`numVIP`, `dateMariage`, `numVIPConjoint`, `lieuMariage`, `DateDivorce`) VALUES
(2, '2014-06-23', 3, 'Miraval', '');

-- --------------------------------------------------------

--
-- Structure de la table `Film`
--

CREATE TABLE IF NOT EXISTS `Film` (
  `NumVisa` int(25) NOT NULL,
  `Titre` varchar(25) NOT NULL,
  `annee` int(5) NOT NULL,
  PRIMARY KEY (`NumVisa`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Film`
--

INSERT INTO `Film` (`NumVisa`, `Titre`, `annee`) VALUES
(315554, '0SS117', 2000);

-- --------------------------------------------------------

--
-- Structure de la table `Genre`
--

CREATE TABLE IF NOT EXISTS `Genre` (
  `LibelleGenre` varchar(50) NOT NULL,
  PRIMARY KEY (`LibelleGenre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Pays`
--

CREATE TABLE IF NOT EXISTS `Pays` (
  `NomPays` varchar(50) NOT NULL,
  PRIMARY KEY (`NomPays`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `PhotoVIP`
--

CREATE TABLE IF NOT EXISTS `PhotoVIP` (
  `numVIP` int(6) NOT NULL,
  `numeroSequentiel` int(20) NOT NULL,
  `date` date NOT NULL,
  `lieu` varchar(20) NOT NULL,
  PRIMARY KEY (`numVIP`,`numeroSequentiel`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `REALISE`
--

CREATE TABLE IF NOT EXISTS `REALISE` (
  `numVIP` int(6) NOT NULL,
  `numVISA` int(25) NOT NULL,
  PRIMARY KEY (`numVIP`,`numVISA`),
  KEY `cleetrangereVISA` (`numVISA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `VIP`
--

CREATE TABLE IF NOT EXISTS `VIP` (
  `IDVIP` int(6) NOT NULL AUTO_INCREMENT,
  `NomVIP` varchar(25) NOT NULL,
  `PrenomVIP` varchar(25) NOT NULL,
  `DateNaissance` date NOT NULL,
  `âge` int(4) NOT NULL,
  `LieuNaissance` varchar(60) NOT NULL,
  `CodeRole` varchar(2) NOT NULL COMMENT 'A, R, AR',
  `Pays` varchar(25) NOT NULL,
  `CodeStatut` char(1) NOT NULL COMMENT 'C, M, D',
  PRIMARY KEY (`IDVIP`),
  KEY `cleetrangere` (`Pays`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `VIP`
--

INSERT INTO `VIP` (`IDVIP`, `NomVIP`, `PrenomVIP`, `DateNaissance`, `âge`, `LieuNaissance`, `CodeRole`, `Pays`, `CodeStatut`) VALUES
(1, 'Du Jardin', 'Jean', '1972-06-19', 43, 'France', 'AR', 'France', 'M'),
(2, 'Pitt', 'Brad', '1963-12-18', 52, 'Pas en France', 'A', 'Pas en France', 'M'),
(3, 'Jolie', 'Angelina', '1975-05-04', 43, 'Autre Part', 'A', 'Angleterre', 'M');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
