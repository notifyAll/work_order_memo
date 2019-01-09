package com.qiugaoy.work_order_memo.service;

import com.qiugaoy.work_order_memo.entity.Store;
import org.springframework.web.multipart.MultipartFile;

public interface StoreService {

    /**
     *
     * @param file 门店信息
     * @return 添加的行数
     */
    Integer importStoresByXlsx(MultipartFile file);

    /**
     * 通过门店号查询 门店信息
     * @param storeId
     * @return
     */
    Store findByStoreId(String storeId);
}
