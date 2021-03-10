package com.shop.service.impl;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.service.UserService;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 19:14
 * @Version 1.0
 * @describe
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    //用户注册
    @Override
    public boolean registUser(User user) {
        int insertResult = userDao.insertUser(user);
        if (insertResult>0){ //用户添加成功，返回true
            return true;
        }else {//用户添加失败，返回false
            return false;
        }
    }

    //检查用户是否存在
    @Override
    public boolean existUser(String username) {
        User user = userDao.queryUserByUsername(username);
        if (user==null){ //查询结果为null表示没有此用户
            return false;
        }else {
            return true;
        }
    }

    //登陆
    @Override
    public User login(User user) {
        User user1 = userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        return user1;
    }
}
