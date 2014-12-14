-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Дек 14 2014 г., 22:07
-- Версия сервера: 5.1.41
-- Версия PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `accounts`
--

-- --------------------------------------------------------

--
-- Структура таблицы `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `ADDRESS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `PERSON_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`),
  KEY `FK_4hnsdjpsxe4rgqn0fdvq2oagd` (`PERSON_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Дамп данных таблицы `address`
--

INSERT INTO `address` (`ADDRESS_ID`, `city`, `country`, `district`, `PERSON_ID`) VALUES
(1, 'City1', 'Contry1', 'District1', 2),
(2, 'City1', 'Contry1', 'District1', 4),
(3, 'City1', 'Contry1', 'District1', 6),
(4, 'City1', 'Contry1', 'District1', 8),
(5, 'City1', 'Contry1', 'District1', 10),
(6, 'City1', 'Contry1', 'District1', 12);

-- --------------------------------------------------------

--
-- Структура таблицы `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL,
  `employeeStatus` varchar(255) DEFAULT NULL,
  `lastUpdatedDate` date DEFAULT NULL,
  `PERSON_ID` bigint(20) NOT NULL,
  `UNIT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_eg5log2luwqhvppkr0bt5wkjy` (`PERSON_ID`),
  KEY `FK_eg5log2luwqhvppkr0bt5wkjy` (`PERSON_ID`),
  KEY `FK_tnrfwxn3re9o2hiwvvfwpxanr` (`UNIT_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Дамп данных таблицы `employee`
--

INSERT INTO `employee` (`id`, `active`, `employeeStatus`, `lastUpdatedDate`, `PERSON_ID`, `UNIT_ID`) VALUES
(1, 0, 'FULL_TIME', '2014-12-14', 1, 1),
(2, 0, 'FULL_TIME', '2014-12-14', 3, 1),
(3, 0, 'FULL_TIME', '2014-12-14', 5, NULL),
(4, 0, 'FULL_TIME', '2014-12-14', 7, NULL),
(5, 0, 'FULL_TIME', '2014-12-14', 9, NULL),
(6, 0, 'FULL_TIME', '2014-12-14', 11, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `employee_project`
--

CREATE TABLE IF NOT EXISTS `employee_project` (
  `PROJECT_ID` bigint(20) NOT NULL,
  `EMPLOYEE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`,`PROJECT_ID`),
  KEY `FK_ckg1wncbsv6uta3bms3sdpeqm` (`EMPLOYEE_ID`),
  KEY `FK_9yr669unhflh7nk40pysmya2y` (`PROJECT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `employee_project`
--

INSERT INTO `employee_project` (`PROJECT_ID`, `EMPLOYEE_ID`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `PERSON_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthDate` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstName` varchar(25) NOT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `lastName` varchar(25) NOT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `surName` varchar(25) NOT NULL,
  `workPlace` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Дамп данных таблицы `person`
--

INSERT INTO `person` (`PERSON_ID`, `birthDate`, `email`, `firstName`, `genre`, `lastName`, `nationality`, `surName`, `workPlace`) VALUES
(1, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(2, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(3, '2014-12-14', 'admin@admin.com', 'Person', 'W', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(4, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(5, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(6, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(7, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(8, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(9, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(10, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(11, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA'),
(12, '2014-12-14', 'admin@admin.com', 'Person', 'M', 'Person lastname', 'BE', 'Person surname', 'GSKTB GA');

-- --------------------------------------------------------

--
-- Структура таблицы `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `project`
--

INSERT INTO `project` (`id`, `projectName`) VALUES
(1, 'hjklh');

-- --------------------------------------------------------

--
-- Структура таблицы `telephone`
--

CREATE TABLE IF NOT EXISTS `telephone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `telephoneType` varchar(255) DEFAULT NULL,
  `value` varchar(12) NOT NULL,
  `ADDRESS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t3k256k0xy9m23f05anyqym1a` (`ADDRESS_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

--
-- Дамп данных таблицы `telephone`
--

INSERT INTO `telephone` (`id`, `telephoneType`, `value`, `ADDRESS_ID`) VALUES
(1, 'MOBILE', '375125655', 1),
(2, 'HOME', '125566545', 1),
(3, 'HOME', '125566545', 1),
(4, 'VO_IP', '12556', 1),
(5, 'HOME', '125566545', 2),
(6, 'HOME', '125566545', 2),
(7, 'MOBILE', '375125655', 2),
(8, 'VO_IP', '12556', 2),
(9, 'VO_IP', '12556', 3),
(10, 'HOME', '125566545', 3),
(11, 'MOBILE', '375125655', 3),
(12, 'HOME', '125566545', 3),
(13, 'HOME', '125566545', 4),
(14, 'HOME', '125566545', 4),
(15, 'VO_IP', '12556', 4),
(16, 'MOBILE', '375125655', 4),
(17, 'MOBILE', '375125655', 5),
(18, 'HOME', '125566545', 5),
(19, 'VO_IP', '12556', 5),
(20, 'HOME', '125566545', 5),
(21, 'VO_IP', '12556', 6),
(22, 'MOBILE', '375125655', 6),
(23, 'HOME', '125566545', 6),
(24, 'HOME', '125566545', 6);

-- --------------------------------------------------------

--
-- Структура таблицы `unit`
--

CREATE TABLE IF NOT EXISTS `unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unitType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `unit`
--

INSERT INTO `unit` (`id`, `unitType`) VALUES
(1, 'DEVEPOPING_TEAM');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
