package com.shop.dao;

import com.shop.bean.User;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 18:00
 * @Version 1.0
 * @describe
 */
public interface UserDao {
    /**
     * 根据 用户名查询用户信息
     * @param username
     * @return 如果返回null 说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据 用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回 null,说明用户名或密码错误,反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 添加用户信息
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int insertUser(User user);
}
