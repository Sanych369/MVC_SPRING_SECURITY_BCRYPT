<%--
  Created by IntelliJ IDEA.
  User: Sanych
  Date: 26.07.2020
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body>
<div align="center">
    <div>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
    <br>
    <div>
        <a href="${pageContext.request.contextPath}/admin/">Вернуться к списку пользователей</a>
    </div>
    <form action="<c:url value="/admin/addUser"/>" method="post">
        <table border="1" cellpadding="5">
            <caption><h2>Добавить пользователя: </h2></caption>
            <tr>
                <th>Логин: </th>
                <td>
                    <input type="text" name="username" size="45" required
                           value="<c:out value='${user.username}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Пароль: </th>
                <td>
                    <input type="text" name="password" size="45" required
                           value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45" required
                           value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Сохранить пользователя" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>