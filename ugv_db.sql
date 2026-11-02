-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2026 at 02:12 AM
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
-- Database: `ugv_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `name`, `email`, `role`, `content`, `created_at`) VALUES
(5, NULL, NULL, NULL, 'raian | raian@gmail.com | alumni | 2026-11-02 06:30:00\n\n🚀 From UGV Classrooms to the Tech Industry: Reflecting on My Journey! 💻\n\nLooking back at my undergraduate days at the University of Global Village (UGV), Barishal, I realize how much those four years shaped my professional foundation. The late-night debugging sessions, lab submissions, and non-departmental fundamentals like electronics and complex mathematics laid the groundwork for my career today.\n\nTransitioning from campus life to working as a developer brought its own challenges, but the problem-solving mindset cultivated during my time at UGV CSE made all the difference.\n\n💡 Advice to My Juniors:\n\nFocus on Basics: Don\'t just learn frameworks; master data structures, algorithms, and core system architectures.\n\nBuild Practical Projects: Hands-on work on your portfolio will set you apart during interviews.\n\nNetwork & Collaborate: Connect with alumni, join developer communities, and keep learning continuously.\n\nProud to be an alumnus of UGV CSE! Feel free to reach out via email or LinkedIn if any junior needs guidance or project feedback.\n\n#UGVAlumni #CSEReflections #CareerGrowth #WebDevelopment #SoftwareEngineering #TechCommunity #BarishalToTech', '2026-11-02 00:33:25'),
(6, NULL, NULL, NULL, 'admin | admin@gmail.com | faculty | 2026-11-02 09:30:00\n\n🎓 Empowering the Next Generation of Engineers at UGV! 💡\n\nTeaching at the University of Global Village (UGV), Barishal in the Department of Computer Science & Engineering has been a deeply rewarding experience. Over the past few years, I’ve had the privilege of guiding young minds through the core principles of computer science—from basic electronics and mathematical logic to relational database systems and advanced software design.\n\nWhat makes our CSE department special is our emphasis on first-principles learning. Seeing students move from theoretical classroom concepts to building full-stack applications, optimizing SQL queries, and launching real-world projects is what drives us every day.\n\nTo our current CSE students: keep questioning, keep building, and stay curious. The tech industry is evolving fast, but with strong fundamentals, you will always stay ahead!\n\n#UGV #CSEDepartment #HigherEducation #TechMentorship #FacultyLife #EngineeringEducation #Barishal', '2026-11-02 00:36:12'),
(7, NULL, NULL, NULL, 'tabin | tabin@gmail.com | student | 2026-11-02 11:30:00\n\n📚 Life as a CSE Student at UGV: Coding, Learning, & Growing Every Day! ✨\n\nBeing a Computer Science & Engineering student at the University of Global Village (UGV), Barishal is an exciting grind. From breaking down complex database constraints in SQL to crafting dynamic web layouts and studying core electronics, every semester brings a new layer of learning.\n\nAs a student aiming to excel in web development, I’ve learned that understanding why a system works line-by-line is just as crucial as writing clean code. Working on local database setups, portfolio projects, and fundamental engineering courses has helped me bridge the gap between classroom theory and real-world execution.\n\n🔥 Current Focus Areas:\n\nFrontend & Web Technologies\n\nRelational Database Systems & SQL Optimization\n\nFundamental Engineering & Problem Solving\n\nGrateful for the support of our faculty and seniors at UGV who constantly push us to aim higher. Excited for what’s ahead!\n\n#UGV #CSEStudent #StudentDeveloper #WebDevelopment #LearnToCode #FutureEngineer #BarishalTech', '2026-11-02 00:38:27');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `role`) VALUES
(1, 'tabin', 'tabin@gmail.com', '1234', 'student'),
(2, 'admin', 'admin@gmail.com', '0000', 'faculty'),
(4, 'raian', 'raian@gmail.com', '1111', 'alumni');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
