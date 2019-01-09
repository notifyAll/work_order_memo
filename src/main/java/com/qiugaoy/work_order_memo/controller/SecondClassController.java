package com.qiugaoy.work_order_memo.controller;

import com.qiugaoy.work_order_memo.VO.ResultVO;
import com.qiugaoy.work_order_memo.entity.SecondClass;
import com.qiugaoy.work_order_memo.exception.ResultException;
import com.qiugaoy.work_order_memo.from.FirstClassForm;
import com.qiugaoy.work_order_memo.from.SecondClassForm;
import com.qiugaoy.work_order_memo.service.SecondClassService;
import com.qiugaoy.work_order_memo.utils.ResultVOUtil;
import lombok.Data;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 二级分类
 */
@RestController
@RequestMapping("/SC")
@Data
public class SecondClassController {

    @Resource
    private SecondClassService secondClassService;

    /**
     * 创建 or 修改二级分类
     */
    @PostMapping("/ins")
    public ResultVO<SecondClass> insertOne(@Valid SecondClassForm secondClassForm) {
        SecondClass save = null;
        try {
            save = secondClassService.save(secondClassForm);
        } catch (ResultException e) {
            return ResultVOUtil.error(e.getCode(), e.getMessage()); //TODO 报错信息无需回传前端
        }
        return ResultVOUtil.success(save);
    }


    /**
     * 获取某一级分类下的所有二级分类
     */
    @GetMapping("/list/byfcid/{firstClassId}")
    public ResultVO<List<SecondClass>> findByFirstClassId(@PathVariable(value = "firstClassId") Integer firstClassId) {
        List<SecondClass> allByFirstClassId =null;
        try{
            allByFirstClassId = secondClassService.findAllByFirstClassId(firstClassId);
        }catch (ResultException  e) {
            return ResultVOUtil.error(e.getCode(), e.getMessage()); //TODO 报错信息无需回传前端
        }
        return ResultVOUtil.success(allByFirstClassId);
    }


}
