<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" var="lang"/>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:requestEncoding value="UTF-8"/>

<html lang="${language}">
<body>
    <form>
        <select id="language" name="language" onchange="submit()">
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
            <option value="pl" ${language == 'pl' ? 'selected' : ''}>Polish</option>
            <option value="de" ${language == 'de' ? 'selected' : ''}>Deutsch</option>
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
    <%--<li><img class="mylanguage" src="https://lipis.github.io/flag-icon-css/flags/4x3/pl.svg"><span class="lang-sm lang-lbl-full" lang="en">pl</span></li>--%>
    <%--<li><span class="lang-sm lang-lbl-full" lang="de"></span></li>--%>
    <%--<li><span class="lang-sm lang-lbl-full" lang="pl"></span></li>--%>
    <%--</ul>--%>
    <%--</div>--%>
</body>
</html>
