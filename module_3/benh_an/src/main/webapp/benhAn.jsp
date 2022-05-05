<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/23/2022
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Benh an</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
            <ul class="navbar-nav ">
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
                    <a class="nav-link" href="/contracts">Contract</a>
                </li>
            </ul>
        </div>
        <form method="get" class="form-inline my-2 my-lg-0">
            <div class="input-group input-group-sm">
                <input type="hidden" name="action" value="search">
                <input name="searchCustomer" type="text" class="form-control" aria-label="Small"
                       aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
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
    <h2>Danh  <b>Bênh Án</b></h2>
    <a href="/benhan?action=create" class="btn btn-success">
        <span>Thêm mới bệnh án</span></a>
    <a href="/benhan" class="btn btn-success">
        <span>Lists</span></a>
</center>
<div align="center">
    <table id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>stt</th>
            <th>Mã bệnh án</th>
            <th>Mã bệnh nhân</th>
            <th>Họ tên</th>
            <th>Ngày nhập viện</th>
            <th>Ngày ra viện</th>
            <th>Lý do</th>
            <th>Tác vụ</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="benhAn" items="${danhSachBenhAn}">
            <tr>
                <td><c:out value="${benhAn.stt}"/></td>
                <td><c:out value="${benhAn.getMaBenhAn()}"/></td>
                <td><c:out value="${benhAn.maBenhNhan.getMaBenhNhan()}"/></td>
                <td><c:out value="${benhAn.maBenhNhan.getHoTen()}"/></td>
                <td><c:out value="${benhAn.ngayNhapVien}"/></td>
                <td><c:out value="${benhAn.ngayRaVien}"/></td>
                <td><c:out value="${benhAn.lyDo}"/></td>
                <td colspan="2">
                    <a href="/benhan?action=edit&id=${benhAn.getMaBenhAn()}">
                        <i class="material-icons" style="color: dodgerblue">&#xE254;</i></a>
                    <a data-toggle="modal" data-target="#exampleModal"
                       onclick="getID(${benhAn.getMaBenhAn()})">
                        <i class="material-icons" style="color: #E34724">&#xE872;</i>
                    </a>
                        <%--                    data-toggle="modal" data-target="#exampleModal"--%>
                        <%--                    onclick="getID(${benhAn.maBenhAn})"--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2>
        <a href="/home" style="color: cornflowerblue">Back to homepage</a>
    </h2>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/benhan?action=delete&id=${benhAn.maBenhAn()}">
                <input type="hidden" name="idDelete" id="modalDelete">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xóa bệnh án</h5>
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
        "ordering": false
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
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
</html>
