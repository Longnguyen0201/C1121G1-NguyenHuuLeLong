<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/16/2022
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers?action=create">Add New Customer</a>
    </h2>
    <form method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="" placeholder="">
        <button type="submit">Search</button>
    </form>

</center>
<div align="center">

    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Mã khách hàng</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Số căn cước/CMND</th>
            <th>Điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Loại khách hàng</th>
            <th>Chức năng</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.code}"/></td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.birthday}"/></td>
<%--                <td><c:out value="${customer.gender}"/></td>--%>
                <td><c:choose>
                    <c:when test="${customer.gender ==0}">
                        Nữ
                    </c:when>
                    <c:when test="${customer.gender == 1}">
                        Nam
                    </c:when>
                </c:choose></td>

                <td><c:out value="${customer.idCard}"/></td>
                <td><c:out value="${customer.phone}"/></td>
                <td><c:out value="${customer.email}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td><c:out value="${customer.customerTypeName}"/></td>
                <td>
                    <a href="/customers?action=edit&id=${customer.id}}">Edit</a>
                    <a href="/customers?action=delete&id=${customer.id}}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2>
        <a href="/home">Back to homepage</a>
    </h2>
</div>
</body>
</html>
