<%--
  Created by IntelliJ IDEA.
  User: kayli
  Date: 14/06/2022
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Conversion</title>
</head>
<body>
<form action="/home" method="post">
    <h3>Input USD to convert</h3>
    <input type="text" name="usd" value="${usd}">
    <input type="submit">
    <p>Result: ${vnd} VND</p>
</form>
</body>
</html>
