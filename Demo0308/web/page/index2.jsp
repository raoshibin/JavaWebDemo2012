<%--
  Created by IntelliJ IDEA.
  User: 饶世斌
  Date: 2021/3/8
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>商城首页</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script type="text/javascript">
        //验证用户名是否为空
        function onchek() {
            //验证用户名是否为空
            var loginName = document.getElementById("username").value;
            if (!loginName) {
                alert("用户名不合法");
                return false;
            }
            //验证密码是否为空
            var password = document.getElementById("password").value;
            if (!password) {
                alert("密码不合法");
                return false;
            }
            //验证密码与确认密码是否一致
            var repassword = document.getElementById("repassword").value;
            if (repassword != password) {
                alert("两次密码不一致");
                return false;
            }

            //验证邮箱--正则表达式
            //判断正则表达式
            //1.使用String对象中的match方法
            //2.使用正则对象中的test方法
            var email = document.getElementById("email").value;
            var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
            if(!reg.test(email)){
                alert("邮箱格式不正确");
                document.getElementById("email").focus();//让鼠标焦点聚集到当前选中的标签上
                return false;
            }
        }
        function changImg() {
            $("#imgId").attr("src","http://localhost:8086/Demo0308/verifyCode.do?"+new Date());
        }
    </script>
</head>
<body>
<!-- 网页table规格开始 -->
<table style="width: 90%;" border="1px" cellspacing="0" cellpadding="0" align="center">
    <!-- 标题login头部开始 -->
    <tr>
        <td>
            <table style="width: 100%;" border="1px" cellspacing="0" cellpadding="0">
                <tr height="50px">
                <td width="33.3%">
                    <img src="../img/logo2.png" height="47px" />
                </td>
                <td width="33.3%">
                    <img src="../img/header.png" height="47px" />
                </td>
                <td width="33.3%">
                    <a href="#">登陆</a>
                    <a href="#">注册</a>
                    <a href="#">购物车</a>
                </td>
                </tr>
            </table>
        </td>
    </tr>
    <!-- 标题login头部结束 -->
    <!-- 导航栏目开始 -->
    <tr>
        <td>
            <table width="100%" bgcolor="#000000">
                <tr height="60px">
                    <td>
                        &nbsp;&nbsp;
                        <a href="#">
                            <font color="white" size="6">首页</font>
                        </a>
                        &nbsp;&nbsp;
                        <a href="#">
                            <font color="white" size="4">手机数码</font>
                        </a>
                        &nbsp;&nbsp;
                        <a href="#">
                            <font color="white" size="4">电脑办公</font>
                        </a>
                        &nbsp;&nbsp;
                        <a href="#">
                            <font color="white" size="4">鞋靴箱包</font>
                        </a>
                        &nbsp;&nbsp;
                        <a href="#">
                            <font color="white" size="4">家用电器</font>
                        </a>

                    </td>
                    <td align="right">
                        <font color="white">此处是搜索框，待完善</font>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <!-- 导航栏目开始 -->
    <!-- 轮播图开始 -->
    <tr>
        <td background="../img/regist_bg.jpg" width="100%" height="600px">
            <form action="#" method="post" onsubmit="return onchek()">
                <table border="1" width="800px" height="400px" cellspacing="0" align="center">
                    <tr>
                        <td colspan="2">
                            会员注册 USER REGISTER
                        </td>
                    </tr>
                    <tr>
                        <td>用户名</td>
                        <td>
                            <input type="tel" id="username" name="username" value="" placeholder="请输入用户名" maxlength="15" />
                        </td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td>
                            <input type="password" id="password" name="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>确认密码</td>
                        <td>
                            <input type="password" id="repassword" name="repassword" />
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>
                            <input type="text" id="email" name="email" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td>
                            <input type="text" name="name"  value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>性别</td>
                        <td>
                            <input type="radio" name="sex" value="男" checked="checked" />男
                            <input type="radio" name="sex" value="女" />女
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期</td>
                        <td>
                            <input type="date" name="birthday" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>验证码</td>
                        <td>
                            <input type="text" name="code" value="" />
                            <img id="imgId" onclick="changImg()" src="${pageContext.request.contextPath}/verifyCode.do">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" id="" value="注册" />
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    <!-- 轮播图结束 -->

    <tr>
        <td align="center">
            <a href="#">
                <font color="blueviolet">关于我们</font>
            </a>&nbsp;
            <a href="#">
                <font color="blueviolet">联系我们</font>
            </a>&nbsp;
            <a href="#">
                <font color="blueviolet">招纳贤士</font>
            </a>&nbsp;
            <a href="#">
                <font color="blueviolet">法律声明</font>
            </a>&nbsp;
            <a href="#">
                <font color="blueviolet">友情链接</font>
            </a>&nbsp;
            <a href="#">
                <font color="blueviolet">支付方式</font>
            </a>&nbsp;
            <a href="#">
                <font color="blueviolet">配送方式</font>
            </a>&nbsp;
            <a href="#">
                <font color="blueviolet">服务声明</font>
            </a>&nbsp;
            <a href="#">
                <font color="blueviolet">广告声明</font>
            </a>&nbsp;
            <br /><br />
            <font align="center">&copy; 2005-2016 Java商城 版权所有</font> <br /><br />
        </td>

    </tr>
</table>
<!-- 网页table规格开始 -->
</body>
</html>

