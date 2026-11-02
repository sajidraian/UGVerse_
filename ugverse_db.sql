-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2026 at 01:50 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ugverse_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `connections`
--

CREATE TABLE `connections` (
  `id` int(11) NOT NULL,
  `sender_email` varchar(100) NOT NULL,
  `receiver_email` varchar(100) NOT NULL,
  `status` enum('Pending','Accepted') DEFAULT 'Pending',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `connections`
--

INSERT INTO `connections` (`id`, `sender_email`, `receiver_email`, `status`, `created_at`) VALUES
(1, 'muhtasimtabin0@gmail.com', 'nayem@gmail.com', 'Pending', '2026-10-23 20:24:09'),
(2, 'nayem@gmail.com', 'muhtasimtabin0@gmail.com', 'Pending', '2026-10-23 20:25:34');

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `name`, `content`, `created_at`) VALUES
(1, 'Muhtasim Tabin', 'UGverse is rulling out the campus!!!', '2026-10-23 16:28:39'),
(2, 'Saimun Islam Shuvo', '📢 Internship Opportunity for UGV Juniors!\n\nHi everyone! As a proud alumnus of the University of Global Village (UGV), Barishal, I’m excited to share that TechVerse Solutions is hiring interns for our Junior Software Engineering Intern position (Barishal / Remote Hybrid).\n\nThis is a great chance to gain hands-on experience, work on real-world web/software projects, and kickstart your career with guidance from a fellow UGVian!\n\nEligibility: Open to current 3rd/4th year UGV students (CSE, EEE, or related departments)\n\nDuration: 3 Months (Stipend + Certificate provided)\n\nInterested? Send your CV to careers@techverse.com or apply at techverse.com/careers by November 15, 2026. Feel free to DM me with any questions!', '2026-10-23 16:37:10'),
(3, 'Saimun Islam Shuvo', '📢 UGV Campus Job Fair 2026 — We’re Hiring! 🎓\n\nHi UGVians! As an alumnus of the University of Global Village (UGV), Barishal, I’m excited to share that TechVerse Solutions is coming to campus for the upcoming Job Fair!\n\nWe are hiring for Junior Software Engineer, Business Development Executive, and Internship roles.\n\nDate & Time: Nov 12, 2026 | 10:00 AM – 4:00 PM\n\nLocation: UGV Campus Auditorium, Barishal\n\nEligibility: Final-year students & fresh graduates (CSE, EEE, BBA)\n\nWhat to expect: Spot written tests, short interviews, and career guidance from UGV alumni.\n\n👉 Bring: 2 printed CVs & your student ID.\n\n📩 Pre-register / Submit CV: techverse.com/ugv-fair by Nov 10, 2026. Feel free to DM me with any questions!', '2026-10-23 16:39:57'),
(4, 'Nayem Islam', '🔬 Seeking Research Assistant (RA) Position — CSE/Engineering\n\nHi everyone! I am a final-year Computer Science & Engineering student at the University of Global Village (UGV), Barishal, actively looking for an Undergraduate Research Assistant (RA) position in Artificial Intelligence / Machine Learning.\n\nFocus Areas: Machine Learning, Computer Vision, Data Analysis\n\nSkills: Python, PyTorch/TensorFlow, C++, Data Preprocessing, Technical Writing\n\nAvailability: Part-Time / Remote or Hybrid (15–20 hours/week)\n\nI am eager to contribute to active research projects, literature reviews, and paper drafting under the guidance of professors or senior researchers.\n\n📩 CV/Portfolio: Available upon request or visit [my-portfolio-link.com]\n\n📧 Contact: student.email@ugv.edu.bd | DM me directly!', '2026-10-23 19:07:37'),
(5, 'admin', '📢 **FACULTY ANNOUNCEMENT**\n\n**Department of Computer Science and Engineering**  \n**University of Global Village,Barishal**\n\n📌 **Subject: Notice Regarding an Upcoming Departmental Meeting**\n\nThis is to inform all students of the Department of Computer Science and Engineering that a departmental meeting will be held to discuss upcoming academic activities, class schedules, and student participation in departmental events.\n\nAll students are requested to attend the meeting on time and maintain proper discipline.\n\n📅 **Date:** 15 November 2026 (Sunday)  \n🕒 **Time:** 11:00 AM – 12:30 PM  \n📍 **Venue:** Room 201-202, Academic Building-2 \n👥 **Participants:** All students of the department\n\n**Important Instructions:**\n1. Students must arrive at least 10 minutes before the meeting begins.\n2. Bring your student ID card.\n3. Maintain discipline throughout the meeting.\n4. Contact the department office for any queries.\n\nThank you for your cooperation.\n\n**By Order of the Department Head**  \n**Dr. Rahman Ahmed**  \nHead of the Department  \nDepartment of Computer Science and Engineering  \nUniversity of Global Village,Barishal\n\n━━━━━━━━━━━━━━━━━━', '2026-10-30 20:08:58');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` enum('Student','Faculty','Alumni') NOT NULL,
  `department` varchar(100) DEFAULT NULL,
  `bio` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `role`, `department`, `bio`, `created_at`) VALUES
(1, 'Muhtasim Tabin', 'muhtasimtabin0@gmail.com', '12345678', 'Student', NULL, NULL, '2026-10-22 21:52:44'),
(2, 'Saimun Islam Shuvo', 'saimunshuvo.ugv@gmail.com', '87654321', 'Alumni', NULL, NULL, '2026-10-22 21:59:36'),
(3, 'Nayem', 'nayem@gmail.com', '1234', 'Student', NULL, NULL, '2026-10-23 17:16:46'),
(6, 'admin', 'admin@gmail.com', '1234', 'Faculty', NULL, NULL, '2026-10-30 19:59:48');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `connections`
--
ALTER TABLE `connections`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `connections`
--
ALTER TABLE `connections`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
