CREATE TABLE `log_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `level` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '日志警告级别',
  `msg` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '日志详细信息',
  `logtime` datetime DEFAULT NULL COMMENT '日志产生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;