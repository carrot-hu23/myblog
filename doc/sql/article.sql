/*
Navicat MySQL Data Transfer

Source Server         : koupigu
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : blogsdb

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-09-10 11:23:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id,主键',
  `a_user_id` int(11) NOT NULL COMMENT '作者id 外键',
  `a_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `a_context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章正文',
  `a_page_view` int(11) NOT NULL DEFAULT '0' COMMENT '浏览数',
  `a_comment` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `a_publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `a_cover_picture` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '封面图url',
  `a_preview_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '预览正文(70个字)',
  `a_diff` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '时间差(db不保存此字段)',
  `a_category_id` int(11) NOT NULL,
  PRIMARY KEY (`a_id`),
  KEY `a_user_id` (`a_user_id`),
  KEY `a_category_id` (`a_category_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`a_user_id`) REFERENCES `user` (`u_id`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`a_category_id`) REFERENCES `category` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=20190091 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章表';
