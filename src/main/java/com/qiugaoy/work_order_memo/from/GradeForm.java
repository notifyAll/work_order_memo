package com.qiugaoy.work_order_memo.from;

import lombok.Data;

/**
 * 工单级别 提交表单
 */
@Data
public class GradeForm {


    private Integer gradeId; //等级 id

    private String gradeName;  //等级名

    private Integer gradeTimeOut;  //超时时间 单位天
}
