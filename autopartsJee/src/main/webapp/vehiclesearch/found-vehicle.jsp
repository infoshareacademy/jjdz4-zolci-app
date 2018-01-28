<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Wyszukiwarka aut</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/menu.css">
    <link rel="stylesheet" href="../css/vs-style.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="../images/favicon.ico">
    <script type="text/javascript" src="../scripts/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../scripts/vehicle-search-jq.js"></script>
</head>
<body>
<a id="banner" href="../index.jsp"><div class="container-fluid text-center" id="header"><h1>Wyszukiwarka aut</h1></div></a>
<div class="row justify-content-center" id="wrapper">

    <div class="col-lg-2 col-md-2 col-sm-2 side-bar">
        <%@ include file="carData.jsp"%>
    </div>

    <div class="col-lg-10 col-md-10 col-sm-10 main-container">
        <div class="text-menu text-center">
            <h2>Znalezione auto</h2>
        </div>
    </div>
</div>
</body>
</html>
