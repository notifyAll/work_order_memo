package com.qiugaoy.work_order_memo.from;


import lombok.Data;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FirstClassForm {

    /**
     *  主键可为空 为空则新增 不为空则为修改
     */
//    @Min(value = 0,message = "")
    private Integer firstClassId;

    /**
     * 一级分类名 不能为空
     */
    @NotBlank(message = "一级分类名不允许为空")
    @Size(min = 1,max = 20,message = "字符长度在1-20之间")
    private String firstClassName;

    /**
     * 分类状态 0禁用 1启用
     */
//    @Min(value = 0,message = "0")
    private Integer  firstClassStart;
}
