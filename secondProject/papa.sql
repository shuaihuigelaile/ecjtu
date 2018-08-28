/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50719
Source Host           : 127.0.0.1:3308
Source Database       : papa

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-08-28 16:01:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '课程名称',
  `classify` varchar(50) NOT NULL DEFAULT '' COMMENT '一级分类',
  `classify_name` varchar(100) NOT NULL DEFAULT '' COMMENT '一级分类名称',
  `sub_classify` varchar(50) NOT NULL DEFAULT '' COMMENT '二级分类',
  `sub_classify_name` varchar(100) NOT NULL DEFAULT '' COMMENT '二级分类名称',
  `username` varchar(200) NOT NULL DEFAULT '' COMMENT '归属人',
  `level` tinyint(1) NOT NULL DEFAULT '1' COMMENT '课程级别：1-初级，2-中级，3-高级',
  `duration` varchar(50) NOT NULL DEFAULT '' COMMENT '时长',
  `brief` text COMMENT '课程描述',
  `study_count` int(11) NOT NULL DEFAULT '0' COMMENT '学习人数',
  `weight` int(11) NOT NULL DEFAULT '1' COMMENT '权重',
  `price` varchar(10) DEFAULT NULL,
  `oldprice` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('1', '小学数学', '0', '小学', '二级分类', '二级分类名称', 'sunny', '1', '700', '此课程很有意义', '30', '1', '12', '12');
INSERT INTO `t_course` VALUES ('2', '初中数学', '1', '初中', '二级分类', '二级分类名称', 'admin', '2', '700', '此课程很有意义', '20', '1', '25', '25');
INSERT INTO `t_course` VALUES ('3', '中国现代史和美国之未来建造', '1', '初中', '二级分类', '二级分类名称', 'sunshine', '3', '800', '此课程很有意义', '10', '1', '36', '26');
INSERT INTO `t_course` VALUES ('4', '上海发展', '2', '高中', '二级分类', '二级分类名称', 'sunshine', '3', '80', '此课程很有意义', '80', '1', '25', '156');
INSERT INTO `t_course` VALUES ('5', '上海来了', '3', '家庭教育', '5', '三年级', 'sunny', '1', '', null, '0', '1', '400', null);
INSERT INTO `t_course` VALUES ('7', '上海来了', '3', '家庭教育', '二级分类', '二级分类名称', 'json', '1', '', 'ssmmd', '0', '1', '600', '2563');
INSERT INTO `t_course` VALUES ('8', '欧盟', '', '', '', '', 'sunny', '1', '', null, '0', '1', '800', '10000');
INSERT INTO `t_course` VALUES ('9', 'java技术', '一级分类', '一级分类名称', '二级分类', '二级分类名称', 'sunshine', '1', '', null, '0', '1', '1500', '256');
INSERT INTO `t_course` VALUES ('10', 'python', '', '', '', '', 'sunny', '1', '', null, '0', '1', '2000', '365');
INSERT INTO `t_course` VALUES ('11', 'php大佬', '', '', '', '', 'json', '1', '', null, '0', '1', '10000', '598');
INSERT INTO `t_course` VALUES ('12', 'c语言', '', '', '', '', 'sunshine', '1', '', null, '0', '1', '20000', '569');
INSERT INTO `t_course` VALUES ('13', 'jsp', '', '', '', '', 'json', '1', '', null, '0', '1', '20000', '695');
INSERT INTO `t_course` VALUES ('14', '中国近代史', '一级分类', '一级分类名称', '二级分类', '二级分类名称', 'sunshine', '1', '', '中国好', '0', '1', '3000', '586');

-- ----------------------------
-- Table structure for t_course_classify
-- ----------------------------
DROP TABLE IF EXISTS `t_course_classify`;
CREATE TABLE `t_course_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `code` varchar(50) NOT NULL DEFAULT '',
  `parent_code` varchar(50) NOT NULL DEFAULT '0' COMMENT '父级别code，如果值为0则代表是一级分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程类别表';

-- ----------------------------
-- Records of t_course_classify
-- ----------------------------

-- ----------------------------
-- Table structure for t_course_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_course_comment`;
CREATE TABLE `t_course_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL DEFAULT '' COMMENT '用户username',
  `to_username` varchar(200) NOT NULL DEFAULT '' COMMENT '评论对象username',
  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程id',
  `section_id` int(11) NOT NULL DEFAULT '0' COMMENT '章节id',
  `section_title` varchar(200) NOT NULL DEFAULT '' COMMENT '章节标题',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '评论内容',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程评论表';

-- ----------------------------
-- Records of t_course_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_course_section
-- ----------------------------
DROP TABLE IF EXISTS `t_course_section`;
CREATE TABLE `t_course_section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '归属课程id',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父章节id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '章节名称',
  `time` varchar(50) NOT NULL DEFAULT '' COMMENT '时长',
  `video_url` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程章节表';

