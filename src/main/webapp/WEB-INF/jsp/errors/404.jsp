<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>404</title>
</head>
<body>
    找不到页面！<a href="${path}/user/login">去登录页</a>
</body>
</html>
