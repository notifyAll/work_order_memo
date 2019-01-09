package com.qiugaoy.work_order_memo.dao;

import com.qiugaoy.work_order_memo.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 紧急级别
 */
public interface GradeDao extends JpaRepository<Grade,Integer> {
}
