package com.qiugaoy.work_order_memo.dao;


import com.qiugaoy.work_order_memo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户
 */
public interface UsersDao  extends JpaRepository<Users,String> {
}
