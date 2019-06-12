<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>图书管理</title>
</head>
<body>
当前用户：${USER_SESSION.username}<a href="${path}/user/logout">退出</a>

<table id="bookTable">
    <thead>
    <tr>
        <th>序号</th>
        <th>标题</th>
        <th>介绍</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="">
        <c:if test="${list} != null">
            <c:forEach items="${list}" var="item">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="${path}/book/edit">修改</a><a href="${path}/book/delete">删除</a></td>
            </c:forEach>
        </c:if>
    </tbody>
</table>
</body>
</html>
