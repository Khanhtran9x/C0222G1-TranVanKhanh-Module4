<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kayli
  Date: 14/06/2022
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculate" method="post">
    <h3>Calculator</h3>
    <input type="text" name="firstNumber" value="${firstNumber}">
    <input type="text" name="secondNumber" value="${secondNumber}"><br><br>
    <input type="submit" name="operator" value="Addition">
    <input type="submit" name="operator" value="Subtraction">
    <input type="submit" name="operator" value="Multiplication">
    <input type="submit" name="operator" value="Division"><br>
    <p>Result: ${result}</p>
</form>
</body>
</html>
