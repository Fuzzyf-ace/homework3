<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<jsp:useBean id="now" class="java.util.Date" />

<html>
<head>
    <title>JSTL Example</title>
</head>
<header>
    <a href="/book">book</a>
    <a href="/movie">movie</a>
    <a href="/shop">shop</a>
</header>
<body>

<!-- Core Tag Library examples -->
    <p>The current date is: <fmt:formatDate type="date" value="${now}"/></p>
<c:set var="name" value="Daiming" />
<p>Hello, <c:out value="${name}" />!</p>
<c:if test="${19 > 10}">
    <p>19 is greater than 10.</p>
</c:if>


<!-- Formatting Tag Library examples -->
<p>The formatted current date is: <fmt:formatDate type="date" value="${now}" pattern="yyyy-MM-dd" /></p>
<p>The formatted currency amount of 1000.99 is: <fmt:formatNumber value="${1000.99}" type="currency" currencyCode="USD" /></p>
<p>The formatted decimal number of 3.14159 is: <fmt:formatNumber value="${3.14159}" type="number" maxFractionDigits="2" /></p>


<!-- SQL Tag Library examples -->
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://csye6220.couxfnqwwltv.us-east-2.rds.amazonaws.com:3306/csye6220"
                   user="admin" password="NUSRpJQAO7A6z19jGstM" />
<sql:query dataSource="${db}" var="result">
    SELECT * FROM books;
</sql:query>
<h2>books</h2>
<table>
    <tr>
        <th>ISBN</th>
        <th>TITLE</th>
        <th>AUTHORS</th>
        <th>PRICE</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.isbn}" /></td>
            <td><c:out value="${row.title}" /></td>
            <td><c:out value="${row.authors}" /></td>
            <td><c:out value="${row.price}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
