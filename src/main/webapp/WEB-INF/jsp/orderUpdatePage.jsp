<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 05.04.2021
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty order.id}">
        <title>Create</title>
    </c:if>
    <c:if test="${!empty order.id}">
        <title>Update</title>
    </c:if>
</head>
<body>
<c:if test="${!empty order.id}">
    <c:url value="/order/update" var="var"/>
</c:if>
<c:if test="${empty order.id}">
    <c:url value="/order/create" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty order.id}">
        <input type="hidden" name="id" value="${order.id}">
    </c:if>
    <label for="client">Client</label>
    <input type="text" name="client" id="client">
    <label for="date">Date</label>
    <input type="text" name="date" id="date">
    <label for="address">Address</label>
    <input type="text" name="address" id="address">
    <c:if test="${empty order.id}">
        <input type="submit" value="Create new order">
    </c:if>
    <c:if test="${!empty order.id}">
        <input type="submit" value="Update order">
    </c:if>
</form>
    <h2><a href="/order">order page</a></h2>
</body>
</html>
