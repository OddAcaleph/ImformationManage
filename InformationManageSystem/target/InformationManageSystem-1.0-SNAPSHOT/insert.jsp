<%--
  Created by IntelliJ IDEA.
  User: 45789
  Date: 2022/3/14
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data Insert</title>
    <style>
        div{
            text-align: center;
        }
    </style>
</head>
<body>

    <div>
        <form action="/insertData">
        输入名称
        <input type="text" placeholder="name" name="name"><br>
        输入类型
        <input type="text" placeholder="type" name="type"><br>
        输入采样时间
        <input type="text" placeholder="yyyy-mm-dd" name="getDate"><br>
        输入采样地点
        <input type="text" placeholder="origin" name="origin"><br>
        输入备注
        <input type="text" placeholder="remark" name="remark"><br><br><br>
        <input type="submit" value="submit"><br>
        <a href="/showData">Back</a>
        </form>
    </div>

</body>
</html>
