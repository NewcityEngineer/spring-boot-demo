/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : springboot_demo

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-05 11:16:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `code` varchar(32) DEFAULT NULL COMMENT '部门编码',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES ('1', '123', '123', '2018-07-05 10:25:35', '2018-07-05 10:25:41');
INSERT INTO `tb_dept` VALUES ('2', '开发部', 'dev', '2018-07-05 10:40:30', '2018-07-05 10:40:30');
INSERT INTO `tb_dept` VALUES ('4', '开发部', 'dev2', '2018-07-05 10:55:19', '2018-07-05 10:55:19');
INSERT INTO `tb_dept` VALUES ('5', '开发部', 'dev2', '2018-07-05 10:55:55', '2018-07-05 10:55:55');
INSERT INTO `tb_dept` VALUES ('6', '开发部', 'dev2', '2018-07-05 10:56:22', '2018-07-05 10:56:22');
