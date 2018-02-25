<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" var="lang"/>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:requestEncoding value="UTF-8"/>

<html lang="${language}">
<head>
    <meta charset="UTF-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <!------ Include the above in your HEAD tag ---------->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/language.css.css">
    <script src="../resources/language.js"></script>
</head>
<body>
    <%--<form>--%>
        <%--<select id="language" name="language" onchange="submit()">--%>
            <%--<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
            <%--<option value="pl" ${language == 'pl' ? 'selected' : ''}>Polishąę</option>--%>
            <%--<option value="de" ${language == 'de' ? 'selected' : ''}>Deutschü</option>--%>
        <%--</select>--%>
    <%--</form>--%>

    <%--<nav class="navbar navbar-inverse navbar-fixed-top">--%>
        <%--<div class="container">--%>
            <%--<div class="navbar-header">--%>
                <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"--%>
                        <%--data-target="#navbar" aria-expanded="false" aria-controls="navbar">--%>
                    <%--<span class="sr-only">Toggle navigation</span>--%>
                    <%--<span class="icon-bar"></span>--%>
                    <%--<span class="icon-bar"></span>--%>
                    <%--<span class="icon-bar"></span>--%>
                <%--</button>--%>
                <%--&lt;%&ndash;<a class="navbar-brand" href="#">Project name</a>&ndash;%&gt;--%>
            <%--</div>--%>


<%-- *************
            <div id="navbar" class="navbar-collapse collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><img id="imgNavSel" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanNavSel">ITA</span> <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a id="navEng" href="#" class="language"><img id="imgNavEng" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanNavEng">English</span></a></li>
                            <li><a id="navIta" href="#" class="language"> <img id="imgNavIta" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanNavIta">Italiano</span></a></li>
                            <li><a id="navDeu" href="#" class="language"> <img id="imgNavDeu" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanNavDeu">Deutsch</span></a></li>
                            <li><a id="navFra" href="#" class="language"><img id="imgNavFra" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanNavFra">Francais</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div> <!--/.navbar-collapse -->
        </div>
    </nav>
    **************--%>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <%--<div class="jumbotron">--%>
        <%--<div class="container">--%>
            <%--<h1>Internationalization </h1>--%>
            <%--<h3>In the navbar using ul dropdown</h3>--%>
                <%--<h3>In the page using button group</h3>--%>
                    <%--<p>--%>
                    <%--<div class="btn-group">--%>
                        <%--<button type="button" class="btn btn-default btn-lg">--%>
                            <%--<img id="imgBtnSel" src="" alt="..." class="img-thumbnail icon-medium">  --%>
                            <%--<span id="lanBtnSel">ITA</span></button>--%>
                        <%--<button type="button" class="btn btn-default btn-lg dropdown-toggle" data-toggle="dropdown" aria-expanded="false">--%>
                            <%--<span class="caret"></span>--%>
                        <%--</button>--%>
                        <%--<ul class="dropdown-menu" role="menu">--%>
                            <%--<li><a id="btnIta" href="#" class="language"> <img id="imgBtnIta" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanBtnlIta">Italiano</span></a></li>--%>
                            <%--<li><a id="btnDeu" href="#" class="language"> <img id="imgBtnDeu" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanBtnDeu">Deutsch</span></a></li>--%>
                            <%--<li><a id="btnFra" href="#" class="language"><img id="imgBtnFra" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanBtnFra">Francais</span></a></li>--%>
                            <%--<li><a id="btnEng" href="#" class="language"><img id="imgBtnEng" src="" alt="..." class="img-thumbnail icon-small">  <span id="lanBtnEng">English</span></a></li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                    <%--</p>--%>

        </div>
    </div>

</body>
</html>
