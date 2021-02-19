<%--
  Created by IntelliJ IDEA.
  User: LIUQI
  Date: 2021/02/19
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
    名称<input type="text" name="userName"><br>
    文件<input type="file" name="uploadFile"><br>
    文件<input type="file" name="uploadFile2"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
