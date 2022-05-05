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
    <title>Create Service</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Courgette|Pacifico:400,700">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/formInput.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-lg">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <div class="contact-form">
                <h1>Create new Customer</h1>
                <h3><span class="message">${requestScope["message"]}</span></h3>
                <form method="post" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label>Mã khách hàng:</label>
                        <input type="text" name="customerCode" class="form-control" pattern="^KH(-)[0-9]{4}$" required>
<%--                        <p style="color: red">${errors.get("code")}</p>--%>
                        <div class="valid-feedback">Looks good!</div>
                        <div class="invalid-feedback"> Sai mã khách hàng</div>
                    </div>
                    <div class="form-group">
                        <label>Họ và tên</label>
                        <input type="text" name="customerName" class="form-control" pattern="^[\p{Lu}\p{Ll}\s]+$" required>
                        <p style="color: red">${errors.get("name")}</p>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Ngày sinh</label>
                                <input type="date" name="birthday" class="form-control" required>
                                <p style="color: red">${errors.get("birthday")}</p>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label>Số căn cước/CMND:</label>
                                <input type="text" name="idCard" class="form-control" required>
                                <p style="color: red">${errors.get("idCard")}</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Giới tính</label>
                                <select name="gender" class="form-control">
                                    <option value="1">Nam</option>
                                    <option value="0">Nữ</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Điện thoại:</label>
                                <input type="text" name="phone" class="form-control" required>
                                <p style="color: red">${errors.get("phone")}</p>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>email:</label>
                                <input type="email" name="email" class="form-control" required>
                                <p style="color: red">${errors.get("email")}</p>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Địa chỉ</label>
                        <input type="text" name="address" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Loại khách hàng</label>
                        <select name="customerType" class="form-control">
                            <c:forEach var="customerType" items="${customerTypeList}">
                                <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="text-center">
                        <a href="/customers" class="btn btn-primary"> Close
                        </a>
                        <input type="submit" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
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
</html>
