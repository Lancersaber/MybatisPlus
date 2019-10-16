package com;

import redis.clients.jedis.Jedis;

public class Test {

    @org.junit.Test
    public void test01(){
        System.out.println("Hello");
        Jedis jedis=new Jedis("49.234.9.177");
        System.out.println("连接成功");
        System.out.println(jedis.ping());
    }
}
