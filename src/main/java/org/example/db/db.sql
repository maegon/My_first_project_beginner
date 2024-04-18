DROP DATABASE IF EXISTS ljw_beginner_pj_sbs;
CREATE DATABASE ljw_beginner_pj_sbs;
USE ljw_beginner_pj_sbs;


/* article */
CREATE TABLE article(
	id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL,
	memberName CHAR(100) UNIQUE NOT NULL,
	hit INT(100) UNSIGNED NOT NULL
);

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목1',
`body` = '내용1',
memberName = '관리자',
hit = 45;


INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목2',
`body` = '내용2',
memberName = 'user1',
hit = 16;



SELECT * FROM article;

SELECT * FROM article WHERE 1;



CREATE TABLE articleReply(
	id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	`body` CHAR(100) NOT NULL,
	memberName CHAR(100) UNIQUE NOT NULL,
	articleId INT(100) UNSIGNED NOT NULL,
	INDEX articleId(`articleId`)
);

INSERT INTO articleReply
SET regDate = NOW(),
updateDate = NOW(),
`body` = '관리자댓글1',
memberName = '관리자',
articleId = 2;

INSERT INTO articleReply
SET regDate = NOW(),
updateDate = NOW(),
`body` = '유저댓글1',
memberName = 'user1',
articleId = 1;

SELECT * FROM articleReply


/* track */
CREATE TABLE track (
	id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	importMusicFile CHAR(100) NOT NULL,
	musicTitle CHAR(100) NOT NULL,
	hit INT(100) UNSIGNED NOT NULL
);


INSERT INTO track
SET regDate = NOW(),
updateDate = NOW(),
importMusicFile = 'Diamond Eyes - Stay.mp3',
musicTitle = 'Diamond Eyes - Stay',
hit = 20;

INSERT INTO track
SET regDate = NOW(),
updateDate = NOW(),
importMusicFile = 'Jim Yosef & Shiah Maisel - Just Getting Started.mp3',
musicTitle = 'Jim Yosef & Shiah Maisel - Just Getting Started',
hit = 5;

SELECT * FROM track;

/* member */
CREATE TABLE `member`(
	id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(100) NOT NULL UNIQUE,
	loginPw CHAR(100) NOT NULL,
	`memberName` CHAR(100) NOT NULL UNIQUE,
	adminId CHAR(100) DEFAULT NULL
);


INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
`memberName` = '관리자',
adminId = 'SBS12341499JW';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
`memberName` = 'user1';


/*
특정 문자를 가진 애들만 출력할때 조건 서식
(인텔리제이에서는 %%입력)
where 'type' like concat('%%','?','%%');
where 'type' like concat('%','?','%');
*/

SELECT * FROM `member`

SELECT * FROM `member` WHERE loginId = 'admin';
SELECT * FROM `member` WHERE loginId = 'user1';




