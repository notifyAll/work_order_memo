package com.qiugaoy.work_order_memo.from;

import lombok.Data;


/**
 *  用户
 */

@Data
public class UsersForm {
    /**
     * 帐号
     */
    private String userId;

    /**
     * 密码
     */
    private String userPasword;

}
