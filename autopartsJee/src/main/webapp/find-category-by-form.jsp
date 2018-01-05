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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="JQuery/find1.js"></script>

    <title>Znajdź po formularzu</title>
</head>
<body>
<a id="banner" href="index.jsp">
    <div class="container-fluid text-center" id="header"><h1> 'autopartsFinder'</h1></div>
</a>
<div class="row justify-content-center" id="wrapper">
    <div class="col-lg-2 side-bar">

    </div>
    <div class="col-lg-10 main-container">
        <div class="text-menu text-center">
            <h2>Wybierz uszkodzoną część:</h2>

            <br/>

            <ul id="myUL">
                <c:forEach var="entry" items="${elements}">
                    <li><a><c:out value="${entry}"/></a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>


<%--<span id="output">abc</span>--%>

<%--<div id="abc">asd</div>--%>
<%--<div id="output"></div>--%>


<%--<select>--%>
<%--<option value="red">red</option>--%>
<%--<option value="black">black</option>--%>
<%--<option value="blue">blue</option>--%>
<%--</select>--%>
<%--<input type="text" id="input" value="">--%>
<%--<div id="output"></div>--%>