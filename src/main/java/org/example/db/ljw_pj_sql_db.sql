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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `article` */

insert  into `article`(`id`,`regDate`,`updateDate`,`title`,`body`,`memberName`,`hit`) values 
(2,'2024-04-20 20:40:26','2024-04-20 20:40:26','제목2','내용2','user1',23),
(3,'2024-04-20 20:49:23','2024-04-20 20:49:23','하이','그래','관리자',0),
(4,'2024-04-21 01:37:45','2024-04-21 01:37:45','하이','그려','user1',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `articleReply` */

insert  into `articleReply`(`id`,`regDate`,`updateDate`,`body`,`memberName`,`articleId`) values 
(1,'2024-04-20 20:40:30','2024-04-20 20:40:30','관리자댓글1','관리자',1),
(2,'2024-04-20 20:40:30','2024-04-20 20:40:30','유저댓글1','user1',2),
(3,'2024-04-20 20:40:50','2024-04-20 20:40:50','유저댓글2','user1',2),
(4,'2024-04-20 20:41:18','2024-04-20 20:41:18','하이','관리자',2),
(5,'2024-04-20 20:45:47','2024-04-20 20:45:47','하이','관리자',2),
(6,'2024-04-20 22:46:01','2024-04-20 22:46:01','하이','관리자',3),
(7,'2024-04-21 00:55:42','2024-04-21 00:55:42','하이','관리자',3),
(8,'2024-04-21 01:20:24','2024-04-21 01:20:24','하이','관리자',2),
(9,'2024-04-21 01:26:02','2024-04-21 01:26:02','하이','관리자',2),
(10,'2024-04-21 01:31:48','2024-04-21 01:31:48','하이','관리자',2),
(11,'2024-04-21 01:38:00','2024-04-21 01:38:00','허허허허허','user1',3),
(12,'2024-04-21 01:45:33','2024-04-21 01:45:33','언제쯤 자려나','관리자',2),
(13,'2024-04-21 01:47:48','2024-04-21 01:47:48','이제 됐나?','관리자',2),
(14,'2024-04-21 01:51:53','2024-04-21 01:51:53','나 못잘거같넹','관리자',2),
(15,'2024-04-21 02:03:24','2024-04-21 02:03:24','드디어 됐다','user1',2);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `member` */

insert  into `member`(`id`,`regDate`,`updateDate`,`loginId`,`loginPw`,`memberName`,`adminId`) values 
(1,'2024-04-20 20:41:00','2024-04-20 20:41:00','admin','admin','관리자','SBS12341499JW'),
(2,'2024-04-20 20:41:00','2024-04-20 20:41:00','user1','user1','user1','null');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `track` */

insert  into `track`(`id`,`regDate`,`updateDate`,`importMusicFile`,`musicTitle`,`hit`) values 
(1,'2024-04-20 20:40:56','2024-04-20 20:40:56','Diamond Eyes - Stay.mp3','Diamond Eyes - Stay',20),
(2,'2024-04-20 20:40:56','2024-04-20 20:40:56','Jim Yosef & Shiah Maisel - Just Getting Started.mp3','Jim Yosef & Shiah Maisel - Just Getting Started',5),
(3,'2024-04-20 20:47:23','2024-04-20 20:47:23','Jnathyn - Clockwork.mp3','Jnathyn - Clockwork',0),
(4,'2024-04-21 01:13:38','2024-04-21 01:13:38','Zedd - Clarity.mp3','Zedd - Clarity',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
