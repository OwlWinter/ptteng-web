/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 127.0.0.1:3306
 Source Schema         : ptteng

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 24/07/2020 09:40:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `imges` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图片地址',
  `updateat` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `createat` timestamp(0) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1, '547567.jpg', '2020-06-09 11:53:13', '2000-01-01 00:00:00');
INSERT INTO `banner` VALUES (2, '453254354.jpg', '2020-06-09 11:53:07', '2000-01-01 00:00:00');
INSERT INTO `banner` VALUES (3, 'banner-3.jpg', '2020-06-09 11:53:43', '2000-01-01 00:00:00');
INSERT INTO `banner` VALUES (4, 'banner-4.jpg', '2020-06-20 18:02:49', '2000-01-01 00:00:00');

-- ----------------------------
-- Table structure for direction
-- ----------------------------
DROP TABLE IF EXISTS `direction`;
CREATE TABLE `direction`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `career_direction` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '职业方向',
  `number_of_student` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '累计学习人数',
  `employed_population` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '就业人数',
  `updateat` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `createat` timestamp(0) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of direction
-- ----------------------------
INSERT INTO `direction` VALUES (1, '前端开发方向', 2222, 1111, '2020-06-09 16:42:15', '2000-01-01 00:00:00');
INSERT INTO `direction` VALUES (2, '后端开发方向', 2222, 1111, '2020-06-09 16:42:17', '2000-01-01 00:00:00');
INSERT INTO `direction` VALUES (3, '移动开发方向', 2222, 1111, '2020-06-09 16:42:19', '2000-01-01 00:00:00');
INSERT INTO `direction` VALUES (4, '整站开发方向', 2222, 1111, '2020-06-09 16:42:21', '2000-01-01 00:00:00');
INSERT INTO `direction` VALUES (5, '运营维护方向', 2222, 1111, '2020-06-09 16:42:23', '2000-01-01 00:00:00');

