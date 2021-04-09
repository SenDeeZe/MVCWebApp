<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 08.04.2021
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order ${order.id}</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>client</th>
        <th>date</th>
        <th>address</th>
    </tr>
        <tr>
            <td>${order.id}</td>
            <td>${order.client}</td>
            <td>${order.date}</td>
            <td>${order.address}</td>
        </tr>
</table>
    <h3><a href="/order">order page</a></h3>
</body>
</html>
