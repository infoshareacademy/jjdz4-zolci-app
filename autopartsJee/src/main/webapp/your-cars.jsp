<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language"/>
<!doctype html>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <title><fmt:message key="title.yourCars"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/fontello-css/fontello.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">
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
        <h1><fmt:message key="yourcars.header"/></h1><br/>

        <c:choose>
            <c:when test="${not empty cars}">
                <div class="table-responsive">
                    <table class="table" style="font-size: 15px;">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col"><fmt:message key="yourcars.delete"/></th>
                            <th scope="col"><fmt:message key="yourcars.brand"/></th>
                            <th scope="col"><fmt:message key="yourcars.model"/></th>
                            <th scope="col"><fmt:message key="yourcars.year"/></th>
                            <th scope="col"><fmt:message key="yourcars.version"/></th>
                            <th scope="col"><fmt:message key="yourcars.variant"/></th>
                                <%--<th class="d-none d-lg-table-cell" scope="col"><fmt:message key="yourcars.fuel"/></th>--%>
                            <th scope="col"><fmt:message key="yourcars.fuel"/></th>
                            <th scope="col"><fmt:message key="yourcars.capacity"/></th>
                                <%--<th class="d-none d-lg-table-cell" scope="col"><fmt:message key="yourcars.power"/></th>--%>
                            <th scope="col"><fmt:message key="yourcars.power"/></th>
                                <%--<th class="d-none d-lg-table-cell" scope="col">VIN</th>--%>
                            <th scope="col">VIN</th>
                                <%--<th class="d-none d-lg-table-cell" scope="col"><fmt:message key="yourcars.registration"/></th>--%>
                            <th scope="col"><fmt:message key="yourcars.registration"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="id" scope="request" value="0"/>

                        <c:forEach var="entry" items="${cars}">
                            <c:set var="id" scope="request" value="${id+1}"/>
                            <tr>
                                <td>${id}</td>
                                <td><a href="/delete-car-servlet?carID=${entry.carID}">X</a></td>
                                <td>${entry.vehicleMake}</td>
                                <td>${entry.vehicleModel}</td>
                                <td>${entry.prodYear}</td>
                                <td>${entry.vehicleVersion}</td>
                                <td>${entry.vehicleVariant}</td>
                                    <%--<td class="d-none d-lg-table-cell">${entry.fuel}</td>--%>
                                <td>${entry.fuel}</td>
                                <td>${entry.capacity}</td>
                                    <%--<td class="d-none d-lg-table-cell">${entry.power}</td>--%>
                                <td>${entry.power}</td>
                                    <%--<td class="d-none d-lg-table-cell">${entry.vin}</td>--%>
                                <td>${entry.vin}</td>
                                    <%--<td class="d-none d-lg-table-cell">${entry.registryNumber}</td>--%>
                                <td>${entry.registryNumber}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <fmt:message key="yourcars.info"/>
            </c:otherwise>
        </c:choose>


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
