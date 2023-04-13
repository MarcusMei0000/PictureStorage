<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    Найди свой путь
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/artist/main">
    <input type="submit" value="Художники">
</form>

<form method="get" action="${pageContext.request.contextPath}/picture/main">
    <input type="submit" value="Картины">
</form>
</body>
</html>