-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2021 at 04:01 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kroko`
--

-- --------------------------------------------------------

--
-- Table structure for table `clan`
--

CREATE TABLE `clan` (
  `clanID` int(15) NOT NULL,
  `ime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `jmbg` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `kontakt` varchar(23) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(23) COLLATE utf8_unicode_ci NOT NULL,
  `adresa` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `clanarina` date NOT NULL,
  `godine` int(10) NOT NULL,
  `postanskiBroj` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `clan`
--

INSERT INTO `clan` (`clanID`, `ime`, `prezime`, `jmbg`, `kontakt`, `email`, `adresa`, `status`, `clanarina`, `godine`, `postanskiBroj`) VALUES
(3, 'Mile', 'Mickovic', '9876543213214', '0621515455', 'dadf@gmail.com', 'Niksicka 18/A', 'Aligaotr', '2022-01-22', 6, 11010),
(5, 'Tomas', 'Ket', '1237894561234', '0649963872', 'dsadsa@gmail.com', 'Misina Malog 18', 'Gušter', '2022-01-16', 1, 11000),
(6, 'Niko', 'Klaudije', '1478523698521', '0615566989', 'derius23@gmail.com', 'Niksicka 32', 'Gušter', '2022-01-17', 1, 11010),
(7, 'Jovana', 'Pesic', '3698521477412', '0652321562', 'alida@gmail.com', 'Branka Krsmanovica 18c', 'Gušter', '2022-01-17', 1, 11000),
(8, 'Božidar', 'Miholović', '1608988421314', '0695596333', 'bozidarmih@gmail.com', 'Bulevar Mihajla Pupina 165b', 'Gušter', '2022-01-18', 1, 11070),
(9, 'Teodora', 'Antić', '1204974223863', '0658865326', 'defo@hotmail.com', 'Lole Ribara', 'Gušter', '2022-01-22', 1, 11080);

-- --------------------------------------------------------

--
-- Table structure for table `opstina`
--

