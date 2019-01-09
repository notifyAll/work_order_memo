package com.qiugaoy.work_order_memo.service;

import com.qiugaoy.work_order_memo.dto.FirstClassDTO;
import com.qiugaoy.work_order_memo.entity.FirstClass;
import com.qiugaoy.work_order_memo.from.FirstClassForm;

import java.util.List;

public interface FirstClassService {

    /**
     * 获取所有的一级和二级分类
     */
    List<FirstClassDTO> findAllFirstClassDTO();


    /**
     *   添加一个一级分类
     */
    FirstClass save(FirstClassForm firstClassForm);

    /**
     *   查询一个一级分类通过 firstClassId
     */
    FirstClass findByFirstClassId(Integer firstClassId);
    /**
     *   查询一个一级分类通过 secondClassId
     */
    FirstClass findBySecondClassId(Integer secondClassId);


}
