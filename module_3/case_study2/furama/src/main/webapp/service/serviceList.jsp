<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/20/2022
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Management Application</title>
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
<%--navbar trang chính--%>
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
        <form method="get" class="form-inline my-2 my-lg-0 justify-content-end">
            <div class="input-group input-group-sm">
                <input type="hidden" name="action" value="search">
                <input name="searchService" type="text" class="form-control" aria-label="Small"
                       aria-describedby="inputGroup-sizing-sm" placeholder="Search by service">
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
    <h2>Manage <b>Service</b></h2>
    <div class="dropdown">
        <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false"><i class="material-icons">&#xE147;</i>Add New Service
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <c:forEach var="serviceType" items="${serviceTypeList}">
                <a class="dropdown-item" href="/services?action=create&idType=${serviceType.serviceTypeId}">
                        ${serviceType.serviceTypeName}</a>
            </c:forEach>
        </div>
    </div>

</center>
<%--Hiển thị List--%>
<div align="center">
    <table id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã dịch vụ</th>
            <th>Tên dịch vụ</th>
            <th>Diện tích</th>
            <th>Giá</th>
            <th>Sức chứa</th>
            <th>Kiểu thuê</th>
            <th>Loại dịch vụ</th>
            <th>Tiêu chuẩn phòng</th>
            <th>Mô tả</th>
            <th>Hồ Bơi</th>
            <th>Số tầng</th>
            <th>Chức năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${serviceList}">
            <tr>
                <td><c:out value="${service.serviceId}"/></td>
                <td><c:out value="${service.serviceCode}"/></td>
                <td><c:out value="${service.serviceName}"/></td>
                <td><c:out value="${service.serviceArea}"/></td>
                <td><c:out value="${service.serviceCost}"/></td>
                <td><c:out value="${service.serviceMaxPeople}"/></td>
                <td><c:out value="${service.rentTypeName}"/></td>
                <td><c:out value="${service.serviceTypeName}"/></td>
                <td><c:out value="${service.standardRoom}"/></td>
                <td><c:out value="${service.description}"/></td>
                <td>
                    <c:if test="${service.areaPool==-1}">
                        none
                    </c:if>
                    <c:if test="${service.areaPool!=-1}">
                        <c:out value="${service.areaPool}"/>
                    </c:if>
                </td>
                <td>
                    <c:if test="${service.floors==-1}">
                        none
                    </c:if>
                    <c:if test="${service.floors!=-1}">
                        <c:out value="${service.floors}"/>
                    </c:if>
                </td>
                <td colspan="2">
                    <a href="/services?action=edit&id=${service.serviceId}"><i class="material-icons"
                                                                               style="color: dodgerblue">&#xE254;</i></a>

                    <a type="button" class="" data-toggle="modal" data-target="#exampleModal"
                       href="/services?action=delete&id=${service.serviceId}" onclick="getID(${service.serviceId})">
                        <i class="material-icons" style="color: #E34724">&#xE872;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h3>
        <a href="/home" style="color: deepskyblue">Back to homepage</a>
    </h3>
</div>
<%--modal Delete--%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/services?action=delete&id=${service.serviceId}">
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
