<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/18/2022
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employees">List All Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngày sinh :</th>
                <td>
                    <input type="text" name="birthday" id="birthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số căn cước/CMND:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Mức lương:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="45"/>
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
                <th>Vị trí:</th>
                <td>
                    <select name="position" >
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.positionId}">${position.positionName}</option>
                        </c:forEach>
<%--                        <option value="1">Quan lý</option>--%>
<%--                        <option value="2">Nhan vien</option>--%>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Học vấn:</th>
                <td>
                    <select name="educationDegree" >
                        <c:forEach var="educationDegree" items="${educationDegreeList}">
                            <option value="${educationDegree.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Bộ phận:</th>
                <td>
                    <select name="division" >
                        <c:forEach var="division" items="${divisionList}">
                            <option value="${division.divisionId}">${division.divisionName}</option>
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
    </form>
</div>
</body>
</html>