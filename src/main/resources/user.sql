CREATE TABLE user (
                      `id` int(11) PRIMARY KEY NOT NULL COMMENT 'id',
                      `username` varchar (255) DEFAULT NULL COMMENT '用户名',
                      `password` varchar(255) DEFAULT NULL COMMENT '密码',
                      `delete_flag` TINYINT(1) DEFAULT 0 COMMENT '是否删除',
                      `create_date` TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8
