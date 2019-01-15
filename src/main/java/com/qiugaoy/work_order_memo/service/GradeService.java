package com.qiugaoy.work_order_memo.service;

import com.qiugaoy.work_order_memo.entity.Grade;
import com.qiugaoy.work_order_memo.from.GradeForm;

import java.util.List;

public interface GradeService {


    /**
     *  获取所有状态等级
     * @return
     */
   List<Grade> findAll();

    /**
     * 新增或修改
     * @param gradeForm 提交的表单
     */
    void save(GradeForm gradeForm);
}
