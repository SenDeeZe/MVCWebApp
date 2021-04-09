<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 04.04.2021
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GOODS</title>
</head>
<body>
<h2>Goods page</h2>
<h3><a href="/order">Order page</a></h3>
<h3>Find goods by id</h3>

<c:url value="/goods/find/${id}" var="var"/>
<form action="${var}" method="POST">
    <input type="text" name=id value="id">
    <input type="submit" value="Find order">
</form>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
    <c:forEach var="goods" items="${goodsList}">
        <tr>
            <td>${goods.id}</td>
            <td>${goods.name}</td>
            <td>${goods.price}</td>
            <td>
                <a href="/goods/update/${goods.id}">update</a>
                <a href="/goods/delete/${goods.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Add</h2>
<c:url value="/goods/create" var="create"/>
<a href="${create}">Create new goods</a>
</body>
</html>
