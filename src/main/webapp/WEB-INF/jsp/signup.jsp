<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Регистрация</title>
    <link href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="/webjars/org.webjars/font-awesome/6.1.2/css/all.min.css" rel="stylesheet">
    <link href="/static/signup.css" rel="stylesheet" type="text/css">
    <tags:head/>
</head>
<body class="text-center signup">
 <main class="form-signin w-100 m-auto">
<div class="container">
<div class="block">
<h1 class="h3 mb-3 fw-normal">Регистрация</h1>
   <form id="signup-form" action="/signup" method="post">
    <div class="row mb-3 justify-content-center">
        <div class="col-sm-10">
            <input name="lastName" class="form-control"placeholder="Фамилия"/>
        </div>
    </div>
    <p>
     <div class="row mb-3 justify-content-center">
        <div class="col-sm-10">
             <input name="firstName"class="form-control"placeholder="Имя"/>
        </div>
     </div>
    </p>
    <p>
    <div class="row mb-3 justify-content-center">
        <div class="col-sm-10">
           <input name="middleName"class="form-control"placeholder="Отчество"/>
        </div>
    </div>
    </p>
    <div class="row mb-3 justify-content-center">
        <div class="col-sm-10">
            <input name="birthday" type="date" class="form-control" placeholder="Дата рождения"/>
        </div>
    </div>
    <div class="row mb-3 justify-content-center">
       <div class="col-sm-10">
         <input type="password" class="form-control" id="inputPassword2" placeholder="Пароль"/>
       </div>
    </div>

   <div class="container-xl">
     <button type="submit" class="btn btn-primary mb-3">Готово</button>
     <button type="submit" class="btn btn-primary mb-3">Очистить</button>
     <button type="submit" class="btn btn-primary mb-3" href="/login" id="submit-button">Войти</button>
   </div>
  </form>
 </main>
</div>
</div>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/static/signup.js"></script>
</body>
</html>
