<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <title>Rejestracja</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/fontello-css/fontello.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="images/favicon.ico">
</head>

<body>
<fmt:requestEncoding value="UTF-8" />
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
            <%@include file="choose-language.jsp" %>
        </div>
    </div>
</nav>
<div class="container">

    <div class="content">
        <h1><fmt:message key="register.header"/></h1><br/>
        <form action="/register" method="POST" class="needs-validation" novalidate>
            <span style="color: red;"><c:out value="${registrationError}"/></span>
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <label for="validationCustom01">Login</label>
                    <input type="text" class="form-control" id="validationCustom01" name="login" placeholder="Login"
                           required>
                    <div class="invalid-feedback">
                        <fmt:message key="register.giveLogin"/>
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationCustom02"><fmt:message key="register.password"/></label>
                    <input type="password" class="form-control" id="validationCustom02" name="password"
                           placeholder="Hasło"
                           required>
                    <div class="invalid-feedback">
                        <fmt:message key="register.givePassword"/>
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-12 mb-3">
                    <label for="validationCustom03"><fmt:message key="register.email"/></label>
                    <input type="email" class="form-control" id="validationCustom03" name="email"
                           placeholder="Adres Email"
                           required>
                    <div class="invalid-feedback">
                        <fmt:message key="register.giveEmail"/>
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6 mb-3">
                    <label for="validationCustom04"><fmt:message key="register.name"/></label>
                    <input type="text" class="form-control" id="validationCustom04" name="name" placeholder="Imię"
                           required>
                    <div class="invalid-feedback">
                        <fmt:message key="register.giveName"/>
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="validationCustom05"><fmt:message key="register.surname"/></label>
                    <input type="text" class="form-control" id="validationCustom05" name="surname"
                           placeholder="Nazwisko"
                           required>
                    <div class="invalid-feedback">
                        <fmt:message key="register.giveSurname"/>
                    </div>
                </div>
            </div>
            <%--<div class="form-row">--%>
                    <%--<input id="validationCustom06" class="form-control" type="checkbox" name="termsCheckbox"--%>
                           <%--required>Akceptuję <a href="#">regulamin</a>--%>
                    <%--<div class="invalid-feedback">--%>
                        <%--Zaakceptuj regulamin!--%>
                    <%--</div>--%>
            <%--</div>--%>


            <button type="submit" class="btn btn-primary"><fmt:message key="register.registerButton"/></button>
    </div>
    </form>
</div>


</div>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>


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
