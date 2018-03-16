<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <title>Wyszukiwarka aut</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/fontello-css/fontello.css">
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">
    <link href="css/vs-style.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
    <script type="text/javascript" src="/scripts/vehicle-search-jq.js"></script>
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
        <h1><i class="demo-icon icon-wrench-outline"></i><fmt:message key="vehicleSearch.banner"/></h1>
        <h4><fmt:message key="vehicleSearchSteps.brand"/> <span class="blue"><c:out value="${sessionScope.makeName}"/></span></h4>
        <h4><fmt:message key="vehicleSearchSteps.model"/> <span class="blue"><c:out value="${sessionScope.modelName}"/></span></h4>
        <h4><fmt:message key="vehicleSearchSteps.engineType"/> <b><span class="blue"><c:out value="${sessionScope.engineName}"/></span></h4>
        <h4><fmt:message key="vehicleSearchSteps.power"/> <span class="blue"><c:out value="${sessionScope.hp}"/></span></h4>
        <h4><fmt:message key="vehicleSearchSteps.capacity"/> <span class="blue"><c:out value="${sessionScope.ccm}"/></span></h4>
        <h4><fmt:message key="vehicleSearchSteps.fuelType"/> <span class="blue"><c:out value="${sessionScope.fuel}"/></span></h4>
        <h3 class="blue"><fmt:message key="vehicleSearchSteps.otherParameters"/></h3>

        <form class="form-group" method="post" action="vs-car-add">
            <label for="year"><fmt:message key="vehicleSearchSteps.yearOfProduction"/></label>
            <select class="select2 form-control" id="year" name="year">
                <option value="" selected disabled hidden>
                    <fmt:message key="vehicleSearch.chooseOption"/></option>
                <c:forEach items="${years}" var="year">
                    <option value="${year}">${year}</option>
                </c:forEach>
            </select>
            <label for="vin"><fmt:message key="vehicleSearchSteps.vinNumber"/>
            </label><input class="form-control" id="vin" type="text" name="vin" required>

            <label for="reg"><fmt:message key="vehicleSearchSteps.registrationNumber"/>
            </label><input class="form-control" id="reg" type="text" name="registry" required>
            <a href="vehicle-search-step2.jsp" class="btn btn-secondary btn-lg">
                <fmt:message key="vehicleSearchSteps.return"/></a>
            <button class="btn btn-secondary btn-lg" type="submit"><fmt:message key="vehicleSearchSteps.saveCar"/></button>
        </form>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
