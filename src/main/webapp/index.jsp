<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="now" class="java.util.Date" />
<c:set var="timeZone" value="${java.util.TimeZone.getDefault().getID()}"/>
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
<h2>Core Tag Library examples</h2>
<p>The current date is: <fmt:formatDate type="date" value="${now}"/></p>
<c:set var="name" value="Daiming" />
<p>Hello, <c:out value="${name}" />!</p>
<c:if test="${19 > 10}">
    <p>19 is greater than 10.</p>
</c:if>

<h2>Formatting Tag Library examples</h2>
<p>Your TimeZone is: <c:out value="${timeZone}"/></p>
<p>The formatted GMT-3 date is: <fmt:formatDate type="both" value="${now}" timeZone="GMT-3" /></p>
<p>The formatted currency amount of 1000.99 is: <fmt:formatNumber value="${1000.99}" type="currency" currencyCode="USD" /></p>
<p>The formatted decimal number of 3.14159 is: <fmt:formatNumber value="${3.14159}" type="number" maxFractionDigits="2" /></p>

<h2>SQL Tag Library examples</h2>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://csye6220.couxfnqwwltv.us-east-2.rds.amazonaws.com:3306/csye6220"
                   user="admin" password="NUSRpJQAO7A6z19jGstM" />
<sql:query dataSource="${db}" var="books">
    SELECT * FROM books;
</sql:query>
<h3>Books</h3>
<table>
    <tr>
        <th>ISBN</th>
        <th>TITLE</th>
        <th>AUTHORS</th>
        <th>PRICE</th>
    </tr>
    <c:forEach var="row" items="${books.rows}">
        <tr>
            <td><c:out value="${row.isbn}" /></td>
            <td><c:out value="${row.title}" /></td>
            <td><c:out value="${row.authors}" /></td>
            <td><c:out value="${row.price}" /></td>
        </tr>
    </c:forEach>
</table>
<sql:query dataSource="${db}" var="movies">
    SELECT * FROM movies;
</sql:query>
<h3>Movies</h3>
<table>
    <tr>
        <th>TITLE</th>
        <th>ACTOR</th>
        <th>ACTRESS</th>
        <th>GENRE</th>
        <th>YEAR</th>
    </tr>
    <c:forEach var="row" items="${movies.rows}">
        <tr>
            <td><c:out value="${row.title}" /></td>
            <td><c:out value="${row.actor}" /></td>
            <td><c:out value="${row.actress}" /></td>
            <td><c:out value="${row.genre}" /></td>
            <td><c:out value="${row.year}" /></td>
        </tr>
    </c:forEach>
</table>

<h2>XML Tag Library examples</h2>
<c:set var="numbers">
<numbers>
    <value>
        1
    </value>
    <value>
        2
    </value>
    <value>
        3
    </value>
    <value>
        4
    </value>
</numbers>
</c:set>
<x:parse xml="${numbers}" var="numberset"/>
<x:if select="$numberset/numbers/value = 1">
    number 1 is in this number set
</x:if>

<h2>Functions Tag Library examples</h2>
<p><c:out value="${fn:toUpperCase('This will be converted to upper case')}" /></p>
<p>The length of Daiming Yang is: <c:out value="${fn:length('Daiming Yang')}" /></p>
<p>The Index of Yang in Daiming Yang is: <c:out value="${fn:indexOf('Daiming Yang', 'Yang')}" /></p>


</body>
</html>
