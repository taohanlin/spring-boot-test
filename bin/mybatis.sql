/*
Navicat MySQL Data Transfer

Source Server         : userInfo
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-06-15 10:01:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `sum_score` double(20,0) NOT NULL COMMENT '分数',
  `avg_score` double(20,0) NOT NULL COMMENT '平均分',
  `age` int(10) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '500', '500', '20');
INSERT INTO `student` VALUES ('2', '李四', '489', '489', '21');
INSERT INTO `student` VALUES ('3', '王五', '620', '600', '600');
INSERT INTO `student` VALUES ('4', '赵六', '520', '520', '520');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(80) NOT NULL,
  `age` int(10) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UQ_User_userName` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '123', '10');
INSERT INTO `user` VALUES ('2', '李四', '456', '20');
INSERT INTO `user` VALUES ('3', '王五', '789', '30');
