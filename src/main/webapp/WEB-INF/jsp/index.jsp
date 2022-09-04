<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>(Мессенджер)-Название сайта</title>
    <link href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/style.css" rel= "stylesheet">
    <link href="/webjars/font-awesome/6.1.2/css/all.min.css" rel="stylesheet">
</head>
<body class="d-flex h-100 text-center text-bg-gray">
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>
    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="mb-auto">
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
      </a>
      <ul class="nav nav-pills">
        <li class="nav-item"><a href="/login" class="nav-link active" aria-current="page">Войти</a></li>
        <li class="nav-item"><a href="/signup" class="nav-link" >Зарегистрироваться</a></li>
        <li class="nav-item"><a href="/" class="nav-link mybutton ">О нас</a></li>
      </ul>
    </header>
  </div>
  </div>
</body>
<style type="text/css">
        *{
          box-sizing: border-box;
        }
        body {
         font-family: 'Poppins', sans-serif;
         margin: 0;
         min-height: 100vh;
         display: flex;
         background-color: #F5F5DC;
        }
    </style>
</html>
