<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/10/2022
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<form action="customer" method="post">
    <h2>Danh sách khách hàng</h2>


    <table class="table">
        <thead>
        <tr>
            <th scope="col">Tên</th>
            <th scope="col">Ngày sinh </th>
            <th scope="col">Địa chi</th>
            <th scope="col">Ảnh</th>
        </tr>
        </thead>
        </head>
    </table>
    <input type="submit" id="submit" value="show list" >
</form>
</body>
</html>
