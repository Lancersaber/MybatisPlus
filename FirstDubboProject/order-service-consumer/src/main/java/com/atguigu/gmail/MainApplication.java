package com.atguigu.gmail;

import com.atguigu.gmail.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService bean = classPathXmlApplicationContext.getBean(OrderService.class);
        bean.initOrder("1");

        System.out.println("调用结束");
        System.in.read();
    }
}
