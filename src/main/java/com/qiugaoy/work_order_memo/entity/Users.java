package com.qiugaoy.work_order_memo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  用户
 */
@Entity
@Data
@Table(name = "order_detail")
public class Users {

    /**
     * 帐号
     */
    @Id
    private String userId;

    /**
     * 密码
     */
    private String userPasword;

    /**
     * 用户状态
     */
    private Integer userStart;
}
