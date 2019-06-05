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

 Date: 05/06/2019 21:00:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log_operation
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_operation`;
CREATE TABLE `sys_log_operation` (
  `id` bigint(40) NOT NULL COMMENT 'id',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `request_uri` varchar(200) DEFAULT NULL COMMENT '请求URI',
  `request_method` varchar(20) DEFAULT NULL COMMENT '请求方式',
  `request_params` text COMMENT '请求参数',
  `request_time` int(10) unsigned NOT NULL COMMENT '请求时长(毫秒)',
  `user_agent` varchar(500) DEFAULT NULL COMMENT '用户代理',
  `ip` varchar(32) DEFAULT NULL COMMENT '操作IP',
  `status` int(3) unsigned NOT NULL COMMENT '状态  0：失败   1：成功',
  `creator_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

SET FOREIGN_KEY_CHECKS = 1;
