CREATE DATABASE IF NOT EXISTS `cloud2020` DEFAULT character SET utf8mb4 collate utf8mb4_general_ci;
USE cloud2020;

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`(
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`serial` varchar(200) DEFAULT '',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
