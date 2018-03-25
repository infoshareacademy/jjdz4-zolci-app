<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" var="lang"/>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<form>
    <select id="language" name="language" onchange="updateLanguage()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="pl" ${language == 'pl' ? 'selected' : ''}>Polski</option>
        <option value="de" ${language == 'de' ? 'selected' : ''}>Deutsch</option>
    </select>
</form>

<script>
    function updateLanguage() {
        console.log("updateLanguage");
        if (window.location.search.indexOf("language="+ $('#language').val()) !== -1) {
        }
        else if (window.location.search.indexOf("language") === -1) {
            window.location.search += '&language=' + $('#language').val();
        } else {
            window.location.search = window.location.search.replace(
                "language=" + '<c:out value="${language}"/>',
                'language=' + $('#language').val()
            );
        }
    }

</script>
