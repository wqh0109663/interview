<%--
  Created by IntelliJ IDEA.
  User: wqh
  Date: 18-9-30
  Time: 下午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    <input type="hidden" name="addr" value="<%=request.getRemoteAddr()%>" />
    <input type="text" placeholder="realName" name="realName">
    <input type="text" placeholder="age" name="age">
    <input type="text" placeholder="remark" name="remark">
    <input type="text" placeholder="loginName" name="loginName">
    <input type="password" placeholder="pwd" name="pwd">
    <input type="submit" value="提交">
</form>
</body>
</html>
