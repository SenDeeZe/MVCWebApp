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
    <title>ORDERS</title>
</head>
<body>
    <h2>Orders page</h2>
    <h3><a href="/goods">Goods page</a></h3>
    <h3>Find order by id</h3>

    <c:url value="/order/find/${id}" var="var"/>
    <form action="${var}" method="POST">
        <input type="text" name=id value="id">
        <input type="submit" value="Find order">
    </form>

    <table>
        <tr>
            <th>id</th>
            <th>client</th>
            <th>date</th>
            <th>address</th>
        </tr>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.id}</td>
                <td>${order.client}</td>
                <td>${order.date}</td>
                <td>${order.address}</td>
                <td>
                    <a href="/order/update/${order.id}">update</a>
                    <a href="/order/delete/${order.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2>Add</h2>
    <c:url value="/order/create" var="create"/>
    <a href="${create}">Create new order</a>
</body>
</html>
