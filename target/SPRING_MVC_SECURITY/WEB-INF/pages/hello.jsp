<%--
  Created by IntelliJ IDEA.
  User: Sanych
  Date: 26.07.2020
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<TITLE>Инфо</TITLE>
<body>
<div align="center">
    <div>
        <a href="${pageContext.request.contextPath}/logout">Выйти</a>
    </div>
    <table border="1" cellpadding="5">
        <caption><h2>Информация о пользователе</h2></caption>
        <tr>
            <th>Логин: </th>
            <td><c:out value='${user.username}' /></td>
        </tr>
        <tr>
            <th>Email: </th>
            <td><c:out value='${user.email}' /></td>
        </tr>
        <tr>
            <th>Пароль: </th>
            <td><b>Недоступно</b></td>
        </tr>
        <tr>
            <th>Права доступа: </th>
            <td>
                <c:forEach var="role" items="${user.roles}">
                    ${role.name};
                </c:forEach>
            </td>
        </tr>
    </table>
</div>

</body>
</html>