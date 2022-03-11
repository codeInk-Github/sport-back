/*
Navicat MySQL Data Transfer

Source Server         : Testblog
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : easyproject

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2020-05-27 14:48:38
*/
DROP DATABASE IF EXISTS `SPORT`;

CREATE DATABASE `SPORT`;

USE `SPORT`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for easyuser
-- ----------------------------
DROP TABLE IF EXISTS `easyuser`;
CREATE TABLE `easyuser` (
                            `id` int(24) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `username` varchar(255) NOT NULL,
                            `password` varchar(255) NOT NULL,
                            `email` varchar(255) NOT NULL,
                            `role` varchar(255) NOT NULL,
                            `state` tinyint(1) NOT NULL DEFAULT '0',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easyuser
-- ----------------------------
INSERT INTO `easyuser`(username, password, email, role, state)
 VALUES ('admin', '123456', '123@qq.com', '超级管理员', '1');
INSERT INTO `easyuser`(username, password, email, role, state)
 VALUES ('naughty', '888888', '456@qq.com', '普通管理员', '0');
INSERT INTO `easyuser`(username, password, email, role, state)
 VALUES ('flysky01', '987654', 'qwe@qq.com', '普通用户', '1');
INSERT INTO `easyuser`(username, password, email, role, state)
 VALUES ('anglybirds', '321654', 'aaaa@163.com', '普通用户', '0');
INSERT INTO `easyuser`(username, password, email, role, state)
 VALUES ('admin003', 'q123456', 'c@qq.com', '普通用户', '1');
INSERT INTO `easyuser`(username, password, email, role, state)
 VALUES ('admin005', '123456', 'cxz@qq.com', '普通用户', '0');
INSERT INTO `easyuser`(username, password, email, role, state)
 VALUES ('zucker', '123456', 'rty@qq.com', '普通用户', '1');



SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mainmenu
-- ----------------------------
DROP TABLE IF EXISTS `mainmenu`;
CREATE TABLE `mainmenu` (
                            `id` int(50) NOT NULL AUTO_INCREMENT,
                            `title` varchar(255) NOT NULL,
                            `path` varchar(255) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainmenu
-- ----------------------------
INSERT INTO `mainmenu` VALUES ('100', '权限管理', '/admin');
INSERT INTO `mainmenu` VALUES ('200', '运动平台', '/use');

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for submenu
-- ----------------------------
DROP TABLE IF EXISTS `submenu`;
CREATE TABLE `submenu` (
                           `id` int(50) NOT NULL AUTO_INCREMENT,
                           `title` varchar(255) NOT NULL,
                           `path` varchar(255) NOT NULL,
                           `mid` int(50) NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `mid` (`mid`),
                           CONSTRAINT `submenu_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `mainmenu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submenu
-- ----------------------------
INSERT INTO `submenu` VALUES ('101', '用户列表', '/user', '100');
INSERT INTO `submenu` VALUES ('102', '修改权限', '/rights', '100');
INSERT INTO `submenu` VALUES ('103', '运动模块', '/sport', '100');
INSERT INTO `submenu` VALUES ('104', '商品模块', '/goods', '100');
INSERT INTO `submenu` VALUES ('201', '运动科普', '/Introduction', '200');
INSERT INTO `submenu` VALUES ('202', '卡路里', '/calories', '200');
INSERT INTO `submenu` VALUES ('203', '营养配餐', '/food', '200');