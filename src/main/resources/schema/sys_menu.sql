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

 Date: 15/08/2019 12:47:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级ID，一级菜单为0',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `permissions` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:list,sys:user:save)',
  `type` tinyint(3) unsigned DEFAULT NULL COMMENT '类型   0：菜单   1：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_pid` (`pid`),
  KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

SET FOREIGN_KEY_CHECKS = 1;
