package com.qiugaoy.work_order_memo.dao;

import com.qiugaoy.work_order_memo.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 门店信息
 */
public interface StoreDao extends JpaRepository<Store,String> {


}
