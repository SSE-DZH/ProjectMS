/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : localhost:3306
 Source Schema         : projectmanagementdb

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 06/07/2024 01:04:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '刘大强', '123456', '123@789.com');
INSERT INTO `admin` VALUES (2, '刘大强', '1234567', '1234@123.com');
INSERT INTO `admin` VALUES (3, '刘大强', '1234567', '1236@123.com');
INSERT INTO `admin` VALUES (4, '刘大', '1234567', '1236@1234.com');

-- ----------------------------
-- Table structure for development_status
-- ----------------------------
DROP TABLE IF EXISTS `development_status`;
CREATE TABLE `development_status`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `current_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '当前状态',
  `this_week_progress` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '本周完成情况',
  `next_week_plan` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '下周工作安排',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '研制状态与进展表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of development_status
-- ----------------------------
INSERT INTO `development_status` VALUES (1, 2, '3', '1', '初始化项目');
INSERT INTO `development_status` VALUES (2, 4, '1', '1', '完成初步');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `project_id` bigint NOT NULL COMMENT '项目ID',
  `current_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '项目当前状态',
  `completion_this_week` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '2' COMMENT '本周完成情况',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目状态日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for module_quantities
-- ----------------------------
DROP TABLE IF EXISTS `module_quantities`;
CREATE TABLE `module_quantities`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `hardware_quantity` bigint NULL DEFAULT NULL COMMENT '硬件数量',
  `software_quantity` bigint NULL DEFAULT NULL COMMENT '软件数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '模块化数量表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of module_quantities
-- ----------------------------
INSERT INTO `module_quantities` VALUES (2, 1, 66, 66);
INSERT INTO `module_quantities` VALUES (3, 2, 30, 49);

-- ----------------------------
-- Table structure for project_milestones
-- ----------------------------
DROP TABLE IF EXISTS `project_milestones`;
CREATE TABLE `project_milestones`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `milestone_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目节点名称',
  `planned_date` date NULL DEFAULT NULL COMMENT '计划完成时间',
  `actual_date` date NULL DEFAULT NULL COMMENT '实际完成时间',
  `division` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '事业部',
  `common_group` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公共组',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目节点完成情况表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_milestones
-- ----------------------------
INSERT INTO `project_milestones` VALUES (1, 1, 'Final Review', '2024-07-09', '2024-07-15', 'DivisionX', 'GroupA');

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品名称',
  `product_model` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品型号',
  `major_project` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '大项目',
  `project_leader` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目负责人',
  `physical_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实物图片',
  `product_attribute` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品属性（新品/改良）',
  `start_date` date NULL DEFAULT NULL COMMENT '启动时间',
  `approval_date` date NULL DEFAULT NULL COMMENT '立项时间',
  `project_score` int NULL DEFAULT NULL COMMENT '项目评分',
  `workload` int NULL DEFAULT NULL COMMENT '样机完成（人天）',
  `project_duration` int NULL DEFAULT NULL COMMENT '项目周期（天）',
  `current_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '当前状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO `projects` VALUES (1, '产品1', '新品', '大项目1111', '闻宇', NULL, '改良', '2024-07-01', '2024-07-05', 85, 10, 30, '2');
INSERT INTO `projects` VALUES (2, '产品2', '新品', '大项目2', '闻宇', NULL, '改良', '2024-07-01', '2024-07-05', 85, 10, 30, '2');
INSERT INTO `projects` VALUES (4, '产品5', '新品', '大项目3', '闻宇', NULL, '改良', '2024-07-01', '2024-07-05', 85, 10, 30, '2');
INSERT INTO `projects` VALUES (5, '产品666', '新品', '大项目3', '闻宇', NULL, '改良', '2024-07-01', '2024-07-05', 85, 10, 30, '2');

-- ----------------------------
-- Table structure for registration_progress
-- ----------------------------
DROP TABLE IF EXISTS `registration_progress`;
CREATE TABLE `registration_progress`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `registration_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '注册类型',
  `submission_date` date NULL DEFAULT NULL COMMENT '注册提交日期',
  `declaration_date` date NULL DEFAULT NULL COMMENT '注册申报日期',
  `test_date` date NULL DEFAULT NULL COMMENT '体考日期',
  `certificate_date` date NULL DEFAULT NULL COMMENT '下证日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '注册进度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of registration_progress
-- ----------------------------
INSERT INTO `registration_progress` VALUES (1, 1, 'TypeB', '2024-07-01', '2024-07-05', '2024-07-08', '2024-07-10');

-- ----------------------------
-- Table structure for risk_tracking
-- ----------------------------
DROP TABLE IF EXISTS `risk_tracking`;
CREATE TABLE `risk_tracking`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `risk_attribute` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '风险属性',
  `risk_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '风险问题的描述',
  `solution` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '解决方案',
  `current_progress` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '当前进度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '风险跟踪与解决表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of risk_tracking
-- ----------------------------
INSERT INTO `risk_tracking` VALUES (1, 1, '技术风险', '项目中遇到的技术挑战', '通过新技术方案解决', '2');
INSERT INTO `risk_tracking` VALUES (2, 2, '技术风险', '项目中遇到的技术挑战', '通过新技术方案解决', '3');
INSERT INTO `risk_tracking` VALUES (3, 4, '技术风险', '项目中遇到的技术挑战', '通过新技术方案解决', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '苏文涛', '123456', '124@123.com');
INSERT INTO `user` VALUES (2, '苏文涛', '123456', '12345@12345@qq.com');
INSERT INTO `user` VALUES (3, '苏文', '123456', '123@123.com');

SET FOREIGN_KEY_CHECKS = 1;
