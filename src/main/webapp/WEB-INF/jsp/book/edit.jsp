<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改图书信息</title>
    <link rel="stylesheet" type="text/css" href="${path}/css/book.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css"/>
</head>
<body class="container">
<div class="p-3 mb-2 bg-primary text-white">
    <span class="mr-0 mr-md-2">当前用户：${USER_SESSION.username}</span>
    <span class="mr-md-6"> </span>
    <a class="mr-md-2 text-dark" href="${path}/user/logout">退出</a>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h4 class="panel-title">新增图书信息</h4>
    </div>
    <form class="form-horizontal" action="${path}/book/edit" method="post">
        <input name="id" type="hidden" value="${book.id}">
        <input name="createTime" type="hidden" value="${book.createTime}">
        <div class="form-group">
            <label for="bookName" class="col-sm-2 control-label">书名：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="bookName" name="bookName" placeholder="请输入书名"
                       value="${book.bookName}">
            </div>
        </div>
        <div class="form-group">
            <label for="author" class="col-sm-2 control-label">作者：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="author" name="author" placeholder="请输入作者"
                       value="${book.author}">
            </div>
        </div>
        <div class="form-group">
            <label for="introduction" class="col-sm-2 control-label">简介：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="introduction" name="introduction" placeholder="请输入简介"
                       value="${book.introduction}">
            </div>
        </div>
        <input class="btn btn-primary" type="submit" value="保存">
    </form>
</body>
</html>
