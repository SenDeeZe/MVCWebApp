<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 09.04.2021
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
        <tr>
            <td>${goods.id}</td>
            <td>${goods.name}</td>
            <td>${goods.price}</td>
        </tr>
</table>
    <h2><a href="/goods">goods page</a></h2>
</body>
</html>
