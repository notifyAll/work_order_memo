package com.qiugaoy.work_order_memo.enums;


import lombok.Getter;

/**
 * 一级分类相关的
 */
@Getter
public enum FirstClassEnum {
    FIRST_CLASS_ID_NOT_NULL(1001,"主键不能为空"),
    FIRST_CLASS_NOT_EXIST(1002,"一级分类查询为空_异常操作")
    ;
    private Integer code;

    private String message;

    FirstClassEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
