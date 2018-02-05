<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
    <c:when test="${not empty sessionScope.isLogged && sessionScope.isLogged == true}">


        <%--TUTAJ MOZNA DODAWAC KOLEJNE FUNKCJONALNOSCI--%>


        <a class="nav-item nav-link" href="/cars">Twoje auta</a>
        <a class="nav-item nav-link" href="add-car-to-database.jsp">Dodaj auto do bazy danych</a>
        <a class="nav-item nav-link" href="/find-category">Znajdź kategorię</a>
        <a class="nav-item nav-link active" href="/logout">Wyloguj [${sessionScope.loggedUser}]
            <span class="sr-only">(current)</span>
        </a>
    </c:when>
    <c:otherwise>
        <a class="nav-item nav-link active" href="login.jsp">Logowanie
            <span class="sr-only">(current)</span>
        </a>
        <a class="nav-item nav-link" href="register.jsp">Rejestracja</a>
    </c:otherwise>
</c:choose>
<c:if test="${errorMessage != null}">
    <%--<div style="color: red;">${errorMessage}</div>--%>
    <div style="color: red;">Błędny login lub hasło</div>
</c:if>
<c:if test="${okMessage != null}">
    <div style="color: green;">${okMessage}</div>
</c:if>