CREATE TABLE `opstina` (
  `postanskiBroj` int(10) NOT NULL,
  `naziv` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `opstina`
--

INSERT INTO `opstina` (`postanskiBroj`, `naziv`) VALUES
(11000, 'Stari grad'),
(11010, 'Voždovac'),
(11050, 'Zvezdara'),
(11070, 'Novi Beograd'),
(11080, 'Zemun');

-- --------------------------------------------------------

--
-- Table structure for table `stavkazaduzenja`
--

CREATE TABLE `stavkazaduzenja` (
  `stavkaID` int(10) NOT NULL,
  `zaduzenjeID` int(10) NOT NULL,
  `dodatnaBaterija` tinyint(1) NOT NULL,
  `dodatnaSvetla` tinyint(1) NOT NULL,
  `vrednost` decimal(10,0) NOT NULL,
  `trotinetID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `stavkazaduzenja`
--

INSERT INTO `stavkazaduzenja` (`stavkaID`, `zaduzenjeID`, `dodatnaBaterija`, `dodatnaSvetla`, `vrednost`, `trotinetID`) VALUES
(1, 2, 1, 0, '3500', 12),
(1, 3, 1, 0, '3200', 20),
(1, 5, 0, 1, '1800', 6),
(2, 5, 1, 0, '1900', 7);

-- --------------------------------------------------------

--
-- Table structure for table `trotinet`
--

CREATE TABLE `trotinet` (
  `trotinetID` int(15) NOT NULL,
  `naziv` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `cena` decimal(10,0) NOT NULL,
  `zauzet` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trotinet`
--

INSERT INTO `trotinet` (`trotinetID`, `naziv`, `cena`, `zauzet`) VALUES
(1, 'Huawei 27A', '1100', 0),
(2, 'Huawei 27A', '1100', 0),
(3, 'Huawei 27A', '1100', 0),
(4, 'Huawei 27A', '1100', 0),
(5, 'Huawei 27A', '1100', 0),
(6, 'Xiaomi Z8ha', '1500', 1),
(7, 'Xiaomi Z8ha', '1500', 1),
(8, 'Xiaomi Z9', '2200', 0),
(9, 'Xiaomi Z9', '2200', 0),
(10, 'Xiaomi Z9', '2200', 0),
(11, 'Xiaomi Z9', '2200', 0),
(12, 'BMW mEro', '3100', 1),
(13, 'BMW mEro', '3100', 0),
(14, 'Huawei 28M', '1200', 0),
(15, 'Huawei 28M', '1200', 0),
(16, 'Huawei 28M', '1200', 0),
(17, 'Huawei 28M', '1200', 0),
(18, 'Huawei 28M', '1200', 0),
(19, 'Huawei 28M', '1200', 0),
(20, 'Asahi 12', '2800', 1),
(21, 'Asahi 12', '2800', 0),
(22, 'Asahi 12', '2800', 0);

-- --------------------------------------------------------

--
-- Table structure for table `zaduzenje`
--

CREATE TABLE `zaduzenje` (
  `zaduzenjeID` int(15) NOT NULL,
  `datumZaduzenja` date NOT NULL,
  `datumRazduzenja` date DEFAULT NULL,
  `brojdana` tinyint(1) NOT NULL,
  `iznos` decimal(10,0) NOT NULL,
  `clanID` int(15) NOT NULL,
  `zaduzioID` int(15) NOT NULL,
  `razduzioID` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zaduzenje`
--

INSERT INTO `zaduzenje` (`zaduzenjeID`, `datumZaduzenja`, `datumRazduzenja`, `brojdana`, `iznos`, `clanID`, `zaduzioID`, `razduzioID`) VALUES
(2, '2021-01-22', NULL, 3, '10500', 5, 1, NULL),
(3, '2021-01-22', NULL, 2, '6400', 8, 1, NULL),
(5, '2021-01-22', NULL, 3, '11100', 6, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `zaposleniID` int(15) NOT NULL,
  `ime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `korisnickoIme` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `korisnickaSifra` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`zaposleniID`, `ime`, `prezime`, `korisnickoIme`, `korisnickaSifra`) VALUES
(1, 'Smit', 'Bergam', 'smit2', 'sm12'),
(2, 'Paula', 'Herc', 'paulla', 'cod18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clan`
--
ALTER TABLE `clan`
  ADD PRIMARY KEY (`clanID`),
  ADD KEY `clan_1` (`postanskiBroj`);

--
-- Indexes for table `opstina`
--
ALTER TABLE `opstina`
  ADD PRIMARY KEY (`postanskiBroj`);

--
-- Indexes for table `stavkazaduzenja`
--
ALTER TABLE `stavkazaduzenja`
  ADD PRIMARY KEY (`stavkaID`,`zaduzenjeID`),
  ADD KEY `stavka_1` (`zaduzenjeID`),
  ADD KEY `stavka_2` (`trotinetID`);

--
-- Indexes for table `trotinet`
--
ALTER TABLE `trotinet`
  ADD PRIMARY KEY (`trotinetID`);

--
-- Indexes for table `zaduzenje`
--
ALTER TABLE `zaduzenje`
  ADD PRIMARY KEY (`zaduzenjeID`),
  ADD KEY `zaduzenje_2` (`clanID`) USING BTREE,
  ADD KEY `zaduzenje_3` (`zaduzioID`),
  ADD KEY `zaduzenje_4` (`razduzioID`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`zaposleniID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clan`
--
ALTER TABLE `clan`
  MODIFY `clanID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `stavkazaduzenja`
--
ALTER TABLE `stavkazaduzenja`
  MODIFY `stavkaID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `trotinet`
--
ALTER TABLE `trotinet`
  MODIFY `trotinetID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `zaduzenje`
--
ALTER TABLE `zaduzenje`
  MODIFY `zaduzenjeID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `zaposleni`
--
ALTER TABLE `zaposleni`
  MODIFY `zaposleniID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `clan`
--
ALTER TABLE `clan`
  ADD CONSTRAINT `clan_1` FOREIGN KEY (`postanskiBroj`) REFERENCES `opstina` (`postanskiBroj`) ON UPDATE CASCADE;

--
-- Constraints for table `stavkazaduzenja`
--
ALTER TABLE `stavkazaduzenja`
  ADD CONSTRAINT `stavka_1` FOREIGN KEY (`zaduzenjeID`) REFERENCES `zaduzenje` (`zaduzenjeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stavka_2` FOREIGN KEY (`trotinetID`) REFERENCES `trotinet` (`trotinetID`) ON UPDATE CASCADE;

--
-- Constraints for table `zaduzenje`
--
ALTER TABLE `zaduzenje`
  ADD CONSTRAINT `zaduzenje_2` FOREIGN KEY (`clanID`) REFERENCES `clan` (`clanID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `zaduzenje_3` FOREIGN KEY (`zaduzioID`) REFERENCES `zaposleni` (`zaposleniID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `zaduzenje_4` FOREIGN KEY (`razduzioID`) REFERENCES `zaposleni` (`zaposleniID`) ON UPDATE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
