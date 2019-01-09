package com.qiugaoy.work_order_memo.controller;

import com.qiugaoy.work_order_memo.VO.ResultVO;
import com.qiugaoy.work_order_memo.entity.Store;
import com.qiugaoy.work_order_memo.exception.ResultException;
import com.qiugaoy.work_order_memo.service.StoreService;
import com.qiugaoy.work_order_memo.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**
 * 门店信息
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    @Resource
    private StoreService storeService;

    /**
     * EXCLE   导入门店数据数据
     * xlsx格式
     * 获取文件
     */

    @PostMapping("/import/xlsx")
    public ResultVO<Integer> importStoresByXlsx(@RequestParam(value = "file") MultipartFile file) {
        Integer row = null;
        try {
            row = storeService.importStoresByXlsx(file);
        } catch (ResultException e) {
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }
        return ResultVOUtil.success(row);
    }

    /**
     * 通过门店号 获取 单个门店信息
     * storeId 门店id
     */
    @GetMapping("/id/{storeId}")
    public ResultVO<Store> getStoreByStoreId(
            @PathVariable(value = "storeId") String storeId
    ) {
        Store store = null;
        try {
            store = storeService.findByStoreId(storeId);
        } catch (ResultException e) {
            return ResultVOUtil.error(e.getCode(), e.getMessage());
        }

        return ResultVOUtil.success(store);
    }


}
