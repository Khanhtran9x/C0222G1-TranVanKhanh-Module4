<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kayli
  Date: 16/06/2022
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Configuration</title>
</head>
<body>
<h3>Your Email Configuration</h3>
<p>Language: ${emailConfiguration.language}</p>
<p>Page size: ${emailConfiguration.pageSize}</p>
<p>Enable spam filter: ${emailConfiguration.enableSpamFilter ?"Enabled" : "Disabled"}</p>
<p>Signature: ${emailConfiguration.signature}</p>
</body>
</html>
