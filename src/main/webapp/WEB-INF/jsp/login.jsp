<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>登录</title>
</head>
<body>
${msg}
<form action="${path}/user/login" method="post">
    用户名：<input type="text" name="username" value="spp"><br>
    密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" value="123456"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
