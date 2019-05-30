/*
 Navicat Premium Data Transfer

 Source Server         : lian1
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : account_system

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 30/05/2019 20:33:38
 Auth:王功明
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_log_login
-- ----------------------------
DROP TABLE IF EXISTS `account_log_login`;
CREATE TABLE `account_log_login`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '关联用户ID',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `login_time` datetime(0) NOT NULL COMMENT '登录时间',
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录IP',
  `login_type` tinyint(1) UNSIGNED NOT NULL COMMENT '登录类型(1.帐号登录，2.手机登录)',
  `is_success` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '登录状态(1.成功,2.失败)',
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT 1 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `usr_id_index`(`user_id`) USING BTREE,
  INDEX `account_index`(`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_log_operate
-- ----------------------------
DROP TABLE IF EXISTS `account_log_operate`;
CREATE TABLE `account_log_operate`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `usr_id` bigint(20) NOT NULL,
  `type` tinyint(1) UNSIGNED NOT NULL COMMENT '操作类型(1.绑定,2.解绑,3.改密,4.审核)',
  `module` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作模块',
  `old_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作前内容',
  `new_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作后内容',
  `create_time` datetime(0) NOT NULL COMMENT '操作时间(创建时间)',
  `is_success` tinyint(1) UNSIGNED NOT NULL COMMENT '操作状态(1.成功2.失败)',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `usr_id_index`(`usr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_send_msg
-- ----------------------------
DROP TABLE IF EXISTS `account_send_msg`;
CREATE TABLE `account_send_msg`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送对象(手机号码或邮箱)',
  `type` tinyint(1) UNSIGNED NOT NULL COMMENT '对象类型',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送信息',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '验证码',
  `expires_time` datetime(0) NOT NULL COMMENT '过期时间',
  `is_success` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '发送状态(1.成功2.失败)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间(创建时间)',
  `is_delete` tinyint(1) NOT NULL DEFAULT 1 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `item_index`(`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '发送信息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `account_sys_permission`;
CREATE TABLE `account_sys_permission`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(11) UNSIGNED NOT NULL COMMENT '上级id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `type` tinyint(1) UNSIGNED NOT NULL COMMENT '类型',
  `permission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限',
  `sort` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序序号',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `account_sys_role`;
CREATE TABLE `account_sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `account_sys_role_permission`;
CREATE TABLE `account_sys_role_permission`  (
  `role_id` int(11) UNSIGNED NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `account_sys_role_user`;
CREATE TABLE `account_sys_role_user`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_user_account
-- ----------------------------
DROP TABLE IF EXISTS `account_user_account`;
CREATE TABLE `account_user_account`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '关联用户ID',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `type` tinyint(255) UNSIGNED NOT NULL DEFAULT 1 COMMENT '帐号类型 1.普通账号，2.手机帐号，3.邮箱帐号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '盐值',
  `open_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '明文密码',
  `last_login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '最后一次登录IP',
  `last_login_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次登录时间',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '绑定时间（创建时间）',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '删除状态 1.正常，2.删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `usr_id_index`(`user_id`) USING BTREE,
  INDEX `account_password_index`(`account`, `password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_user_base
-- ----------------------------
DROP TABLE IF EXISTS `account_user_base`;
CREATE TABLE `account_user_base`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `type` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '用户类型(1.超级管理员,2.普通用户)',
  `header_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '账户头像',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT 1 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username_index`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户基础表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_user_security
-- ----------------------------
DROP TABLE IF EXISTS `account_user_security`;
CREATE TABLE `account_user_security`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `usr_id` bigint(20) UNSIGNED NOT NULL COMMENT '关联用户ID',
  `question_first` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第一个问题',
  `answer_first` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第一个答案',
  `question_second` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第二个问题',
  `answer_second` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第二个答案',
  `question_third` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第三个问题',
  `answer_third` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第三个答案',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `usr_id_index`(`usr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户安全表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
