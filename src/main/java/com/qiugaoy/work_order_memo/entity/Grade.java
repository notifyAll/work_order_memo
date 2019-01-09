package com.qiugaoy.work_order_memo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *  工单级别
 */
@Entity
@Data
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  /*(strategy = GenerationType.IDENTITY)自增类型*/
    private Integer gradeId; //等级 id

    private String gradeName;  //等级名

    private Integer gradeTimeOut;  //超时时间 单位天
}
