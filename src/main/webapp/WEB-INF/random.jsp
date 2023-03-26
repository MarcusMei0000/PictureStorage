<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
    Random page
</head>
<body>
<h1>hello</h1>
Your friends Ваши друзья
<ul>
    <c:forEach var="clip" items="${friends}" >
        <li><c:out  value="${clip}" /></li>
    </c:forEach>
</ul>
</body>
</html>