package com.qiugaoy.work_order_memo.dao;

import com.qiugaoy.work_order_memo.entity.SecondClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 二级分类
 */
public interface SecondClassDao  extends JpaRepository<SecondClass,Integer> {

    /**
     * 通过一个一级分类id查询 所有二级分类
     */
    public List<SecondClass>  findByFirstClassId(Integer firstClassId);

}
