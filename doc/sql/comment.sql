/*
Navicat MySQL Data Transfer

Source Server         : koupigu
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : blogsdb

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-09-10 11:23:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_article_id` int(11) NOT NULL,
  `c_user_id` int(11) NOT NULL,
  `c_context` varchar(255) NOT NULL,
  `c_discuss_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `c_comment_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`c_id`),
  KEY `c_user_id` (`c_user_id`),
  KEY `c_article_id` (`c_article_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`c_user_id`) REFERENCES `user` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`c_article_id`) REFERENCES `article` (`a_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
