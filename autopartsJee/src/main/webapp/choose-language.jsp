<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" var="lang" />
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:requestEncoding value = "UTF-8" />

<html lang="${language}">
<meta charset="UTF-8">
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="pl" ${language == 'pl' ? 'selected' : ''}>Polish</option>
        <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
    </select>
</form>
</html>
