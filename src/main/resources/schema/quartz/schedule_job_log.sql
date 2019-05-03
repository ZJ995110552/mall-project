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

 Date: 03/05/2019 07:30:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` decimal(30,0) DEFAULT NULL COMMENT '日志id',
  `job_id` decimal(30,0) DEFAULT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(200) DEFAULT NULL COMMENT '方法名',
  `params` varchar(200) DEFAULT NULL COMMENT '参数',
  `status` int(10) DEFAULT NULL COMMENT '任务状态:0成功 1失败',
  `error` varchar(500) DEFAULT NULL COMMENT '失败信息',
  `times` bigint(10) DEFAULT NULL COMMENT '耗时(单位:毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
