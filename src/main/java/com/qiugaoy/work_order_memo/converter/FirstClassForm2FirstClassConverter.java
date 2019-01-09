package com.qiugaoy.work_order_memo.converter;

import com.qiugaoy.work_order_memo.entity.FirstClass;
import com.qiugaoy.work_order_memo.from.FirstClassForm;
import org.springframework.beans.BeanUtils;

/**
 *  FirstClassForm 转换成  FirstClass
 */
public class FirstClassForm2FirstClassConverter {

    public static FirstClass  converter(FirstClassForm source){
        FirstClass target=new FirstClass();

//        拷贝参数
        return converter(source,target);
    }


    /**
     * 拷贝参数
     * @param source  资源
     * @param target  目标
     * @return
     */
    public static FirstClass  converter(FirstClassForm source,FirstClass target){
        if (target.getFirstClassStart()!=null&&source.getFirstClassStart()==null){
            source.setFirstClassStart(target.getFirstClassStart());
        }
//        拷贝参数
        BeanUtils.copyProperties(source,target);

        return target;
    }
}
