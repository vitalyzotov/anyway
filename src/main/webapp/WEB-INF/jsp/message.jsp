<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
<head>
    <title>Сообщения</title>
    <title>Домой</title>
    <link rel ="stylesheet" href="/static/message.css"
    <tags:head/>
</head>
<body>
<div id="nav">
<div class="menu-item">
Меню 1
    <div class="submenu">
        Подменю
            </div></div>
<ul class="nav nav-pills">
<li class="nav-item"><a href="/" class="nav-link">Домой</a>
</ul>
</div>

<div id="anyway-messages">

</div>

<tags:scripts/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>
<script src="/static/app.js"></script>
</body>
</html>
