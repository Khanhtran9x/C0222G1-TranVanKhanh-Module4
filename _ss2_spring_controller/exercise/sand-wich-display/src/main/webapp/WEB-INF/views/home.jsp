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
    <title>SandWich Condiments</title>
</head>
<body>
<form action="/save" method="post">
    <h3>Sandwich Condiments</h3>
    <input type="checkbox" id="lettuce" name="condiments" value="lettuce">
    <label for="lettuce">Lettuce</label><br>
    <input type="checkbox" id="tomato" name="condiments" value="tomato">
    <label for="tomato">Tomato</label><br>
    <input type="checkbox" id="mustard" name="condiments" value="mustard">
    <label for="mustard">Mustard</label><br>
    <input type="checkbox" id="sprouts" name="condiments" value="sprouts">
    <label for="sprouts">Sprouts</label><br>
    <input type="submit" value="Save">
</form>

<c:if test="${condiments != null}">
    <hr>
    <h3>Your ordered sandwich contains the following:</h3>
    <c:forEach items="${condiments}" var = "condiment" varStatus="status">
        <ul>
            <li>${condiment}</li>
        </ul>
    </c:forEach>
</c:if>
</body>
</html>
