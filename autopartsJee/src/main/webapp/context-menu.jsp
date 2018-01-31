<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
<c:when test="${not empty sessionScope.isLogged && sessionScope.isLogged == true}">
    Zalogowano jako ${sessionScope.loggedUser} <a href="<c:url value="/logout"/>">Wyloguj</a>
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