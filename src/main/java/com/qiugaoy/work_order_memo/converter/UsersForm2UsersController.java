package com.qiugaoy.work_order_memo.converter;


import com.qiugaoy.work_order_memo.entity.Users;
import com.qiugaoy.work_order_memo.from.UsersForm;
import org.springframework.beans.BeanUtils;

/**
 *  用户表单转用户信息
 */
public class UsersForm2UsersController {
    //
    public static Users converter(UsersForm source){
        Users target=new Users();
//        拷贝参数
        return converter(source,target);
    }


    /**
     * 拷贝参数
     * @param source  资源
     * @param target  目标
     * @return
     */
    public static Users  converter(UsersForm source,Users target){
//        拷贝参数
//        BeanUtils.copyProperties(source,target);

        target.setUserId(source.getUserId());
        target.setUserPasword(source.getUserPasword());

        return target;
    }
}
