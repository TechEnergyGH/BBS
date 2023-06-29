create SCHEMA bbs DEFAULT CHARACTER set utf8;

USE bbs;
CREATE TABLE `user`(
 `uID` int NOT NULL AUTO_INCREMENT COMMENT '用户编号',
 `Name` VARCHAR(20) NOT NULL COMMENT '用户昵称',
 `Password` VARCHAR(20) NOT NULL COMMENT '用户密码',
 `Email` VARCHAR(30) COMMENT '电子邮箱',
 `Sex`  VARCHAR(5) NOT NULL COMMENT '用户性别',
 `Birthday` DATE NOT NULL COMMENT '用户生日',
 `PostNumber` int NOT NULL DEFAULT '0' COMMENT '发帖数',
 `Level` int NOT NULL DEFAULT '0' COMMENT '用户等级',
 `Authority` int NOT NULL DEFAULT '0' COMMENT '权限等级',
 PRIMARY KEY(`uID`)
 UNIQUE KEY(`Email`);
)ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

CREATE TABLE `plate`(
	`pID` int NOT NULL AUTO_INCREMENT COMMENT '板块编号',
	`uID` int COMMENT '版主编号(用户编号)',
	`Name` VARCHAR(50) NOT NULL COMMENT '板块名称',
	`Statement` TEXT COMMENT '板块说明',
	`PostCount` int NOT NULL DEFAULT '0' COMMENT '板块帖子数',
	PRIMARY KEY(`pID`),
	FOREIGN KEY(`uID`) REFERENCES `user`(`uID`) ON DELETE SET NULL
)ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='板块信息表';

CREATE TABLE `mainpost`(
	`mID` int NOT NULL AUTO_INCREMENT COMMENT '主贴编号',
	`pID` int NOT NULL COMMENT '主贴板块编号',
	`uID` int NOT NULL COMMENT '主贴用户编号',
	`Title` VARCHAR(20) NOT NULL COMMENT '主贴标题',
	`Content` TEXT NOT NULL COMMENT '主贴内容',
	`ReleaseTime` DATETIME COMMENT '发布时间',
	`NumberOfHits` int NOT NULL DEFAULT '0' COMMENT '点赞次数',
	`ClickCount` int NOT NULL DEFAULT '0' COMMENT '主贴点击次数',
	PRIMARY KEY(`mID`),
	FOREIGN KEY(`pID`) REFERENCES `plate`(`pID`),
	FOREIGN KEY(`uID`) REFERENCES `user`(`uID`)
)ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8  COMMENT='主贴信息表';

CREATE TABLE `Reply`(
	`rID` int NOT NULL AUTO_INCREMENT COMMENT '回帖编号',
	`mID` int NOT NULL COMMENT '主贴编号',
	`uID` int NOT NULL COMMENT '用户编号',
	`ReplayTime` DATETIME NOT NULL COMMENT '回复时间',
	`NumberOfHits` int NOT NULL DEFAULT '0' COMMENT '点赞次数',
	`Content` TEXT NOT NULL COMMENT '回复内容',
	PRIMARY KEY(`rID`),
	FOREIGN KEY(`mID`) REFERENCES `mainpost`(`mID`),
	FOREIGN KEY(`uID`) REFERENCES `user`(`uID`)
)ENGINE=INNODB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8  COMMENT='回帖表';

CREATE TABLE `PrivateMessage`(
	`pmID` int NOT NULL AUTO_INCREMENT COMMENT '私信编号',
	`suID` int NOT NULL COMMENT '发送用户编号',
	`ruID` int NOT NULL COMMENT '接收用户编号',
	`Content` TEXT COMMENT '内容',
	`SendTime` DATETIME COMMENT '发送时间',
	PRIMARY KEY(`pmID`),
	FOREIGN KEY(`suID`) REFERENCES `user`(`uID`),
	FOREIGN KEY(`ruID`) REFERENCES `user`(`uID`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  COMMENT='私信表';

CREATE TABLE `Report`(
	`ReportID` int NOT NULL AUTO_INCREMENT COMMENT '举报编号',
	`uID` int NOT NULL COMMENT '举报用户',
	`ruID` int NOT NULL COMMENT '被举报用户',
	`ReprotContent` TEXT NOT NULL COMMENT '举报内容',
	`ReportTime` DATETIME NOT NULL COMMENT '举报时间',
	`FeedBackContent` TEXT NOT NULL COMMENT '回复内容',
	`FeedBackTime` DATETIME NOT NULL COMMENT '回复时间',
	PRIMARY KEY(`ReportID`),
	FOREIGN KEY(`uID`) REFERENCES `user`(`uID`),
	FOREIGN KEY(`ruID`) REFERENCES `user`(`uID`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  COMMENT='举报表';

CREATE TABLE `Vote`(
	`VoteID` int NOT NULL AUTO_INCREMENT COMMENT '投票编号',
	`uID` int NOT NULL COMMENT '用户编号',
	`Topic` VARCHAR(50) NOT NULL COMMENT '主题',
	`StartTime` DATETIME NOT NULL COMMENT '开始时间',
	`EndTime` DATETIME COMMENT '结束时间',
	PRIMARY KEY(`VoteID`),
	FOREIGN KEY(`uID`) REFERENCES `user`(`uID`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  COMMENT='投票表';

CREATE TABLE `VoteOption`(
	`OptionID` int NOT NULL AUTO_INCREMENT COMMENT '选项编号',
	`VoteID` int NOT NULL COMMENT '投票编号',
	`Option` TEXT NOT NULL COMMENT '选项内容',
	PRIMARY KEY(`OptionID`),
	FOREIGN KEY(`VoteID`) REFERENCES `Vote`(`VoteID`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  COMMENT='投票选项表';

CREATE TABLE `VotePerson`(
	`VotePersonID` int NOT NULL AUTO_INCREMENT COMMENT '投票人编号',
	`OptionID` int NOT NULL COMMENT '选项编号',
	`uID` int NOT NULL COMMENT '用户编号',
	PRIMARY KEY(`VotePersonID`),
	FOREIGN KEY(`OptionID`) REFERENCES `VoteOption`(`OptionID`),
	FOREIGN KEY(`uID`) REFERENCES `user`(`uID`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  COMMENT='投票人表';

SELECT * FROM user WHERE uID=10;

INSERT into user VALUES(0,"lisi","123456","1234@qq.com","男",'2023-6-26','0','0','0');
delete from user where uID=24;
UPDATE user SET Name='1' WHERE uID='16';

CREATE VIEW v_Vote AS SELECT vote.uID,Topic,vote.VoteID,`Option`,`VotePersonID` FROM vote,voteoption,voteperson
WHERE vote.VoteID=voteoption.VoteID and voteoption.OptionID=voteperson.OptionID;

INSERT INTO plate VALUES(0,10,"test","test?",0);


CREATE TRIGGER  after_insert_mainpost AFTER INSERT ON mainpost FOR EACH ROW
BEGIN
	UPDATE `user` SET PostNumber=PostNumber + 1 WHERE uID=new.uID;
	UPDATE plate SET PostCount=PostCount + 1 WHERE pID=new.pID;
END;

CREATE TRIGGER after_delete_mainpost AFTER DELETE ON mainpost FOR EACH ROW
BEGIN
	UPDATE `user` SET PostNumber=PostNumber - 1 WHERE uID=old.uID;
	UPDATE plate SET PostCount=PostCount - 1 WHERE pID=old.pID;
END;