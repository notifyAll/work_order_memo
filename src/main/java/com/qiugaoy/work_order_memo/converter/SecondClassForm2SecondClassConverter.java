package com.qiugaoy.work_order_memo.converter;

import com.qiugaoy.work_order_memo.entity.SecondClass;
import com.qiugaoy.work_order_memo.from.SecondClassForm;
import org.springframework.beans.BeanUtils;

/**
 *  FirstClassForm 转换成  FirstClass
 */
public class SecondClassForm2SecondClassConverter {

    public static SecondClass converter(SecondClassForm source){
        SecondClass target=new SecondClass();

//        拷贝参数
        return converter(source,target);
    }


    /**
     * 拷贝参数
     * @param source  资源
     * @param target  目标
     * @return
     */
    public static SecondClass  converter(SecondClassForm source,SecondClass target){

        if (target.getSecondClassStart()!=null&&source.getSecondClassStart()==null){
            source.setSecondClassStart(target.getSecondClassStart());
        }
        if (target.getFirstClassId()!=null&&source.getFirstClassId()==null){
            source.setFirstClassId(target.getFirstClassId());
        }
//        拷贝参数
        BeanUtils.copyProperties(source,target);

        return target;
    }
}
