package com.shop.dao.impl;

import com.shop.bean.User;
import com.shop.dao.BaseDao;
import com.shop.dao.UserDao;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 18:01
 * @Version 1.0
 * @describe
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    /**
     * 根据 用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public User queryUserByUsername(String username) {
        //数据库语句
        String sql="SELECT `id`,`username`,`password`,`email` FROM t_user WHERE `username`=?";
        return super.queryForOne(User.class,sql,username);
    }

    /**
     * 根据 用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        //数据库语句
        String sql="SELECT `id`,`username`,`password`,`email` FROM t_user WHERE `username`=? AND `password`=?";
        return super.queryForOne(User.class,sql,username,password);
    }

    /**
     * 添加用户信息
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    @Override
    public int insertUser(User user) {
        //sql语句
        String sql="INSERT INTO t_user(`username`,`password`,`email`) VALUES(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
