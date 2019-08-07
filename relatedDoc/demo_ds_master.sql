/*
Navicat MySQL Data Transfer

Source Server         : 10.255.254.40
Source Server Version : 50713
Source Host           : 10.255.254.40:3306
Source Database       : demo_ds_master

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-05-16 14:41:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `ip` int(10) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20000246023 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `ip` int(10) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
DROP TRIGGER IF EXISTS `t_afterinsert_on_master_t_order`;
DELIMITER ;;
CREATE TRIGGER `t_afterinsert_on_master_t_order` AFTER INSERT ON `t_order` FOR EACH ROW BEGIN 
insert into demo_ds_slave_0.t_order(order_id,status,user_id,ip) values(new.order_id,new.status,new.user_id,new.ip); 
insert into demo_ds_slave_1.t_order(order_id,status,user_id,ip) values(new.order_id,new.status,new.user_id,new.ip); 
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_afterinsert_on_master_t_order_delete`;
DELIMITER ;;
CREATE TRIGGER `t_afterinsert_on_master_t_order_delete` BEFORE DELETE ON `t_order` FOR EACH ROW BEGIN  
delete from demo_ds_slave_0.t_order where order_id=old.order_id;  
delete from demo_ds_slave_1.t_order where order_id=old.order_id;  
END
;;
DELIMITER ;
