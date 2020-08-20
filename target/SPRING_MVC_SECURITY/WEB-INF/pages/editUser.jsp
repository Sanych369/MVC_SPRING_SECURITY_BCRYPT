<%--
  Created by IntelliJ IDEA.
  User: Sanych
  Date: 26.07.2020
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Изменение пользователя</title>
</head>
<body>
<div align="center">
    <div>
        <a href="${pageContext.request.contextPath}logout">Выйти</a>
    </div>
    <br>
    <div>
        <a href="${pageContext.request.contextPath}/admin/">Вернуться к списку пользователей</a>
    </div>
    <form action="<c:url value="/admin/editUser"/>" method="post">
        <table border="1" cellpadding="5">
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
            </c:if>
            <caption><h2>Изменить пользователя: </h2></caption>
            <tr>
                <th>Логин: </th>
                <td>
                    <input type="text" name="username" size="45"
                           value="<c:out value='${user.username}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Пароль: </th>
                <td>
                    <input type="text" name="password" size="45"
                           value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <th>Email: </th>
            <td>
                <input type="text" name="email" size="45"
                       value="<c:out value='${user.email}' />"
                />
            </td>
            </tr>
            <tr>
                <th>Группа доступа: </th>
                <td>
                    <c:forEach var="role" items="${user.roles}">
                        <c:if test="${role.id == 1}">
                            <c:set var="ROLE_USER" value="ROLE_USER" />
                        </c:if>
                        <c:if test="${role.id == 2}">
                            <c:set var="ROLE_ADMIN" value="ROLE_ADMIN" />
                        </c:if>
                    </c:forEach>
                    <input type="checkbox" name="role" value="ROLE_USER"
                    <c:if test="${ROLE_USER == 'ROLE_USER'}"> checked=checked</c:if>/>USER<br>
                    <input type="checkbox" name="role" value="ROLE_ADMIN"
                    <c:if test="${ROLE_ADMIN == 'ROLE_ADMIN'}"> checked=checked</c:if>/>ADMIN
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Сохранить изменения" />
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
