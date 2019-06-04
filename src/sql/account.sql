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

 Date: 04/06/2019 22:39:13
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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户操作日志表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '发送信息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `account_sys_permission`;
CREATE TABLE `account_sys_permission`  (
  `id` int(1) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `type` int(1) NOT NULL COMMENT '类型 1菜单 2功能',
  `parent_id` int(1) NOT NULL COMMENT '父级编号',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单地址',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单图标标识',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '授权标识，多个以,分隔',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '权限状态 1正常 2禁用',
  `memo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `sort` int(1) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否删除 1未删除 2已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_sys_permission
-- ----------------------------
INSERT INTO `account_sys_permission` VALUES (1, '系统管理', 1, 0, 'sys/setting', 'admin', '', 1, '系统设置', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (2, '用户管理', 1, 1, 'sys/user', 'admin', '', 1, '用户设置', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (3, '用户添加', 2, 2, '', 'admin', 'sys:user:save', 1, '用户添加', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (4, '用户修改', 2, 2, '', 'admin', 'sys:user:update', 1, '用户修改', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (5, '用户删除', 2, 2, '', 'admin', 'sys:user:delete', 1, '用户删除', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (6, '用户列表', 2, 2, '', 'admin', 'sys:user:list', 1, '用户列表', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (7, '用户授权', 2, 2, '', 'admin', 'sys:user:grant', 1, '用户授权', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (8, '角色管理', 1, 1, 'sys/role', 'admin', '', 1, '角色设置', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (9, '角色添加', 2, 8, '', 'admin', 'sys:role:save', 1, '角色添加', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (10, '角色修改', 2, 8, '', 'admin', 'sys:role:update', 1, '角色修改', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (11, '角色删除', 2, 8, '', 'admin', 'sys:role:delete', 1, '角色删除', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (12, '角色列表', 2, 8, '', 'admin', 'sys:role:list', 1, '角色列表', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (13, '权限管理', 1, 1, 'sys/menu', 'admin', '', 1, '权限设置', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (14, '权限添加', 2, 13, '', 'admin', 'sys:menu:save', 1, '权限添加', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (15, '权限修改', 2, 13, '', 'admin', 'sys:menu:update', 1, '权限修改', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (16, '权限删除', 2, 13, '', 'admin', 'sys:menu:delete', 1, '权限删除', 0, '2019-05-23 16:11:49', 1);
INSERT INTO `account_sys_permission` VALUES (17, '权限列表', 2, 13, '', 'admin', 'sys:menu:list', 1, '权限列表', 0, '2019-05-23 16:11:49', 1);

-- ----------------------------
-- Table structure for account_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `account_sys_role`;
CREATE TABLE `account_sys_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_sys_role
-- ----------------------------
INSERT INTO `account_sys_role` VALUES (1, 'ADMIN', '管理员', '2017-05-01 13:25:39', '2017-10-05 21:59:18', 1);
INSERT INTO `account_sys_role` VALUES (2, 'USER', '', '2017-08-01 21:47:31', '2017-10-05 21:59:26', 1);

-- ----------------------------
-- Table structure for account_sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `account_sys_role_permission`;
CREATE TABLE `account_sys_role_permission`  (
  `role_id` int(11) UNSIGNED NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_sys_role_permission
-- ----------------------------
INSERT INTO `account_sys_role_permission` VALUES (1, 1);
INSERT INTO `account_sys_role_permission` VALUES (1, 2);
INSERT INTO `account_sys_role_permission` VALUES (1, 3);
INSERT INTO `account_sys_role_permission` VALUES (1, 4);
INSERT INTO `account_sys_role_permission` VALUES (1, 6);
INSERT INTO `account_sys_role_permission` VALUES (1, 7);
INSERT INTO `account_sys_role_permission` VALUES (1, 8);
INSERT INTO `account_sys_role_permission` VALUES (1, 9);
INSERT INTO `account_sys_role_permission` VALUES (1, 10);
INSERT INTO `account_sys_role_permission` VALUES (1, 11);
INSERT INTO `account_sys_role_permission` VALUES (1, 12);
INSERT INTO `account_sys_role_permission` VALUES (1, 13);
INSERT INTO `account_sys_role_permission` VALUES (1, 14);
INSERT INTO `account_sys_role_permission` VALUES (1, 15);
INSERT INTO `account_sys_role_permission` VALUES (1, 16);
INSERT INTO `account_sys_role_permission` VALUES (1, 17);
INSERT INTO `account_sys_role_permission` VALUES (1, 18);
INSERT INTO `account_sys_role_permission` VALUES (1, 19);
INSERT INTO `account_sys_role_permission` VALUES (1, 20);
INSERT INTO `account_sys_role_permission` VALUES (1, 21);
INSERT INTO `account_sys_role_permission` VALUES (1, 22);
INSERT INTO `account_sys_role_permission` VALUES (1, 23);
INSERT INTO `account_sys_role_permission` VALUES (1, 24);
INSERT INTO `account_sys_role_permission` VALUES (1, 25);
INSERT INTO `account_sys_role_permission` VALUES (1, 26);
INSERT INTO `account_sys_role_permission` VALUES (1, 27);
INSERT INTO `account_sys_role_permission` VALUES (1, 28);
INSERT INTO `account_sys_role_permission` VALUES (1, 29);
INSERT INTO `account_sys_role_permission` VALUES (1, 30);
INSERT INTO `account_sys_role_permission` VALUES (1, 31);
INSERT INTO `account_sys_role_permission` VALUES (1, 32);
INSERT INTO `account_sys_role_permission` VALUES (1, 33);
INSERT INTO `account_sys_role_permission` VALUES (1, 34);
INSERT INTO `account_sys_role_permission` VALUES (1, 35);
INSERT INTO `account_sys_role_permission` VALUES (1, 36);
INSERT INTO `account_sys_role_permission` VALUES (1, 37);
INSERT INTO `account_sys_role_permission` VALUES (1, 38);
INSERT INTO `account_sys_role_permission` VALUES (1, 39);
INSERT INTO `account_sys_role_permission` VALUES (1, 40);
INSERT INTO `account_sys_role_permission` VALUES (2, 1);
INSERT INTO `account_sys_role_permission` VALUES (2, 2);
INSERT INTO `account_sys_role_permission` VALUES (2, 3);
INSERT INTO `account_sys_role_permission` VALUES (2, 4);
INSERT INTO `account_sys_role_permission` VALUES (2, 6);
INSERT INTO `account_sys_role_permission` VALUES (2, 7);
INSERT INTO `account_sys_role_permission` VALUES (2, 8);
INSERT INTO `account_sys_role_permission` VALUES (2, 9);
INSERT INTO `account_sys_role_permission` VALUES (2, 10);
INSERT INTO `account_sys_role_permission` VALUES (2, 11);
INSERT INTO `account_sys_role_permission` VALUES (2, 12);
INSERT INTO `account_sys_role_permission` VALUES (2, 13);
INSERT INTO `account_sys_role_permission` VALUES (2, 14);
INSERT INTO `account_sys_role_permission` VALUES (2, 15);
INSERT INTO `account_sys_role_permission` VALUES (2, 16);
INSERT INTO `account_sys_role_permission` VALUES (2, 17);
INSERT INTO `account_sys_role_permission` VALUES (2, 18);
INSERT INTO `account_sys_role_permission` VALUES (2, 19);
INSERT INTO `account_sys_role_permission` VALUES (2, 20);
INSERT INTO `account_sys_role_permission` VALUES (2, 21);
INSERT INTO `account_sys_role_permission` VALUES (2, 22);
INSERT INTO `account_sys_role_permission` VALUES (2, 23);
INSERT INTO `account_sys_role_permission` VALUES (2, 24);
INSERT INTO `account_sys_role_permission` VALUES (2, 25);
INSERT INTO `account_sys_role_permission` VALUES (2, 30);
INSERT INTO `account_sys_role_permission` VALUES (2, 31);
INSERT INTO `account_sys_role_permission` VALUES (2, 34);
INSERT INTO `account_sys_role_permission` VALUES (2, 36);

-- ----------------------------
-- Table structure for account_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `account_sys_role_user`;
CREATE TABLE `account_sys_role_user`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_sys_role_user
-- ----------------------------
INSERT INTO `account_sys_role_user` VALUES (1, 1);
INSERT INTO `account_sys_role_user` VALUES (2, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_user_account
-- ----------------------------
INSERT INTO `account_user_account` VALUES (40, 40, '12342221225', 1, '5923c74b98d7421d7a056ee6583194a7', 'sk55', '12', '', '2019-05-29 23:37:35', '2019-05-29 23:37:35', '2019-05-29 23:37:35', 1);
INSERT INTO `account_user_account` VALUES (41, 1, 'admin', 1, '626ab0aba5993b5f4f85d2b2069d9acf', 'Si1V', '123456', '', '2019-05-29 23:45:05', '2019-05-29 23:45:05', '2019-05-29 23:45:05', 1);
INSERT INTO `account_user_account` VALUES (42, 42, '18573519914', 1, '53164bd7cb224620f6101068ba32d821', '91Y6', '123456', '', '2019-05-30 19:42:20', '2019-05-30 19:42:20', '2019-05-30 19:42:20', 1);
INSERT INTO `account_user_account` VALUES (43, 43, 'abel1', 1, 'd9b8e1ca0bae3602f012bf1103ccc652', '444b', '123456', '', '2019-06-03 20:24:32', '2019-06-03 20:24:32', '2019-06-03 20:24:32', 1);
INSERT INTO `account_user_account` VALUES (44, 44, 'dddddmmm', 1, '9788213d11df1fa067e4ed547ce984f2', '84fb', '1234563', '', '2019-06-03 20:24:44', '2019-06-03 20:24:44', '2019-06-03 20:24:44', 1);
INSERT INTO `account_user_account` VALUES (45, 45, 'qqwe', 1, '71e9b23e8152975df0d65288598419d9', '7390', '6985', '', '2019-06-03 20:24:57', '2019-06-03 20:24:57', '2019-06-03 20:24:57', 1);
INSERT INTO `account_user_account` VALUES (46, 46, 'asd123', 1, 'd419f0557db96a8d2c37cf479ab56791', 'i193', '123', '', '2019-06-03 20:25:08', '2019-06-03 20:25:08', '2019-06-03 20:25:08', 1);
INSERT INTO `account_user_account` VALUES (47, 47, '2223333', 1, 'c110049f01f6648645a23d54a55719bb', '5WeO', '112321', '', '2019-06-03 20:25:16', '2019-06-03 20:25:16', '2019-06-03 20:25:16', 1);
INSERT INTO `account_user_account` VALUES (48, 48, 'dpqw42', 1, 'e01ca2dcaa3a6746709fb898c57962e4', '7t82', '123', '', '2019-06-03 20:25:24', '2019-06-03 20:25:24', '2019-06-03 20:25:24', 1);
INSERT INTO `account_user_account` VALUES (49, 49, 'p213p', 1, 'f7349f89bd997422e510d1e38b462969', 'qc6X', '123213', '', '2019-06-03 20:25:37', '2019-06-03 20:25:37', '2019-06-03 20:25:37', 1);
INSERT INTO `account_user_account` VALUES (50, 50, 'sadasdas123', 1, '7f75f0827cfa9e550897141a4ed68b4f', 'NV72', '12321', '', '2019-06-03 20:25:49', '2019-06-03 20:25:49', '2019-06-03 20:25:49', 1);
INSERT INTO `account_user_account` VALUES (51, 51, 'qq123', 1, '1bf7e6c7e4f0b3deac0c4f59df163692', '8Sm2', 'sad', '', '2019-06-03 20:25:55', '2019-06-03 20:25:55', '2019-06-03 20:25:55', 1);
INSERT INTO `account_user_account` VALUES (52, 52, 'dddaaa', 1, '972c666113ed6038ed296c6c9eb828a5', '84MM', '1123', '', '2019-06-03 20:26:00', '2019-06-03 20:26:00', '2019-06-03 20:26:00', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户基础表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_user_base
-- ----------------------------
INSERT INTO `account_user_base` VALUES (1, 'rY1eOeX', '超级管理员', '', '', 1, '', '2019-05-29 23:37:35', '2019-05-29 23:37:35', 1);
INSERT INTO `account_user_base` VALUES (41, '64G8D66', '小兰', '', '', 1, '', '2019-05-29 23:45:05', '2019-05-29 23:45:05', 1);
INSERT INTO `account_user_base` VALUES (42, 'CVW5UT3', '小溪', '', '', 1, '', '2019-05-30 19:42:20', '2019-05-30 19:42:20', 1);
INSERT INTO `account_user_base` VALUES (43, '09g95BK', '三儿', '', '', 1, '', '2019-06-03 20:24:32', '2019-06-03 20:24:32', 1);
INSERT INTO `account_user_base` VALUES (44, 'n592qAM', '二五', '', '', 1, '', '2019-06-03 20:24:44', '2019-06-03 20:24:44', 1);
INSERT INTO `account_user_base` VALUES (45, '9aon4XZ', '一期', '', '', 1, '', '2019-06-03 20:24:57', '2019-06-03 20:24:57', 1);
INSERT INTO `account_user_base` VALUES (46, 'tkU81nl', '过儿', '', '', 1, '', '2019-06-03 20:25:08', '2019-06-03 20:25:08', 1);
INSERT INTO `account_user_base` VALUES (47, 'Bm24MS2', '狒狒', '', '', 1, '', '2019-06-03 20:25:16', '2019-06-03 20:25:16', 1);
INSERT INTO `account_user_base` VALUES (48, '1qO2aFR', '兔子', '', '', 1, '', '2019-06-03 20:25:24', '2019-06-03 20:25:24', 1);
INSERT INTO `account_user_base` VALUES (49, 'y4zA0FC', '冯总', '', '', 1, '', '2019-06-03 20:25:37', '2019-06-03 20:25:37', 1);
INSERT INTO `account_user_base` VALUES (50, 'd25h478', '巴铁', '', '', 1, '', '2019-06-03 20:25:49', '2019-06-03 20:25:49', 1);
INSERT INTO `account_user_base` VALUES (51, 'S8T4069', '伺服', '', '', 1, '', '2019-06-03 20:25:55', '2019-06-03 20:25:55', 1);
INSERT INTO `account_user_base` VALUES (52, 'ym1993A', '壳子', '', '', 1, '', '2019-06-03 20:26:00', '2019-06-03 20:26:00', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户安全表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
