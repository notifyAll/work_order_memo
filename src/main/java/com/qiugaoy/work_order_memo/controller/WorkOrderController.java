package com.qiugaoy.work_order_memo.controller;

import com.qiugaoy.work_order_memo.VO.ResultVO;
import lombok.Data;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 工单控制层
 */
@RestController
@RequestMapping(value = "/WO")
@Data
public class WorkOrderController {

    /**
     * 通条件查询工单
     * 带分页
     */

    @GetMapping("/find")
    public ResultVO findAllWorkOrderByFrom(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        QPageRequest pageable = new QPageRequest(page, size);  //分页信息
        return  null;
    }
    /**
     * 新增工单
     */
    @PostMapping("/ins")
    public ResultVO insertOne(){

        return null;
    }
    /**
     * 确认完成工单
     */
    @PostMapping("/upd/{workOrderId}")
    public ResultVO UpdateByWorkOrderId(
            @PathVariable(value = "workOrderId") Integer workOrderId
    ){

        return null;
    }
    /**
     *  查询 当日超期工单  快超期的工单
     */
    @GetMapping("/timeout")
    public ResultVO findAllByGradeTimeOut(

    ){

        return null;
    }


}


