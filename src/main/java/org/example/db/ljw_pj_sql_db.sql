/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - ljw_beginner_pj_sbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ljw_beginner_pj_sbs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `ljw_beginner_pj_sbs`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `title` char(100) NOT NULL,
  `body` text NOT NULL,
  `memberName` char(100) NOT NULL,
  `hit` int(100) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `article` */

insert  into `article`(`id`,`regDate`,`updateDate`,`title`,`body`,`memberName`,`hit`) values 
(1,'2024-04-21 11:34:03','2024-04-21 11:34:03','제목1','내용1','관리자',14),
(3,'2024-04-21 11:55:57','2024-04-21 11:55:57','테스트글작성 유저1번','테스트','user1',0);

/*Table structure for table `articleReply` */

DROP TABLE IF EXISTS `articleReply`;

CREATE TABLE `articleReply` (
  `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `body` char(100) NOT NULL,
  `memberName` char(100) NOT NULL,
  `articleId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `articleId` (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `articleReply` */

insert  into `articleReply`(`id`,`regDate`,`updateDate`,`body`,`memberName`,`articleId`) values 
(1,'2024-04-21 11:34:11','2024-04-21 11:34:11','관리자댓글1','관리자',1),
(2,'2024-04-21 11:34:11','2024-04-21 11:34:11','유저댓글1','user1',2),
(3,'2024-04-21 11:34:11','2024-04-21 11:34:11','유저댓글2','user1',2),
(4,'2024-04-21 11:54:22','2024-04-21 11:54:22','테스트댓글','나유저2',2),
(5,'2024-04-21 11:57:02','2024-04-21 11:57:02','짬뽕?','user1',2);

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `loginId` char(100) NOT NULL,
  `loginPw` char(100) NOT NULL,
  `memberName` char(100) NOT NULL,
  `adminId` char(100) DEFAULT 'null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginId` (`loginId`),
  UNIQUE KEY `memberName` (`memberName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member` */

insert  into `member`(`id`,`regDate`,`updateDate`,`loginId`,`loginPw`,`memberName`,`adminId`) values 
(1,'2024-04-21 11:34:20','2024-04-21 11:34:20','admin','admin','관리자','SBS12341499JW'),
(2,'2024-04-21 11:34:20','2024-04-21 11:34:20','user1','user1','user1','null'),
(3,'2024-04-21 11:44:31','2024-04-21 11:44:31','user3','user3','나유저3','null'),
(4,'2024-04-21 11:46:42','2024-04-21 11:46:42','user2','user2','나유저2','null');

/*Table structure for table `track` */

DROP TABLE IF EXISTS `track`;

CREATE TABLE `track` (
  `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `importMusicFile` char(100) NOT NULL,
  `musicTitle` char(100) NOT NULL,
  `hit` int(100) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `track` */

insert  into `track`(`id`,`regDate`,`updateDate`,`importMusicFile`,`musicTitle`,`hit`) values 
(1,'2024-04-21 11:36:13','2024-04-21 11:36:13','Diamond Eyes - Stay.mp3','Diamond Eyes - Stay',20),
(2,'2024-04-21 11:36:13','2024-04-21 11:36:13','Jim Yosef & Shiah Maisel - Just Getting Started.mp3','Jim Yosef & Shiah Maisel - Just Getting Started',5),
(3,'2024-04-21 11:36:13','2024-04-21 11:36:13','Jnathyn - Dioma.mp3','Jnathyn - Dioma',16),
(4,'2024-04-21 11:37:29','2024-04-21 11:37:29','Jnathyn - Rise.mp3','Jnathyn - Rise',0),
(5,'2024-04-21 11:52:49','2024-04-21 11:52:49','Jnathyn - Clockwork.mp3','Jnathyn - Clockwork',0),
(6,'2024-04-21 11:59:54','2024-04-21 11:59:54','Zedd & Alessia Cara - Stay.mp3','Zedd & Alessia Cara - Stay',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
