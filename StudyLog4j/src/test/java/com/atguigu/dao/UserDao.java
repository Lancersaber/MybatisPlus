package com.atguigu.dao;

import org.apache.log4j.Logger;
import org.junit.Test;


public class UserDao {

    private static final Logger logger=Logger.getLogger(UserDao.class);//log4j

//    private Logger logger=LoggerFactory.getLogger(this.getClass()); //slf4j

    @Test
    public void test01(){
        logger.debug("hello 0316--------debug");
        logger.info("hello 0316--------info");
        logger.warn("hello 0316--------warn");
        logger.error("hello 0316--------error");
    }

    @Test
    public void test02(){
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
    }
}
