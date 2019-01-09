package com.qiugaoy.work_order_memo.exception;

import com.qiugaoy.work_order_memo.enums.ResultEnum;
import lombok.Getter;


@Getter
public class ResultException extends RuntimeException {
    private String code;

    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        code=resultEnum.getCode();
    }
}
