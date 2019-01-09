package com.qiugaoy.work_order_memo.utils;


import com.qiugaoy.work_order_memo.VO.ResultVO;
import com.qiugaoy.work_order_memo.enums.ResultEnum;

/**
 * 返回结果封装工具
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCSEE.getCode());
        resultVO.setMsg(ResultEnum.SUCCSEE.getMessage());
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    /**
     * 失败
     * @return
     */
    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }
    public static ResultVO error(String code, String message){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return resultVO;
    }
}
