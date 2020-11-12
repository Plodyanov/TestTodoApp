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
    <title>Список задач</title>
</head>
<body>

<h2>Список задач</h2>
<table>
    <tr>
        <th>Id задачи</th>
        <th>Описание</th>
        <th>Статус</th>
        <th>Действие</th>
    </tr>
    <c:forEach var="assignment" items="${assignmentList}">
        <tr>
            <td>${assignment.id}</td>
            <td>${assignment.title}</td>
            <td><input type="checkbox" <c:if test="${assignment.done}">checked = "checked"</c:if> disabled></td>
            <td>
                <a href="/edit/${assignment.id}">изменить</a>
                <a href="/delete/${assignment.id}">удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Добавить</h2>
<a href="/add">Добавить новую задачу</a>
</body>
</html>
