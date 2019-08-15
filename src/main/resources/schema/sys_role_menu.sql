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

 Date: 15/08/2019 12:47:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_menu_id` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关系';

SET FOREIGN_KEY_CHECKS = 1;
