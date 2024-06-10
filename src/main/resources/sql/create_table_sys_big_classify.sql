CREATE TABLE `sys_big_classify` (
        `big_classify_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '大分类id',
        `big_classify_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '大分类名称',
        `operator_status` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态：1-草稿2-正常启用3-中止9-删除',
        `create_user_id` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
        `update_user_id` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
        `update_time` datetime DEFAULT NULL COMMENT '修改时间',
        `remark` varchar(1024) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
        PRIMARY KEY (`big_classify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;