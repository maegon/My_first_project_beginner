DROP DATABASE IF EXISTS ljw_beginner_pj_sbs;
CREATE DATABASE ljw_beginner_pj_sbs;
USE ljw_beginner_pj_sbs;

/*
CREATE TABLE article(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL,
	memberId INT(10) UNSIGNED NOT NULL,
	boardId INT(10) UNSIGNED NOT NULL,
	hit int(10) unsigned not null,
	INDEX boardId(`boardId`)
);


ALTER TABLE article ADD COLUMN hit INT(10) UNSIGNED NOT NULL;


insert into article
set regDate = now(),
updateDate = now(),
title = '제목1',
`body` = '내용1',
memberId = 1,
boardId = 1,
hit = 45;


INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목2',
`body` = '내용2',
memberId = 2,
boardId = 2,
hit = 16;


INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목3',
`body` = '내용3',
memberId = 3,
boardId = 2,
hit = 453;


select * from article;


CREATE TABLE articleReply(
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	`body` char(100) NOT NULL,
	memberId INT(10) UNSIGNED NOT NULL,
	articleId INT(10) UNSIGNED NOT NULL,
	INDEX articleId(`articleId`)
);

INSERT INTO articleReply
SET regDate = NOW(),
updateDate = NOW(),
`body` = '댓글1',
memberId = 1,
articleId = 2;

INSERT INTO articleReply
SET regDate = NOW(),
updateDate = NOW(),
`body` = '댓글2',
memberId = 2,
articleId = 1;

SELECT * FROM articleReply

*/

CREATE TABLE `member`(
	id INT(100) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(100) NOT NULL UNIQUE,
	loginPw CHAR(100) NOT NULL,
	`memberName` CHAR(100) NOT NULL,
	`memberEmail` CHAR(100) NOT NULL
);

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
`loginId` = 'admin99104sbs',
`loginPw` = 'admin99104sbsjw',
`memberName` = '관리자',
`memberEmail` = '99gorhs@gmail.com';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
`loginId` = 'user1',
`loginPw` = 'user1',
`memberName` = 'user1',
`memberEmail` = 'user1@gmail.com';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
`loginId` = 'user2',
`loginPw` = 'user2',
`memberName` = 'user2',
`memberEmail` = 'user2@gmail.com';

SELECT * FROM `member`


/*
Create table board (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	`code` char(100) not null unique, #free/notice
	`name` char(100) not null #자유/공지
);

INSERT INTO `board`
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'notice',
`name` = '공지';

INSERT INTO `board`
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'free',
`name` = '자유';

select * from `board`;

SELECT * FROM `article`;
SELECT * FROM `articleReply`;
*/

