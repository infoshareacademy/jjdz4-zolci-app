<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" var="lang" />
<fmt:requestEncoding value = "UTF-8" />
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<!doctype html>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <title>Wpisz kod sesji Atena</title>
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
        <h1><fmt:message key="findAztec.header"/></h1><br/>
        <h3><fmt:message key="findAztec.instruction"/></h3>
        <span style="color: limegreen;"><c:out value="${carAdded}"/></span>
        <span style="color: red;"><c:out value="${wrongCode}"/></span>
        <%--<c:when test="${carAdded == true}">--%>
            <%--<fmt:message key="findAztec.message.correct"/>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--&lt;%&ndash;<fmt:message key="findAztec.message.fault"/>&ndash;%&gt;--%>
        <%--</c:otherwise>--%>
        <form action="/find-by-aztec" method="GET" class="needs-validation" novalidate>
            <div class="form-group">
                <input type="text" id="validationCustom1" class="form-control" name="search"
                       placeholder="aztec" required>
                <div class="invalid-feedback">
                    <fmt:message key="findAztec.message.fault"/>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">
                <fmt:message key="findAztec.searchButton"/>
            </button>
        </form>
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

