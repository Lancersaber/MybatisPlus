package com.example.demo;

import com.example.demo.bean.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    EmployeeMapper mapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//k-v都是字符串 ，操作字符串的

    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象的

    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;

    @Test
    public void contextLoads() {
        Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);
        logger.info("info");
    }

    /**
     * String(字符串)、List(列表)、Set(集合)、Hash(散列),ZSet(有序集合)
     * stringRedisTemplate.opsForValue();[生成一个用于操作String的对象]
     * stringRedisTemplate.opsForList();[生成一个用于操作List的对象]
     * stringRedisTemplate.opsForHash();[生成一个用于操作Hash的对象]
     * stringRedisTemplate.opsForSet();[生成一个用于操作Set的对象]
     * stringRedisTemplate.opsForZSet();[生成一个用于操作ZSet的对象]
     */
    @Test
    public void test01(){
        stringRedisTemplate.opsForValue();
        stringRedisTemplate.opsForList();
        stringRedisTemplate.opsForHash();
        stringRedisTemplate.opsForSet();
        stringRedisTemplate.opsForZSet();
    }


    @Test
    public void test02(){
        Employee employeeId = mapper.getEmployeeId(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//        redisTemplate.opsForValue().set("emp-01",employeeId);
        //1、将数据以json的方式保存
        //1）、自己将对象转为json
        //2）、redisTemplate默认的序列化规则
        empRedisTemplate.opsForValue().set("emp_01",employeeId);
    }

}
