<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/24/2022
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Courgette|Pacifico:400,700">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/create.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-lg">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <div class="contact-form">
                <h1>Mượn sách </h1>
                <h3><span class="message">${requestScope["message"]}</span></h3>
                <form method="post" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label>Mã mượn sách</label>
                        <input type="text" name="code" class="form-control" pattern="^MS(\-)[0-9]{4}$" required>
                        <div class="valid-feedback">Valid</div>
                        <div class="invalid-feedback">ex:MS-0001</div>
                    </div>
                    <div class="form-group">
                        <label>Tên sách</label>
                        <input type="hidden" name="maSach"  value="${sach.maSach}">
                        <input type="text" name="name" class="form-control" value="${sach.tenSach}"
                               pattern="^[\p{Lu}\p{Ll}]+( [\p{Lu}\p{Ll}]+)*$" required disabled>
                        <div class="valid-feedback">Valid</div>
                        <div class="invalid-feedback">Name cannot have any extra spaces or no characters</div>
                    </div>
                    <div class="form-group">
                        <label>Học sinh</label>
                        <select name="hocsinh" class="form-control">
                            <c:forEach var="hocsinh" items="${hocsinhList }">
                                <option value="${hocsinh.maHocSinh}">${hocsinh.hoTen}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Ngày mượn sách</label>
                        <input type="date" name="ngayMuon" class="form-control" required>

                    </div>
                    <div class="form-group">
                        <label>Ngày trả sách</label>
                        <input type="date" name="ngayTra" class="form-control" required >
                    </div>
                    <div class="text-center">
                        <a href="/sachs" class="btn btn-primary"> Close
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
</html>
