<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/24/2022
  Time: 9:34 PM
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
                <h1>Update Product</h1>
                <h3><span class="message">${requestScope["message"]}</span></h3>
                <form method="post" class="needs-validation" novalidate>
                    <c:if test="${product != null}">
                        <input type="hidden" name="id" value="${product.id}"/>
                    </c:if>
                    <div class="form-group">
                        <label>Name Product</label>
                        <input type="text" name="name" value="${product.name}" class="form-control"
                               pattern="^[\p{Lu}\p{Ll}]+( [\p{Lu}\p{Ll}]+)*$" required>
                        <div class="valid-feedback">Valid</div>
                        <div class="invalid-feedback">Name cannot have any extra spaces or no characters</div>
                    </div>
                    <div class="form-group">
                        <label>Price Product</label>
                        <input type="number" name="price" value="${product.price}" class="form-control" required min="10000000">
                        <div class="valid-feedback">Valid</div>
                        <div class="invalid-feedback">Price cannot less than 10.000.000VND</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Quantity</label>
                                <input type="number" name="quantity" value="${product.quantity}" class="form-control" min="0" required pattern="^\d+(.\d+)*$">
                                <div class="valid-feedback">Valid</div>
                                <div class="invalid-feedback">Quantity cannot less than 0</div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Color</label>
                                <select name="color" class="form-control">
                                    <option value="Red">Red</option>
                                    <option value="Blue">Blue</option>
                                    <option value="Black" selected>Black</option>
                                    <option value="White">White</option>
                                    <option value="Yellow">Yellow</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-control">

                                    <c:forEach var="category" items="${categoryList }">
                                        <c:choose>
                                            <c:when test="${category.categoryId == product.category}">
                                                <option value="${category.categoryId}" selected>${category.categoryName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${category.categoryId}">${category.categoryName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <a href="/products" class="btn btn-primary"> Close
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

