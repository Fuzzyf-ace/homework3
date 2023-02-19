<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
    <title>JSTL Example</title>
</head>
<body>
<h1>Welcome to our website!</h1>

<!-- Core Tag Library examples -->
<p>The current date is: <c:out value="${now}" /></p>
<c:set var="name" value="John" />
<p>Hello, <c:out value="${name}" />!</p>
<c:if test="${5 > 3}">
    <p>5 is greater than 3.</p>
</c:if>


<!-- Formatting Tag Library examples -->
<p>The formatted current date is: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></p>
<p>The formatted currency amount is: <fmt:formatNumber value="${1000.99}" type="currency" currencyCode="USD" /></p>
<p>The formatted decimal number is: <fmt:formatNumber value="${3.14159}" type="number" maxFractionDigits="2" /></p>

<!-- SQL Tag Library examples -->
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/mydb"
                   user="username" password="password" />
<sql:query dataSource="${db}" var="result">
    SELECT * FROM users;
</sql:query>
<table>
    <tr>
        <th>User ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}" /></td>
            <td><c:out value="${row.name}" /></td>
            <td><c:out value="${row.email}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
