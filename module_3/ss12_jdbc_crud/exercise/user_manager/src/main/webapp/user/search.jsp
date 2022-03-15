<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/15/2022
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Search by country</title>
</head>
<body>
<center>
    <h1>User Search</h1>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users searching by country</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>
        <c:forEach var="user" items="${searchList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
            </tr>
        </c:forEach>
        <a href="/users">Back to Users list</a>
    </table>
</div>
</body>
</html>
