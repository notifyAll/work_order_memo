package com.qiugaoy.work_order_memo.service.impl;

import com.qiugaoy.work_order_memo.converter.FirstClass2FirstClassDTOConverter;
import com.qiugaoy.work_order_memo.converter.FirstClassForm2FirstClassConverter;
import com.qiugaoy.work_order_memo.dao.FirstClassDao;
import com.qiugaoy.work_order_memo.dto.FirstClassDTO;
import com.qiugaoy.work_order_memo.entity.FirstClass;
import com.qiugaoy.work_order_memo.enums.FirstClassEnum;
import com.qiugaoy.work_order_memo.enums.ResultEnum;
import com.qiugaoy.work_order_memo.exception.ResultException;
import com.qiugaoy.work_order_memo.from.FirstClassForm;
import com.qiugaoy.work_order_memo.service.FirstClassService;
import com.qiugaoy.work_order_memo.service.SecondClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FirstClassServiceImpl implements FirstClassService {

    @Resource
    private FirstClassDao firstClassDao;

    @Resource
    private SecondClassService secondClassService;

    /**
     * 获取所有的一级和二级分类
     */
    @Override
    public List<FirstClassDTO> findAllFirstClassDTO() {
        List<FirstClass> firstClassList = firstClassDao.findAll();
        List<FirstClassDTO> firstClassDTOList = new ArrayList<>();
        for (int i = 0; i < firstClassList.size(); i++) {
            FirstClassDTO firstClassDTO = FirstClass2FirstClassDTOConverter.converter(firstClassList.get(i));
            firstClassDTOList.add(firstClassDTO);
            /**
             * 添加其目录下的二级分类
             */
            firstClassDTO.setSecondClassList(secondClassService.findAllByFirstClassId(firstClassDTO.getFirstClassId()));
        }
        return firstClassDTOList;
    }

    /**
     * 添加一个一级分类  附带修改功能
     *
     * @param firstClassForm
     */
    @Override
    @Transactional
    public FirstClass save(FirstClassForm firstClassForm) {
        FirstClass firstClass = null;
        if (firstClassForm.getFirstClassId() == null) { //新增
            firstClass = FirstClassForm2FirstClassConverter.converter(firstClassForm);
        } else {  //修改
            firstClass = findByFirstClassId(firstClassForm.getFirstClassId());
            if (firstClass == null) {
//                查询为空
                log.error(FirstClassEnum.FIRST_CLASS_NOT_EXIST.getMessage() + firstClassForm.toString());
                throw new ResultException(ResultEnum.FIRST_CLASS_NOT_EXIST);
            }
            //拷贝数据  类型转换
            firstClass = FirstClassForm2FirstClassConverter.converter(firstClassForm, firstClass);

            //修改时状态不存在  防止出现null 设个0
            if (firstClass.getFirstClassStart() == null || firstClass.getFirstClassStart() > 1 || firstClass.getFirstClassStart() < 0) {
                firstClass.setFirstClassStart(0);
            }
        }
        FirstClass save = firstClassDao.save(firstClass);

        return save;
    }

    /**
     * 查询一个一级分类通过 firstClassId
     *
     * @param firstClassId
     */
    @Override
    public FirstClass findByFirstClassId(Integer firstClassId) {
        if (firstClassId == null) {
            log.error(FirstClassEnum.FIRST_CLASS_ID_NOT_NULL.getCode()+" -- firstClassId:{}",firstClassId);
            throw new ResultException(ResultEnum.FIRST_CLASS_ID_NOT_NULL);
        }
        //查询
        FirstClass firstClass = firstClassDao.findById(firstClassId).get();
        if (firstClass==null){
            log.error(FirstClassEnum.FIRST_CLASS_NOT_EXIST.getMessage());
            throw new ResultException(ResultEnum.FIRST_CLASS_NOT_EXIST);
        }
        return firstClass;
    }

    /**
     * 查询一个一级分类通过 secondClassId
     *
     * @param secondClassId
     */
    @Override
    public FirstClass findBySecondClassId(Integer secondClassId) {
        return null;
    }
}
