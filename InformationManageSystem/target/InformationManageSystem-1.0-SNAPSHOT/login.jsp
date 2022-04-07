<%--
  Created by IntelliJ IDEA.
  User: 45789
  Date: 2022/3/10
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<%

%>

<div style="text-align: center">
    <form action="/login" method="post">
        <input type="text" name="name" placeholder="username"><br>
        <input type="password" name="password" placeholder="password"><br>
        <input type="text" name="checkcode" placeholder="checkcode"><br>
        <img src="/verifycode" onclick="reFresh(this)"><br>
        <input type="submit" value="submit">
    </form>
</div>

<script>
    function reFresh(e) {
        const source = e.src;
        var index = source.indexOf("?");
        if(index > -1) {
            var s = source.substring(0, index);
            var date = new Date();
            var time = date.getTime();
            e.src = s + "?time=" + time;
        }else{
            var data = new Date();
            e.src = source + "?time=" + time;
        }
    }
</script>

</body>
</html>
