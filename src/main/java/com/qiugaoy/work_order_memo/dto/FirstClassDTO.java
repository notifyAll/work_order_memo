package com.qiugaoy.work_order_memo.dto;


import com.qiugaoy.work_order_memo.entity.SecondClass;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FirstClassDTO {
     private Integer firstClassId;


    private String firstClassName;

    /**
     * 分类状态 0禁用 1启用
     */
    private Integer  firstClassStart;

    private Date createTime;

    private Date lastUpdateTime;

    /**
     * 其下的所有二级分类
     */
    private List<SecondClass> secondClassList;

}
