-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2022 at 12:10 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asmj4`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`, `status`) VALUES
(1, 'Short', 'selling'),
(2, 'Hoodie', 'selling'),
(3, 'Áo', 'delete'),
(4, 'Quần', 'selling');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `username`, `fullname`, `email`, `address`, `phone_number`, `password`, `img`, `role`, `status`) VALUES
(2, 'lienpt', 'Thị Liên123 Phùng', 'lienptph16568@fpt.edu.vn', 'hà nội', '0329891028', '$2a$10$2TKHLL/2NOpkbclqjScAzeonVIN4QS1zQw3gkKmPKx4kppfUiU6i2', NULL, 'customer', 'exist'),
(4, 'lien123', 'Thị Liên 22Phùng', 'lienptph16568@fpt.edu.vn', 'hà nội', '0329891029', '$2a$10$rUMXqYws2WXUuc.nycIjYu7k/ap/uz8p78GP2yB.G6CP15jG3RqbO', NULL, 'staff', 'exist'),
(5, 'lienptph16568', 'Thị Liên Phùng2000', 'lienptph16568@fpt.edu.vn', 'hà nội', '0329891090', '$2a$10$55.pjbvrSWKH1ayxUWPUfONkF.QcuAtDOyG2DuurjG2kAN1NnDQXG', NULL, 'customer', 'exist'),
(6, 'abc123', 'abc123', 'abc@gmail.com', 'Hà Nội', '0377776661', '$2a$10$Uv5qO94hahLiDXWhuRlG6.JZWQHygIdJQ9t51s977WPPKNNtJpyiu', NULL, 'customer', 'exist'),
(7, 'lien2002', 'Thị Liên Phùng', 'lienptph16568@fpt.edu.vn', 'hà nội', '0329891099', '$2a$10$mX0iKZE5bGPESWvu0WL9O.X9PCOmr/vT0Zm2wnSTCI/MRyOfLpS7.', NULL, 'customer', 'exist'),
(8, 'lien2002nv', 'Phùng Thị Liên', 'lienptph16568@fpt.edu.vn', 'hÃ  ná»i', '0329891011', '$2a$10$ngb8X1tJgqSqU72f7mNw4O59ZBNKRvGCUnSmtRgfW.jVfKdr1WTHK', NULL, 'staff', 'exist'),
(9, 'dinhnv', 'Phùng văn định', 'lienptph16568@fpt.edu.vn', 'Hà nội, Ba vì', '0984476256', '$2a$10$yDxRIoFLTIPdbat.uIjYt.kYjDm0Ap0k/KvmTke8qgMoaxbTxaRXS', NULL, 'customer', 'exist'),
(10, 'sau123', 'Nguyễn thị sáu', 'lienptph16568@fpt.edu.vn', 'hà nội', '0987741072', '$2a$10$50a1rVYySoz71PRaSKclUuGE0cYrvg0L5E1QVi9.52ZCzaha1N1kS', NULL, 'staff', 'exist');

-- --------------------------------------------------------

--
-- Table structure for table `detail_bill`
--

