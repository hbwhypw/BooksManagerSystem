<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta charset="utf-8">
    <title>图书管理</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/book.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css"/>
    <script src="${path}/js/jquery.min.js"></script>
    <script src="${path}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${path}/js/bootbox.min.js"></script>
</head>
<body>
<div class="box">
    <div class="p-3 mb-2 bg-primary text-white">
        <span class="mr-0 mr-md-2">当前用户：${USER_SESSION.username}</span>
        <span class="mr-md-6"> </span>
        <a class="mr-md-2 text-dark" href="${path}/user/logout">退出</a>
    </div>
    <div class="content">
        <!--搜索输入框及查询、重置按钮-->
        <div class="container content_width">
            <div class="person_search">
                <div class="search_input">
                    <div class="input-group mb-3">
                        <span>姓名：</span>
                        <input id="Ktext" type="text" class="form-control" placeholder="请输入姓名">
                    </div>
                </div>
                <div class="search_input">
                    <button class="btn btn-primary search_btn" type="button" id="search_btn">查询</button>
                    <button class="btn btn-primary search_btn" type="button" id="back_btn">重置</button>
                </div>
            </div>
            <div class="line"></div>
        </div>
        <!--添加按钮及bootstrap的模态框-->
        <div class="export">
            <button id="new_add" type="button" class="btn btn-primary btn-sm">
                <img src="${path}/img/add_two.png"/>
                <span>添加</span>
            </button>
        </div>
        <!--表格列表-->
        <table id="tb" class="table">
            <thead>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>介绍</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="show_tbody">
            <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.bookName}</td>
                <td>${item.author}</td>
                <td>${item.introduction}</td>
                <td>${item.createTime}</td>
                <td>${item.updateTime}</td>
                <td>
                    <a href="${path}/book/edit/${item.id}" class="edit">编辑</a>
                    <a href="${path}/book/delete/${item.id}" class="del">删除</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    var path = "${path}";
</script>
<script src="${path}/js/mejs.js"></script>
</body>
</html>
