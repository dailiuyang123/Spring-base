<%--
  Created by IntelliJ IDEA.
  User: 11851
  Date: 2018/2/3
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; UTF-8" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="false"  %>

<html>
<head>
    <title style="text-align: center">用户注册 </title>
    <form method="post" action="${pageContext.request.contextPath}/user/addUser" name="addUser">
        <table style="width: 500px;height: 500px ;" >
            <tr>注册</tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="real_name"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>手机号</td>
                <td><input type="number" name="mobile" maxlength="11"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="number" name="age"></td>
            </tr>
            <tr>
                <td>邮件</td>
                <td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address"></td>
            </tr>
        </table>
        <input type="submit" value="注册">
        <input type="reset" value="重来">
    </form>

</head>
<body>

</body>
</html>
