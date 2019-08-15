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

 Date: 15/08/2019 12:47:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_dept_id` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色管理';

SET FOREIGN_KEY_CHECKS = 1;
