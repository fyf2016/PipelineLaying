/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : pipelying

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-01-13 21:52:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `building`
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `point` varchar(50) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `letter` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES ('1', '东区大学生活动中心(A)', '119.544183,39.907721', '东大活负责为学校大型活动、会议、训练、演出和竞赛提供网上借用场地、灯光、音响及相关服务；负责接收校内单位及个人的场馆租用预订工作。东大活为大学生进行文化艺术娱乐活动，丰富大学生课余生活提供了场所。', 'images/1.jpg', 'A');
INSERT INTO `building` VALUES ('2', '学生公寓(B)', '119.542234,39.907517', '本科生公寓为6人间（个别为8人间），室内配有上下铺铁床、床垫、暖气、储葳柜、书柜、桌椅等设施，可自费上网。', 'images/2.jpg', 'B');
INSERT INTO `building` VALUES ('3', '学生食堂(C)', '119.542139,39.909945', '东区食堂包括二食堂、三食堂、清真餐厅、教师餐厅，食堂环境干净整洁，饭菜可口美味、种类丰富。 ', 'images/3.jpg', 'C');
INSERT INTO `building` VALUES ('4', '世纪楼(D)', '119.543913,39.911101', '燕山大学行政中心，是燕大的办公楼，21层的独特设计代表21世纪，是燕大最高的建筑。', 'images/4.jpg', 'D');
INSERT INTO `building` VALUES ('5', '第一教学楼(E)', '119.544699,39.91016', '一教位于图书馆东侧，每到春夏，满墙的爬山虎成为校园一道亮丽的风景线。教室明亮宽敞，楼道干净整洁，学习设施齐全。', 'images/5.jpg', 'E');
INSERT INTO `building` VALUES ('6', '第二教学楼(F)', '119.546388,39.912187', '二教位于一教旁边,散发着学术气息,和一教的爬山虎景色相互映衬', 'images/6.jpg', 'F');
INSERT INTO `building` VALUES ('7', '第三教学楼(G)', '119.544295,39.909983', '三教位于图书馆西侧，内有机房和教室等，教室宽敞明亮，学习设施齐全。', 'images/7.jpg', 'G');
INSERT INTO `building` VALUES ('8', '第四教学楼(H)', '119.545746,39.915251', '四教位于人文馆对侧，隶属于车辆学院，楼道干净整洁，学习设施齐全', 'images/8.jpg', 'H');
INSERT INTO `building` VALUES ('9', '图书馆(I)', '119.544403,39.910793', '图书馆共七层，包括8个阅览室以及6个自习室。到目前为止，本馆收藏有中外文图书110多万册，期刊2200余种，馆藏覆盖了我校所有学科，尤以重型机械及其相关专业文献收藏最具特色。', 'images/9.jpg', 'I');
INSERT INTO `building` VALUES ('10', '机械馆(J)', '119.545,39.911543', '机械馆隶属于机械工程学院，是该学院进行教育教学工作、科研工作以及学生组织活动工作的主要场所。毗邻图书馆、第一教学楼与第三教学楼。富有浓浓的学术学习氛围和设施。', 'images/10.jpg', 'J');
INSERT INTO `building` VALUES ('11', '信息馆(K)', '119.544241,39.914864', '信息馆隶属于信息科学与技术学院，内设机房、实验室、团委办公室、综合会议室等，以供学生学习、教师科研、以及学院正常秩序管理的场所。既能体现工科学院的严谨务实，又弥漫着人文气息。', 'images/11.jpg', 'K');
INSERT INTO `building` VALUES ('12', '人文馆(M)', '119.544973,39.916497', '人文馆与信息馆相邻，是燕大最具人文情怀的建筑，具有“儒雅恬静与朝气蓬勃融合，开放与实用结合”的气质，内含报告厅和展厅等场所，给我们提供便利。', 'images/12.jpg', 'M');
INSERT INTO `building` VALUES ('13', '体育馆(L)', '119.546227,39.917008', '燕大学子体育活动中心，供学生进行乒乓球、篮球、羽毛球等各种运动项目，场地丰富多样，深受学生喜爱。', 'images/13.jpg', 'L');
