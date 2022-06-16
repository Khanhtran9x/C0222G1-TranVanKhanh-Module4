<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kayli
  Date: 16/06/2022
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>THÔNG TIN TỜ KHAI Y TẾ ĐÃ KHAI</title>
</head>
<body>
<h2>THÔNG TIN TỜ KHAI Y TẾ ĐÃ KHAI</h2>
<p>Họ tên: ${medicalDeclaration.name}</p>
<p>Năm sinh: ${medicalDeclaration.dateOfBirth}</p>
<p>Số CMND hoặc hộ chiếu: ${medicalDeclaration.idCard}</p>
<p>Thông tin đi lại: ${medicalDeclaration.transportationInformation}</p>
<p>Số hiệu phương tiện: ${medicalDeclaration.transportationCode}</p>
<p>Số ghế: ${medicalDeclaration.seatCode}</p>
<p>Ngày bắt đầu: ${medicalDeclaration.startDay}/${medicalDeclaration.startMonth}/${medicalDeclaration.startYear}</p>
<p>Ngày kết thúc: ${medicalDeclaration.endDay}/${medicalDeclaration.endMonth}/${medicalDeclaration.endYear}</p>
<p>Các nơi đã đi đến trong vòng 14 ngày qua: ${medicalDeclaration.visitablePlaces}</p>
</body>
</html>
