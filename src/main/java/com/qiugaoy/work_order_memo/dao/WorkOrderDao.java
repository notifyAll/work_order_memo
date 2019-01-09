package com.qiugaoy.work_order_memo.dao;

import com.qiugaoy.work_order_memo.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 工单表
 */
public  interface WorkOrderDao extends JpaRepository<WorkOrder,Integer> {

    /**
     *  通过门店id 查询工单
     */

    /**
     * 通过时间查询工单
     */
    /**
     *
     */
}
