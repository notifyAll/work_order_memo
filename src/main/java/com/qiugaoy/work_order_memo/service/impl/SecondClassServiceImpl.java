package com.qiugaoy.work_order_memo.service.impl;

import com.qiugaoy.work_order_memo.converter.SecondClassForm2SecondClassConverter;
import com.qiugaoy.work_order_memo.dao.SecondClassDao;
import com.qiugaoy.work_order_memo.entity.FirstClass;
import com.qiugaoy.work_order_memo.entity.SecondClass;
import com.qiugaoy.work_order_memo.enums.ParamEnum;
import com.qiugaoy.work_order_memo.enums.ResultEnum;
import com.qiugaoy.work_order_memo.exception.ResultException;
import com.qiugaoy.work_order_memo.from.SecondClassForm;
import com.qiugaoy.work_order_memo.service.FirstClassService;
import com.qiugaoy.work_order_memo.service.SecondClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 二级分类
 */
@Service
@Slf4j
public class SecondClassServiceImpl implements SecondClassService {

    @Resource
    private SecondClassDao secondClassDao;

    @Resource
    private FirstClassService firstClassService;

    /**
     * 查询所有二级分类 列表通过
     *
     * @param firstClassId 一级分类id
     * @return
     */
    @Override
    public List<SecondClass> findAllByFirstClassId(Integer firstClassId) {
        if (firstClassId == null) {
            log.error(ParamEnum.FIRST_CLASS_ID_NOT_NULL.getCode() + " -- firstClassId:{}", firstClassId);
            throw new ResultException(ResultEnum.FIRST_CLASS_ID_NOT_NULL);
        }

        List<SecondClass> secondClassList = secondClassDao.findByFirstClassId(firstClassId);
        //查询结果允许为空
        return secondClassList;
    }

    /**
     * 新增 和修改
     *
     * @param secondClassForm
     */
    @Override
    public SecondClass save(SecondClassForm secondClassForm) {

//       1验证一级分类是否存在 查询一级分类
        FirstClass firstClass = firstClassService.findByFirstClassId(secondClassForm.getFirstClassId());
//      2转换数据  为保存还是修改
        SecondClass secondClass = null;
        if (secondClassForm.getSecondClassId() == null) {
            //新增
            secondClass = SecondClassForm2SecondClassConverter.converter(secondClassForm);
        } else {
//            修改
            SecondClass target = findBySecondClassId(secondClassForm.getSecondClassId());
            secondClass = SecondClassForm2SecondClassConverter.converter(secondClassForm, target);
        }
//      3 save
        SecondClass save = secondClassDao.save(secondClass);
        if (save == null) {
            //保存失败
            log.error(ResultEnum.SECOND_CLASS_SAVE_FAIL.getCode() + ": :secondClass:{}; secondClassForm:{}", secondClass, secondClassForm);
            throw new ResultException(ResultEnum.SECOND_CLASS_SAVE_FAIL);
        }
        return save;
    }

    /**
     * 查询一个二级分类通过id
     *
     * @param secondClassId
     * @return
     */
    @Override
    public SecondClass findBySecondClassId(Integer secondClassId) {
        if (secondClassId == null) {
            log.error(ResultEnum.SECOND_CLASS_ID_NOT_NULL.getCode() + "{}", secondClassId);
            throw new ResultException(ResultEnum.SECOND_CLASS_ID_NOT_NULL);
        }
        SecondClass secondClass = null;
        try {
            secondClass = secondClassDao.findById(secondClassId).get();
        }catch (Exception e){
            log.error(ResultEnum.SECOND_CLASS_NOT_EXIST.getCode() + "--secondClassId:{} , e:{}", secondClassId,e.getMessage());
            throw new ResultException(ResultEnum.SECOND_CLASS_NOT_EXIST);
        }
//         secondClass = secondClassDao.findById(secondClassId).get();
//        if (secondClass == null) {
//            log.error(ResultEnum.SECOND_CLASS_NOT_EXIST.getCode() + "{}", secondClassId);
//            throw new ResultException(ResultEnum.SECOND_CLASS_NOT_EXIST);
//        }
        return secondClass;
    }
}
