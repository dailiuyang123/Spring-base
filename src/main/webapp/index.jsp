<%@ page language="java"  pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="margin:auto">


<form name= "myform" method = 'post'  action =  "${ pageContext.request.contextPath }/user/findAll.do"  >

    <div  style="width: 500px; margin: 0px auto">
        <h2>用户登录页</h2>
<table >
    <tr>
        <td> 用户名</td>
        <td><input type="text" name="user.name"></td>
    </tr>

    <tr>
        <td>密码</td>
        <td><input type="password" name="user.password"></td>
    </tr>
    <tr>

        <td><input type="submit" value="登录"></td>
    </tr>
</table>
    </div>
</form>

</body>
</html>
