<html lang="${language}">
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="pl" ${language == 'pl' ? 'selected' : ''}>Polish</option>
        <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
    </select>
</form>
</html>
