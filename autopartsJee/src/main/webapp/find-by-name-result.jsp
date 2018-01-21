<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Strona główna</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/example.css">
    <link href="https://fonts.googleapis.com/css?family=Lato|Open+Sans" rel="stylesheet">

    <title>Wyniki wyszukiwania</title>
</head>
<body>
<a id="banner" href="index.jsp">
    <div class="container-fluid text-center" id="header"><h1> Autoparts Finder</h1></div>
</a>
<div class="row justify-content-center" id="wrapper">
    <div class="col-lg-2 side-bar">

    </div>
    <div class="col-lg-10 main-container text-center">
        <div class="text-menu">
            <h3>Po wybraniu części strona przeniesie ciebie do serwisu allegro:</h3><br/>
            <ul id="myUL">
                <%--<li><a href="<c:out value="${link}" />"><c:out value="${link}"/></a></li>--%>
                <%--<li style="font-size: 24px;"><a href="find-category-by-name.jsp">Wróć do wyszukiwania</a></li>--%>

                <c:forEach var="entry" items="${link}">
                    <div <c:if test="${entry.key == ''}">style="color: red;"</c:if>>
                        <li><a href="${entry.key}"><c:out value="${entry.value}"/></a></li>
                    </div>
                </c:forEach>
                <li style="font-size: 24px;"><a href="find-category-by-name.jsp">Wróć do wyszukiwania</a></li>


            </ul>
        </div>
    </div>
</div>
</body>
</html>

<%--<c:forEach var="entry" items="${list}">--%>

    <%--<div <c:if test="${entry.key.gender.toString() == 'MAN'}">style="color: blue;"</c:if>>--%>
    <%--ID: <c:out value="${entry.key.id}"/><br/>--%>
    <%--Name: <c:out value="${entry.key.name}"/><br/>--%>
    <%--Surname: <c:out value="${entry.key.surname}"/><br/>--%>
    <%--Login: <c:out value="${entry.key.login}"/><br/>--%>
    <%--Age: <c:out value="${entry.key.age}"/><br/>--%>
    <%--Gender: <c:out value="${entry.key.gender}"/><br/>--%>
    <%--Stats: <c:out value="${entry.value}"/><br/>--%>

    <%--<c:forEach var="phoneEntry" items="${entry.key.phones}">--%>
        <%--Phone: <c:out value="${phoneEntry.id} - (${phoneEntry.number})"/><br/>--%>
    <%--</c:forEach>--%>
    <%--</div>--%>