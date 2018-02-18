
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" />

<c:choose>
    <c:when test="${not empty sessionScope.isLogged && sessionScope.isLogged == true}">


        <%--TUTAJ MOZNA DODAWAC KOLEJNE FUNKCJONALNOSCI--%>
        <fmt:requestEncoding value="UTF-8" />
        <a class="nav-item nav-link" href="/cars"><fmt:message key="menu.cars"/></a>
        <a class="nav-item nav-link" href="add-car-to-database.jsp"><fmt:message key="menu.addCarToDatabase"/></a>
        <a class="nav-item nav-link" href="/find-category"><fmt:message key="menu.findCategory"/></a>
        <a class="nav-item nav-link active" href="/logout"><fmt:message key="menu.logout"/> [${sessionScope.loggedUser}]
                <span class="sr-only">(current)</span></a>

        <%--<a class="nav-item nav-link" href="/cars">Twoje auta</a>--%>
        <%--<a class="nav-item nav-link" href="add-car-to-database.jsp">Dodaj auto do bazy danych</a>--%>
        <%--<a class="nav-item nav-link" href="/find-category">Znajdź kategorię</a>--%>
        <%--<a class="nav-item nav-link active" href="/logout">Wyloguj [${sessionScope.loggedUser}]--%>
            <%--<span class="sr-only">(current)</span>--%>
        <%--</a>--%>
    </c:when>
    <c:otherwise>
        <a class="nav-item nav-link active" href="login.jsp"><fmt:message key="menu.login"/>
            <span class="sr-only">(current)</span>
        </a>
        <a class="nav-item nav-link" href="register.jsp"><fmt:message key="menu.registry"/></a>
    </c:otherwise>
</c:choose>
<c:if test="${errorMessage != null}">
    <%--<div style="color: red;">${errorMessage}</div>--%>
    <div style="color: red;"><fmt:message key="menu.errorMessage"/></div>
</c:if>
<c:if test="${okMessage != null}">
    <div style="color: green;">${okMessage}</div>
</c:if>