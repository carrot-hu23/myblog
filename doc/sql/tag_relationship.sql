/*
Navicat MySQL Data Transfer

Source Server         : koupigu
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : blogsdb

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-09-10 11:24:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tag_relationship
-- ----------------------------
DROP TABLE IF EXISTS `tag_relationship`;
CREATE TABLE `tag_relationship` (
  `relationship_a_id` int(11) NOT NULL,
  `relationship_t_id` int(11) NOT NULL,
  KEY `a_id` (`relationship_a_id`),
  KEY `t_id` (`relationship_t_id`),
  CONSTRAINT `tag_relationship_ibfk_1` FOREIGN KEY (`relationship_a_id`) REFERENCES `article` (`a_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tag_relationship_ibfk_2` FOREIGN KEY (`relationship_t_id`) REFERENCES `tag` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
