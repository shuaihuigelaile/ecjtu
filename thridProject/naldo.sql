/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50719
Source Host           : 127.0.0.1:3308
Source Database       : naldo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-08-28 21:31:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `consignee_name` varchar(255) DEFAULT NULL,
  `consignee_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `comments_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `commodity_id` int(11) DEFAULT NULL,
  `comments_time` datetime DEFAULT NULL,
  `comment_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comments_id`),
  KEY `user_id` (`user_id`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `commodity_name` varchar(255) DEFAULT NULL,
  `commodity_introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `commodity_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `commodity_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `commodity_attribute_value`;
CREATE TABLE `commodity_attribute_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_property_type_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `commodity_attribute_value_ibfk_1` FOREIGN KEY (`id`) REFERENCES `commodity_property_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_attribute_value
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_ifo
-- ----------------------------
DROP TABLE IF EXISTS `commodity_ifo`;
CREATE TABLE `commodity_ifo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) DEFAULT NULL,
  `style_no` int(11) DEFAULT NULL,
  `commodity_price` double DEFAULT NULL,
  `quantity_commodity` int(11) DEFAULT NULL,
  `commodity_color` varchar(255) DEFAULT NULL,
  `clarity` varchar(255) DEFAULT NULL,
  `cut` varchar(255) DEFAULT NULL,
  `polishing` varchar(255) DEFAULT NULL,
  `symmetry` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `commodity_ifo_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_ifo
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_images
-- ----------------------------
DROP TABLE IF EXISTS `commodity_images`;
CREATE TABLE `commodity_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `commodity_images_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_images
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_property
-- ----------------------------
DROP TABLE IF EXISTS `commodity_property`;
CREATE TABLE `commodity_property` (
  `commodity_info_Id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_property_id` int(11) DEFAULT NULL,
  `commodity_property_value_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`commodity_info_Id`),
  KEY `commodity_property_value_id` (`commodity_property_value_id`),
  CONSTRAINT `commodity_property_ibfk_1` FOREIGN KEY (`commodity_info_Id`) REFERENCES `commodity_ifo` (`id`),
  CONSTRAINT `commodity_property_ibfk_2` FOREIGN KEY (`commodity_property_value_id`) REFERENCES `commodity_property_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_property
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_property_type
-- ----------------------------
DROP TABLE IF EXISTS `commodity_property_type`;
CREATE TABLE `commodity_property_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_property_type
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_type
-- ----------------------------
DROP TABLE IF EXISTS `commodity_type`;
CREATE TABLE `commodity_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_type
-- ----------------------------
INSERT INTO `commodity_type` VALUES ('2', '裤子');
INSERT INTO `commodity_type` VALUES ('3', '裤子');
INSERT INTO `commodity_type` VALUES ('7', '上衣');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` int(11) DEFAULT NULL,
  `user_Id` int(11) DEFAULT NULL,
  `order_State` varchar(255) DEFAULT NULL,
  `payment_status` smallint(1) DEFAULT NULL,
  `shipment_Status` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `userinfo` (`id`),
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for shopping_trolley
-- ----------------------------
DROP TABLE IF EXISTS `shopping_trolley`;
CREATE TABLE `shopping_trolley` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) DEFAULT NULL,
  `shopping_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `shopping_trolley_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`id`),
  CONSTRAINT `shopping_trolley_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_trolley
-- ----------------------------

-- ----------------------------
-- Table structure for trade_information
-- ----------------------------
DROP TABLE IF EXISTS `trade_information`;
CREATE TABLE `trade_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `commodity_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount_payable` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `trade_information_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `trade_information_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_information
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2016 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sunny', '2632855426@qq.com', '25', '15079254030');
INSERT INTO `user` VALUES ('2', 'json', '123', '25', '222');
INSERT INTO `user` VALUES ('3', 'lucy', '123', '25', '222');
INSERT INTO `user` VALUES ('4', 'zhuzi', '243949538', 'root', '');
INSERT INTO `user` VALUES ('5', 'liuyongnong', '243949538', 'root', '');
INSERT INTO `user` VALUES ('2015', 'sunny3', '15070246728', 'root', '15070246728');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `idCard` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(4) DEFAULT '保密',
  `date_birth` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2016 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'sunny', '22', '23', '22', '2', '55', '保密', null);
INSERT INTO `userinfo` VALUES ('2', 'lucy', '25', '66', '66', '66', '66', '保密', null);
INSERT INTO `userinfo` VALUES ('8', 'admin', '22', '123456', '', '123', 'sunny', 'jjj', null);
INSERT INTO `userinfo` VALUES ('9', 'sunshine', '', '25', '256', '256', 'sss', '', null);
INSERT INTO `userinfo` VALUES ('10', 'jack', '243949538', 'root', '', '123', 'feifei', '', null);
INSERT INTO `userinfo` VALUES ('11', 'zhuzi', '243949538', 'root', '', '123', 'feifei', '', null);
INSERT INTO `userinfo` VALUES ('12', 'liuyongnong', '243949538', 'root', '', '123', 'feifei', '', null);
INSERT INTO `userinfo` VALUES ('2015', 'sunny3', '15070246728', 'root', '15070246728', '360427', 'yycl', '保密', null);
