<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Znajdź samochód według kodu AZTEC</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/example.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">
    <title>Znajdź kategorię</title>
</head>
<body>
<a id="banner" href="index.jsp"><div class="container-fluid text-center" id="header"><h1>Autoparts Finder</h1></div></a>
<div class="row justify-content-center" id="wrapper">
    <div class="col-lg-2 side-bar">
        <%@ include file="carData.jsp"%>

    </div>
    <div class="col-lg-10 main-container">
        <div class="text-menu text-center">
            <h2>Podaj kod sesji Atena:</h2><br/>
            <form action="/find-by-aztec" method="GET">
                <input type="text" name="search">
                <input type="submit" value="Szukaj">
            </form>
        </div>
    </div>
</div>
</body>
</html>
