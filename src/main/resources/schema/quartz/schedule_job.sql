/*
 Navicat Premium Data Transfer

 Source Server         : 10.211.55.6
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : xx.211.55.6:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 01/05/2019 10:15:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `id` bigint(80) DEFAULT NULL COMMENT '任务ID',
  `bean_name` varchar(80) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(80) DEFAULT NULL COMMENT '方法名',
  `params` varchar(0) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(200) DEFAULT NULL COMMENT 'cron表达式',
  `status` int(5) DEFAULT NULL COMMENT '任务状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
