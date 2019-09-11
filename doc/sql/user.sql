/*
Navicat MySQL Data Transfer

Source Server         : koupigu
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : blogsdb

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-09-10 11:24:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(50) NOT NULL,
  `u_password` varchar(18) NOT NULL,
  `u_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `u_photo` varchar(100) NOT NULL DEFAULT 'http://localhost:8080/image/user/photo.jpg',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2019826 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
