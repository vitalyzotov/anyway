<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
<head>
    <title>(Мессенджер)-Название сайта</title>
    <link href="/static/index.css" rel= "stylesheet">
    <tags:head/>
</head>
<body class="d-flex h-100 text-center text-bg-gray">
    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
        <header class="mb-auto">
            <div class="container">
                <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                    </a>
                    <ul class="nav nav-pills">
                       <li class="nav-item"><a href="/login" class="nav-link active" aria-current="page">Войти</a></li>
                        <li class="nav-item"><a href="/signup" class="nav-link">Зарегистрироваться</a></li>
                        <li class="nav-item"><a href="/message" class="nav-link">Сообщения</a>
                        <li class="nav-item"><a href="/listperson" class="nav-link">Люди</a>
                        <li class="nav-item"><a href="/" class="nav-link mybutton">О нас</a></li>
                    </ul>
                </header>
            </div>
        </header>
    </div>

 <div id="MainShell">

 </div>

    <script src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
