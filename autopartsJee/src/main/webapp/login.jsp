<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Strona główna</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/menu.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">
    <title>Zaloguj się</title>
    <link rel="stylesheet" href="css/menu.css">
</head>
<body>
<a id="banner" href="index.jsp">
    <div class="container-fluid text-center" id="header"><h1>Autoparts Finder</h1></div>
</a>
<div class="row justify-content-center" id="wrapper">
    <div class="col-lg-2 col-md-2 col-sm-2 side-bar">
        <%@ include file="carData.jsp" %>

    </div>
    <div class="col-lg-10 col-md-10 col-sm-10 main-container">
        <div class="text-menu text-center">
            <h2>Podaj nazwę użytkownika i hasło: </h2><br/>
            <form action="/login" method="POST">
                <label>Login:</label> <input type="text" name="login"></br>
                <label>Hasło:</label> <input type="password" name="password"></br>
                <input type="submit" value="Szukaj" class="hidden btn btn-primary">

            </form>

            <br>
            <br>
            <ul id="myUL">
                <li><a href="index.jsp">Wróć</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
