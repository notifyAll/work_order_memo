package com.qiugaoy.work_order_memo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 *  工单类型
 */
@Entity
@DynamicInsert  /*动态插入  insert into product_category (category_name, category_type) values (?, ?)  自动忽略掉两个 时间 null*/
@DynamicUpdate  /* 动态更新注解 数据库中updatetime是自动更新的 如果不用该注解  每次保存都会覆盖  都修改数据没变化时不会update数据*/
@Data
@Table(name = "order_detail")
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  /*(strategy = GenerationType.IDENTITY)自增类型*/
    private int workOrderId;
    /**
     * 门店id
     */
    private String storeId;

    /**
     * 创建用户
     */
    private Integer userId;
    /**
     * 等级 id
     */
    private Integer gradeId;
    /**
     * 描述
     */
    private  String workOrderDesc;
    /**
     * 工单联系方式
     */
    private  String workOrderPhone;
    private Date createTime;
    private Date lastUpdateTime;
}
