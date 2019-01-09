package com.qiugaoy.work_order_memo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
   二级分类
 */
@Entity
@DynamicInsert  /* 动态插入  insert into product_category (category_name, category_type) values (?, ?)  自动忽略掉两个 时间 null*/
@DynamicUpdate  /* 动态更新注解 数据库中updatetime是自动更新的 如果不用该注解  每次保存都会覆盖  都修改数据没变化时不会update数据*/
@Data
@Table(name = "second_class")
public class SecondClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  /*(strategy = GenerationType.IDENTITY)自增类型*/
    private Integer secondClassId;

    private Integer firstClassId;

    private String secondClassName;

    private Date createTime;
    /**
     * 分类状态 0禁用 1启用
     */
    private Integer  secondClassStart;

    private Date lastUpdateTime;
}
