<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="pl.isa.autopartsJee.languageOptions.language" var="lang"/>
<%--<c:set var="selectpicker"--%>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}" />
<%--<fmt:requestEncoding value="UTF-8"/>--%>



    <form>
        <select id="language" name="language" onchange="submit()">
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
            <option value="pl" ${language == 'pl' ? 'selected' : ''}>Polish</option>
            <option value="de" ${language == 'de' ? 'selected' : ''}>Deutsch</option>
        </select>
    </form>


    <%--<div>--%>
        <%--<a href="#"><img src="#"></a>--%>
        <%--<a href="#"><img src="#"></a>--%>
        <%--<a href=""><img src="#"></a>--%>
    <%--</div>--%>


        <%--<form>--%>
            <%--<select id="language" name="language" onchange="submit()" class="selectpicker" data-width="fit">--%>
                <%--<option value="en" ${language == 'en' ? 'selected' : ''}--%>
                        <%--data-content='<span class="flag-icon flag-icon-us"></span> English'>en</option>--%>
                <%--<option value="pl" ${language == 'pl' ? 'selected' : ''}--%>
                        <%--data-content='<span class="flag-icon flag-icon-pl"></span> Polish'>pl</option>--%>
                <%--<option value="de" ${language == 'de' ? 'selected' : ''}--%>
                        <%--data-content='<span class="flag-icon flag-icon-de"></span> Deutsch'>de</option>--%>
            <%--</select>--%>
        <%--</form>--%>


<%--<form>--%>
    <%--<select id="language" name="language" onchange="submit()" class="selectpicker" data-width="fit">--%>
        <%--<option value="en" ${language == 'en' ? 'selected' : ''}--%>
                <%--data-content='<span class="bfh-languages" data-language="en_GB" data-flags="true"></span> English'>en</option>--%>
        <%--<option value="pl" ${language == 'pl' ? 'selected' : ''}--%>
                <%--data-content='<span class="bfh-languages" data-language="pl_PL" data-flags="true"></span> Polish'>polish</option>--%>
        <%--<option value="de" ${language == 'de' ? 'selected' : ''}--%>
                <%--data-content='<span class="lang-sm lang-lbl" lang="en"></span> Deutsch'>de</option>--%>
        <%--<option value="de" ${language == 'de' ? 'selected' : ''}--%>
                <%--data-content='<span class="bfh-languages" data-language="de" data-flags="true"></span> Deutsch'>de--%>
        <%--</option>--%>

    <%--</select>--%>
<%--</form>--%>




        <%--<select class="selectpicker" data-width="fit">--%>
            <%--<option  data-content='<span class="flag-icon flag-icon-us"></span> English'>en</option>--%>
            <%--<option  data-content='<span class="flag-icon flag-icon-pl"></span> Polish'>pl</option>--%>
            <%--<option  data-content='<span class="flag-icon flag-icon-de"></span> Deutsch'>de</option>--%>
        <%--</select>--%>





