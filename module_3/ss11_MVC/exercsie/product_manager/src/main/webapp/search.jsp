<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/14/2022
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Product</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>description</td>
        <td>Manufacture</td>
    </tr>
    <c:forEach var="product" items="${searchList}">
        <tr>
            <td>${product.nameProduct}</td>
            <td>${product.priceProduct}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
