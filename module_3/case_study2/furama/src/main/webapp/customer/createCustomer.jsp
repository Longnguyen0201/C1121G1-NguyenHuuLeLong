<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/17/2022
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Mã khách hàng:</th>
                <td>
                    <input type="text" name="customerCode" id="code" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="customerName" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngày sinh :</th>
                <td>
                    <input type="text" name="birthday" id="birthday" size="45"/>
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
                    <input type="text" name="idCard" id="idCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Điện thoại:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Loại khách hàng:</th>
                <td>
<%--                    <input type="text" name="customerType" id="customerType" size="45"/>--%>
                    <select name="customerType" id="customerType">
                        <option value="1">Diamond</option>
                        <option value="2">Platinium</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
