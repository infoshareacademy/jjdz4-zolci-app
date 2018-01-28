<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${errorMessage != null}">
    <%--<div style="color: red;">${errorMessage}</div>--%>
    <div class="alert alert-danger">
    <strong> Błędny login lub hasło </strong>
    </div>
</c:if>
<c:if test="${okMessage != null}">
    <div style="color: green;">${okMessage}</div>
</c:if>
<c:choose>
<c:when test="${not empty sessionScope.isLogged && sessionScope.isLogged == true}">
    Zalogowano jako ${sessionScope.loggedUser} <a href="<c:url value="/logout"/>">Wyloguj</a>
</c:when>
<c:otherwise>
    <a href="<c:url value="login.jsp"/>">Zaloguj się</a>
</c:otherwise>
</c:choose>
