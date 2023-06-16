-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2023 at 04:46 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_reservation_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
  `guest_id` int(11) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  `phone_number` varchar(10) NOT NULL,
  `adhar_number` varchar(12) NOT NULL,
  `city` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`guest_id`, `first_name`, `last_name`, `email`, `phone_number`, `adhar_number`, `city`, `password`) VALUES
(7, 'Devam', 'doshi', 'dev', '9427986041', '1234', 'Idar', '1234'),
(9, 'Rishi', 'Shah', 'rishishah72@gmail.com', '7041254802', '12356489753', 'Idar', '521'),
(10, 'devam', 'doshi', 'dead', '9427986040', '4546', 'sdks', '123'),
(11, 'Pratham', 'Doshi', 'prem1@gmail.com', '9427986047', '1236547896', 'Bansda', '1234'),
(12, 'Devam', 'dsasd', 'dasdasd', '9999999999', '1234', 'sdsd', '123'),
(13, 'asd', 'asd', 'asd', '1233443434', '123123123123', 'adas', '123'),
(14, '', '', '', '', '', '', ''),
(15, 'Yatish', 'Gandhi', 'baba@gmail.com', '1234561234', '123456789987', 'Idar', '123'),
(16, 'asddas', 'asdd', 'sdasd', '1231231234', '123123123123', 'dad', '123'),
(17, 'bhcvhsd', 'hvakffs', 'hakhsdga', '1231231231', '23132', 'dasd', '12'),
(18, 'Dhruv', 'Shah', 'dhruvshah1@gmail.com', '9737356041', '123456789987', 'Anand', '123'),
(19, 'Abhi', 'Jivani', 'abhijivani12gmail.com', '9712128483', '1236547895', 'ahmd', '123'),
(20, 'Keyur', 'Ajudiya', 'keyurajudiya31@gmail', '9016690651', '123456789', 'Rajkot', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `hotel_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(300) NOT NULL,
  `city` varchar(20) NOT NULL,
  `phone_number` bigint(10) NOT NULL,
  `email` varchar(60) NOT NULL,
  `hotel_image` longtext NOT NULL,
  `hotel_manager_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`hotel_id`, `name`, `address`, `city`, `phone_number`, `email`, `hotel_image`, `hotel_manager_id`) VALUES
(18, 'Pearl Hotel', 'Nr. Ramdev Masala Co, Sarkhej-Bavla Rd, opp. Divya Dham Ashram, Changodar, Gujarat 382213\r\n', 'Changodar', 9727752429, 'pearlthehotel@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h1.jpg', 1),
(19, 'Townhouse Hotel', 'Pritam Nagar, Paldi, Ahmedabad, Gujarat 380007\r\n', 'Ahmedabad', 6874598565, 'townhouseinfo@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h2.jpg', 2),
(20, 'ITC Narmada Hotel', 'Survey # 104 A, Judges Bunglow Rd, I I M, Vastrapur, Ahmedabad, Gujarat 380015\r\n', 'Ahmedabad', 7969664000, 'itcnarmadainfo@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h3.jpg', 3),
(21, 'Tirupati International Hotel', 'Near Surat Train Station, Surat | 81 m from Surat Railway Station\r\n', 'Surat', 7548966521, 'tirupatihotelinfo@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h4.jpg', 4),
(22, 'Vivanta Hotel', '8km from Vadodara Airport,Akota,Vadodara.\r\n', 'Vadodara', 7412369658, 'vivantahotelinfo@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h5.jpg', 5),
(23, 'Volga', 'Idar', 'Idar', 1234567897, 'volga.idar@gmail.com', 'C:\\Personal Images\\Devam --ABU\\IMG_20211115_171346.jpg', 6),
(24, 'Taj Skyline', 'SBR road , shilaj , Ahemdbad 380001\r\n', 'Ahmedabad', 9878987455, 'taj.info2gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h1.jpg', 7),
(34, 'Umaid Bhawan Palace, Jodhpur', 'Circuit House Rd, Cantt Area, Jodhpur, Rajasthan 342006', 'Jodhpur', 2912510101, 'umaid.info@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h7.jpeg', 35),
(55, 'rishi', 'adjhalsd', 'hldjslf', 1231231231, 'info@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h5.jpg', 59),
(56, 'hjasjdkd', 'qwtyi	', 'ajksd', 5645645641, 'info@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h4.jpg', 60),
(57, 'jklasd', 'a;ksd	', 'asd', 1236549874, 'a@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h7.jpeg', 61),
(58, 'asd', 'hda	', 'jaklsd', 1231231231, 'i@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h4.jpg', 62),
(59, 'haskd', 'asdhjasjd', 'ahsd', 1234562314, '1@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h1.jpg', 63),
(60, 'asd', 'sadasd', 'sasf', 1231231231, 'a@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\Screenshot 2023-06-06 192421.png', 64),
(61, 'brew coffee', 'sbr road gandhinager	', 'KIYPUR', 1231231231, 'iie@gmial.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h7.jpeg', 65),
(62, 'wer', 'adasf', 'asd', 1231231231, 'rishi@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\Screenshot 2023-06-06 192421.png', 66),
(63, 'das', 'das', 'dgf', 1231231231, 'das@gmail.com', 'C:\\Programming\\Java_Dev\\Java_Project_1\\src\\hotel_image\\h4.jpg', 67);

