<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css">
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/js/vector.js"></script>
</head>
<body>
<div id="container">
    <div id="output">
        <div class="containerT">
            <h1>用户登录</h1>
            <form class="form" id="entry_form" action="${path}/user/login" method="post">
                <input type="text" placeholder="用户名" id="entry_name" name="username" value="admin">
                <input type="password" placeholder="密码" id="entry_password" name="password" value="123456">
                <button type="button" id="entry_btn" >登录</button>
                <button type="button" id="register_btn" >没有账号，去注册</button>
                <div id="prompt" class="prompt">${msg}</div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        Victor("container", "output");   //登录背景函数
        $("#entry_name").focus();
        $("#entry_btn").click(function () {
            $("#entry_form").submit();
        });
        $("#register_btn").click(function () {
            window.location.href = "/user/register";
        });
        $(document).keydown(function (event) {
            if (event.keyCode == 13) {
                $("#entry_btn").click();
            }
        });

    });
</script>
</body>
</html>
