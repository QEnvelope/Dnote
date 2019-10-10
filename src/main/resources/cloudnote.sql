CREATE TABLE note (
`id` int(11) PRIMARY KEY NOT NULL COMMENT 'id' auto_increment,
`title` varchar (100) NOT NULL COMMENT '笔记标题',
`author_id` int(11) NOT NULL COMMENT '作者id',
`create_time` TIMESTAMP COMMENT '创建时间',
`update_time` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
`content` text DEFAULT NULL COMMENT '笔记内容'
) ENGINE=InnoDB DEFAULT CHARSET=utf8  AUTO_INCREMENT=11
