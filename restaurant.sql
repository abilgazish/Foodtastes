-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 04 2020 г., 18:42
-- Версия сервера: 10.1.39-MariaDB
-- Версия PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `restaurant`
--

-- --------------------------------------------------------

--
-- Структура таблицы `admindata`
--

CREATE TABLE `admindata` (
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `telephoneNumber` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `admindata`
--

INSERT INTO `admindata` (`login`, `password`, `address`, `telephoneNumber`, `id`) VALUES
('asdf', '789asd', 'wqeqwe', 'wqeq', 1),
('Yera', '123asd', 'affdsf', 'dfdsfsd', 2),
('qwer', '123qwerty', 'erstdhf', '693', 3),
('Yera', '123qwe', 'rhdtjfg', '852', 4),
('Yera', '123asd', 'rwtyertkg', '653', 5);

-- --------------------------------------------------------

--
-- Структура таблицы `buyerdata`
--

CREATE TABLE `buyerdata` (
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `telephoneNumber` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `buyerdata`
--

INSERT INTO `buyerdata` (`login`, `password`, `address`, `telephoneNumber`, `id`) VALUES
('ght', '753qwe', 'sdfsdf', 'sdfsdf', 1),
('Yera', '123asd', 'sadfsafs', 'sfdsfsdf', 2),
('qwe', '123', 'erdytf', '852', 3),
('Yera', '123qw', 'rewtyht', '865', 4);

-- --------------------------------------------------------

--
-- Структура таблицы `foods`
--

CREATE TABLE `foods` (
  `id` int(11) NOT NULL,
  `kindoffood` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `foods`
--

INSERT INTO `foods` (`id`, `kindoffood`, `name`, `price`) VALUES
(3, 'dfsdf', 'ghdffasgdf', 1500),
(4, 'dfdsf', 'dfds', 1500),
(5, 'sadad', 'sada', 877),
(6, 'Peraw', 'Perawki', 2000),
(7, 'Goryachi', 'Borw', 500),
(8, 'Okjas', 'Shyngys', 789456),
(9, 'srdfg', 'qrewtf', 8745),
(10, 'Goryac', 'Borw', 5000);

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `foodsId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `passwordNumber` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`id`, `foodsId`, `name`, `surname`, `passwordNumber`) VALUES
(1, 1, 'dsaddad', 'asdasdad', 'asdd12000'),
(2, 2, 'Aza', 'Ala', 'zxxcx1566'),
(3, 2, 'bcbcv', 'bcbc', 'dfg45'),
(4, 2, 'asdsa', 'asdasda', 'sadasd'),
(5, 7, 'Yera', 'awsedrjf', '8652');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `admindata`
--
ALTER TABLE `admindata`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `buyerdata`
--
ALTER TABLE `buyerdata`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `admindata`
--
ALTER TABLE `admindata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `buyerdata`
--
ALTER TABLE `buyerdata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `foods`
--
ALTER TABLE `foods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
