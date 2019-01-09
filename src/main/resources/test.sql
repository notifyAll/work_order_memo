-- 修改 时间字段为 创建时自动填入 和修改时填入  CURRENT_TIMESTAMP 创建时修改    ON UPDATE CURRENT_TIMESTAMP 修改时修改  第一句修改无效
ALTER TABLE first_class ALTER COLUMN last_update_time SET  DEFAULT  CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP; --无效
ALTER TABLE first_class change  last_update_time last_update_time  timestamp  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP; --有效


show create table first_class;  --查看表结构

-- 增加一个字段在    store_address  后面
alter table store add column store_name varchar(100)  comment  '门店 名称' after store_address

-- 修改字段类型
alter table second_class change  second_class_start second_class_start int default 0 comment '二级分类状态 0 禁用 1使用'