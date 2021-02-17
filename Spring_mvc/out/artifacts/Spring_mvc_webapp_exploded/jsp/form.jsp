<%--
  Created by IntelliJ IDEA.
  User: liuqi
  Date: 2021/2/17
  Time: 上午1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick14" method="post">
    <%--表面是第几个User对象的userName,age--%>
    <input type="text" name="userList[0].userName"><br/>
    <input type="text" name="userList[0].age"><br/>
    <input type="text" name="userList[1].userName"><br/>
    <input type="text" name="userList[1].age"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