-- ----------------------------
-- Records of t_course_section
-- ----------------------------

-- ----------------------------
-- Table structure for t_mall_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_mall_cart`;
CREATE TABLE `t_mall_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `productId` int(11) DEFAULT NULL COMMENT '''商品id''',
  `quantity` int(11) DEFAULT NULL COMMENT '''数量''',
  `checked` int(11) DEFAULT NULL COMMENT '''是否选择，1=已勾选,0=未勾选''',
  `createTime` datetime DEFAULT NULL COMMENT '''创建时间''',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_mall_cart
-- ----------------------------
INSERT INTO `t_mall_cart` VALUES ('5', '2', '3', '4', null, '2018-08-23 19:53:59', '2018-08-24 15:09:02');
INSERT INTO `t_mall_cart` VALUES ('6', '2', '2', '4', null, '2018-08-23 19:57:29', '2018-08-24 15:09:02');
INSERT INTO `t_mall_cart` VALUES ('8', '2', '1', '4', null, '2018-08-24 12:51:28', '2018-08-24 15:09:02');
INSERT INTO `t_mall_cart` VALUES ('9', '2', '5', '4', null, '2018-08-24 12:52:40', '2018-08-24 15:09:02');
INSERT INTO `t_mall_cart` VALUES ('27', '1', '1', '1', null, '2018-08-24 16:12:57', null);
INSERT INTO `t_mall_cart` VALUES ('28', '1', '8', '3', null, '2018-08-24 16:37:57', '2018-08-25 21:27:30');
INSERT INTO `t_mall_cart` VALUES ('29', '1', '10', '2', null, '2018-08-25 21:28:35', '2018-08-25 21:28:37');
INSERT INTO `t_mall_cart` VALUES ('30', '17', '5', '1', null, '2018-08-27 14:45:17', null);
INSERT INTO `t_mall_cart` VALUES ('33', '18', '2', '10', null, '2018-08-27 19:10:29', '2018-08-27 19:32:46');
INSERT INTO `t_mall_cart` VALUES ('34', '18', '5', '2', null, '2018-08-27 19:28:05', '2018-08-27 19:33:01');
INSERT INTO `t_mall_cart` VALUES ('35', '18', '4', '2', null, '2018-08-27 19:32:00', '2018-08-27 19:32:56');
INSERT INTO `t_mall_cart` VALUES ('36', '18', '3', '2', null, '2018-08-27 19:32:05', '2018-08-27 19:32:50');
INSERT INTO `t_mall_cart` VALUES ('37', '18', '1', '1', null, '2018-08-27 19:32:41', null);
INSERT INTO `t_mall_cart` VALUES ('38', '13', '1', '2', null, '2018-08-27 21:36:49', '2018-08-27 21:36:55');
INSERT INTO `t_mall_cart` VALUES ('39', '13', '3', '1', null, '2018-08-27 21:37:01', null);
INSERT INTO `t_mall_cart` VALUES ('40', '17', '1', '1', null, '2018-08-28 11:00:32', null);
INSERT INTO `t_mall_cart` VALUES ('41', '11', '1', '1', null, '2018-08-28 15:45:39', null);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderId` int(25) NOT NULL AUTO_INCREMENT,
  `receiver` varchar(255) NOT NULL,
  `money` varchar(255) DEFAULT NULL,
  `orderStaus` tinyint(10) DEFAULT NULL,
  `payStaus` tinyint(10) DEFAULT NULL,
  `sendGoodStaus` tinyint(10) DEFAULT NULL,
  `payWay` varchar(255) DEFAULT NULL,
  `sendWay` varchar(255) DEFAULT NULL,
  `buyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=1940049477 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('26958824', 'sunny', '125', '0', '0', '0', null, null, '2018-08-28 09:47:12');
INSERT INTO `t_order` VALUES ('364235962', 'sunny', '125', '0', '0', '0', null, null, '2018-08-27 23:02:38');
INSERT INTO `t_order` VALUES ('1238657629', 'json', null, '0', '0', '0', null, null, '2018-12-20 00:00:00');
INSERT INTO `t_order` VALUES ('1447859491', 'sunny', '0', '0', '0', '0', null, null, '2018-08-28 09:46:34');
INSERT INTO `t_order` VALUES ('1940049476', 'huawei', '60', '0', '0', '0', null, null, '2018-08-27 21:37:15');

