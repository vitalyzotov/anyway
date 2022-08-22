<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Login</title>
    <tags:head/>
</head>
<body>

<div class="container-fluid min-vh-100 d-flex flex-column">
    <div class="row flex-grow-1"></div>
    <div class="row align-items-center">
        <div class="col"></div>
        <div class="col">
            <div class="container">
                <h1>Вход</h1>
                <form id="login-form" action="/do_login" method="post">

                    <!-- Username -->
                    <div class="form-floating mb-4">
                        <input type="text" id="login-form__username" class="form-control" name="username"/>
                        <label for="login-form__username">Имя пользователя</label>
                    </div>

                    <!-- Password -->
                    <div class="form-floating mb-4">
                        <input type="password" id="login-form__password" class="form-control" name="password"/>
                        <label for="login-form__password">Пароль</label>
                    </div>

                    <c:if test="${error != null}">
                        <div class="col-md-12 text-center text-danger">
                                ${error}
                        </div>
                    </c:if>

                    <!-- Submit button -->
                    <div class="col-md-12 text-center">
                        <button type="submit" class="btn btn-primary btn-lg">Войти</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col"></div>
    </div>
    <div class="row flex-grow-1"></div>
</div>

<tags:scripts/>
</body>
</html>
