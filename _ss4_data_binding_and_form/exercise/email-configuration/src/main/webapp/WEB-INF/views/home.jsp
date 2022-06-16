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
    <title>Email Configuration</title>
</head>
<body>
<form:form action="/saveConfiguration" modelAttribute="emailConfiguration" method="post">
    <h3>Configuration</h3>
    <table>
        <tr>
            <th>Language</th>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page size</th>
            <td>
                <span>
                    Show
                    <form:select path="pageSize">
                        <form:options items="${pageSizes}"></form:options>
                    </form:select>
                    per page
                </span>
            </td>
        </tr>
        <tr>
            <th>Spam filter</th>
            <td>
                <span>
                    <form:checkbox path="enableSpamFilter"></form:checkbox>
                    Enable spam filter
                </span>
            </td>
        </tr>
        <tr>
            <th>Signature</th>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <button type="submit">Update</button>
                <a href="/email-configuration">
                    <button type="button">Cancel</button>
                </a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
