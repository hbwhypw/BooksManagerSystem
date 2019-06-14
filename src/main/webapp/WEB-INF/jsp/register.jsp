<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="${path}/css/book.css"/>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css"/>
</head>
<body class="container">
<div class="p-3 mb-2 bg-primary text-white">
    <div>图书管理系统</div>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h4 class="panel-title">用户注册</h4>
    </div>
    <form class="form-horizontal" action="${path}/user/register" method="post">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username" placeholder="用户名" required>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="password" name="password" placeholder="密码" required>
            </div>
        </div>
        <div class="form-group">
            <label for="gender" class="col-sm-2 control-label">性别：</label>
            <div class="col-sm-8">
                <select class="form-control" id="gender" name="gender">
                    <option selected value="1">男</option>
                    <option value="2">女</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="date" class="col-sm-2 control-label">生日：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="date" name="date" placeholder="生日(如：2000-10-01)" required>
            </div>
        </div>
        <input class="btn btn-primary" type="submit" value="注册">
    </form>
</div>
</body>
</html>
