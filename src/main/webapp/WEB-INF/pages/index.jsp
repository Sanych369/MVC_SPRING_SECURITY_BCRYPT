<%--
  Created by IntelliJ IDEA.
  User: Sanych
  Date: 26.07.2020
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<div align="center">
    <a href="${pageContext.request.contextPath}/logout">Выйти</a>
    <br>
    <a href="${pageContext.request.contextPath}/admin/addUser">Добавить нового пользователя</a>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Пользователи</h2></caption>
        <tr>
            <th>ID</th>
            <th>Логин</th>
            <th>Пароль</th>
            <th>Email</th>
            <th>Права доступа</th>
            <th>Действия</th>
        </tr>
        <c:forEach var="users" items="${users}">
            <tr>
                <td><c:out value="${users.id}" /></td>
                <td><c:out value="${users.username}" /></td>
                <td><c:out value="${users.password}" /></td>
                <td><c:out value="${users.email}" /></td>
                <td>
                    <c:forEach var="role" items="${users.roles}">
                        ${role.name};
                    </c:forEach>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/editUser?id=<c:out value='${users.id}' />">Изменить пользователя</a>
                    ||
                    <a href="${pageContext.request.contextPath}/admin/deleteUser?id=<c:out value='${users.id}' />">Удалить пользователя</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
