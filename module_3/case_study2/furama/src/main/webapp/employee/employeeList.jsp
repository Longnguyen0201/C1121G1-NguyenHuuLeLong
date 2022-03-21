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
    <title>Employee Management Application</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/furama.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


</head>
<body>
<nav class="navbar navbar-expand-md ">
    <div class="container">
        <a class="navbar-brand" href="/home">Furama</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse " id="navbarsExampleDefault">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employees">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/services">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contract</a>
                </li>
            </ul>

        </div>
        <form  method="get" class="form-inline my-2 my-lg-0 justify-content-end">
            <div class="input-group input-group-sm">
                <input type="hidden" name="action" value="search">
                <input name="searchEmployee" type="text" class="form-control" aria-label="Small"
                       aria-describedby="inputGroup-sizing-sm" placeholder="Search by name">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary btn-number">
                        <i class="mdi mdi-search"></i>
                    </button>
                </div>
            </div>
        </form>
    </div>
</nav>
<center>

    <h2>Manage <b>Employees</b></h2>
    <a href="/employees?action=create" class="btn btn-success" >
        <i class="material-icons">&#xE147;</i> <span>Add New Employee</span></a>
</center>
<div align="center">
    <table id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>Số căn cước/CMND</th>
            <th>Mức lương</th>
            <th>Điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Vị trí</th>
            <th>Học vấn</th>
            <th>Bộ phận</th>
            <th>Chức năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><c:out value="${employee.birthday}"/></td>
                <td><c:out value="${employee.idCard}"/></td>
                <td><c:out value="${employee.salary}"/></td>
                <td><c:out value="${employee.phone}"/></td>
                <td><c:out value="${employee.email}"/></td>
                <td><c:out value="${employee.address}"/></td>
                <td><c:out value="${employee.positionName}"/></td>
                <td><c:out value="${employee.educationName}"/></td>
                <td><c:out value="${employee.divisionName}"/></td>
                <td colspan="2">
                    <a href="/employees?action=edit&id=${employee.id}"><i class="material-icons"
                                                                          style="color: dodgerblue">&#xE254;</i></a>

                    <a type="button" class="" data-toggle="modal" data-target="#exampleModal"
                       href="/employees?action=delete&id=${employee.id}" onclick="getID(${employee.id})">
                        <i class="material-icons" style="color: #E34724">&#xE872;</i>
                    </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h3>
        <a href="/home" style="color: deepskyblue">Back to homepage</a>
    </h3>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/employees?action=delete&id=${employee.id}">
                <input type="hidden" name="idDelete" id="modalDelete">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete the employee?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
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
    $.extend(true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": true
    });
    $(document).ready(function () {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    });
</script>
<script>
    function getID(id) {
        document.getElementById("modalDelete").value = id;
    }
</script>

</html>
