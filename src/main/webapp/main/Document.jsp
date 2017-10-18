<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <style type="text/css">
        * { font-family: "微软雅黑"; }
        .textField { border:none; border-bottom: 1px solid gray; text-align: center; }
        #file { border:1px solid black; width: 80%; margin:0 auto; }
        h1 input{ font-size:72px; }
        td textarea { font-size: 14px; }
        .key { width:125px; font-size:20px; }
    </style>
</head>
<body>
<form action="word/getWord" method="post">
    <div id="file" align="center">
        <h1><input type="text" name="title" class="textField" value="基本信息表"/></h1>
        <hr/>
        <table>
            <tr>
                <td class="key">項目來源：</td>
                <td><input type="text" name="comFrom" class="textField"/></td>
                <td class="key">投资经理：</td>
                <td>
                <td><input type="text" name="manager" class="textField"/></td>
                </td>
            </tr>
            <tr>
                <td class="key">公司名称：</td>
                <td><input type="text" name="componyName" class="textField"/></td>
                <td class="key">成立时间：</td>
                <td><input type="text" name="createTime" class="textField"/></td>
            </tr>
            <tr>
                <td colspan="4" class="key">个人简介：</td>
            </tr>
            <tr>
                <td colspan="4">
                    <textarea rows="10" cols="100" name="content"></textarea>
                </td>
            </tr>
        </table>
    </div>
    <div align="center" style="margin-top:15px;">
        <input type="submit" value="保存Word文档" />
    </div>
</form>
</body>
</html>