<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/20/2022
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <h1>Create new service</h1>
                <h3><span class="message">${requestScope["message"]}</span></h3>
                <form method="post">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Mã dịch vụ</label>
                                <input type="text" name="serviceCode" class="form-control" required>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label>Tên dịch vụ</label>
                                <input type="text" name="serviceName" class="form-control" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Diện tích sử dụng</label>
                                <input type="number" name="serviceArea" class="form-control" required>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Giá tiền</label>
                                <input type="number" name="serviceCost" class="form-control" required>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Số người sử dụng tối đa</label>
                                <input type="number" name="serviceMaxPeople" class="form-control" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label>Kiểu thuê</label>
                                <select name="rentType" class="form-control">
                                    <c:forEach var="rentType" items="${rentTypeList}">
                                        <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <c:forEach var="serviceType" items="${serviceTypeList}">
                            <c:if test="${serviceType.serviceTypeId == idType}">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label>Loại dịch vụ</label>
                                        <select name="serviceType" class="form-control">
                                            <option value="${serviceType.serviceTypeId}">${serviceType.serviceTypeName}</option>
                                        </select>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>

                    <div class="form-group">
                        <label>Tiêu chuẩn phòng</label>
                        <input type="text" name="standardRoom" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Mô tả tiện nghi khác</label>
                        <textarea class="form-control" name="description" required></textarea>
                    </div>
                    <div class="row">
                        <c:forEach var="serviceType" items="serviceTypeList">
                            <c:if test="${ idType ==1}">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label>Diện tích hồ bơi</label>
                                        <input type="number" name="areaPool" class="form-control" required>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="serviceType" items="serviceTypeList">
                            <c:if test="${!(idType==3)}">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label>Số tầng</label>
                                        <input type="number" name="floors" class="form-control" required>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
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