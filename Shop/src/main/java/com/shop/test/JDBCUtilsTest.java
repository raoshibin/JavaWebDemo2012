package com.shop.test;

import com.shop.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 18:07
 * @Version 1.0
 * @describe
 */
public class JDBCUtilsTest {
    @Test
    public void testJDBCUtils(){
        Connection con = JDBCUtils.getConnection();
        System.out.println(con);
        JDBCUtils.close(con);
    }


}
