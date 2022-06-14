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
    <title>Dictionary</title>
</head>
<body>
<form action="/home" method="post">
    <h3>Input english word to look up</h3>
    <input type="text" name="englishWord" value="${englishWord}">
    <input type="submit">
    <p>Result: ${vietnameseWord}</p>
</form>
</body>
</html>