-- --------------------------------------------------------

--
-- Table structure for table `hotel_manager`
--

CREATE TABLE `hotel_manager` (
  `username` varchar(40) NOT NULL,
  `password` varchar(8) NOT NULL,
  `hotel_manager_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotel_manager`
--

INSERT INTO `hotel_manager` (`username`, `password`, `hotel_manager_id`) VALUES
('pearl', '123', 1),
('townhouse', '123', 2),
('itcnarmada', '123', 3),
('tirupatiinternational ', '123', 4),
('vivanta', '123', 5),
('volga', '123', 6),
('tajskyline', '123', 7),
('umaid', '123', 35),
('uio', '1', 59),
('m', '2', 60),
('poi', '123', 61),
('oi', 'q', 62),
('k', '1', 63),
('s', '1', 64),
('OPI', '1', 65),
('123', '123', 66),
('tyu', '1', 67);

-- --------------------------------------------------------

--
-- Table structure for table `hotel_room`
--

CREATE TABLE `hotel_room` (
  `room_id` int(11) NOT NULL,
  `hotel_id` int(11) NOT NULL,
  `price_per_night` int(10) NOT NULL,
  `is_available` int(10) DEFAULT NULL,
  `room_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotel_room`
--

INSERT INTO `hotel_room` (`room_id`, `hotel_id`, `price_per_night`, `is_available`, `room_type`) VALUES
(1, 18, 5000, 5, 1),
(2, 19, 1000, 6, 1),
(3, 20, 10000, 10, 2),
(4, 21, 7000, 2, 2),
(5, 22, 3000, 7, 1),
(6, 23, 2500, 6, 2),
(7, 24, 15000, 100, 2),
(8, 61, 10000, 10, 1),
(9, 62, 2, 12, 2),
(10, 63, 69, 69, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hotel_room_type`
--

CREATE TABLE `hotel_room_type` (
  `room_type_id` int(11) NOT NULL,
  `room_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotel_room_type`
--

INSERT INTO `hotel_room_type` (`room_type_id`, `room_type`) VALUES
(1, 'Normal'),
(2, 'Delux');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `reservation_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `reservation_id` int(11) NOT NULL,
  `guest_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `check_in_date` varchar(10) NOT NULL,
  `check_out_date` varchar(10) NOT NULL,
  `num_of_guests` int(4) NOT NULL,
  `total_price` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guest`
--
ALTER TABLE `guest`
  ADD PRIMARY KEY (`guest_id`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`hotel_id`),
  ADD KEY `hotel_manager_id` (`hotel_manager_id`);

--
-- Indexes for table `hotel_manager`
--
ALTER TABLE `hotel_manager`
  ADD PRIMARY KEY (`hotel_manager_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `hotel_room`
--
ALTER TABLE `hotel_room`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `hotel_id` (`hotel_id`),
  ADD KEY `room_type` (`room_type`);

--
-- Indexes for table `hotel_room_type`
--
ALTER TABLE `hotel_room_type`
  ADD PRIMARY KEY (`room_type_id`),
  ADD UNIQUE KEY `room_type` (`room_type_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `reservation_id` (`reservation_id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `guest_id` (`guest_id`),
  ADD KEY `room_id` (`room_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `guest`
--
ALTER TABLE `guest`
  MODIFY `guest_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `hotel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `hotel_manager`
--
ALTER TABLE `hotel_manager`
  MODIFY `hotel_manager_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `hotel_room`
--
ALTER TABLE `hotel_room`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `hotel_room_type`
--
ALTER TABLE `hotel_room_type`
  MODIFY `room_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`hotel_manager_id`) REFERENCES `hotel_manager` (`hotel_manager_id`);

--
-- Constraints for table `hotel_room`
--
ALTER TABLE `hotel_room`
  ADD CONSTRAINT `hotel_room_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`),
  ADD CONSTRAINT `hotel_room_ibfk_2` FOREIGN KEY (`room_type`) REFERENCES `hotel_room_type` (`room_type_id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
