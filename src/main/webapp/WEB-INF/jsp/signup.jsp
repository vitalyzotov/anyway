<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Регистрация</title>
    <link href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
<h1>Регистрация нового пользователя</h1>

<form id="submit-form" action="/signup" method="post">
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Фамилия</label>
        <div class="col-sm-10">
            <input name="lastName" class="form-control"/>
        </div>
    </div>
    <p>
        Имя
        <input name="firstName"/>
    </p>
    <p>
        Отчество
        <input name="middleName"/>
    </p>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Дата рождения</label>
        <div class="col-sm-10">
            <input name="birthday" type="date" class="form-control">
        </div>
    </div>
    <button type="submit">Готово</button>
    <button type="reset">Очистить</button>
    <button id="submit-button" type="button">Просто кнопка</button>
</form>
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
