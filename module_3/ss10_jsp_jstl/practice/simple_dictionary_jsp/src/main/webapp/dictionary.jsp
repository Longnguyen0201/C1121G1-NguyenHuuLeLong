<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/10/2022
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
Map<String,String> dic = new HashMap<>();
%>
<%
dic.put("hello", "Xin Chào");
dic.put("how", "Thế nào");
dic.put("book", "Quyển vở");
dic.put("computer", "Máy tính");

String searchUp =  request.getParameter("search");
String search = searchUp.toLowerCase();

String result = dic.get(search);
  PrintWriter writer = response.getWriter();

if ( result != null){
  writer.println("Word: " + search);
  writer.println("Result: " + result);
}else {
  writer.println("Not found");
}
%>


</body>
</html>
