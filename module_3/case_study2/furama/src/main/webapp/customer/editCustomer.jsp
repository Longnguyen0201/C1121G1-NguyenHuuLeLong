<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/17/2022
  Time: 9:31 PM
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

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Update Customer</h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}'/>"/>
            </c:if>
            <tr>
                <th>Mã khách hàng:</th>
                <td>
                    <input type="text" name="customerCode" id="code" size="45" value="${customer.code}"/>
                </td>
            </tr>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="customerName" id="name" size="45" value="${customer.name}"/>
                </td>
            </tr>
            <tr>
                <th>Ngày sinh :</th>
                <td>
                    <input type="text" name="birthday" id="birthday" size="45"value="${customer.birthday}"/>
                </td>
            </tr>
            <tr>
            <tr>
                <th>Giới tính:</th>
                <td>
                    <input type="radio" id="gender1" name="gender" value="1">
                    <label for="gender1">Nam</label><br>
                    <input type="radio" id="gender2" name="gender" value="0">
                    <label for="gender2">Nữ</label><br>
                </td>
            </tr>
            <tr>
                <th>Số căn cước/CMND:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45" value="${customer.idCard}"/>
                </td>
            </tr>
            <tr>
                <th>Điện thoại:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"value="${customer.phone}"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45" value="${customer.email}"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="${customer.address}"/>
                </td>
            </tr>
            <tr>
                <th>Loại khách hàng:</th>
                <td>
                    <%--                    <input type="text" name="customerType" id="customerType" size="45"/>--%>
                    <select name="customerType" >
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
        <h2>
            <a href="/customers">Back to Customer Manager</a>
        </h2>
    </form>
</div>
</body>
</html>