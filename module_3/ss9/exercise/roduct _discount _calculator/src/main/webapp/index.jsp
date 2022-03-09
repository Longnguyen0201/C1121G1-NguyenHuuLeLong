<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/9/2022
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/discount">
        <legend>Product Discount Calculator</legend>
        <div class="mb-3">
            <label  class="form-label">Product Description</label>
            <input type="text"  class="form-control" name="product" placeholder="Product">
        </div>
        <div class="mb-3">
            <label  class="form-label">List Price</label>
            <input type="text" class="form-control" name="price" placeholder="Price">
        </div>
        <div class="mb-3">
            <label  class="form-label">Discount Percent</label>
            <input type="text" class="form-control" name="percent" placeholder="Percent(%)">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
<%--    <label>Product Description</label><br>--%>
<%--    <input type="text" name="product" placeholder="Product Description"><br>--%>
<%--    <label> Price</label><br>--%>
<%--    <input type="text" name="price" placeholder="Price product"><br>--%>
<%--    <label> Discount Percent:</label><br>--%>
<%--    <input type="text" name="percent" placeholder="Discount Percent(%)" value="10"><br>--%>
<%--    <input type="submit" id="submit" value="Discount Amount">--%>
</form>
</body>
</html>