-- ----------------------------
-- Table structure for t_site_carousel
-- ----------------------------
DROP TABLE IF EXISTS `t_site_carousel`;
CREATE TABLE `t_site_carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `picture` varchar(100) NOT NULL DEFAULT '' COMMENT '图片URL',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '链接URL',
  `weight` int(11) NOT NULL DEFAULT '0' COMMENT '权重',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页轮播表';

-- ----------------------------
-- Records of t_site_carousel
-- ----------------------------

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `major` varchar(255) DEFAULT NULL,
  `honor` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '邹微微', '数学', '获得优秀教师奖', '是一名性格开朗的老师');
INSERT INTO `t_teacher` VALUES ('2', '王维', '语文', '获得优秀教师奖', '是一名性格开朗的老师');
INSERT INTO `t_teacher` VALUES ('3', '邹贵森', '英语', '获得优秀教师奖', '是一名性格开朗的老师');
INSERT INTO `t_teacher` VALUES ('4', '邹桂平', '语文', '获得优秀教师奖', '是一名性格开朗的老师');
INSERT INTO `t_teacher` VALUES ('5', '刘超', '英语', '获得优秀教师奖', '是一名性格开朗的老师');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `gender` tinyint(1) NOT NULL DEFAULT '1' COMMENT '性别: 0-女；1-男',
  `header` varchar(128) NOT NULL DEFAULT '' COMMENT '头像',
  `phone` varchar(15) NOT NULL DEFAULT '' COMMENT '手机号码',
  `education` varchar(20) NOT NULL DEFAULT '' COMMENT '学历：大专及其以下、本科、硕士、博士、博士后',
  `college_name` varchar(100) NOT NULL DEFAULT '' COMMENT '大学名称',
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '头衔',
  `sign` varchar(500) NOT NULL DEFAULT '' COMMENT '签名',
  `province` varchar(16) NOT NULL DEFAULT '' COMMENT '所在省份',
  `city` varchar(16) NOT NULL DEFAULT '' COMMENT '所在城市',
  `weight` int(11) NOT NULL DEFAULT '0' COMMENT '权重',
  `email` varchar(20) DEFAULT NULL,
  `joinTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `T_USER_USERNAME_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户表(学生和教师同属于这一张表)';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('8', 'yinshaohui', '456', '1', '', '', '', '', '', '', '', '', '0', null, null);
INSERT INTO `t_user` VALUES ('9', 'sunshine', '456', '1', '', '', '', '', '', '', '', '', '0', null, null);
INSERT INTO `t_user` VALUES ('11', 'huige', '123', '1', '', '', '', '', '', '', '', '', '0', null, null);
INSERT INTO `t_user` VALUES ('12', 'shuaihuige', '123', '1', '', '', '', '', '', '', '', '', '0', null, null);
INSERT INTO `t_user` VALUES ('13', 'huawei', '123', '1', '', '', '', '', '', '', '', '', '0', null, null);
INSERT INTO `t_user` VALUES ('15', 'jjj', '123', '1', '', '', '', '', '', '', '', '', '0', null, null);
INSERT INTO `t_user` VALUES ('16', '123456', '123456', '1', '', '15079254030', '', '', '', '', '', '', '0', '263@qq.com', null);
INSERT INTO `t_user` VALUES ('17', 'sunny', '123456', '1', '', '15079254030', '', '', '', '', '', '', '0', '2632855426@qq.com', null);
INSERT INTO `t_user` VALUES ('18', 'admin', '123456', '1', '', '123', '', '', '', '', '', '', '0', '263285@qq.com', null);

-- ----------------------------
-- Table structure for t_user_collections
-- ----------------------------
DROP TABLE IF EXISTS `t_user_collections`;
CREATE TABLE `t_user_collections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '收藏课程id',
  `create_time` datetime DEFAULT NULL,
  `course_name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏表';

-- ----------------------------
-- Records of t_user_collections
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_course_section
-- ----------------------------
DROP TABLE IF EXISTS `t_user_course_section`;
CREATE TABLE `t_user_course_section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程id',
  `section_id` int(11) NOT NULL DEFAULT '0' COMMENT '章节id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态：0-学习中；1-学习结束',
  `rate` int(11) NOT NULL DEFAULT '0' COMMENT '学习进度',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户学习表，记录用户所学的课程及其课程章节';

-- ----------------------------
-- Records of t_user_course_section
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_follows
-- ----------------------------
DROP TABLE IF EXISTS `t_user_follows`;
CREATE TABLE `t_user_follows` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `follow_id` int(11) NOT NULL DEFAULT '0' COMMENT '关注的用户id',
  `create_time` datetime DEFAULT NULL,
  `follow_name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注表';

-- ----------------------------
-- Records of t_user_follows
-- ----------------------------
