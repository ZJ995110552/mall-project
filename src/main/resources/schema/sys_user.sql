/*
 Navicat Premium Data Transfer

 Source Server         : 10.211.55.6
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : 10.211.55.6:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 22/05/2019 22:08:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(40) NOT NULL COMMENT 'id',
  `user_id` varchar(50) NOT NULL COMMENT '用户编号',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `head_url` varchar(200) DEFAULT NULL COMMENT '头像',
  `gender` tinyint(3) unsigned DEFAULT NULL COMMENT '性别   0：男   1：女    2：保密',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '归属组织',
  `super_admin` tinyint(3) unsigned DEFAULT NULL COMMENT '超级管理员   0：否   1：是',
  `last_login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：停用   1：正常',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`),
  KEY `idx_create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

SET FOREIGN_KEY_CHECKS = 1;
