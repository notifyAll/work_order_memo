package com.qiugaoy.work_order_memo.dao;

import com.qiugaoy.work_order_memo.entity.FirstClass;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;





@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
@Data
public class FirstClassDaoTest {
    @Resource
    FirstClassDao firstClassDao;

    @Test
    public void  savetest(){
        FirstClass firstClass = new FirstClass();

        firstClass.setFirstClassName("分离式电子秤");


        firstClassDao.save(firstClass);

    }


    @Test
    @Transactional
    @Rollback(false)
    public void  updtest(){
        FirstClass firstClass = firstClassDao.findById(3).get();

//        System.out.println(firstClass.getFirstClassName()+" -----------------");
//       Date date= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
//        firstClass.setLastUpdateTime(new Date());
//        firstClass.setFirstClassStart(Character.forDigit(1,10));
//
//        FirstClass save = firstClassDao.save(firstClass);
//
//        System.out.println(save.getFirstClassName()+"-------" );


    }

    @Test
//    @Transactional
    public void  getOntest(){
//        FirstClass firstClass = firstClassDao.getOne(3);
        FirstClass firstClass = firstClassDao.findById(3).get();

        log.info(firstClass.getFirstClassName());

    }
}