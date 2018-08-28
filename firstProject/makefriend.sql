/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50719
Source Host           : 127.0.0.1:3308
Source Database       : makefriend

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-08-28 16:17:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `logname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `pic` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`logname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('json', '11', '11', '111', '12', '25');
INSERT INTO `member` VALUES ('sunny', '123456', '15079254030', '26328554226@qq.com', '辉哥来了', '辉哥');
INSERT INTO `member` VALUES ('sunshine', '123', '123', '123', '123', '123');
