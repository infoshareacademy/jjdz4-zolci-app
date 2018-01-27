<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Wyszukaj po kodzie AZTEC</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/example.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">

    <title>Wyniki wyszukiwania</title>
</head>
<body>
<a id="banner" href="index.jsp">
    <div class="container-fluid text-center" id="header"><h1> Autoparts Finder</h1></div>
</a>
<div class="row justify-content-center" id="wrapper">
    <div class="col-lg-2 side-bar">
        <%@ include file="carData.jsp"%>
    </div>
    <div class="col-lg-10 main-container text-center">
        <div class="text-menu">
            <h3>Dane pojazdu:</h3><br/>
            <ul id="myUL">
                <li>Marka pojazdu: ${vehicleMake}</li>
                <li>Model: ${vehicleModel}</li>
                <li>Rok produkcji: ${prodYear}</li>
                <li>Wersja: ${vehicleVersion}</li>
                <li>Wariant: ${vehicleVariant}</li>
                <li>Rodzaj paliwa: ${fuel}</li>
                <li>Pojemność silnika: ${capacity}</li>
                <li>Moc silnika: ${power}</li>
                <li>Numer VIN: ${vin}</li>
                <li>Numer rejestracyjny: ${registryNumber}</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
