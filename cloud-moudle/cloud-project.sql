-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.60-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  10.2.0.5672
-- --------------------------------------------------------

-- 导出 test1 的数据库结构
CREATE DATABASE IF NOT EXISTS ;
USE `test1`;

-- 导出  表 test1.user_table 结构
CREATE TABLE IF NOT EXISTS `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `user_name` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '用户名',
  `pass_word` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '密码',
  `phone` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '电话',
  `real_name` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `identity_card` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '身份证号码',
  `address` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '地址',
  `age` int(3) NOT NULL DEFAULT '18' COMMENT '年纪',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别1男2女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COMMENT='用户表';

-- 正在导出表  test1.user_table 的数据：~2 rows (大约)

INSERT INTO `user_table` (`id`, `user_name`, `pass_word`, `phone`, `real_name`, `identity_card`, `address`, `age`, `sex`) VALUES
	(1, '刘星', '123456', '13566666666', '刘星', '411111111111111111111', '湖北', 18, 1),
	(2, '李明', '456123', '13588888888', 'lm', '456144216542316541156', '广东', 18, 1);






-- 导出 test2 的数据库结构
CREATE DATABASE IF NOT EXISTS `test2`;
USE `test2`;


-- 导出  表 test2.user_product 结构
CREATE TABLE IF NOT EXISTS `user_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `product_name` varchar(150) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '商品名称',
  `product_num` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `product_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '商品价格',
  `product_color` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '0' COMMENT '商品颜色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COMMENT='用户商品表';

-- 正在导出表  test2.user_product 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_product` DISABLE KEYS */;
INSERT INTO `user_product` (`id`, `user_id`, `product_name`, `product_num`, `product_price`, `product_color`) VALUES
	(1, 1, 'iPhone 11 Pro Max  256G', 100, 15000, '银色'),
	(2, 1, 'iPhone 11 Pro Max  256G', 50, 15300, '金色'),
	(3, 1, 'iPhone 11 Pro Max  256G', 30, 15300, '黑色'),
	(4, 1, 'iPhone 11 Pro Max  256G', 10, 15300, '绿色'),
	(5, 2, 'iPhone 11 Pro Max  256G', 10, 15300, '绿色'),
	(6, 2, 'iPhone 11 Pro Max  256G', 30, 15300, '黑色'),
	(7, 2, 'iPhone 11 Pro Max  256G', 50, 15300, '金色'),
	(8, 2, 'iPhone 11 Pro Max  256G', 100, 15000, '银色'),
	(9, 1, '华为 meta 30 Pro 5G', 7, 6500, '黑色');

