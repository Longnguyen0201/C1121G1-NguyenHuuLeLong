<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/19/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Update Employee</h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}'/>"/>
            </c:if>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="employeeName" id="name" size="45" value="${employee.name}"/>
                </td>
            </tr>
            <tr>
                <th>Ngày sinh :</th>
                <td>
                    <input type="text" name="birthday" id="birthday" size="45"value="${employee.birthday}"/>
                </td>
            </tr>
            <tr>
                <th>Mức lương:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="45" value="${employee.salary}"/>
                </td>
            </tr>
            <tr>
                <th>Số căn cước/CMND:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45" value="${employee.idCard}"/>
                </td>
            </tr>
            <tr>
                <th>Điện thoại:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"value="${employee.phone}"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45" value="${employee.email}"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="${employee.address}"/>
                </td>
            </tr>
            <tr>
                <th>Vị trí:</th>
                <td>
                    <select name="position" >
                        <c:forEach var="position" items="${positionList}">
                            <c:choose>
                                <c:when test="${position.positionId == employee.positionId}">
                                    <option value="${position.positionId}" selected>${position.positionName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${position.positionId}">${position.positionName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Học vẫn:</th>
                <td>
                    <select name="education" >
                        <c:forEach var="education" items="${educationDegreeList}">
                            <c:choose>
                                <c:when test="${education.educationDegreeId == employee.educationId}">
                                    <option value="${education.educationDegreeId}" selected>${education.educationDegreeName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${education.educationDegreeId}" >${education.educationDegreeName}</option>
                                </c:otherwise>
                            </c:choose>
<%--                            <option value="${education.educationDegreeId}">${education.educationDegreeName}</option>--%>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Bộ phận:</th>
                <td>
                    <select name="division" >
                        <c:forEach var="division" items="${divisionList}">
                            <c:choose>
                                <c:when test="${division.divisionId == employee.divisionId}">
                                    <option value="${division.divisionId}" selected>${division.divisionName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${division.divisionId}" >${division.divisionName}</option>
                                </c:otherwise>
                            </c:choose>

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
        <p>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p>
        <h2>
            <a href="/employees">Back to employee Manager</a>
        </h2>
    </form>
</div>
</body>
</html>