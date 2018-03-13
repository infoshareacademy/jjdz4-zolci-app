<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" />
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="title.adminPanel"/>Panel administratora</title>
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
    <c:set var="admin" scope="request" value="admin"/>
    <div class="content">
        <h1><fmt:message key="adminPanel.header"/></h1><br/>
        <span style="color: limegreen;"><c:out value="${updatemessage}"/></span><br/>
        <fmt:message key="adminPanel.header2"/>
        <form method="post" action="/updatepreferences">
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check1" name="login" value="true">
                <label class="form-check-label" for="check1"><fmt:message key="adminPanel.loggedUsers"/></label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check2" name="logout" value="true">
                <label class="form-check-label" for="check2"><fmt:message key="adminPanel.unlogedUsers"/></label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check9" name="failedlogins" value="true">
                <label class="form-check-label" for="check9"><fmt:message key="adminPanel.loggingFaults"/></label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check3" name="manualsearch" value="true">
                <label class="form-check-label" for="check3"><fmt:message key="adminPanel.search"/></label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check4" name="formsearch" value="true">
                <label class="form-check-label" for="check4"><fmt:message key="adminPanel.searchForm"/></label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check5" name="register" value="true">
                <label class="form-check-label" for="check5"><fmt:message key="adminPanel.numberOfRegistry"/></label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check7" name="failedregisters" value="true">
                <label class="form-check-label" for="check7"><fmt:message key="adminPanel.registryFaults"/></label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check8" name="addedcars" value="true">
                <label class="form-check-label" for="check8"><fmt:message key="adminPanel.addCars"/></label>
            </div>

            <button type="submit" class="btn btn-primary"><fmt:message key="adminPanel.update"/></button>
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
