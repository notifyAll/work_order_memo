package com.qiugaoy.work_order_memo.from;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * 二级分类表单
 */
@Data
public class SecondClassForm {

    private Integer secondClassId;

    @NotEmpty(message = "firstClassId不能为空")
    private Integer firstClassId;
    /**
     * 二分类名 不能为空
     */
    @NotBlank(message = "二级分类名不允许为空")
    @Size(min = 1,max = 20,message = "字符长度在1-20之间")
    private String secondClassName;

    /**
     * 分类状态 0禁用 1启用
     */

    private Integer  secondClassStart;

}
