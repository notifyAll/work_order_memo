package com.qiugaoy.work_order_memo.controller;


import com.qiugaoy.work_order_memo.VO.ResultVO;
import com.qiugaoy.work_order_memo.dto.FirstClassDTO;
import com.qiugaoy.work_order_memo.from.FirstClassForm;
import com.qiugaoy.work_order_memo.service.FirstClassService;
import com.qiugaoy.work_order_memo.utils.ResultVOUtil;
import lombok.Data;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/FC")
@Data
public class FirstClassController {


    @Resource
    private FirstClassService firstClassService;

    /**
     * 添加一个一级分类
     * 如果id不为空则为修改
     *
     * @return
     */
    @PostMapping("/ins")
    public ResultVO insertOne(@Valid FirstClassForm firstClassForm) {

        firstClassService.save(firstClassForm);

        return ResultVOUtil.success();
    }

    /**
     * 查询一级分类 通过2级分类id
     *
     * @return
     */
    @GetMapping("/list/byscid/{secondClassId}")
    public ResultVO findBySecondClassId(@PathVariable(value = "secondClassId") Integer secondClassId) {
        return null;
    }

    /**
     * 查询一级分类 通过1级分类id
     *
     * @return
     */
    @GetMapping("/list/byfcid/{firstClassId}")
    public ResultVO findByFirstClassId(@PathVariable(value = "firstClassId") Integer firstClassId) {
        return null;
    }


    /**
     * 查询所有 1级分类 和其二级分类
     */
    @GetMapping("/find/all")
    public ResultVO<List<FirstClassDTO>> findAllFirstClassDTO() {
        List<FirstClassDTO> firstClassDTOList = firstClassService.findAllFirstClassDTO();

        return ResultVOUtil.success(firstClassDTOList);
    }
}
