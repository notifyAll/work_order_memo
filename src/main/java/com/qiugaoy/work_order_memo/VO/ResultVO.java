package com.qiugaoy.work_order_memo.VO;

import lombok.Data;

/**
 *  *返回结果的包装类
 */
@Data
public class ResultVO<T> {

        /** 错误码 */
        private String code;

        /** 提示信息 */
        private  String msg;

        /** 数据 */
        private T data;
    }


