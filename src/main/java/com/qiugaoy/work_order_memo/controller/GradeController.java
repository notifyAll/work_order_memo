package com.qiugaoy.work_order_memo.controller;

import com.qiugaoy.work_order_memo.VO.ResultVO;
import com.qiugaoy.work_order_memo.entity.Grade;
import com.qiugaoy.work_order_memo.service.GradeService;
import com.qiugaoy.work_order_memo.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//等级
@RestController
@Slf4j
@RequestMapping(value = "/grade")
public class GradeController {

    @Resource
    private GradeService gradeService;


    /**
     * 获取所有等级列表
     */
    @GetMapping("/list")
    public ResultVO<List<Grade>> findAll() {

        List<Grade> all = gradeService.findAll();

        return ResultVOUtil.success(all);
    }


    /**
     * 添加修改等级
     */


    /**
     * 通过id 获取等级
     */

}
