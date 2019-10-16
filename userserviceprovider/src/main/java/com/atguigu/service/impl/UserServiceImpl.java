package com.atguigu.service.impl;

import com.atguigu.gmail.UserAddress;
import com.atguigu.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1=new UserAddress(1,"北京","1","李老师","13083170182","Y");
        UserAddress address2=new UserAddress(2,"北京","2","王老师老师","13083170182","Y");

        return Arrays.asList(address1,address2);
    }
}
