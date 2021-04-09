<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 08.04.2021
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty goods.id}">
        <title>Create</title>
    </c:if>
    <c:if test="${!empty goods.id}">
        <title>Update</title>
    </c:if>
</head>
<body>
<c:if test="${!empty goods.id}">
    <c:url value="/goods/update" var="var"/>
</c:if>
<c:if test="${empty goods.id}">
    <c:url value="/goods/create" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty goods.id}">
    <input type="hidden" name="id" value="${goods.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="price">Price</label>
    <input type="text" name="price" id="price">
    <c:if test="${empty goods.id}">
    <input type="submit" value="Create new goods">
    </c:if>
    <c:if test="${!empty goods.id}">
    <input type="submit" value="Update goods">
    </c:if>
</form>
    <h2><a href="/goods">goods page</a></h2>
</body>
</html>
