<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/23/2022
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>BenhAn</title>
</head>
<body>
<center>
    <h1>Danh sách bệnh án</h1>

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Update Customer</h2>
            </caption>
            <c:if test="${benhAn != null}">
                <input type="hidden" name="id" value="${benhAn.maBenhAn}"/>
            </c:if>
            <tr>
                <th>Mã bệnh án:</th>
                <td>
                    <input type="text" name="maBenhAn"  size="45" value="${benhAn.maBenhAn}" disabled/>
                </td>
            </tr>
            <tr>
                <th>Mã bệnh nhân</th>
                <td>
                    <input type="text" name="maBenhNhan"  size="45" value="${benhAn.maBenhNhan.getMaBenhNhan()}" disabled/>
                </td>
            </tr>
            <tr>
                <th>Họ tên</th>
                <td>
                    <input type="text" name="hoTen"  size="45"value="${benhAn.maBenhNhan.getHoTen()}"/>
                </td>
            </tr>
            <tr>
                <th>Ngày nhập viện</th>
                <td>
                    <input type="date" name="ngayNhapVien"  size="45" value="${benhAn.ngayNhapVien}"/>
                </td>
            </tr>
            <tr>
                <th>Ngày ra viện</th>
                <td>
                    <input type="date" name="ngayRaVien" value="${benhAn.ngayRaVien}"/>
                </td>
            </tr>
            <tr>
                <th>Lý do</th>
                <td>
                    <input type="text" name="lyDo"  size="45" value="${benhAn.lyDo}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                    <a type="button" href="/benhan"> Trở về danh sách</a>
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
