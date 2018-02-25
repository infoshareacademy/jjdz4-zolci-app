<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" var="lang"/>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:requestEncoding value="UTF-8"/>

<%--<html lang="${language}">--%>
<%--&lt;%&ndash;<link rel="stylesheet" href="css/language.css">&ndash;%&gt;--%>
<%--<head>--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/css/bootstrap-select.min.css">--%>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/0.8.2/css/flag-icon.min.css">--%>
    <%--<script src="scripts/selectpicker.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/js/bootstrap-select.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
    <form>
        <select id="language" name="language" onchange="submit()">
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
            <option value="pl" ${language == 'pl' ? 'selected' : ''}>Polish</option>
            <option value="de" ${language == 'de' ? 'selected' : ''}>Deutsch</option>
        </select>
    </form>

    <form>
        <select class="selectpicker" data-width="fit">
            <option  data-content='<span class="flag-icon flag-icon-us"></span> English'>en</option>
            <option  data-content='<span class="flag-icon flag-icon-pl"></span> Polish'>pl</option>
            <option  data-content='<span class="flag-icon flag-icon-de"></span> Deutsch'>de</option>
        </select>
    </form>



    <%--<form>--%>
    <%--<select id="language" name="language" onchange="submit()">--%>
    <%--<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
    <%--<option value="pl" ${language == 'pl' ? 'selected' : ''}>Polishąę</option>--%>
    <%--<option value="de" ${language == 'de' ? 'selected' : ''}>Deutschü</option>--%>
    <%--</select>--%>
    <%--</form>--%>

    <%--<div class="btn-group">--%>
    <%--<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">--%>
    <%--<span class="lang-sm lang-lbl-full" lang="it"></span> <span class="caret"></span>--%>
    <%--</button>--%>
    <%--<ul class="dropdown-menu" role="menu">--%>
    <%--<li><img class="mylanguage" src="https://lipis.github.io/flag-icon-css/flags/4x3/pl.svg">--%>
        <%--<span class="lang-sm lang-lbl-full" lang="pl">pl</span></li>--%>

    <%--<li><img class="mylanguage" src="https://lipis.github.io/flag-icon-css/flags/4x3/de.svg">--%>
        <%--<span class="lang-sm lang-lbl-full" lang="de">de</span></li>--%>

    <%--<li><img class="mylanguage" src="https://lipis.github.io/flag-icon-css/flags/4x3/en.svg">--%>
        <%--<span class="lang-sm lang-lbl-full" lang="en">en</span></li>--%>
    <%--</ul>--%>
    <%--</div>--%>


<%--</body>--%>
<%--</html>--%>
