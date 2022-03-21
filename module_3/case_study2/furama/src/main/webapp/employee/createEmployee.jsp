<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/18/2022
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <h1>Create new Employee</h1>
                <h3><span class="message">${requestScope["message"]}</span></h3>
                <form method="post">
                    <div class="form-group">
                        <label>Họ và tên</label>
                        <input type="text" name="name" class="form-control" required>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Ngày sinh</label>
                                <input type="text" name="birthday" class="form-control" required>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label>Số căn cước/CMND:</label>
                                <input type="text" name="idCard" class="form-control" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Mức lương:</label>
                                <input type="number" name="salary" class="form-control" required>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Điện thoại:</label>
                                <input type="text" name="phone" class="form-control" required>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>email:</label>
                                <input type="text" name="email" class="form-control" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Địa chỉ</label>
                        <input type="text" name="address" class="form-control" required>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Vị trí</label>
                                <select name="position" class="form-control">
                                    <c:forEach var="position" items="${positionList}">
                                        <option value="${position.positionId}">${position.positionName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Học vấn</label>
                                <select name="educationDegree" class="form-control">
                                    <c:forEach var="educationDegree" items="${educationDegreeList}">
                                        <option value="${educationDegree.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Bộ phận</label>
                                <select name="division" class="form-control">
                                    <c:forEach var="division" items="${divisionList}">
                                        <option value="${division.divisionId}">${division.divisionName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <a href="/services" class="btn btn-primary"> Close
                        </a>
                        <input type="submit" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>