-- ----------------------------
-- Table structure for login_user
-- ----------------------------
DROP TABLE IF EXISTS `login_user`;
CREATE TABLE `login_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `head` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户头像',
  `passwd` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码加密值',
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `updateat` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `createat` timestamp(0) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE COMMENT '用户名唯一索引',
  UNIQUE INDEX `uk_email`(`email`) USING BTREE COMMENT '邮箱唯一索引',
  UNIQUE INDEX `uk_phone_num`(`phone_number`) USING BTREE COMMENT '手机号码唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login_user
-- ----------------------------
INSERT INTO `login_user` VALUES (23, 'email', 'ZW1haWw.png', '$2a$10$Ou0qDDrz/4mWEwQCYYpNIeBydeeyCKLlGmiVWioCyxIW7KCxPYsti', '11111111@qq.com', '', '2020-07-12 23:38:56', '2020-07-12 15:52:19');
INSERT INTO `login_user` VALUES (24, 'phone', 'cGhvbmU.png', '$2a$10$0J5CpJLfNPkW7vs4Q5IzquGEZNqiTKRTVS9.dT8dSu4RVQPFJ79Lm', '', '111111111', '2020-07-14 09:35:34', '2020-07-13 10:57:45');

-- ----------------------------
-- Table structure for occupation
-- ----------------------------
DROP TABLE IF EXISTS `occupation`;
CREATE TABLE `occupation`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `career_direction` int(11) UNSIGNED NOT NULL COMMENT '职业方向id',
  `major` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学习方向',
  `imges` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图片地址',
  `introduce` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '简介',
  `threshold` int(11) UNSIGNED NOT NULL COMMENT '学习门槛',
  `difficulty` int(11) UNSIGNED NOT NULL COMMENT '学习难度',
  `growth_cycle` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '成长周期',
  `scarcity` int(11) UNSIGNED NOT NULL COMMENT '市场需求量',
  `salary` int(11) UNSIGNED NOT NULL COMMENT '初始薪资',
  `coefficient` float UNSIGNED NOT NULL COMMENT '薪资增长系数',
  `number_of_student` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '在学人数',
  `prompt` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '提示信息',
  `updateat` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `createat` timestamp(0) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of occupation
-- ----------------------------
INSERT INTO `occupation` VALUES (1, 1, '前端工程师1', '687.png', '见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 3, '1-3', 567, 5000, 1.3, 9876, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:24', '2020-06-09 18:25:59');
INSERT INTO `occupation` VALUES (2, 1, '前端工程师2', '687.png', '见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 3, '1-3', 567, 5000, 1.3, 9876, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:27', '2020-06-09 18:26:44');
INSERT INTO `occupation` VALUES (3, 1, '前端工程师3', '687.png', '见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 3, '1-3', 567, 5000, 1.3, 9876, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:30', '2020-06-09 18:26:45');
INSERT INTO `occupation` VALUES (4, 1, '前端工程师4', '687.png', '见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 3, '1-3', 567, 5000, 1.3, 9876, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:33', '2020-06-09 18:26:48');
INSERT INTO `occupation` VALUES (5, 1, '前端工程师5', '687.png', '见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 3, '1-3', 567, 5000, 1.3, 9876, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:37', '2020-06-09 18:26:48');
INSERT INTO `occupation` VALUES (6, 1, '前端工程师6', '687.png', '见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 3, '1-3', 567, 5000, 1.3, 9876, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:40', '2020-06-09 18:26:48');
INSERT INTO `occupation` VALUES (7, 2, '后端工程师1', '687.png', '后端工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 4, 5, '2-5', 5167, 6000, 1.5, 2816, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:42', '2020-06-09 18:28:52');
INSERT INTO `occupation` VALUES (8, 2, '后端工程师2', '687.png', '后端工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 4, 5, '2-5', 5167, 6000, 1.5, 2816, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:45', '2020-06-09 18:28:53');
INSERT INTO `occupation` VALUES (9, 2, '后端工程师3', '687.png', '后端工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 4, 5, '2-5', 5167, 6000, 1.5, 2816, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:47', '2020-06-09 18:28:54');
INSERT INTO `occupation` VALUES (10, 2, '后端工程师4', '687.png', '后端工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 4, 5, '2-5', 5167, 6000, 1.5, 2816, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:50', '2020-06-09 18:28:54');
INSERT INTO `occupation` VALUES (11, 2, '后端工程师5', '687.png', '后端工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 4, 5, '2-5', 5167, 6000, 1.5, 2816, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:53', '2020-06-09 18:28:55');
INSERT INTO `occupation` VALUES (12, 2, '后端工程师6', '687.png', '后端工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 4, 5, '2-5', 5167, 6000, 1.5, 2816, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:56', '2020-06-09 18:28:59');
INSERT INTO `occupation` VALUES (13, 3, '移动开发工程师1', '687.png', '移动开发工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 3, 3, '1-5', 4167, 6300, 1.1, 3216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:50:59', '2020-06-09 18:30:05');
INSERT INTO `occupation` VALUES (14, 3, '移动开发工程师2', '687.png', '移动开发工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 3, 3, '1-5', 4167, 6300, 1.1, 3216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:01', '2020-06-09 18:30:06');
INSERT INTO `occupation` VALUES (15, 3, '移动开发工程师3', '687.png', '移动开发工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 3, 3, '1-5', 4167, 6300, 1.1, 3216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:03', '2020-06-09 18:30:06');
INSERT INTO `occupation` VALUES (16, 3, '移动开发工程师4', '687.png', '移动开发工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 3, 3, '1-5', 4167, 6300, 1.1, 3216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:05', '2020-06-09 18:30:06');
INSERT INTO `occupation` VALUES (17, 3, '移动开发工程师5', '687.png', '移动开发工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 3, 3, '1-5', 4167, 6300, 1.1, 3216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:07', '2020-06-09 18:30:06');
INSERT INTO `occupation` VALUES (18, 3, '移动开发工程师6', '687.png', '移动开发工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 3, 3, '1-5', 4167, 6300, 1.1, 3216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:09', '2020-06-09 18:30:08');
INSERT INTO `occupation` VALUES (19, 3, '移动开发工程师7', '687.png', '移动开发工程师:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 3, 3, '1-5', 4167, 6300, 1.1, 3216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:12', '2020-06-09 18:30:08');
INSERT INTO `occupation` VALUES (20, 4, '整站开发方向1', '687.png', '整站开发方向:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 1, 2, '1-2', 3367, 5600, 1.6, 2216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:14', '2020-06-09 18:30:57');
INSERT INTO `occupation` VALUES (21, 4, '整站开发方向2', '687.png', '整站开发方向:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 1, 2, '1-2', 3367, 5600, 1.6, 2216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:16', '2020-06-09 18:30:58');
INSERT INTO `occupation` VALUES (22, 4, '整站开发方向3', '687.png', '整站开发方向:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 1, 2, '1-2', 3367, 5600, 1.6, 2216, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:18', '2020-06-09 18:30:58');
INSERT INTO `occupation` VALUES (23, 5, '运营维护方向1', '687.png', '运营维护方向:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 4, '2-4', 3332, 6700, 1.21, 2436, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:29', '2020-06-09 18:32:06');
INSERT INTO `occupation` VALUES (24, 5, '运营维护方向2', '687.png', '运营维护方向:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 4, '2-4', 3332, 6700, 1.21, 2436, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:33', '2020-06-09 18:32:06');
INSERT INTO `occupation` VALUES (25, 5, '运营维护方向3', '687.png', '运营维护方向:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 4, '2-4', 3332, 6700, 1.21, 2436, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:35', '2020-06-09 18:32:08');
INSERT INTO `occupation` VALUES (26, 5, '运营维护方向4', '687.png', '运营维护方向:见金陵玉殿莺啼晓，秦淮水bai榭花开早，谁知道容易冰消。眼看他起朱楼，眼看他宴宾客，眼看他楼塌了！这青苔碧瓦堆，俺曾睡风流觉；将五十年兴亡看饱；那乌衣巷不姓王，莫愁湖鬼夜哭，凤凰台栖枭鸟。残山梦最真，旧境丢难掉。不信这舆图换稿。诌一套哀江南，放悲声唱到老。', 2, 4, '2-4', 3332, 6700, 1.21, 2436, '提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础', '2020-06-16 14:51:38', '2020-06-09 18:32:09');

-- ----------------------------
-- Table structure for representative
-- ----------------------------
DROP TABLE IF EXISTS `representative`;
CREATE TABLE `representative`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学员姓名',
  `imges` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像图片地址',
  `major` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学习方向',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学员简介',
  `salary` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '薪资',
  `updateat` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `createat` timestamp(0) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of representative
-- ----------------------------
INSERT INTO `representative` VALUES (1, '罗大佑', 'head_1.png', '技术顾问', '百度技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。 曾任新网高级技术经理，负责技术研发，团队管理与建设。', 10000, '2020-06-09 17:14:16', '2000-01-01 00:00:00');
INSERT INTO `representative` VALUES (2, '李大钊', 'head_2.png', '运维', '国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。', 20000, '2020-06-09 17:33:55', '2000-01-01 00:00:00');
INSERT INTO `representative` VALUES (3, '陈独秀', 'head_3.png', '前端开发', '而喜欢那我i如何拍吹牛吹牛跑去哦成年人', 8000, '2020-06-09 17:14:50', '2000-01-01 00:00:00');
INSERT INTO `representative` VALUES (4, '伍佰', 'head_4.png', '后端开发', '色反馈闹琳娜出资额分分饿哦轮番轰炸WB记录哦hi：DF和', 30000, '2020-06-09 17:16:19', '2000-01-01 00:00:00');
INSERT INTO `representative` VALUES (5, '周杰伦', 'head_5.png', '全干工程师', '岩烧店的烟味弥漫 隔壁是国术馆\r\n\r\n店里面的妈妈桑 茶道 有三段\r\n教拳脚武术的老板 练铁沙掌 耍杨家枪\r\n硬底子功夫最擅长 还会金钟罩铁步衫\r\n他们儿子我习惯 从小就耳濡目染', 30000, '2020-06-09 17:34:05', '2000-01-01 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
