-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Ноя 23 2014 г., 18:27
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
-- Структура таблицы `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_definition` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `account`
--

INSERT INTO `account` (`id`, `account_definition`) VALUES
(1, '{"person":{"firstName":"Person1","surName":"Person surname1","lastName":"Person lastname1","birthDate":"2014-11-22 11:40:49","workPlace":["Work place of person1"],"genre":"M","nationality":"BE","address":{"country":"Contry1","city":"City1","district":"District1","telephones":{"telephones":[{"value":"125 566 545","telephoneType":"HOME"},{"value":"375 12 56 55","telephoneType":"MOBILE"},{"value":"12 56 54","telephoneType":"WORK"},{"value":"12556","telephoneType":"VO_IP"}]}},"id":0},"credit":{"value":2000,"curr":"RU"},"debit":{"value":2,"curr":"RU"},"ballance":{"value":2000,"curr":"RU"},"lastUpdatedDate":"2014-11-22 11:40:49","id":1}');

-- --------------------------------------------------------

--
-- Структура таблицы `exchanger`
--

CREATE TABLE IF NOT EXISTS `exchanger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_definition` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `exchanger`
--

INSERT INTO `exchanger` (`id`, `account_definition`) VALUES
(1, '{"course":[{"value":1000,"curr":"US"},{"value":2001,"curr":"EU"},{"value":400,"curr":"EU"}],"basicCurrency":"RU","bankRef":"SBER-BANK"}');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
