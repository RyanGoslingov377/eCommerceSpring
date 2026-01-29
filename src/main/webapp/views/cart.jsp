<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Корзина</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Perishable Shop</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="/">Назад в магазин</a></li>
                <li class="nav-item"><a class="nav-link" href="/logout">Выход</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h2>Ваша корзина</h2>

    <c:if test="${not empty success}">
        <div class="alert alert-success">${success}</div>
    </c:if>

    <!-- Пока просто заглушка, позже подключим реальные товары -->
    <div class="alert alert-info">
        Функционал корзины частично реализован. Товары добавляются, но пока не отображаются здесь.
    </div>

    <a href="/" class="btn btn-primary">Вернуться к покупкам</a>
</div>
</body>
</html>