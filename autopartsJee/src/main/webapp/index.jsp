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
    <link rel="stylesheet" href="css/fontello-css/fontello.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">
    <title>Strona główna</title>
    <link rel="icon" type="image/x-icon" href="images/favicon.ico">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark " style=" background-color:rgba(41,41,41,0.8);">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">
            <i class="demo-icon icon-wrench-outline"></i>
            Autoparts Finder
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <ul class="navbar-nav ml-auto">
                <%@include file="context-menu.jsp" %>
            </ul>
        </div>
    </div>
</nav>
<div class="container">

    <div class="content">
        <h1> Autoparts Finder</h1><br/>
        <h3>Autoparts Finder jest aplikacją, która pomoże Ci zlokalizować uszkodzoną część w Twoim aucie oraz
            przekieruje Cię
            do kategorii Allegro, w której znajdziesz część zamienną. </h3><br/>
        <h4>Jako zalogowany użytkownik możesz wprowadzić do naszej bazy danych swój pojazd i skorzystać z funkcjonalności serwisu.</h4>
    </div>


</div>


















<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>
