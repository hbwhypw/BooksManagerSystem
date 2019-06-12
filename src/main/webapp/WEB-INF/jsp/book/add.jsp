<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改图书信息</title>
</head>
<body>
<form action="${path}/book/add" method="post">
    书名：<input name="bookName"><br>
    作者：<input name="author"><br>
    简介：<input name="introduction"><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
