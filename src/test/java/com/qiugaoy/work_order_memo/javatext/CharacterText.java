package com.qiugaoy.work_order_memo.javatext;


import org.junit.Test;

public class CharacterText  {
    @Test
    public void  text (){
        System.out.println("Character.forDigit(1,2)"+Character.forDigit(1,2));
        System.out.println("Character.forDigit(1,10)"+Character.forDigit(1,10));
        System.out.println("Character.forDigit(0,10)"+Character.forDigit(0,10));
        System.out.println("Character.forDigit(3,2)"+Character.forDigit(3,2));  //越界就为空 了
        System.out.println("Character.forDigit(3,10)"+Character.forDigit(3,10));
        System.out.println("Character.forDigit(-3,10)"+Character.forDigit(-3,10));
        System.out.println("Character.forDigit(-10,10)"+Character.forDigit(-10,10));
        System.out.println("Character.forDigit(-10,-10)"+Character.forDigit(-10,-10));
        System.out.println("Character.forDigit(-12,10)"+Character.forDigit(-12,10));
        System.out.println("Character.forDigit(10,10)"+Character.forDigit(10,10)); //为空 ？？
        System.out.println("Character.forDigit(11,16)"+Character.forDigit(11,16)); //结果为 b   感觉radix 代表进制 但又像范围

        System.out.println("-----------------------------");

        char a= (char) -1;
        System.out.println(a); //感觉char不能为负数
    }
}
