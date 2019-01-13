package com.qiugaoy.work_order_memo.service.impl;

import com.qiugaoy.work_order_memo.converter.UsersForm2UsersController;
import com.qiugaoy.work_order_memo.dao.UsersDao;
import com.qiugaoy.work_order_memo.entity.Users;
import com.qiugaoy.work_order_memo.enums.ResultEnum;
import com.qiugaoy.work_order_memo.exception.ResultException;
import com.qiugaoy.work_order_memo.from.UsersForm;
import com.qiugaoy.work_order_memo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UsersServiceImpl  implements UsersService {

    @Resource
    private UsersDao usersDao;
    /**
     * 登录
     *
     * @param usersForm 用户登录表单
     * @return 用户数据
     */

    @Override
    public Users login(UsersForm usersForm) {

        Users usersFormConverter = UsersForm2UsersController.converter(usersForm);
        Users users=null;
        //用户不存在
//        try {
            users =  findByUserId(usersFormConverter.getUserId());
//        }catch (ResultException e){
//            log.error(e.getCode()+":用户不存在："+e.getMessage()+"usersForm:{}",usersForm);
//            throw new ResultException(ResultEnum.USERS_ID_NOT_EXIST);
//        }

        //密码错误
        if (!users.getUserPasword().equals(usersFormConverter.getUserPasword())){
            log.error(ResultEnum.USERS_USERPASWORD_ERROR.getCode()+"用户密码错误： usersForm:{}",usersForm);
            throw new ResultException(ResultEnum.USERS_USERPASWORD_ERROR);
        }

//        用户状态异常
        if (users.getUserStart()!=1){
            log.error(ResultEnum.USERS_USERSTART_ERROR.getCode()+"用户状态异常： usersForm:{}",usersForm);
            throw new ResultException(ResultEnum.USERS_USERSTART_ERROR);
        }

        return users;
    }

    /**
     * 查询一个用户
     *
     * @param userId 用户id
     * @return 用户数据
     */
    @Override
    public Users findByUserId(String userId) {
        if (userId==null){
            log.error(ResultEnum.USERS_ID_NOT_EXIST.getCode()+":用户不存在："+userId+"usersForm:{}",userId);
            throw new ResultException(ResultEnum.USERS_ID_NOT_EXIST);
        }
        Users users=null;
        try {
            users =  usersDao.findById(userId).get();
        }catch (Exception e){
            log.error(ResultEnum.USERS_ID_NOT_EXIST.getCode()+":用户不存在："+e.getMessage()+"usersForm:{}",userId);
            throw new ResultException(ResultEnum.USERS_ID_NOT_EXIST);
        }

        return users;
    }


}