CREATE TABLE `detail_bill` (
  `id` int(11) NOT NULL,
  `id_order_infor` int(11) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT 0,
  `into_money` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_infor`
--

CREATE TABLE `order_infor` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_customer` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `total` double NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `order_infor`
--

INSERT INTO `order_infor` (`id`, `date`, `status`, `description`, `id_customer`, `id_product`, `total`, `amount`) VALUES
(6, '2022-04-07 20:40:48', 'Confirm', NULL, 2, 6, 300000, 1),
(7, '2022-04-07 20:40:48', 'Cancel', NULL, 2, 8, 300000, 1),
(9, '2022-04-07 20:43:58', 'Cancel', NULL, 2, 8, 300000, 1),
(14, '2022-04-07 21:05:52', 'Confirm', NULL, 2, 6, 300000, 1),
(15, '2022-04-07 21:05:52', 'Cancel', NULL, 2, 8, 300000, 1),
(17, '2022-04-07 21:07:26', 'Cancel', NULL, 2, 6, 300000, 1),
(18, '2022-04-07 21:09:13', 'Confirm', NULL, 2, 5, 200000, 1),
(20, '2022-04-07 21:23:19', 'Cancel', NULL, 2, 5, 200000, 1),
(21, '2022-04-07 22:18:33', 'Cancel', NULL, 2, 5, 200000, 1),
(22, '2022-04-07 22:18:33', 'Cancel', NULL, 2, 8, 300000, 1),
(23, '2022-04-08 02:21:19', 'Cancel', NULL, 2, 5, 200000, 1),
(24, '2022-04-08 02:21:19', 'Cancel', NULL, 2, 6, 300000, 1),
(25, '2022-04-08 02:23:17', 'Cancel', NULL, 2, 5, 200000, 1),
(26, '2022-04-08 02:23:17', 'Cancel', NULL, 2, 8, 300000, 1),
(27, '2022-04-08 02:25:10', 'Cancel', NULL, 2, 5, 200000, 1),
(28, '2022-04-08 02:27:13', 'Cancel', NULL, 2, 6, 600000, 2),
(29, '2022-04-08 02:27:13', 'Cancel', NULL, 2, 8, 300000, 1),
(30, '2022-04-08 06:47:50', 'Confirm', NULL, 4, 6, 300000, 1),
(31, '2022-04-08 06:52:42', 'Confirm', NULL, 4, 8, 300000, 1),
(32, '2022-04-08 06:59:10', 'Confirm', NULL, 4, 6, 300000, 1),
(33, '2022-04-08 07:22:46', 'Confirm', NULL, 4, 8, 300000, 1),
(34, '2022-04-08 07:27:41', 'Confirm', NULL, 4, 6, 300000, 1),
(35, '2022-04-08 07:35:34', 'Confirm', NULL, 4, 5, 200000, 1),
(36, '2022-04-08 07:48:27', 'Confirm', NULL, 4, 8, 300000, 1),
(37, '2022-04-08 10:45:26', 'Confirm', NULL, 2, 5, 200000, 1),
(38, '2022-04-08 10:45:26', 'Confirm', NULL, 2, 6, 300000, 1),
(39, '2022-04-08 14:03:21', 'Confirm', NULL, 4, 6, 300000, 1),
(40, '2022-04-08 14:03:21', 'Confirm', NULL, 4, 8, 300000, 1),
(41, '2022-04-13 10:20:48', 'Confirm', NULL, 2, 5, 200000, 1),
(42, '2022-04-13 10:27:18', 'Confirm', NULL, 2, 6, 300000, 1),
(43, '2022-04-13 16:58:50', 'Confirm', NULL, 5, 6, 300000, 1),
(44, '2022-04-13 16:58:50', 'Confirm', NULL, 5, 8, 300000, 1),
(45, '2022-04-13 17:01:52', 'Confirm', NULL, 5, 6, 300000, 1),
(46, '2022-04-18 04:32:52', 'Confirm', NULL, 2, 8, 600000, 2),
(47, '2022-04-18 04:32:52', 'Confirm', NULL, 2, 9, 200000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `img1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `img2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_category` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` double NOT NULL DEFAULT 0,
  `id_promotion` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `size` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL DEFAULT 0,
  `status` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `img1`, `img2`, `id_category`, `description`, `price`, `id_promotion`, `date`, `size`, `color`, `amount`, `status`) VALUES
(5, 'Áo cộc trắng', 'ao1.webp', 'ao2.webp', 3, 'Áo thun mặc mát vào mùa hè', 200000, 1, '2022-03-30 20:08:54', 'L', 'Yellow', 35, 'delete'),
(6, 'Áo thun tím mộng mơ', 'ao3.webp', 'ao4.webp', 2, 'Áo mặc vào mùa đông', 300000, 4, '2022-03-30 20:08:54', 'M', 'Black', 22, 'selling'),
(7, 'Áo hoodie', 'ao4.webp', 'ao5.webp', 2, 'Áo mặc mùa đông', 400000, 3, '2022-03-30 20:11:38', 'L', 'White', 29, 'delete'),
(8, 'Áo ba lỗ', 'ao2.webp', 'ao3.webp', 1, 'Áo mặc mat mẻ', 300000, 1, '2022-03-30 20:11:38', 'M', 'Blue', 19, 'selling'),
(9, 'Áo thun nữ', '90.png', '88.png', 1, 'Áo thun nam thích hợp mặc mùa hè', 200000, 1, '2022-04-13 10:57:59', 'S', 'white', 19, 'selling'),
(10, 'Áo hoodie', '2021-11-13.png', '88.png', 1, 'Áo thun nam thích hợp mặc mùa hè', 200000, 2, '2022-04-17 23:17:42', 'S', 'white', 20, 'delete');

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `id` int(11) NOT NULL,
  `promo_code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `percent` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`id`, `promo_code`, `percent`) VALUES
(1, 'ptph12', 20),
(2, 'ptph13', 20),
(3, 'ptph14', 0),
(4, 'ptph15', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phone_number` (`phone_number`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `detail_bill`
--
ALTER TABLE `detail_bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_bill` (`id_order_infor`);

--
-- Indexes for table `order_infor`
--
ALTER TABLE `order_infor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_customer` (`id_customer`),
  ADD KEY `order_infor_ibfk_1` (`id_product`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_promotion` (`id_promotion`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `promo_code` (`promo_code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `detail_bill`
--
ALTER TABLE `detail_bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_infor`
--
ALTER TABLE `order_infor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`);

--
-- Constraints for table `detail_bill`
--
ALTER TABLE `detail_bill`
  ADD CONSTRAINT `detail_bill_ibfk_1` FOREIGN KEY (`id_order_infor`) REFERENCES `order_infor` (`id`);

--
-- Constraints for table `order_infor`
--
ALTER TABLE `order_infor`
  ADD CONSTRAINT `order_infor_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `order_infor_ibfk_2` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`id_promotion`) REFERENCES `promotion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
