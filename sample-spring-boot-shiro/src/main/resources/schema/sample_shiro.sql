/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : sample_shiro

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-07-31 17:41:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`permission_name` varchar(50) NOT NULL COMMENT '权限名',
`role_id` int(11) DEFAULT NULL COMMENT '外键关联role',
PRIMARY KEY (`id`),
KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'article:add', '3');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`rolename` varchar(20) DEFAULT NULL COMMENT '角色名称',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');
INSERT INTO `role` VALUES ('2', 'user');
INSERT INTO `role` VALUES ('3', 'editor');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
`username` varchar(20) NOT NULL COMMENT '用户名',
`password` varchar(50) NOT NULL COMMENT '密码',
`salt` varchar(50) NOT NULL COMMENT '盐值',
`role_id` int(11) NOT NULL COMMENT '外键关联role表',
PRIMARY KEY (`id`),
KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'b5040da053372bdcdef5f9bf602f5858', '15e76e8bdcfc4788860120d45dfb54ed', '1');
INSERT INTO `user` VALUES ('2', 'user', '8234bc2ad84d8c52894135f751e09de1', '1d4316c564a04bea95b1476463e95180', '2');
INSERT INTO `user` VALUES ('3', 'editor', '1d9d0bdfa309ebe5a263ff057861b6f2', '0aae75172866450e8e27a6df76859d08', '3');