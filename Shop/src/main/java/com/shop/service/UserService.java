package com.shop.service;

import com.shop.bean.User;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 18:56
 * @Version 1.0
 * @describe
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public boolean registUser(User user);

    /**
     * 检测用户是否已存在
     * @param username
     * @return 返回true表示用户不存在，返回false表示用户存在
     */
    public boolean existUser(String username);

    /**
     * 登陆
     * @param user
     * @return 如果返回null，表示登陆失败，返回true，表示登陆成功
     */
    public User login(User user);

}
