package com.qiugaoy.work_order_memo.enums;

import lombok.Getter;

/**
 * 返回用户端的 信息
 */
@Getter
public enum  ResultEnum {
    FIRST_CLASS_ID_NOT_NULL("FC001","主键不能为空"),
    FIRST_CLASS_NOT_EXIST("FC002","一级分类查询为空_异常操作"),
    FIRST_CLASS_SAVE_FAIL("FC003","一级分类保存失败"),
    SECOND_CLASS_ID_NOT_NULL("SC001","主键不能为空"),
    SECOND_CLASS_NOT_EXIST("SC002","二级分类查询为空_异常操作"),
    SECOND_CLASS_SAVE_FAIL("SC003","二级分类保存失败"),
    STORE_ID_NOT_NULL("Store001","门店主键不能为空"),
    STORE_FILE_NOT_XLSX("Store002","全门店信息非xlsx格式"),
    STORE_FILE_READ_FAIL("Store003","全门店信息表读取失败"),
    STORE_NOT_EXIST("Store004","门店不存在"),
    USERS_ID_NOT_EXIST("U001","用户信息不存在"),
    USERS_USERPASWORD_ERROR("U002","密码错误"),
    USERS_USERSTART_ERROR("U003","用户状态异常"),
    SUCCSEE("R001","查询成功"),
    FAIL("R002","查询失败"),
    ;
    String code;
    String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
