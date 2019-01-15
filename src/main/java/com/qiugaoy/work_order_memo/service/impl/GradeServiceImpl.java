package com.qiugaoy.work_order_memo.service.impl;

import com.qiugaoy.work_order_memo.VO.ResultVO;
import com.qiugaoy.work_order_memo.dao.GradeDao;
import com.qiugaoy.work_order_memo.entity.Grade;
import com.qiugaoy.work_order_memo.from.GradeForm;
import com.qiugaoy.work_order_memo.service.GradeService;
import com.qiugaoy.work_order_memo.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
public class GradeServiceImpl implements GradeService {

    @Resource
    private GradeService gradeService;


    /**
     * 获取所有状态等级
     *
     * @return
     */
    @Override
    public List<Grade> findAll() {
        List<Grade> all = gradeService.findAll();
        return all;
    }

    /**
     * 新增或修改
     *
     * @param gradeForm 提交的表单
     */
    @Override
    public void save(GradeForm gradeForm) {

    }

    /**
     * 添加处理等级
     * 如果id不为空则为修改
     *
     * @return
     */
    @PostMapping("/ins")
    public ResultVO insertOne(@Valid GradeForm gradeForm) {

        gradeService.save(gradeForm);

        return ResultVOUtil.success();
    }

}
