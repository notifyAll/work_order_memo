package com.qiugaoy.work_order_memo.controller;


import com.qiugaoy.work_order_memo.VO.ResultVO;
import com.qiugaoy.work_order_memo.entity.Users;
import com.qiugaoy.work_order_memo.enums.ParamValue;
import com.qiugaoy.work_order_memo.exception.ResultException;
import com.qiugaoy.work_order_memo.from.UsersForm;
import com.qiugaoy.work_order_memo.service.UsersService;
import com.qiugaoy.work_order_memo.utils.ResultVOUtil;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * 简单的登录验证
 * <p>
 * 登录一次后 用户账号密码直接保存在前端cookie中 未加密
 * <p>
 * 后端存于session中 若session 有用户数据则认为 已登录
 * <p>
 * 登录后 返回用户 session id
 * <p>
 * TODO
 * 1  用户的token 校验
 * 2  密码加密
 * 3  集成shiro
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UsersService usersService;

    /**
     * 登录
     */
    @GetMapping("/login")
    public ResultVO login(HttpServletRequest request, HttpServletResponse response, HttpSession session, @Valid UsersForm usersForm) {
        String requestedSessionId = request.getRequestedSessionId();
//        System.out.println(requestedSessionId);
//        HttpSession session = request.getSession();
//        Object attribute1 = session.getAttribute(requestedSessionId);
        Users login = null;
        try {
            login = usersService.login(usersForm);
        } catch (ResultException e) {
            return  ResultVOUtil.error(e.getCode(),e.getMessage());
        }

//        Cookie[] cookies = request.getCookies();
        Cookie userId=new Cookie("userId",login.getUserId());
        Cookie userPasword=new Cookie("userPasword",login.getUserPasword());
        userId.setMaxAge(604800000); //七天
        userPasword.setMaxAge(604800000);  //七天

//        response.set
        response.addCookie(userId);
        response.addCookie(userPasword);

        //放到session中
        session.setAttribute(ParamValue.userSessionKey, login);

//        session.setAttribute(requestedSessionId, "老王");

        return ResultVOUtil.success();
    }

    /**
     * 修改密码
     */

    /**
     * 注册添加用户
     */


    /**
     * 测试接口
     *
     * @param request
     * @param id
     * @return
     */
    @GetMapping("/login/test")
    public ResultVO login(HttpServletRequest request, @RequestParam(value = "id") String id) {
        String requestedSessionId = request.getRequestedSessionId();

        System.out.println(requestedSessionId);

        HttpSession session = request.getSession();

        String s = "abc";
        Object attribute = session.getAttribute(s);
        Object attribute1 = session.getAttribute(id);
//        System.out.println(users.getUserId() +users.getUserPasword());
        return null;
    }
}
