<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 02.11.2020
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty assignment.title}">
        <title>Добавление задачи</title>
    </c:if>
    <c:if test="${!empty assignment.title}">
        <title>Редактирование задачи</title>
    </c:if>
</head>
<body>
<c:if test="${empty assignment.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty assignment.title}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">

    <c:if test="${!empty assignment.title}">
        <input type="hidden" name="id" value="${assignment.id}">
        <label for="title">Описание</label>
        <input type="text" name="title" value="${assignment.title}" id="title">
        <label for="done">Статус</label>
        <input type="checkbox" name="done" <c:if test="${assignment.done}">checked = "checked"</c:if> id="done">
        <input type="submit" value="Сохранить изменения">
    </c:if>

    <c:if test="${empty assignment.title}">
        <label for="title">Описание</label>
        <input type="text" name="title" id="title">
        <label for="done">Статус</label>
        <input type="checkbox" name="done" id="done">
        <input type="submit" value="Добавить задачу">
    </c:if>

</form>
</body>
</html>
