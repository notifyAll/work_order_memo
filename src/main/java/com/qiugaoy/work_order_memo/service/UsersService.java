package com.qiugaoy.work_order_memo.service;

import com.qiugaoy.work_order_memo.entity.Users;
import com.qiugaoy.work_order_memo.from.UsersForm;

public interface UsersService {

    /**
     * 登录
     * @param usersForm  用户登录表单
     * @return 用户数据
     */
    Users login(UsersForm usersForm);


    /**
     * 查询一个用户
     * @param userId  用户id
     * @return 用户数据
     */

    Users findByUserId(String userId);
}
