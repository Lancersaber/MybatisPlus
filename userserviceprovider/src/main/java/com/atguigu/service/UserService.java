package com.atguigu.service;

import com.atguigu.gmail.UserAddress;

import java.util.List;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 按照用户id返回所有收获地址
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);
}
