<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
    Главная главная
</head>
<body>
<h1>Окстись и выбери!</h1>
<ul>
    <form method="get" action="${pageContext.request.contextPath}/artist/all">
        <input type="submit" value="Показать всех">
    </form>

    <form method="get" action="${pageContext.request.contextPath}/artist/add">
        <input type="submit" value="Добавить">
    </form>

    <form method="get" action="${pageContext.request.contextPath}/artist/update">
        <input type="submit" value="Изменить">
    </form>

    <form method="get" action="${pageContext.request.contextPath}/artist/delete">
        <input type="submit" value="Удалить">
    </form>
</ul>
</body>
</html>