<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/24/2022
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                       <a href="/products" style="color: white"><h2>Manage <b>Products</b></h2></a>
                    </div>
                    <div class="col-sm-6">
                        <a href="/products?action=create" class="btn btn-success"><i
                                class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                    </div>
                </div>
                <div class="row">
                    <form method="get">
                        <br/>
                        <input type="hidden" name="action" value="search">
                        <input type="text" name="search" size="25" placeholder="Enter Product Name">
                        <input type="submit" value="Search">
                    </form>
                </div>
            </div>
            <h3><span class="message">${requestScope["message"]}</span></h3>
            <table class="table table-striped table-hover" id="example">
                <thead>
                <tr>
                    <th>stt</th>
                    <th>name</th>
                    <th>price</th>
                    <th>quantity</th>
                    <th>color</th>
                    <th>catelogy</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${list}" varStatus="l">
                    <tr>
                        <td>${l.count}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.quantity}</td>
                        <td>${product.color}</td>
                        <td>${product.categoryName}</td>

                        <td>
                            <a href="/products?action=edit&id=${product.id}">
                                <i class="material-icons" style="color: dodgerblue">&#xE254;</i></a>
                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal">
                                <i class="material-icons" data-toggle="tooltip" title="Delete"
                                   onclick='sendProductId("${product.getId()}")'>&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/products?action=delete">
                <input type="hidden" name="id_modal_delete" id="isDelete">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script>

    function sendProductId(id) {
        document.getElementById('isDelete').value = id;
    }

    // Disable form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
<%--code phân trang--%>
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


</html>
