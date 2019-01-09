package com.qiugaoy.work_order_memo.service;

import com.qiugaoy.work_order_memo.entity.SecondClass;
import com.qiugaoy.work_order_memo.from.SecondClassForm;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SecondClassService {

    /**
     * 查询所有二级分类 列表通过
     * @param firstClassId 一级分类id
     * @return
     */
    List<SecondClass> findAllByFirstClassId(Integer firstClassId);

    /**
     * 新增 和修改
     */
    SecondClass save(SecondClassForm secondClassForm);


    /**
     * 查询一个二级分类通过id
     * @param secondClassId
     * @return
     */
    SecondClass findBySecondClassId(Integer secondClassId);
}

