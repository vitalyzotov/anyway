<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Регистрация</title>
    <link href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="/webjars/org.webjars/font-awesome/6.1.2/css/all.min.css" rel="stylesheet">
    <link href="/static/signup.css" rel="stylesheet" type="text/css">
</head>
<body class="text-center">

 <main class="form-signin w-100 m-auto">
  <form>

<div class="container">
<div class="block">

<h1 class="h3 mb-3 fw-normal">Регистрация</h1>

<form id="submit-form" action="/signup" method="post">
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Фамилия</label>
        <div class="col-sm-10">
            <input name="lastName" class="form-control"/>
        </div>
    </div>
    <p>
     <div class="row mb-3">
        <label class=" col-sm-2 col-form-label">Имя</label>
        <div class="col-sm-10">
             <input name="firstName"class="form-control"/>
        </div>
     </div>
    </p>
    <p>
    <div class="row mb-3">
        <label class=" col-sm-2 col-form-label">Отчество</label>
        <div class="col-sm-10">
           <input name="middleName"class="form-control"/>
        </div>
    </div>
    </p>
    <div class="row mb-3">
        <label class=" col-sm-2 col-form-label">Дата рождения</label>
        <div class="col-sm-10">
            <input name="birthday" type="date" class="form-control">
        </div>
    </div>
    <div class="row mb-3">
            <label class=" col-sm-2 col-form-label">Пароль</label>
            <div class="col-sm-10">
                <input name="birthday" type="password" class="form-control">
            </div>
    </div>

    <button class="btn btn-outline-primary" type="submit">Готово</button>
    <button class="w-30 btn btn-lg btn-primary" type="reset">Очистить</button>
    <button class="w-30 btn btn-lg btn-primary" href="/login" id="submit-button" type="button">Войти</button>

 </main>
</form>
</div>
</div>

<script src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">
    function convertFormToJSON(form) {
        const array = $(form).serializeArray(); // Encodes the set of form elements as an array of names and values.
        const json = {};
        $.each(array, function () {
            json[this.name] = this.value || "";
        });
        return json;
    }


    $(document).ready(function () {
        $("#submit-button").click(function () {
            $.ajax("/signup", {
                data: JSON.stringify(convertFormToJSON($("#submit-form"))),
                contentType: 'application/json',
                type: 'POST'
            }).done(function () {
                $(this).addClass("done");
            });

        })
    });

</script>
</body>
</html>
