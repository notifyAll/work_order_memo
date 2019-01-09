package com.qiugaoy.work_order_memo.dao;

import com.qiugaoy.work_order_memo.entity.FirstClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 一级分类
 */
public interface FirstClassDao extends JpaRepository<FirstClass,Integer> {
}
