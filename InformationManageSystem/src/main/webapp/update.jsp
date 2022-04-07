<%@ page import="domain.FlyAsh" %><%--
  Created by IntelliJ IDEA.
  User: 45789
  Date: 2022/3/14
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Data Update</title>
    <style>
        div{
            margin: auto;
            text-align: center;
        }
    </style>
</head>
<body>

<%
    FlyAsh fa = (FlyAsh) session.getAttribute("fa");
%>

<div>
    <form action="/updateData">
        输入名称
        <input type="text" value="${updatefa.name}" name="name"><br>
        输入类型
        <input type="text" value="${updatefa.type}" name="type"><br>
        输入采样时间
        <input type="text" value="${updatefa.getDate}" name="getDate"><br>
        输入采样地点
        <input type="text" value="${updatefa.origin}" name="origin"><br>
        输入备注
        <input type="text" value="${updatefa.remark}" name="remark"><br><br><br>
        <input type="submit" value="submit"><br>
        <a href="/showData">Back</a>
    </form>
</div>

</body>
</html>
