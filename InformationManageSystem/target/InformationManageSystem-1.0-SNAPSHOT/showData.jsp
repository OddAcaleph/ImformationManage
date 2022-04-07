<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="domain.FlyAsh" %>
<%@ page import="Dao.FlyAshDao" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 45789
  Date: 2022/3/13
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fly Ash Data</title>
    <style>
        tr{
            width: 100px;
            height: 20px;
        }
        div{
            text-align: center;
        }
        table, th, tr, td{
            text-align: center;
            border : 1px solid black;
            width: auto;
            margin: auto;
        }
    </style>
</head>
<body>

<%
    ArrayList<FlyAsh> flyAshes = (ArrayList<FlyAsh>) session.getAttribute("datas");
%>

<div>
    <p style="text-align: center"><h2>飞灰信息表</h2></p>
    <div>
        <input type="submit" value="新增数据" onclick="location='insert.jsp'">
        <input type="submit" value="删除数据" onclick="delAlltr()">
        <input type="submit" value="更新数据" onclick="location='showData'">
    </div>
    <br>
    <table cellpadding="0" cellspacing="0">
        <tr>
            <th><input type="checkbox" id="firstCB"></th>
            <th>ID</th>
            <th>名称</th>
            <th>类型</th>
            <th>采样时间</th>
            <th>采样地点</th>
            <th>备注</th>
        </tr>

        <c:forEach items="${datas}" var="fa">
            <tr>
                <td><input type="checkbox" name="checkbox"></td>
                <td>${fa.id}</td>
                <td>${fa.name}</td>
                <td>${fa.type}</td>
                <td>${fa.getDate}</td>
                <td>${fa.origin}</td>
                <td>${fa.remark}</td>
                <td><a href="${pageContext.request.contextPath}/showUpdateData?id=${fa.id}">修改数据</a></td>
                <td><a href="javascript:deleteTr(${fa.id})">删除数据</a></td>
            </tr>
        </c:forEach>

    </table>
</div>



<script>
    window.onload = function () {
        document.getElementById("firstCB").onclick = function () {
            let cbs = document.getElementsByName("checkbox");
            for (let i = 0; i < cbs.length; i++) {
                cbs[i].checked = this.checked;
            }
        }
    }

    function deleteTr(id) {
        if(confirm("确认删除？")){
            location.href = "${pageContext.request.contextPath}/deleteData?id=" + id;
        }
    }

    function delAlltr() {
        let cbs = document.getElementsByName("checkbox");
        let ids = []
        for (let i = 0; i < cbs.length; i++) {
            if(cbs[i].checked){
                ids.push(i + 1)
            }
        }
        if(confirm("确认删除？")){
            location.href = "${pageContext.request.contextPath}/deleteAllData?ids=" + ids;
        }
    }

    function updatetr(obj) {
        table = obj.parentNode.parentNode.parentNode;
        tr = obj.parentNode.parentNode;
        for (var i = 0; i < tr.children(obj.parentNode).length; i++) {
            let innerHTML = tr[i].innerHTML
            alert(innerHTML)
        }
        tr.getValue(i)
    }
</script>

</body>
</html>
