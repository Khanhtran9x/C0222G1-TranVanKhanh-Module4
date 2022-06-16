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
    <title>TỜ KHAI Y TẾ</title>
</head>
<body>
    <form:form action="/save-medical-declaration" method="post" modelAttribute="medicalDeclaration">
        <center>
        <h2>TỜ KHAI Y TẾ</h2>
        <h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ
            PHÒNG DỊCH BỆNH TRUYỀN NHIỄM</h4>
        <h4 style="color: red">Khuyến cáo: khai báo sai sự thật có thể dẫn tới xử lí hình sự</h4>
        </center>

        <p>Họ tên(ghi chữ IN HOA)</p>
        <form:input path="name" cssStyle="width: 100%" required="required"/>

        <table style="width: 100%">
            <tr>
                <th style="width: 33%">Năm sinh</th>
                <th style="width: 33%">Giới tính</th>
                <th style="width: 33%">Quốc tịch</th>
            </tr>
            <tr>
                <td>
                    <form:select path="dateOfBirth" cssStyle="width: 100%;">
                        <form:options items="${dateOfBirth}"/>
                    </form:select>
                </td>
                <td>
                    <form:select path="gender" cssStyle="width: 100%;">
                        <form:option value="Nam"/>
                        <form:option value="Nữ"/>
                    </form:select>
                </td>
                <td>
                    <form:select path="nation" cssStyle="width: 100%;">
                        <form:options items="${nation}"/>
                    </form:select>
                </td>
            </tr>
        </table>

        <p>Số hộ chiếu hoặc số CMND</p>
        <form:input path="idCard" cssStyle="width: 100%" required="required"/>

        <p>Thông tin đi lại</p>
        <form:radiobuttons items="${transportation}" path="transportationInformation" required="required"/>

        <p>Số hiệu phương tiện</p>
        <form:input path="transportationCode" cssStyle="width: 100%" required="required"/>

        <p>Số ghế</p>
        <form:input path="seatCode" cssStyle="width: 100%" required="required"/>

        <table style="width: 100%">
            <tr>
                <th style="width: 50%">Ngày khởi hành</th>
                <th style="width: 50%">Ngày kết thúc</th>
            </tr>
            <tr>
                <td>
                    <span>
                        <form:select path="startDay" cssStyle="width: 30%;">
                            <form:options items="${startDay}"/>
                        </form:select>
                        <form:select path="startMonth" cssStyle="width: 30%;">
                            <form:options items="${startMonth}"/>
                        </form:select>
                        <form:select path="startYear" cssStyle="width: 30%;">
                            <form:options items="${startYear}"/>
                        </form:select>
                    </span>
                </td>
                <td>
                    <span>
                        <form:select path="endDay" cssStyle="width: 30%;">
                            <form:options items="${endDay}"/>
                        </form:select>
                        <form:select path="endMonth" cssStyle="width: 30%;">
                            <form:options items="${endMonth}"/>
                        </form:select>
                        <form:select path="endYear" cssStyle="width: 30%;">
                            <form:options items="${endYear}"/>
                        </form:select>
                    </span>
                </td>
            </tr>
        </table>

        <p>Trong vòng 14 ngày qua, anh/chị có đến tỉnh/thành phố nào?</p>
        <form:textarea path="visitablePlaces" cssStyle="width: 100%" required="required"/>

        <input type="submit" value="Gửi tờ khai">
    </form:form>
</body>
</html>
