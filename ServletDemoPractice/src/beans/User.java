package beans;

import java.util.Date;
import java.util.Objects;

/**
 * @Author 饶世斌
 * @Date 2021/3/5 18:23
 * @Version 1.0
 * @describe 用户信息实体类
 */
public class User {
    private String username; //用户名
    private String password;//用户密码
    private Date lastLoginDate;//最后的登陆时间
    private Integer loginCount;//登陆次数

    //空构造行数
    public User() {
    }

    //带参数的构造函数
    public User(String username, String password, Date lastLoginDate, Integer loginCount) {
        this.username = username;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
        this.loginCount = loginCount;
    }

    //get和set方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", loginCount=" + loginCount +
                '}';
    }

    //重写equal方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,password);
    }
}
