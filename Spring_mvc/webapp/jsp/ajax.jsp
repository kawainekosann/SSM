<%--
  Created by IntelliJ IDEA.
  User: liuqi
  Date: 2021/2/17
  Time: 上午1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<script>
    var userList = new Array();
    userList.push({userName:"liu1",age:27})
    userList.push({userName:"liu2",age:28})

    $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath}/user/quick15",
        data:JSON.stringify(userList),
        contentType:"application/json;charset=utf-8"
    })
</script>
<body>
</body>
</html>
