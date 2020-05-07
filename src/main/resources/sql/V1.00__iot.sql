CREATE TABLE `log_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `level` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '日志警告级别',
  `msg` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '日志详细信息',
  `logtime` datetime DEFAULT NULL COMMENT '日志产生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


CREATE TABLE `iot_device` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `device_code` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备编号',
                              `device_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备名称',
                              `device_pwd` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备密码',
                              `protocol` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备协议',
                              `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备安装地址',
                              `status` int(255) DEFAULT NULL COMMENT '数据状态 1-正常 2-禁用',
                              `create_time` datetime DEFAULT  CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              `update_time` datetime DEFAULT  CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `type` int(255) NOT NULL COMMENT '用户类型',
                        `username` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
                        `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
                        `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
                        `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


CREATE TABLE `device_info` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `device_code` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '设备编号',
                               `address` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '设备对应地址',
                               `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               `device_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '设备名称',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;