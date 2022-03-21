<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/20/2022
  Time: 8:51 PM
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
                <h1>Edit Service</h1>
                <form method="post">
                    <c:if test="${service != null}">
                        <input type="hidden" name="id" value="<c:out value='${service.serviceId}'/>"/>
                    </c:if>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Mã dịch vụ</label>
                                <input type="text" name="serviceCode" class="form-control" value="${service.serviceCode}" required>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="form-group">
                                <label>Tên dịch vụ</label>
                                <input type="text" name="serviceName" class="form-control" value="${service.serviceName}" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Diện tích sử dụng</label>
                                <input type="number" name="serviceArea" class="form-control" value="${service.serviceArea}" required>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Giá tiền</label>
                                <input type="number" name="serviceCost" class="form-control" value="${service.serviceCost}" required>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label>Số người sử dụng tối đa</label>
                                <input type="number" name="serviceMaxPeople" class="form-control" value="${service.serviceMaxPeople}" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label>Kiểu thuê</label>
                                <select name="rentType" class="form-control">
                                    <c:forEach var="rentType" items="${rentTypeList}">
                                        <c:choose>
                                            <c:when test="${rentType.rentTypeId == service.rentTypeId}" >
                                                <option value="${rentType.rentTypeId}" selected>${rentType.rentTypeName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label>Loại dịch vụ</label>
                                <select name="serviceType" class="form-control">
                                    <c:forEach var="serviceType" items="${serviceTypeList}">
                                        <c:choose>
                                            <c:when test="${serviceType.serviceTypeId==service.serviceTypeId}">
                                                <option value="${serviceType.serviceTypeId}" selected>${serviceType.serviceTypeName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${serviceType.serviceTypeId}">${serviceType.serviceTypeName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Tiêu chuẩn phòng</label>
                        <input type="text" name="standardRoom" class="form-control" value="${service.standardRoom}" required>
                    </div>
                    <div class="form-group">
                        <label>Mô tả tiện nghi khác</label>
                        <input type="text" class="form-control" name="description" value="${service.description}" required>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label>Diện tích hồ bơi</label>
                                <input type="number" name="areaPool" class="form-control" value="${service.areaPool}" required>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label>Số tầng</label>
                                <input type="number" name="floors" class="form-control" value="${service.floors}" required>
                            </div>
                        </div>
                    </div>
                    <p>
                        <c:if test='${requestScope["message"] != null}'>
                            <span class="message">${requestScope["message"]}</span>
                        </c:if>
                    </p>
                    <div class="text-center">
                        <a href="/services" class="btn btn-primary" > Close</a>
                        <a type="submit" class="btn btn-primary"><i class="fa fa-paper-plane"></i> Update</a>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
