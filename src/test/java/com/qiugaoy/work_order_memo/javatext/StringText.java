package com.qiugaoy.work_order_memo.javatext;

import org.junit.Test;


public class StringText {
    @Test
    public void StringMatchesText(){

        String s="服务台Maximo工单分类每日检核表.xlsx";

        boolean matches = s.matches(".*\\.xlsx$");
//        "0.0"
        System.out.println(1.0==1);
//        System.out.println(Integer.parseInt("0.0")); 小数不能直接转 int
        System.out.println(matches);
    }


}
