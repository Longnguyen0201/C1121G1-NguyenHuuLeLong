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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
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
    <caption><h2>List of Customer</h2></caption>
    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>
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
            <th >Chức năng</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${customerList}">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.code}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><c:out value="${employee.birthday}"/></td>
                    <%--                <td><c:out value="${customer.gender}"/></td>--%>
                <td><c:choose>
                    <c:when test="${employee.gender ==0}">
                        Nữ
                    </c:when>
                    <c:when test="${employee.gender == 1}">
                        Nam
                    </c:when>
                </c:choose></td>

                <td><c:out value="${employee.idCard}"/></td>
                <td><c:out value="${employee.phone}"/></td>
                <td><c:out value="${employee.email}"/></td>
                <td><c:out value="${employee.address}"/></td>
                <td><c:out value="${employee.customerTypeName}"/></td>
                <td>
                    <a href="/customers?action=edit&id=${employee.id}">Edit</a>
                </td>
                <td>
<%--                    <a href="/customers?action=delete&id=${customer.id}">Delete</a>--%>
                    <a type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                       href="/customers?action=delete&id=${employee.id}" onclick="getID(${employee.id})">
                        delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="post" action="/customers?action=delete&id=${customer.id}">
                    <input type="hidden" name="idDelete" id="modalDelete">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Delete customer</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Do you want to delete the customer?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <h2>
        <a href="/home">Back to homepage</a>
    </h2>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>


<script>
    $.extend( true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    } );
    $(document).ready(function() {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    } );
</script>
<script>
    function getID(id) {
        document.getElementById("modalDelete").value = id;
    }
</script>
</html>
