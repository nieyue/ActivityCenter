# 数据库 
#创建数据库
DROP DATABASE IF EXISTS activity_center_db;
CREATE DATABASE activity_center_db;

#使用数据库 
use activity_center_db;

#创建活动类型表 
CREATE TABLE activity_cate_tb(
activity_cate_id int(11) NOT NULL AUTO_INCREMENT COMMENT '活动类型id',
name varchar(255) COMMENT '活动类型名称',
update_date datetime COMMENT '更新时间',
PRIMARY KEY (activity_cate_id)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='活动类型表';

#创建活动表 
CREATE TABLE activity_tb(
activity_id int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
title varchar(255) COMMENT '活动名称',
summary longtext COMMENT '简介',
target varchar(255) COMMENT '活动对象',
img_address varchar(255) COMMENT '封面',
content longtext COMMENT '活动内容',
pvs bigint(20) DEFAULT 0 COMMENT 'pv',
uvs bigint(20) DEFAULT 0 COMMENT 'uv',
ips bigint(20) DEFAULT 0 COMMENT 'ip',
reading_number bigint(20) DEFAULT 0 COMMENT '阅读数',
status tinyint(4) DEFAULT 1 COMMENT '下架0,上架1',
activity_cate_id int(11) COMMENT '活动类型id,外键',
start_date datetime  COMMENT '活动开始时间',
end_date datetime  COMMENT '活动结束时间',
create_date datetime  COMMENT '创建时间',
update_date datetime  COMMENT '更新时间',
PRIMARY KEY (activity_id),
INDEX INDEX_READINGNUMBER (reading_number) USING BTREE,
INDEX INDEX_ACTIVITYCATEID (activity_cate_id) USING BTREE,
INDEX INDEX_STARTDATE (start_date) USING BTREE,
INDEX INDEX_ENDDATE (end_date) USING BTREE,
INDEX INDEX_CREATEDATE (create_date) USING BTREE,
INDEX INDEX_UPDATEDATE (update_date) USING BTREE,
INDEX INDEX_STATUS (status) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='活动表';

#创建活动用户表 
CREATE TABLE activity_user_tb(
activity_user_id int(11) NOT NULL AUTO_INCREMENT COMMENT '活动用户id',
name varchar(255) COMMENT '姓名',
phone varchar(255) COMMENT '手机号',
address varchar(255) COMMENT '地址',
create_date datetime  COMMENT '创建时间',
update_date datetime  COMMENT '更新时间',
acount_id int(11) COMMENT '填写账户Id',
activity_id int(11) COMMENT '活动Id',
PRIMARY KEY (activity_user_id),
INDEX INDEX_ACOUNTID (acount_id) USING BTREE,
INDEX INDEX_ACTIVITYID (activity_id) USING BTREE,
INDEX INDEX_CREATEDATE (create_date) USING BTREE,
INDEX INDEX_UPDATEDATE (update_date) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='活动用户表';

#创建每日数据表 
CREATE TABLE daily_data_tb(
daily_data_id int(11) NOT NULL AUTO_INCREMENT COMMENT '数据id',
pvs bigint(20) COMMENT 'pvs',
uvs bigint(20) COMMENT 'uvs',
ips bigint(20) COMMENT 'ips',
reading_number bigint(20) COMMENT '阅读数',
create_date datetime COMMENT '创建时间',
activity_id int(11) COMMENT '活动id外键',
acount_id int(11) COMMENT '账户id外键',
PRIMARY KEY (daily_data_id),
INDEX INDEX_CREATEDATE (create_date) USING BTREE,
INDEX INDEX_ACTIVITYID (activity_id) USING BTREE,
INDEX INDEX_ACOUNTID (acount_id) USING BTREE,
UNIQUE INDEX DAY_DATA (create_date,activity_id,acount_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='每日数据表';

#创建数据表 
CREATE TABLE data_tb(
data_id int(11) NOT NULL AUTO_INCREMENT COMMENT '数据id',
pvs bigint(20) COMMENT 'pvs',
uvs bigint(20) COMMENT 'uvs',
ips bigint(20) COMMENT 'ips',
reading_number bigint(20) COMMENT '阅读数',
create_date datetime COMMENT '创建时间',
activity_id int(11) COMMENT '活动id外键',
acount_id int(11) COMMENT '账户id外键',
PRIMARY KEY (data_id),
INDEX INDEX_CREATEDATE (create_date) USING BTREE,
INDEX INDEX_ACTIVITYID (activity_id) USING BTREE,
INDEX INDEX_ACOUNTID (acount_id) USING BTREE,
UNIQUE INDEX TIME_DATA (create_date,activity_id,acount_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='数据表';