/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.56.6
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : 192.168.56.6:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 15/08/2019 12:47:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色用户关系';

SET FOREIGN_KEY_CHECKS = 1;
