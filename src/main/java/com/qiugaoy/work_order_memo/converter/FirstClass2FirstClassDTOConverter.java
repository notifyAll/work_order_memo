package com.qiugaoy.work_order_memo.converter;

import com.qiugaoy.work_order_memo.dto.FirstClassDTO;
import com.qiugaoy.work_order_memo.entity.FirstClass;
import com.qiugaoy.work_order_memo.from.FirstClassForm;
import org.springframework.beans.BeanUtils;

/**
 *  FirstClass 转换成  FirstClassDTO
 */
public class FirstClass2FirstClassDTOConverter {

    //
    public static FirstClassDTO converter(FirstClass source){
        FirstClassDTO target=new FirstClassDTO();
//        拷贝参数
        return converter(source,target);
    }


    /**
     * 拷贝参数
     * @param source  资源
     * @param target  目标
     * @return
     */
    public static FirstClassDTO  converter(FirstClass source,FirstClassDTO target){
//        拷贝参数
        BeanUtils.copyProperties(source,target);

        return target;
    }
}
