package com.qiugaoy.work_order_memo.converter;

import com.qiugaoy.work_order_memo.entity.Store;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 门店信息表的数据 转换成 List<Store>
 */
public class StoreXLSXFile2StoreListConverter {

    /**
     * @param source 全门店信息文件
     * @return 门店集合
     */
    public static List<Store> converter(MultipartFile source) throws IOException, InvalidFormatException {
        //2获取输入流
        InputStream inputStream = null;
        Workbook workbook = null;
//        try {
        inputStream = source.getInputStream();
        workbook = WorkbookFactory.create(inputStream);

        //获取表格
        Sheet sheetAt = workbook.getSheetAt(0);

//拷贝数据  将表格中的数据 转换成 List<Store>

        int lastRowNum = sheetAt.getLastRowNum();
        List<Store> storeList = new ArrayList<>();
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheetAt.getRow(i);
            Store store = new Store();
            copyRow(row, store);
            // 拷贝数据
            storeList.add(store);
        }
        workbook.close();
        inputStream.close();
        return storeList;

//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                workbook.close();
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
    }


    /**
     * 将表格中的一行转换成 Store
     *
     * @param source 表格中的一行
     * @param target 门店信息
     */
    private static void copyRow(Row source, Store target) {
        int size = source.getLastCellNum() + 1;
        // 数据转换
        target.setStoreId(source.getCell(0) != null ? source.getCell(0).toString() : "");
        target.setStoreName(source.getCell(1) != null ? source.getCell(1).toString() : "");
        target.setStoreAddress(source.getCell(2) != null ? source.getCell(2).toString() : "");
        target.setStorePhone(source.getCell(3) != null ? source.getCell(3).toString() : "");
//        target.setStoreRegion(source.getCell(4) != null ? Integer.parseInt(source.getCell(4).toString()) : 0); //门店是否为负责区域
        Cell cell = source.getCell(4);
        target.setStoreRegion((cell == null || cell.getNumericCellValue() != 1) ? 0 : 1); //门店是否为负责区域
//        if (cell == null || cell.getNumericCellValue() != 1) {
//            target.setStoreRegion(0); //非负责区域
//        } else {
//            target.setStoreRegion(1); //非负责区域
//        }
        target.setStoreIp(source.getCell(5) != null ? source.getCell(5).toString() : "");


    }
}
