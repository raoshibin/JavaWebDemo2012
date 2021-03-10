package com.shop.test;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 18:13
 * @Version 1.0
 * @describe
 */
public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();

    //测试 根据 用户名查询用户信息
    @Test
    public void queryUserByUsername(){
        System.out.println(userDao.queryUserByUsername("liming"));
    }

    //测试 根据 用户名和密码查询用户信息
    @Test
    public void queryUserByUsernameAndPassword(){
        System.out.println(userDao.queryUserByUsernameAndPassword("admin","123456"));
    }

    //测试添加用户
    @Test
    public void insertUserTest(){
        User user = userDao.queryUserByUsername("user1");
        if (user!=null){
            System.out.println("用户名已存在");
        }else {
            int insertResult = userDao.insertUser(new User(null, "user1", "123456", "2345488@qq.com"));
            if (insertResult>0){
                System.out.println("用户添加成功");
            }else {
                System.out.println("用户添加失败");
            }
        }
    }
}
