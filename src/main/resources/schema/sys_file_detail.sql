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

 Date: 07/08/2019 20:01:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_file_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_detail`;
CREATE TABLE `sys_file_detail` (
  `id` bigint(40) NOT NULL COMMENT '附件id',
  `container_id` bigint(20) DEFAULT NULL COMMENT '归属信息id',
  `file_category` varchar(50) DEFAULT NULL COMMENT '附件类别',
  `logical_name` varchar(300) DEFAULT NULL COMMENT '附件名（逻辑名）',
  `description` varchar(2000) DEFAULT NULL COMMENT '附件资料描述',
  `extention_name` varchar(50) DEFAULT NULL COMMENT '附件扩展名',
  `physical_name` varchar(300) DEFAULT NULL COMMENT '附件名（物理名）',
  `file_content` varchar(300) DEFAULT NULL COMMENT '文件内容',
  `doc_server_address` varchar(40) DEFAULT NULL COMMENT '文件主机地址',
  `server_group` varchar(20) DEFAULT NULL COMMENT '附件组',
  `server_root_dir` varchar(500) DEFAULT NULL COMMENT '文件绝对路径',
  `creator` varchar(40) DEFAULT NULL COMMENT '创建者',
  `creator_ip` varchar(40) DEFAULT NULL COMMENT '创建者ip',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` varchar(2) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统附件表';

SET FOREIGN_KEY_CHECKS = 1;
