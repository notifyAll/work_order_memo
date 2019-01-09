package com.qiugaoy.work_order_memo.service.impl;

import com.qiugaoy.work_order_memo.converter.StoreXLSXFile2StoreListConverter;
import com.qiugaoy.work_order_memo.dao.StoreDao;
import com.qiugaoy.work_order_memo.entity.Store;
import com.qiugaoy.work_order_memo.enums.ResultEnum;
import com.qiugaoy.work_order_memo.exception.ResultException;
import com.qiugaoy.work_order_memo.service.StoreService;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreDao storeDao;

    /**
     * 必须为xlsx格式
     *
     * @param file 门店信息
     * @return 添加的行数
     */

    @Override
    @Transactional
    public Integer importStoresByXlsx(MultipartFile file) {
//        String name = file.getName();  //file  获取参数名吧
        //1 获取文件名称
        String originalFilename = file.getOriginalFilename();  // 文件的真实名 服务台Maximo工单分类每日检核表.xlsx
//        System.out.println("name"+name);
//        System.out.println("originalFilename"+originalFilename);
        // 必须为xlsx格式
        if (!originalFilename.matches(".*\\.xlsx$")) {
            log.error(ResultEnum.STORE_FILE_NOT_XLSX.getCode() + " -- originalFilename:" + originalFilename);
            throw new ResultException(ResultEnum.STORE_FILE_NOT_XLSX);
        }

//        2数据转换
        List<Store> storeList = null;
        try {
            storeList = StoreXLSXFile2StoreListConverter.converter(file);
        } catch (Exception e) {
            log.error(ResultEnum.STORE_FILE_READ_FAIL.getCode() + " -- {} --" + e.getMessage(), originalFilename);
            throw new ResultException(ResultEnum.STORE_FILE_READ_FAIL);
        }
        //读取为空
        if (storeList == null || storeList.size() <= 0) {
            log.error(ResultEnum.STORE_FILE_READ_FAIL.getCode() + " -- originalFilename: {} ", originalFilename);
            throw new ResultException(ResultEnum.STORE_FILE_READ_FAIL);
        }
//     XX  删除原库 再保存  无需删除原库 直接保存 jpa会检测数据是否修改再保存
        List<Store> saveAll = storeDao.saveAll(storeList);

        return saveAll.size();
    }

    /**
     * 通过门店号查询 门店信息
     *
     * @param storeId
     * @return
     */
    @Override
    public Store findByStoreId(String storeId) {

        if ( storeId==null||storeId.trim().equals("")){
            log.error(ResultEnum.STORE_ID_NOT_NULL.getCode() + " -- storeId : {} --" , storeId);
            throw new ResultException(ResultEnum.STORE_ID_NOT_NULL);
        }
        Store store =null;

        try {
             store = storeDao.findById(storeId).get();
        }catch (Exception e){
            log.error(ResultEnum.STORE_NOT_EXIST.getCode() + " -- storeId : {}  e:{} --" , storeId,e.getMessage());
            throw new ResultException(ResultEnum.STORE_NOT_EXIST);
        }
//        Store store = storeDao.findById(storeId).get();
//        if (store==null){
//            log.error(ResultEnum.STORE_NOT_EXIST.getCode() + " -- storeId : {} --" , storeId);
//            throw new ResultException(ResultEnum.STORE_NOT_EXIST);
//        }
        return store;
    }
}
