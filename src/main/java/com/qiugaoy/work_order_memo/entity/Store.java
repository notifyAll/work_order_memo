package com.qiugaoy.work_order_memo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  门店信息
 *
 *  通过excle 全局 导入 直接全覆盖
 */
@Entity
@Data
@Table(name = "store")
public class Store {

    /**
     * 门店 id
     */
    @Id
    private String storeId;
    /**
     * 门店 名称
     */
    private  String storeName;

    /**
     * 门店 地址
     */
    private  String storeAddress;

    /**
     * 门店 电话
     */
    private  String storePhone;

    /**
     * 门店 是否为负责 区域  0为非负责区域  1 是负责区域
     */
    private  Integer storeRegion;

    /**
     * 门店 ip
     */
    private  String storeIp;
}
